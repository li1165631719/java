package day17.com.atguigu.team.service;

import java.io.Serializable;

/**
 * @author
 * @version v1.0
 * @Description �Զ����쳣��
 * @data 2023��2��12������16��28
 */
public class TeamException extends Exception implements Serializable {
    private static final long serialVersionUID = -3245373345463790665L;//���˽���ʶ��Ψһ����

    public TeamException() {
        super();
    }

    public TeamException(String message) {
        super(message);
    }


}
