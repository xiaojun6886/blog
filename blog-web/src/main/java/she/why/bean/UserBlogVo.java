package she.why.bean;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by xiaojun on 2020/4/9.
 */
@Data
public class UserBlogVo {

    private BigInteger id;          //主键
    private String userId;          //用户id
    private String userName;        //用户名
    private String password;        //密码
    private String email;           //邮箱
    private String phoneNum;        //手机号
    private Timestamp createDate;   //创建时间
    private Timestamp updateDate;   //更新时间
    private String updateName;      //更新人

}
