package day14.java3;

/***
 * ��ĳ�Ա֮�ģ�����飨��ʼ���飩
 *
 * 1.���������ã�������ʼ���ࡢ����
 * 2.�������������εĻ���ֻ����static.
 * 3.���ࣺ��̬����� vs �Ǿ�̬�����
 *
 * 4.��̬�����
 *       >�ڲ�������������
 *       >������ļ��ض�ִ��,����ִֻ��һ��
 *       >���ã���ʼ��һЩ�������
 *       >���һ�����ж����˶����̬�Ĵ���飬���Ⱥ�˳��ִ��
 *       >��̬������ִ��Ҫ�����ڷǾ�̬�����ִ��
 *       >��̬�������ֻ�ܵ��þ�̬�����ԡ���̬�ķ����������÷Ǿ�̬�Ľṹ
 *
 * 5.�Ǿ�̬�����
 *       >�ڲ�������������
 *       >���Ŷ���Ĵ�����ִ��
 *       >ÿ����һ�����󣬾�ִ��һ�ηǾ�̬�����
 *       >���ã��ڴ�������ʱ���Զ�������ԵȽ��г�ʼ��
 *       >���һ�����ж����˶���Ǿ�̬����飬�����������Ⱥ�˳��ִ��
 *       >�Ǿ�̬�������ֻ�ܵ��þ�̬�����ԡ���̬�ķ��������ܵ��÷Ǿ�̬�Ľṹ
 *
 *
 * ������Ը�ֵ��λ�ã�
 * ��Ĭ�ϳ�ʼ��
 * ����ʾ��ʼ��
 * �۹������г�ʼ��
 * �����˶����Ժ󣬿���ͨ��������.���ԡ��򡱶���.�����������и�ֵ
 * ���ڴ�����и�ֵ
 */
public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;
        Person person = new Person();
        Person person1 = new Person();
        Person.info();
    }
}

class Person {
    static String desc = "����һ����";

    //static�����
    static {

        System.out.println("hello,static block");
    }

    //����
    String name;
    int age;

    //��static�Ĵ����
    {

        System.out.println("hello��block");
    }

    //������
    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public static void info() {
        System.out.println("����һ�����ֵ���");
    }

    //����
    public void eat() {
        System.out.println("�Է�");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}