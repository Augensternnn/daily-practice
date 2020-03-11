/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 10/03/2020 19:38:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_employee
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employee`;
CREATE TABLE `tbl_employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_employee
-- ----------------------------
INSERT INTO `tbl_employee` VALUES (1, 'tom', '0', 'tom@qq.com');
INSERT INTO `tbl_employee` VALUES (3, 'jack', '0', 'jack@qq.com');
INSERT INTO `tbl_employee` VALUES (4, 'rose', '0', 'rose@qq.com');
INSERT INTO `tbl_employee` VALUES (5, 'rose', '0', 'rose@qq.com');
INSERT INTO `tbl_employee` VALUES (6, 'haha', '0', 'haha@qq.com');
INSERT INTO `tbl_employee` VALUES (7, 'haha', '0', 'haha@qq.com');
INSERT INTO `tbl_employee` VALUES (8, 'haha', '0', 'haha@qq.com');
INSERT INTO `tbl_employee` VALUES (9, 'haha', '0', 'haha@qq.com');
INSERT INTO `tbl_employee` VALUES (11, 'haha', '0', 'haha@qq.com');
INSERT INTO `tbl_employee` VALUES (12, 'haha', '0', 'haha@qq.com');
INSERT INTO `tbl_employee` VALUES (13, 'haha', '0', 'haha@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
