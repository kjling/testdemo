/*
SQLyog v10.2 
MySQL - 5.5.53 : Database - exam
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`exam` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `exam`;

/*Table structure for table `db_student` */

DROP TABLE IF EXISTS `db_student`;

CREATE TABLE `db_student` (
  `sysid` int(11) NOT NULL AUTO_INCREMENT,
  `studentID` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `studentName` varchar(255) DEFAULT NULL,
  `result` int(11) DEFAULT NULL,
  `sclass` varchar(255) NOT NULL,
  PRIMARY KEY (`sysid`),
  UNIQUE KEY `studentID` (`studentID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `db_student` */

insert  into `db_student`(`sysid`,`studentID`,`password`,`studentName`,`result`,`sclass`) values (1,'1321152232','49ba59abbe56e057','吴俊川',20,'移动云办公'),(3,'1321162105','49ba59abbe56e057','陈鹏民',NULL,'移动云办公'),(4,'1321162119','49ba59abbe56e057','黄小宴',NULL,'移动云办公'),(5,'10000','49ba59abbe56e057','中国电信',NULL,'会计信息化'),(6,'10010','49ba59abbe56e057','中国联通',NULL,'新媒体工程'),(7,'10086','49ba59abbe56e057','中国移动',NULL,'移动云办公'),(12,'110','49ba59abbe56e057','警察',NULL,'移动云办公'),(13,'gepanjiang','49ba59abbe56e057','gepanjiang',20,'会计信息化'),(14,'gpj','49ba59abbe56e057','gpj',NULL,'移动云办公');

/*Table structure for table `db_subject` */

DROP TABLE IF EXISTS `db_subject`;

CREATE TABLE `db_subject` (
  `stID` int(11) NOT NULL AUTO_INCREMENT,
  `stTitle` varchar(255) NOT NULL,
  `stOptionA` varchar(255) NOT NULL,
  `stOptionB` varchar(255) NOT NULL,
  `stOptionC` varchar(255) NOT NULL,
  `stOptionD` varchar(255) NOT NULL,
  `stAnswer` varchar(255) NOT NULL,
  `stParse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `db_subject` */

insert  into `db_subject`(`stID`,`stTitle`,`stOptionA`,`stOptionB`,`stOptionC`,`stOptionD`,`stAnswer`,`stParse`) values (1,'如果希望监听TCP端口9000，应该怎样创建socket?','new Socket(\"localhost\",9000);','new ServerSocket(9000);','new Socket(9000);','new ServerSocket(\"localhost\",9000);','B','ServerSocket（int port）方法创建一个server socket 绑定一个端口'),(2,'下列哪项不属于jdk1.6垃圾收集器？','Serail收集器','parNew收集器','CMS收集器','G1收集器','D','G1收集器现在只是出于理论研究成果阶段，还未投入使用'),(3,'在JAVA中，下面关于String类和StringBuffer类的描述正确的是那一个？','StringBuffer类的对象调用toString（）方法将转换为String类型','两个类都有append（）方法','可以直接将字符串“test”赋值给声明的Stirng类和StringBuffer类的变量','两个类的实例的值都能够被改变','A','A. StringBuffer类调用toString（）方法后将转换为String类型   正确\r\nB. String类型中没有append（）方法\r\nC. 可以直接将字符串“test”复制给声明的Stirng类的变量，而StringBuffer类的不行\r\nD. String类的实例只能被改变，因为String是不可变的'),(4,'关于bootstrap3的说法，错误的是','在windows上支持IE8','在IOS上支持Opera','在MAC OS及Windows上支持firefox','在IOS及android上都支持chrome','B',''),(5,'下面有关JAVA异常类的描述，说法错误的是？','异常的继承结构：基类为Throwable，Error和Exception继承Throwable，RuntimeException和IOException等继承Exception','非RuntimeException一般是外部错误，其必须被 try{}catch语句块所捕获','Error类体系描述了Java运行系统中的内部错误以及资源耗尽的情形，Error不需要捕捉','RuntimeException体系包括错误的类型转换、数组越界访问和试图访问空指针等等，必须被 try{}catch语句块所捕获','D','runTimeException不需要捕获'),(6,'JAVA语言的下面几种数组复制方法中，哪个效率最高？','for循环逐一复制','System.arraycopy','System.copyof','使用clone方法','B','具体的理由不好说。不过一致的说法和实验证明是arraycopy（)效率高！！！T...T'),(7,'在Java中，关于HashMap类的描述，以下错误的是','HashMap使用键/值得形式保存数据','HashMap 能够保证其中元素的顺序','HashMap允许将null用作键','HashMap允许将null用作值','B','基于哈希表的Map接口的实现。此实现提供所有可选的映射操作，并允许使用null值和null键。此类不保证映射的顺序，特别是它不保证该顺序恒久不变');

/*Table structure for table `db_teacher` */

DROP TABLE IF EXISTS `db_teacher`;

CREATE TABLE `db_teacher` (
  `sysid` int(11) NOT NULL AUTO_INCREMENT,
  `teacherID` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`sysid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `db_teacher` */

insert  into `db_teacher`(`sysid`,`teacherID`,`password`) values (1,'admin','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
