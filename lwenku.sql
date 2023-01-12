/*
 Navicat Premium Data Transfer

 Source Server         : mysql8-test
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:33068
 Source Schema         : lwenku

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 31/12/2022 21:48:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hon
-- ----------------------------
DROP TABLE IF EXISTS `hon`;
CREATE TABLE `hon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cover` varchar(255) DEFAULT 'imgdefault' COMMENT '封面',
  `name` varchar(255) NOT NULL COMMENT '书名',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `heat` int DEFAULT NULL COMMENT '热度',
  `date` date DEFAULT NULL COMMENT '更新日期',
  `price` varchar(32) DEFAULT NULL COMMENT '大赏',
  `recommend` int DEFAULT '0' COMMENT '推荐',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of hon
-- ----------------------------
BEGIN;
INSERT INTO `hon` VALUES (1, 'img\\86-不存在的战区-.jpg', '86-不存在的战区-', '安里アサト', NULL, '2020-09-15', '2019，2018', 2);
INSERT INTO `hon` VALUES (2, 'img\\GAMERS电玩咖！.jpg', 'GAMERS电玩咖！', '葵关南', NULL, '2020-04-21', '2018，2017', 0);
INSERT INTO `hon` VALUES (3, 'img\\Re从零开始的异世界生活.jpg', 'Re:从零开始的异世界生活', '长月达平', NULL, '2020-11-12', '2017', 0);
INSERT INTO `hon` VALUES (4, 'img\\七魔剑支配天下.jpg', '七魔剑支配天下', '宇野朴人', NULL, '2020-03-08', '2020', 0);
INSERT INTO `hon` VALUES (5, 'img\\三角的距离无限趋近零.jpg', '三角的距离无限趋近零', '岬鹭宫', NULL, '2020-10-16', '2019', 0);
INSERT INTO `hon` VALUES (6, 'img\\为美好的世界献上祝福！.jpg', '为美好的世界献上祝福！', '晓夏目', 1, '2020-01-07', '2017', 4);
INSERT INTO `hon` VALUES (7, 'img\\关于我转生变成史莱姆这档事.jpg', '关于我转生变成史莱姆这档事', '伏濑', 5, '2020-11-30', NULL, 1);
INSERT INTO `hon` VALUES (8, 'img\\关于邻家的天使大人不知不觉把我惯成了废人这档子事.jpg', '关于邻家的天使大人不知不觉把我惯成了废人这档子事', '佐伯さん', NULL, '2020-11-13', '2020', 2);
INSERT INTO `hon` VALUES (9, 'img\\刀剑神域(SAO／ALO／GGO／UW).jpg', '刀剑神域(SAO／ALO／GGO／UW)', '川原砾', NULL, '2020-11-27', '2019，2018，2017', 0);
INSERT INTO `hon` VALUES (10, 'img\\刮掉胡子的我与捡到的女高中生.jpg', '刮掉胡子的我与捡到的女高中生', 'しめさば', NULL, '2020-12-02', '2019', 0);
INSERT INTO `hon` VALUES (11, 'img\\哥布林杀手.jpg', '哥布林杀手', '蜗牛くも', NULL, '2020-08-06', '2017', 1);
INSERT INTO `hon` VALUES (12, 'img\\因为不是真正的伙伴而被逐出勇者队伍，流落到边境展开慢活人生.jpg', '因为不是真正的伙伴而被逐出勇者队伍，流落到边境展开慢活人生', 'ざっぽん', 1, '2020-12-04', NULL, 0);
INSERT INTO `hon` VALUES (13, 'img\\在地下城寻求邂逅是否搞错了什么.jpg', '在地下城寻求邂逅是否搞错了什么', '大森藤野', 7, '2020-11-12', '2018', 0);
INSERT INTO `hon` VALUES (14, 'img\\天才王子的赤字国家重生术.jpg', '天才王子的赤字国家重生术', '鸟羽彻', 4, '2020-12-04', NULL, 0);
INSERT INTO `hon` VALUES (15, 'img\\如果有妹妹就好了.jpg', '如果有妹妹就好了', '平坂读', NULL, '2020-12-03', '2018', 0);
INSERT INTO `hon` VALUES (16, 'img\\就算是有点色色的三姊妹，你也愿意娶回家吗？.jpg', '就算是有点色色的三姊妹，你也愿意娶回家吗？', '浅冈旭', 2, '2020-12-04', NULL, 0);
INSERT INTO `hon` VALUES (17, 'img\\平凡职业造就世界最强.jpg', '平凡职业造就世界最强', '白米良', 8, '2020-12-02', NULL, 0);
INSERT INTO `hon` VALUES (18, 'img\\弱势角色友崎君.jpg', '弱势角色友崎君', '屋久悠树', NULL, '2020-08-30', '2020，2019，2018，2017', 1);
INSERT INTO `hon` VALUES (19, 'img\\我们的重制人生.jpg', '我们的重制人生', '木绪なち', NULL, '2020-11-08', '2019，2018', 0);
INSERT INTO `hon` VALUES (20, 'img\\新约 魔法禁书目录.jpg', '新约 魔法禁书目录', '镰池和马', NULL, '2020-07-12', '2019，2017', 0);
INSERT INTO `hon` VALUES (21, 'img\\旋律、抒情、偶像、魔法.jpg', '旋律、抒情、偶像、魔法', '石川博品', NULL, '2019-06-24', '2017', 0);
INSERT INTO `hon` VALUES (22, 'img\\无尽连锁.jpg', '无尽连锁', '海道左近', NULL, '2020-09-22', '2018', 0);
INSERT INTO `hon` VALUES (23, 'img\\月与莱卡与吸血公主.jpg', '月与莱卡与吸血公主', '牧野圭佑', NULL, '2020-08-19', '2018', 0);
INSERT INTO `hon` VALUES (24, 'img\\欢迎来到实力至上主义的教室.jpg', '欢迎来到实力至上主义的教室', '衣笠彰梧', 3, '2020-12-02', '2020，2019', 0);
INSERT INTO `hon` VALUES (25, 'img\\爆肝工程师的异世界狂想曲.jpg', '爆肝工程师的异世界狂想曲', '爱七ひろ', 6, '2020-12-03', NULL, 0);
INSERT INTO `hon` VALUES (26, 'img\\继母的拖油瓶是我的前女友.jpg', '继母的拖油瓶是我的前女友', '纸城境介', NULL, '2020-10-08', '2020', 0);
INSERT INTO `hon` VALUES (27, 'img\\这份恋情，与其未来。.jpg', '这份恋情，与其未来。', '森桥宾果', NULL, '2020-02-16', '2017', 0);
INSERT INTO `hon` VALUES (28, 'img\\青春猪头少年不会梦到兔女郎学姊.jpg', '青春猪头少年不会梦到兔女郎学姊', '鸭志田一', NULL, '2020-12-02', '2020', 0);
INSERT INTO `hon` VALUES (29, 'img\\青梅竹马绝对不会输的恋爱喜剧.jpg', '青梅竹马绝对不会输的恋爱喜剧', '二丸修一', NULL, '2020-01-25', '2020', 0);
INSERT INTO `hon` VALUES (30, 'img\\食锈末世录.jpg', '食锈末世录', '瘤久保慎司', NULL, '2020-07-09', '2019', 0);
INSERT INTO `hon` VALUES (31, 'img\\魔女之旅.jpg', '魔女之旅', '白石定规', 10, '2020-12-02', NULL, 0);
INSERT INTO `hon` VALUES (32, 'img\\魔导具师妲莉亚永不妥协～从今天开始的自由职人生活～.jpg', '魔导具师妲莉亚永不妥协～从今天开始的自由职人生活～', '甘岸久弥', 9, '2020-12-03', NULL, 0);
INSERT INTO `hon` VALUES (33, 'img\\龙王的工作！.jpg', '龙王的工作！', '白鸟士郎', NULL, '2020-08-28', '2020，2019，2018，2017', 0);
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `nameZh` varchar(255) DEFAULT NULL COMMENT '中文名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'admin', '管理员');
INSERT INTO `role` VALUES (2, 'user', '普通用户');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'test', '123456');
INSERT INTO `user` VALUES (20, 'ag', '123');
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL COMMENT 'userId',
  `rid` int DEFAULT NULL COMMENT 'roleId',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (6, 20, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
