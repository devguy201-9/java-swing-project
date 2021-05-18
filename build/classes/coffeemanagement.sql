-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2021 at 03:03 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5

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
  `id_HD` int(10) UNSIGNED NOT NULL,
  `id_SP` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `amount` int(10) UNSIGNED DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ct_hoadon`
--

INSERT INTO `ct_hoadon` (`id_HD`, `id_SP`, `name`, `amount`, `price`) VALUES
(2, 8, 'Latte', 2, 50000),
(2, 4, 'Chocolate Đá Xay', 3, 55000);

-- --------------------------------------------------------

--
-- Table structure for table `ct_phieunhaphang`
--

CREATE TABLE `ct_phieunhaphang` (
  `id_PNH` int(10) UNSIGNED DEFAULT NULL,
  `id_NL` int(11) UNSIGNED DEFAULT NULL,
  `amount` int(10) UNSIGNED DEFAULT NULL,
  `price` float DEFAULT NULL,
  `total_money` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ct_phieunhaphang`
--

INSERT INTO `ct_phieunhaphang` (`id_PNH`, `id_NL`, `amount`, `price`, `total_money`) VALUES
(8, 1, 21, 50000, 1050000),
(8, 2, 32, 55000, 1760000);

-- --------------------------------------------------------

--
-- Table structure for table `ct_quyen`
--

CREATE TABLE `ct_quyen` (
  `id_permission` int(10) NOT NULL,
  `id_duty` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ct_quyen`
--

INSERT INTO `ct_quyen` (`id_permission`, `id_duty`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(2, 1),
(2, 2),
(2, 4),
(2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `danhmuc`
--

CREATE TABLE `danhmuc` (
  `id_duty` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `image` varchar(50) DEFAULT NULL,
  `image_hover` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `danhmuc`
--

INSERT INTO `danhmuc` (`id_duty`, `name`, `image`, `image_hover`) VALUES
(1, 'Bán hàng', 'Shop_20px.png', 'Shop_20px_active.png'),
(2, 'Quản lý Sản Phẩm', 'QLSP_20px.png', 'QLSP_20px_active.png'),
(3, 'Quản lý nhân viên', 'NhanVien_20px.png', 'NhanVien_20px_active.png'),
(4, 'Quản lý Khách Hàng', 'KhachHang_20px.png', 'KhachHang_20px_active.png'),
(5, 'Nhập & Xuất', 'ThongKe_20px.png', 'ThongKe_20px_active.png'),
(6, 'Nhà cung cấp', 'CongCu_20px.png', 'CongCu_20px_active.png'),
(7, 'Tài Khoản', 'CaiDat_20px.png', 'CaiDat_20px_active.png'),
(8, 'Thống kê', 'ThongKe_20px.png', 'ThongKe_20px_active.png');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_KH` int(10) UNSIGNED NOT NULL,
  `id_NV` int(10) UNSIGNED NOT NULL,
  `total_money` float DEFAULT NULL,
  `create_day` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`id`, `id_KH`, `id_NV`, `total_money`, `create_day`) VALUES
(1, 1, 1, 260000, '2021-05-12 07:20:02'),
(2, 1, 1, 324000, '2021-05-16 11:22:06');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `id_KH` int(10) UNSIGNED NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`id_KH`, `first_name`, `last_name`, `phone`) VALUES
(1, 'Quá', 'Dương', '0124352565'),
(2, 'Như', 'Võ', '0893757393'),
(3, 'Long', 'Cô', '08577568343'),
(4, 'Tiễn', 'Dương', '0868358383'),
(5, 'Tào', 'Tháo', '0249289385'),
(6, 'Thanh Thiên', 'Thiên', '0586538533');

-- --------------------------------------------------------

--
-- Table structure for table `loai`
--

CREATE TABLE `loai` (
  `id_Loai` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loai`
--

INSERT INTO `loai` (`id_Loai`, `name`) VALUES
(1, 'Bánh Mặn'),
(2, 'Bánh Ngọt'),
(3, 'Cà Phê Pha Máy'),
(4, 'Cà Phê Truyền Thống'),
(5, 'Đá Xay'),
(6, 'Trà Trái Cây'),
(7, 'Trà Tươi');

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

--
-- Dumping data for table `nguyenlieu`
--

INSERT INTO `nguyenlieu` (`id_NL`, `name`, `amount`, `price`) VALUES
(1, 'Cafe Nguyên Chất', 41, 50000),
(2, 'Cafe Rang ', 64, 55000),
(3, 'Sữa Tươi Nguyên Kem', 12, 120000);

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

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`id_NCC`, `name_NCC`, `address`, `phone`) VALUES
(1, 'Đại Hải', 'Cao Bằng', '04897935794'),
(2, 'Thành Phát', '24, Đắc Lắc', '0248394927'),
(3, 'Nại Hà', 'Cầu Giấy, Hà Nội', '0427385067'),
(4, 'Trang Phùng', 'Sài Gòn', '0656432353'),
(5, 'Thái Nguyên', 'Buôn Mê Thuột, Tây Nguyên', '0849375835');

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
  `start_day` date DEFAULT NULL,
  `img` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`id_NV`, `name`, `age`, `gender`, `address`, `phone`, `start_day`, `img`) VALUES
(1, 'admin', 20, 'male', 'Cục hàng không vũ trụ NASA', '0123456789', '2021-04-17', '001.jpg'),
(2, 'Võ Hoàng Quỳnh Như', 20, 'female', 'Bình Chánh', '0375661537', '2021-05-12', '002.jpg'),
(3, 'Võ Quang Thuận', 20, 'male', 'Quận 11', '0848383573', '2021-05-18', 'tAP43hcA.jpg'),
(4, 'Trần Gia Thuân', 20, 'male', 'Hóc Môn', '0853858243', '2021-05-18', 'lf9rqEFk.jpg');

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

--
-- Dumping data for table `phieunhaphang`
--

INSERT INTO `phieunhaphang` (`id_PNH`, `id_NCC`, `id_NV`, `date_add`, `total_money`) VALUES
(1, 1, 1, '2021-05-12', 0),
(2, 1, 2, '2021-05-12', 0),
(3, 1, 2, '2021-05-12', 0),
(4, 3, 2, '2021-05-15', 0),
(5, 3, 1, '2021-05-15', 0),
(6, 3, 2, '2021-05-16', 0),
(7, 2, 2, '2021-05-16', 0),
(8, 2, 2, '2021-05-16', 2810000);

-- --------------------------------------------------------

--
-- Table structure for table `quyen`
--

CREATE TABLE `quyen` (
  `id_permission` int(10) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `quyen`
--

INSERT INTO `quyen` (`id_permission`, `name`) VALUES
(1, 'admin'),
(2, 'nhân viên');

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
  `price` float DEFAULT NULL,
  `img` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id_SP`, `id_Loai`, `name`, `descrption`, `amount`, `price`, `img`) VALUES
(1, 1, 'Bánh Mì Chà Bông Phô Mai', 'Bánh mì tươi kết hợp với chà bông và phô mai', NULL, 30000, 'bky-001.jpg'),
(2, 1, 'Bánh Bông Lan Trứng Muối', 'Bánh mềm xốp kết hợp trứng muối thơm ngon', NULL, 30000, 'bky-002.jpg'),
(3, 1, 'Bánh Mì Chả Lụa Xá Xíu', 'Bánh mì giòn thơm với chả lụa và thịt xá xíu thơm ngon, kết hợp cùng rau và gia vị, hòa quyện cùng n', NULL, 20000, 'bky-003.jpg'),
(4, 2, 'Mousse Canh Dây', 'Một sự kết hợp khéo léo giữa kem và lớp bánh mềm, được phủ lên trên xốt chanh dây ngon tuyệt.', NULL, 29000, 'cak-001.jpg'),
(5, 2, 'Mousse Red Vervet', 'Một sự kết hợp khéo léo giữa kem và lớp bánh mềm, với màu sắc đẹp mắt', NULL, 29000, 'cak-002.jpg'),
(6, 2, 'Bánh Phô Mai Trà Xanh', 'Một sự sáng tạo mới mẻ, kết hợp giữa trà xanh đậm đà và phô mai ít béo.', NULL, 29000, 'cak-003.jpg'),
(7, 3, 'Cappuccino', 'Bắt đầu với cà phê espresso, sau đó thêm một lượng tương đương giữa sữa tươi và bọt sữa', NULL, 50000, 'mcf-001.jpg'),
(8, 3, 'Latte', 'Bắt đầu với cà phê espresso, sau đó thêm một lượng tương đương giữa sữa tươi và bọt sữa', NULL, 50000, 'mcf-002.jpg'),
(9, 3, 'Caramel Macchiato', 'Bắt đầu từ dòng sữa tươi và lớp bọt sữa, sau đó hòa quyện cùng cà phê espresso đậm đà và sốt caramel', NULL, 59000, 'mcf-003.jpg'),
(10, 4, 'Cà Phê Đen Đá', 'Cà phê đậm đà pha hoàn toàn từ Phin, cho thêm 1 thìa đường, một ít đá viên mát lạnh', NULL, 29000, 'tcf-001.jpg'),
(11, 4, 'Cà Phê Sữa Đá', 'Cà phê được pha từ phin truyền thống, hòa cùng sữa đặc và thêm chút đá', NULL, 29000, 'tcf-002.jpg'),
(12, 4, 'Cà Phê Đen Nóng', 'Cà phê đậm đà pha từ Phin', NULL, 29000, 'tcf-003.jpg'),
(13, 5, 'Chocolate Đá Xay', 'Chocolate sữa đá xay kết hợp kem tươi mát lạnh', NULL, 55000, 'frz-001.jpg'),
(14, 5, 'Matcha Đá Xanh', 'Matcha sữa đá xay kết hợp kem tươi mát lạnh', NULL, 55000, 'frz-002.jpg'),
(15, 5, 'Cà phê Dừa Đá Xay và Thạch', 'Cà phê kết hợp với dừa tươi xay đậm đà thơm béo cùng thạch dai giòn', NULL, 55000, 'frz-003.jpg'),
(16, 6, 'Trà Đào', 'Mùi vị chua ngọt thanh mát kết hợp đào miếng ngon tuyệt', NULL, 50000, 'frt-001.jpg'),
(17, 6, 'Trà Cocktail', 'Vị trà thanh mát kết hợp với các loại trái cây tươi', NULL, 50000, 'frt-002.jpg'),
(18, 6, 'Trà Vải - Lài', 'Trà lài thanh nhẹ kết hợp cùng vải tươi', NULL, 50000, 'frt-003-4.jpg'),
(19, 7, 'Trà Lài', 'Trà lài hương vị truyền thống', NULL, 35000, 'tea-001-2-3-4.jpg'),
(20, 7, 'Trà Xanh', 'Trà xanh hương vị truyền thống', NULL, 35000, 'tea-001-2-3-4.jpg'),
(21, 7, 'Trà Ô Long', 'Trà ô long thơm ngon tuyệt hảo', NULL, 35000, 'tea-001-2-3-4.jpg');

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
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`id_TK`, `id_NV`, `user_name`, `pass`, `id_permission`) VALUES
(1, 1, 'admin', 'admin', 1),
(2, 2, 'vonhu', 'vonhu', 1),
(3, 3, 'thuanvo', 'thuanvo', 2),
(4, 4, 'giathuan', 'giathuan', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ct_hoadon`
--
ALTER TABLE `ct_hoadon`
  ADD KEY `id_HD` (`id_HD`),
  ADD KEY `id_SP` (`id_SP`);

--
-- Indexes for table `ct_phieunhaphang`
--
ALTER TABLE `ct_phieunhaphang`
  ADD KEY `id_PNH` (`id_PNH`),
  ADD KEY `id_NL` (`id_NL`);

--
-- Indexes for table `ct_quyen`
--
ALTER TABLE `ct_quyen`
  ADD KEY `id_permission` (`id_permission`),
  ADD KEY `id_duty` (`id_duty`);

--
-- Indexes for table `danhmuc`
--
ALTER TABLE `danhmuc`
  ADD PRIMARY KEY (`id_duty`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_KH` (`id_KH`),
  ADD KEY `id_NV` (`id_NV`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id_KH`);

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
-- AUTO_INCREMENT for table `danhmuc`
--
ALTER TABLE `danhmuc`
  MODIFY `id_duty` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id_KH` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `loai`
--
ALTER TABLE `loai`
  MODIFY `id_Loai` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  MODIFY `id_NL` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nguyenlieudadung`
--
ALTER TABLE `nguyenlieudadung`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `id_NCC` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `id_NV` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  MODIFY `id_PNH` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `quyen`
--
ALTER TABLE `quyen`
  MODIFY `id_permission` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id_SP` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id_TK` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
-- Constraints for table `ct_phieunhaphang`
--
ALTER TABLE `ct_phieunhaphang`
  ADD CONSTRAINT `ct_phieunhaphang_ibfk_1` FOREIGN KEY (`id_NL`) REFERENCES `nguyenlieu` (`id_NL`),
  ADD CONSTRAINT `ct_phieunhaphang_ibfk_2` FOREIGN KEY (`id_PNH`) REFERENCES `phieunhaphang` (`id_PNH`);

--
-- Constraints for table `ct_quyen`
--
ALTER TABLE `ct_quyen`
  ADD CONSTRAINT `id_duty` FOREIGN KEY (`id_duty`) REFERENCES `danhmuc` (`id_duty`),
  ADD CONSTRAINT `id_permission` FOREIGN KEY (`id_permission`) REFERENCES `quyen` (`id_permission`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`id_KH`) REFERENCES `khachhang` (`id_KH`),
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
