/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : 2020personnel

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2020-06-29 15:58:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for db_baoming_info
-- ----------------------------
DROP TABLE IF EXISTS `db_baoming_info`;
CREATE TABLE `db_baoming_info` (
  `id` varchar(60) NOT NULL COMMENT '编号',
  `staffName` varchar(40) DEFAULT NULL COMMENT '员工姓名',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `nativePlace` varchar(40) DEFAULT NULL COMMENT '籍贯',
  `homeAddress` varchar(200) DEFAULT NULL COMMENT '家庭住址',
  `phone` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `inTime` varchar(40) DEFAULT NULL COMMENT '入职时间',
  `workPost` varchar(50) DEFAULT NULL COMMENT '工作岗位',
  `statement` varchar(255) DEFAULT NULL,
  `remarks` text COMMENT '反馈意见',
  `mianshi` double unsigned zerofill DEFAULT NULL,
  `bishi` double unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_baoming_info
-- ----------------------------
INSERT INTO `db_baoming_info` VALUES ('04EAD5F31DC34AF3921862E5FD120F04', '李赣', '男', '四川', '武汉', '6324', '2020-06-09', '测试', '冲了之后非常开心', '死人s', '0000000000000000000050', '0000000000000000000100');
INSERT INTO `db_baoming_info` VALUES ('B808016B46A5467A9577553E3B0CBEEB', '章乐', '男', 'CHINA', '中国', '13548286491', '2020-06-02', '测试', '无', '死', '0000000000000000000000', '0000000000000000000000');
INSERT INTO `db_baoming_info` VALUES ('CB9E5429319B40B6B789337252E1439E', '孙笑川', '男', '啊实打实的', '去问我去饿', '987', '2020-06-25', '开发', '无', '新津皇帝', '0000000000000000000065', '0000000000000000000070');

-- ----------------------------
-- Table structure for db_check_work_info
-- ----------------------------
DROP TABLE IF EXISTS `db_check_work_info`;
CREATE TABLE `db_check_work_info` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `staff_id` varchar(40) DEFAULT NULL COMMENT '员工id',
  `kaoqing_type` varchar(20) DEFAULT NULL COMMENT '考勤类型',
  `kaoqing_time` varchar(40) DEFAULT NULL COMMENT '考勤时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_check_work_info
-- ----------------------------
INSERT INTO `db_check_work_info` VALUES ('268FF0F90B2E43449624F3AC245C5F33', '4EB45FB799C34A9A89D0B14A2911CD9A', '早退', '2020-02-24', '提前下班');
INSERT INTO `db_check_work_info` VALUES ('F6A49F221AE748A0AABDC36C252FA9A5', '4EB45FB799C34A9A89D0B14A2911CD9A', '迟到', '2020-02-24', '');

-- ----------------------------
-- Table structure for db_compile_info
-- ----------------------------
DROP TABLE IF EXISTS `db_compile_info`;
CREATE TABLE `db_compile_info` (
  `id` varchar(40) NOT NULL,
  `compileType` varchar(255) NOT NULL,
  `compileName` varchar(255) NOT NULL,
  `compileNumber` int(11) NOT NULL,
  `compileTime` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_compile_info
-- ----------------------------
INSERT INTO `db_compile_info` VALUES ('1234564556', '行政编制', '经理编制111', '2', '2020-06-28');
INSERT INTO `db_compile_info` VALUES ('3692366DE4B542699ACF9CBABB0D9076', '员额编制', '主任编制', '1', '2020-06-16');
INSERT INTO `db_compile_info` VALUES ('5565895598', '员额编制', '副经理编制', '5', '2020-06-28');

-- ----------------------------
-- Table structure for db_dept_info
-- ----------------------------
DROP TABLE IF EXISTS `db_dept_info`;
CREATE TABLE `db_dept_info` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `dept_name` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `remark` varchar(40) DEFAULT NULL COMMENT '备注',
  `deptSize` int(11) DEFAULT NULL,
  `deptFundForm` varchar(140) DEFAULT NULL,
  `pId` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parentId` (`pId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_dept_info
-- ----------------------------
INSERT INTO `db_dept_info` VALUES ('03A0A5441A52444A8E231B46E6DF99A7', '嗷嗷撒所', '订单', '0', '订单', 'CB8F5953693D4E2DA1D897CEB884C41C');
INSERT INTO `db_dept_info` VALUES ('2F7B32A083E649B5AAFDAAF3CDD9455B', '嗷嗷撒所', 'gfd', '0', '订单', 'D84D3FC430104F068B7BCD8EE0D4722A');
INSERT INTO `db_dept_info` VALUES ('90230B2376B0468BA24495D1670EE3B2', '教务处', '教务处', '20', '学校发放', null);

-- ----------------------------
-- Table structure for db_file_control_info
-- ----------------------------
DROP TABLE IF EXISTS `db_file_control_info`;
CREATE TABLE `db_file_control_info` (
  `id` varchar(100) NOT NULL COMMENT 'id',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `type` varchar(40) DEFAULT NULL COMMENT '类型',
  `content` longtext NOT NULL COMMENT '内容',
  `author` varchar(40) NOT NULL COMMENT '作者',
  `time` varchar(40) NOT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_file_control_info
-- ----------------------------
INSERT INTO `db_file_control_info` VALUES ('ZhupiYKW', 'ZhupiYKW', 'fun', 'fuckfuckfuck', 'zxb', '2019-04-06 23:15:00');
INSERT INTO `db_file_control_info` VALUES ('ZhupiYKW1', 'ZhupiYKW1', 'fun', 'fuckfusdfsdfsdfsdfckfuck', 'zxb', '2019-04-07 23:15:00');

-- ----------------------------
-- Table structure for db_fl_info
-- ----------------------------
DROP TABLE IF EXISTS `db_fl_info`;
CREATE TABLE `db_fl_info` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `flname` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `remark` longtext NOT NULL COMMENT '内容',
  `author` varchar(40) DEFAULT NULL COMMENT '作者',
  `time` varchar(40) DEFAULT NULL COMMENT '时间',
  `type` varchar(40) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_fl_info
-- ----------------------------
INSERT INTO `db_fl_info` VALUES ('CCDAFB3026A5486C89BAFE94EE751461', '世纪东方看', 'SDK九分裤山东济南\r\n上岛咖啡江南时代看来分\r\n四等分宽见你算了的开发', '山东矿机', '2020-06-28 19:13:03', 'text');
INSERT INTO `db_fl_info` VALUES ('DBC1D1B7453D471C9FDEE6A4CAD321CC', '财务ff部', 'Neighbors\r\nKnowing them:  four houses on each floor, 2 are small companies,1 live for 12 years\r\nSee them:  high school, every morning ,in elevator\r\nRelationship : good, father likes to share idea with man\r\nHelpful: No experience of helping each other\r\nProblems: no', 'ZXB', '2020-06-09 13:10:30', 'text');
INSERT INTO `db_fl_info` VALUES ('FAFB603EFC574795924E273C64432010', 'jskd', 'sdffsadfsdfasdfasdfasdf', 'ZXB', '2020-06-28 19:11:10', 'ff');

-- ----------------------------
-- Table structure for db_job_info
-- ----------------------------
DROP TABLE IF EXISTS `db_job_info`;
CREATE TABLE `db_job_info` (
  `id` varchar(40) NOT NULL,
  `jobName` varchar(255) NOT NULL,
  `deptId` varchar(40) NOT NULL,
  `compileId` varchar(40) NOT NULL,
  `jobTime` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `deptId` (`deptId`),
  KEY `compileId` (`compileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_job_info
-- ----------------------------
INSERT INTO `db_job_info` VALUES ('07A87ADDB7F243B3B97FFB0798289295', '天皇', '2F7B32A083E649B5AAFDAAF3CDD9455B', '3692366DE4B542699ACF9CBABB0D9076', '2020-06-28');
INSERT INTO `db_job_info` VALUES ('1BCB47C582E74FD99C866866C5E7FAEB', '副主任', '9843C340287140C18F55C3C5BD27AB25', '3692366DE4B542699ACF9CBABB0D9076', '2020-06-24');
INSERT INTO `db_job_info` VALUES ('A7C2150F9E0C4E8BAF7FADB5AA8A1FF5', '主任', '9843C340287140C18F55C3C5BD27AB25', '1234564556', '2020-07-02');

-- ----------------------------
-- Table structure for db_model_info
-- ----------------------------
DROP TABLE IF EXISTS `db_model_info`;
CREATE TABLE `db_model_info` (
  `id` varchar(40) NOT NULL,
  `mname` varchar(255) NOT NULL DEFAULT '',
  `num` char(2) NOT NULL DEFAULT '',
  `age` char(2) NOT NULL DEFAULT '',
  `name` char(2) NOT NULL DEFAULT '',
  `gender` char(2) NOT NULL DEFAULT '',
  `telnum` char(2) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_model_info
-- ----------------------------
INSERT INTO `db_model_info` VALUES ('B16DCAC286184043A2F7A792C71CF2E8', '基本信息采集', '是', '否', '是', '是', '是');

-- ----------------------------
-- Table structure for db_salary_detail
-- ----------------------------
DROP TABLE IF EXISTS `db_salary_detail`;
CREATE TABLE `db_salary_detail` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `salary_id` varchar(40) DEFAULT NULL COMMENT '工资条ID',
  `price` double DEFAULT NULL COMMENT '金额',
  `name` varchar(40) DEFAULT NULL COMMENT '名称',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_salary_detail
-- ----------------------------
INSERT INTO `db_salary_detail` VALUES ('29DC51774ED04647800719F7DB2E992A', '5EA4A5978DDC482184085E07890516F0', '100', '奖金', null);
INSERT INTO `db_salary_detail` VALUES ('417B64BF79D149B29C576EC47A4955CF', '94401460745A43C39CD0605ADB3D662E', '10000', '年终奖', null);
INSERT INTO `db_salary_detail` VALUES ('663E29095964474FB21C00AF3B0F6E4F', '94401460745A43C39CD0605ADB3D662E', '1000', '项目奖金', null);
INSERT INTO `db_salary_detail` VALUES ('70AC25ECA0954963A8A02170950A13BD', '94401460745A43C39CD0605ADB3D662E', '-202', '五险代扣', null);
INSERT INTO `db_salary_detail` VALUES ('8393349D040A45FC998DD081E04341D6', '6B1DB0E142B0481A8922BA66E98ACB4C', '6212', '基本工资', null);
INSERT INTO `db_salary_detail` VALUES ('8F64C90C837F469FA204D917685F05C6', '6B1DB0E142B0481A8922BA66E98ACB4C', '1000', '奖金', null);
INSERT INTO `db_salary_detail` VALUES ('BC19D6F1422C4C929B75C2872CE59570', '94401460745A43C39CD0605ADB3D662E', '6000', '基本工资', null);
INSERT INTO `db_salary_detail` VALUES ('DC405B03A69C4207B374D2E2CE760263', '6B1DB0E142B0481A8922BA66E98ACB4C', '-212', '五险代扣', null);
INSERT INTO `db_salary_detail` VALUES ('F1B3D8C35CF14B7BB8FEEA7054E48419', '5EA4A5978DDC482184085E07890516F0', '6212', '基本工资', null);

-- ----------------------------
-- Table structure for db_salary_info
-- ----------------------------
DROP TABLE IF EXISTS `db_salary_info`;
CREATE TABLE `db_salary_info` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `staff_id` varchar(40) DEFAULT NULL COMMENT '员工ID',
  `year_mon` varchar(40) DEFAULT NULL COMMENT '工资年月',
  `true_price` double DEFAULT NULL COMMENT '实发工资',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_salary_info
-- ----------------------------
INSERT INTO `db_salary_info` VALUES ('6B1DB0E142B0481A8922BA66E98ACB4C', '4EB45FB799C34A9A89D0B14A2911CD9A', '2020-02', '7000', '');
INSERT INTO `db_salary_info` VALUES ('94401460745A43C39CD0605ADB3D662E', '8B145DEDD59446AE8D4918A1DEE086E1', '2020-01', '16798', '年终奖与本月工资一起发，有疑问，请联系人事。');

-- ----------------------------
-- Table structure for db_staff_info
-- ----------------------------
DROP TABLE IF EXISTS `db_staff_info`;
CREATE TABLE `db_staff_info` (
  `id` varchar(60) NOT NULL COMMENT '编号',
  `dept_id` varchar(40) DEFAULT NULL COMMENT '部门ID',
  `staff_name` varchar(40) DEFAULT NULL COMMENT '员工姓名',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `card_no` varchar(40) DEFAULT NULL COMMENT '身份证号',
  `native_place` varchar(40) DEFAULT NULL COMMENT '籍贯',
  `home_address` varchar(200) DEFAULT NULL COMMENT '家庭住址',
  `phone` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `work_years` varchar(10) DEFAULT NULL COMMENT '工作年限',
  `in_time` varchar(40) DEFAULT NULL COMMENT '入职时间',
  `work_post` varchar(50) DEFAULT NULL COMMENT '工作岗位',
  `base_salary` double DEFAULT NULL COMMENT '基本工资',
  `status` varchar(20) DEFAULT NULL COMMENT '员工状态',
  `out_time` varchar(40) DEFAULT NULL COMMENT '离职时间',
  `remarks` text COMMENT '备注',
  `job_id` varchar(40) DEFAULT NULL COMMENT '工号',
  `degree` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `level` varchar(255) DEFAULT NULL COMMENT '技术等级',
  `post` varchar(255) DEFAULT NULL COMMENT '职务',
  `tech_title` varchar(255) DEFAULT NULL COMMENT '职称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_staff_info
-- ----------------------------
INSERT INTO `db_staff_info` VALUES ('4EB45FB799C34A9A89D0B14A2911CD9A', '90230B2376B0468BA24495D1670EE3B2', '蒋至龙', '男', '450111199208010102', '北京', '北京市xx街道xxx小区xxx房号', '18989898989', '3', '2020-02-24', '管理岗位', '6212', '在职', '', '表现优秀，上调基本工资100\r\n没理由！\r\n斯是陋室\r\n搜店铺搜到', '10102', '硕士', '管理岗位六级', '教导主任', '副处级四等分');
INSERT INTO `db_staff_info` VALUES ('8B145DEDD59446AE8D4918A1DEE086E1', '2F7B32A083E649B5AAFDAAF3CDD9455B', '周家龙', '男', '450111199208010101', '北京', '北京市xx街道xxx小区xxx房号', '15078787878', '3', '2020-02-24', '专业技术岗', '6000', '在职', '', '符合考评要求，涨薪1000', '10101', '博士', '专业技术岗位七级', '教师', '讲师');

-- ----------------------------
-- Table structure for db_zhaopin_info
-- ----------------------------
DROP TABLE IF EXISTS `db_zhaopin_info`;
CREATE TABLE `db_zhaopin_info` (
  `id` varchar(40) NOT NULL,
  `title` varchar(50) DEFAULT '',
  `deptName` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `peopleNeed` decimal(50,0) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `pSum` int(20) unsigned zerofill DEFAULT '00000000000000000000',
  `tTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_zhaopin_info
-- ----------------------------
INSERT INTO `db_zhaopin_info` VALUES ('0BFA0C5957DC4DC186E4F52D1554AB84', '0210', '教务处', '主任', '50', '120', '00000000000000000000', '2020-06-12');
INSERT INTO `db_zhaopin_info` VALUES ('3E2E2791D2A74685BC17844DF29F72F2', '乖乖', '教务处', '天皇', '239293', '乖乖', '00000000000000000000', '2020-06-09');
INSERT INTO `db_zhaopin_info` VALUES ('5411F54929F44352B6240C0436A8882F', '按时微微', '教务处', '天皇', '234', '鼎喂喂喂', '00000000000000000000', '2020-06-17');
INSERT INTO `db_zhaopin_info` VALUES ('6E2D37FD84E7482AA14F9B1100E6E514', 'sdasd', '教务处', '天皇', '60', '3123', '00000000000000000000', '2020-06-19');
INSERT INTO `db_zhaopin_info` VALUES ('B71C44CE045840E3879CB8A53D0D251F', 'test1', '技术部', '开发', '0', 'fuckasdasdasdasdgwrehtejjytejytekytekytekytekytek', '00000000000000000000', '2020-06-11');
INSERT INTO `db_zhaopin_info` VALUES ('CEB54DE9F7094093AF7B2A0B5FB5F5A1', '按时', '教务处', '天皇', '34', '鼎折覆餗', '00000000000000000000', '2020-06-28');
INSERT INTO `db_zhaopin_info` VALUES ('D5A9A9F99121413FBA94D8B4FF645D8E', 'test1', '技术部', '开发', '1949', 'fuckasdasdasdasdgwrehtejjytejytekytekytekytekytek', '00000000000000000000', '2020-06-11');
INSERT INTO `db_zhaopin_info` VALUES ('DF8DB018502E45B28FAD85618249B78C', 'd2', '技术部', '测试', '111', 'qwe`', '00000000000000000000', '2020-06-13');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `notice_type` varchar(40) DEFAULT NULL COMMENT '通知类型',
  `content` longtext NOT NULL COMMENT '内容',
  `author` varchar(40) NOT NULL COMMENT '作者',
  `publish_time` varchar(40) NOT NULL COMMENT '发布时间',
  `looks` int(11) NOT NULL COMMENT '查看次数',
  `notice_statue` varchar(40) DEFAULT NULL COMMENT '通知状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('530FD963ED254DB3946BF0E449B2A7BA', '请各工作人员及时录入手上的相关小区数据', null, '<p>各位工作人员：<br/></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新的一月已经开始，请及时录入上月各物业管理信息数据。谢谢配合！<br/></p><p><br/></p>', 'admin', '2019-04-06 23:14:37', '3', null);
INSERT INTO `sys_notice` VALUES ('EEE5329D24674D88B2E8D43A19795164', '请各工作人员及时录入手上的相关小区数据', null, '<p>测试</p>', 'admin', '2019-04-06 23:15:00', '0', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL DEFAULT '' COMMENT '编号',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `role` varchar(64) DEFAULT NULL COMMENT '角色',
  `is_block` varchar(10) DEFAULT NULL COMMENT '是否锁定',
  `tel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `job_id` varchar(255) DEFAULT NULL COMMENT '工号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('0D6F5A0B6DA0417CB39D9692D9078E13', '111', '2', '1', '0', '111333', '123@qq.com', '3');
INSERT INTO `sys_user` VALUES ('1', 'sys', '1', '1', '0', null, null, '');
INSERT INTO `sys_user` VALUES ('201F57E421EC41A7A388F4107A2B0F3E', 'admin3', '123', '1', '0', '213123', '836800432@qq.com', '1010132423423');
INSERT INTO `sys_user` VALUES ('B7EBA40F4EF74387BE4F7EB383430B40', 'admin', '1', '1', '0', '1111', '11@qq.com', '10102');
