CREATE DATABASE IF NOT EXISTS qacdb;

CREATE TABLE IF NOT EXISTS qacdb.`Customer` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(255) DEFAULT NULL,
  `Surname` varchar(255) DEFAULT NULL,
  `PhoneNumber` varchar(11) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Postcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CustomerID`),
  UNIQUE KEY `CustomerID` (`CustomerID`)
);
