
#in MAC
brew install mysql

mysql.server start

mysql -u root -p

create database userTest;

use userTest;

--`userId` int NOT NULL AUTO_INCREMENT,

CREATE TABLE `user` (
  `user_id` varchar(36) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `real_name` varchar(100) NOT NULL,
  `password` varchar(36) NOT NULL,
  `register_time` datetime NOT NULL,
  `gender` varchar(2) ,
  `birthday` date ,
  `head_image` varchar(100) ,
  `user_status` varchar(2) NOT NULL,
  `create_by` varchar(100) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(100) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--唯一索引

drop table student;

INSERT INTO `user_test` VALUES ('01', 'Rock01', '33', 'JinzhongRoad' );
delete from student where id='01';
UPDATE student t set age=7 where t.id in ('01','2') and t.name='1';