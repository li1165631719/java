package day16.java2;

/**
 * throws
 * 1.���ڷ����������棬�������쳣����
 * 2.��ʾ�׳��쳣���ɸ÷����ĵ�����������
 * 3.��ʾ�����쳣��һ�ֿ����ԣ�����һ���ᷢ����Щ�쳣
 * <p>
 * throw
 * 1.���ڷ������ڣ��������쳣������
 * 2.��ʾ�׳��쳣���ɷ������ڵ���䴦��
 * 3.ִ�� throw һ���׳���ĳ���쳣
 * <p>
 * <p>
 * <p>
 * throwһ���׳��쳣��throws��һ���׳��쳣
 */
public class StudentTest {

    public static void main(String[] args) {
        Student s = new Student();
        try {
            s.regist(-1001);
            System.out.println(s);
        } catch (Exception e) {
            //           e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}

class Student {
    private int id;

    public void regist(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
//            System.out.println("����������ݷǷ���");
            //�ֶ��׳��쳣����
//            throw new RuntimeException("����������ݷǷ���");
//            throw new Exception("����������ݷǷ���");
            throw new MyException("�������븺����");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
