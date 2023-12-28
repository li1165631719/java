package day16.java2;

/**
 * 如何自定义异常类？
 * 1.继承于现有的异常结构：RuntimeException  、 Exception
 * 2.提供全局常量，serialVersionUID
 * 3.提供重载的构造器
 */
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 7172910833864283167L;//类的唯一标识

    public MyException() {

    }

    public MyException(String message) {

        super(message);
    }

}
