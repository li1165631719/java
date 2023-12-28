package day17.com.atguigu.team.domain;

public class NoteBook implements Equipment {
    private String model;//����������
    private String price;//�����ļ۸�

    public NoteBook() {
        super();
    }

    public NoteBook(String model, String price) {
        super();
        this.price = price;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
