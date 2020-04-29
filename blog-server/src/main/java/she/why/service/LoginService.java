package she.why.service;

import she.why.resultUtils.BaseResult;

import java.util.Map;

/**
 * Created by xiaojun on 2020/4/10.
 */
public interface LoginService {

    int registerBlog(Map<String,String> params);

    int queryUser(String fullName);

    BaseResult loginUser(String userName, String password);

}
