package she.why.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import she.why.mapper.TaskMapper;
import she.why.service.TaskService;

/**
 * Created by xiaojun on 2020/4/8.
 */

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public int updateReadNumByBlogDetailId(String blogDetailId, String readNum) {
        return taskMapper.updateRedisReadNumToBlog(blogDetailId,readNum);
    }
}
