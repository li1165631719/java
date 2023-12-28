package day17.com.atguigu.team.service;

/**
 * 功能：表示员工的状态
 */
public class Status {
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");
    private final String NAME;
    private Status(String name) {
        this.NAME = name;
    }//构造方法

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
