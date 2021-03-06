/**
  * 文章表
 */
create table `blog_article` (
 `id` bigint  NOT NULL AUTO_INCREMENT,
 `blog_detail_id` varchar(200) comment "详情id",
 `user_id` varchar(200) comment "用户id",
 `user_name` varchar(200) comment "用户名",
 `title` varchar(200) comment "标题",
 `label` varchar(200) comment "标签",
 `article_summary` blob comment "文章摘要",
 `content` blob comment "文章内容",
 `status` varchar(200) comment "文章状态 0 正常 1 删除",
 `read_number` bigint comment "阅读数",
 `release_date` timestamp comment "发布时间",
 `edit_name` varchar comment "编辑者",
 `create_date` timestamp comment "创建时间",
 `create_name` varchar(200) comment "创建人",
 `update_date` timestamp comment "更新时间" ,
 `update_name` varchar(200) comment "更新人",
  PRIMARY KEY (id)
)ENGINE = INNODB
 DEFAULT CHARSET = utf8mb4
 COLLATE = utf8mb4_bin;




/**
  * 留言版
 */
create table `message_board_detail` (
 `id` bigint  NOT NULL AUTO_INCREMENT,
 `message_id` int(20) comment "留言文本id",
 `message_text` varchar(200) comment "留言文本",
 `user_id` int (20) comment "用户id",
 `user_name` varchar(200) comment "用户名",
 `create_by` int(20) comment "创建人id",
 `create_name` varchar(200) comment "创建人",
 `message_status` varchar(200) comment "留言状态 0 正常 1 删除",
 `create_date` timestamp comment "创建时间",
 `update_date` timestamp comment "更新时间" ,
 `update_name` varchar(200) comment "更新人",
  PRIMARY KEY (id)
)ENGINE = INNODB
 DEFAULT CHARSET = utf8mb4
 COLLATE = utf8mb4_bin;

/**
  * 用户信息表
 */
create table `user_blog` (
 `id` bigint  NOT NULL AUTO_INCREMENT,
 `user_id` varchar (100) comment "用户id",
 `user_name` varchar(200) comment "用户名",
 `password` varchar(200) comment "密码",
 `email` varchar(200) comment "邮箱",
 `phone_num` varchar(200) comment "手机号",
 `create_date` timestamp comment "创建时间",
 `update_date` timestamp comment "更新时间" ,
 `update_name` varchar(200) comment "更新人",
  PRIMARY KEY (id)
)ENGINE = INNODB
 DEFAULT CHARSET = utf8mb4
 COLLATE = utf8mb4_bin;