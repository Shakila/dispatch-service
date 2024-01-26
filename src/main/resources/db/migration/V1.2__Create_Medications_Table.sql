CREATE TABLE `medications` (
  `code` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `picture` text DEFAULT NULL,
  `weight` int NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
