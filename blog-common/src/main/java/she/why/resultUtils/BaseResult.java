package she.why.resultUtils;

import she.why.constantUtils.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 *      公共返回结果集
 *     @param code
 *      @param msg
 *     @param  data
 */
public class BaseResult {

    public static  Map<String, Object> setResut(Integer code, String msg, Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.HTTP_CODE_NAME, code);
        result.put(Constants.HTTP_SMSG_NAME, msg);
        if (data != null)
            result.put(Constants.HTTP_DATA_NAME, data);
        return result;
    }

    /**
     *  返回成功
     *
     * @return
     */
    public static Map<String,Object> setResultSuccess(){
        return setResut(Constants.HTTP_200_CODE,Constants.HTTP_SUCCESS_NAME,null);
    }

    /**
     * 返回成功
     * @param msg  成功的自定义信息
     */

    public static Map<String,Object> setResultSuccess(String msg){
        return setResut(Constants.HTTP_200_CODE,msg,null);
    }

    /**
     * 返回成功
     * @param data  成功的具体参数
     */

    public  static Map<String,Object> setResultSuccessData(Object data){
        return setResut(Constants.HTTP_200_CODE,Constants.HTTP_SUCCESS_NAME,data);
    }

    /**
     * 放回失败状态 自定义400
     * @return
     */
    public static Map<String,Object> setResultError(){
        return setResut(Constants.HTTP_400_CODE,Constants.HTTP_ERROR_NAME,null);
    }
    /**
     * 放回失败信息 自定义 msg
     * @return
     */
    public static Map<String,Object> setResultParamError(String msg){
        return setResut(Constants.HTTP_400_CODE,msg,null);
    }


}
