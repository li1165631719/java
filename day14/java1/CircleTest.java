package day14.java1;

//static关键字的应用
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle(3.4);
        System.out.println("c1的id：" + c1.getId());
        System.out.println("c2的id：" + c2.getId());
        System.out.println("c3的id：" + c3.getId());
        System.out.println("创建圆的个数为：" + Circle.getTotal());
    }


}

class Circle {

    private static int total = 0;//记录创建的圆个数
    private static int init = 1001;//static声明的属性被所有对象所共享
    private double radius;
    private int id;//自动赋值

    public Circle() {
        id = init++;
        total++;
    }

    public Circle(double radius) {
        this();
        //id=init++;
        //total++;
        this.radius = radius;
    }

    public static int getTotal() {
        return total;
    }

    public double findArea() {
        return 3.14 * radius * radius;

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }


}