DROP TABLE IF EXISTS `pictures`;
DROP TABLE IF EXISTS `shops`;

CREATE TABLE `shops` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `cap` int NOT NULL);

CREATE TABLE `pictures` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `date` varchar(45) NOT NULL,
  `shop_id` int NOT NULL);