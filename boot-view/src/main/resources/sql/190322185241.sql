/*
MySQL Backup
Source Server Version: 5.7.23
Source Database: manage
Date: 2019/3/22 18:52:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `cfg_configuration`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_configuration`;
CREATE TABLE `cfg_configuration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `config_no` varchar(100) NOT NULL COMMENT '参数编号',
  `descr_c` varchar(300) NOT NULL COMMENT '参数名称',
  `value` varchar(1000) DEFAULT NULL COMMENT '参数字符值',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创立日期',
  `create_by` varchar(60) DEFAULT NULL COMMENT '修改人ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改日期',
  `update_by` varchar(60) DEFAULT NULL COMMENT '修改人ID',
  `version` int(11) NOT NULL DEFAULT '0',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='系统参数配置';

-- ----------------------------
--  Table structure for `cfg_out_goods`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_out_goods`;
CREATE TABLE `cfg_out_goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `is_mark_goods` tinyint(4) DEFAULT NULL COMMENT '是否指定商品(0 :否 1：是)',
  `platform_code` varchar(50) DEFAULT NULL COMMENT '电商平台编码',
  `platform_name` varchar(100) DEFAULT NULL COMMENT '电商平台名称',
  `merchant_code` varchar(50) DEFAULT NULL COMMENT '电商企业编码',
  `merchant_name` varchar(100) DEFAULT NULL COMMENT '电商企业名称',
  `merchant_goods_code` varchar(50) DEFAULT NULL COMMENT '企业商品编码',
  `merchant_goods_name` varchar(100) DEFAULT NULL COMMENT '企业商品品名',
  `hscode` varchar(100) DEFAULT NULL,
  `goods_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `package_type` varchar(10) DEFAULT NULL COMMENT '包装种类',
  `net_weight` decimal(50,4) unsigned DEFAULT NULL COMMENT '净重',
  `bar_code` varchar(100) DEFAULT NULL COMMENT '条形码',
  `unit1` varchar(10) DEFAULT NULL COMMENT '第一法定单位',
  `unit2` varchar(10) DEFAULT NULL COMMENT '第一法定单位',
  `qty1` decimal(19,5) DEFAULT NULL COMMENT '第一法定数量',
  `qty2` decimal(19,5) DEFAULT NULL,
  `account_num` varchar(100) DEFAULT NULL COMMENT '账册项号',
  `created_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '1',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `GOODS_NAME` (`platform_code`,`merchant_code`,`merchant_goods_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='出口商品配置表';

-- ----------------------------
--  Table structure for `doc_person_manage`
-- ----------------------------
DROP TABLE IF EXISTS `doc_person_manage`;
CREATE TABLE `doc_person_manage` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT,
  `person_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '人员名称',
  `type` tinyint(2) DEFAULT NULL COMMENT '结果',
  `status` tinyint(2) DEFAULT '0' COMMENT '人员状态',
  `department` tinyint(2) DEFAULT NULL COMMENT '部门',
  `job_name` tinyint(2) DEFAULT NULL COMMENT '岗位名称',
  `sex` tinyint(2) DEFAULT NULL COMMENT '性别',
  `age` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '年龄',
  `school` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '学校名',
  `education` tinyint(2) DEFAULT NULL COMMENT '学历',
  `profession` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '专业',
  `school_attribute` tinyint(2) DEFAULT NULL COMMENT '院校属性',
  `experience` text CHARACTER SET utf8 COMMENT '工作经历',
  `phone` varchar(13) CHARACTER SET utf8 DEFAULT NULL COMMENT '电话',
  `email` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮箱',
  `create_by` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `update_by` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `version` tinyint(2) DEFAULT '0',
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1 COMMENT='人员管理表';

-- ----------------------------
--  Table structure for `exp_service_msg`
-- ----------------------------
DROP TABLE IF EXISTS `exp_service_msg`;
CREATE TABLE `exp_service_msg` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '消息id',
  `business_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '业务跟踪单号',
  `business_id` bigint(20) DEFAULT NULL COMMENT '业务id',
  `ex_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '交换机',
  `routing_key` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '路由key',
  `status` int(3) NOT NULL COMMENT '状态：10 发送中 20发送成功 30发送失败 40 处理中 50 处理成功 60 处理失败',
  `error_msg` text COLLATE utf8mb4_unicode_ci COMMENT '错误信息',
  `msg_count` int(4) DEFAULT NULL COMMENT '执行次数',
  `retry_count` int(4) DEFAULT NULL COMMENT '消息能够重试次数',
  `next_invoke_time` datetime DEFAULT NULL COMMENT '下次执行时间',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_by` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `update_by` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `version` int(2) DEFAULT '0',
  `is_deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='MQ消息管理表';

-- ----------------------------
--  Table structure for `life_study_plan`
-- ----------------------------
DROP TABLE IF EXISTS `life_study_plan`;
CREATE TABLE `life_study_plan` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `study_name` varchar(50) DEFAULT NULL COMMENT '知识点名称',
  `schedule` int(3) DEFAULT '0' COMMENT '进度',
  `operating_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='学习计划表';

-- ----------------------------
--  Table structure for `life_study_plan_detail`
-- ----------------------------
DROP TABLE IF EXISTS `life_study_plan_detail`;
CREATE TABLE `life_study_plan_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `study_name` varchar(50) DEFAULT NULL COMMENT '学习规划名',
  `study_detail` text COMMENT '学习内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `md_url`
-- ----------------------------
DROP TABLE IF EXISTS `md_url`;
CREATE TABLE `md_url` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `p_id` int(10) DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单/链接名',
  `url` varchar(300) DEFAULT NULL COMMENT '对应的链接',
  `user_id` int(10) DEFAULT NULL COMMENT '用户id(根据用户展示不同的导航页)',
  `create_time` datetime DEFAULT NULL COMMENT '链接创建时间',
  `click_times` int(10) DEFAULT '0' COMMENT '点击次数',
  `operate_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=999910 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `QRTZ_BLOB_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;
CREATE TABLE `QRTZ_BLOB_TRIGGERS` (
  `SCHED_NAME` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `QRTZ_CALENDARS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CALENDARS`;
CREATE TABLE `QRTZ_CALENDARS` (
  `SCHED_NAME` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CALENDAR_NAME` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `QRTZ_CRON_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;
CREATE TABLE `QRTZ_CRON_TRIGGERS` (
  `SCHED_NAME` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CRON_EXPRESSION` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `QRTZ_FIRED_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;
CREATE TABLE `QRTZ_FIRED_TRIGGERS` (
  `SCHED_NAME` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ENTRY_ID` varchar(95) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
  `JOB_NAME` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `JOB_GROUP` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `QRTZ_JOB_DETAILS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;
CREATE TABLE `QRTZ_JOB_DETAILS` (
  `SCHED_NAME` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `JOB_NAME` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `JOB_GROUP` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `IS_DURABLE` varchar(1) COLLATE utf8mb4_unicode_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) COLLATE utf8mb4_unicode_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) COLLATE utf8mb4_unicode_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) COLLATE utf8mb4_unicode_ci NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `QRTZ_LOCKS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_LOCKS`;
CREATE TABLE `QRTZ_LOCKS` (
  `SCHED_NAME` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LOCK_NAME` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `QRTZ_PAUSED_TRIGGER_GRPS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;
CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS` (
  `SCHED_NAME` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `QRTZ_SCHEDULER_STATE`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;
CREATE TABLE `QRTZ_SCHEDULER_STATE` (
  `SCHED_NAME` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `QRTZ_SIMPLE_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPLE_TRIGGERS` (
  `SCHED_NAME` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `QRTZ_SIMPROP_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPROP_TRIGGERS` (
  `SCHED_NAME` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `STR_PROP_1` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `STR_PROP_2` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `STR_PROP_3` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `QRTZ_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;
CREATE TABLE `QRTZ_TRIGGERS` (
  `SCHED_NAME` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `JOB_NAME` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `JOB_GROUP` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) COLLATE utf8mb4_unicode_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `QRTZ_JOB_DETAILS` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `s_permission`
-- ----------------------------
DROP TABLE IF EXISTS `s_permission`;
CREATE TABLE `s_permission` (
  `id` int(10) NOT NULL,
  `parent_id` int(10) DEFAULT NULL,
  `code` varchar(40) DEFAULT NULL COMMENT '权限code',
  `name` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限基础表';

-- ----------------------------
--  Table structure for `s_role`
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `is_deleted` int(1) DEFAULT '0',
  `version` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
--  Table structure for `s_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `s_role_permission`;
CREATE TABLE `s_role_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_id` int(10) DEFAULT NULL,
  `permission_id` int(10) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `version` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4491 DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

-- ----------------------------
--  Table structure for `s_user`
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(64) DEFAULT NULL COMMENT '登录名称',
  `display_name` varchar(64) DEFAULT NULL COMMENT '展示名称',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `error_count` bigint(10) DEFAULT '0' COMMENT '登录失败次数',
  `is_lock` int(1) DEFAULT '0' COMMENT '是否锁定：0否，1是，错误次数到一定值会锁定',
  `expire_time` timestamp NULL DEFAULT NULL COMMENT '过期时间',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `is_deleted` int(1) DEFAULT '0',
  `version` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
--  Table structure for `s_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `s_user_role`;
CREATE TABLE `s_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户表id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色表id',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `is_deleted` int(1) DEFAULT '0',
  `version` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
--  Table structure for `test_sql`
-- ----------------------------
DROP TABLE IF EXISTS `test_sql`;
CREATE TABLE `test_sql` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `cfg_configuration` VALUES ('1','email.sender','邮件发送者邮箱11','wei.wan@topideal.com.cn','2018-09-12 08:17:57','wa','2018-11-02 07:38:11','wanwei','53','0'), ('2','email.recipient','邮件接收者邮箱','wei.wan@topideal.com.cn','2018-09-12 08:19:06','wanwei','2018-09-25 07:38:18','wanwei','0','0'), ('9','1','1','1','2018-09-12 19:38:05','admin','2018-09-13 06:43:38',NULL,'0','1'), ('10','email.path','附件路径','C:/Users/12548/Desktop/weekly/','2018-09-13 14:45:00','admin','2018-09-13 06:45:01',NULL,'0','0'), ('11','email.password','邮箱密码','Ww1995','2018-09-13 14:59:55','admin','2018-09-13 06:59:56',NULL,'0','0'), ('12','1','1','1','2018-09-13 15:03:46','admin','2018-09-13 07:03:51',NULL,'0','1'), ('13','1','1','1','2018-09-13 15:08:31','admin','2018-09-13 07:08:37',NULL,'0','1'), ('14','1','1','1','2018-09-13 15:09:42','admin','2018-09-13 07:09:48',NULL,'0','1'), ('15','email.recipientCC','抄送人','wei.wan@topideal.com.cn','2018-09-13 15:26:49','admin','2018-09-13 07:26:50',NULL,'0','0'), ('16','ceshi','','ceshi 1','2018-09-14 14:06:44','admin','2018-09-14 06:08:11',NULL,'0','1'), ('17','ceshi','','ceshi5','2018-09-14 14:08:35','admin','2018-09-17 09:02:40',NULL,'0','1');
INSERT INTO `doc_person_manage` VALUES ('1','wanwei','0','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'wanwei','2018-09-18','wanwei','2018-09-18','0','0'), ('2','sdfhd','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2018-09-18',NULL,NULL,'0','1'), ('3','shsf','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2018-09-18',NULL,NULL,'0','1'), ('4','zhangsan','1','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2018-09-18',NULL,NULL,'0','0'), ('5','张三','2','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0'), ('6','李四','0','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0'), ('7','王五','2','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0'), ('8','张三','1','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0'), ('9','李四','0','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0'), ('10','王五','1','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0'), ('11','张三','2','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0'), ('12','李四','2','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0'), ('13','王五','1','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0'), ('14','张三','0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0'), ('15','李四','0','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0'), ('16','王五','0','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0');
INSERT INTO `life_study_plan` VALUES ('3','多线程','11','2019-02-22 11:16:40'), ('4','设计模式','7','2019-03-18 20:38:46'), ('5','java基础','5','2019-02-22 11:16:47'), ('6','mysql数据库','2','2019-02-22 11:16:49'), ('7','重构--改善既有代码的设计','1','2019-02-22 11:16:51'), ('8','数据结构（算法）','1','2019-02-22 16:35:39'), ('9','shell编程基础','5','2019-02-28 01:56:46'), ('10','功能管理系统','11','2019-02-28 01:52:05'), ('11','每日工作','3','2019-03-18 20:35:34'), ('12','redis','1','2019-02-26 18:56:26'), ('13','分布式SpringCloud','0',NULL), ('14','lodash','0',NULL);
INSERT INTO `life_study_plan_detail` VALUES ('10','功能管理系统','添加了学习规划管理页面 --（实现进度显示，阶段记录）','2019-02-21 00:40:52'), ('11','shell编程基础','基本语法学习 ： (if/for/echo/switch )','2019-02-21 02:30:49'), ('12','功能管理系统','学习规划页面 -- 添加 排序功能（上一次学习时间，熟练度）','2019-02-22 16:34:52'), ('13','数据结构（算法）','迷宫算法 -- 深度优先算法','2019-02-22 16:36:32'), ('14','shell编程基础','window下编辑的shell脚本文件类型需转化为 unix','2019-02-22 17:43:58'), ('15','每日工作','diana 项目添加系统参数管理页面','2019-02-26 01:34:30'), ('16','redis','reids spring 注解方法使用','2019-02-26 18:58:37'), ('17','设计模式','桥接模式（将抽象部分和实现部分分离 ： 蜡笔 与 彩水笔）','2019-02-26 19:01:07'), ('18','功能管理系统','重新学习引入定时任务（quarzt）--将定时任务固化到硬盘，保证项目终止重启后定时任务能够恢复原来状态','2019-02-28 01:53:55'), ('19','每日工作','熟悉BC业务，学习quarzt到固化硬盘使用，rf自动化接口打jar包','2019-02-28 01:55:43'), ('20','shell编程基础','linux下定时任务运行shell脚本学习','2019-02-28 01:57:06'), ('21','每日工作','RestTemplate （spring自带 基于HttpClient）学习使用','2019-03-18 20:36:12'), ('22','设计模式','模板模式---使用抽象类将共同方法抽出整理好作为模板','2019-03-18 20:38:22');
INSERT INTO `md_url` VALUES ('1','0','业务类导航','',NULL,NULL,'0',NULL), ('2','0','技术类导航','',NULL,NULL,'0',NULL), ('3','0','其他导航','',NULL,NULL,'0',NULL), ('10','1','项目导航','',NULL,NULL,'0',NULL), ('11','1','工具导航','',NULL,NULL,'0',NULL), ('20','2','java','',NULL,NULL,'0',NULL), ('21','2','android','',NULL,NULL,'0',NULL), ('22','2','mySql',NULL,NULL,NULL,'0',NULL), ('23','2','GIT',NULL,NULL,NULL,'0',NULL), ('24','2','文章','',NULL,NULL,'0',NULL), ('25','2','缓存',NULL,NULL,NULL,'0',NULL), ('26','2','加密/解密',NULL,NULL,'2019-03-11 22:41:20','0','2019-03-11 22:41:20'), ('27','2','分布式',NULL,NULL,'2019-03-22 02:47:04','0','2019-03-22 02:47:04'), ('30','3','生活类导航',NULL,NULL,NULL,'0',NULL), ('1000','10','BBC',NULL,NULL,NULL,'0',NULL), ('1001','10','BC',NULL,NULL,NULL,'0',NULL), ('1002','10','统一登录','http://www.chinaicip.com:8009/sso/login',NULL,NULL,'15','2019-03-19 13:57:55'), ('1003','10','WMS',NULL,NULL,NULL,'0',NULL), ('1004','10','EMA',NULL,NULL,NULL,'0',NULL), ('1005','10','TMS',NULL,NULL,NULL,'0',NULL), ('1006','10','卓志共用',NULL,NULL,NULL,'0',NULL), ('1007','10','MOCK','',NULL,NULL,'0',NULL), ('1008','10','diana',NULL,NULL,'2019-03-10 18:54:20','0','2019-03-10 18:54:20'), ('1009','10','工时系统',NULL,NULL,'2019-03-11 02:16:15','0','2019-03-11 02:16:15'), ('1100','11','MQ',NULL,NULL,NULL,'0',NULL), ('1101','11','FTP',NULL,NULL,NULL,'0',NULL), ('1102','11','图标',NULL,NULL,'2019-03-14 18:30:01','0','2019-03-14 18:30:01'), ('2000','20','项目日志输出',NULL,NULL,NULL,'0',NULL), ('2001','20','Job',NULL,NULL,'2019-02-28 00:51:42','0','2019-02-28 00:51:42'), ('2100','21','gank','https://gank.io/',NULL,NULL,'4','2019-01-28 00:59:57'), ('2102','21','drySister(android项目教程)','http://www.runoob.com/w3cnote/android-tutorial-android-studio.html',NULL,NULL,'2','2019-01-22 10:54:42'), ('2200','22','极客时间-mysql','https://time.geekbang.org/column/intro/139',NULL,NULL,'13','2019-03-18 18:08:13'), ('2300','23','我的git项目','https://github.com/wanwei1995',NULL,NULL,'0',NULL), ('2400','24','csdn-我的文章','https://mp.csdn.net/postlist',NULL,NULL,'2',NULL), ('2401','24','简书-我的文章','https://www.jianshu.com/writer#',NULL,NULL,'17','2019-03-14 18:25:09'), ('2500','25','Hazelcast',NULL,NULL,NULL,'0',NULL), ('2600','26','base64加解密','http://www.vgot.net/test/image2base64.php',NULL,'2019-03-11 22:41:50','0','2019-03-11 22:41:50'), ('2700','27','springCloud',NULL,NULL,'2019-03-22 02:47:18','0','2019-03-22 02:47:18'), ('3000','30','互联网新闻','https://jhuo.ca/',NULL,'2019-01-23 17:43:44','5','2019-02-11 19:18:01'), ('9999','0','临时导航','',NULL,NULL,'0',NULL), ('100000','1000','本地ideal','http://localhost:8089/login',NULL,NULL,'29','2019-03-19 18:11:34'), ('100001','1000','118测试环境','http://192.168.0.118:8888/login',NULL,NULL,'14','2019-03-19 18:11:50'), ('100002','1000','121测试环境','http://106.75.147.121:8080/ofc/',NULL,NULL,'7','2019-01-22 13:58:03'), ('100100','1001','本地ideal','http://localhost:8080/login',NULL,NULL,'20','2019-03-06 00:38:59'), ('100101','1001','权限管理','http://106.75.148.192:8080/login?tenant=system',NULL,NULL,'0',NULL), ('100102','1001','192测试环境','http://106.75.148.192:8080/login',NULL,NULL,'11','2019-03-11 18:46:34'), ('100103','1001','118测试环境','http://192.168.0.118:8999/login',NULL,NULL,'17','2019-03-05 19:30:03'), ('100104','1001','UAT环境','http://106.75.140.242:8080/ofc/login',NULL,NULL,'0',NULL), ('100300','1003','118测试环境','http://192.168.0.118:8480/wms/',NULL,NULL,'6','2019-03-19 19:11:11'), ('100301','1003','本地ideal','http://localhost:8089',NULL,NULL,'0',NULL), ('100302','1003','app下载链接','http://wms-download.topideal.com.cn/app/android/WMSapp.apk',NULL,'2019-01-22 15:07:52','5','2019-02-25 02:02:08'), ('100500','1005','线上环境','https://www.chinaicip.com/tms/login;jsessionid=59BFFF8DAD401C4EE07C8676F31C2984',NULL,NULL,'1','2019-03-19 13:58:06'), ('100501','1005','本地','http://localhost:8180/tms/',NULL,NULL,'1','2019-03-19 13:58:09'), ('100502','1005','118测试环境','http://192.168.0.118:8180/tms/login',NULL,NULL,'0',NULL), ('100600','1006','confluence','https://topideal.us/confluence/#all-updates',NULL,NULL,'4',NULL), ('100601','1006','gitlab','https://topideal.us/gitlab/',NULL,NULL,'0',NULL), ('100602','1006','jira','https://topideal.us/jira/browse/WMS-348?jql=',NULL,NULL,'19','2019-01-24 17:31:03'), ('100603','1006','Fisheye','http://192.168.0.118:8060/user/wanwei',NULL,NULL,'5',NULL), ('100700','1007','测试环境','http://192.168.0.118:8181/mock-web/',NULL,NULL,'0',NULL), ('100800','1008','本地环境','http://localhost:8280/diana/login',NULL,'2019-03-10 18:54:48','1','2019-03-10 18:55:04'), ('100900','1009','正式环境','http://topideal.top/hades/',NULL,'2019-03-11 02:16:28','1','2019-03-11 02:16:35'), ('110000','1100','本地MQ','http://10.0.0.225:15672/#/queues',NULL,NULL,'16',NULL), ('110001','1100','118MQ','http://192.168.0.118:15672/#/users',NULL,NULL,'1',NULL), ('110002','1100','234MQ(新)','http://10.13.98.234:15672/',NULL,NULL,'0',NULL), ('110100','1101','118环境','ftp://192.168.0.118:10021',NULL,NULL,'1',NULL), ('110200','1102','easyicon图标','https://www.easyicon.net/iconsearch/%E8%AD%A6%E5%91%8A/?s=download_png_DESC',NULL,'2019-03-14 18:30:26','0','2019-03-14 18:30:26'), ('110201','1102','阿里图标','http://iconfont.cn/collections/index?spm=a313x.7781069.1998910419.5&type=2',NULL,'2019-03-14 18:31:01','0','2019-03-14 18:31:01'), ('200000','2000','logback日志输出','https://www.cnblogs.com/gslyyq/p/5256789.html',NULL,NULL,'1','2019-01-22 10:54:45'), ('200100','2001','Springboot中如何为Quartz的Job自动装配Spring容器Bean','https://blog.csdn.net/pengjunlee/article/details/78965877',NULL,'2019-02-28 00:52:11','0','2019-02-28 00:52:11'), ('200101','2001','quartz的持久化任务调度使用应用的dataSource','https://www.cnblogs.com/huahua035/p/7977092.html',NULL,'2019-02-28 00:52:32','0','2019-02-28 00:52:32'), ('200102','2001','SpringBoot集成Quartz(解决@Autowired空指针Null问题即依赖注入的属性为null)','http://www.cnblogs.com/huahua035/p/7839834.html',NULL,'2019-02-28 00:53:26','1','2019-02-28 01:15:48'), ('250001','2500','hazelcast入门教程','https://www.chkui.com/article/hazelcast/hazelcast_get_started_and_code_sample',NULL,NULL,'6',NULL), ('250002','2500','监控中心启动页','http://localhost:8080/hazelcast-mancenter/',NULL,NULL,'0',NULL), ('270000','2700','Spring Cloud 入门教程','http://www.cnblogs.com/chry/p/7299844.html',NULL,'2019-03-22 02:47:50','0','2019-03-22 02:47:50'), ('270001','2700','Spring Cloud Eureka 自我保护机制','https://www.cnblogs.com/xishuai/p/spring-cloud-eureka-safe.html',NULL,'2019-03-22 02:48:44','0','2019-03-22 02:48:44'), ('270002','2700','负载均衡策略配置','https://blog.csdn.net/rickiyeat/article/details/64918756',NULL,'2019-03-22 02:49:33','0','2019-03-22 02:49:33'), ('999900','9999','最近5年133个Java面试问题列表 - 简书','https://www.jianshu.com/p/e58920e1e3aa',NULL,NULL,'25','2019-03-19 13:58:12'), ('999901','9999','线程池之ThreadPoolExecutor概述','https://www.jianshu.com/p/c41e942bcd64',NULL,NULL,'5','2019-01-22 11:28:20'), ('999902','9999','彻底理解cookie，session，token','https://www.cnblogs.com/moyand/p/9047978.html',NULL,NULL,'11','2019-02-20 01:34:21'), ('999903','9999','java面试题','https://www.jianshu.com/p/e8d750ef9bbf',NULL,NULL,'2','2019-01-22 11:28:47'), ('999904','9999','Fiddler 抓包工具总结','https://www.cnblogs.com/yyhh/p/5140852.html',NULL,'2019-01-22 10:34:59','8','2019-01-22 11:28:21'), ('999905','9999','Java程序员的学习生涯中各个阶段的建议','https://cloud.tencent.com/developer/article/1365707',NULL,'2019-01-31 18:43:30','2','2019-02-20 01:34:26'), ('999906','9999','Java并发编程75道面试题及答案','https://blog.csdn.net/qq_34039315/article/details/78549311',NULL,'2019-01-31 23:59:11','0','2019-01-31 23:59:11'), ('999907','9999','shell编程基础','https://cloud.tencent.com/developer/article/1392600',NULL,'2019-02-20 01:47:12','2','2019-02-22 15:02:03'), ('999908','9999','nginx学习教程（gh12）','https://pan.baidu.com/s/19-9qtSkP9O8SI1XCnlrSqQ',NULL,'2019-02-28 17:58:49','0','2019-02-28 17:58:49'), ('999909','9999','高可用服务学习（银文杰博客）','https://blog.csdn.net/yinwenjie',NULL,'2019-03-05 17:11:21','5','2019-03-14 18:00:21');
INSERT INTO `QRTZ_CRON_TRIGGERS` VALUES ('DIANA_TASK_EXECUTOR','导出文件定期清理任务','job','0 0 1 1/1 * ?','Asia/Shanghai'), ('DIANA_TASK_EXECUTOR','测试','job','* * * * * ?','Asia/Shanghai');
INSERT INTO `QRTZ_FIRED_TRIGGERS` VALUES ('DIANA_TASK_EXECUTOR','DESKTOP-G3N9E5O15519418846371551941884569','测试','job','DESKTOP-G3N9E5O1551941884637','1551941921917','1551941921849','5','EXECUTING','测试','job','0','0'), ('DIANA_TASK_EXECUTOR','DESKTOP-G3N9E5O15519418846371551941884570','测试','job','DESKTOP-G3N9E5O1551941884637','1551941922007','1551941922000','5','EXECUTING','测试','job','0','0');
INSERT INTO `QRTZ_JOB_DETAILS` VALUES ('DIANA_TASK_EXECUTOR','导出文件定期清理任务','job',NULL,'com.topideal.supplychain.job.ExportRecordClearJob','1','0','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'), ('DIANA_TASK_EXECUTOR','测试','job',NULL,'com.ww.springboot.boot.job.TestJob','1','0','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0');
INSERT INTO `QRTZ_LOCKS` VALUES ('DIANA_TASK_EXECUTOR','STATE_ACCESS'), ('DIANA_TASK_EXECUTOR','TRIGGER_ACCESS');
INSERT INTO `QRTZ_SCHEDULER_STATE` VALUES ('DIANA_TASK_EXECUTOR','DESKTOP-G3N9E5O1551941884637','1551941919561','20000');
INSERT INTO `QRTZ_TRIGGERS` VALUES ('DIANA_TASK_EXECUTOR','导出文件定期清理任务','job','导出文件定期清理任务','job',NULL,'1551373200000','-1','5','WAITING','CRON','1551339173000','0',NULL,'0',''), ('DIANA_TASK_EXECUTOR','测试','job','测试','job',NULL,'1551941923000','1551941922000','5','WAITING','CRON','1551347329000','0',NULL,'0','');
INSERT INTO `s_permission` VALUES ('1',NULL,'master','基础数据'), ('2',NULL,'doc','单据'), ('3',NULL,'rule','规则'), ('4',NULL,'log','日志'), ('5',NULL,'config','配置'), ('6',NULL,'task','任务'), ('8',NULL,'assessment','KPI考核'), ('100','1','master.carrier','配送商管理'), ('110','1','master.subscriber','订阅者管理'), ('120','1','master.distribution','配送商服务管理'), ('130','1','master.capacityArea','运力区域管理'), ('140','1','master.customs','关区管理'), ('150','1','master.userKey','用户密钥管理'), ('160','1','master.mqMapping','MQ管理'), ('170','1','master.waybilltemp','面单模板管理'), ('180','1','master.deliverPeriod','配送时效管理'), ('200','2','doc.orderHeader','订单信息管理'), ('210','2','doc.sfRouteLogImport','顺丰签收轨迹导入'), ('300','3','rule.deliverRule','配送商规则'), ('310','3','rule.capacityRule','运力规则'), ('400','4','log.expInvokeLog','接口日志管理'), ('500','5','config.sysConfig','物流公司参数'), ('510','5','config.businessConfig','业务参数'), ('520','5','config.carrierConfig','承运商参数'), ('600','6','task.waybill','面单任务管理'), ('610','6','task.shipment','运单任务管理'), ('620','6','task.declare','申报任务管理'), ('630','6','task.subscribeReq','订阅请求任务管理'), ('640','6','task.message','物流日志分发任务消息管理'), ('650','6','task.busException','异常处理页面'), ('1001','100','master.carrier.add','新增'), ('1002','100','master.carrier.update','修改'), ('1003','100','master.carrier.find','查找'), ('1004','100','master.carrier.service','设置服务'), ('1101','110','master.subscriber.find','查找'), ('1102','110','master.subscriber.update','更新'), ('1200','120','master.distribution.add','新增'), ('1201','120','master.distribution.delete','删除'), ('1202','120','master.distribution.update','修改'), ('1203','120','master.distribution.find','查找'), ('1300','130','master.capacityarea.add','新增'), ('1301','130','master.capacityarea.delete','删除'), ('1302','130','master.capacityarea.update','修改'), ('1303','130','master.capacityarea.find','查找'), ('1400','140','master.customs.add','新增'), ('1401','140','master.customs.delete','删除'), ('1402','140','master.customs.find','查找'), ('1500','150','master.userKey.add','新增'), ('1501','150','master.userKey.delete','删除'), ('1502','150','master.userKey.update','修改'), ('1503','150','master.userKey.find','查找'), ('1504','150','master.userKey.secret','生成秘钥'), ('1600','160','master.mqMapping.add','新增'), ('1601','160','master.mqMapping.delete','删除'), ('1602','160','master.mqMapping.update','修改'), ('1603','160','master.mqMapping.find','查找'), ('1604','160','master.mqMapping.reBuild','重构mq'), ('1700','170','master.waybilltemp.add','新增'), ('1701','170','master.waybilltemp.delete','删除'), ('1702','170','master.waybilltemp.update','修改'), ('1703','170','master.waybilltemp.find','查找'), ('2001','200','doc.orderHeader.find','查找'), ('3001','300','rule.deliverRule.add','新增'), ('3002','300','rule.deliverRule.delete','删除'), ('3003','300','rule.deliverRule.update','修改'), ('3004','300','rule.deliverRule.find','查找'), ('3005','300','rule.deliverRule.import','导入'), ('3006','300','rule.deliverRule.export','批量导出'), ('3007','300','rule.deliverRule.load','模板下载'), ('3100','310','rule.capacityRule.update','修改'), ('3101','310','rule.capacityRule.find','查找'), ('3102','310','rule.capacityRule.export','批量导出'), ('3103','310','rule.capacityRule.reset','重置剩余量'), ('4001','400','log.expInvokeLog.find','查找'), ('5001','500','config.sysConfig.add','新增'), ('5002','500','config.sysConfig.delete','删除'), ('5003','500','config.sysConfig.update','修改'), ('5004','500','config.sysConfig.find','查找'), ('5100','510','config.businessConfig.add','新增'), ('5101','510','config.businessConfig.delete','删除'), ('5102','510','config.businessConfig.update','修改'), ('5103','510','config.businessConfig.find','查找'), ('5200','520','config.carrierConfig.add','新增'), ('5201','520','config.carrierConfig.delete','删除'), ('5202','520','config.carrierConfig.find','查找'), ('5203','520','config.carrierConfig.link','关联'), ('6000','600','task.waybill.find','查找'), ('6100','610','task.shipment.find','查找'), ('6200','620','task.declare.find','查找'), ('6300','630','task.subscribeReq.find','查找'), ('6400','640','task.message.find','查找'), ('6500','650','task.busException.find','查找'), ('6501','650','task.busException.delete','删除'), ('6502','650','task.busException.retry','重推');
INSERT INTO `s_role` VALUES ('1','admin',NULL,NULL,NULL,NULL,'0',NULL), ('2','customer',NULL,NULL,NULL,NULL,'1',NULL), ('9','manager','2017-12-22 11:49:02','admin',NULL,NULL,'0',NULL);
INSERT INTO `s_role_permission` VALUES ('3679','1','1',NULL,NULL,NULL,NULL,'0'), ('3680','1','100',NULL,NULL,NULL,NULL,'0'), ('3681','1','1001',NULL,NULL,NULL,NULL,'0'), ('3682','1','1002',NULL,NULL,NULL,NULL,'0'), ('3683','1','1003',NULL,NULL,NULL,NULL,'0'), ('3684','1','1004',NULL,NULL,NULL,NULL,'0'), ('3685','1','110',NULL,NULL,NULL,NULL,'0'), ('3686','1','1101',NULL,NULL,NULL,NULL,'0'), ('3687','1','1102',NULL,NULL,NULL,NULL,'0'), ('3688','1','120',NULL,NULL,NULL,NULL,'0'), ('3689','1','1200',NULL,NULL,NULL,NULL,'0'), ('3690','1','1201',NULL,NULL,NULL,NULL,'0'), ('3691','1','1202',NULL,NULL,NULL,NULL,'0'), ('3692','1','1203',NULL,NULL,NULL,NULL,'0'), ('3693','1','130',NULL,NULL,NULL,NULL,'0'), ('3694','1','1300',NULL,NULL,NULL,NULL,'0'), ('3695','1','1301',NULL,NULL,NULL,NULL,'0'), ('3696','1','1302',NULL,NULL,NULL,NULL,'0'), ('3697','1','1303',NULL,NULL,NULL,NULL,'0'), ('3698','1','140',NULL,NULL,NULL,NULL,'0'), ('3699','1','1400',NULL,NULL,NULL,NULL,'0'), ('3700','1','1401',NULL,NULL,NULL,NULL,'0'), ('3701','1','1402',NULL,NULL,NULL,NULL,'0'), ('3702','1','150',NULL,NULL,NULL,NULL,'0'), ('3703','1','1500',NULL,NULL,NULL,NULL,'0'), ('3704','1','1501',NULL,NULL,NULL,NULL,'0'), ('3705','1','1502',NULL,NULL,NULL,NULL,'0'), ('3706','1','1503',NULL,NULL,NULL,NULL,'0'), ('3707','1','1504',NULL,NULL,NULL,NULL,'0'), ('3708','1','160',NULL,NULL,NULL,NULL,'0'), ('3709','1','1600',NULL,NULL,NULL,NULL,'0'), ('3710','1','1601',NULL,NULL,NULL,NULL,'0'), ('3711','1','1602',NULL,NULL,NULL,NULL,'0'), ('3712','1','1603',NULL,NULL,NULL,NULL,'0'), ('3713','1','1604',NULL,NULL,NULL,NULL,'0'), ('3714','1','170',NULL,NULL,NULL,NULL,'0'), ('3715','1','1700',NULL,NULL,NULL,NULL,'0'), ('3716','1','1701',NULL,NULL,NULL,NULL,'0'), ('3717','1','1702',NULL,NULL,NULL,NULL,'0'), ('3718','1','1703',NULL,NULL,NULL,NULL,'0'), ('3719','1','180',NULL,NULL,NULL,NULL,'0'), ('3720','1','2',NULL,NULL,NULL,NULL,'0'), ('3721','1','200',NULL,NULL,NULL,NULL,'0'), ('3722','1','2001',NULL,NULL,NULL,NULL,'0'), ('3723','1','210',NULL,NULL,NULL,NULL,'0'), ('3724','1','3',NULL,NULL,NULL,NULL,'0'), ('3725','1','300',NULL,NULL,NULL,NULL,'0'), ('3726','1','3001',NULL,NULL,NULL,NULL,'0'), ('3727','1','3002',NULL,NULL,NULL,NULL,'0'), ('3728','1','3003',NULL,NULL,NULL,NULL,'0'), ('3729','1','3004',NULL,NULL,NULL,NULL,'0'), ('3730','1','3005',NULL,NULL,NULL,NULL,'0'), ('3731','1','3006',NULL,NULL,NULL,NULL,'0'), ('3732','1','3007',NULL,NULL,NULL,NULL,'0'), ('3733','1','310',NULL,NULL,NULL,NULL,'0'), ('3734','1','3100',NULL,NULL,NULL,NULL,'0'), ('3735','1','3101',NULL,NULL,NULL,NULL,'0'), ('3736','1','3102',NULL,NULL,NULL,NULL,'0'), ('3737','1','3103',NULL,NULL,NULL,NULL,'0'), ('3738','1','4',NULL,NULL,NULL,NULL,'0'), ('3739','1','400',NULL,NULL,NULL,NULL,'0'), ('3740','1','4001',NULL,NULL,NULL,NULL,'0'), ('3741','1','5',NULL,NULL,NULL,NULL,'0'), ('3742','1','500',NULL,NULL,NULL,NULL,'0'), ('3743','1','5001',NULL,NULL,NULL,NULL,'0'), ('3744','1','5002',NULL,NULL,NULL,NULL,'0'), ('3745','1','5003',NULL,NULL,NULL,NULL,'0'), ('3746','1','5004',NULL,NULL,NULL,NULL,'0'), ('3747','1','510',NULL,NULL,NULL,NULL,'0'), ('3748','1','5100',NULL,NULL,NULL,NULL,'0'), ('3749','1','5101',NULL,NULL,NULL,NULL,'0'), ('3750','1','5102',NULL,NULL,NULL,NULL,'0'), ('3751','1','5103',NULL,NULL,NULL,NULL,'0'), ('3752','1','520',NULL,NULL,NULL,NULL,'0'), ('3753','1','5200',NULL,NULL,NULL,NULL,'0'), ('3754','1','5201',NULL,NULL,NULL,NULL,'0'), ('3755','1','5202',NULL,NULL,NULL,NULL,'0'), ('3756','1','5203',NULL,NULL,NULL,NULL,'0'), ('3757','1','6',NULL,NULL,NULL,NULL,'0'), ('3758','1','600',NULL,NULL,NULL,NULL,'0'), ('3759','1','6000',NULL,NULL,NULL,NULL,'0'), ('3760','1','610',NULL,NULL,NULL,NULL,'0'), ('3761','1','6100',NULL,NULL,NULL,NULL,'0'), ('3762','1','620',NULL,NULL,NULL,NULL,'0'), ('3763','1','6200',NULL,NULL,NULL,NULL,'0'), ('3764','1','630',NULL,NULL,NULL,NULL,'0'), ('3765','1','6300',NULL,NULL,NULL,NULL,'0'), ('3766','1','640',NULL,NULL,NULL,NULL,'0'), ('3767','1','6400',NULL,NULL,NULL,NULL,'0'), ('3768','1','650',NULL,NULL,NULL,NULL,'0'), ('3769','1','6500',NULL,NULL,NULL,NULL,'0'), ('3770','1','6501',NULL,NULL,NULL,NULL,'0'), ('3771','1','6502',NULL,NULL,NULL,NULL,'0'), ('3772','1','7',NULL,NULL,NULL,NULL,'0'), ('3773','1','700',NULL,NULL,NULL,NULL,'0'), ('3774','1','7000',NULL,NULL,NULL,NULL,'0'), ('3775','1','7001',NULL,NULL,NULL,NULL,'0'), ('3776','1','7002',NULL,NULL,NULL,NULL,'0'), ('3777','1','7003',NULL,NULL,NULL,NULL,'0'), ('3778','1','7004',NULL,NULL,NULL,NULL,'0');
INSERT INTO `s_role_permission` VALUES ('3779','1','7005',NULL,NULL,NULL,NULL,'0'), ('3780','1','7006',NULL,NULL,NULL,NULL,'0'), ('3781','1','710',NULL,NULL,NULL,NULL,'0'), ('3782','1','7100',NULL,NULL,NULL,NULL,'0'), ('3783','1','7101',NULL,NULL,NULL,NULL,'0'), ('3784','1','7102',NULL,NULL,NULL,NULL,'0'), ('3785','1','7103',NULL,NULL,NULL,NULL,'0'), ('3786','1','8',NULL,NULL,NULL,NULL,'0'), ('4384','9','1',NULL,NULL,NULL,NULL,'0'), ('4385','9','100',NULL,NULL,NULL,NULL,'0'), ('4386','9','1001',NULL,NULL,NULL,NULL,'0'), ('4387','9','1002',NULL,NULL,NULL,NULL,'0'), ('4388','9','1003',NULL,NULL,NULL,NULL,'0'), ('4389','9','1004',NULL,NULL,NULL,NULL,'0'), ('4390','9','110',NULL,NULL,NULL,NULL,'0'), ('4391','9','1101',NULL,NULL,NULL,NULL,'0'), ('4392','9','1102',NULL,NULL,NULL,NULL,'0'), ('4393','9','120',NULL,NULL,NULL,NULL,'0'), ('4394','9','1200',NULL,NULL,NULL,NULL,'0'), ('4395','9','1201',NULL,NULL,NULL,NULL,'0'), ('4396','9','1202',NULL,NULL,NULL,NULL,'0'), ('4397','9','1203',NULL,NULL,NULL,NULL,'0'), ('4398','9','130',NULL,NULL,NULL,NULL,'0'), ('4399','9','1300',NULL,NULL,NULL,NULL,'0'), ('4400','9','1301',NULL,NULL,NULL,NULL,'0'), ('4401','9','1302',NULL,NULL,NULL,NULL,'0'), ('4402','9','1303',NULL,NULL,NULL,NULL,'0'), ('4403','9','140',NULL,NULL,NULL,NULL,'0'), ('4404','9','1400',NULL,NULL,NULL,NULL,'0'), ('4405','9','1401',NULL,NULL,NULL,NULL,'0'), ('4406','9','1402',NULL,NULL,NULL,NULL,'0'), ('4407','9','150',NULL,NULL,NULL,NULL,'0'), ('4408','9','1500',NULL,NULL,NULL,NULL,'0'), ('4409','9','1501',NULL,NULL,NULL,NULL,'0'), ('4410','9','1502',NULL,NULL,NULL,NULL,'0'), ('4411','9','1503',NULL,NULL,NULL,NULL,'0'), ('4412','9','1504',NULL,NULL,NULL,NULL,'0'), ('4413','9','160',NULL,NULL,NULL,NULL,'0'), ('4414','9','1600',NULL,NULL,NULL,NULL,'0'), ('4415','9','1601',NULL,NULL,NULL,NULL,'0'), ('4416','9','1602',NULL,NULL,NULL,NULL,'0'), ('4417','9','1603',NULL,NULL,NULL,NULL,'0'), ('4418','9','170',NULL,NULL,NULL,NULL,'0'), ('4419','9','1700',NULL,NULL,NULL,NULL,'0'), ('4420','9','1701',NULL,NULL,NULL,NULL,'0'), ('4421','9','1702',NULL,NULL,NULL,NULL,'0'), ('4422','9','1703',NULL,NULL,NULL,NULL,'0'), ('4423','9','180',NULL,NULL,NULL,NULL,'0'), ('4424','9','2',NULL,NULL,NULL,NULL,'0'), ('4425','9','200',NULL,NULL,NULL,NULL,'0'), ('4426','9','2001',NULL,NULL,NULL,NULL,'0'), ('4427','9','210',NULL,NULL,NULL,NULL,'0'), ('4428','9','3',NULL,NULL,NULL,NULL,'0'), ('4429','9','300',NULL,NULL,NULL,NULL,'0'), ('4430','9','3001',NULL,NULL,NULL,NULL,'0'), ('4431','9','3002',NULL,NULL,NULL,NULL,'0'), ('4432','9','3003',NULL,NULL,NULL,NULL,'0'), ('4433','9','3004',NULL,NULL,NULL,NULL,'0'), ('4434','9','3005',NULL,NULL,NULL,NULL,'0'), ('4435','9','3006',NULL,NULL,NULL,NULL,'0'), ('4436','9','3007',NULL,NULL,NULL,NULL,'0'), ('4437','9','310',NULL,NULL,NULL,NULL,'0'), ('4438','9','3100',NULL,NULL,NULL,NULL,'0'), ('4439','9','3101',NULL,NULL,NULL,NULL,'0'), ('4440','9','3102',NULL,NULL,NULL,NULL,'0'), ('4441','9','3103',NULL,NULL,NULL,NULL,'0'), ('4442','9','4',NULL,NULL,NULL,NULL,'0'), ('4443','9','400',NULL,NULL,NULL,NULL,'0'), ('4444','9','4001',NULL,NULL,NULL,NULL,'0'), ('4445','9','5',NULL,NULL,NULL,NULL,'0'), ('4446','9','500',NULL,NULL,NULL,NULL,'0'), ('4447','9','5001',NULL,NULL,NULL,NULL,'0'), ('4448','9','5002',NULL,NULL,NULL,NULL,'0'), ('4449','9','5003',NULL,NULL,NULL,NULL,'0'), ('4450','9','5004',NULL,NULL,NULL,NULL,'0'), ('4451','9','510',NULL,NULL,NULL,NULL,'0'), ('4452','9','5100',NULL,NULL,NULL,NULL,'0'), ('4453','9','5101',NULL,NULL,NULL,NULL,'0'), ('4454','9','5102',NULL,NULL,NULL,NULL,'0'), ('4455','9','5103',NULL,NULL,NULL,NULL,'0'), ('4456','9','520',NULL,NULL,NULL,NULL,'0'), ('4457','9','5200',NULL,NULL,NULL,NULL,'0'), ('4458','9','5201',NULL,NULL,NULL,NULL,'0'), ('4459','9','5202',NULL,NULL,NULL,NULL,'0'), ('4460','9','5203',NULL,NULL,NULL,NULL,'0'), ('4461','9','6',NULL,NULL,NULL,NULL,'0'), ('4462','9','600',NULL,NULL,NULL,NULL,'0'), ('4463','9','6000',NULL,NULL,NULL,NULL,'0'), ('4464','9','610',NULL,NULL,NULL,NULL,'0'), ('4465','9','6100',NULL,NULL,NULL,NULL,'0'), ('4466','9','620',NULL,NULL,NULL,NULL,'0'), ('4467','9','6200',NULL,NULL,NULL,NULL,'0'), ('4468','9','630',NULL,NULL,NULL,NULL,'0'), ('4469','9','6300',NULL,NULL,NULL,NULL,'0'), ('4470','9','640',NULL,NULL,NULL,NULL,'0'), ('4471','9','6400',NULL,NULL,NULL,NULL,'0'), ('4472','9','650',NULL,NULL,NULL,NULL,'0'), ('4473','9','6500',NULL,NULL,NULL,NULL,'0'), ('4474','9','6501',NULL,NULL,NULL,NULL,'0'), ('4475','9','6502',NULL,NULL,NULL,NULL,'0');
INSERT INTO `s_role_permission` VALUES ('4476','9','7',NULL,NULL,NULL,NULL,'0'), ('4477','9','700',NULL,NULL,NULL,NULL,'0'), ('4478','9','7000',NULL,NULL,NULL,NULL,'0'), ('4479','9','7001',NULL,NULL,NULL,NULL,'0'), ('4480','9','7002',NULL,NULL,NULL,NULL,'0'), ('4481','9','7003',NULL,NULL,NULL,NULL,'0'), ('4482','9','7004',NULL,NULL,NULL,NULL,'0'), ('4483','9','7005',NULL,NULL,NULL,NULL,'0'), ('4484','9','7006',NULL,NULL,NULL,NULL,'0'), ('4485','9','710',NULL,NULL,NULL,NULL,'0'), ('4486','9','7100',NULL,NULL,NULL,NULL,'0'), ('4487','9','7101',NULL,NULL,NULL,NULL,'0'), ('4488','9','7102',NULL,NULL,NULL,NULL,'0'), ('4489','9','7103',NULL,NULL,NULL,NULL,'0'), ('4490','9','8',NULL,NULL,NULL,NULL,'0');
INSERT INTO `s_user` VALUES ('11','admin','管理员','e10adc3949ba59abbe56e057f20f883e','0','0','2025-01-01 00:00:00','2017-12-25 18:36:53','admin','2018-09-29 16:23:14','wanwei','0',NULL), ('23','wanwei','wanwei','e10adc3949ba59abbe56e057f20f883e','0','0','2019-07-02 00:00:00','2018-01-03 17:06:27','admin','2018-09-29 16:42:36','admin','0',NULL);
INSERT INTO `s_user_role` VALUES ('128','11','1','2018-09-29 16:23:14','wanwei',NULL,NULL,'0',NULL), ('130','23','9','2018-09-29 16:42:36','admin',NULL,NULL,'0',NULL), ('131','23','1','2018-09-29 16:42:36','admin',NULL,NULL,'0',NULL);
INSERT INTO `test_sql` VALUES ('1',NULL);
