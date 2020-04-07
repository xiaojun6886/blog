package she.why.bean;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVo {

   private int id;
    private int message_id;
    private String message_text;
    private int user_id;
   private String user_name;
    private String intcreate_by;
    private String intcreate_name;
    private String message_status;
    private Date create_date;
    private Date update_date;
    private String intupdate_name;

}
