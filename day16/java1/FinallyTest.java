package day16.java1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * try-catch-finally中finally的使用
 * <p>
 * <p>
 * 1.finally是可选的
 * <p>
 * 2.finally中声明的是一定会被执行的代码，即使catch中又出现异常了，try中有return语句，catch中有
 * return语句等情况。
 * <p>
 * 3.像数据库连接、输入输出流、网络Socket等资源，JVM是不能自动回收的，我们需要自己手动的进行资源的
 * 释放、此时的资源释放，就需要声明在finally中。
 */

public class FinallyTest {

    @Test
    public void test2() {
        FileInputStream fileInputStream = null;
        try {
            File file = new File("hello.txt");
            fileInputStream = new FileInputStream(file);

            int data = fileInputStream.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fileInputStream.read();
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testMethod() {
        int num = method();
        System.out.println(num);
    }

    public int method() {
        try {
            int[] arr = new int[10];
            //System.out.println(arr[10]);
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return 2;
        } finally {
            System.out.println("我一定会被执行");
            return 3;
        }
    }

    @Test
    public void test1() {
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("我好帅啊~~~~~");
        finally {
            System.out.println("我好帅啊~~~~~");
        }
    }
}
