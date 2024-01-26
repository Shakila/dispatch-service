CREATE TABLE `drones` (
  `serial_number` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `weight` int NOT NULL,
  `battery` int NOT NULL,
  `state` varchar(100) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
  PRIMARY KEY (`serial_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
