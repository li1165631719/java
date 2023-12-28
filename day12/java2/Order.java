package day12.java2;

/**
 * 体会四种不同的权限修饰
 */
public class Order {
    public int orderPublic;
    protected int orderProtected;
    int orderDefault;
    private int orderPrivate;

    private void methodPrivate() {

        orderPrivate = 1;
        orderDefault = 2;
        orderProtected = 3;
        orderPublic = 4;

    }

    void methodDefault() {
        orderPrivate = 1;
        orderDefault = 2;
        orderProtected = 3;
        orderPublic = 4;
    }

    protected void methodProtected() {

        orderPrivate = 1;
        orderDefault = 2;
        orderProtected = 3;
        orderPublic = 4;
    }

    public void methodPublic() {
        orderPrivate = 1;
        orderDefault = 2;
        orderProtected = 3;
        orderPublic = 4;
    }


}
