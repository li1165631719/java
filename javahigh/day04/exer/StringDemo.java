package javahigh.day04.exer;

import org.testng.annotations.Test;

/**
 * @Author lizhihao
 * @Date 2023/12/10 18:29
 * @PackageName:javahigh.day04.exer
 * @ClassName: StringDemo
 * @Description: TODO
 * @Version 1.0
 */
public class StringDemo {
    /**
     * 2、将一个字符串进行反转。将字符串中指定部分进行反转。比如"abcdefg"反转为"abfedcg"
     * <p>
     * 方式一：转换为char[]
     */
    public String reverse(String str, int startIndex, int endIndex) {

        if (null != str) {
            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {
                char tmp = arr[x];
                arr[x] = arr[y];
                arr[y] = tmp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式二：使用String的拼接
    public String reverse1(String str, int startIndex, int endIndex) {
        if (null != str) {
            //第一部分
            String reverseStr = str.substring(0, startIndex);
            //第二部分
            for (int i = endIndex; i >= startIndex; i--) {//倒叙拼接
                reverseStr += str.charAt(i);
            }
            //第三部分
            reverseStr += str.substring(endIndex + 1);
            return reverseStr;
        }
        return null;
    }

    //方式三：使用StringBuffer/StringBuilder替换String
    public String reverse2(String str, int startIndex, int endIndex) {
        if (null != str) {
            StringBuilder builder = new StringBuilder(str.length());
            //第一部分
            builder.append(str.substring(0, startIndex));
            //第二部分
            for (int i = endIndex; i >= startIndex; i--) {//倒叙拼接
                builder.append(str.charAt(i));
            }
            //第三部分
            builder.append(str.substring(endIndex + 1));
            return builder.toString();
        }
        return null;
    }

    @Test
    public void test2() {
        String str = "abcdefg";
        String s1 = reverse2(str, 2, 5);
        System.out.println(s1);
    }
}
