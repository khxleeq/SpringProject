DROP TABLE IF EXISTS `flower` CASCADE;

CREATE TABLE `flower`(
`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(255),
`colour` VARCHAR(255),
`scent` VARCHAR(255)
);
