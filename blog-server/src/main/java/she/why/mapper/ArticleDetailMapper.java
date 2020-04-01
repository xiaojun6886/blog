package she.why.mapper;

import org.apache.ibatis.annotations.Param;
import she.why.entity.ArticleDetailEntity;

/**
 * Created by xiaojun on 2020/4/1.
 */
public interface ArticleDetailMapper {

    ArticleDetailEntity queryArticleDetail(@Param("blogDetailId") String blogDetailId);

}
