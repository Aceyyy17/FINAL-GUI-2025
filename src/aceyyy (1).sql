-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2025 at 07:39 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aceyyy`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_diagnose`
--

CREATE TABLE `tbl_diagnose` (
  `diagnose_id` int(20) NOT NULL,
  `patient_id` int(20) NOT NULL,
  `d_name` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `status` varchar(100) NOT NULL,
  `treatment` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_diagnose`
--

INSERT INTO `tbl_diagnose` (`diagnose_id`, `patient_id`, `d_name`, `date`, `status`, `treatment`) VALUES
(1, 6, 'asd', '2025-05-26', 'asd', 'asd'),
(2, 6, 'aaaaaa', '2025-05-26', 'aaaaaa', 'aaaaaaaaa'),
(3, 7, 'qweqwe', '2025-05-26', 'qweqwe', 'qweqwe');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logs`
--

CREATE TABLE `tbl_logs` (
  `l_id` int(20) NOT NULL,
  `Action` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `user_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_logs`
--

INSERT INTO `tbl_logs` (`l_id`, `Action`, `date`, `user_id`) VALUES
(219, 'User ID: 25 logged in', '2025-05-26 21:33:24', 25);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_patients`
--

CREATE TABLE `tbl_patients` (
  `p_id` int(20) NOT NULL,
  `p_fname` varchar(100) NOT NULL,
  `p_lname` varchar(100) NOT NULL,
  `p_pnumber` varchar(100) NOT NULL,
  `p_gender` varchar(100) NOT NULL,
  `p_address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_patients`
--

INSERT INTO `tbl_patients` (`p_id`, `p_fname`, `p_lname`, `p_pnumber`, `p_gender`, `p_address`) VALUES
(6, 'Jhandel', 'Ababon', '0900505400', 'Female', 'Minglanilla'),
(7, 'Mark Anthony', 'Espinosa', '0509522500', 'Male', 'Naga, Cebu');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_recover`
--

CREATE TABLE `tbl_recover` (
  `r_id` int(20) NOT NULL,
  `u_id` int(20) NOT NULL,
  `question1` varchar(255) NOT NULL,
  `question2` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_recover`
--

INSERT INTO `tbl_recover` (`r_id`, `u_id`, `question1`, `question2`) VALUES
(5, 24, 'HtQtuy/nlYeBk45JH3SrR/SYWKZA24TWI8taJcBJH2I=', 'HtQtuy/nlYeBk45JH3SrR/SYWKZA24TWI8taJcBJH2I='),
(6, 25, 'MB5PYIsbI2YzCUe34Q5ZU2VferIoI4Ttd+ydolWV0OE=', 'MB5PYIsbI2YzCUe34Q5ZU2VferIoI4Ttd+ydolWV0OE=');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE `tbl_users` (
  `u_id` int(10) NOT NULL,
  `u_fname` varchar(255) NOT NULL,
  `u_lname` varchar(255) NOT NULL,
  `u_email` varchar(255) NOT NULL,
  `u_username` varchar(255) NOT NULL,
  `u_password` varchar(255) NOT NULL,
  `u_type` varchar(100) NOT NULL,
  `u_status` varchar(100) NOT NULL,
  `u_image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_users`
--

INSERT INTO `tbl_users` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_username`, `u_password`, `u_type`, `u_status`, `u_image`) VALUES
(24, 'Ace Welman', 'Bacus', 'Acey@gmail.com', 'Acey', '3VWxmGJQ17i0rajrZQQ0FM2y66d0Kkfra1Uj5UdPYV0=', 'Admin', 'Active', 'src/userimages/ad.png'),
(25, 'Mark', 'Espinosa', 'Mark@gmail.com', 'Mark', 'MB5PYIsbI2YzCUe34Q5ZU2VferIoI4Ttd+ydolWV0OE=', 'User', 'Active', 'src/userimages/Mark.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_diagnose`
--
ALTER TABLE `tbl_diagnose`
  ADD PRIMARY KEY (`diagnose_id`),
  ADD KEY `pid` (`patient_id`);

--
-- Indexes for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD PRIMARY KEY (`l_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `tbl_patients`
--
ALTER TABLE `tbl_patients`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `tbl_recover`
--
ALTER TABLE `tbl_recover`
  ADD PRIMARY KEY (`r_id`),
  ADD KEY `userid` (`u_id`);

--
-- Indexes for table `tbl_users`
--
ALTER TABLE `tbl_users`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_diagnose`
--
ALTER TABLE `tbl_diagnose`
  MODIFY `diagnose_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `l_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=220;

--
-- AUTO_INCREMENT for table `tbl_patients`
--
ALTER TABLE `tbl_patients`
  MODIFY `p_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tbl_recover`
--
ALTER TABLE `tbl_recover`
  MODIFY `r_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_users`
--
ALTER TABLE `tbl_users`
  MODIFY `u_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_diagnose`
--
ALTER TABLE `tbl_diagnose`
  ADD CONSTRAINT `pid` FOREIGN KEY (`patient_id`) REFERENCES `tbl_patients` (`p_id`);

--
-- Constraints for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `tbl_users` (`u_id`);

--
-- Constraints for table `tbl_recover`
--
ALTER TABLE `tbl_recover`
  ADD CONSTRAINT `userid` FOREIGN KEY (`u_id`) REFERENCES `tbl_users` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
