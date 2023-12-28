package day17.com.atguigu.team.service;

import java.io.Serializable;

/**
 * @author
 * @version v1.0
 * @Description 自定义异常类
 * @data 2023年2月12日下午16：28
 */
public class TeamException extends Exception implements Serializable {
    private static final long serialVersionUID = -3245373345463790665L;//两端交互识别唯一的类

    public TeamException() {
        super();
    }

    public TeamException(String message) {
        super(message);
    }


}
