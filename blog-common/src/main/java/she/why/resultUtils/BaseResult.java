package she.why.resultUtils;

/**
 *      公共返回结果集
 *     @param code
 *      @param msg
 *     @param  data
 */
public interface BaseResult<T> {
    String getCode();

    void setCode(String var1);

    void setMsg(String var1);

    String getMsg();

    void setModel(T var1);

    T getModel();

}
