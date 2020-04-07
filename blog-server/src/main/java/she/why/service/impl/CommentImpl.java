package she.why.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import she.why.entity.CommentDetailEntity;
import she.why.mapper.CommentMapper;
import she.why.service.CommentService;

@Service
public class CommentImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int insertMessage(CommentDetailEntity commentDetailEntity) {
      return   commentMapper.insertMessage(commentDetailEntity);
    }
}
