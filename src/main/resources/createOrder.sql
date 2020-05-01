CREATE DATABASE IF NOT EXISTS qacdb;

CREATE TABLE IF NOT EXISTS qacdb.`Order` (
  `OrderID` int(3) NOT NULL AUTO_INCREMENT,
  `CustomerID` int(3) NOT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`OrderID`),
  UNIQUE KEY `OrderID` (`OrderID`),
  KEY `CustomerID` (`CustomerID`),
  CONSTRAINT `Order_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `Customer` (`CustomerID`)
);
