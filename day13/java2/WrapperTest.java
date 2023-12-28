package day13.java2;

import org.junit.Test;

/**
 * 包装类的使用：
 * 1.java提供了8种基本数据类型对应的包装类，使得基本数据类的变量具有类的特征
 * <p>
 * 2.掌握的：基本数据类型、包装类、String三者之间的相互转换
 */
public class WrapperTest {

    //String类型---->基本数据类型、包装类：调用包装类的parseXxx()
    @Test
    public void test5() {
        String str1 = "123";
        //错误的情况：
//        int num1=(int)str1;
//        Integer in1=(Integer) str1;

        //可能会报numberFormat的错误
        int num1 = Integer.parseInt(str1);
        System.out.println(num1 + 1);

        String str2 = "true1";
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1);

        boolean b2;


    }

    //基本数据类型、包装类------>String类型：调用String重载的valueOf（Xxx xxx)
    @Test
    public void test4() {

        int num1 = 10;
        //方式一：连接运算
        String str1 = num1 + "";
        //方式二：调用String的valueOf(Xxx xxx)
        float f1 = 12.3f;
        String str2 = String.valueOf(f1);//"12.3"

        Double d1 = new Double(12.4);
        String str3 = String.valueOf(d1);
    }


    /***
     * JDK 5.0新特性：自动装箱和自动拆箱
     */
    @Test
    public void test3() {
//        int num1=10;
//        //基本数据类型----->包装类
//        method(num1);
//        Integer in1=new Integer(num1);
//        method(in1);//这样就可以多态的放在method方法中了

        //自动装箱：
        int num2 = 10;
        Integer in1 = num2;//就不需要构造器去让基本数据类型转为包装类了

        boolean b1 = true;
        Boolean b2 = b1;//自动装箱

        //自动开箱：包装类------>基本数据类型
        System.out.println(in1.toString());
        int num3 = in1.intValue();
        int num4 = in1;//自动拆箱，不需要intValue

        Integer n1 = new Integer(num3);//装箱

    }

    public void method(Object obj) {

        System.out.println(obj);
    }


    //包装类------>基本数据类型:调用包装类的xxxValue()

    /**
     * 包装类作为一个类是不可以进行加减乘除的，所以需要转化成基本数据类去进行加减乘除。
     */
    @Test
    public void test2() {
        Integer in1 = new Integer(12);
        int i1 = in1.intValue();
        System.out.println(i1 + 1);

        Float f1 = new Float(12.3);
        float f2 = f1.floatValue();
        System.out.println(f2 + 1);
    }

    //基本数据类型----->包装类:调用包装类的构造器
    @Test
    public void test1() {

        int num1 = 10;
//        System.out.println(num1.toString());

        Integer in1 = new Integer(num1);
        System.out.println(in1.toString());


        Integer in2 = new Integer("123");
        System.out.println(in2.toString());
//        Integer in3=new Integer("123abc");
//        System.out.println(in3.toString());
        System.out.println(in2);
        Float f1 = new Float(12.3f);
        Float f2 = new Float("12.3");
        System.out.println(f1);
        System.out.println(f2);

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("true123");
        System.out.println(b2);

        Order order = new Order();
        System.out.println(order.isMale);
        System.out.println(order.isFemale);


    }

    @Test
    public void test7() {
        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;


        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
    }
}

class Order {
    boolean isMale;
    Boolean isFemale;
}
