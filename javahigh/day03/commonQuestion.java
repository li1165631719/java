package javahigh.day03;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author lizhihao
 * @Date 2023/11/24 21:42
 * @PackageName:javahigh.day03
 * @ClassName: commonQuestion
 * @Description: TODO
 * @Version 1.0
 */
public class commonQuestion {


    //常见的算法题目

    /**
     * 1、模拟一个trim()方法，去除字符串两端的空格。
     */
    @Test
    public void test() {
        String str1 = " abc ";
        String str2 = trim(str1);
        System.out.println(str2);
    }

    public String trim(String str) {
        char[] strchars = str.toCharArray();
        int t = 0;
        int e = 0;
        while ((t < strchars.length) && ((strchars[t] & 0xff) == ' ')) {
            t++;
        }
        while ((e < strchars.length) && ((strchars[strchars.length - 1 - e] & 0xff) == ' ')) {
            e++;
        }
        String str1 = new String(strchars, t, str.length() - e - 1);
        return str1;
    }

    /**
     * 2、将一个字符串进行反转。将字符串中指定部分进行反转。比如"abcdefg"反转为"abfedcg"
     */
    @Test
    public void test2() {
        String str = "abcdefg";
        String str1 = back(str, 2);
        System.out.println(str1);
    }

    public String back(String str, int index) {
        char[] chars = str.toCharArray();
        for (int i = index; i < str.length() / 2; ++i) {
            char tmp = chars[i];
            chars[i] = chars[str.length() - i - 1];
            chars[str.length() - i - 1] = tmp;
        }
        str = new String(chars);
        return str;
    }

    /**
     * 3、获取一个字符串在另一个字符串中出现的次数。
     * 比如：获取"ab"在"abkkcadkabkebfkabkskab"中出现的次数
     */
    @Test
    public void test3() {

        String search = "k";
        String str = "abkkcadkabkebfkabkskab";
        int index = 0;
        int count = 0;
        int cout1 = searchCharIndex(search, str, count, index);
        System.out.println(cout1);
    }

    public int searchCharIndex(String search, String str, int count, int index) {
        for (int i = 0; i < str.length(); i++) {
            if ((str.indexOf(search, index) != -1) && ((str.indexOf(search, index) + search.length()) < str.length())) {
                count++;
                index = str.indexOf(search, index) + search.length();
                i = index;
            }
//            }else if((str.indexOf(search,index)==-1)&&(index==0)){//第一次寻找短字符串时就找不到
//                System.out.println("短字符串未在长字符串中出现");
//                break;
//            }
        }
        return count;
    }

    /**
     * 4、获取两个字符串中最大的相同子串。比如：
     * str1="abcwerthelloyulodef"; str2="cvhellobnm"
     * 提示：将短的那个串进行长度依次递减的字串与较长的串比较
     * 思路：
     * 依次截取str2字符串
     * 利用substring截取substring(i,i+flag) i的范围str2.length-flag+1  遍历所有该长度的连续字符串
     * 用indexOf（str1，str3）>0确认字符串是否存在
     */
    @Test
    public void test4() {
        String str1 = "abcwerthelloyulodef";
        String str2 = "cvhellobnmlodef";
        int k = -1;
        HashSet<String> strings = new HashSet<>();
        strings = getMaxSameString(str1, str2);
        System.out.println(strings);

    }

    public HashSet<String> getMaxSameString(String str1, String str2) {
        int flag = 0;//代表字串个数
        boolean k = false;
        HashSet<String> strings = new HashSet<>();
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() <= str2.length()) ? str1 : str2;
        for (flag = str2.length(); flag > 0; --flag) {
            for (int i = 0; i < str2.length() - flag + 1; ++i) {
                String str3 = str2.substring(i, i + flag);
                k = str1.contains(str3);
                if (k) {
                    strings.add(str3);
                    if (i == (str2.length() - flag)) {
                        return strings;
                    }
                }
            }
        }
        if (!k) {
            System.out.println("没有匹配到相同字串");
        }
        return null;
    }


    /**
     * 5、对字符串中字符进行自然顺序排序
     * 提示：
     * 1)字符串变成字符数组
     * 2)对数组排序，选择，冒泡，Arrays.sort();
     * 3)将排序后的数组变成字符串
     */
    @Test
    public void test5() {
        String str = "abfedcg";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String str2 = new String(chars);
        System.out.println(str2);
    }


}

