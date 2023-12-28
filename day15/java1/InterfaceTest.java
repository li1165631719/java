package day15.java1;

interface Attackable {
    void attack();

}

interface Flyable {
    //全局常量
    public static final int MAX_SPEED = 7900;//第一宇宙速度
    public static final int MIN_SPEED = 1;

    //抽象方法
    public abstract void fly();

    //省略了public abstract
    void stop();

}

//*******************************************8
interface AA {

    void method1();
}

interface BB {

    void method2();
}

interface CC extends AA, BB {

}

/**
 * 接口的使用
 * 1.使用interface来定义
 * 2.在Java中，接口和类是两个并列的结构
 * 3.如何定义接口，定义接口中的成员
 * <p>
 * 3.1  JDK7以前：只能定义全局常量和抽象方法
 * >全局常量：public static final的，但是书写时，可以省略不写
 * >抽象方法：public abstract的
 * 3.2 JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法和默认方法
 * <p>
 * <p>
 * <p>
 * 4.接口中不能定义构造器的！意味着接口不可以实例化
 * <p>
 * 5.Java开发中，接口通过接口让类去实现（implements）的方式来使用
 * 如果实现类覆盖了接口中所有抽象方法，则此实现类就可以实例化。
 * 如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类
 * <p>
 * <p>
 * 6.Java类可以实现多个接口------->弥补了Java单继承的局限性
 * 格式： class AA extends BB implements CC,DD,EE
 * 7.接口和接口之间可以多继承
 * <p>
 * ********************************************8
 * 8.接口的具体使用：体现多态性
 * 9.接口，实际上可以看做是一种规范
 * <p>
 * 面试题：抽象类与接口有哪些异同？
 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
        //Flyable.MIN_SPEED=2;
        Plane plane = new Plane();
        plane.fly();
    }
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("通过引擎起飞");

    }

    @Override
    public void stop() {
        System.out.println("驾驶员在减速");

    }

}

class Bullet implements Flyable, Attackable, CC {

    @Override
    public void attack() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}