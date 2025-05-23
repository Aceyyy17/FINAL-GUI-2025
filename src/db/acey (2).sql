-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2025 at 01:27 AM
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
-- Database: `acey`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_diagnose`
--

CREATE TABLE `tbl_diagnose` (
  `diagnose_id` int(20) NOT NULL,
  `patient_id` int(20) NOT NULL,
  `doctor_specialist_id` int(20) NOT NULL,
  `d_name` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `status` varchar(50) NOT NULL,
  `u_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_doctor_specialist`
--

CREATE TABLE `tbl_doctor_specialist` (
  `doctor_specialist_id` int(20) NOT NULL,
  `d_fname` varchar(100) NOT NULL,
  `d_lname` varchar(100) NOT NULL,
  `specialist` varchar(150) NOT NULL,
  `user_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(32, 'User with ID 6 logged in', '2025-05-23 04:27:27', 6),
(33, 'Deleted Users with ID No: 8', '2025-05-23 04:29:58', 6),
(34, 'Deleted Users with ID No: 6', '2025-05-23 04:30:25', 6),
(35, 'Deleted Users with ID No: 6', '2025-05-23 04:30:29', 6),
(36, 'User with ID 6 logged in', '2025-05-23 04:42:18', 6),
(37, 'Deleted Users with ID No: 9', '2025-05-23 04:44:23', 6),
(38, 'User with ID 6 logged in', '2025-05-23 07:49:39', 6),
(39, 'User with ID 6 logged in', '2025-05-23 07:51:06', 6),
(40, 'User with ID 6 logged in', '2025-05-23 07:52:53', 6),
(41, 'User with ID 6 logged in', '2025-05-23 12:35:27', 6),
(48, 'User with ID 6 logged in', '2025-05-23 14:00:52', 6),
(49, 'User with ID 6 logging out', '2025-05-23 14:02:00', 6),
(50, 'User with ID 6 logged in', '2025-05-23 14:02:08', 6),
(51, 'User with ID 6 logged in', '2025-05-23 14:31:06', 6),
(52, 'User with ID 6 logged in', '2025-05-23 14:33:57', 6),
(53, 'User with ID 6 logged in', '2025-05-23 14:43:13', 6),
(54, 'User with ID 6 logged in', '2025-05-23 14:44:30', 6),
(55, 'User with ID 6 logged in', '2025-05-23 14:47:06', 6),
(56, 'User with ID 6 logged in', '2025-05-23 14:50:42', 6),
(57, 'Deleted Users with ID No: 10', '2025-05-23 14:50:57', 6),
(58, 'User with ID 6 logged in', '2025-05-23 14:54:16', 6),
(59, 'User with ID 6 logged in', '2025-05-23 14:55:14', 6);

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
(6, 'Ace Welman', 'Bacus', 'acey@gmail.com', 'Acey', '3VWxmGJQ17i0rajrZQQ0FM2y66d0Kkfra1Uj5UdPYV0=', 'Admin', 'Active', 'src/userimages/ace.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_diagnose`
--
ALTER TABLE `tbl_diagnose`
  ADD PRIMARY KEY (`diagnose_id`),
  ADD KEY `pid` (`patient_id`),
  ADD KEY `dspid` (`doctor_specialist_id`),
  ADD KEY `uid` (`u_id`);

--
-- Indexes for table `tbl_doctor_specialist`
--
ALTER TABLE `tbl_doctor_specialist`
  ADD PRIMARY KEY (`doctor_specialist_id`);

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
  MODIFY `diagnose_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_doctor_specialist`
--
ALTER TABLE `tbl_doctor_specialist`
  MODIFY `doctor_specialist_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `l_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `tbl_patients`
--
ALTER TABLE `tbl_patients`
  MODIFY `p_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_recover`
--
ALTER TABLE `tbl_recover`
  MODIFY `r_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_users`
--
ALTER TABLE `tbl_users`
  MODIFY `u_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_diagnose`
--
ALTER TABLE `tbl_diagnose`
  ADD CONSTRAINT `dspid` FOREIGN KEY (`doctor_specialist_id`) REFERENCES `tbl_doctor_specialist` (`doctor_specialist_id`),
  ADD CONSTRAINT `pid` FOREIGN KEY (`patient_id`) REFERENCES `tbl_patients` (`p_id`),
  ADD CONSTRAINT `uid` FOREIGN KEY (`u_id`) REFERENCES `tbl_users` (`u_id`);

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
