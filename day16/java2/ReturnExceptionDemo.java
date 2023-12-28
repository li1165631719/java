package day16.java2;

//有异常后直接执行finally方法，然后处理异常
public class ReturnExceptionDemo {
    public static void methodA() {
        try {
            System.out.println("进入方法A");//先执行①
            throw new RuntimeException("制造异常");

        } finally {
            System.out.println("用A方法的finally");//在执行②
        }
    }

    public static void methodB() {
        try {
            System.out.println("进入方法B");
            return;
        } finally {
            System.out.println("用B方法的finally");
        }
    }

    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());//再执行③处理异常
        }
        methodB();
    }
}
