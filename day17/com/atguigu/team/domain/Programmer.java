package day17.com.atguigu.team.domain;

import day17.com.atguigu.team.service.Status;

public class Programmer extends Employee {
    private int memberId;//开发团队中的id
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }


    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String toString() {
        return super.toString() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }
}
