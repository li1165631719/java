package day16.java1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * try catch ����������쳣��ʹ�ó������������ȥ�ˡ����ڼ����ݽ��ķ����У���һ������������û��Ҫִ���ˣ�
 * ����ÿ������Ӧ��throwsֱ���׳������������󷽷���Ӧ��try-catch���쳣�����
 */


/**
 * �쳣����ķ�ʽ����throws + �쳣����                             throws�׳��쳣���ǲ�������쳣��try-catch-finally�Ƿ��ֲ�������쳣
 *
 *1.��throws + �쳣���͡�д�ڷ�������������ָ���˷���ִ��ʱ�����ܻ��׳��쳣����
 *  һ����������ִ��ʱ�������쳣���Ի����쳣���봦����һ���쳣��Ķ��󣬴˶�������throws���쳣
 *  ����ʱ���ͻᱻ�׳����쳣�����쳣�����Ĵ��룬�Ͳ���ִ�У�
 *
 *2.��᣺try-catch-finally���������쳣���������
 *     throwsֻ�ǰ��쳣�׸������ĵ����ߣ������а��쳣�����Ĵ����
 *
 *3�����������ʹ��try-catch-finally����ʹ��throws?
 *  3.1��������б���д�ķ���û��throws�����쳣����������д�ķ���Ҳ����ʹ��throws����ζ�����
 *     ������д�ķ������쳣������ʹ��try-catch-finally��ʽ����
 *  3.2ִ�з���a�У��Ⱥ��ֵ��������⼸���������⼸�������ǵݽ���ϵִ�еġ����ǽ����⼸������ʹ��throw
 *     �ķ�ʽ���д�����ִ�еķ���a���Կ���ʹ��try-catch-finally��ʽ����
 *
 *
 *
 */

public class ExceptionTest2 {
    public static void main(String[] args) {
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
        method3();
    }

    public static void method3() {
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method2() throws IOException {
        method1();
    }

    public static void method1() throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = null;
        File file = new File("hello1.txt");
        fileInputStream = new FileInputStream(file);

        int data = fileInputStream.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fileInputStream.read();
        }

        fileInputStream.close();

        System.out.println("hahahahahaha!");
    }
}
