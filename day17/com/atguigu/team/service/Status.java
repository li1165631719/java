package day17.com.atguigu.team.service;

/**
 * ���ܣ���ʾԱ����״̬
 */
public class Status {
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");
    private final String NAME;
    private Status(String name) {
        this.NAME = name;
    }//���췽��

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
