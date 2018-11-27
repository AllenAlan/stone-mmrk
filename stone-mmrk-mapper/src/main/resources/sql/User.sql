-- auto Generated on 2018-10-07
-- DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`(
	`id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userName',
	`password` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'password',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '`t_user`';
