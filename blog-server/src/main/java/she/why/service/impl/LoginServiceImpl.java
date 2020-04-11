package she.why.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import she.why.entity.UserBlogEntity;
import she.why.mapper.LoginMapper;
import she.why.service.LoginService;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xiaojun on 2020/4/10.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public int registerBlog(Map<String,String> params) {
            UserBlogEntity userBlogEntity = new UserBlogEntity();
            userBlogEntity.setUserName(StringUtils.isEmpty(params.get("fullName")) ? "" : params.get("fullName"));
            userBlogEntity.setEmail(StringUtils.isEmpty(params.get("email")) ? "" : params.get("email"));
            userBlogEntity.setPhoneNum(StringUtils.isEmpty(params.get("phoneNum")) ? "" : params.get("phoneNum"));
            userBlogEntity.setPassword(StringUtils.isEmpty(params.get("password")) ? "" : params.get("password"));
            userBlogEntity.setUserId(String.valueOf(UUID.randomUUID()));
            userBlogEntity.setCreateDate(new Date());
            userBlogEntity.setUpdateDate(new Date());
        return loginMapper.insertRegisterBlog(userBlogEntity);
    }

    @Override
    public int queryUser(String fullName) {
       return loginMapper.selectUser(fullName);
    }

    @Override
    public int loginUser(String userName, String password) {
        return loginMapper.queryUserInfo(userName,password);
    }
}
