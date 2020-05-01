CREATE DATABASE IF NOT EXISTS qacdb;

CREATE TABLE IF NOT EXISTS qacdb.`OrderLine` (
  `OrderLineID` int(3) NOT NULL AUTO_INCREMENT,
  `OrderID` int(3) NOT NULL,
  `ProductID` int(3) NOT NULL,
  `Quantity` int(3) NOT NULL,
  PRIMARY KEY (`OrderLineID`),
  UNIQUE KEY `OrderLineID` (`OrderLineID`),
  KEY `OrderID` (`OrderID`),
  KEY `ProductID` (`ProductID`),
  CONSTRAINT `OrderLine_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `Order` (`OrderID`),
  CONSTRAINT `OrderLine_ibfk_2` FOREIGN KEY (`ProductID`) REFERENCES `Product` (`ProductID`)
  );
