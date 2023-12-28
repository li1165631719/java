package day17.com.atguigu.team.service;

import day17.com.atguigu.team.domain.PC;
import day17.com.atguigu.team.domain.*;

import static day17.com.atguigu.team.service.Data.*;


/**
 * @author
 * @version v1.0
 * @Description ����Data�е����ݷ�װ��Employee[]�����У�ͬʱ�ṩ��ز���Employee[]�ķ���
 * @data 2023��2��12������16��28
 * <p>
 * java�����������ԣ�����Ҫnew����ֱ��������ֻ�Ǹ��ն���
 */
public class NameListService {

    private Employee[] employees;

    /**
     * ��employees������Ԫ�ؽ��г�ʼ��
     */
    public NameListService() {
//        ������Ŀ�ṩ��Data�๹����Ӧ��С��employees����
//        �ٸ���Data���е����ݹ�����ͬ�Ķ��󣬰���Employee��Programmer��Designer��Architect
//        ���������������
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < EMPLOYEES.length; i++) {

            //��ȡԱ������
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            //��ȡEmployee��4��������Ϣ  String =>��װ���Լ��������� ��֮��valueof()
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            double bonus;//�Է�bonusΪ��
            int stock;//�Է�stockΪ��
            Equipment equipment;
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }

    }

    /**
     * @Description ��ȡָ��index�ϵ�Ա�����豸
     * @author
     * @version v1.0
     * @data 2023��2��12������16��28
     */
    private Equipment creatEquipment(int index) {
        int key = Integer.parseInt(EQIPMENTS[index][0]);
        String modelOrname = EQIPMENTS[index][1];
        switch (key) {
            case PC://21
                String display = EQIPMENTS[index][2];
                return new PC(modelOrname, display);
            case NOTEBOOK://22
                String price = EQIPMENTS[index][2];
                return new NoteBook(modelOrname, price);
            case PRINTER://23
                return new Printer(modelOrname, EQIPMENTS[index][2]);
        }

        return null;
    }

    /**
     * @Description ��ȡ��ǰ����Ա��
     * @author
     * @version v1.0
     * @data 2023��2��12������16��28
     */
    public Employee[] getAllEmployees() {

        return employees;
    }

    /**
     * @Description ��ȡָ��id��Ա������
     * @author
     * @version v1.0
     * @data 2023��2��12������16��28
     */

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {//id��int���ͣ��������Integer������equals
                return employees[i];//�ҵ��ͷ������Ա���ˣ�ֱ�ӳ������ˣ�����break

            }
        }
        throw new TeamException("�Ҳ���ָ����Ա��");//�׳��쳣���������ڵ��ø÷���ʱ���ٽ��д���
    }

}
