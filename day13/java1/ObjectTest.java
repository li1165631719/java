package day13.java1;

/**
 * java.lang.Object类
 * 1.Object类是所有java类的根父类
 * 2.如果再类的声明中未使用extends关键字指明父类，则默认父类为java.lang.Object类
 * 3.Object类中的功能（属性、方法）就具有通用性
 * 属性：无
 * 方法：equals()/toString()/getClass()/hashCode()/clone()/finalize()/
 * wait()、notify()、notifyAll()
 * <p>
 * 4.Object类只声明一个空参的构造器
 * <p>
 * 面试题：
 * final、finally、finalize的区别？
 * finalize：
 * 在对象被垃圾回收之前，对象自动的调用自己的finalize方法。
 */
public class ObjectTest {
    public static void main(String[] args) {

        Order order = new Order();
        System.out.println(order.getClass().getSuperclass());
    }
}

class Order {

}
