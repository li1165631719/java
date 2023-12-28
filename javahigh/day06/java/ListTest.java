package javahigh.day06.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 1.list接口框架
 * |-----Collection接口：单列集合，用来存储一个一个的对象
 * |-----list接口：存储有序的、可重复的数据。  ----->“动态"数组,替换原有的数组
 * |------ArrayList:作为list接口的主要实现类，线程不安全的，效率高；底层用Object[]elementData存储
 * |------LinkList:对于频繁的插入、删除操作，使用此类效率比ArrayList高：底层使用双向链表存储
 * |------Vector:作为list接口的古老实现类，线程安全的
 * <p>
 * 2.ArrayList的源码分析
 * 2.1jdk 7情况下
 * ArrayList list=new ArrayList();//底层创建了长度是10的Object[]数组elementData
 * List.add(123);//elementData[0]=new Integer(123);
 * .....
 * list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
 * 默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 * <p>
 * 结论：建议开发中使用带参的构造器:ArrayList list=new ArrayList(initialCapacity)
 * <p>
 * 2.2jdk8中ArrayList的变化
 * ArrayList list =new ArrayList();//底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 * <p>
 * list.add(123);//第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到element[0]中
 * ...
 * 后续的添加和扩容操作与jdk7无异
 * 2.3小结：jdk7中的ArrayList类似于单例的饿汉式，而jdk8中的ArrayLits的对象
 * 的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。
 * <p>
 * 3.LinkList的源码分析
 * LinkList list=new LinkedList();内部声明了Node类型和first和last属性。
 * list.add(123);//将123封装到Node中，创建了Node对象。
 * <p>
 * 其中Node定义为：
 * private static class Node<E> {
 * E item;
 * Node<E> next;
 * Node<E> prev;
 * <p>
 * Node(Node<E> prev, E element, Node<E> next) {
 * this.item = element;
 * this.next = next;
 * this.prev = prev;
 * }
 * }
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 面试题：ArrayList、LinkList、Vector三者的异同？
 * 同：三个类都实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 * 不同：见上
 * <p>
 * <p>
 * <p>
 * <p>
 * 5.list接口中的常用方法
 */
public class ListTest {
    /**
     * void add(int index, Object ele):在index位置插入ele元素
     * boolean addAll(int index, Collection eles):从index位置开始将eles中
     * 的所有元素添加进来
     * Object get(int index):获取指定index位置的元素
     * int indexOf(Object obj):返回obj在集合中首次出现的位置
     * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
     * Object remove(int index):移除指定index位置的元素，并返回此元素
     * Object set(int index, Object ele):设置指定index位置的元素为ele
     * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex
     * 位置的子集合
     * <p>
     * <p>
     * <p>
     * <p>
     * 总结：常用方法
     * <p>
     * 增：add(Object obj)
     * 删：remove(int index)/remove(Object obj)
     * 改：set(int index,Object ele)
     * 查：get(int index)
     * 插：add(int index,Object ele)
     * 长度：size()
     * 遍历：
     * ①Iterator迭代器
     * ②增强for循环
     * ③普通的循环
     */

    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //方式一:Iterator迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("*************************");

        //方式二：
        for (Object obj : list) {

            System.out.println(obj);
        }

        System.out.println("*************************");

        //方式三：普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);
        //int indexOf(Object obj):返回obj在集合中首次出现的位置,如果不存在返回-1
        int index = list.indexOf(456);
        System.out.println(index);

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1, "CC");
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开区间
        List subList = list.subList(1, 3);
        System.out.println(subList);


    }


    @Test
    public void test1() {

        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);

        System.out.println(list);

        //void add(int index,Object ele):在index位置插入ele元素
        list.add(1, "BB");
        System.out.println(list);

        //boolean addAll(int index,Collection eles):从index位置将eles的所有元素加入集合中
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        //list.add(list1);//将整个集合看成一个整体
        System.out.println(list.size());

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(0));

    }
}
