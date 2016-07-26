/*
Navicat MySQL Data Transfer

Source Server         : 114.215.145.215
Source Server Version : 50539
Source Host           : 114.215.145.215:3306
Source Database       : wowbear

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2015-08-03 14:20:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` mediumint(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `acount` varchar(45) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT '',
  `password` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL COMMENT '�ֻ�����',
  `qq` varchar(45) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `user_type` int(2) DEFAULT '0',
  `login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `disabled` int(2) DEFAULT '0',
  `birthday` date DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `signature` varchar(200) DEFAULT NULL COMMENT 'ǩ��',
  `city` varchar(45) DEFAULT NULL,
  `photoURL` varchar(45) DEFAULT NULL COMMENT 'ͼƬurl',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='�û���';


-- ----------------------------
-- Table structure for `friends`
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `friendID` int(11) DEFAULT NULL,
  `nickName` varchar(255) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `isInBlackList` int(11) DEFAULT '0',
  `createBy` int(11) DEFAULT NULL,
  `updateBy` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `group_members`
-- ----------------------------
DROP TABLE IF EXISTS `group_members`;
CREATE TABLE `group_members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupID` int(11) DEFAULT NULL,
  `isNotify` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `groupName` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL COMMENT '0',
  `joinTime` datetime DEFAULT NULL,
  `leaveTime` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `isAccept` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='�û�Ⱥ���';

-- ----------------------------
-- Table structure for `groups`
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(45) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `ownerID` int(11) DEFAULT NULL,
  `ownerName` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL COMMENT '1 ',
  `describ` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `expireTime` datetime DEFAULT NULL,
  `huanGroupID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='Ⱥ���';

