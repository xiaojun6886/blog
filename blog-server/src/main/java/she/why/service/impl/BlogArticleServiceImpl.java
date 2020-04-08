package she.why.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import she.why.entity.BlogArticleEntity;
import she.why.mapper.BlogArticleMapper;
import she.why.service.BlogArticleService;

import java.util.List;

/**
 * Created by xiaojun on 2020/4/2.
 */
@Service
public class BlogArticleServiceImpl implements BlogArticleService {

    @Autowired
    private BlogArticleMapper blogArticleMapper;

    @Override
    public List<BlogArticleEntity> getIndexDetailEntity() {
        return blogArticleMapper.queryIndexDetail();
    }
}
