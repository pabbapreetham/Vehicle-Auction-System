/* ------------------------------------------------------------------------*/
/* Create Table Query for Address Table*/
CREATE TABLE Address (
    addressId int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    line1 varchar(255) NOT NULL,
    line2 varchar(255),
    city varchar(255),
    state varchar(255),
    zipCode varchar(255),
    country varchar(255)
);
/* ------------------------------------------------------------------------*/

/* ------------------------------------------------------------------------*/
/* Create Table Query for SellerCompany Table*/
CREATE TABLE SellerCompany (
    companyId int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    companyName varchar(255) NOT NULL unique,
    addressId int ,
    country varchar(255),
    FOREIGN KEY (addressId) REFERENCES Address(addressId)
);
/* ------------------------------------------------------------------------*/

/* ------------------------------------------------------------------------*/
/* Create Table Query for SubTeam Table*/
CREATE TABLE SubTeam (
    subTeamId int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    subTeamName varchar(255) NOT NULL,
    addressId int ,
    companyId int,
    country varchar(255),
    FOREIGN KEY (addressId) REFERENCES Address(addressId),
    FOREIGN KEY (companyId) REFERENCES SellerCompany(companyId)
);
/* ------------------------------------------------------------------------*/

/* ------------------------------------------------------------------------*/
/* Create Table Query for Seller Table*/
CREATE TABLE Seller (
    sellerId int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    sellerName varchar(255) NOT NULL,
    email varchar(255) UNIQUE NOT NULL,
    phone int,
    ext int,
    isSellerActive bool
);
/* ------------------------------------------------------------------------*/

/* ------------------------------------------------------------------------*/
/* Create Table Query for SubTeamSeller Table*/
CREATE TABLE SubTeamSeller (
    subTeamSellerId int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    subTeamId int NOT NULL,
    sellerId int NOT NULL,
    sellerName varchar(255),
    subTeamName varchar(255) ,
    isLinkActive bool,
    FOREIGN KEY (subTeamId) REFERENCES SubTeam(subTeamId),
    FOREIGN KEY (sellerId) REFERENCES Seller(sellerId)
);
/* ------------------------------------------------------------------------*/

/* ------------------------------------------------------------------------*/
/* Create Table Query for User Table*/
CREATE TABLE User (
    userId int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    sellerId int NOT NULL,
    userName varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    isUserActive bool,
    FOREIGN KEY (sellerId) REFERENCES Seller(sellerId)
);
/* ------------------------------------------------------------------------*/

/* ------------------------------------------------------------------------*/
/* Create Table Query for Vehicle Table*/
CREATE TABLE Vehicle (
    vehicleId int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userId int NOT NULL,
    VIN varchar(255) ,
    modelName varchar(255),
    vehicleCompany varchar(255),
    isAuction bool,
    FOREIGN KEY (userId) REFERENCES User(userId)
);
/* ------------------------------------------------------------------------*/

/* ------------------------------------------------------------------------*/
/* Create Table Query for DirectBuy Table*/
CREATE TABLE DirectBuy (
    directBuyId int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    vehicleId int NOT NULL,
    price int,
    vehicleStatus bool,
    FOREIGN KEY (vehicleId) REFERENCES Vehicle(vehicleId)
);
/* ------------------------------------------------------------------------*/

/* ------------------------------------------------------------------------*/
/* Create Table Query for Auction Table*/
CREATE TABLE Auction (
    auctionId int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    vehicleId int NOT NULL,
    auctionDate varchar(255),
    basePrice int,
    auctionStatus bool,
    FOREIGN KEY (vehicleId) REFERENCES Vehicle(vehicleId)
);
/* ------------------------------------------------------------------------*/

/* ------------------------------------------------------------------------*/
/* TRIGGER query to update user status and sellersubteam status*/
DELIMITER //
CREATE TRIGGER sellerStatusUpdate
	AFTER UPDATE ON seller
	FOR EACH ROW
BEGIN
	IF (NEW.isSellerActive != OLD.isSellerActive) THEN
		UPDATE subteamSeller ss
		SET ss.isLinkActive = NEW.isSellerActive
		WHERE ss.sellerId = NEW.sellerId;
    END IF;
END //
DELIMITER ;
/* ------------------------------------------------------------------------*/

/* ------------------------------------------------------------------------*/
/* VIEW query to get sellers which have user credentials*/
CREATE VIEW `sellerwithuser` AS
    SELECT 
        `s`.`sellerId` AS `sellerId`,
        `s`.`sellerName` AS `sellerName`,
        `u`.`userName` AS `userName`
    FROM
        (`seller` `s`
        JOIN `user` `u` ON ((`s`.`sellerId` = `u`.`sellerId`)));

/* ------------------------------------------------------------------------*/


/* ------------------------------------------------------------------------*/
/* STORED PROCEDURE to create Vehicle details*/
DELIMITER //
CREATE PROCEDURE `createVehicle`(
IN userId int,
IN VIN varchar(255),
IN modelName varchar(255),
IN vehicleCompany varchar(255),
IN isAuction bool,
IN auctionDate varchar(255),
IN basePrice int,
IN auctionStatus bool,
IN price int,
IN vehicleStatus varchar(255)

)
BEGIN
	DECLARE vId int;
    INSERT INTO Vehicle (userId, VIN, modelName, vehicleCompany, isAuction)
    VALUES(userId, VIN, modelName, vehicleCompany, isAuction);
    SELECT vehicleId INTO vId FROM Vehicle v WHERE v.userId = userId AND v.VIN = VIN;
    IF isAuction = true THEN
		INSERT INTO Auction (vehicleId, auctionDate, basePrice, auctionStatus)
        VALUES (vId, auctionDate, basePrice, auctionStatus);
	END IF;
    IF isAuction = false THEN
		INSERT INTO DirectBuy (vehicleId, price, vehicleStatus)
        VALUES (vId, price, vehicleStatus);
	end IF;
END//
DELIMITER ;
/* ------------------------------------------------------------------------*/



/* ------------------------------------------------------------------------*/
/* INSERT queries*/

/* INSERT query to insert Seller Company Data*/
INSERT INTO SellerCompany (companyName, addressId, country) VALUES (#{companyName}, #{addressId} , #{country});

/* INSERT query to insert Seller Data*/
INSERT INTO Seller (sellerName, email, phone, ext, isSellerActive) VALUES (#{sellerName}, #{email} , #{phone},  #{ext}, true);

/* INSERT query to insert User Data*/
INSERT INTO User(sellerId, userName, password, isUserActive) VALUES (#{sellerId}, #{userName}, #{password}, true);

/* ------------------------------------------------------------------------*/



/* ------------------------------------------------------------------------*/
/* SELECT queries*/

/* SELECT query to get Sellers of non-users Data*/
SELECT * FROM Seller s WHERE s.sellerId NOT IN (SELECT su.sellerId FROM sellerWithUser su);

/* SELECT query to get Seller companies Data*/
SELECT * from SellerCompany sc;

/* ------------------------------------------------------------------------*/

/* ------------------------------------------------------------------------*/
/* UPDATE queries*/

/* UPDATE query to update Seller Status*/
UPDATE Seller s SET s.isSellerActive = #{status} WHERE s.sellerId = #{sellerId};

/* ------------------------------------------------------------------------*/

