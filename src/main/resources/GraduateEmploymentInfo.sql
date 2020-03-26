/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : GraduateEmploymentInfo

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 26/03/2020 13:21:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `area_id` int(10) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(100) NOT NULL,
  `parent_id` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`area_id`),
  KEY `tb_area_parent` (`parent_id`),
  CONSTRAINT `tb_area_parent` FOREIGN KEY (`parent_id`) REFERENCES `tb_area` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
BEGIN;
INSERT INTO `tb_area` VALUES (4, '四川', NULL, '2020-03-06 13:39:59');
INSERT INTO `tb_area` VALUES (5, '重庆', NULL, '2020-03-06 13:40:14');
INSERT INTO `tb_area` VALUES (6, '成都', 4, '2020-03-06 13:46:34');
INSERT INTO `tb_area` VALUES (8, '河北', NULL, '2020-03-06 23:35:56');
INSERT INTO `tb_area` VALUES (9, '石家庄', 8, '2020-03-06 23:36:40');
INSERT INTO `tb_area` VALUES (10, '广东', NULL, '2020-03-06 23:36:51');
INSERT INTO `tb_area` VALUES (11, '广州', 10, '2020-03-06 23:36:59');
INSERT INTO `tb_area` VALUES (12, '浙江', NULL, '2020-03-06 23:37:21');
INSERT INTO `tb_area` VALUES (13, '杭州', 12, '2020-03-06 23:37:38');
INSERT INTO `tb_area` VALUES (14, '湖北', NULL, '2020-03-06 23:38:06');
INSERT INTO `tb_area` VALUES (15, '武汉', 14, '2020-03-06 23:38:17');
INSERT INTO `tb_area` VALUES (16, '江苏', NULL, '2020-03-06 23:38:33');
INSERT INTO `tb_area` VALUES (17, '南京', 16, '2020-03-06 23:38:45');
INSERT INTO `tb_area` VALUES (18, '辽宁', NULL, '2020-03-06 23:39:21');
INSERT INTO `tb_area` VALUES (19, '沈阳', 18, '2020-03-06 23:39:40');
INSERT INTO `tb_area` VALUES (20, '湖南', NULL, '2020-03-06 23:39:55');
INSERT INTO `tb_area` VALUES (21, '长沙', 20, '2020-03-06 23:40:03');
INSERT INTO `tb_area` VALUES (22, '河南', NULL, '2020-03-06 23:40:22');
INSERT INTO `tb_area` VALUES (23, '郑州', 22, '2020-03-06 23:40:38');
INSERT INTO `tb_area` VALUES (24, '山东', NULL, '2020-03-06 23:40:48');
INSERT INTO `tb_area` VALUES (25, '济南', 24, '2020-03-06 23:41:01');
INSERT INTO `tb_area` VALUES (26, '黑龙江', NULL, '2020-03-06 23:41:18');
INSERT INTO `tb_area` VALUES (27, '哈尔滨', 26, '2020-03-06 23:41:30');
INSERT INTO `tb_area` VALUES (28, '吉林', NULL, '2020-03-06 23:41:39');
INSERT INTO `tb_area` VALUES (29, '长春', 28, '2020-03-06 23:41:51');
INSERT INTO `tb_area` VALUES (30, '陕西', NULL, '2020-03-06 23:42:04');
INSERT INTO `tb_area` VALUES (31, '西安', 30, '2020-03-06 23:42:28');
INSERT INTO `tb_area` VALUES (32, '福建', NULL, '2020-03-06 23:42:40');
INSERT INTO `tb_area` VALUES (33, '福州', 32, '2020-03-06 23:42:50');
INSERT INTO `tb_area` VALUES (34, '安徽', NULL, '2020-03-06 23:43:04');
INSERT INTO `tb_area` VALUES (35, '合肥', 34, '2020-03-06 23:43:12');
INSERT INTO `tb_area` VALUES (36, '江西', NULL, '2020-03-06 23:43:22');
INSERT INTO `tb_area` VALUES (37, '南昌', 36, '2020-03-06 23:43:38');
INSERT INTO `tb_area` VALUES (38, '云南', NULL, '2020-03-06 23:43:56');
INSERT INTO `tb_area` VALUES (39, '昆明', 38, '2020-03-06 23:44:10');
INSERT INTO `tb_area` VALUES (40, '内蒙古', NULL, '2020-03-06 23:44:22');
INSERT INTO `tb_area` VALUES (41, '呼和浩特', 40, '2020-03-06 23:44:50');
INSERT INTO `tb_area` VALUES (42, '广西', NULL, '2020-03-06 23:45:00');
INSERT INTO `tb_area` VALUES (43, '南宁', 42, '2020-03-06 23:45:15');
INSERT INTO `tb_area` VALUES (44, '山西', NULL, '2020-03-06 23:45:33');
INSERT INTO `tb_area` VALUES (45, '太原', 44, '2020-03-06 23:45:45');
INSERT INTO `tb_area` VALUES (46, '新疆', NULL, '2020-03-06 23:45:54');
INSERT INTO `tb_area` VALUES (47, '乌鲁木齐', 46, '2020-03-06 23:46:07');
INSERT INTO `tb_area` VALUES (48, '贵州', NULL, '2020-03-06 23:46:16');
INSERT INTO `tb_area` VALUES (49, '贵阳', 48, '2020-03-06 23:46:28');
INSERT INTO `tb_area` VALUES (50, '甘肃', NULL, '2020-03-06 23:46:38');
INSERT INTO `tb_area` VALUES (51, '兰州', 50, '2020-03-06 23:46:53');
INSERT INTO `tb_area` VALUES (52, '青海', NULL, '2020-03-06 23:47:04');
INSERT INTO `tb_area` VALUES (53, '西宁', 52, '2020-03-06 23:47:15');
INSERT INTO `tb_area` VALUES (54, '海南', NULL, '2020-03-06 23:47:27');
INSERT INTO `tb_area` VALUES (55, '海口', 54, '2020-03-06 23:47:39');
INSERT INTO `tb_area` VALUES (56, '宁夏', NULL, '2020-03-06 23:47:57');
INSERT INTO `tb_area` VALUES (57, '银川', 56, '2020-03-06 23:48:10');
INSERT INTO `tb_area` VALUES (58, '西藏', NULL, '2020-03-06 23:48:36');
INSERT INTO `tb_area` VALUES (59, '拉萨', 58, '2020-03-06 23:48:46');
INSERT INTO `tb_area` VALUES (60, '台湾', NULL, '2020-03-06 23:49:17');
INSERT INTO `tb_area` VALUES (61, '台北', 60, '2020-03-06 23:49:25');
INSERT INTO `tb_area` VALUES (62, '北京市', NULL, '2020-03-06 23:50:22');
INSERT INTO `tb_area` VALUES (63, '上海市', NULL, '2020-03-06 23:50:34');
INSERT INTO `tb_area` VALUES (64, '天津市', NULL, '2020-03-06 23:50:49');
INSERT INTO `tb_area` VALUES (65, '深圳', 10, '2020-03-06 23:52:25');
INSERT INTO `tb_area` VALUES (66, '香港', NULL, '2020-03-07 00:00:09');
INSERT INTO `tb_area` VALUES (67, '澳门', NULL, '2020-03-07 00:00:16');
COMMIT;

-- ----------------------------
-- Table structure for tb_class_grade
-- ----------------------------
DROP TABLE IF EXISTS `tb_class_grade`;
CREATE TABLE `tb_class_grade` (
  `class_id` int(10) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(100) NOT NULL,
  `specialty_id` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `admin_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `tb_class_grade_tb_specialty` (`specialty_id`),
  KEY `tb_class_grade_tb_person_info` (`admin_id`),
  CONSTRAINT `tb_class_grade_tb_person_info` FOREIGN KEY (`admin_id`) REFERENCES `tb_person_info` (`person_id`),
  CONSTRAINT `tb_class_grade_tb_specialty` FOREIGN KEY (`specialty_id`) REFERENCES `tb_specialty` (`specialty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for tb_college
-- ----------------------------
DROP TABLE IF EXISTS `tb_college`;
CREATE TABLE `tb_college` (
  `college_id` int(10) NOT NULL AUTO_INCREMENT,
  `college_name` varchar(100) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `admin_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`college_id`),
  KEY `tb_college_tb_person_info` (`admin_id`),
  CONSTRAINT `tb_college_tb_person_info` FOREIGN KEY (`admin_id`) REFERENCES `tb_person_info` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for tb_employment_information
-- ----------------------------
DROP TABLE IF EXISTS `tb_employment_information`;
CREATE TABLE `tb_employment_information` (
  `information_id` int(10) NOT NULL AUTO_INCREMENT,
  `student_num` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `class_id` int(10) NOT NULL,
  `area_id` int(10) NOT NULL,
  `unit_id` int(10) NOT NULL,
  `salary` varchar(10) NOT NULL,
  `employment_way_id` int(10) NOT NULL,
  `msg` varchar(10000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `gender` int(1) NOT NULL,
  `college_id` int(10) NOT NULL,
  `specialty_id` int(10) NOT NULL,
  PRIMARY KEY (`information_id`),
  UNIQUE KEY `student_num_qurey` (`student_num`) USING BTREE,
  KEY `tb_employment_information_tb_class_grade` (`class_id`),
  KEY `tb_employment_information_tb_area` (`area_id`),
  KEY `tb_employment_information_tb_unit_kind` (`unit_id`),
  KEY `tb_employment_information_tb_employment_way` (`employment_way_id`),
  KEY `tb_employment_information_tb_college` (`college_id`) USING BTREE,
  KEY `tb_employment_information_tb_specialty` (`specialty_id`),
  CONSTRAINT `tb_employment_information_tb_area` FOREIGN KEY (`area_id`) REFERENCES `tb_area` (`area_id`),
  CONSTRAINT `tb_employment_information_tb_class_grade` FOREIGN KEY (`class_id`) REFERENCES `tb_class_grade` (`class_id`),
  CONSTRAINT `tb_employment_information_tb_college` FOREIGN KEY (`college_id`) REFERENCES `tb_college` (`college_id`),
  CONSTRAINT `tb_employment_information_tb_employment_way` FOREIGN KEY (`employment_way_id`) REFERENCES `tb_employment_way` (`employment_way_id`),
  CONSTRAINT `tb_employment_information_tb_specialty` FOREIGN KEY (`specialty_id`) REFERENCES `tb_specialty` (`specialty_id`),
  CONSTRAINT `tb_employment_information_tb_unit_kind` FOREIGN KEY (`unit_id`) REFERENCES `tb_unit_kind` (`unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1033 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for tb_employment_way
-- ----------------------------
DROP TABLE IF EXISTS `tb_employment_way`;
CREATE TABLE `tb_employment_way` (
  `employment_way_id` int(10) NOT NULL AUTO_INCREMENT,
  `vay_name` varchar(100) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`employment_way_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_employment_way
-- ----------------------------
BEGIN;
INSERT INTO `tb_employment_way` VALUES (1, '学校双选会', '2020-03-06 13:57:09');
INSERT INTO `tb_employment_way` VALUES (2, '互联网招聘平台', '2020-03-06 13:57:27');
INSERT INTO `tb_employment_way` VALUES (3, '个人寻找', '2020-03-06 13:57:45');
INSERT INTO `tb_employment_way` VALUES (4, '朋友推荐', '2020-03-06 13:57:59');
COMMIT;

-- ----------------------------
-- Table structure for tb_organization_num
-- ----------------------------
DROP TABLE IF EXISTS `tb_organization_num`;
CREATE TABLE `tb_organization_num` (
  `num_id` int(10) NOT NULL AUTO_INCREMENT,
  `sum` int(10) NOT NULL,
  `class_id` int(10) DEFAULT NULL,
  `college_id` int(10) DEFAULT NULL,
  `specialty_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`num_id`),
  KEY `tb_organization_num_tb_class_grade` (`class_id`),
  KEY `tb_organization_num_tb_college` (`college_id`),
  KEY `tb_organization_num_tb_specialty` (`specialty_id`),
  CONSTRAINT `tb_organization_num_tb_class_grade` FOREIGN KEY (`class_id`) REFERENCES `tb_class_grade` (`class_id`),
  CONSTRAINT `tb_organization_num_tb_college` FOREIGN KEY (`college_id`) REFERENCES `tb_college` (`college_id`),
  CONSTRAINT `tb_organization_num_tb_specialty` FOREIGN KEY (`specialty_id`) REFERENCES `tb_specialty` (`specialty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for tb_person_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_person_info`;
CREATE TABLE `tb_person_info` (
  `person_id` int(10) NOT NULL AUTO_INCREMENT,
  `enable_Status` int(2) DEFAULT '0',
  `person_name` varchar(100) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `college_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_person_info
-- ----------------------------
BEGIN;
INSERT INTO `tb_person_info` VALUES (3, 2, '超级管理员', '2020-03-06 19:27:50', 'admin1', 'admin', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_specialty
-- ----------------------------
DROP TABLE IF EXISTS `tb_specialty`;
CREATE TABLE `tb_specialty` (
  `specialty_id` int(10) NOT NULL AUTO_INCREMENT,
  `specialty_name` varchar(100) NOT NULL,
  `college_id` int(10) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`specialty_id`),
  KEY `tb_specialty_tb_college` (`college_id`),
  CONSTRAINT `tb_specialty_tb_college` FOREIGN KEY (`college_id`) REFERENCES `tb_college` (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for tb_unit_kind
-- ----------------------------
DROP TABLE IF EXISTS `tb_unit_kind`;
CREATE TABLE `tb_unit_kind` (
  `unit_id` int(10) NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(100) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_unit_kind
-- ----------------------------
BEGIN;
INSERT INTO `tb_unit_kind` VALUES (1, '国企', '2020-03-06 13:56:23');
INSERT INTO `tb_unit_kind` VALUES (2, '私企', '2020-03-06 13:56:29');
INSERT INTO `tb_unit_kind` VALUES (3, '公务员', '2020-03-06 13:56:36');
INSERT INTO `tb_unit_kind` VALUES (4, '事业单位', '2020-03-06 13:56:43');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
