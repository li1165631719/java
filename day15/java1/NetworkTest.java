package day15.java1;

interface Network {
    public void browse();
}

/**
 * �ӿڵ�Ӧ�ã�����ģʽ
 */
public class NetworkTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);

        proxyServer.browse();

    }
}

//��������
class Server implements Network {
    @Override
    public void browse() {
        System.out.println("��ʵ�ķ�������������");
    }
}

//������
class ProxyServer implements Network {

    private Network work;

    public ProxyServer(Network work) {
        this.work = work;
    }

    public void check() {
        System.out.println("����֮ǰ�ļ�鹤��");
    }


    @Override
    public void browse() {

        check();
        work.browse();
    }
}
