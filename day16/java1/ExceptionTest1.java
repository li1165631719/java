package day16.java1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * �쳣�Ĵ���ץ��ģ��
 * ����һ�����ס�������������ִ�й����У�һ�������쳣���ͻ����쳣���봦����һ����Ӧ�쳣��Ķ���
 * �����˶����׳���
 * һ���׳������Ժ����Ĵ���Ͳ���ִ�С�
 * <p>
 * �����쳣����Ĳ�������ϵͳ�Զ����ɵ��쳣����
 * ���ֶ�����һ���쳣���󣬲��׳���throw��
 * <p>
 * <p>
 * ���̶�����ץ�����������Ϊ�쳣�Ĵ���ʽ����try-catch-finally ��throws
 * <p>
 * <p>
 * ����try-catch-finally��ʹ��
 * <p>
 * try{
 * //���ܳ����쳣�Ĵ���
 * }catch���쳣����1 ������1��{
 * //�����쳣�ķ�ʽ1
 * }catch���쳣����2 ������2��{
 * //�����쳣�ķ�ʽ2
 * }catch���쳣����3 ������3��{
 * //�����쳣�ķ�ʽ3
 * }
 * ����������
 * finally{
 * //һ����ִ�еĴ���
 * }
 * <p>
 * ˵����
 * 1.finallyʱ��ѡ��
 * 2.ʹ��try�����ܳ����쳣�����װ��������ִ�й����У�һ�������쳣���ͻ�����һ����Ӧ�쳣��Ķ��󣬸��ݴ˶����
 * ���ͣ�ȥcatch��ƥ��
 * 3.һ��try�е��쳣����ƥ�䵽ĳһ��catch���ͽ���catch�����쳣�Ĵ���һ��������ɣ���������ǰ��
 * try-catch�ṹ����û��finally�������������ִ�����Ĵ���
 * 4.catch�е��쳣�������û�и��ӹ�ϵ����˭�������ϣ�˭������������ν��
 * catch�е��쳣������������Ӹ����ϵ����Ҫ��������һ�������ڸ�������棬���򣬱���
 * 5.���õ��쳣������ķ�ʽ����String getMessage() ��printStackTrace()
 * 6.��try�ṹ�������ı������ٳ���try�ṹ���Ͳ����ٱ�����
 * 7.try-catch-finally�ṹ����Ƕ��
 * <p>
 * <p>
 * ���1��ʹ��try-catch-finally�������ʱ�쳣��ʹ�ó����ڱ���ʱ���ٱ�����������ʱ���Կ��ܱ���
 * �൱������ʹ��try-catch-finally��һ������ʱ���ܳ��ֵ��쳣���ӳٵ�����ʱ���֡�
 * ���2�������У����������쳣�Ƚϳ�������������ͨ���Ͳ��������ʱ�쳣��дtry-catch-finally�ˡ�
 * ����ڱ���ʱ�쳣������˵һ��Ҫ�����쳣�Ĵ���
 */
public class ExceptionTest1 {
    @Test
    public void test2() {
        try {
            File file = new File("day16/java/hello.txt");
            FileInputStream fileInputStream = new FileInputStream(file);

            int data = fileInputStream.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        String str = "123";
        str = "abc";
        int num = 0;
        try {
            num = Integer.parseInt(str);
            System.out.println("hello------1");
        } catch (NumberFormatException e) {
//            System.out.println("������ֵת���쳣�ˣ���Ҫ�ż�����������");
            //String getMessage����;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(num);
        System.out.println("hello------2");
    }
}
