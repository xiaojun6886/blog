package she.why.task;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import she.why.constantUtils.Constants;
import she.why.service.TaskService;

import java.util.Set;

/**
 * Created by xiaojun on 2020/4/8.
 */
@Slf4j
@Component
public class UpdateRedisReadNumToBlogTask {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private TaskService taskService;

    //每10秒更新一次
    @Scheduled(cron="0/10 * *  * * ? ")
    public void testTask(){
        log.info("开始执行更新访问量任务...");
        Set<String> keys = redisTemplate.keys(Constants.REDIS_INCR_PREFIX + "*");
        int count = 0;
        for (String data : keys) {
            String readNum = redisTemplate.opsForValue().get(data);
            String articleId = StringUtils.substringAfter(data, Constants.REDIS_INCR_PREFIX);
           int i = taskService.updateReadNumByBlogDetailId(articleId, readNum);
           if (i>0){
               count++;
           }
        }
        log.info("从redis更新文章访问量总条数：{}",count);
    }
}
