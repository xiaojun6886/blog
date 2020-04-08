package she.why.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import she.why.entity.BlogArticleEntity;
import she.why.mapper.ArticleDetailMapper;
import she.why.service.ArticleDetailService;


/**
 * Created by xiaojun on 2020/4/1.
 */
@Service
public class ArticleDetailServiceImpl implements ArticleDetailService {

    @Autowired
    private ArticleDetailMapper articleDetailMapper;

    @Override
    public BlogArticleEntity getArticleDetail(String blogDetailId, String label) {
         return articleDetailMapper.queryArticleDetail(blogDetailId,label);
    }
}
