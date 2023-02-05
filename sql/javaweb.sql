/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : javaweb

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 18/12/2021 13:11:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for firstcase
-- ----------------------------
DROP TABLE IF EXISTS `firstcase`;
CREATE TABLE `firstcase`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `gender` bit(1) NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '籍贯',
  `qq` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'QQ号',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of firstcase
-- ----------------------------
INSERT INTO `firstcase` VALUES (46, '肖', b'1', '陕西', '', '97898808@qq.com');
INSERT INTO `firstcase` VALUES (47, '葛', b'1', '陕西', '7869466', '97898809@qq.com');
INSERT INTO `firstcase` VALUES (48, '张', b'0', '北京', '7869467', '97898810@qq.com');
INSERT INTO `firstcase` VALUES (49, '姜', b'0', '北京', '7869468', '97898811@qq.com');
INSERT INTO `firstcase` VALUES (51, '胡', b'1', '北京', '7869470', '97898813@qq.com');
INSERT INTO `firstcase` VALUES (52, '安', b'0', '北京', '7869471', '97898814@qq.com');
INSERT INTO `firstcase` VALUES (53, '邓', b'1', '北京', '7869472', '97898815@qq.com');
INSERT INTO `firstcase` VALUES (54, '庞', b'0', '北京', '7869473', '97898816@qq.com');
INSERT INTO `firstcase` VALUES (55, '唐', b'1', '北京', '7869474', '97898817@qq.com');
INSERT INTO `firstcase` VALUES (56, '宋', b'1', '陕西', '7869475', '97898818@qq.com');
INSERT INTO `firstcase` VALUES (57, '任', b'1', '北京', '7869476', '97898819@qq.com');
INSERT INTO `firstcase` VALUES (58, '谷', b'0', '北京', '7869477', '97898820@qq.com');
INSERT INTO `firstcase` VALUES (59, '袁', b'1', '北京', '7869478', '97898821@qq.com');
INSERT INTO `firstcase` VALUES (82, '学琴', b'0', '上海', '78453', '786@qq.com');
INSERT INTO `firstcase` VALUES (83, '芳姐', b'1', '北京', '1213456789', '12345678@qq.com');

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES (1, '河南');
INSERT INTO `province` VALUES (2, '河北');
INSERT INTO `province` VALUES (3, '湖南');
INSERT INTO `province` VALUES (4, '湖北');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'dps', '54188');
INSERT INTO `user` VALUES (3, 'Hht', '020202');
INSERT INTO `user` VALUES (4, '白冬阳', '020202');

SET FOREIGN_KEY_CHECKS = 1;
