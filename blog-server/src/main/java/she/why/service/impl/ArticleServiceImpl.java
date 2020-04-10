package she.why.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import she.why.entity.BlogArticleEntity;
import she.why.mapper.BlogArticleMapper;
import she.why.service.ArticleService;

import java.util.List;

/**
 * Created by xiaojun on 2020/4/8.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private BlogArticleMapper blogArticleMapper;
    @Override
    public List<BlogArticleEntity> queryArticleList(String label) {
        List<BlogArticleEntity> blogArticleEntities = blogArticleMapper.queryIndexDetail(label);
        return blogArticleEntities;
    }
}
