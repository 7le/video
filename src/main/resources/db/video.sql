/*
Navicat MySQL Data Transfer

Source Server         : root114.215.122.158
Source Server Version : 50715
Source Host           : 114.215.122.158:3306
Source Database       : video_db

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-06-11 21:51:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `vid` int(11) NOT NULL,
  `delete_flag` int(1) NOT NULL,
  `created_at` datetime NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK_Reference_2` (`vid`),
  KEY `FK_Reference_3` (`uid`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`vid`) REFERENCES `video` (`vid`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='收藏表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` int(1) NOT NULL,
  `created_at` datetime NOT NULL,
  `creator` varchar(255) NOT NULL,
  `modifier` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `token` varchar(50) DEFAULT NULL,
  `delete_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `video_url` varchar(255) NOT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `delete_flag` int(1) NOT NULL,
  `created_at` datetime NOT NULL,
  `creator` varchar(255) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='视频表';
