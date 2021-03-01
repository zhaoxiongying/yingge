CREATE SCHEMA `yingshao_qa` ;

CREATE TABLE `answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `answer_content` varchar(1000) DEFAULT NULL COMMENT '答案内容',
  `problem_id` bigint(20) DEFAULT NULL COMMENT '问题编号',
  `respondent` varchar(45) DEFAULT NULL COMMENT '回答者',
  `answer_time` varchar(45) DEFAULT NULL COMMENT '回答时间',
  `count` varchar(45) DEFAULT NULL COMMENT '提问者评论好评次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='答案表'

CREATE TABLE `problem_parent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `answer_content` varchar(45) NOT NULL COMMENT '问题分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题父类表'

CREATE TABLE `problem_subclass` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `classification_name` varchar(45) DEFAULT NULL COMMENT '分类名称',
  `subclass_name` varchar(45) DEFAULT NULL COMMENT '子类名称',
  `respondent` bigint(20) DEFAULT NULL COMMENT '父类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题子类表'

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `is_delete` tinyint(4) NOT NULL COMMENT '是否删除 1 删除 0未删除',
  `role_code` varchar(45) NOT NULL COMMENT '角色字母编号',
  `role_name` varchar(45) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(45) DEFAULT NULL COMMENT '描述',
  `role_status` tinyint(4) NOT NULL COMMENT '状态 1、正常 0、禁用',
  `is_admin` tinyint(4) NOT NULL COMMENT '是否是超级管理员角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表'

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `is_admin` tinyint(4) NOT NULL COMMENT '是否是超级管理员',
  `login_name` varchar(100) NOT NULL COMMENT '登录账号',
  `password` varchar(45) NOT NULL COMMENT '密码',
  `secret_key` varchar(45) DEFAULT NULL COMMENT '加密秘钥',
  `mobile` varchar(45) DEFAULT NULL COMMENT '手机号',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `sex` varchar(45) DEFAULT NULL COMMENT '性别',
  `user_status` tinyint(4) NOT NULL COMMENT '状态: 1 正常 0禁用',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `is_delete` tinyint(4) NOT NULL COMMENT '是否删除 1 删除 0未删除',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `modifier_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表'

CREATE TABLE `user_role_ref` (
  `id` bigint(20) NOT NULL COMMENT '编号',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `is_delete` tinyint(4) NOT NULL COMMENT '是否删除 1 删除 0未删除',
  `creator_id` bigint(20) NOT NULL COMMENT '创建人',
  `modifier_id` bigint(20) NOT NULL COMMENT '修改人',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表'