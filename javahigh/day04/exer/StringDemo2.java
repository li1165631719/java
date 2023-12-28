package javahigh.day04.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lizhihao
 * @Date 2023/12/10 22:14
 * @PackageName:javahigh.day04.exer
 * @ClassName: StringDemo2
 * @Description: TODO
 * @Version 1.0
 */
public class StringDemo2 {
    /**
     * 4、获取两个字符串中最大的相同子串。比如：
     * str1="abcwerthelloyulodef"; str2="cvhellobnm"
     * 提示：将短的那个串进行长度依次递减的字串与较长的串比较
     * 前提：两个字符串中只有一个最大子串
     * 思路：
     * 依次截取str2字符串
     * 利用substring截取substring(i,i+flag) i的范围str2.length-flag+1  遍历所有该长度的连续字符串
     * 用indexOf（str1，str3）>0确认字符串是否存在
     */
    public String getMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() <= str2.length()) ? str1 : str2;
            int length = minStr.length();
            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

    public String[] getMaxSameString1(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer sBuffer = new StringBuffer();
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() <= str2.length()) ? str1 : str2;
            int length = minStr.length();
            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        sBuffer.append(subStr + ",");
                    }
                }
                //System.out.println(sBuffer);
                if (sBuffer.length() != 0) {
                    break;
                }
            }
            String[] spilt = sBuffer.toString().replaceAll(",$", "").split("\\,");
            return spilt;
        }
        return null;
    }

    @Test
    public void testGetMaxSameString() {
        String str1 = "abcwerthello1yulodef111111111";
        String str2 = "cvhello1bnmulodef222";
        String maxSameString = getMaxSameString(str1, str2);
        String[] maxSameString1 = getMaxSameString1(str1, str2);
        System.out.println(maxSameString);
        System.out.println(Arrays.toString(maxSameString1));
    }
}
