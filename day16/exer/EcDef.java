package day16.exer;

import java.io.Serializable;

//�Զ����쳣��
public class EcDef extends Exception implements Serializable {

    private static final long serialVersionUID = -3222302066920782670L;

    public EcDef() {

    }

    public EcDef(String msg) {
        super(msg);
    }
}
