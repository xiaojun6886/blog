package she.why.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import she.why.entity.BlogArticleEntity;
import she.why.mapper.BlogArticleMapper;
import she.why.service.BlogArticleService;
import she.why.utils.ElasticSerachConfig;

import java.util.List;

/**
 * Created by xiaojun on 2020/4/2.
 */
@Service
@Slf4j
public class BlogArticleServiceImpl implements BlogArticleService {

    @Autowired
    private BlogArticleMapper blogArticleMapper;

    @Autowired
    private ElasticSerachConfig elasticSerachConfig;

    @Override
    public List<BlogArticleEntity> getIndexDetailEntity(String label) {
        return blogArticleMapper.queryIndexDetail(label);
    }

    @Override
    public List<String> getSearchHome(String searchHome) {
        try {
            TransportClient client = elasticSerachConfig.esClint();
            if(client==null)
            {
//                client =ESUtils.getTransportClient();
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(),ex);
        }

        return null;
    }
}
