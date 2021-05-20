/*
Navicat MySQL Data Transfer

Source Server         : MYSQL5_3306
Source Server Version : 50518
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2021-05-20 12:10:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `name` varchar(255) NOT NULL,
  `account` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES ('zhangsan', '1000');
INSERT INTO `accounts` VALUES ('lisi', '1000');
