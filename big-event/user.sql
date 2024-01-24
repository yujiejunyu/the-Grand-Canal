/*
 Navicat Premium Data Transfer

 Source Server         : nextconnect
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 09/01/2024 12:05:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `photo` int(0) NULL DEFAULT 0 COMMENT '电话',
  `email` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '邮箱',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '4miya', 'e10adc3949ba59abbe56e057f20f883e', 124889, '28463105', '2024-01-07 15:28:26', '2024-01-07 15:28:26');
INSERT INTO `user` VALUES (2, 'miya54', '27a79d15fb0b790386d8dbb4e3cb8e3e', 164852, '284310', '2024-01-07 15:45:07', '2024-01-07 15:45:07');
INSERT INTO `user` VALUES (3, 'miya545', '27a79d15fb0b790386d8dbb4e3cb8e3e', 164852, '284310', '2024-01-07 16:31:03', '2024-01-07 16:31:03');

SET FOREIGN_KEY_CHECKS = 1;
