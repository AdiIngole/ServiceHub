CREATE DATABASE `service_hub` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `admin` (
  `adminid` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `appointment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cuname` varchar(255) DEFAULT NULL,
  `spuname` varchar(255) DEFAULT NULL,
  `appointment_date_time` datetime DEFAULT NULL,
  `spemail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `designation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `designation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `email_generate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `reciption` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `feedback` (
  `fid` int NOT NULL AUTO_INCREMENT,
  `feedback` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `mob` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `sp_final` (
  `sp_id` int NOT NULL AUTO_INCREMENT,
  `aadhar_image` mediumblob NOT NULL,
  `aadhar_number` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `dateofbirth` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `experiance` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `high_qualification` varchar(255) DEFAULT NULL,
  `licence_certificate` mediumblob NOT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `mob_number` varchar(255) DEFAULT NULL,
  `office_address` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `photo` mediumblob NOT NULL,
  `qualification_certificate` mediumblob NOT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `tahsil` varchar(255) DEFAULT NULL,
  `university_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `sp_request` (
  `sp_id` int NOT NULL AUTO_INCREMENT,
  `aadhar_image` mediumblob NOT NULL,
  `aadhar_number` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `dateofbirth` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `experiance` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `high_qualification` varchar(255) DEFAULT NULL,
  `licence_certificate` mediumblob NOT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `mob_number` varchar(255) DEFAULT NULL,
  `office_address` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `photo` mediumblob NOT NULL,
  `qualification_certificate` mediumblob NOT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `tahsil` varchar(255) DEFAULT NULL,
  `university_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `user_registration` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `dateofbirth` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `mobilenumber` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `tahasil` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `is_appointment_scheduled` bit(1) DEFAULT NULL,
  `is_rejected` bit(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `validation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
