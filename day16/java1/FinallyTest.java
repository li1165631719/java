package day16.java1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * try-catch-finally��finally��ʹ��
 * <p>
 * <p>
 * 1.finally�ǿ�ѡ��
 * <p>
 * 2.finally����������һ���ᱻִ�еĴ��룬��ʹcatch���ֳ����쳣�ˣ�try����return��䣬catch����
 * return���������
 * <p>
 * 3.�����ݿ����ӡ����������������Socket����Դ��JVM�ǲ����Զ����յģ�������Ҫ�Լ��ֶ��Ľ�����Դ��
 * �ͷš���ʱ����Դ�ͷţ�����Ҫ������finally�С�
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
            System.out.println("��һ���ᱻִ��");
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
//        System.out.println("�Һ�˧��~~~~~");
        finally {
            System.out.println("�Һ�˧��~~~~~");
        }
    }
}
