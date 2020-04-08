package she.why.mapper;

import she.why.entity.BlogArticleEntity;

import java.util.List;

/**
 * Created by xiaojun on 2020/4/2.
 */
public interface BlogArticleMapper {

    List<BlogArticleEntity> queryIndexDetail();
}
