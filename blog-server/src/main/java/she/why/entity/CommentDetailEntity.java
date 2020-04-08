package she.why.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDetailEntity {
    private int id;
    private int message_id;
    private String messageText;
    private int user_id;
    private String user_name;
    private String intcreate_by;
    private String intcreate_name;
    private String message_status;
    private Date createDate;
    private Date updateDate;
    private String intupdate_name;

}
