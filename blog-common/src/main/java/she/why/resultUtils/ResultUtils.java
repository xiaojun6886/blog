package she.why.resultUtils;

public class ResultUtils {


    public static BaseResult success(){
        BaseResult result = new BaseResultMsg();
        result.setCode("200");
        result.setMsg("成功");
        return result;
    }

    public static BaseResult success(Object data){
        BaseResult result = new BaseResultMsg();
        result.setCode("200");
        result.setMsg("成功");
        result.setModel(data);
        return result;
    }

    public static BaseResult error(){
        BaseResult result = new BaseResultMsg();
        result.setCode("500");
        result.setMsg("失败");
        return result;
    }

    public static BaseResult error(Object data){
        BaseResult result = new BaseResultMsg();
        result.setCode("500");
        result.setMsg("失败");
        result.setModel(data);
        return result;
    }


}
