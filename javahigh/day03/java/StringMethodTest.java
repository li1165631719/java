package javahigh.day03.java;

import org.junit.Test;

/**
 * @Author lizhihao
 * @Date 2023/11/20 21:27
 * @PackageName:javahigh.day03.java
 * @ClassName: StringMethodTest
 * @Description: TODO
 * @Version 1.0
 */
public class StringMethodTest {

    /**
     * 替换：
     * String replace(char oldChar, char newChar)：返回一个新的字符串，它是
     * 通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
     * String replace(CharSequence target, CharSequence replacement)：使
     * 用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
     * String replaceAll(String regex, String replacement) ： 使 用 给 定 的
     * replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
     * String replaceFirst(String regex, String replacement) ： 使 用 给 定 的
     * replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
     * 匹配：
     * boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
     * 切片：
     * String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
     * String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此
     * 字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
     */

    @Test
    public void test4() {
        String str1 = "北京尚硅谷教育北京";
        String str2 = str1.replace('北', '东');
        System.out.println(str1);
        System.out.println(str2);//返回变了，但是原来的str1没有变

        String str3 = str1.replace("北京", "上海");
        System.out.println(str3);

        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);

        String str4 = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str4.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);

        String str5 = "hello|world|java";
        String[] strs = str5.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }

        System.out.println();

        String str6 = "hello.world.java";
        String[] strs6 = str6.split("\\.");
        for (int i = 0; i < strs6.length; i++) {
            System.out.println(strs6[i]);
        }

    }

    /**
     * boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
     * boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
     * boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的
     * 子字符串是否以指定前缀开始
     * boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列
     * 时，返回 true
     * int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
     * int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出
     * 现处的索引，从指定的索引开始
     * int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
     * int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后
     * 一次出现处的索引，从指定的索引开始反向搜索
     * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
     */

    @Test
    public void test3() {
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("ld");
        System.out.println(b1);

        boolean b2 = str1.endsWith("He");
        System.out.println(b2);

        boolean b3 = str1.startsWith("ll", 2);
        System.out.println(b3);

        String str2 = "woR";
        System.out.println(str1.contains(str2));


        System.out.println(str1.indexOf("lol"));

        System.out.println(str1.indexOf("lo", 5));

        int count = 0;
        int index = 0;//记录索引
        String search = "o";
        System.out.println(searchCharIndex(search, str1, count, index));

        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or"));
        System.out.println(str3.lastIndexOf("or", 6));

        //什么情况下，indexOf(str)和lstIndexOf(str)返回值相同？
        //要么一个要么没有

    }

    //查找字符（字符串）在字符串中的个数
    public int searchCharIndex(String search, String str1, int count, int index) {
        for (int i = 1; i < str1.length(); ++i) {
            if (str1.indexOf(search, index) != -1) {
                count++;
                index = str1.indexOf(search, index) + search.length();
            } else {
                return count;
            }
        }
        return count;
    }

    /**
     * int length()：返回字符串的长度： return value.length
     * char charAt(int index)： 返回某索引处的字符return value[index]
     * boolean isEmpty()：判断是否是空字符串：return value.length == 0
     * String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
     * String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
     * String trim()：返回字符串的副本，忽略前导空白和尾部空白
     * boolean equals(Object obj)：比较字符串的内容是否相同
     * boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大
     * 小写
     * String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
     * int compareTo(String anotherString)：比较两个字符串的大小
     * String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从
     * eginIndex开始截取到最后的一个子字符串。
     * String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字
     * 符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
     */

    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");

        String s5 = "abc";
        String s6 = new String("abd");
        System.out.println(s5.compareTo(s6));//涉及到字符串的排序

        String s7 = "北京尚硅谷教育";
        String s8 = s7.substring(2);
        System.out.println(s7);
        System.out.println(s8);
        String s9 = s7.substring(2, 5);
        System.out.println(s9);
    }


    @Test
    public void test1() {
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));

        System.out.println(s1.isEmpty());//length==0

        String s2 = s1.toLowerCase();
        System.out.println(s1);//s1是不可变的，仍然为原来的字符串
        System.out.println(s2);//改成小写后的字符串

        String s3 = "  Hel   loW   orld    ";
        String s4 = s3.trim();//去除首尾空格
        System.out.println("-------" + s3 + "------");
        System.out.println("-------" + s4 + "------");

    }


}
