package javahigh.day04.exer;

import org.junit.Test;

/**
 * @Author lizhihao
 * @Date 2023/12/10 19:57
 * @PackageName:javahigh.day04.exer
 * @ClassName: StringDemo1
 * @Description: TODO
 * @Version 1.0
 */
public class StringDemo1 {
    /**
     * 3、获取一个字符串在另一个字符串中出现的次数。
     * 比如：获取"ab"在"abkkcadkabkebfkabkskab"中出现的次数
     */
    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        //方式一：
//            while((index=mainStr.indexOf(subStr))!=-1){
//                count++;
//                mainStr=mainStr.substring(index+subStr.length());
//            }
//            return count;
        //方式二：对方式一的改进
        while ((index = mainStr.indexOf(subStr, index)) != -1) {
            count++;
            index += subLength;
        }
        return count;

    }

    @Test
    public void testGetCount() {
        String mainStr = "abkkcadkabkebfkabkskab";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
        int index = subStr.indexOf(mainStr);
        System.out.println(index);

    }
}
