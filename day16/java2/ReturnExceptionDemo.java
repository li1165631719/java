package day16.java2;

//���쳣��ֱ��ִ��finally������Ȼ�����쳣
public class ReturnExceptionDemo {
    public static void methodA() {
        try {
            System.out.println("���뷽��A");//��ִ�Т�
            throw new RuntimeException("�����쳣");

        } finally {
            System.out.println("��A������finally");//��ִ�Т�
        }
    }

    public static void methodB() {
        try {
            System.out.println("���뷽��B");
            return;
        } finally {
            System.out.println("��B������finally");
        }
    }

    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());//��ִ�Т۴����쳣
        }
        methodB();
    }
}
