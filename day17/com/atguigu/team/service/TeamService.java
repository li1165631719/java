package day17.com.atguigu.team.service;

import day17.com.atguigu.team.domain.Architect;
import day17.com.atguigu.team.domain.Designer;
import day17.com.atguigu.team.domain.Employee;
import day17.com.atguigu.team.domain.Programmer;

import static day17.com.atguigu.team.service.Status.FREE;

/**
 * @author
 * @Description ���ڿ����Ŷӳ�Ա�Ĺ�����ӡ�ɾ����
 * @date 2023.2.23    10:58 am
 */
public class TeamService {
    private static int counter = 1;//��memberId��ֵʹ��
    private final int MAX_MEMBER = 5;//���ƿ����Ŷӵ�����
    private Programmer[] team = new Programmer[MAX_MEMBER];//���濪���Ŷӳ�Ա
    private int total = 0;//��¼�����Ŷ���ʵ�ʵ�����

    public TeamService() {
        super();
    }

    /**
     * @author
     * @Description ��ȡ�����е����г�Ա
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
     * @Description ��ָ����Ա��ӵ��Ŷ���
     * @date 2023.2.23    10:58 am
     */
    public void addMember(Employee e) throws TeamException {
        //��Ա�������޷����
        if (total >= MAX_MEMBER) {
            throw new TeamException("��Ա�������޷����");
        }
        //�ó�Ա���ǿ�����Ա���޷����
        if (!(e instanceof Programmer)) {
            throw new TeamException("�ó�Ա���ǿ�����Ա���޷����");
        }
        //�ó�Ա���ڿ����Ŷ���
        if (isExist(e)) {
            throw new TeamException("�ó�Ա���ڿ����Ŷ���");
        }
        //��Ա������ĳ�Ŷӳ�Ա
        //�ó�Ա�����ݼ٣��޷����
        Programmer p = (Programmer) e;//һ���������ClassCastException
        if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {//equalsIgnoreCase:���Դ�Сд�������
            throw new TeamException("��Ա������ĳ�Ŷӳ�Ա");
        } else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("�ó�Ա�����ݼ٣��޷����");
        }
        //�Ŷ�������ֻ����һ���ܹ�ʦ

        //�Ŷ�������ֻ�����������ʦ
        //�Ŷ�������ֻ������������Ա

        //��ȡteam�����г�Ա�мܹ�ʦ�����ʦ������Ա������
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
                throw new TeamException("�Ŷ�������ֻ����һ���ܹ�ʦ");
            }
        } else if (p instanceof Designer) {
            if (numberOfDes > 2) {
                throw new TeamException("�Ŷ�������ֻ�����������ʦ");
            }
        } else if (p instanceof Programmer) {
            if (numberOfPro > 3) {
                throw new TeamException("�Ŷ�������ֻ������������Ա");
            }
        }

        //�����
//        if(p instanceof Architect && numberOfArch>=1){
//            throw new TeamException("�Ŷ�������ֻ����һ���ܹ�ʦ");
//        }else if(p instanceof Designer && numberOfDes > 2){
//            throw new TeamException("�Ŷ�������ֻ�����������ʦ");
//        }else if(p instanceof Programmer && numberOfPro > 2){
//            throw new TeamException("�Ŷ�������ֻ������������Ա");
//        }

        //p�����Ը�ֵ
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        //��p����e����ӵ����е�team��
        team[total++] = p;
        //p�����Ը�ֵ
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }

    /**
     * @param memeberId
     * @throws TeamException
     * @author
     * @Description ���Ŷ���ɾ��
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
        //δ�ҵ�ָ��memeberId�����
        if (i == total) {
            throw new TeamException("�Ҳ���ɾ��ָ��memeberId��Ա����ɾ��ʧ��");
        }

        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        team[total--] = null;

    }

    /**
     * @author
     * @Description �ж�ָ��Ա���Ƿ��Ѿ����������еĿ����Ŷ���
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
