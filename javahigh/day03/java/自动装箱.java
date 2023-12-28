package javahigh.day03.java;

import org.junit.Test;

/**
 * @Author lizhihao
 * @Date 2023/11/23 0:26
 * @PackageName:javahigh.day03.java
 * @ClassName: 自动装箱
 * @Description: TODO
 * @Version 1.0
 */
public class 自动装箱 {
    @Test
    public void test() {

        int num1 = 1;//基本数据类型：int num1

        Integer a = 2; //自动装箱  封装类型：Integer i
        Integer b = new Integer(2); //自动装箱
        num1 = a;
        //实际:先装箱然后拆箱
        Integer i = Integer.valueOf(num1);//装箱:基本类型转换成封装类型
        int v = i.intValue();//拆箱:对象重新转化为基本数据类型

        /**
         * 八种基本数据类型分别是：
         * 1、4种整数类型（byte、short、int、long）；
         * 2、2种浮点类型（float、double）；
         * 3、1种字符类型“char”；
         * 4、1种布尔类型“boolean”。
         * */
    }
}
