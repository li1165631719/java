package day17.com.atguigu.team.service;

import day17.com.atguigu.team.domain.PC;
import day17.com.atguigu.team.domain.*;

import static day17.com.atguigu.team.service.Data.*;


/**
 * @author
 * @version v1.0
 * @Description 负责将Data中的数据封装到Employee[]数据中，同时提供相关操作Employee[]的方法
 * @data 2023年2月12日下午16：28
 * <p>
 * java面向对象的语言，必须要new对象，直接类声明只是个空对象
 */
public class NameListService {

    private Employee[] employees;

    /**
     * 给employees及数组元素进行初始化
     */
    public NameListService() {
//        根据项目提供的Data类构建相应大小的employees数组
//        再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect
//        将对象存于数组中
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < EMPLOYEES.length; i++) {

            //获取员工类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            //获取Employee的4个基本信息  String =>包装类以及基本类型 反之用valueof()
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            double bonus;//以防bonus为空
            int stock;//以防stock为空
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
     * @Description 获取指定index上的员工的设备
     * @author
     * @version v1.0
     * @data 2023年2月12日下午16：28
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
     * @Description 获取当前所有员工
     * @author
     * @version v1.0
     * @data 2023年2月12日下午16：28
     */
    public Employee[] getAllEmployees() {

        return employees;
    }

    /**
     * @Description 获取指定id的员工对象
     * @author
     * @version v1.0
     * @data 2023年2月12日下午16：28
     */

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {//id是int类型，如果是用Integer类型用equals
                return employees[i];//找到就返回这个员工了，直接出函数了，无需break

            }
        }
        throw new TeamException("找不到指定的员工");//抛出异常但不处理，在调用该方法时候再进行处理
    }

}
