/*
Navicat MySQL Data Transfer

Source Server         : ngsy
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : ngsy

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-06-12 17:19:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bonus_penalty
-- ----------------------------
DROP TABLE IF EXISTS `bonus_penalty`;
CREATE TABLE `bonus_penalty` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `person_id` varchar(40) DEFAULT NULL COMMENT '人员主键',
  `type` varchar(20) DEFAULT NULL COMMENT '奖惩类别',
  `name` varchar(255) DEFAULT NULL COMMENT '内容',
  `own_date` datetime DEFAULT NULL COMMENT '获得日期',
  `lost_date` datetime DEFAULT NULL COMMENT '失效日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bonus_penalty
-- ----------------------------

-- ----------------------------
-- Table structure for code
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `type` varchar(40) DEFAULT NULL COMMENT '类型主键',
  `name` varchar(255) DEFAULT NULL COMMENT '字典项名',
  `code` varchar(20) DEFAULT NULL COMMENT '字典项代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code
-- ----------------------------

-- ----------------------------
-- Table structure for code_type
-- ----------------------------
DROP TABLE IF EXISTS `code_type`;
CREATE TABLE `code_type` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '数据字典分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code_type
-- ----------------------------

-- ----------------------------
-- Table structure for duties_person
-- ----------------------------
DROP TABLE IF EXISTS `duties_person`;
CREATE TABLE `duties_person` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `person_id` varchar(40) DEFAULT NULL COMMENT '人员主键',
  `duties_unit_id` varchar(40) DEFAULT NULL COMMENT '单位行政职务主键',
  `own_date` datetime DEFAULT NULL COMMENT '任职时间',
  `is_probation` varchar(2) DEFAULT NULL COMMENT '是否试用',
  `probation_date` datetime DEFAULT NULL COMMENT '试用期至',
  `lost_date` datetime DEFAULT NULL COMMENT '卸任时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of duties_person
-- ----------------------------

-- ----------------------------
-- Table structure for duties_unit
-- ----------------------------
DROP TABLE IF EXISTS `duties_unit`;
CREATE TABLE `duties_unit` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `unit_id` varchar(40) DEFAULT NULL COMMENT '单位主键',
  `name` varchar(255) DEFAULT NULL COMMENT '行政职务名称',
  `rank` varchar(20) DEFAULT NULL COMMENT '院内行政职级',
  `count` int(5) DEFAULT NULL COMMENT '应有职数',
  `is_used` varchar(2) DEFAULT NULL COMMENT '是否使用中 0-否 1-是',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of duties_unit
-- ----------------------------

-- ----------------------------
-- Table structure for education
-- ----------------------------
DROP TABLE IF EXISTS `education`;
CREATE TABLE `education` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `person_id` varchar(40) DEFAULT NULL COMMENT '人员主键',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `school` varchar(255) DEFAULT NULL COMMENT '院校',
  `specialty` varchar(255) DEFAULT NULL COMMENT '专业',
  `education` varchar(20) DEFAULT NULL COMMENT '学历',
  `degree` varchar(20) DEFAULT NULL COMMENT '学位',
  `graduation_date` datetime DEFAULT NULL COMMENT '毕业时间',
  `is_highest` varchar(2) DEFAULT NULL COMMENT '是否最高 1-是 2-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of education
-- ----------------------------

-- ----------------------------
-- Table structure for job_person
-- ----------------------------
DROP TABLE IF EXISTS `job_person`;
CREATE TABLE `job_person` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `person_id` varchar(40) DEFAULT NULL COMMENT '人员主键',
  `job_id` varchar(40) DEFAULT NULL COMMENT '单位岗位主键',
  `shuang_jian_tiao` varchar(20) DEFAULT NULL COMMENT '双肩挑',
  `job_salary` varchar(3) DEFAULT NULL COMMENT '享受岗位工资',
  `salary` decimal(10,0) DEFAULT NULL COMMENT '工资',
  `own_date` datetime DEFAULT NULL COMMENT '任职时间',
  `is_probation` varchar(2) DEFAULT NULL COMMENT '是否试用',
  `probation_date` datetime DEFAULT NULL COMMENT '试用期至',
  `lost_date` datetime DEFAULT NULL COMMENT '离职时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_person
-- ----------------------------

-- ----------------------------
-- Table structure for job_unit
-- ----------------------------
DROP TABLE IF EXISTS `job_unit`;
CREATE TABLE `job_unit` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `unit_id` varchar(40) DEFAULT NULL COMMENT '单位主键',
  `name` varchar(255) DEFAULT NULL COMMENT '岗位名称',
  `rank` varchar(20) DEFAULT NULL COMMENT '岗位级别',
  `type` varchar(20) DEFAULT NULL COMMENT '院内岗位分类',
  `count` int(11) DEFAULT NULL COMMENT '应有岗数',
  `salary` decimal(10,0) DEFAULT NULL COMMENT '岗位工资',
  `is_used` varchar(2) DEFAULT NULL COMMENT '是否使用中',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_unit
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `type` varchar(2) DEFAULT NULL COMMENT '对象类型',
  `target` varchar(40) DEFAULT NULL COMMENT '对象id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for ndkh
-- ----------------------------
DROP TABLE IF EXISTS `ndkh`;
CREATE TABLE `ndkh` (
  `id` varchar(40) NOT NULL,
  `person_id` varchar(40) DEFAULT NULL,
  `year` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ndkh
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permission_name` varchar(32) DEFAULT NULL COMMENT '权限名',
  `permission_sign` varchar(128) DEFAULT NULL COMMENT '权限标识,程序中判断使用,如"user:create"',
  `description` varchar(256) DEFAULT NULL COMMENT '权限描述,UI界面显示使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '管理员', 'admin', '管理员');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `nationality` varchar(20) DEFAULT NULL COMMENT '民族',
  `
native_place` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `birthplace` varchar(20) DEFAULT NULL COMMENT '出生地',
  `party` varchar(20) DEFAULT NULL COMMENT '政治面貌',
  `partydate` datetime DEFAULT NULL COMMENT '入党时间',
  `work_date` datetime DEFAULT NULL COMMENT '参加工作时间',
  `health` varchar(20) DEFAULT NULL COMMENT '健康状况',
  `specialty` varchar(255) DEFAULT NULL COMMENT '熟悉专业有何专长',
  `id_card` varchar(30) DEFAULT NULL COMMENT '身份证号',
  `xian_ren_zhi_wu` varchar(255) DEFAULT NULL COMMENT '现任职务',
  `ni_ren_zhi_wu` varchar(255) DEFAULT NULL COMMENT '拟任职务',
  `ni_mian_zhi_wu` varchar(255) DEFAULT NULL COMMENT '拟免职务',
  `state` int(3) DEFAULT NULL COMMENT '人员状态',
  `shuang_shi_date` datetime DEFAULT NULL COMMENT '双师认定时间',
  `enter_date` datetime DEFAULT NULL COMMENT '进入本单位工作时间',
  `type` varchar(20) DEFAULT NULL COMMENT '人员类型',
  `salary_rank_id` varchar(40) DEFAULT NULL COMMENT '考勤课酬',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------

-- ----------------------------
-- Table structure for rank
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `person_id` varchar(40) DEFAULT NULL COMMENT '人员主键',
  `rank` varchar(20) DEFAULT NULL COMMENT '职级',
  `own_date` datetime DEFAULT NULL COMMENT '获得日期',
  `state` varchar(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank
-- ----------------------------

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `person_id` varchar(40) DEFAULT NULL COMMENT '人员主键',
  `begin_date` datetime DEFAULT NULL COMMENT '起始时间',
  `end_date` datetime DEFAULT NULL COMMENT '结束时间',
  `content` varchar(255) DEFAULT NULL COMMENT '简历正文',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resume
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '处室id',
  `role_name` varchar(32) DEFAULT NULL COMMENT '处室名',
  `role_sign` varchar(128) DEFAULT NULL COMMENT '处室标识,程序中判断使用,如"admin"',
  `description` varchar(256) DEFAULT NULL COMMENT '处室描述,UI界面显示使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='处室表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', 'admin', '管理员');

-- ----------------------------
-- Table structure for salary_rank
-- ----------------------------
DROP TABLE IF EXISTS `salary_rank`;
CREATE TABLE `salary_rank` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `rank` varchar(255) DEFAULT NULL COMMENT '考勤课薪级别',
  `standard` decimal(10,0) DEFAULT NULL COMMENT '考勤课薪标准',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salary_rank
-- ----------------------------

-- ----------------------------
-- Table structure for technical_title
-- ----------------------------
DROP TABLE IF EXISTS `technical_title`;
CREATE TABLE `technical_title` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `person_id` varchar(40) DEFAULT NULL COMMENT '人员主键',
  `technical_title` varchar(20) DEFAULT NULL COMMENT '专业技术职称',
  `own_date` datetime DEFAULT NULL COMMENT '获得日期',
  `job_date` datetime DEFAULT NULL COMMENT '职称聘任时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of technical_title
-- ----------------------------

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '单位名',
  `simple_name` varchar(255) DEFAULT NULL COMMENT '单位简称',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `tree_level` int(5) DEFAULT NULL COMMENT '单位树级别',
  `superior_id` varchar(40) DEFAULT NULL COMMENT '上级单位主键',
  `is_used` int(3) DEFAULT NULL COMMENT '是否使用 0-停用 1-使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of unit
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名 英文 用于大组工网关联',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `userdesc` varchar(50) DEFAULT NULL COMMENT '用户姓名 用于中文名显示',
  `state` int(11) DEFAULT NULL COMMENT '状态 1--启用 0--停用',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '职务id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间 自动生成',
  `role_id` bigint(20) DEFAULT NULL COMMENT '处室id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '管理员', '1', '1', '2014-07-17 12:59:08', '1');
