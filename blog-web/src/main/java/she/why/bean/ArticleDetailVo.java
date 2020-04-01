package she.why.bean;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Timestamp;

/**
 * Created by xiaojun on 2020/4/1.
 */
@Data
public class ArticleDetailVo {

    private BigInteger id;          //主键
    private String blogDetailId;    //文章id
    private String title;           //标题
    private String content;           //内容
    private Timestamp releaseDate;  //发布时间
    private String editName;        //编辑者
    private BigInteger readNumber;  //阅读量
    private Timestamp createDate;   //创建时间
    private String createName;      //创建人
    private Timestamp updateDate;   //更新时间
    private String updateName;      //更新人

}
