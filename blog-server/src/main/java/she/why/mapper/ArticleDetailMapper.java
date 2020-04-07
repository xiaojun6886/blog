package she.why.mapper;

import org.apache.ibatis.annotations.Param;
import she.why.entity.ArticleDetailEntity;
import she.why.entity.IndexDetailEntity;

/**
 * Created by xiaojun on 2020/4/1.
 */
public interface ArticleDetailMapper {

    IndexDetailEntity queryArticleDetail(@Param("blogDetailId") String blogDetailId,@Param("label") String label);

}
