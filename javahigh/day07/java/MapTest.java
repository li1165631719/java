package javahigh.day07.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * һ��Map��ʵ����Ľṹ��
 * |----Map:˫�����ݣ��洢key-value�Ե�����  ---�����ڸ��еĺ�����y=f(x)
 * |----HashMap:��ΪMap����Ҫʵ����:�̲߳���ȫ�ģ�Ч�ʸߣ��ܴ洢null��key��value
 * |----LinkedHashMap:��֤����mapԪ��ʱ�����԰�����ӵ�˳��ʵ�ֱ���
 * ԭ����ԭ�е�HashMap�ײ�ṹ�����ϣ������һ��ָ�룬ָ��ǰһ���ͺ�һ��Ԫ��
 * ����Ƶ���ı�������������ִ��Ч�ʸ���HashMap��
 * |----TreeMap:��֤������ӵ�key-value�Խ�������ʵ�������������ʱ����key����Ȼ�����������
 * �ײ�ʹ�ú����
 * |----Hashtable:��Ϊ���ϵ�ʵ���ࣺ�̲߳���ȫ�ģ�Ч�ʵͣ����ܴ洢null��key��value
 * |----Properties:���������������ļ���key��value����String���͡�
 * <p>
 * <p>
 * HashMap�ĵײ㣺���飫����jdk7֮ǰ��
 * ���飫����+�������jdk8��
 * <p>
 * <p>
 * �����⣺
 * 1.HashMap�ĵײ�ʵ��ԭ��
 * 2.HashMap��HashTable����ͬ��
 * 3.CurrentHashMap��HashTable����ͬ������ʱ������
 * <p>
 * ����Map�ṹ����⣺
 * Map�е�key:����ġ������ظ��ģ�ʹ��Set�洢���е�Key ----->key���ڵ���Ҫ��дequals()��hashCode()(��HashMapΪ��)
 * Map�е�value������ġ����ظ��ģ�ʹ��Collection�洢���е�value ------>value���ڵ���Ҫ��дequals()
 * һ����ֵ�ԣ�key-value����һ��Entry����
 * Map�е�entry������ġ������ظ��ģ�ʹ��Set�洢���е�entry
 * <p>
 * ����HashMap�ĵײ�ʵ��ԭ����jdk7Ϊ��˵����
 * HashMap map=new HashMap������
 * ��ʵ�����Ժ󣬵ײ㴴���˳�����16��һά����Entry[] table��
 * ...�����Ѿ�ִ�й����put...
 * map.put(key1,value1):
 * ���ȣ�����key1�������hashCode()����key1��ϣֵ���˹�ϣֵ����ĳ���㷨�����Ժ󣬵õ�Entry�����еĴ��λ�á�
 * �����λ��������Ϊ�գ���ʱkey1-value1��ӳɹ���----���1
 * �����λ���ϵ����ݲ�Ϊ�գ�����λ���ϴ���һ�����߶�����ݣ���������ʽ���ڣ������Ƚ�key1���Ѿ����ڵ�һ�����߶������
 * �Ĺ�ϣֵ��
 * ���key1�Ĺ�ϣֵ���Ѿ����ڵ����ݵĹ�ϣֵ������ͬ,��ʱkey1-value1��ӳɹ���----���2
 * ���equals()����false����ʱ��key1-value1��ӳɹ���----���3
 * ���equals()����true:ʹ��value1�滻value2��
 * <p>
 * ���䣺�������2�����3����ʱkey1-value1��ԭ��������������ķ�ʽ�洢��
 * <p>
 * �ڲ��ϵ���ӹ����У����漰���������⣬Ĭ�ϵ����ݷ�ʽ������Ϊԭ��������2��������ԭ�е����ݸ��ƹ�����
 */
public class MapTest {

    @Test
    public void test1() {
        Map map = new HashMap<>();
//        map=new Hashtable();
        map.put(null, null);

    }
}
