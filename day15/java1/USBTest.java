package day15.java1;

interface USB {
    //常量：定义长、宽、最大最小的传输速度等

    void start();

    void stop();

}

/**
 * 接口的使用
 * 1.接口的使用上也满足多态性
 * 2.接口，实际上就是定义了一种规范
 * 3.开发中，体会面向接口编程！
 */

public class USBTest {
    public static void main(String[] args) {

        Computer computer = new Computer();
        //1.创建了接口的非匿名实现类的非匿名对象
        Flash flash = new Flash();
        computer.transferData(flash);
        //2.创建了接口的非匿名实现类的匿名对象
        computer.transferData(new Printer());

        //3.创建了接口的匿名实现类的非匿名对象

        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("MP3开始工作");
            }

            @Override
            public void stop() {
                System.out.println("MP3停止工作");
            }
        };
        computer.transferData(phone);

        //4.创建了接口的匿名实现类的匿名对象
        computer.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("手机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("手机停止工作");
            }
        });
    }
}

class Computer {
    public void transferData(USB usb) {
        usb.start();
        System.out.println("具体的传输细节");

        usb.stop();
    }
}

class Flash implements USB {

    @Override
    public void start() {
        System.out.println("u盘开启工作");
    }

    @Override
    public void stop() {
        System.out.println("U盘结束工作");
    }
}

class Printer implements USB {

    @Override
    public void start() {
        System.out.println("打印机开启工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }
}