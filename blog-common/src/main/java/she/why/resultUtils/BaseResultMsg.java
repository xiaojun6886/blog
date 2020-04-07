package she.why.resultUtils;

public class BaseResultMsg<T> implements BaseResult<T> {
    private String code;
    private String msg;
    private T model;


    public BaseResultMsg() {
    }

    public BaseResultMsg(String code, String msg, T model) {
        this.code = code;
        this.msg = msg;
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
