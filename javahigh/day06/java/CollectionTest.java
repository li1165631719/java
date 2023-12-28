package javahigh.day06.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法的测试
 * <p>
 * 向Collection接口的实现类的对象中添加数据时，要求obj所在类重写equals方法（）；
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
        collection.add(new Person("Jerry", 20));//再没有重写person里的equals之前用==判断，而不是判断内容

        //1.contains(Object) obj):判断当前集合中是否包含obj
        //我们在判断时会调用obj对象所在类的equals（）。
        boolean contains = collection.contains(123);
        System.out.println(contains);
        System.out.println(collection.contains(new String("Tom")));
//        System.out.println(collection.contains(person));//true
        System.out.println(collection.contains(new Person("Jerry", 20)));

        //2.containsAll(Collection coll1):判断形参coll1中所有元素是否都存在于当前集合中
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


        //4.removeAll(Collection coll1):从当前集合中移除coll1中所有元素
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

        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前的集合。
//        Collection coll1= Arrays.asList(123, 456);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj):要想返回true，判断当前集合和形参集合要相同。
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("Jerry", 20));
        coll1.add(new String("Tom"));
        coll1.add(false);
        System.out.println(coll.equals(coll1));//顺序不一样equals()也不是true
    }


    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合  ----->数组:toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组 ----->集合:调用Arrays类的静态方法aList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});//识别成一个对象元素了。
        List arr2 = Arrays.asList(123, 456);

        System.out.println(arr1.size());
        List arr3 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr3.size());//2
        System.out.println(arr1);
        System.out.println(arr2);

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素，放在IteratorTest.java中


    }

}
