package she.why.service;

import java.util.Map;

/**
 * Created by xiaojun on 2020/4/10.
 */
public interface LoginService {

    int registerBlog(Map<String,String> params);

    int queryUser(String fullName);

}
