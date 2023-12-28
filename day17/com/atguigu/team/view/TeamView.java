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
            System.out.println("1-�Ŷ��б� 2-����Ŷӳ�Ա 3-ɾ���Ŷӳ�Ա 4-�˳� ��ѡ��1-4����");
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
                        System.out.println("�Ŷӳ�ԱΪ�գ��޳�Ա��ɾ");
                    } else {
                        getTeam();
                        deleteMember();
                    }
                    break;
                case '4':
                    System.out.println("ȷ���Ƿ��˳���Y/N����");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    /**
     * @Description ��ʾ���е�Ա����Ϣ
     * @author
     * @version v1.0
     * @data 2023��2��12������16��28
     */
    private void listAllEmployees() {
//        System.out.println("��ʾԱ����������Ϣ");
        System.out.println("----------------------------------�����Ŷ� �������----------------------------------\n");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null && employees.length == 0) {
            System.out.println("��˾��û���κ�Ա����Ϣ");
        } else {
            System.out.println("ID\t����\t\t����\t����\t\tְλ\t\t״̬\t\t����\t\t��Ʊ\t\t�����豸");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    private void getTeam() {
        //System.out.println("�鿴�����Ŷ����");
        Programmer[] programmers = teamSvc.getTeam();
//        System.out.println(programmers.length);
        if (programmers == null || programmers.length == 0) {
            System.out.println("�����Ŷ���û���κ�Ա����Ϣ");
        } else {
            System.out.println("ID\t����\t\t����\t����\t\tְλ\t\t״̬\t\t����\t\t��Ʊ\t\t�����豸");
            for (int i = 0; i < programmers.length; i++) {
                System.out.println(programmers[i]);
            }
        }
    }

    private void addMember() {
//        System.out.println("����Ŷӳ�Ա");
        try {
            System.out.println("��������Ҫ��ӵ�ָ���Ŷӳ�Աid:");
            int id = TSUtility.readInt();
            Employee employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("��ӳɹ���");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteMember() {
//        System.out.println("ɾ���Ŷӳ�Ա");
        //        System.out.println("����Ŷӳ�Ա");
        try {
            System.out.println("��������Ҫɾ����ָ���Ŷӳ�Աid:");
            int id = TSUtility.readInt();
            Employee employee = listSvc.getEmployee(id);
            teamSvc.removeMember(id);
            System.out.println("ɾ���ɹ���");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
