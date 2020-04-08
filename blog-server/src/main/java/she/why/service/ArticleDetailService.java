package she.why.service;

import she.why.entity.BlogArticleEntity;

/**
 * Created by xiaojun on 2020/4/1.
 */
public interface ArticleDetailService {

    BlogArticleEntity getArticleDetail(String blogDetailId);
}
