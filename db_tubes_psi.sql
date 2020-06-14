-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2020 at 08:51 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tubes_psi`
--

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `id` int(11) NOT NULL,
  `id_assistant` int(11) NOT NULL,
  `id_praktikum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`id`, `id_assistant`, `id_praktikum`) VALUES
(3, 4, 5),
(4, 3, 2),
(6, 52, 11),
(7, 53, 10);

-- --------------------------------------------------------

--
-- Table structure for table `praktikum`
--

CREATE TABLE `praktikum` (
  `id` int(11) NOT NULL,
  `mata_praktikum` varchar(64) NOT NULL,
  `ruangan` varchar(64) NOT NULL,
  `hari` varchar(50) NOT NULL,
  `jam` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `praktikum`
--

INSERT INTO `praktikum` (`id`, `mata_praktikum`, `ruangan`, `hari`, `jam`) VALUES
(1, 'Internet dan Teknologi Web', 'SB 601', 'Monday', '07.00 - 08.40'),
(2, 'Pemrograman Web', 'SB 601', 'Monday', '08.40 - 10.30'),
(3, 'Pengaksesan Basis Data', 'SB 601', 'Tuesday', '08.40 - 10.30'),
(4, 'Rekayasa Web', 'SB 604', 'Tuesday', '13.00 - 14.20'),
(5, 'Sistem Aplikasi Bergerak', 'SB 604', 'Tuesday', '07.00 - 08.40'),
(6, 'Infrastruktur Pendukung Aplikasi', 'SB 603', 'Wednesday', '13.00 - 14.20'),
(7, 'Pola Pikir Komputasional', 'SB 601', 'Wednesday', '15.30 - 17.30'),
(8, 'Rekayasa Perangkat Lunak', 'SB 603', 'Thursday', '07.00 - 08.40'),
(9, 'Pengaksesan Basis Data', 'SB 601', 'Thursday', '08.40 - 10.30'),
(10, 'Algoritma dan Pemrograman', 'SB 605', 'Friday', '13.00 - 14.20'),
(11, 'Pembangunan Sistem Berbasis Komponen', 'SB 601', 'Thursday', '14.20-16.00');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `name`, `email`, `password`, `role_id`) VALUES
(3, 'Ega Novianingsih', 'ega@mail.com', '827ccb0eea8a706c4c34a16891f84e7b', 2),
(4, 'Adhy Wiranto Sudjana', 'adhy@mail.com', '827ccb0eea8a706c4c34a16891f84e7b', 2),
(51, 'Admin Baru', 'root', '21232f297a57a5a743894a0e4a801fc3', 1),
(52, 'Zikri Alhaq', 'zikri@mail.com', '1234', 2),
(53, 'Rian', 'rian@mail.com', '1234', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `id_role` int(11) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id_role`, `role`) VALUES
(1, 'Admin'),
(2, 'Assistant');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_assistant`),
  ADD KEY `id_praktik` (`id_praktikum`);

--
-- Indexes for table `praktikum`
--
ALTER TABLE `praktikum`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `role_id` (`role_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id_role`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `praktikum`
--
ALTER TABLE `praktikum`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD CONSTRAINT `jadwal_ibfk_1` FOREIGN KEY (`id_praktikum`) REFERENCES `praktikum` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `jadwal_ibfk_2` FOREIGN KEY (`id_assistant`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id_role`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
