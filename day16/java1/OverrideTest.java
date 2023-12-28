package day16.java1;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ������д����֮һ��
 * ������д�ķ����׳����쳣�����ڸ�����д�ķ����׳��쳣����     (����û�����쳣������Ҳһ���������쳣)
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