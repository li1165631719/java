package day16.java;

/**
 * Error ��Java������޷�������������⡣�磺JVMϵͳ�ڲ�������Դ
 * �ľ���������������磺StackOverflowError��OOM��
 * <p>
 * һ�㲻��д����ԵĴ�����д���
 */
public class ErrorTest {
    public static void main(String[] args) {
        // 1.ջ�����java.lang.StackOverflowError
//        main(args);
        //2.������� java.lang.OutOfMemoryError
        Integer[] arr = new Integer[1024 * 1024 * 1024];
    }
}
