package javahigh.day06.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 ������foreachѭ�������ڱ������ϡ�����
 */
public class ForTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for( ����Ԫ�ص����� �ֲ����� : ���϶���)
        //�ڲ���Ȼ�����˵�������
        for (Object obj : coll) {

            System.out.println(obj);

        }
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        //for(����Ԫ�ص����� �ֲ����� : �������)
        for (int i : arr) {
            System.out.println(i);

        }
    }

    //��ϰ��
    @Test
    public void test3() {
        String[] arr = new String[]{"MM", "MM", "MM"};

        //��ʽһ����ͨforѭ��
//        for(int i=0;i< arr.length;i++){
//            arr[i]="GG";
//        }
        //��ʽ������ǿforѭ��
        for (String s : arr//��arr[i]��s,ȥ����ֵ���������鲻�䡣
        ) {
            s = "GG";
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
