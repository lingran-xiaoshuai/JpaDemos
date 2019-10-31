CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学生姓名',
  `student_age` int(0) DEFAULT NULL COMMENT '学生年龄',
  `student_sex` char(0) DEFAULT NULL COMMENT '学生性别(1男,2女)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- 数据库名称: jpatest
-- 账号:root
-- 密码:123456