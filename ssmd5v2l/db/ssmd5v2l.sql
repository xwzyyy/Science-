-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: ssmd5v2l
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `ssmd5v2l`
--

/*!40000 DROP DATABASE IF EXISTS `ssmd5v2l`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ssmd5v2l` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ssmd5v2l`;

--
-- Table structure for table `bianjibu`
--

DROP TABLE IF EXISTS `bianjibu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bianjibu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bianjizhanghao` varchar(200) NOT NULL COMMENT '编辑账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `bianjixingming` varchar(200) DEFAULT NULL COMMENT '编辑姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` varchar(200) DEFAULT NULL COMMENT '年龄',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  `bianjishouji` varchar(200) DEFAULT NULL COMMENT '编辑手机',
  PRIMARY KEY (`id`),
  UNIQUE KEY `bianjizhanghao` (`bianjizhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='编辑部';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bianjibu`
--

LOCK TABLES `bianjibu` WRITE;
/*!40000 ALTER TABLE `bianjibu` DISABLE KEYS */;
INSERT INTO `bianjibu` VALUES (21,'2022-08-07 01:53:40','编辑账号1','123456','编辑姓名1','男','年龄1','upload/bianjibu_touxiang1.jpg','13823888881'),(22,'2022-08-07 01:53:40','编辑账号2','123456','编辑姓名2','男','年龄2','upload/bianjibu_touxiang2.jpg','13823888882'),(23,'2022-08-07 01:53:40','编辑账号3','123456','编辑姓名3','男','年龄3','upload/bianjibu_touxiang3.jpg','13823888883'),(24,'2022-08-07 01:53:40','编辑账号4','123456','编辑姓名4','男','年龄4','upload/bianjibu_touxiang4.jpg','13823888884'),(25,'2022-08-07 01:53:40','编辑账号5','123456','编辑姓名5','男','年龄5','upload/bianjibu_touxiang5.jpg','13823888885'),(26,'2022-08-07 01:53:40','编辑账号6','123456','编辑姓名6','男','年龄6','upload/bianjibu_touxiang6.jpg','13823888886');
/*!40000 ALTER TABLE `bianjibu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg'),(2,'picture2','upload/picture2.jpg'),(3,'picture3','upload/picture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gaigaohuifu`
--

DROP TABLE IF EXISTS `gaigaohuifu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gaigaohuifu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gaojianbianhao` varchar(200) DEFAULT NULL COMMENT '稿件编号',
  `gaojianbiaoti` varchar(200) DEFAULT NULL COMMENT '稿件标题',
  `gaojianleixing` varchar(200) DEFAULT NULL COMMENT '稿件类型',
  `zuozhezhanghao` varchar(200) DEFAULT NULL COMMENT '作者账号',
  `zuozhexingming` varchar(200) DEFAULT NULL COMMENT '作者姓名',
  `zuozheshouji` varchar(200) DEFAULT NULL COMMENT '作者手机',
  `gaigaoshijian` datetime DEFAULT NULL COMMENT '改稿时间',
  `bianjizhanghao` varchar(200) DEFAULT NULL COMMENT '编辑账号',
  `bianjixingming` varchar(200) DEFAULT NULL COMMENT '编辑姓名',
  `shengaozhanghao` varchar(200) DEFAULT NULL COMMENT '审稿账号',
  `shengaoxingming` varchar(200) DEFAULT NULL COMMENT '审稿姓名',
  `gaigaowenjian` varchar(200) NOT NULL COMMENT '改稿文件',
  `huifuneirong` longtext COMMENT '回复内容',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='改稿回复';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gaigaohuifu`
--

LOCK TABLES `gaigaohuifu` WRITE;
/*!40000 ALTER TABLE `gaigaohuifu` DISABLE KEYS */;
INSERT INTO `gaigaohuifu` VALUES (81,'2022-08-07 01:53:40','稿件编号1','稿件标题1','稿件类型1','作者账号1','作者姓名1','作者手机1','2022-08-07 09:53:40','编辑账号1','编辑姓名1','审稿账号1','审稿姓名1','','回复内容1','是',''),(82,'2022-08-07 01:53:40','稿件编号2','稿件标题2','稿件类型2','作者账号2','作者姓名2','作者手机2','2022-08-07 09:53:40','编辑账号2','编辑姓名2','审稿账号2','审稿姓名2','','回复内容2','是',''),(83,'2022-08-07 01:53:40','稿件编号3','稿件标题3','稿件类型3','作者账号3','作者姓名3','作者手机3','2022-08-07 09:53:40','编辑账号3','编辑姓名3','审稿账号3','审稿姓名3','','回复内容3','是',''),(84,'2022-08-07 01:53:40','稿件编号4','稿件标题4','稿件类型4','作者账号4','作者姓名4','作者手机4','2022-08-07 09:53:40','编辑账号4','编辑姓名4','审稿账号4','审稿姓名4','','回复内容4','是',''),(85,'2022-08-07 01:53:40','稿件编号5','稿件标题5','稿件类型5','作者账号5','作者姓名5','作者手机5','2022-08-07 09:53:40','编辑账号5','编辑姓名5','审稿账号5','审稿姓名5','','回复内容5','是',''),(86,'2022-08-07 01:53:40','稿件编号6','稿件标题6','稿件类型6','作者账号6','作者姓名6','作者手机6','2022-08-07 09:53:40','编辑账号6','编辑姓名6','审稿账号6','审稿姓名6','','回复内容6','是','');
/*!40000 ALTER TABLE `gaigaohuifu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gaigaotongzhi`
--

DROP TABLE IF EXISTS `gaigaotongzhi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gaigaotongzhi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gaojianbianhao` varchar(200) DEFAULT NULL COMMENT '稿件编号',
  `gaojianbiaoti` varchar(200) DEFAULT NULL COMMENT '稿件标题',
  `gaojianleixing` varchar(200) DEFAULT NULL COMMENT '稿件类型',
  `zuozhezhanghao` varchar(200) DEFAULT NULL COMMENT '作者账号',
  `zuozhexingming` varchar(200) DEFAULT NULL COMMENT '作者姓名',
  `zuozheshouji` varchar(200) DEFAULT NULL COMMENT '作者手机',
  `bianjizhanghao` varchar(200) DEFAULT NULL COMMENT '编辑账号',
  `bianjixingming` varchar(200) DEFAULT NULL COMMENT '编辑姓名',
  `shengaozhanghao` varchar(200) DEFAULT NULL COMMENT '审稿账号',
  `shengaoxingming` varchar(200) DEFAULT NULL COMMENT '审稿姓名',
  `gaigaoneirong` longtext COMMENT '改稿内容',
  `tongzhishijian` datetime DEFAULT NULL COMMENT '通知时间',
  `huifuzhuangtai` varchar(200) DEFAULT NULL COMMENT '回复状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='改稿通知';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gaigaotongzhi`
--

LOCK TABLES `gaigaotongzhi` WRITE;
/*!40000 ALTER TABLE `gaigaotongzhi` DISABLE KEYS */;
INSERT INTO `gaigaotongzhi` VALUES (71,'2022-08-07 01:53:40','稿件编号1','稿件标题1','稿件类型1','作者账号1','作者姓名1','作者手机1','编辑账号1','编辑姓名1','审稿账号1','审稿姓名1','改稿内容1','2022-08-07 09:53:40','已回复'),(72,'2022-08-07 01:53:40','稿件编号2','稿件标题2','稿件类型2','作者账号2','作者姓名2','作者手机2','编辑账号2','编辑姓名2','审稿账号2','审稿姓名2','改稿内容2','2022-08-07 09:53:40','已回复'),(73,'2022-08-07 01:53:40','稿件编号3','稿件标题3','稿件类型3','作者账号3','作者姓名3','作者手机3','编辑账号3','编辑姓名3','审稿账号3','审稿姓名3','改稿内容3','2022-08-07 09:53:40','已回复'),(74,'2022-08-07 01:53:40','稿件编号4','稿件标题4','稿件类型4','作者账号4','作者姓名4','作者手机4','编辑账号4','编辑姓名4','审稿账号4','审稿姓名4','改稿内容4','2022-08-07 09:53:40','已回复'),(75,'2022-08-07 01:53:40','稿件编号5','稿件标题5','稿件类型5','作者账号5','作者姓名5','作者手机5','编辑账号5','编辑姓名5','审稿账号5','审稿姓名5','改稿内容5','2022-08-07 09:53:40','已回复'),(76,'2022-08-07 01:53:40','稿件编号6','稿件标题6','稿件类型6','作者账号6','作者姓名6','作者手机6','编辑账号6','编辑姓名6','审稿账号6','审稿姓名6','改稿内容6','2022-08-07 09:53:40','已回复');
/*!40000 ALTER TABLE `gaigaotongzhi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gaojiankanzai`
--

DROP TABLE IF EXISTS `gaojiankanzai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gaojiankanzai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gaojianbianhao` varchar(200) DEFAULT NULL COMMENT '稿件编号',
  `gaojianbiaoti` varchar(200) DEFAULT NULL COMMENT '稿件标题',
  `gaojianleixing` varchar(200) DEFAULT NULL COMMENT '稿件类型',
  `zuozhezhanghao` varchar(200) DEFAULT NULL COMMENT '作者账号',
  `zuozhexingming` varchar(200) DEFAULT NULL COMMENT '作者姓名',
  `zuozheshouji` varchar(200) DEFAULT NULL COMMENT '作者手机',
  `bianjizhanghao` varchar(200) DEFAULT NULL COMMENT '编辑账号',
  `bianjixingming` varchar(200) DEFAULT NULL COMMENT '编辑姓名',
  `shengaozhanghao` varchar(200) DEFAULT NULL COMMENT '审稿账号',
  `shengaoxingming` varchar(200) DEFAULT NULL COMMENT '审稿姓名',
  `luyongshijian` datetime DEFAULT NULL COMMENT '录用时间',
  `choujin` float NOT NULL COMMENT '酬金',
  `kanzaishijian` date NOT NULL COMMENT '刊载时间',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 COMMENT='稿件刊载';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gaojiankanzai`
--

LOCK TABLES `gaojiankanzai` WRITE;
/*!40000 ALTER TABLE `gaojiankanzai` DISABLE KEYS */;
INSERT INTO `gaojiankanzai` VALUES (101,'2022-08-07 01:53:40','稿件编号1','稿件标题1','稿件类型1','作者账号1','作者姓名1','作者手机1','编辑账号1','编辑姓名1','审稿账号1','审稿姓名1','2022-08-07 09:53:40',1,'2022-08-07','未支付'),(102,'2022-08-07 01:53:40','稿件编号2','稿件标题2','稿件类型2','作者账号2','作者姓名2','作者手机2','编辑账号2','编辑姓名2','审稿账号2','审稿姓名2','2022-08-07 09:53:40',2,'2022-08-07','未支付'),(103,'2022-08-07 01:53:40','稿件编号3','稿件标题3','稿件类型3','作者账号3','作者姓名3','作者手机3','编辑账号3','编辑姓名3','审稿账号3','审稿姓名3','2022-08-07 09:53:40',3,'2022-08-07','未支付'),(104,'2022-08-07 01:53:40','稿件编号4','稿件标题4','稿件类型4','作者账号4','作者姓名4','作者手机4','编辑账号4','编辑姓名4','审稿账号4','审稿姓名4','2022-08-07 09:53:40',4,'2022-08-07','未支付'),(105,'2022-08-07 01:53:40','稿件编号5','稿件标题5','稿件类型5','作者账号5','作者姓名5','作者手机5','编辑账号5','编辑姓名5','审稿账号5','审稿姓名5','2022-08-07 09:53:40',5,'2022-08-07','未支付'),(106,'2022-08-07 01:53:40','稿件编号6','稿件标题6','稿件类型6','作者账号6','作者姓名6','作者手机6','编辑账号6','编辑姓名6','审稿账号6','审稿姓名6','2022-08-07 09:53:40',6,'2022-08-07','未支付');
/*!40000 ALTER TABLE `gaojiankanzai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gaojianleixing`
--

DROP TABLE IF EXISTS `gaojianleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gaojianleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gaojianleixing` varchar(200) DEFAULT NULL COMMENT '稿件类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='稿件类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gaojianleixing`
--

LOCK TABLES `gaojianleixing` WRITE;
/*!40000 ALTER TABLE `gaojianleixing` DISABLE KEYS */;
INSERT INTO `gaojianleixing` VALUES (51,'2022-08-07 01:53:40','稿件类型1'),(52,'2022-08-07 01:53:40','稿件类型2'),(53,'2022-08-07 01:53:40','稿件类型3'),(54,'2022-08-07 01:53:40','稿件类型4'),(55,'2022-08-07 01:53:40','稿件类型5'),(56,'2022-08-07 01:53:40','稿件类型6');
/*!40000 ALTER TABLE `gaojianleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gaojianluyong`
--

DROP TABLE IF EXISTS `gaojianluyong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gaojianluyong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gaojianbianhao` varchar(200) DEFAULT NULL COMMENT '稿件编号',
  `gaojianbiaoti` varchar(200) DEFAULT NULL COMMENT '稿件标题',
  `gaojianleixing` varchar(200) DEFAULT NULL COMMENT '稿件类型',
  `zuozhezhanghao` varchar(200) DEFAULT NULL COMMENT '作者账号',
  `zuozhexingming` varchar(200) DEFAULT NULL COMMENT '作者姓名',
  `zuozheshouji` varchar(200) DEFAULT NULL COMMENT '作者手机',
  `bianjizhanghao` varchar(200) DEFAULT NULL COMMENT '编辑账号',
  `bianjixingming` varchar(200) DEFAULT NULL COMMENT '编辑姓名',
  `shengaozhanghao` varchar(200) DEFAULT NULL COMMENT '审稿账号',
  `shengaoxingming` varchar(200) DEFAULT NULL COMMENT '审稿姓名',
  `luyongshijian` datetime DEFAULT NULL COMMENT '录用时间',
  `banmianfei` varchar(200) NOT NULL COMMENT '版面费',
  `luyonggaojian` varchar(200) NOT NULL COMMENT '录用稿件',
  `kanzaizhuangtai` varchar(200) DEFAULT NULL COMMENT '刊载状态',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='稿件录用';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gaojianluyong`
--

LOCK TABLES `gaojianluyong` WRITE;
/*!40000 ALTER TABLE `gaojianluyong` DISABLE KEYS */;
INSERT INTO `gaojianluyong` VALUES (91,'2022-08-07 01:53:40','稿件编号1','稿件标题1','稿件类型1','作者账号1','作者姓名1','作者手机1','编辑账号1','编辑姓名1','审稿账号1','审稿姓名1','2022-08-07 09:53:40','版面费1','','已刊载','未支付'),(92,'2022-08-07 01:53:40','稿件编号2','稿件标题2','稿件类型2','作者账号2','作者姓名2','作者手机2','编辑账号2','编辑姓名2','审稿账号2','审稿姓名2','2022-08-07 09:53:40','版面费2','','已刊载','未支付'),(93,'2022-08-07 01:53:40','稿件编号3','稿件标题3','稿件类型3','作者账号3','作者姓名3','作者手机3','编辑账号3','编辑姓名3','审稿账号3','审稿姓名3','2022-08-07 09:53:40','版面费3','','已刊载','未支付'),(94,'2022-08-07 01:53:40','稿件编号4','稿件标题4','稿件类型4','作者账号4','作者姓名4','作者手机4','编辑账号4','编辑姓名4','审稿账号4','审稿姓名4','2022-08-07 09:53:40','版面费4','','已刊载','未支付'),(95,'2022-08-07 01:53:40','稿件编号5','稿件标题5','稿件类型5','作者账号5','作者姓名5','作者手机5','编辑账号5','编辑姓名5','审稿账号5','审稿姓名5','2022-08-07 09:53:40','版面费5','','已刊载','未支付'),(96,'2022-08-07 01:53:40','稿件编号6','稿件标题6','稿件类型6','作者账号6','作者姓名6','作者手机6','编辑账号6','编辑姓名6','审稿账号6','审稿姓名6','2022-08-07 09:53:40','版面费6','','已刊载','未支付');
/*!40000 ALTER TABLE `gaojianluyong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shangchuangaojian`
--

DROP TABLE IF EXISTS `shangchuangaojian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shangchuangaojian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gaojianbianhao` varchar(200) DEFAULT NULL COMMENT '稿件编号',
  `gaojianbiaoti` varchar(200) NOT NULL COMMENT '稿件标题',
  `gaojianleixing` varchar(200) DEFAULT NULL COMMENT '稿件类型',
  `zuozhezhanghao` varchar(200) DEFAULT NULL COMMENT '作者账号',
  `zuozhexingming` varchar(200) DEFAULT NULL COMMENT '作者姓名',
  `zuozheshouji` varchar(200) DEFAULT NULL COMMENT '作者手机',
  `gaojian` varchar(200) NOT NULL COMMENT '稿件',
  `shangchuanshijian` datetime DEFAULT NULL COMMENT '上传时间',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gaojianbianhao` (`gaojianbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='上传稿件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shangchuangaojian`
--

LOCK TABLES `shangchuangaojian` WRITE;
/*!40000 ALTER TABLE `shangchuangaojian` DISABLE KEYS */;
INSERT INTO `shangchuangaojian` VALUES (41,'2022-08-07 01:53:40','1111111111','稿件标题1','稿件类型1','作者账号1','作者姓名1','作者手机1','','2022-08-07 09:53:40','是',''),(42,'2022-08-07 01:53:40','2222222222','稿件标题2','稿件类型2','作者账号2','作者姓名2','作者手机2','','2022-08-07 09:53:40','是',''),(43,'2022-08-07 01:53:40','3333333333','稿件标题3','稿件类型3','作者账号3','作者姓名3','作者手机3','','2022-08-07 09:53:40','是',''),(44,'2022-08-07 01:53:40','4444444444','稿件标题4','稿件类型4','作者账号4','作者姓名4','作者手机4','','2022-08-07 09:53:40','是',''),(45,'2022-08-07 01:53:40','5555555555','稿件标题5','稿件类型5','作者账号5','作者姓名5','作者手机5','','2022-08-07 09:53:40','是',''),(46,'2022-08-07 01:53:40','6666666666','稿件标题6','稿件类型6','作者账号6','作者姓名6','作者手机6','','2022-08-07 09:53:40','是','');
/*!40000 ALTER TABLE `shangchuangaojian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shengaoren`
--

DROP TABLE IF EXISTS `shengaoren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shengaoren` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shengaozhanghao` varchar(200) NOT NULL COMMENT '审稿账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `shengaoxingming` varchar(200) DEFAULT NULL COMMENT '审稿姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` varchar(200) DEFAULT NULL COMMENT '年龄',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  `shengaoshouji` varchar(200) DEFAULT NULL COMMENT '审稿手机',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shengaozhanghao` (`shengaozhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='审稿人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shengaoren`
--

LOCK TABLES `shengaoren` WRITE;
/*!40000 ALTER TABLE `shengaoren` DISABLE KEYS */;
INSERT INTO `shengaoren` VALUES (31,'2022-08-07 01:53:40','审稿账号1','123456','审稿姓名1','男','年龄1','upload/shengaoren_touxiang1.jpg','13823888881'),(32,'2022-08-07 01:53:40','审稿账号2','123456','审稿姓名2','男','年龄2','upload/shengaoren_touxiang2.jpg','13823888882'),(33,'2022-08-07 01:53:40','审稿账号3','123456','审稿姓名3','男','年龄3','upload/shengaoren_touxiang3.jpg','13823888883'),(34,'2022-08-07 01:53:40','审稿账号4','123456','审稿姓名4','男','年龄4','upload/shengaoren_touxiang4.jpg','13823888884'),(35,'2022-08-07 01:53:40','审稿账号5','123456','审稿姓名5','男','年龄5','upload/shengaoren_touxiang5.jpg','13823888885'),(36,'2022-08-07 01:53:40','审稿账号6','123456','审稿姓名6','男','年龄6','upload/shengaoren_touxiang6.jpg','13823888886');
/*!40000 ALTER TABLE `shengaoren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shougao`
--

DROP TABLE IF EXISTS `shougao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shougao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gaojianbianhao` varchar(200) DEFAULT NULL COMMENT '稿件编号',
  `gaojianbiaoti` varchar(200) DEFAULT NULL COMMENT '稿件标题',
  `gaojianleixing` varchar(200) DEFAULT NULL COMMENT '稿件类型',
  `zuozhezhanghao` varchar(200) DEFAULT NULL COMMENT '作者账号',
  `zuozhexingming` varchar(200) DEFAULT NULL COMMENT '作者姓名',
  `zuozheshouji` varchar(200) DEFAULT NULL COMMENT '作者手机',
  `shangchuanshijian` varchar(200) DEFAULT NULL COMMENT '上传时间',
  `gaojian` varchar(200) DEFAULT NULL COMMENT '稿件',
  `bianjizhanghao` varchar(200) DEFAULT NULL COMMENT '编辑账号',
  `bianjixingming` varchar(200) DEFAULT NULL COMMENT '编辑姓名',
  `shengaozhanghao` varchar(200) NOT NULL COMMENT '审稿账号',
  `shengaoxingming` varchar(200) DEFAULT NULL COMMENT '审稿姓名',
  `shougaoshijian` datetime DEFAULT NULL COMMENT '收稿时间',
  `luyongzhuangtai` varchar(200) DEFAULT NULL COMMENT '录用状态',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='收稿';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shougao`
--

LOCK TABLES `shougao` WRITE;
/*!40000 ALTER TABLE `shougao` DISABLE KEYS */;
INSERT INTO `shougao` VALUES (61,'2022-08-07 01:53:40','稿件编号1','稿件标题1','稿件类型1','作者账号1','作者姓名1','作者手机1','上传时间1','','编辑账号1','编辑姓名1','审稿账号1','审稿姓名1','2022-08-07 09:53:40','已录用',1,1,'是',''),(62,'2022-08-07 01:53:40','稿件编号2','稿件标题2','稿件类型2','作者账号2','作者姓名2','作者手机2','上传时间2','','编辑账号2','编辑姓名2','审稿账号2','审稿姓名2','2022-08-07 09:53:40','已录用',2,2,'是',''),(63,'2022-08-07 01:53:40','稿件编号3','稿件标题3','稿件类型3','作者账号3','作者姓名3','作者手机3','上传时间3','','编辑账号3','编辑姓名3','审稿账号3','审稿姓名3','2022-08-07 09:53:40','已录用',3,3,'是',''),(64,'2022-08-07 01:53:40','稿件编号4','稿件标题4','稿件类型4','作者账号4','作者姓名4','作者手机4','上传时间4','','编辑账号4','编辑姓名4','审稿账号4','审稿姓名4','2022-08-07 09:53:40','已录用',4,4,'是',''),(65,'2022-08-07 01:53:40','稿件编号5','稿件标题5','稿件类型5','作者账号5','作者姓名5','作者手机5','上传时间5','','编辑账号5','编辑姓名5','审稿账号5','审稿姓名5','2022-08-07 09:53:40','已录用',5,5,'是',''),(66,'2022-08-07 01:53:40','稿件编号6','稿件标题6','稿件类型6','作者账号6','作者姓名6','作者手机6','上传时间6','','编辑账号6','编辑姓名6','审稿账号6','审稿姓名6','2022-08-07 09:53:40','已录用',6,6,'是','');
/*!40000 ALTER TABLE `shougao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abo','abo','管理员','2022-08-07 01:53:40');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zuozhe`
--

DROP TABLE IF EXISTS `zuozhe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zuozhe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zuozhezhanghao` varchar(200) NOT NULL COMMENT '作者账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `zuozhexingming` varchar(200) DEFAULT NULL COMMENT '作者姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` varchar(200) DEFAULT NULL COMMENT '年龄',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  `zuozheshouji` varchar(200) DEFAULT NULL COMMENT '作者手机',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zuozhezhanghao` (`zuozhezhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='作者';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zuozhe`
--

LOCK TABLES `zuozhe` WRITE;
/*!40000 ALTER TABLE `zuozhe` DISABLE KEYS */;
INSERT INTO `zuozhe` VALUES (11,'2022-08-07 01:53:40','作者账号1','123456','作者姓名1','男','年龄1','upload/zuozhe_touxiang1.jpg','13823888881'),(12,'2022-08-07 01:53:40','作者账号2','123456','作者姓名2','男','年龄2','upload/zuozhe_touxiang2.jpg','13823888882'),(13,'2022-08-07 01:53:40','作者账号3','123456','作者姓名3','男','年龄3','upload/zuozhe_touxiang3.jpg','13823888883'),(14,'2022-08-07 01:53:40','作者账号4','123456','作者姓名4','男','年龄4','upload/zuozhe_touxiang4.jpg','13823888884'),(15,'2022-08-07 01:53:40','作者账号5','123456','作者姓名5','男','年龄5','upload/zuozhe_touxiang5.jpg','13823888885'),(16,'2022-08-07 01:53:40','作者账号6','123456','作者姓名6','男','年龄6','upload/zuozhe_touxiang6.jpg','13823888886');
/*!40000 ALTER TABLE `zuozhe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-07  9:55:51
