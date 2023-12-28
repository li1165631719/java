package javahigh.day06.java1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * |-----Collection�ӿڣ����м��ϣ������洢һ��һ���Ķ���
 * |-----Set�ӿڣ��洢����ġ������ظ������ݡ�  ------>���н��ġ����ϡ�������ȷ��������
 * |------HashSet:��ΪSet�ӿڵ���Ҫʵ���࣬�̲߳���ȫ�ģ����Դ洢nullֵ
 * |------LinkedHashSet����ΪHashSet�����ࣺ�������ڲ�����ʱ�����԰�����ӵ�˳�����
 * ����Ƶ���ı���������LinkedHashSetҪ����HashSet��
 * |------TreeSet�����԰�����Ӷ����ָ�����ԣ���������
 * <p>
 * 1.Set�ӿ���û�ж�����ⶨ���µķ�����ʹ�õĶ���Collection���������ķ�����
 * <p>
 * 2.Ҫ����Set����ӵ����ݣ������ڵ���һ��Ҫ��дhashCode������equals����
 * Ҫ����д��hashCode������equals���������ܱ���һ���ԣ���ȵĶ�����������ȵ�ɢ����
 * ��д����������С���ɣ�����������equals���������Ƚϵ�Field,��Ӧ����������hashCode
 */
public class SetTest {
    /**
     * Set���洢����ġ������ظ�������
     * ��HashSetΪ��˵����
     * 1.�����ԣ�����������ԡ��洢�������ٵײ�������в��ǰ�������������˳����ӣ����Ǹ������ݵĹ�ϣֵ�����ġ�
     * <p>
     * 2.�����ظ��ԣ���֤��ӵ�Ԫ�ذ���equals�����ж�ʱ�����ܷ���true��������ͬ��Ԫ��ֻ�����һ����
     * <p>
     * ����������ݵĹ��̣���HashSetΪ����
     * ������HashSet�����Ԫ��a�����ȵ���Ԫ��a�������hashCode��������������Ԫ��a�Ĺ�ϣֵ��
     * �˹�ϣֵ����ͨ��ĳ���㷨�������HashSet�ײ������д�ŵ�λ�ã���Ϊ������λ�ã����ж�����
     * ��λ�����Ƿ��Ѿ���Ԫ�أ�
     * �����λ����û������Ԫ�أ���Ԫ��a��ӳɹ���------>���1
     * �����λ����������Ԫ��b������������ʽ���ڵĶ��Ԫ�أ������ȱȽ�Ԫ��a��Ԫ��b�Ĺ�ϣֵ��
     * ���hashֵ����ͬ����Ԫ��a��ӳɹ���------>���2
     * ���hashֵ��ͬ��������Ҫ����Ԫ��a�������equals����������
     * equals��������true��Ԫ��a���ʧ��
     * equals��������true����Ԫ��a��ӳɹ���------>���3
     * <p>
     * ������ӳɹ������2�����3���ԣ�Ԫ��a���Ѿ�����ָ������λ��������������ķ�ʽ�洢��
     * jdk7��Ԫ��a���������У�ָ��ԭ����Ԫ�ء�
     * jdk8:ԭ����Ԫ���������У�ָ��Ԫ��a
     * �ܽ᣺���ϰ���
     * <p>
     * HashSet�ײ㣺����+����Ľṹ��
     */

    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        // System.out.println(new User("Tom",22).equals(new User("Tom",22)));
        set.add(new User("Tom", 22));
        set.add(new User("Tom", 22));
        set.add(129);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    //LinkedHashSet��ʹ��
    //LinkedHashSet��ΪHashSet�����࣬��������ݵ�ʱ��ÿ�����ݻ�ά�����������ã���¼������ǰһ��
    //���ݺͺ�һ�����ݡ�
    //�ŵ㣺����Ƶ���ı���������LinkedHashSetҪ����HashSet��
    @Test
    public void test2() {
        Set set = new LinkedHashSet();//Ҳ������ģ�����������һ������
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        // System.out.println(new User("Tom",22).equals(new User("Tom",22)));
        set.add(new User("Tom", 22));
        set.add(new User("Tom", 22));
        set.add(129);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
