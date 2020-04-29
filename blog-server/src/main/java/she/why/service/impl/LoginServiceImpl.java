package she.why.service.impl;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import she.why.entity.UserBlogEntity;
import she.why.mapper.LoginMapper;
import she.why.resultUtils.BaseResult;
import she.why.resultUtils.BaseResultMsg;
import she.why.resultUtils.ResultUtils;
import she.why.service.LoginService;
import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
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
            userBlogEntity.setPassword(StringUtils.isEmpty(params.get("password")) ? "" : md5(params.get("password")));
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
    public BaseResult loginUser(String userName, String password) {
        BaseResult baseResult = new BaseResultMsg();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            baseResult.setCode("500");
            baseResult.setMsg("用户名和密码不能为空！");
           return ResultUtils.error(baseResult);
        }
        String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String ph = "^[1][34578]\\d{9}$";
        Map<String,String> map = new HashMap<>();
        if (userName.matches(em)) {
            map.put("email",userName);
        } else if (userName.matches(ph)) {
            map.put("phoneNum",userName);
        }else {
            map.put("userName",userName);
        }
        UserBlogEntity userBlogEntity = loginMapper.queryUserInfo(map);
        if (userBlogEntity == null) {
            baseResult.setCode("500");
            baseResult.setMsg("用户名错误！");
            return ResultUtils.error(baseResult);
        }
       if (!md5(password).equals(userBlogEntity.getPassword())) {
           baseResult.setCode("500");
           baseResult.setMsg("密码错误！");
           return ResultUtils.error(baseResult);
       }
        return ResultUtils.success(userBlogEntity);
    }

    /**
     *  对输入的密码进行加密
     */
    public static String md5(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");//利用哈希算法，MD5
            //面向字节处理，所以可以处理字节的东西，如图片，压缩包。。
            byte[] input = password.getBytes();
            byte[] output = md.digest(input);
            //将md5处理后的output结果利用Base64转成原有的字符串,不会乱码
            String str = Base64.encodeBase64String(output);
//			String str = new String(output); //原有转换
            return str;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("密码加密失败");
            return "";
        }
    }
}