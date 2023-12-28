package day16.java2;

/**
 * throws
 * 1.用在方法声明后面，跟的是异常类名
 * 2.表示抛出异常，由该方法的调用者来处理
 * 3.表示出现异常的一种可能性，并不一定会发生这些异常
 * <p>
 * throw
 * 1.用在方法体内，跟的是异常对象名
 * 2.表示抛出异常，由方法体内的语句处理
 * 3.执行 throw 一定抛出了某种异常
 * <p>
 * <p>
 * <p>
 * throw一定抛出异常，throws不一定抛出异常
 */
public class StudentTest {

    public static void main(String[] args) {
        Student s = new Student();
        try {
            s.regist(-1001);
            System.out.println(s);
        } catch (Exception e) {
            //           e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}

class Student {
    private int id;

    public void regist(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
//            System.out.println("您输入的数据非法！");
            //手动抛出异常对象
//            throw new RuntimeException("您输入的数据非法！");
//            throw new Exception("您输入的数据非法！");
            throw new MyException("不能输入负数！");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
