package day14.java1;

/**
 * static�ؼ��ֵ�ʹ��
 * <p>
 * 1.static����̬��
 * 2.static�����������Ρ����ԡ�����������顢�ڲ���
 * <p>
 * 3.ʹ��static��������:��̬������
 * 3.1���԰��Ƿ�ʹ��static���Σ��ַ�Ϊ����̬����vs�Ǿ�̬���ԣ�ʵ��������
 * ʵ�����������Ǵ�������Ķ������ÿ�����󶼶�����ӵ��һ�����еķǾ�̬���ԣ����޸�����һ�������е�
 * �Ǿ�̬����ʱ�����ᵼ������������ͬ��������ֵ���޸�
 * ��̬���������Ǵ�������Ķ�����󣬶��������ͬһ����̬��������ͨ��ĳһ�������޸ľ�̬����ʱ���ᵼ��
 * ����������ô˾�̬����ʱ�����޸Ĺ��˵ġ�
 * 3.2 static�������Ե�����˵����
 * �پ�̬����������ļ��ض����أ�����ͨ��"��.��̬����"�ķ�ʽ���ã�ʵ���������ű����Ĵ��������أ�
 * �ھ�̬�����ļ���Ҫ���ڶ���Ĵ�����
 * ��������ֻ�����һ�Ρ���̬������������Ҳֻ�����һ�ݣ����ڷ������ľ�̬���С�
 * <p>
 * ��           �����         ʵ������
 * ��            yes           no
 * ����          yes           yes
 * 3.3 ��̬���Ծ�����System.out;Math.PI;
 * <p>
 * <p>
 * 4.ʹ��static���η���:��̬����
 * ��������ļ��ض����أ�����ͨ������.�������������е���
 * ��              ������          �Ǿ�̬����
 * ��           yes             no
 * ����         yes             yes
 * �� ��̬�����У�ֻ�ܵ��þ�̬�ķ���������
 * �Ǿ�̬�����У��ȿ��Ե��÷Ǿ�̬�ķ��������ԣ�Ҳ���Ե��þ�̬�ķ���������
 * <p>
 * 5�� staticע��㣺
 * 5.1�ھ�̬�����ڣ�������this�ؼ��֡�super�ؼ���
 * 5.2���ھ�̬���Ժ;�̬������ʹ�ã���Ҷ����������ڵĽǶ�����⡣
 * <p>
 * 6. �����У����ȷ��һ�������Ƿ�����Ϊstatic�ģ�
 * >�����ǿ��Ա��������������ģ��������Ŷ���Ĳ�ͬ����ͬ�ġ�
 * >���еĳ���Ҳ��������Ϊstatic
 * <p>
 * �����У����ȷ��һ�������Ƿ�����Ϊstatic�ģ�
 * >������̬���Եķ�����ͨ������Ϊstatic��
 * >�������еķ�����ϰ��������Ϊstatic�ġ����磺Math��Arrays��Collections
 */

public class StaticTest {

    public static void main(String[] args) {

        Chinese.nation = "�й�";
        Chinese.show();


        Chinese chinese = new Chinese();
        chinese.name = "Ҧ��";
        chinese.age = 40;

        Chinese chinese1 = new Chinese();
        chinese1.name = "����";
        chinese1.age = 30;

        chinese.nation = "CHN";
        chinese.eat();


        System.out.println(chinese1.nation);

    }

}

//�й���
class Chinese {
    static String nation;
    String name;
    int age;

    public static void show() {
        //���ܵ��÷Ǿ�̬�Ľṹ
        System.out.println("����һ���й���");
        System.out.println(Chinese.nation);
        walk();
    }

    public static void walk() {

    }

    public void eat() {
        System.out.println("�й��˳��в�");
        //���÷Ǿ�̬�ṹ
        this.info();
        System.out.println("name:" + name);
        //���þ�̬�ṹ
        walk();
        System.out.println("nation:" + nation);


    }

    public void info() {
        System.out.println("name:" + name + ",age:" + age);
    }
}
