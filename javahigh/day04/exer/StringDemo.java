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
     * 2����һ���ַ������з�ת�����ַ�����ָ�����ֽ��з�ת������"abcdefg"��תΪ"abfedcg"
     * <p>
     * ��ʽһ��ת��Ϊchar[]
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

    //��ʽ����ʹ��String��ƴ��
    public String reverse1(String str, int startIndex, int endIndex) {
        if (null != str) {
            //��һ����
            String reverseStr = str.substring(0, startIndex);
            //�ڶ�����
            for (int i = endIndex; i >= startIndex; i--) {//����ƴ��
                reverseStr += str.charAt(i);
            }
            //��������
            reverseStr += str.substring(endIndex + 1);
            return reverseStr;
        }
        return null;
    }

    //��ʽ����ʹ��StringBuffer/StringBuilder�滻String
    public String reverse2(String str, int startIndex, int endIndex) {
        if (null != str) {
            StringBuilder builder = new StringBuilder(str.length());
            //��һ����
            builder.append(str.substring(0, startIndex));
            //�ڶ�����
            for (int i = endIndex; i >= startIndex; i--) {//����ƴ��
                builder.append(str.charAt(i));
            }
            //��������
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
