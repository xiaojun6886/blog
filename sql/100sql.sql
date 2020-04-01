
/**
*文章详情表
 */
create table `article_detail` (
	`id` bigint  NOT NULL AUTO_INCREMENT,
	`blog_detail_id` varchar(200) comment "标题id",
	`title` varchar(200) comment "标题",
	`content` blob comment "文章内容",
	`release_date` timestamp comment "发布时间",
	`edit_name` varchar(200) comment "编辑",
	`read_number` bigint comment "阅读数",
	`create_date` timestamp comment "创建时间",
	`create_name` varchar(200) comment "创建人",
	`update_date` timestamp comment "更新时间" ,
	`update_name` varchar(200) comment "更新人",
	 PRIMARY KEY (id)
)ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin;
