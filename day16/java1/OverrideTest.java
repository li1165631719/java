package day16.java1;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 方法重写规则之一：
 * 子类重写的方法抛出的异常不大于父类重写的方法抛出异常类型     (父类没有抛异常，子类也一定不能抛异常)
 */
public class OverrideTest {

    public static void main(String[] args) {
        OverrideTest test = new OverrideTest();
        test.display(new subClass());
    }

    public void display(SuperClass s) {
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SuperClass {
    public void method() throws IOException {

    }
}

class subClass extends SuperClass {
    public void method() throws FileNotFoundException {

    }
}