package javahigh.day06.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection�ӿ��������ķ����Ĳ���
 * <p>
 * ��Collection�ӿڵ�ʵ����Ķ������������ʱ��Ҫ��obj��������дequals����������
 */
public class CollectionTest {

    @Test
    public void test1() {
        //contains()
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
//        Person person =new Person("Jerry",20);
//        collection.add(person);
        collection.add(new Person("Jerry", 20));//��û����дperson���equals֮ǰ��==�жϣ��������ж�����

        //1.contains(Object) obj):�жϵ�ǰ�������Ƿ����obj
        //�������ж�ʱ�����obj�����������equals������
        boolean contains = collection.contains(123);
        System.out.println(contains);
        System.out.println(collection.contains(new String("Tom")));
//        System.out.println(collection.contains(person));//true
        System.out.println(collection.contains(new Person("Jerry", 20)));

        //2.containsAll(Collection coll1):�ж��β�coll1������Ԫ���Ƿ񶼴����ڵ�ǰ������
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(collection.containsAll(coll1));


    }

    @Test
    public void test2() {
        //3.remove(object obj):
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);


        //4.removeAll(Collection coll1):�ӵ�ǰ�������Ƴ�coll1������Ԫ��
        Collection coll1 = Arrays.asList(123, 456);
        coll.remove(coll1);
        System.out.println(coll);


    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //5.retainAll(Collection coll1):��������ȡ��ǰ���Ϻ�coll1���ϵĽ����������ظ���ǰ�ļ��ϡ�
//        Collection coll1= Arrays.asList(123, 456);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj):Ҫ�뷵��true���жϵ�ǰ���Ϻ��βμ���Ҫ��ͬ��
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("Jerry", 20));
        coll1.add(new String("Tom"));
        coll1.add(false);
        System.out.println(coll.equals(coll1));//˳��һ��equals()Ҳ����true
    }


    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //7.hashCode():���ص�ǰ����Ĺ�ϣֵ
        System.out.println(coll.hashCode());

        //8.����  ----->����:toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //��չ������ ----->����:����Arrays��ľ�̬����aList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});//ʶ���һ������Ԫ���ˡ�
        List arr2 = Arrays.asList(123, 456);

        System.out.println(arr1.size());
        List arr3 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr3.size());//2
        System.out.println(arr1);
        System.out.println(arr2);

        //9.iterator():����Iterator�ӿڵ�ʵ�������ڱ�������Ԫ�أ�����IteratorTest.java��


    }

}
