package she.why.mapper;

import org.apache.ibatis.annotations.Param;
import she.why.entity.BlogArticleEntity;

/**
 * Created by xiaojun on 2020/4/1.
 */
public interface ArticleDetailMapper {

    BlogArticleEntity queryArticleDetail(@Param("blogDetailId") String blogDetailId);

    int updateReadNumToBlogArticle(@Param("blogDetailId") String blogDetailId,@Param("readNumber") String readNumber);


}
