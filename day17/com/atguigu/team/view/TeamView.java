package day17.com.atguigu.team.view;

import day17.com.atguigu.team.domain.Employee;
import day17.com.atguigu.team.domain.Programmer;
import day17.com.atguigu.team.service.NameListService;
import day17.com.atguigu.team.service.TeamService;

public class TeamView {

    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }

    public void enterMainMenu() {
        boolean loopFlag = true;
        char menu = '0';
        while (loopFlag) {
            if ((menu != '1') & (menu != '2') & (menu != '3')) {
                listAllEmployees();
            }
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    getTeam();
                    break;
                case '3':
                    Programmer[] programmers = teamSvc.getTeam();
                    if (programmers.length == 0) {
                        System.out.println("团队成员为空，无成员可删");
                    } else {
                        getTeam();
                        deleteMember();
                    }
                    break;
                case '4':
                    System.out.println("确认是否退出（Y/N）：");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    /**
     * @Description 显示所有的员工信息
     * @author
     * @version v1.0
     * @data 2023年2月12日下午16：28
     */
    private void listAllEmployees() {
//        System.out.println("显示员工的所有信息");
        System.out.println("----------------------------------开发团队 调度软件----------------------------------\n");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null && employees.length == 0) {
            System.out.println("公司中没有任何员工信息");
        } else {
            System.out.println("ID\t姓名\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    private void getTeam() {
        //System.out.println("查看开发团队情况");
        Programmer[] programmers = teamSvc.getTeam();
//        System.out.println(programmers.length);
        if (programmers == null || programmers.length == 0) {
            System.out.println("开发团队中没有任何员工信息");
        } else {
            System.out.println("ID\t姓名\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
            for (int i = 0; i < programmers.length; i++) {
                System.out.println(programmers[i]);
            }
        }
    }

    private void addMember() {
//        System.out.println("添加团队成员");
        try {
            System.out.println("请输入需要添加的指定团队成员id:");
            int id = TSUtility.readInt();
            Employee employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteMember() {
//        System.out.println("删除团队成员");
        //        System.out.println("添加团队成员");
        try {
            System.out.println("请输入需要删除的指定团队成员id:");
            int id = TSUtility.readInt();
            Employee employee = listSvc.getEmployee(id);
            teamSvc.removeMember(id);
            System.out.println("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
