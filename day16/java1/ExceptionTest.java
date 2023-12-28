package day16.java1;

import org.junit.Test;

import javax.xml.crypto.Data;


/**
 * һ���쳣��ϵ�ṹ
 * <p>
 * java.lang.Throwable
 * |-------java.lang.Error:һ�㲻��д����ԵĴ�����д���
 * |-------java.lang.Exception:���Խ����쳣�Ĵ���
 * |----------�����쳣��checked��
 * |-------IOException
 * |---------FileNotFoundException
 * |-------ClassNotFoundException
 * |---------����ʱ�쳣��unchecked��
 * |------NUllPointerException
 * |------ArrayIndexOutOfBoundsException
 * |------ClassCastException
 * |------NumberFormatException
 * |------InputMissingException
 * |------ArithmeticException
 * <p>
 * �����⣺�������쳣����Щ������˵��
 */
public class ExceptionTest {

    //ClassCastException
    @Test
    public void test3() {
        Object obj = new Data() {

        };
        String str = (String) obj;
    }

    //ArrayIndexOutOfBoundsException
    @Test
    public void test2() {
        int[] arr = new int[10];
        System.out.println(arr[10]);
    }

    //NullPointerException
    @Test
    public void test1() {
//        int[] arr =null;
//        System.out.println(arr[3]);
        String str = "abc";
        str = null;
        System.out.println(str.charAt(0));
    }
}
