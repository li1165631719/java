package day14.java3;


/**
 * 对象可以赋值的位置：
 * ①默认初始化
 * ②显示初始化/⑤
 * ③构造器中初始化
 * ④有了对象以后，可以通过”对象.属性“或”对象.方法“，进行赋值
 * <p>
 * <p>
 * <p>
 * <p>
 * 执行的先后顺序：① - ② / ⑤ - ③ - ④
 */

public class OrderTest {

    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.orderId);
    }
}

class Order {
    int orderId = 3;

    {
        orderId = 4;
    }

}
