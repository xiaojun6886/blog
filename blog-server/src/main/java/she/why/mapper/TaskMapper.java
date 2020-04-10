package she.why.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by xiaojun on 2020/4/8.
 */
public interface TaskMapper {

    int updateRedisReadNumToBlog(@Param("blogDetailId") String blogDetailId,@Param("readNum") String readNum);

}
