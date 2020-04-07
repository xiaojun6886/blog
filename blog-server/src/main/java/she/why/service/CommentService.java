package she.why.service;


import she.why.entity.CommentDetailEntity;

/**
 * Created by wei 2020/4/7
 */
public interface CommentService {

    /**
     * 把留言版信息，插入留言表
     * @param message
     */
    int insertMessage(CommentDetailEntity commentDetailEntity);

}
