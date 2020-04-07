package she.why.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by wei on 2020/4/7
 */
public interface CommentMapper {
     int insertMessage(@Param("message") String message);
}
