package day15.exer3;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(3.4);
        ComparableCircle c2 = new ComparableCircle(3.6);

        int compareValue = c1.compareTo(c2);
        if (compareValue > 0) {
            System.out.println("c1�Ķ����");

        } else if (compareValue < 0) {
            System.out.println("c2�Ķ����");
        } else if (compareValue == 0) {
            System.out.println("c1��c2һ����");
        }

        int compareValue2 = c1.compareTo(new String("AA"));
        System.out.println(compareValue2);

    }
}
