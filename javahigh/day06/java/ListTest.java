package javahigh.day06.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 1.list�ӿڿ��
 * |-----Collection�ӿڣ����м��ϣ������洢һ��һ���Ķ���
 * |-----list�ӿڣ��洢����ġ����ظ������ݡ�  ----->����̬"����,�滻ԭ�е�����
 * |------ArrayList:��Ϊlist�ӿڵ���Ҫʵ���࣬�̲߳���ȫ�ģ�Ч�ʸߣ��ײ���Object[]elementData�洢
 * |------LinkList:����Ƶ���Ĳ��롢ɾ��������ʹ�ô���Ч�ʱ�ArrayList�ߣ��ײ�ʹ��˫������洢
 * |------Vector:��Ϊlist�ӿڵĹ���ʵ���࣬�̰߳�ȫ��
 * <p>
 * 2.ArrayList��Դ�����
 * 2.1jdk 7�����
 * ArrayList list=new ArrayList();//�ײ㴴���˳�����10��Object[]����elementData
 * List.add(123);//elementData[0]=new Integer(123);
 * .....
 * list.add(11);//����˴ε���ӵ��µײ�elementData�������������������ݡ�
 * Ĭ������£�����Ϊԭ����������1.5����ͬʱ��Ҫ��ԭ�������е����ݸ��Ƶ��µ������С�
 * <p>
 * ���ۣ����鿪����ʹ�ô��εĹ�����:ArrayList list=new ArrayList(initialCapacity)
 * <p>
 * 2.2jdk8��ArrayList�ı仯
 * ArrayList list =new ArrayList();//�ײ�Object[] elementData��ʼ��Ϊ{}����û�д�������Ϊ10������
 * <p>
 * list.add(123);//��һ�ε���add()ʱ���ײ�Ŵ����˳���Ϊ10�����飬��������123��ӵ�element[0]��
 * ...
 * ��������Ӻ����ݲ�����jdk7����
 * 2.3С�᣺jdk7�е�ArrayList�����ڵ����Ķ���ʽ����jdk8�е�ArrayLits�Ķ���
 * �Ĵ��������ڵ���������ʽ���ӳ�������Ĵ�������ʡ�ڴ档
 * <p>
 * 3.LinkList��Դ�����
 * LinkList list=new LinkedList();�ڲ�������Node���ͺ�first��last���ԡ�
 * list.add(123);//��123��װ��Node�У�������Node����
 * <p>
 * ����Node����Ϊ��
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
 * �����⣺ArrayList��LinkList��Vector���ߵ���ͬ��
 * ͬ�������඼ʵ����List�ӿڣ��洢���ݵ��ص���ͬ���洢����ġ����ظ�������
 * ��ͬ������
 * <p>
 * <p>
 * <p>
 * <p>
 * 5.list�ӿ��еĳ��÷���
 */
public class ListTest {
    /**
     * void add(int index, Object ele):��indexλ�ò���eleԪ��
     * boolean addAll(int index, Collection eles):��indexλ�ÿ�ʼ��eles��
     * ������Ԫ����ӽ���
     * Object get(int index):��ȡָ��indexλ�õ�Ԫ��
     * int indexOf(Object obj):����obj�ڼ������״γ��ֵ�λ��
     * int lastIndexOf(Object obj):����obj�ڵ�ǰ������ĩ�γ��ֵ�λ��
     * Object remove(int index):�Ƴ�ָ��indexλ�õ�Ԫ�أ������ش�Ԫ��
     * Object set(int index, Object ele):����ָ��indexλ�õ�Ԫ��Ϊele
     * List subList(int fromIndex, int toIndex):���ش�fromIndex��toIndex
     * λ�õ��Ӽ���
     * <p>
     * <p>
     * <p>
     * <p>
     * �ܽ᣺���÷���
     * <p>
     * ����add(Object obj)
     * ɾ��remove(int index)/remove(Object obj)
     * �ģ�set(int index,Object ele)
     * �飺get(int index)
     * �壺add(int index,Object ele)
     * ���ȣ�size()
     * ������
     * ��Iterator������
     * ����ǿforѭ��
     * ����ͨ��ѭ��
     */

    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //��ʽһ:Iterator��������ʽ
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("*************************");

        //��ʽ����
        for (Object obj : list) {

            System.out.println(obj);
        }

        System.out.println("*************************");

        //��ʽ������ͨforѭ��
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
        //int indexOf(Object obj):����obj�ڼ������״γ��ֵ�λ��,��������ڷ���-1
        int index = list.indexOf(456);
        System.out.println(index);

        //int lastIndexOf(Object obj):����obj�ڵ�ǰ������ĩ�γ��ֵ�λ��
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index):�Ƴ�ָ��indexλ�õ�Ԫ�أ������ش�Ԫ��
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index, Object ele):����ָ��indexλ�õ�Ԫ��Ϊele
        list.set(1, "CC");
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):���ش�fromIndex��toIndexλ�õ�����ҿ�����
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

        //void add(int index,Object ele):��indexλ�ò���eleԪ��
        list.add(1, "BB");
        System.out.println(list);

        //boolean addAll(int index,Collection eles):��indexλ�ý�eles������Ԫ�ؼ��뼯����
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        //list.add(list1);//���������Ͽ���һ������
        System.out.println(list.size());

        //Object get(int index):��ȡָ��indexλ�õ�Ԫ��
        System.out.println(list.get(0));

    }
}
