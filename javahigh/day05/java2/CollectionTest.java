package javahigh.day05.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * ���Ͽ�ܵĸ���
 * <p>
 * 1.���ϡ����鶼�ǶԶ�����ݽ��д洢�����ĵĽṹ�����java������
 * ˵������ʱ�Ĵ洢����Ҫָ�����ڲ����Ĵ洢�����漰���־û��Ĵ洢��.txt,.jpg,.avi�����ݿ��У�
 * <p>
 * 2.1�����ڴ洢������ݷ�����ص㣺
 * >һ����ʼ���Ժ��䳤�Ⱦ�ȷ���ˡ�
 * >����һ������ţ���Ԫ�ص�����Ҳ��ȷ���ˡ�����Ҳ��ֻ�ܲ���ָ�����͵������ˡ�
 * ���磺String[] arr;int[] arr1;Object[] arr2;
 * 2.2�����ڴ洢������ݷ�����ص㣺
 * >һ����ʼ���Ժ��䳤�ȾͲ����޸ġ�
 * >�������ṩ�ķ������ޣ�������ӡ�ɾ�����������ݵȲ������ǳ����㣬ͬʱЧ�ʲ��ߡ�
 * >��ȡ������ʵ��Ԫ�صĸ�������������û���ֳɵ����Ի򷽷�����
 * >����洢���ݵ��ص㣺���򡢿��ظ����������򡢲����ظ������󣬲������㡣
 * <p>
 * �������Ͽ��
 * |-----Collection�ӿڣ����м��ϣ������洢һ��һ���Ķ���
 * |-----list�ӿڣ��洢����ġ����ظ������ݡ�  ----->����̬���顱
 * |------ArrayList��LinkList��Vector
 * <p>
 * |-----Set�ӿڣ��洢����ġ������ظ������ݡ�  ------>���н��ġ����ϡ�������ȷ��������
 * |------HashSet��LinkedHashSet��TreeSet
 * <p>
 * |-------Map�ӿڣ�˫�м��ϣ������洢һ�ԣ�key - value��һ�Ե�����   ---->���еĺ�����y=f(x)
 * |-------HashMap��LinkedHashMap��TreeMap��Hashtable��Properties
 * <p>
 * <p>
 * ����Collection�ӿ��еķ�����ʹ��
 */
public class CollectionTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();

        //add(Object e)��
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());
//
//        int[] arr1=new int[10];
//        arr1[0]=arr1[1]=1;
//        System.out.println(arr1[0]);
//        System.out.println(arr1[0]==arr1[1]);

        //size():��ȡ��ӵ�Ԫ�صĸ���
        System.out.println(coll.size());

        //addAll():
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size());//6
        System.out.println(coll);

        //clear():��ռ���Ԫ��
        coll.clear();

        //isEmpty():�жϵ�ǰ�����Ƿ�Ϊ��
        System.out.println(coll.isEmpty());


    }
}
