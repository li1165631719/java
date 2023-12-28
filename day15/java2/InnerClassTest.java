package day15.java2;

/**
 * ����ڲ���Ա֮�壺�ڲ���
 * 1.Java������һ����A��������һ����B�У���A�����ڲ��࣬��B��Ϊ�ⲿ��
 * <p>
 * 2.�ڲ���ĳɷ֣���Ա�ڲ��ࣨ��̬���Ǿ�̬��vs�ֲ��ڲ��ࣨ�����ڡ�������ڡ��������ڣ�
 * <p>
 * 3.��Ա�ڲ��ࣺ
 * һ���棺��Ϊ�ⲿ��ĳ�Ա��
 * >�����ⲿ�ṹ
 * >���Ա�static���Σ������������ⲿ�ࣩ
 * >���Ա����ֲ�ͬȨ������
 * <p>
 * ��һ���棺��Ϊһ���ࣺ
 * >���ڿ��Զ������ԡ���������������
 * >���Ա�final���Σ���ʾ���಻�ܱ��̳С�����֮�⣬��ʹ��final,�Ϳ��Ա����Ρ�
 * >���Ա�abstract����
 * <p>
 * 4.��ע���µ�3������
 * 4.1 ���ʵ������Ա�ڲ���Ķ���
 * 4.2 ����ڳ�Ա�ڲ��������ֵ����ⲿ��Ľṹ
 * 4.3 �����оֲ��ڲ����ʹ��,��<{@link InnerClassTest1}>
 */
public class InnerClassTest {
    public static void main(String[] args) {
        //����Dogʵ������̬�ĳ�Ա�ڲ��ࣩ
        Person.Dog dog = new Person.Dog();
        dog.show();
        //����Birdʵ�����Ǿ�̬�ĳ�Ա�ڲ��ࣩ
//        Person.Bird bird=new Person.Bird();//����
        Person p = new Person();
        Person.Bird bird = p.new Bird();
        bird.sing();
        System.out.println();
        bird.display("���");
    }
}

class Person {
    String name = "С��";
    int age;

    public void eat() {
        System.out.println("�˳Է���");
    }

    //��̬��Ա�ڲ���
    static class Dog {

        String name;
        int age;

        public void show() {
            System.out.println("����������");
        }
    }

    //�Ǿ�̬��Ա�ڲ���
    class Bird {
        String name = "�ž�";

        public Bird() {

        }

        public void sing() {

            System.out.println("����һֻСС��");

            Person.this.eat();//�����ⲿ��ķǾ�̬����
        }

        public void display(String name) {
            System.out.println(name);//�������β�
            System.out.println(this.name);//�ڲ��������
            System.out.println(Person.this.name);//�ⲿ�������
        }
    }
}