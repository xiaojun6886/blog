/**
  * 主页表
 */
create table `index_detail` (
	`id` bigint  NOT NULL AUTO_INCREMENT,
	`blog_detail_id` varchar(200) comment "详情id",
	`title` varchar(200) comment "标题",
	`label` varchar(200) comment "标签",
	`articleZhai` blob comment "文章摘要",
	`content` blob comment "文章内容",
	`status` varchar(200) comment "文章状态 0 正常 1 删除",
	`read_number` bigint comment "阅读数",
	`release_date` timestamp comment "发布时间",
	`create_date` timestamp comment "创建时间",
	`create_name` varchar(200) comment "创建人",
	`update_date` timestamp comment "更新时间" ,
	`update_name` varchar(200) comment "更新人",
	 PRIMARY KEY (id)
)ENGINE = INNODB
 DEFAULT CHARSET = utf8mb4
 COLLATE = utf8mb4_bin;