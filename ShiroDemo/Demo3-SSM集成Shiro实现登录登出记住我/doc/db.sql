/*
Navicat MySQL Data Transfer

Source Server         :
Source Server Version : 50518
Source Host           : localhost:3306
Source Database       : shiro_test

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2021-02-06 18:43:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限主键ID',
  `permission_name` varchar(100) NOT NULL COMMENT '权限名称',
  `description` varchar(100) NOT NULL COMMENT '权限描述',
  `state` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '权限状态，默认为1，1表示正常，0表示不正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES ('1', 'user:delete', '删除用户', '1');
INSERT INTO `tb_permission` VALUES ('2', 'user:add', '添加用户', '1');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色主键ID',
  `role_name` varchar(100) NOT NULL COMMENT '角色名字',
  `desc` varchar(100) NOT NULL COMMENT '角色描述',
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '角色状态，默认是1，1表示正常，0表示不正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', 'user', '普通用户角色', '1');

-- ----------------------------
-- Table structure for tb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_permission
-- ----------------------------
INSERT INTO `tb_role_permission` VALUES ('1', '1', '1');
INSERT INTO `tb_role_permission` VALUES ('2', '1', '2');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户注解ID',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '用户密码',
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '用户状态，1表示正常，0表示不正常，默认为1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'root', 'dbb1c112a931eeb16299d9de1f30161d', '1');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('1', '1', '1');
