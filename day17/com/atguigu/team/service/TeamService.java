package day17.com.atguigu.team.service;

import day17.com.atguigu.team.domain.Architect;
import day17.com.atguigu.team.domain.Designer;
import day17.com.atguigu.team.domain.Employee;
import day17.com.atguigu.team.domain.Programmer;

import static day17.com.atguigu.team.service.Status.FREE;

/**
 * @author
 * @Description 关于开发团队成员的管理：添加、删除等
 * @date 2023.2.23    10:58 am
 */
public class TeamService {
    private static int counter = 1;//给memberId赋值使用
    private final int MAX_MEMBER = 5;//限制开发团队的人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
    private int total = 0;//记录开发团队中实际的人数

    public TeamService() {
        super();
    }

    /**
     * @author
     * @Description 获取看法中的所有成员
     * @date 2023.2.23    10:58 am
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * @author
     * @Description 将指定成员添加到团队中
     * @date 2023.2.23    10:58 am
     */
    public void addMember(Employee e) throws TeamException {
        //成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        //该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        //该成员已在开发团队中
        if (isExist(e)) {
            throw new TeamException("该成员已在开发团队中");
        }
        //该员工已是某团队成员
        //该成员正在休假，无法添加
        Programmer p = (Programmer) e;//一定不会出现ClassCastException
        if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {//equalsIgnoreCase:忽略大小写的情况下
            throw new TeamException("该员工已是某团队成员");
        } else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("该成员正在休假，无法添加");
        }
        //团队中至多只能有一名架构师

        //团队中至多只能有两名设计师
        //团队中至多只能有三名程序员

        //获取team中已有成员中架构师，设计师，程序员的人数
        int numberOfArch = 0, numberOfDes = 0, numberOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numberOfArch++;
            } else if (team[i] instanceof Designer) {
                numberOfDes++;
            } else if (team[i] instanceof Programmer) {
                numberOfPro++;
            }
        }
        if (p instanceof Architect) {
            if (numberOfArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numberOfDes > 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numberOfPro > 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        //错误的
//        if(p instanceof Architect && numberOfArch>=1){
//            throw new TeamException("团队中至多只能有一名架构师");
//        }else if(p instanceof Designer && numberOfDes > 2){
//            throw new TeamException("团队中至多只能有两名设计师");
//        }else if(p instanceof Programmer && numberOfPro > 2){
//            throw new TeamException("团队中至多只能有三名程序员");
//        }

        //p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        //将p（或e）添加到现有的team中
        team[total++] = p;
        //p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }

    /**
     * @param memeberId
     * @throws TeamException
     * @author
     * @Description 从团队中删除
     * @date 2023.2.23    10:58 am
     */
    public void removeMember(int memeberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memeberId) {
                team[i].setStatus(FREE);
                break;
            }
        }
        //未找到指定memeberId的情况
        if (i == total) {
            throw new TeamException("找不到删除指定memeberId的员工，删除失败");
        }

        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        team[total--] = null;

    }

    /**
     * @author
     * @Description 判断指定员工是否已经存在于现有的开发团队中
     * @date 2023.2.23    10:58 am
     */
    public boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }
}
