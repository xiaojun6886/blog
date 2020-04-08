package she.why.mapper;

import org.apache.ibatis.annotations.Param;
import she.why.entity.BlogArticleEntity;

import java.util.List;

/**
 * Created by xiaojun on 2020/4/2.
 */
public interface BlogArticleMapper {

    List<BlogArticleEntity> queryIndexDetail(@Param("label") String label);
}
