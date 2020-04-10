package she.why.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Service;
import she.why.constantUtils.Constants;
import she.why.entity.BlogArticleEntity;
import she.why.mapper.ArticleDetailMapper;
import she.why.service.ArticleDetailService;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;


/**
 * Created by xiaojun on 2020/4/1.
 */

@Slf4j
@Service
public class ArticleDetailServiceImpl implements ArticleDetailService {

    @Autowired
    private ArticleDetailMapper articleDetailMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public BlogArticleEntity getArticleDetail(String blogDetailId) {
        RedisAtomicInteger redisAtomicInteger = new RedisAtomicInteger(Constants.REDIS_INCR_PREFIX + blogDetailId,redisTemplate.getConnectionFactory());
        int count = redisAtomicInteger.incrementAndGet();
        BlogArticleEntity blogArticleEntity = articleDetailMapper.queryArticleDetail(blogDetailId);
        BigInteger readNumber = blogArticleEntity.getReadNumber();
        if (count >= 10) {
            int readNum = count + Integer.valueOf(String.valueOf(readNumber));
            int i = articleDetailMapper.updateReadNumToBlogArticle(blogDetailId, String.valueOf(readNum));
            if (i==1) {
                redisTemplate.delete(Constants.REDIS_INCR_PREFIX + blogDetailId);
                blogArticleEntity.setReadNumber(BigInteger.valueOf(readNum));
            }
            log.info("更新访问量数据条数：{}, blogDetailId={},readNumber={}",i,blogDetailId,readNum);
        }
        return blogArticleEntity;
    }
}
