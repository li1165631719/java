package day15.exer;


public class CircleTest {
    public static void main(String[] args) {

        Circle circle1 = new Circle(2.3);
        Circle circle2 = new Circle(3.3, "white", 2.0);

        System.out.println("��ɫ�Ƿ���ȣ�" + circle1.getColor().equals(circle2.color));

        System.out.println("�뾶�Ƿ���ȣ�" + circle1.equals(circle2));

        System.out.println(circle1);
        System.out.println(circle2.toString());

    }


}
