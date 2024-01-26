CREATE TABLE `available_medications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `drone` varchar(100) NOT NULL,
  `medication_code` varchar(100) NOT NULL
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
  PRIMARY KEY (`id`),
  CONSTRAINT FK_DRONE FOREIGN KEY (`drone`) REFERENCES drones(`serial_number`),
  CONSTRAINT FK_MEDICATION FOREIGN KEY (`medication_code`) REFERENCES medications(`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
