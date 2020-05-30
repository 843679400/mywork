/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.25a : Database - salesystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`salesystem` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `salesystem`;

/*Table structure for table `consumer` */

DROP TABLE IF EXISTS `consumer`;

CREATE TABLE `consumer` (
  `con_number` varchar(10) NOT NULL COMMENT '消费者账号',
  `con_password` varchar(20) NOT NULL COMMENT '消费者密码',
  `con_phone` varchar(20) NOT NULL COMMENT '消费者手机号',
  `con_address` varchar(50) DEFAULT NULL COMMENT '收货地址',
  `con_name` varchar(10) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`con_number`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `consumer` */

insert  into `consumer`(`con_number`,`con_password`,`con_phone`,`con_address`,`con_name`) values ('1','1','1123','石家庄123','石头123'),('123456','123456','13273310508','未知','未知'),('2','2','2','北京市','二号');

/*Table structure for table `shopcart` */

DROP TABLE IF EXISTS `shopcart`;

CREATE TABLE `shopcart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `con_number` varchar(10) NOT NULL COMMENT '买家账户',
  `product_id` varchar(10) NOT NULL COMMENT '商品编号',
  `product_sum` int(10) NOT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

/*Data for the table `shopcart` */

insert  into `shopcart`(`id`,`con_number`,`product_id`,`product_sum`) values (8,'admin','12',1);

/*Table structure for table `t_area` */

DROP TABLE IF EXISTS `t_area`;

CREATE TABLE `t_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(40) NOT NULL,
  `province` varchar(40) NOT NULL,
  `city` varchar(40) NOT NULL,
  `district` varchar(40) NOT NULL,
  `parent` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_area` */

/*Table structure for table `t_auth` */

DROP TABLE IF EXISTS `t_auth`;

CREATE TABLE `t_auth` (
  `auth_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限编号（自动增长）',
  `auth_name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `auth_describe` varchar(255) DEFAULT NULL COMMENT '描述',
  `auth_path` varchar(255) DEFAULT NULL COMMENT '权限的访问路径',
  `auth_parent_id` int(11) DEFAULT NULL COMMENT '父权限id',
  PRIMARY KEY (`auth_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `t_auth` */

insert  into `t_auth`(`auth_id`,`auth_name`,`auth_describe`,`auth_path`,`auth_parent_id`) values (1,'订单管理','订单管理','baseMessage',0),(2,'账户管理','账户管理','userManager',0),(3,'商品管理','商品管理','sale',0),(4,'库存管理','库存管理','inventorymanage',0),(5,'统计图','统计图','purchase',0),(12,'账号列表','账号列表','pages/userManager/user-list.html',2),(13,'权限列表','权限列表','pages/userManager/role-list.html',2),(14,'商品上架','商品上架','pages/sale/reserve.html',3),(18,'采购入库','采购入库','pages/purchase/repository-add.html',4),(19,'库存查询','库存查询','pages/purchase/repository-inquiry.html',4),(20,'每月销售利润统计','每月销售利润统计','pages/statistics/statistic.html',5),(21,'库存量统计','库存量统计','pages/statistics/GoodsStatistics.html',5),(22,'订单受理','订单受理','pages/baseMessage/reserve.html',1),(23,'商品销售量','商品销售量','pages/statistics/productSales.html',5);

/*Table structure for table `t_gathering` */

DROP TABLE IF EXISTS `t_gathering`;

CREATE TABLE `t_gathering` (
  `gath_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收款id',
  `gath_date` date NOT NULL COMMENT '收款日期',
  `gath_money` decimal(10,0) NOT NULL COMMENT '收款金额',
  `gath_orderId` varchar(40) NOT NULL COMMENT '订单编号（外键，',
  `gath_remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `gath_createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `gath_updateDate` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  `gath_state` int(11) DEFAULT '0' COMMENT '(状态)是否已删除，取值为0和1默认为0',
  `gath_modifier` int(11) DEFAULT NULL COMMENT '修改人（引用（t_user表）user_id）',
  KEY `gath_id` (`gath_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `t_gathering` */

insert  into `t_gathering`(`gath_id`,`gath_date`,`gath_money`,`gath_orderId`,`gath_remark`,`gath_createDate`,`gath_updateDate`,`gath_state`,`gath_modifier`) values (2,'2019-09-07','400','0',NULL,'2019-09-07 15:49:20',NULL,0,NULL),(3,'2019-09-07','0','0',NULL,'2019-09-07 19:06:24',NULL,0,NULL),(7,'2019-09-09','99','120190909114004157917793',NULL,'2019-09-09 12:05:10',NULL,0,0),(8,'2019-09-09','276','120190909202000332917798',NULL,'2019-09-09 12:20:45',NULL,0,0),(9,'2019-09-09','1248','120190909202734177917793',NULL,'2019-09-09 12:27:54',NULL,0,0),(10,'2019-09-09','178','120190909203718267917797',NULL,'2019-09-09 12:37:38',NULL,0,0),(11,'2019-09-09','188','120190909204007686917793',NULL,'2019-09-09 12:40:29',NULL,0,0),(12,'2019-09-09','178','120190909210021113917795',NULL,'2019-09-09 13:00:38',NULL,0,0),(13,'2019-09-10','158','120190910095926412917798',NULL,'2019-09-10 01:59:53',NULL,0,0),(14,'2019-09-10','7740','120190910122926463917793',NULL,'2019-09-10 04:32:06',NULL,0,0),(15,'2019-09-10','100','120190910180241283917792',NULL,'2019-09-10 10:02:57',NULL,0,0),(16,'2019-09-10','542','120190910214159999917792',NULL,'2019-09-10 13:42:23',NULL,0,0),(17,'2019-09-11','108','120190911112017186917798',NULL,'2019-09-11 03:20:33',NULL,0,0),(18,'2019-09-16','356','120190916183939313917798',NULL,'2019-09-16 10:40:39',NULL,0,0),(19,'2019-09-16','346','120190916184302217917796',NULL,'2019-09-16 10:43:34',NULL,0,0),(20,'2019-09-16','446','120190916184503044117792',NULL,'2019-09-16 10:45:23',NULL,0,0),(21,'2019-09-16','258','120190916184601010117791',NULL,'2019-09-16 10:46:12',NULL,0,0),(22,'2019-09-16','474','120190916185211287117797',NULL,'2019-09-16 10:53:00',NULL,0,0),(23,'2019-09-16','336','120190916203257021117794',NULL,'2019-09-16 12:33:52',NULL,0,0);

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_id` varchar(40) NOT NULL COMMENT '订单编号',
  `order_cusId` varchar(10) NOT NULL COMMENT '用户账号',
  `order_aggregateAmount` decimal(10,0) NOT NULL COMMENT '总金额',
  `order_empId` int(11) DEFAULT NULL COMMENT '员工编号（引用（t_emp表）emp_id）',
  `order_createDate` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  `order_updateDate` date DEFAULT NULL COMMENT '修改日期',
  `order_state` int(11) NOT NULL DEFAULT '0' COMMENT '订单是否受理(0未受理 1受理)',
  `order_deposit` int(11) DEFAULT '0' COMMENT '是否已交押金，取值为0和1默认为0',
  `order_fullPayment` int(11) DEFAULT '0' COMMENT '是否已交全款，取值为0和1默认为0 当交完全款以后表示订单完成',
  `order_remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `order_cashPledge` decimal(10,0) DEFAULT NULL COMMENT '押金',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`order_id`,`order_cusId`,`order_aggregateAmount`,`order_empId`,`order_createDate`,`order_updateDate`,`order_state`,`order_deposit`,`order_fullPayment`,`order_remark`,`order_cashPledge`) values (35,'12020042113541129694','1','5001',NULL,'2020-03-01 05:54:11',NULL,1,0,0,NULL,NULL),(36,'12020042113551320692','1','4499',NULL,'2020-02-06 05:55:13',NULL,1,0,0,NULL,NULL),(37,'12020042114090968891','1','3599',NULL,'2020-03-21 06:09:09',NULL,1,0,0,NULL,NULL),(38,'12020042114230328466','2','8598',NULL,'2020-02-14 06:23:03',NULL,1,0,0,NULL,NULL),(39,'12020042312200972362','2','5298',NULL,'2020-04-23 04:20:09',NULL,1,0,0,NULL,NULL),(40,'12020042312240058265','2','2299',NULL,'2020-04-23 04:24:00',NULL,1,0,0,NULL,NULL),(41,'12020042317253139997','1','4299',NULL,'2020-04-23 09:25:31',NULL,1,0,0,NULL,NULL),(42,'12020042317315098895','1','3599',NULL,'2020-04-23 09:31:51',NULL,1,0,0,NULL,NULL),(43,'12020042317480867491','1','4299',NULL,'2020-04-23 09:48:08',NULL,1,0,1,NULL,NULL),(44,'12020051212470074497','1','2299',NULL,'2020-05-12 04:47:00',NULL,1,0,1,NULL,NULL),(45,'12020051322345960495','1','2299',NULL,'2020-05-13 14:34:59',NULL,1,0,1,NULL,NULL),(46,'12020051416552381592','1','2299',NULL,'2020-05-14 08:55:23',NULL,1,0,1,NULL,NULL),(47,'12020051417195609494','1','3599',NULL,'2020-05-14 09:19:56',NULL,0,0,0,NULL,NULL),(48,'12020052318314985393','1','2299',NULL,'2020-05-23 10:32:03',NULL,0,0,0,NULL,NULL),(49,'12020052318342681291','1','5898',NULL,'2020-05-23 10:34:26',NULL,0,0,0,NULL,NULL),(50,'12020052318361696897','1','899',NULL,'2020-05-23 10:37:07',NULL,1,0,0,NULL,NULL),(51,'12020052319291378398','1','4299',NULL,'2020-05-23 11:30:24',NULL,0,0,0,NULL,NULL),(52,'1202005232003293423182693','123456','2299',NULL,'2020-05-23 12:03:29',NULL,0,0,0,NULL,NULL),(53,'1202005232035281423182695','123456','2299',NULL,'2020-05-23 12:35:28',NULL,0,0,0,NULL,NULL),(54,'1202005232045301883182697','123456','4299',NULL,'2020-05-23 12:45:30',NULL,0,0,0,NULL,NULL),(55,'1202005232049129303182697','123456','2299',NULL,'2020-05-23 12:49:12',NULL,1,0,1,NULL,NULL);

/*Table structure for table `t_orderdetail` */

DROP TABLE IF EXISTS `t_orderdetail`;

CREATE TABLE `t_orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_id` varchar(40) NOT NULL COMMENT '订单编号（引用（t_sale表）sale_id）',
  `order_gooId` int(11) NOT NULL COMMENT '商品编号',
  `order_price` decimal(10,0) NOT NULL COMMENT '货品进价',
  `order_discounts` varchar(500) DEFAULT NULL COMMENT '商品名称',
  `order_amount` int(11) NOT NULL COMMENT '数量',
  `order_remark` varchar(100) DEFAULT NULL COMMENT '售价',
  `order_createDate` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  `order_updateDate` int(11) DEFAULT '0' COMMENT '是否删除订单 0未删除 1删除',
  `order_modifier` varchar(500) DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

/*Data for the table `t_orderdetail` */

insert  into `t_orderdetail`(`id`,`order_id`,`order_gooId`,`order_price`,`order_discounts`,`order_amount`,`order_remark`,`order_createDate`,`order_updateDate`,`order_modifier`) values (61,'12020042113541129694',1,'2900','小米9',1,'5001.00',NULL,1,'\\upload\\1585636354715.jpg'),(62,'12020042113551320692',10,'700','红米7A',1,'900.00',NULL,1,'\\upload\\1587447332680.jpg'),(63,'12020042113551320692',11,'3299','小米10',1,'3599.00',NULL,1,'\\upload\\1587447399777.jpg'),(64,'12020042114090968891',11,'3299','小米10',1,'3599.00',NULL,1,'\\upload\\1587447399777.jpg'),(65,'12020042114230328466',7,'3799','腾讯黑鲨游戏手机3',2,'4299.00',NULL,0,'\\upload\\1587446828427.jpg'),(66,'12020042312200972362',8,'900','红米Note8',1,'999.00',NULL,0,'\\upload\\1587447183832.jpg'),(67,'12020042312200972362',12,'3799','小米10Pro',1,'4299.00',NULL,0,'\\upload\\1587447479829.jpg'),(68,'12020042312240058265',13,'1999','红米K30 5G',1,'2299.00',NULL,0,'\\upload\\1587447906509.jpg'),(69,'12020042317253139997',12,'3799','小米10Pro',1,'4299.00',NULL,1,'\\upload\\1587447479829.jpg'),(70,'12020042317315098895',11,'3299','小米10',1,'3599.00',NULL,0,'\\upload\\1587447399777.jpg'),(71,'12020042317480867491',12,'3799','小米10Pro',1,'4299.00',NULL,0,'\\upload\\1587447479829.jpg'),(72,'12020051212470074497',13,'1999','红米K30 5G',1,'2299.00',NULL,0,'\\upload\\1587447906509.jpg'),(73,'12020051322345960495',13,'1999','红米K30 5G',1,'2299.00',NULL,0,'\\upload\\1587447906509.jpg'),(74,'12020051416552381592',13,'1999','红米K30 5G',1,'2299.00',NULL,0,'\\upload\\1587447906509.jpg'),(75,'12020051417195609494',11,'3299','小米10',1,'3599.00',NULL,0,'\\upload\\1587447399777.jpg'),(76,'12020052318314985393',13,'1999','红米K30 5G',1,'2299.00',NULL,0,'\\upload\\1587447906509.jpg'),(77,'12020052318342681291',14,'3299','Redmi K30 Pro 变焦版',1,'3599.00',NULL,0,'\\upload\\1587447988969.jpg'),(78,'12020052318342681291',13,'1999','红米K30 5G',1,'2299.00',NULL,0,'\\upload\\1587447906509.jpg'),(79,'12020052318361696897',9,'800','红米8',1,'899.00',NULL,0,'\\upload\\1587447318182.jpg'),(80,'12020052319291378398',12,'3799','小米10Pro',1,'4299.00',NULL,0,'\\upload\\1587447479829.jpg'),(81,'1202005232003293423182693',13,'1999','红米K30 5G',1,'2299.00',NULL,0,'\\upload\\1587447906509.jpg'),(82,'1202005232035281423182695',13,'1999','红米K30 5G',1,'2299.00',NULL,0,'\\upload\\1587447906509.jpg'),(83,'1202005232045301883182697',7,'3799','腾讯黑鲨游戏手机3',1,'4299.00',NULL,0,'\\upload\\1587446828427.jpg'),(84,'1202005232049129303182697',13,'1999','红米K30 5G',1,'2299.00',NULL,0,'\\upload\\1587447906509.jpg');

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `product_id` varchar(10) NOT NULL COMMENT '商品id',
  `product_name` varchar(255) NOT NULL COMMENT '商品名称',
  `product_brand` varchar(255) NOT NULL COMMENT '商品品牌',
  `product_type` varchar(255) NOT NULL COMMENT '商品类别',
  `product_standard` varchar(255) NOT NULL COMMENT '商品规格(容量,尺寸等)',
  `product_address` varchar(255) NOT NULL COMMENT '商品产地',
  `product_warning` int(255) NOT NULL COMMENT '数量',
  `product_price` decimal(10,2) NOT NULL COMMENT '进价',
  `modifier_id` int(10) DEFAULT NULL COMMENT '修改人id',
  `product_state` int(255) DEFAULT '0' COMMENT '商品状态(上架为1 未上架为0)',
  `product_creatDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `product_modifieDate` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  `product_photo` varchar(500) NOT NULL COMMENT '商品图片地址',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '售价',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `t_product` */

insert  into `t_product`(`product_id`,`product_name`,`product_brand`,`product_type`,`product_standard`,`product_address`,`product_warning`,`product_price`,`modifier_id`,`product_state`,`product_creatDate`,`product_modifieDate`,`product_photo`,`price`) values ('10','红米7A','小米','手机','4000mAh超长续航 / 骁龙8核处理器 / 标配10W快充 / AI人脸解锁 / 大字体，大音量，无线收音机 / 整机生活防泼溅 / 极简模式，亲情守护','中国',19,'700.00',0,1,'2020-04-21 13:36:23',NULL,'\\upload\\1587447332680.jpg','900.00'),('11','小米10','小米','手机','骁龙865处理器 / 1亿像素8K电影相机 / 双模5G / 新一代LPDDR5内存 / 对称式立体声 / 90Hz刷新率+180Hz采样率 / UFS 3.0高速存储 / 全面适配Wi-Fi 6 / 超强VC液冷散热 / 30W极速闪充+30W无线闪充+10W无线反充 / 4780mAh大电量 / 多功能NFC','中国',16,'3299.00',0,1,'2020-04-21 13:37:17',NULL,'\\upload\\1587447399777.jpg','3599.00'),('12','小米10Pro','小米','手机','骁龙865处理器 / 1亿像素8K电影相机，50倍数字变焦，10倍混合光学变焦 / 双模5G / 新一代LPDDR5内存 / 50W极速闪充+30W无线闪充+10W无线反充 / 对称式立体声 / 90Hz刷新率+180Hz采样率 / UFS 3.0高速存储 / 全面适配WiFi 6 / 超强VC液冷散热 / 4500mAh大电量 / 多功能NFC','中国',5,'3799.00',0,1,'2020-04-21 13:38:01',NULL,'\\upload\\1587447479829.jpg','4299.00'),('13','红米K30 5G','小米','手机','双模5G / 三路并发 / 高通骁龙765G / 7nm 5G低功耗处理器 / 120Hz高帧率流速屏 / 6.67\'\'小孔径全面屏 / 索尼6400万前后六摄 / 最高可选8GB+256GB大存储 / 4500mAh+30W快充 / 3D四曲面玻璃机身 / 多功能NFC','中国',99629644,'1999.00',0,1,'2020-04-21 13:45:07',NULL,'\\upload\\1587447906509.jpg','2299.00'),('14','Redmi K30 Pro 变焦版','小米','手机','双模5G / 高通骁龙865 / 弹出式超光感全面屏 / 索尼6400万双光学防抖四摄 / 8K视频拍摄 / 30倍变焦 / 超大面积VC立体散热 / 4700mAh+33W疾速闪充 / 多功能NFC / 红外遥控','中国',29,'3299.00',0,1,'2020-04-21 13:46:30',NULL,'\\upload\\1587447988969.jpg','3599.00'),('3','华为荣耀10','华为','手机','xxxxxxxxxxxxx','中国',99,'2900.00',0,1,'2020-04-02 16:25:38',NULL,'\\upload\\1585815922803.jpg','3200.00'),('6','RedMi30Pro','小米','手机','4800万全场景四摄 / 前置1300万美颜相机 / 骁龙665处理器 / 4000mAh超长续航 / 标配18W快充 / 超线性扬声器 / 90%高屏占比 / 康宁大猩猩保护玻璃 / 6.3英寸水滴全面屏','中国',10,'2999.00',0,1,'2020-04-21 13:23:01',NULL,'\\upload\\1587446579813.jpg','3299.00'),('7','腾讯黑鲨游戏手机3','腾讯','手机','骁龙865处理器 / 双模5G / 腾讯Solar Core游戏引擎 / 270Hz触控采样率+90Hz屏幕刷新率 / 最高65W极速闪充+背部磁吸充电 / 4720mAh大容量双电池 / UFS3.0闪存 / “三明治”液冷散热 / 屏幕压感3.0 / 游戏语音操控','中国',876561,'3799.00',0,1,'2020-04-21 13:27:10',NULL,'\\upload\\1587446828427.jpg','4299.00'),('8','红米Note8','小米','手机','4800万全场景四摄 / 前置1300万美颜相机 / 骁龙665处理器 / 4000mAh超长续航 / 标配18W快充 / 超线性扬声器 / 90%高屏占比 / 康宁大猩猩保护玻璃 / 6.3英寸水滴全面屏','中国',18,'900.00',0,1,'2020-04-21 13:33:10',NULL,'\\upload\\1587447183832.jpg','999.00'),('9','红米8','小米','手机','4800万全场景四摄 / 前置1300万美颜相机 / 骁龙665处理器 / 4000mAh超长续航 / 标配18W快充 / 超线性扬声器 / 90%高屏占比 / 康宁大猩猩保护玻璃 / 6.3英寸水滴全面屏','中国',19,'800.00',0,1,'2020-04-21 13:35:19',NULL,'\\upload\\1587447318182.jpg','899.00');

/*Table structure for table `t_restock_order` */

DROP TABLE IF EXISTS `t_restock_order`;

CREATE TABLE `t_restock_order` (
  `resto_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '退货单号',
  `resto_supId` int(11) NOT NULL COMMENT '供货商编号',
  `resto_total` decimal(10,0) NOT NULL COMMENT '货物总价',
  `resto_data` date DEFAULT NULL COMMENT '退货日期',
  `resto_remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `resto_createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `resto_updateDate` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  `resto_isDelete` int(11) NOT NULL DEFAULT '0' COMMENT '是否已删除，取值为0和1默认为0。',
  `resto_modifier` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`resto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12346 DEFAULT CHARSET=utf8;

/*Data for the table `t_restock_order` */

insert  into `t_restock_order`(`resto_id`,`resto_supId`,`resto_total`,`resto_data`,`resto_remark`,`resto_createDate`,`resto_updateDate`,`resto_isDelete`,`resto_modifier`) values (12345,1001,'1000','2019-09-07','测试退货','2019-09-07 16:03:22',NULL,0,NULL);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `role_roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色Id',
  `role_roleName` varchar(20) NOT NULL COMMENT '角色名称',
  `role_describe` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `role_status` int(11) DEFAULT '0' COMMENT '状态码 0启用1禁用',
  `role_isDelete` bigint(10) DEFAULT '0' COMMENT '是否已删除，取值为0和1默认为0。',
  `role_createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `role_updateDate` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  `role_modifier` int(11) DEFAULT NULL COMMENT '修改人（引用（t_user表）user_id）',
  PRIMARY KEY (`role_roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`role_roleId`,`role_roleName`,`role_describe`,`role_status`,`role_isDelete`,`role_createDate`,`role_updateDate`,`role_modifier`) values (1,'xx','描述',1,0,'2020-04-02 17:30:07',NULL,NULL),(17,'product','商品管理员',0,0,'2020-05-12 13:50:54',NULL,NULL),(18,'tu','统计图',0,0,'2020-05-23 20:52:28',NULL,NULL);

/*Table structure for table `t_role_auth` */

DROP TABLE IF EXISTS `t_role_auth`;

CREATE TABLE `t_role_auth` (
  `ra_id` int(11) NOT NULL AUTO_INCREMENT,
  `ra_roleId` int(11) NOT NULL COMMENT '角色编号',
  `ra_authId` int(11) NOT NULL COMMENT '权限编号（自增,引用（t_auth表）auth_id）',
  `ra_describe` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`ra_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

/*Data for the table `t_role_auth` */

insert  into `t_role_auth`(`ra_id`,`ra_roleId`,`ra_authId`,`ra_describe`) values (1,1,1,NULL),(56,1,2,NULL),(57,1,3,NULL),(58,1,4,NULL),(59,1,5,NULL),(60,1,6,NULL),(61,1,12,NULL),(62,1,22,NULL),(63,1,13,NULL),(64,1,14,NULL),(65,1,15,NULL),(66,1,16,NULL),(67,1,17,NULL),(68,1,18,NULL),(69,1,19,NULL),(70,1,20,NULL),(71,1,21,NULL),(72,1,23,NULL),(73,1,5,NULL),(74,16,12,NULL),(75,16,13,NULL),(76,16,14,NULL),(77,16,18,NULL),(78,16,19,NULL),(79,16,20,NULL),(80,16,21,NULL),(81,16,22,NULL),(82,16,23,NULL),(83,16,1,NULL),(84,16,2,NULL),(85,16,3,NULL),(86,16,4,NULL),(87,16,5,NULL),(88,17,14,NULL),(89,17,3,NULL),(90,18,20,NULL),(91,18,21,NULL),(92,18,5,NULL);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_loginName` varchar(20) NOT NULL COMMENT '用户名',
  `user_loginPwd` varchar(20) DEFAULT NULL COMMENT '用户密码',
  `user_describe` varchar(100) DEFAULT NULL COMMENT '用户描述',
  `user_createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `user_updateDate` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  `user_isDelete` int(1) NOT NULL DEFAULT '0' COMMENT '是否已删除，取值为0和1默认为0',
  `user_modifier` int(1) DEFAULT NULL COMMENT '修改人（引用（t_user表）user_id）',
  `user_tellnum` char(11) NOT NULL COMMENT '手机号',
  `user_statu` int(255) DEFAULT '0' COMMENT '状态码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10054 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`user_loginName`,`user_loginPwd`,`user_describe`,`user_createDate`,`user_updateDate`,`user_isDelete`,`user_modifier`,`user_tellnum`,`user_statu`) values (10051,'admin','123456','超级用户','2019-09-07 19:02:42','2019-09-16 20:23:25',0,10051,'18231285206',1),(10052,'test','123456','测试账户','2020-05-12 13:46:52',NULL,0,NULL,'13112319980',1),(10053,'test1','111','统计图管理员','2020-05-23 20:52:01',NULL,0,NULL,'123',NULL);

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `ur_urId` int(11) NOT NULL AUTO_INCREMENT,
  `ur_userId` int(11) DEFAULT NULL COMMENT '用户编号（自增,引用（t_user表）user_id）',
  `ur_roleId` int(11) DEFAULT NULL COMMENT '角色编号（自增,引用（t_role表）role_roleId）',
  `ur_describe` varchar(255) DEFAULT NULL COMMENT '描述',
  `ur_modifier` int(11) DEFAULT NULL COMMENT '修改人（引用（t_user表）user_id）',
  PRIMARY KEY (`ur_urId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`ur_urId`,`ur_userId`,`ur_roleId`,`ur_describe`,`ur_modifier`) values (1,10051,1,'拥有所有权限',NULL),(2,10053,18,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
