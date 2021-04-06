-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2021 at 11:37 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coffeemanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `ct_hoadon`
--

CREATE TABLE `ct_hoadon` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_HD` int(10) UNSIGNED NOT NULL,
  `id_SP` int(10) UNSIGNED NOT NULL,
  `amount` int(10) UNSIGNED DEFAULT NULL,
  `price` float DEFAULT NULL,
  `promotion_price` float DEFAULT NULL,
  `total_money` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ct_khuyenmai`
--

CREATE TABLE `ct_khuyenmai` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_KM` int(10) UNSIGNED DEFAULT NULL,
  `id_SP` int(10) UNSIGNED DEFAULT NULL,
  `discount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ct_phieunhaphang`
--

CREATE TABLE `ct_phieunhaphang` (
  `id_PNH` int(10) UNSIGNED NOT NULL,
  `id_NL` int(11) UNSIGNED DEFAULT NULL,
  `amount` int(10) UNSIGNED DEFAULT NULL,
  `price` float DEFAULT NULL,
  `total_money` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_KH` int(10) UNSIGNED NOT NULL,
  `id_KM` int(10) UNSIGNED NOT NULL,
  `id_NV` int(10) UNSIGNED NOT NULL,
  `total_money` float DEFAULT NULL,
  `total_promo` float DEFAULT NULL,
  `total_remaining_money` float DEFAULT NULL,
  `create_day` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `id_KH` int(10) UNSIGNED NOT NULL,
  `id_HD` int(10) UNSIGNED NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `id_KM` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `loai`
--

CREATE TABLE `loai` (
  `id_Loai` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `nguyenlieu`
--

CREATE TABLE `nguyenlieu` (
  `id_NL` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `amount` int(10) UNSIGNED DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `nguyenlieudadung`
--

CREATE TABLE `nguyenlieudadung` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_NL` int(10) UNSIGNED NOT NULL,
  `id_SP` int(10) UNSIGNED NOT NULL,
  `amount_material` int(10) UNSIGNED DEFAULT NULL,
  `amount_product` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `id_NCC` int(10) UNSIGNED NOT NULL,
  `name_NCC` varchar(50) NOT NULL,
  `address` text DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `id_NV` int(10) UNSIGNED NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `age` int(10) UNSIGNED DEFAULT NULL,
  `gender` enum('male','female') DEFAULT NULL,
  `address` text DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `start_day` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `nhiemvu`
--

CREATE TABLE `nhiemvu` (
  `id_duty` int(10) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phieunhaphang`
--

CREATE TABLE `phieunhaphang` (
  `id_PNH` int(10) UNSIGNED NOT NULL,
  `id_NCC` int(11) UNSIGNED NOT NULL,
  `id_NV` int(11) UNSIGNED NOT NULL,
  `date_add` date NOT NULL,
  `total_money` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `quyen`
--

CREATE TABLE `quyen` (
  `id_permission` int(10) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `quyencuanhiemvu`
--

CREATE TABLE `quyencuanhiemvu` (
  `id_permission` int(10) NOT NULL,
  `id_duty` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id_SP` int(10) UNSIGNED NOT NULL,
  `id_Loai` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `descrption` text DEFAULT NULL,
  `amount` int(10) UNSIGNED DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id_TK` int(10) UNSIGNED NOT NULL,
  `id_NV` int(10) UNSIGNED NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `id_permission` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ct_hoadon`
--
ALTER TABLE `ct_hoadon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_HD` (`id_HD`),
  ADD KEY `id_SP` (`id_SP`);

--
-- Indexes for table `ct_khuyenmai`
--
ALTER TABLE `ct_khuyenmai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_KM` (`id_KM`),
  ADD KEY `id_SP` (`id_SP`);

--
-- Indexes for table `ct_phieunhaphang`
--
ALTER TABLE `ct_phieunhaphang`
  ADD PRIMARY KEY (`id_PNH`),
  ADD KEY `id_NL` (`id_NL`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_KH` (`id_KH`),
  ADD KEY `id_KM` (`id_KM`),
  ADD KEY `id_NV` (`id_NV`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id_KH`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`id_KM`);

--
-- Indexes for table `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`id_Loai`);

--
-- Indexes for table `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  ADD PRIMARY KEY (`id_NL`);

--
-- Indexes for table `nguyenlieudadung`
--
ALTER TABLE `nguyenlieudadung`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_NL` (`id_NL`),
  ADD KEY `id_SP` (`id_SP`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`id_NCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`id_NV`);

--
-- Indexes for table `nhiemvu`
--
ALTER TABLE `nhiemvu`
  ADD PRIMARY KEY (`id_duty`);

--
-- Indexes for table `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD PRIMARY KEY (`id_PNH`),
  ADD KEY `id_NCC` (`id_NCC`),
  ADD KEY `id_NV` (`id_NV`);

--
-- Indexes for table `quyen`
--
ALTER TABLE `quyen`
  ADD PRIMARY KEY (`id_permission`);

--
-- Indexes for table `quyencuanhiemvu`
--
ALTER TABLE `quyencuanhiemvu`
  ADD KEY `id_permission` (`id_permission`),
  ADD KEY `id_duty` (`id_duty`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id_SP`),
  ADD KEY `id_Loai` (`id_Loai`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id_TK`),
  ADD KEY `id_NV` (`id_NV`),
  ADD KEY `taikhoan_ibfk_2` (`id_permission`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ct_hoadon`
--
ALTER TABLE `ct_hoadon`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ct_khuyenmai`
--
ALTER TABLE `ct_khuyenmai`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ct_phieunhaphang`
--
ALTER TABLE `ct_phieunhaphang`
  MODIFY `id_PNH` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id_KH` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `id_KM` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loai`
--
ALTER TABLE `loai`
  MODIFY `id_Loai` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  MODIFY `id_NL` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nguyenlieudadung`
--
ALTER TABLE `nguyenlieudadung`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `id_NCC` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `id_NV` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nhiemvu`
--
ALTER TABLE `nhiemvu`
  MODIFY `id_duty` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  MODIFY `id_PNH` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `quyen`
--
ALTER TABLE `quyen`
  MODIFY `id_permission` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id_SP` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id_TK` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ct_hoadon`
--
ALTER TABLE `ct_hoadon`
  ADD CONSTRAINT `ct_hoadon_ibfk_1` FOREIGN KEY (`id_HD`) REFERENCES `hoadon` (`id`),
  ADD CONSTRAINT `ct_hoadon_ibfk_2` FOREIGN KEY (`id_SP`) REFERENCES `sanpham` (`id_SP`);

--
-- Constraints for table `ct_khuyenmai`
--
ALTER TABLE `ct_khuyenmai`
  ADD CONSTRAINT `ct_khuyenmai_ibfk_1` FOREIGN KEY (`id_KM`) REFERENCES `khuyenmai` (`id_KM`),
  ADD CONSTRAINT `ct_khuyenmai_ibfk_2` FOREIGN KEY (`id_SP`) REFERENCES `sanpham` (`id_SP`);

--
-- Constraints for table `ct_phieunhaphang`
--
ALTER TABLE `ct_phieunhaphang`
  ADD CONSTRAINT `ct_phieunhaphang_ibfk_1` FOREIGN KEY (`id_NL`) REFERENCES `nguyenlieu` (`id_NL`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`id_KH`) REFERENCES `khachhang` (`id_KH`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`id_KM`) REFERENCES `khuyenmai` (`id_KM`),
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`id_NV`) REFERENCES `nhanvien` (`id_NV`);

--
-- Constraints for table `nguyenlieudadung`
--
ALTER TABLE `nguyenlieudadung`
  ADD CONSTRAINT `nguyenlieudadung_ibfk_1` FOREIGN KEY (`id_NL`) REFERENCES `nguyenlieu` (`id_NL`),
  ADD CONSTRAINT `nguyenlieudadung_ibfk_2` FOREIGN KEY (`id_SP`) REFERENCES `sanpham` (`id_SP`);

--
-- Constraints for table `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD CONSTRAINT `phieunhaphang_ibfk_1` FOREIGN KEY (`id_NCC`) REFERENCES `nhacungcap` (`id_NCC`),
  ADD CONSTRAINT `phieunhaphang_ibfk_2` FOREIGN KEY (`id_NV`) REFERENCES `nhanvien` (`id_NV`);

--
-- Constraints for table `quyencuanhiemvu`
--
ALTER TABLE `quyencuanhiemvu`
  ADD CONSTRAINT `id_duty` FOREIGN KEY (`id_duty`) REFERENCES `nhiemvu` (`id_duty`),
  ADD CONSTRAINT `id_permission` FOREIGN KEY (`id_permission`) REFERENCES `quyen` (`id_permission`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`id_Loai`) REFERENCES `loai` (`id_Loai`);

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`id_NV`) REFERENCES `nhanvien` (`id_NV`),
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`id_permission`) REFERENCES `quyen` (`id_permission`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
