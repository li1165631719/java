package javahigh.day03.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 *
 * @Author lizhihao
 * @Date 2023/11/22 23:49
 * @PackageName:javahigh.day03.java
 * @ClassName: StringTest1
 * @Description: TODO
 * @Version 1.0
 */
public class StringTest1 {

    @Test
    public void test4() {
        char[] f = new char[]{'a', 'b', 'c'};
        String a = new String(f);
        a.intern();
//        a.intern();
//        String b= a.intern();
//        String c= b.intern();
//
//        System.out.println(a==b);
//        System.out.println(b==c);
//        System.out.println(a==c);

        Person p = new Person("a", 18);
        Person p2 = new Person("a", 18);
        System.out.println(p.name == p2.name);

        //p.setName(p2.getName());
        System.out.println(p.name.intern() == p2.name);

        String country = "China";
        String internedCountry = country.intern();

        System.out.println("1111111111111:" + (country == internedCountry));
        String d = "abc";

        String e = new String(d);
        e.intern();

        System.out.println(e == a);
        System.out.println(d == e);
        System.out.println(d == a);

        System.out.println();

        new StringBuffer(e);

    }

    /**
     * String 与 byte[]之间的转换
     * 编码：String ---->byte[]:调用String的getBytes()
     * 解码：byte[] ---->String:调用String构造器
     * <p>
     * 编码：字符串 ------> 字节（看得懂 ------>看不懂的二进制数据）
     * 解码：编码的逆过程，字节 ------> 字符串（看不懂的二进制数据 ------>看得懂）
     * <p>
     * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("GBK");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("**************************");
        String str2 = new String(bytes);//使用默认的字符集，进行解码
        System.out.println(str2);

        String str3 = new String(gbks, "utf-8");
        System.out.println(str3);

        String str4 = new String(gbks, "gbk");
        System.out.println(str4);

    }

    //题目：abc123 从第二位开始倒序
    @Test
    public void testtest() {
        String str1 = "abc123";//题目：a21cb3

        char[] charArray = str1.toCharArray();
        for (int i = 1; i < (charArray.length / 2); i++) {
            char tmp = charArray[i];
            //System.out.println("临时存放char["+i+"]的值为："+tmp);
            charArray[i] = charArray[charArray.length - 1 - i];
            //System.out.println("被交换的值："+charArray[i]);
            charArray[charArray.length - 1 - i] = tmp;
        }
        String str2 = new String(charArray);
        System.out.println(str2);

    }

    /**
     * String与char[]之间的转换
     * <p>
     * String ----->char[]:调用String的toCharArray()
     * char[] ----->String:调用String的构造器
     */
    @Test
    public void test2() {
        String str1 = "abc123";//题目：a21cb3

        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(arr);
    }

    /**
     * 复习：
     * String 与基本数据类型、包装类之间的转换。
     * <p>
     * String ----> 基本数据类型、包装类:调用包装类的静态方法：parseXXX(str)
     * <p>
     * 基本数据类型、包装类 ----> String：调用String重载的valueOf();
     */

    @Test
    public void test() {
        String str = "123";
        //int num = (int)str;错误的
        int num = Integer.parseInt(str);
        String numString = String.valueOf(num);//"123"
        String str3 = num + "";//只要有变量参与运算都在堆里

        System.out.println(str == str3);//false  原因：因为str在常量池中，str3是在堆里运算后的结果


    }


}
