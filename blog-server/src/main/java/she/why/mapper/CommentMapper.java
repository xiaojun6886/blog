package she.why.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import she.why.entity.CommentDetailEntity;

/**
 * Created by wei on 2020/4/7
 */
public interface CommentMapper {
     int insertMessage(@Param("commentDetailEntity") CommentDetailEntity commentDetailEntity);
}
