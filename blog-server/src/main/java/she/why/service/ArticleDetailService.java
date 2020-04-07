package she.why.service;

import she.why.entity.IndexDetailEntity;

/**
 * Created by xiaojun on 2020/4/1.
 */
public interface ArticleDetailService {

    IndexDetailEntity getArticleDetail(String blogDetailId,String label);
}
