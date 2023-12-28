package javahigh.day06.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

    /**
     * 1.��TreeSet����Ӷ���Ҫ������ͬ��Ķ���
     * 2.����������Ȼ���� �� ��������
     * <p>
     * <p>
     * 3.��Ȼ���򣬱Ƚ����������Ƿ���ͬ�ı�׼Ϊ��compareTo()����0������equals().
     * 4.���������У��Ƚ����������Ƿ���ͬ�ı�׼Ϊ��compare()����0������equals().
     */
    @Test
    public void Test() {
        TreeSet set = new TreeSet();
        //������Ӳ�ͬ��Ķ���

//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));

        //����һ��
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //��������
        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 32));
        set.add(new User("Jim", 2));
        set.add(new User("Mike", 65));
        set.add(new User("Jack", 33));
        set.add(new User("Jack", 56));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {


        Comparator comparator = new Comparator() {
            //���������С��������
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    if (u1.getAge() == u2.getAge()) {
                        return u1.getName().compareTo(u2.getName());
                    } else {
                        return Integer.compare(u1.getAge(), u2.getAge());
                    }
                } else {
                    throw new RuntimeException("������������Ͳ�ƥ�䣡");
                }
            }
        };
        TreeSet set = new TreeSet<>(comparator);
        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 32));
        set.add(new User("Jim", 2));
        set.add(new User("Mike", 65));
        set.add(new User("Jack", 33));
        set.add(new User("Jack", 56));
        set.add(new User("Marry", 33));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
