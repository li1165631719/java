package day15.exer1;

public class Manager extends Employee {
    private double bonus;//奖金


    public Manager(double bonus) {
        super();
        this.bonus = bonus;
    }

    public Manager(String id, String name, double salary, double bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("管理员工，提供公司运行的效率");
    }
}
