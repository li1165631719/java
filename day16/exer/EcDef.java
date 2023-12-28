package day16.exer;

import java.io.Serializable;

//自定义异常类
public class EcDef extends Exception implements Serializable {

    private static final long serialVersionUID = -3222302066920782670L;

    public EcDef() {

    }

    public EcDef(String msg) {
        super(msg);
    }
}
