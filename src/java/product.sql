/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-03-13 16:08:59
*/

create database ssm;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `products` (
  `product_id` varchar(36) NOT NULL,
  `product_name` varchar(200) DEFAULT NULL,
  `product_price` decimal(15,3) DEFAULT NULL,
  `product_type` varchar(6) DEFAULT NULL,
  `product_status` varchar(2) DEFAULT NULL,
  `product_count` int(10) DEFAULT NULL,
  `product_discount` decimal(3,2) DEFAULT NULL,
  `product_image` varchar(1000) DEFAULT NULL,
  `product_remark` varchar(1000) DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
