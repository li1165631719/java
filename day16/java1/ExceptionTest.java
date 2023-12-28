package day16.java1;

import org.junit.Test;

import javax.xml.crypto.Data;


/**
 * 一、异常体系结构
 * <p>
 * java.lang.Throwable
 * |-------java.lang.Error:一般不编写针对性的代码进行处理
 * |-------java.lang.Exception:可以进行异常的处理
 * |----------编译异常（checked）
 * |-------IOException
 * |---------FileNotFoundException
 * |-------ClassNotFoundException
 * |---------运行时异常（unchecked）
 * |------NUllPointerException
 * |------ArrayIndexOutOfBoundsException
 * |------ClassCastException
 * |------NumberFormatException
 * |------InputMissingException
 * |------ArithmeticException
 * <p>
 * 面试题：常见的异常有哪些？举例说明
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
