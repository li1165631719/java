package day15.java1;

interface USB {
    //���������峤���������С�Ĵ����ٶȵ�

    void start();

    void stop();

}

/**
 * �ӿڵ�ʹ��
 * 1.�ӿڵ�ʹ����Ҳ�����̬��
 * 2.�ӿڣ�ʵ���Ͼ��Ƕ�����һ�ֹ淶
 * 3.�����У��������ӿڱ�̣�
 */

public class USBTest {
    public static void main(String[] args) {

        Computer computer = new Computer();
        //1.�����˽ӿڵķ�����ʵ����ķ���������
        Flash flash = new Flash();
        computer.transferData(flash);
        //2.�����˽ӿڵķ�����ʵ�������������
        computer.transferData(new Printer());

        //3.�����˽ӿڵ�����ʵ����ķ���������

        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("MP3��ʼ����");
            }

            @Override
            public void stop() {
                System.out.println("MP3ֹͣ����");
            }
        };
        computer.transferData(phone);

        //4.�����˽ӿڵ�����ʵ�������������
        computer.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("�ֻ���ʼ����");
            }

            @Override
            public void stop() {
                System.out.println("�ֻ�ֹͣ����");
            }
        });
    }
}

class Computer {
    public void transferData(USB usb) {
        usb.start();
        System.out.println("����Ĵ���ϸ��");

        usb.stop();
    }
}

class Flash implements USB {

    @Override
    public void start() {
        System.out.println("u�̿�������");
    }

    @Override
    public void stop() {
        System.out.println("U�̽�������");
    }
}

class Printer implements USB {

    @Override
    public void start() {
        System.out.println("��ӡ����������");
    }

    @Override
    public void stop() {
        System.out.println("��ӡ����������");
    }
}