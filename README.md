# Spring-shiro-jwt-Demo

## 前言

SpringBoot的一个前后端分离的Demo，同时后端整合了Shiro+Jwt+Redis的安全框架。

通过一个demo进一步了解了前后端分离的架构思想以及安全框架shiro的运行机制。

## 后端开发

### 主要工具

- SpringBoot
- MyBatisPlus
- Shiro
- Redis

### 新建数据库

```sql
/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : community_market

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2022-03-25 11:11:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for system_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_permission`;
CREATE TABLE `system_permission` (
  `id` bigint NOT NULL,
  `name` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限名称',
  `description` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限介绍',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_system_permission_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='权限';

-- ----------------------------
-- Records of system_permission
-- ----------------------------
INSERT INTO `system_permission` VALUES ('1506480475219300352', 'index', '首页', '2022-03-23 11:58:29', '2022-03-23 11:58:29', '0');
INSERT INTO `system_permission` VALUES ('1506480475231883264', 'modifyUser', '修改用户信息', '2022-03-23 11:58:29', '2022-03-23 11:58:29', '0');

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `id` bigint NOT NULL,
  `name` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色介绍',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_role_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户角色';

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES ('1506480475194134528', 'admin', '超级管理员', '2022-03-23 11:58:29', '2022-03-23 11:58:29', '0');
INSERT INTO `system_role` VALUES ('1506480475206717440', 'normal', '普通用户', '2022-03-23 11:58:29', '2022-03-23 11:58:29', '0');

-- ----------------------------
-- Table structure for system_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_role_permission`;
CREATE TABLE `system_role_permission` (
  `id` bigint NOT NULL,
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `permission_id` bigint NOT NULL COMMENT '权限ID',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_system_role_permission_rel_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色权限关联表';

-- ----------------------------
-- Records of system_role_permission
-- ----------------------------
INSERT INTO `system_role_permission` VALUES ('1506480475315769344', '1506480475194134528', '1506480475219300352', '2022-03-23 11:58:29', '2022-03-23 11:58:29', '0');
INSERT INTO `system_role_permission` VALUES ('1506480475328352256', '1506480475194134528', '1506480475231883264', '2022-03-23 11:58:29', '2022-03-23 11:58:29', '0');
INSERT INTO `system_role_permission` VALUES ('1506480475340935168', '1506480475206717440', '1506480475219300352', '2022-03-23 11:58:29', '2022-03-23 11:58:29', '0');

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` bigint NOT NULL,
  `nickname` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `username` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `email` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `gender` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别 male/female',
  `description` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户简介',
  `avatar` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `salt` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '盐',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL,
  `del_flag` tinyint(1) NOT NULL DEFAULT '0',
  `status` int NOT NULL DEFAULT '0' COMMENT '用户状态 0:正常 1:暂时冻结',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_pk` (`username`),
  UNIQUE KEY `t_user_pk_2` (`email`),
  UNIQUE KEY `t_user_pk_4` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1506476260283518976', null, 'admin', '870a89140c96275e063dec545692926b', null, null, null, null, null, '5AmQ/67mDGqJgw9fcXzCkQ==', '2022-03-23 11:41:44', '2022-03-23 11:41:44', '0', '0');

-- ----------------------------
-- Table structure for system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role` (
  `id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_role_id_uindex` (`id`),
  KEY `t_user_role_user_id_role_id_index` (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户权限关联表';

-- ----------------------------
-- Records of system_user_role
-- ----------------------------
INSERT INTO `system_user_role` VALUES ('150647626028451949', '1506476260283518976', '1506480475194134528', '2022-03-23 13:04:17', '2022-03-23 13:04:20', '0');

```
### 修改配置文件数据库以及Redis的链接
### 直接启动
