package day15.java2;

public class InnerClassTest1 {

    //�����к��ټ�
    public void method() {
        //�ֲ��ڲ���
        class AA {

        }
    }


    //����һ��ʵ����Comparable�ӿڵ���Ķ���
    public Comparable getComparable() {

        //����һ��ʵ����Comparable�ӿڵ���:�ֲ��ڲ���
        //��ʽһ��
//        class MyComparable implements Comparable{
//
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//        return new MyComparable();
        //��ʽ����
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}
