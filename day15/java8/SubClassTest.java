package day15.java8;

public class SubClassTest {
    public static void main(String[] args) {
        SubClass s = new SubClass();
        //s.method1();
        //SubClass.method1();
        //֪ʶ��1���ӿ��ж���ľ�̬������ֻ��ͨ���ӿ�ȥ����
        CompareA.method1();
        //֪ʶ��2��ͨ��ʵ����Ķ��󣬿��Ե��ýӿ��е�Ĭ�Ϸ���
        //���ʵ������д�˽ӿ��е�Ĭ�Ϸ���������ʱ����Ȼ���õ�����д�Ժ�ķ���
        s.method2();
        //֪ʶ��3��������ࣨ��ʵ���ࣩ�̳еĸ����ʵ�ֽӿ���������ͬ��ͬ�����ķ�����
        //��ô������û����д�˷���������£�Ĭ�ϵ��õ��Ǹ����е�ͬ��ͬ�����ķ�����--->������ԭ��
        //֪ʶ��4�����ʵ����ʵ�������ӿڣ��������ӿ��ж�����ͬ��ͬ������Ĭ�Ϸ�����
        //��ô��ʵ����û����д�˷���������£�����----->�ӿڳ�ͻ
        //�����Ҫ���Ǳ�����ʵ��������д�˷�����
        s.method3();

        //SubClass.method2();
    }
}

class SubClass extends SuperClass implements CompareA, CompareB {

    @Override
    public void method2() {
        System.out.println("SubClass:�Ϻ�");
    }

    @Override
    public void method3() {
        System.out.println("SubClass:����");
    }

    //֪ʶ��5������������У���ʵ���ࣩ�е��ø��ࡢ�ӿ��б���д�ķ���
    public void myMethod() {
        method3();//�����Լ���д�ķ���
        super.method3();//���ø�����������
        //���ýӿ��е�Ĭ�Ϸ���
        CompareA.super.method3();
        CompareA.super.method3();
    }
}