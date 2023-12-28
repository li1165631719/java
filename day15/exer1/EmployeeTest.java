package day15.exer1;

public class EmployeeTest {
    public static void main(String[] args) {
        //多态
        Employee manager = new Manager("1", "库克", 10000, 5000);
        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.work();
    }
}
