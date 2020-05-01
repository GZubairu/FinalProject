CREATE DATABASE IF NOT EXISTS qacdb;

CREATE TABLE IF NOT EXISTS qacdb.`Product` (
  `ProductID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(255) DEFAULT NULL,
  `ProductDescription` varchar(255) DEFAULT NULL,
  `Price` int(5) DEFAULT NULL,
  PRIMARY KEY (`ProductID`),
  UNIQUE KEY `ProductID` (`ProductID`)
);
