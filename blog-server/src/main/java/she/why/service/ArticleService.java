package she.why.service;

import she.why.entity.BlogArticleEntity;

import java.util.List;

/**
 * Created by xiaojun on 2020/4/8.
 */
public interface ArticleService {

    List<BlogArticleEntity> queryArticleList(String label);
}
