package day15.java;

/**
 * ���������������
 */

public class PersonTest {
    public static void main(String[] args) {

        method(new Student());//��������
        Worker worker = new Worker();
        method1(worker);//����������������Ķ���

        method1(new Worker());//���������������Ķ���

        //������һ����������Ķ���p
        Person p = new Person() {
            @Override
            public void eat() {

                System.out.println("�Զ���");
            }

            @Override
            public void breath() {

                System.out.println("�úú���");
            }
        };
        method1(p);
        //���������������������
        method1(new Person() {
            public void eat() {

                System.out.println("�ԺóԵĶ���");
            }

            @Override
            public void breath() {

                System.out.println("�úú������ʿ���");
            }
        });
    }


    public static void method1(Person p) {
        p.eat();
        p.breath();
    }

    public static void method(Student s) {

    }
}

class Worker extends Person {

    @Override
    public void breath() {

    }

    @Override
    public void eat() {

    }
}
