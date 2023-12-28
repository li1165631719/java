package javahigh.day03.exer;

/**
 * 一道面试题
 *
 * @Author lizhihao
 * @Date 2023/11/20 19:52
 * @PackageName:javahigh.day03.exer
 * @ClassName: StringTets
 * @Description: TODO
 * @Version 1.0
 */
public class StringTest {

    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best


    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
}
