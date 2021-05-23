/*
Navicat MySQL Data Transfer

Source Server         : MYSQL5_3306
Source Server Version : 50518
Source Host           : localhost:3306
Source Database       : db_mp_test

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2021-05-23 20:35:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('2', 'lisi', '123456', '李四', '20', 'lisi@qq.com');
INSERT INTO `tb_user` VALUES ('3', 'wangwu', '123456', '王五', '21', 'wangwu@qq.com');
INSERT INTO `tb_user` VALUES ('4', 'zhaoliu', 'abcdef', '赵六', '22', 'zhaoliu@qq.com');
