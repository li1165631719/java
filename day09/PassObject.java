package day09;

public class PassObject {
    public static void main(String[] args) {
        PassObject passObject = new PassObject();
        Circle c = new Circle();
        PassObject.printArea(c, 5);
        System.out.println("now radius is " + c.radius);
    }

    public static void printArea(Circle c, int time) {
        System.out.println("radius\t\tArea");
        for (int i = 1; i <= time; i++) {
            c.radius = i;//设置园的半径
            System.out.println(c.radius + "\t\t" + c.findArea());
        }
        c.radius = time + 1;
    }
}
