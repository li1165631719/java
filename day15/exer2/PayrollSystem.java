package day15.exer2;

import java.util.Scanner;

/**
 * ����PayrollSystem�࣬����Employee�������鲢��ʼ�����������Ÿ�
 * ���Ա��������á�����ѭ���ṹ��������Ԫ�أ���������������
 * ��,name,number,birthday,�Լ��ö������ա����������뱾���·�ֵʱ�������
 * ����ĳ��Employee��������գ���Ҫ������ӹ�����Ϣ��
 */
public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�����뵱�µ��·ݣ�");
        int month = scanner.nextInt();
        Employee[] emps = new Employee[2];

        emps[0] = new SalarieddEmployee("��ɭ", 1002, new MyDate(1992, 2, 28), 10000);
        emps[1] = new HourlyEmployee("������", 2001, new MyDate(1991, 5, 6), 60, 240);

        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
            System.out.println("�¹���Ϊ��" + emps[i].earnings());
            if (month == emps[i].getBirthday().getMonth()) {
                System.out.println("���տ��֣�����һ��Ԫ��");
            }
        }
    }
}
