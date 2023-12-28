package javahigh.day06.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ����Ԫ�صı���������ʹ�õ�����Iterator�ӿ�
 * 1.�ڲ��ķ�����hasNext������next����
 * 2.���϶���ÿ�ε���iterator()�����õ�һ��ȫ�µĵ���������
 * 3.�ڲ�������remove�����������ڱ�����ʱ��ɾ�������е�Ԫ�ء��˷�����ͬ�ڼ���ֱ�ӵ���remove������
 */
public class IteratorTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //��ʽһ:
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//
//        //���쳣:NoSuchElementException
//        System.out.println(iterator.next());

        //��ʽ��:���Ƽ�
//        for(int i=0;i<coll.size();i++){
//            System.out.println(iterator.next());
//        }
        //��ʽ��:�Ƽ�
        //�ж��Ƿ�����һ��Ԫ��
        while (iterator.hasNext()) {
            //��ָ�����Ƣڽ������Ժ󼯺�λ���ϵ�Ԫ�ط���
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);


        //����ʽһ:
//        Iterator iterator=coll.iterator();
//        while(iterator.next()!=null){
//            System.out.println(iterator.next());
//        }//�ᱨ�쳣���������������

        //����ʽ��:
        //���϶���ÿ�ε���iterator()�������õ�һ��ȫ�µĵ���������Ĭ���α궼�ڼ��ϵĵ�һ��Ԫ��
        while (coll.iterator().hasNext()) {

            System.out.println(coll.iterator().next());
        }
    }

    //����Iterator�е�remove����
    //��remove֮ǰû�е���next����IllegalStateException�쳣
    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //ɾ�������С�Tom��
        Iterator iterator = coll.iterator();
        //iterator.remove();//��remove֮ǰû�е���next����IllegalStateException�쳣
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if ("Tom".equals(obj)) {
                iterator.remove();
//                iterator.remove();
            }

        }
        //��������
        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            System.out.println(obj);
        }


    }
}
