package day16.java;

public class InnerClassTest {
    /**
     * �ھֲ��ڲ���ķ����У�����show��������þֲ��ڲ����������ķ��������磺method���еľֲ�����������num���Ļ���
     * Ҫ��˱�������Ϊfinal�ġ�
     * <p>
     * jdk 7��֮ǰ�汾��Ҫ��˾ֲ�������ʽ������Ϊfinal��
     * jdk 8��֮��İ汾������ʡ��final������
     */

    public void method() {
        //�ֲ�����
        int num = 10;
        class AA {
            public void show() {
//                num=20;
                System.out.println(num);
            }
        }
    }
}
