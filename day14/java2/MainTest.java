package day14.java2;

/**
 * main()方法的使用说明
 * 1.main()方法作为程序的入口
 * 2.main()方法也是一个普通的静态方法
 * 3.main()方法也可以作为我们与控制台交互的方式。（之前，使用Scanner）
 */

public class MainTest {
    public static void main(String[] args) {//入口
        Main.main(new String[100]);
        //show();不行是因为静态里只可以调用静态的方法，在加载类的时候就需要加载调用了
        //解决方法一：将show改成static或者创建一个对象，这样就创建了整个类对象以及方法。就可以去用实例变量去调用非静态方法了。
        MainTest test = new MainTest();
        test.show();

    }

    public void show() {

    }
}

class Main {
    public static void main(String[] args) {

        args = new String[100];
        for (int i = 0; i < args.length; i++) {
            args[i] = "args_" + i;
            System.out.println(args[i]);
        }

    }

}