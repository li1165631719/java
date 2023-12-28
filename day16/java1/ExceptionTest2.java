package day16.java1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * try catch 真正解决了异常，使得程序继续进行下去了。而在几个递进的方法中，第一个方法出错后就没必要执行了，
 * 所以每个方法应用throws直接抛出，而在整个大方法中应用try-catch把异常处理掉
 */


/**
 * 异常处理的方式二：throws + 异常类型                             throws抛出异常但是并不解决异常，try-catch-finally是发现并解决掉异常
 *
 *1.“throws + 异常类型”写在方法的声明处。指明此方法执行时，可能会抛出异常类型
 *  一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足throws后异常
 *  类型时，就会被抛出。异常代码异常后续的代码，就不再执行！
 *
 *2.体会：try-catch-finally：真正的异常被处理掉了
 *     throws只是把异常抛给方法的调用者，并灭有把异常真正的处理掉
 *
 *3，开发中如何使用try-catch-finally还是使用throws?
 *  3.1如果父类中被重写的方法没有throws处理异常，则子类重写的方法也不能使用throws，意味着如果
 *     子类重写的方法有异常，必须使用try-catch-finally方式处理
 *  3.2执行方法a中，先后又调用了另外几个方法。这几个方法是递进关系执行的。我们建议这几个方法使用throw
 *     的方式进行处理。而执行的方法a可以考虑使用try-catch-finally方式处理。
 *
 *
 *
 */

public class ExceptionTest2 {
    public static void main(String[] args) {
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
        method3();
    }

    public static void method3() {
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method2() throws IOException {
        method1();
    }

    public static void method1() throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = null;
        File file = new File("hello1.txt");
        fileInputStream = new FileInputStream(file);

        int data = fileInputStream.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fileInputStream.read();
        }

        fileInputStream.close();

        System.out.println("hahahahahaha!");
    }
}
