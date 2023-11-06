# clc-healthmilestone









DDL SCRIPT:
-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Nov 06, 2023 at 05:29 AM
-- Server version: 5.7.24
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clc_milestone`
--

-- --------------------------------------------------------

--
-- Table structure for table `donations`
--

CREATE TABLE `donations` (
  `ID` int(11) NOT NULL,
  `organ` varchar(255) DEFAULT NULL,
  `donation_date` datetime DEFAULT NULL,
  `user_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `donations`
--

INSERT INTO `donations` (`ID`, `organ`, `donation_date`, `user_ID`) VALUES
(1, 'Heart', '2023-03-15 00:00:00', 2),
(2, 'Liver', '2021-11-09 00:00:00', 3);

-- --------------------------------------------------------

--
-- Table structure for table `medicines`
--

CREATE TABLE `medicines` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `strength` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `num_servings` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `medicines`
--

INSERT INTO `medicines` (`ID`, `name`, `type`, `strength`, `quantity`, `num_servings`) VALUES
(1, 'Peneciline', 'Antibiotic', '250mg', 90, 45),
(2, 'Adderall', 'Dextroamphetamine-amphetamine', '20mg', 60, 30),
(3, 'Percocet', 'Acetaminophen', '10mg', 20, 20),
(4, 'Ibuprophen', 'NSAID', '600mg', 100, 50);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `first_name`, `last_name`, `phone_number`, `email`, `username`, `password`) VALUES
(1, 'John', 'Smith', '3609876543', 'john_smith@gmail.com', 'john', 'smith1'),
(2, 'Mark', 'Cuban', '1234567890', 'mark_cuban@hotmail.com', 'mark', 'cuban1'),
(3, 'Mary', 'Bryant', '6785346892', 'mary_bryant@gmail.com', 'mary', 'bryant1'),
(4, 'Klay', 'Thompson', '4256784545', 'klay_thompson@gmail.com', 'klay', 'thompson1'),
(5, 'Gavin', 'Kuehn', '6027393046', 'gdkuehn03@gmail.com', 'C3Quil', '12345678');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `donations`
--
ALTER TABLE `donations`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `user_ID` (`user_ID`);

--
-- Indexes for table `medicines`
--
ALTER TABLE `medicines`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `donations`
--
ALTER TABLE `donations`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `medicines`
--
ALTER TABLE `medicines`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `donations`
--
ALTER TABLE `donations`
  ADD CONSTRAINT `donations_ibfk_1` FOREIGN KEY (`user_ID`) REFERENCES `users` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
