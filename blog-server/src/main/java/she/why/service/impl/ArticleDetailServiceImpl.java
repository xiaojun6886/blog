package she.why.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import she.why.entity.ArticleDetailEntity;
import she.why.mapper.ArticleDetailMapper;
import she.why.resultUtils.BaseResult;
import she.why.service.ArticleDetailService;


/**
 * Created by xiaojun on 2020/4/1.
 */
@Service
public class ArticleDetailServiceImpl implements ArticleDetailService {

    @Autowired
    private ArticleDetailMapper articleDetailMapper;

    @Override
    public ArticleDetailEntity getArticleDetail(String blogDetailId) {
        ArticleDetailEntity articleDetailEntity = articleDetailMapper.queryArticleDetail(blogDetailId);
        return articleDetailEntity;
    }
}
