package javahigh.day06.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListExer {
    private static void updateList(List list) {
        //list.remove(2);
        list.remove(new Integer(2));
    }

    /**
     * ����list��remove��int index����remove��Object obj��
     */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }
}
