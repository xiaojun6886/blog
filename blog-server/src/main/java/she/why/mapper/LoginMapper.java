package she.why.mapper;

import org.apache.ibatis.annotations.Param;
import she.why.entity.UserBlogEntity;

import java.util.Map;

/**
 * Created by xiaojun on 2020/4/10.
 */
public interface LoginMapper {

    int insertRegisterBlog(UserBlogEntity userBlogEntity);

    int selectUser(@Param("fullName") String fullName);

    UserBlogEntity queryUserInfo(@Param("map") Map<String,String> map);


}
