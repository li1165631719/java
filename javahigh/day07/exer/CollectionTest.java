package javahigh.day07.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CollectionTest {
    //练习：在List内去除重复数字值，要求尽量简单
    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    @Test
    public void test1() {
        Collection coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(343);
        coll.forEach(System.out::println);

    }

    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }

    @Test
    public void test3() {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");
        set.add(p1);
        set.add(p2);

        p1.setName("CC");
        set.remove(p1);//移除的是新算的hash值不再是之前“AA”hash值所处的位置。这样处于”AA“hashcode的”CC“并不会被”CC“算出的hashcode位置删除。
        // 没如果不重写hashcode和equals方法，就会去找p1的地址。
        System.out.println(set);
        set.add(new Person(1001, "CC"));
        System.out.println(set);
        set.add(new Person(1001, "AA"));
        System.out.println(set);
    }
}
