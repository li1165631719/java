package day16.java2;

/**
 * ����Զ����쳣�ࣿ
 * 1.�̳������е��쳣�ṹ��RuntimeException  �� Exception
 * 2.�ṩȫ�ֳ�����serialVersionUID
 * 3.�ṩ���صĹ�����
 */
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 7172910833864283167L;//���Ψһ��ʶ

    public MyException() {

    }

    public MyException(String message) {

        super(message);
    }

}
