package she.why.resultUtils;

import she.why.constantUtils.Constants;

import java.util.HashMap;
import java.util.Map;


public class BaseResult {

    public static  Map<String, Object> setResut(Integer code, String msg, Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.HTTP_CODE_NAME, code);
        result.put(Constants.HTTP_SMSG_NAME, msg);
        if (data != null)
            result.put(Constants.HTTP_DATA_NAME, data);
        return result;
    }

}
