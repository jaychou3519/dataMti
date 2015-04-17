/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.121
Source Server Version : 50611
Source Host           : 192.168.0.121:3306
Source Database       : datamti

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2014-09-26 14:19:09
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for dictype
-- ----------------------------
DROP TABLE IF EXISTS `dictype`;
CREATE TABLE `dictype` (
  `uid` varchar(50) NOT NULL COMMENT '主键',
  `text` varchar(200) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `pid` varchar(50) DEFAULT NULL,
  `seq` varchar(50) DEFAULT NULL,
  `id` varchar(50) DEFAULT NULL COMMENT '字典编码',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictype
-- ----------------------------
INSERT INTO `dictype` VALUES ('0', '资源类型', '添加资源时候的字典', '0', '0', 'zylx');
INSERT INTO `dictype` VALUES ('09cd7b6a-0675-416e-8cc1-57c434962d21', '注销', '', 'czlx', '2', '2');
INSERT INTO `dictype` VALUES ('1', '菜单', '资源类型', 'zylx', '1', 'menu');
INSERT INTO `dictype` VALUES ('1212', '人妖', '人妖测试', 'sex', '4', '1111');
INSERT INTO `dictype` VALUES ('2', '功能', '资源类型', 'zylx', '2', 'feature');
INSERT INTO `dictype` VALUES ('2ed971b9-a739-449b-8949-e5a8d30101f4', '删除', '', 'czlx', '5', '5');
INSERT INTO `dictype` VALUES ('57ea55c7-a9a5-4427-9786-8dc348a6c594', '性别', 'x', '0', '100', 'sex');
INSERT INTO `dictype` VALUES ('8683d90c-f3c5-4032-bb87-a48b15a19d01', '男', '1', 'sex', '100', '1');
INSERT INTO `dictype` VALUES ('87049017-d0f2-4e02-a823-9c330d528424', '更新', '', 'czlx', '4', '4');
INSERT INTO `dictype` VALUES ('87246f67-826f-4185-a01a-f0036162e930', '登陆', '', 'czlx', '1', '1');
INSERT INTO `dictype` VALUES ('bf5b7bfd-1b5b-443a-8289-9e2d30ab037d', '新增', '', 'czlx', '3', '3');
INSERT INTO `dictype` VALUES ('c288d7b0-fc66-42d6-9768-87d29fa32386', '操作类型', '系统操作记录日志类型', '0', '100', 'czlx');
INSERT INTO `dictype` VALUES ('d201408211434220001', 'cscasc', 'sadsad', 'sex', '123', '11231312');
INSERT INTO `dictype` VALUES ('f8841207-8f8b-4bdc-9efa-0d66a8d341a7', '女', '2', 'sex', '100', '2');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `ID` varchar(50) NOT NULL COMMENT 'ID',
  `USERID` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `USERNAME` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `OPERATION_TYPE` int(11) DEFAULT NULL COMMENT '操作类型(1：新增，2：修改，3：更新，4：删除，5：查询)',
  `TABLENAME` varchar(100) DEFAULT NULL COMMENT '操作表名',
  `TABLEID` varchar(50) DEFAULT NULL COMMENT '操作主键',
  `COMMENT` varchar(500) DEFAULT NULL COMMENT '备注',
  `CTIME` datetime DEFAULT NULL COMMENT '操作时间',
  `IP` varchar(50) DEFAULT NULL COMMENT '用户IP',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('062effee-f339-4fff-914e-bbd0c081dbba', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-07-01 14:15:05', '未分配或者内网IP   ');
INSERT INTO `log` VALUES ('07b6b656-cf28-4016-ab43-eda9cc986339', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-07-02 09:22:38', '未分配或者内网IP   ');
INSERT INTO `log` VALUES ('116fe69b-1854-4538-8e32-f0d05d045dc5', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-06-30 15:44:34', '未分配或者内网IP   ');
INSERT INTO `log` VALUES ('59467031-d029-44b9-b6a8-854db4fe9b0c', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-07-02 09:15:45', '未分配或者内网IP   ');
INSERT INTO `log` VALUES ('5c226e1e-c61e-4c5d-bc10-fabc220e6d0a', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-07-02 09:25:09', '未分配或者内网IP   ');
INSERT INTO `log` VALUES ('714c799a-2ed8-4577-bc94-4f2935a26250', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-06-30 15:52:05', '未分配或者内网IP   ');
INSERT INTO `log` VALUES ('869e13c8-2a9a-420b-bc87-98a65c42cde9', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-07-01 14:24:42', '未分配或者内网IP   ');
INSERT INTO `log` VALUES ('9ed29926-bb6c-4ff7-9436-4e3e5046aa91', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-07-28 17:01:28', '未分配或者内网IP   ');
INSERT INTO `log` VALUES ('a09b329a-a54a-40f2-9746-f69a6e93ca6b', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-07-01 11:33:03', '未分配或者内网IP   ');
INSERT INTO `log` VALUES ('b98153dd-f963-4a91-9e19-497a550fa326', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-07-28 16:33:19', '未分配或者内网IP   ');
INSERT INTO `log` VALUES ('c7367afe-73e8-48f9-b35b-a32668ae8456', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-07-02 09:13:24', '未分配或者内网IP   ');
INSERT INTO `log` VALUES ('f5afb36b-8314-4162-9a91-de2a66346f59', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-06-30 15:32:48', '未分配或者内网IP   ');
INSERT INTO `log` VALUES ('fdb3abe7-2159-4071-acff-d71cc28105d5', '0', 'jt56', '8', 'tuser', '0', '登陆成功', '2014-07-02 16:49:07', '未分配或者内网IP   ');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `pid` varchar(36) DEFAULT NULL,
  `imgurl` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_m0i6pj14hcg1mleojnl7igg6o` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('demo', 'demo', '演示样本', '0', 'demoController.do?totemplate', '0', 'icon-list');
INSERT INTO `resource` VALUES ('jsgl', '角色管理', null, '2', 'roleController.do?list', 'xtgl', null);
INSERT INTO `resource` VALUES ('m201408261629210001', '数据管理', '国家平台数据管理', '3', '', '0', 'icon-desktop');
INSERT INTO `resource` VALUES ('m201408261630210002', '车源管理', '车源管理', '1', 'vehicleresourceController.do?list', 'm201408261629210001', null);
INSERT INTO `resource` VALUES ('m201408271632430001', '货源管理', '国家平台货源信息', '2', 'cargoresourceController.do?list', 'm201408261629210001', null);
INSERT INTO `resource` VALUES ('m201409161557590001', '数据监控', '数据库性能优化监控', '12', 'druid', 'xtgl', null);
INSERT INTO `resource` VALUES ('m201409171538460001', '字典管理', '数据字典', '5', 'dictypeController.do?list', 'xtgl', null);
INSERT INTO `resource` VALUES ('rzgl', '日志管理', '00000', '4', 'logController.do?list', 'xtgl', null);
INSERT INTO `resource` VALUES ('xtgl', '系统管理', null, '0', null, '0', 'icon-desktop');
INSERT INTO `resource` VALUES ('yhgl', '用户管理', null, '3', 'userController.do?list', 'xtgl', null);
INSERT INTO `resource` VALUES ('zygl', '菜单管理', '管理系统中所有的菜单', '1', 'resourceController.do?list', 'xtgl', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `pid` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3qq9eyhwbhblv83lt270gxbik` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('admin', '超管', '超级管理员角色，拥有系统中所有的资源访问权限', '0', '0');
INSERT INTO `role` VALUES ('jsAdmin', '角色管理员', '', '2', 'admin');
INSERT INTO `role` VALUES ('role201408211509110001', 'test', 'efasf', '11', '0');
INSERT INTO `role` VALUES ('rzAdmin', '日志管理员', '日志管理员', '10', 'admin');
INSERT INTO `role` VALUES ('yhAdmin', '用户管理员', null, '3', 'admin');
INSERT INTO `role` VALUES ('zyAdmin', '资源管理员', null, '1', 'admin');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `resource_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  PRIMARY KEY (`role_id`,`resource_id`),
  KEY `FK_aunc1ssqh18meky8cxl48i4m9` (`role_id`),
  KEY `FK_18oms8g4ib4h67dqx0f3fwaed` (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('xtgl', '0');
INSERT INTO `role_resource` VALUES ('yhgl', '0');
INSERT INTO `role_resource` VALUES ('zygl', '0');
INSERT INTO `role_resource` VALUES ('demo', 'admin');
INSERT INTO `role_resource` VALUES ('jsgl', 'admin');
INSERT INTO `role_resource` VALUES ('m201408221052070001', 'admin');
INSERT INTO `role_resource` VALUES ('m201408261629210001', 'admin');
INSERT INTO `role_resource` VALUES ('m201408261630210002', 'admin');
INSERT INTO `role_resource` VALUES ('m201408271632430001', 'admin');
INSERT INTO `role_resource` VALUES ('rzgl', 'admin');
INSERT INTO `role_resource` VALUES ('u201408201337060001', 'admin');
INSERT INTO `role_resource` VALUES ('u201408211136260001', 'admin');
INSERT INTO `role_resource` VALUES ('xtgl', 'admin');
INSERT INTO `role_resource` VALUES ('yhgl', 'admin');
INSERT INTO `role_resource` VALUES ('zygl', 'admin');
INSERT INTO `role_resource` VALUES ('yhgl', 'guest');
INSERT INTO `role_resource` VALUES ('zygl', 'guest');
INSERT INTO `role_resource` VALUES ('jsgl', 'jsAdmin');
INSERT INTO `role_resource` VALUES ('xtgl', 'jsAdmin');
INSERT INTO `role_resource` VALUES ('rzgl', 'rzAdmin');
INSERT INTO `role_resource` VALUES ('xtgl', 'rzAdmin');
INSERT INTO `role_resource` VALUES ('xtgl', 'yhAdmin');
INSERT INTO `role_resource` VALUES ('yhgl', 'yhAdmin');
INSERT INTO `role_resource` VALUES ('zygl', 'zyAdmin');

-- ----------------------------
-- Table structure for testaa
-- ----------------------------
DROP TABLE IF EXISTS `testaa`;
CREATE TABLE `testaa` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testaa
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `type` int(5) DEFAULT '1' COMMENT '用户类型(0：超级管理员，1：普通成员)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', '2014-05-12 13:53:50', null, 'jt56', '123', '0');
INSERT INTO `user` VALUES ('1', '2014-05-12 13:53:50', null, 'admin1', '123', '1');
INSERT INTO `user` VALUES ('2', '2014-05-12 13:53:50', null, 'admin2', '123', '1');
INSERT INTO `user` VALUES ('3', '2014-05-12 13:53:50', null, 'admin3', '123', '1');
INSERT INTO `user` VALUES ('4', '2014-05-12 13:53:50', null, 'admin4', '123', '1');
INSERT INTO `user` VALUES ('u201408130001', null, null, '用户管理', '1', '1');
INSERT INTO `user` VALUES ('u201408130002', '2014-08-13 11:53:48', null, '支撑平台管理', '121213', '1');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `FK_30t0khk63muiwisjpp0h7e57l` (`role_id`),
  KEY `FK_mipcojqd9xymdghov18fobf7e` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('0', 'admin');
INSERT INTO `user_role` VALUES ('2', 'jsAdmin');
INSERT INTO `user_role` VALUES ('4', 'rzAdmin');
INSERT INTO `user_role` VALUES ('3', 'u201408201721040001');
INSERT INTO `user_role` VALUES ('3', 'yhAdmin');
INSERT INTO `user_role` VALUES ('u201408130001', 'yhAdmin');
INSERT INTO `user_role` VALUES ('1', 'zyAdmin');
