package day15.java1;

interface Attackable {
    void attack();

}

interface Flyable {
    //ȫ�ֳ���
    public static final int MAX_SPEED = 7900;//��һ�����ٶ�
    public static final int MIN_SPEED = 1;

    //���󷽷�
    public abstract void fly();

    //ʡ����public abstract
    void stop();

}

//*******************************************8
interface AA {

    void method1();
}

interface BB {

    void method2();
}

interface CC extends AA, BB {

}

/**
 * �ӿڵ�ʹ��
 * 1.ʹ��interface������
 * 2.��Java�У��ӿں������������еĽṹ
 * 3.��ζ���ӿڣ�����ӿ��еĳ�Ա
 * <p>
 * 3.1  JDK7��ǰ��ֻ�ܶ���ȫ�ֳ����ͳ��󷽷�
 * >ȫ�ֳ�����public static final�ģ�������дʱ������ʡ�Բ�д
 * >���󷽷���public abstract��
 * 3.2 JDK8�����˶���ȫ�ֳ����ͳ��󷽷�֮�⣬�����Զ��徲̬������Ĭ�Ϸ���
 * <p>
 * <p>
 * <p>
 * 4.�ӿ��в��ܶ��幹�����ģ���ζ�Žӿڲ�����ʵ����
 * <p>
 * 5.Java�����У��ӿ�ͨ���ӿ�����ȥʵ�֣�implements���ķ�ʽ��ʹ��
 * ���ʵ���า���˽ӿ������г��󷽷������ʵ����Ϳ���ʵ������
 * ���ʵ����û�и��ǽӿ������еĳ��󷽷������ʵ������Ϊһ��������
 * <p>
 * <p>
 * 6.Java�����ʵ�ֶ���ӿ�------->�ֲ���Java���̳еľ�����
 * ��ʽ�� class AA extends BB implements CC,DD,EE
 * 7.�ӿںͽӿ�֮����Զ�̳�
 * <p>
 * ********************************************8
 * 8.�ӿڵľ���ʹ�ã����ֶ�̬��
 * 9.�ӿڣ�ʵ���Ͽ��Կ�����һ�ֹ淶
 * <p>
 * �����⣺��������ӿ�����Щ��ͬ��
 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
        //Flyable.MIN_SPEED=2;
        Plane plane = new Plane();
        plane.fly();
    }
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("ͨ���������");

    }

    @Override
    public void stop() {
        System.out.println("��ʻԱ�ڼ���");

    }

}

class Bullet implements Flyable, Attackable, CC {

    @Override
    public void attack() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}