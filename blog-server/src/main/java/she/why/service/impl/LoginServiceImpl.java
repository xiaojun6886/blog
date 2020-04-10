package she.why.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import she.why.entity.UserBlogEntity;
import she.why.mapper.LoginMapper;
import she.why.service.LoginService;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * Created by xiaojun on 2020/4/10.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public int registerBlog(UserBlogEntity userBlogEntity) {
        if (userBlogEntity != null) {
            userBlogEntity.setUserId("PS"+ UUID.randomUUID());
            userBlogEntity.setCreateDate(new Date());
            userBlogEntity.setUpdateDate(new Date());
        }
        return loginMapper.insertRegisterBlog(userBlogEntity);
    }
}
