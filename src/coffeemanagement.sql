-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `coffeemanagement`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ct_hoadon`
--

CREATE TABLE `ct_hoadon` (
  `id_HD` int(10) UNSIGNED NOT NULL,
  `id_SP` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `amount` int(10) UNSIGNED DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ct_phieunhaphang`
--

CREATE TABLE `ct_phieunhaphang` (
  `id_PNH` int(10) UNSIGNED DEFAULT NULL,
  `id_NL` int(11) UNSIGNED DEFAULT NULL,
  `amount` int(10) UNSIGNED DEFAULT NULL,
  `price` float DEFAULT NULL,
  `total_money` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ct_quyen`
--

CREATE TABLE `ct_quyen` (
  `id_permission` int(10) NOT NULL,
  `id_duty` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ct_quyen`
--

INSERT INTO `ct_quyen` (`id_permission`, `id_duty`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhmuc`
--

CREATE TABLE `danhmuc` (
  `id_duty` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `image` varchar(50) DEFAULT NULL,
  `image_hover` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `danhmuc`
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
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_KH` int(10) UNSIGNED NOT NULL,
  `id_NV` int(10) UNSIGNED NOT NULL,
  `total_money` float DEFAULT NULL,
  `create_day` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `id_KH` int(10) UNSIGNED NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai`
--

CREATE TABLE `loai` (
  `id_Loai` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loai`
--

INSERT INTO `loai` (`id_Loai`, `name`) VALUES
(1, 'TEAFRT'),
(2, 'FREEZE'),
(3, 'CFPM');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguyenlieu`
--

CREATE TABLE `nguyenlieu` (
  `id_NL` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `amount` int(10) UNSIGNED DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguyenlieudadung`
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
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `id_NCC` int(10) UNSIGNED NOT NULL,
  `name_NCC` varchar(50) NOT NULL,
  `address` text DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `id_NV` int(10) UNSIGNED NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `age` int(10) UNSIGNED DEFAULT NULL,
  `gender` enum('male','female') DEFAULT NULL,
  `address` text DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `start_day` date DEFAULT NULL,
  `status` BOOLEAN DEFAULT TRUE,
  `img` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`id_NV`, `name`, `age`, `gender`, `address`, `phone`, `start_day`,`status`,`img`) VALUES
(1, 'admin', 20, 'male', NULL, '0123456789', '2021-04-17',true, '001.jpg'),
(2, 'Như', 20, 'female', NULL, NULL, NULL,true,'002.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhaphang`
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
-- Cấu trúc bảng cho bảng `quyen`
--

CREATE TABLE `quyen` (
  `id_permission` int(10) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `quyen`
--

INSERT INTO `quyen` (`id_permission`, `name`) VALUES
(1, 'admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
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
(1, 1, 'Trà Đào', 'Mùi vị chua ngọt thanh mát kết hợp đào miếng ngon tuyệt', NULL, 50000, 'frt-001.jpg'),
(2, 1, 'Trà Cocktail', 'Vị trà thanh mát kết hợp với các loại trái cây tươi', NULL, 50000, 'frt-002.jpg'),
(3, 1, 'Trà Vải - Lài', 'Trà lài thanh nhẹ kết hợp cùng vải tươi', NULL, 45000, 'frt-003-4.jpg'),
(4, 2, 'Chocolate Đá Xay', 'Chocolate sữa đá xay kết hợp kem tươi mát lạnh', NULL, 55000, 'frz-001.jpg'),
(5, 2, 'Matcha Đá Xanh', 'Matcha sữa đá xay kết hợp kem tươi mát lạnh', NULL, 55000, 'frz-002.jpg'),
(6, 2, 'Cà phê Dừa Đá Xay và Thạch', 'Cà phê kết hợp với dừa tươi xay đậm đà thơm béo cùng thạch dai giòn', NULL, 65000, 'frt-003.jpg'),
(7, 3, 'Cappuccino', 'Bắt đầu với cà phê espresso, sau đó thêm một lượng tương đương giữa sữa tươi và bọt sữa', NULL, 50000, 'mcf-001.jpg'),
(8, 3, 'Latte', 'Bắt đầu với cà phê espresso, sau đó thêm một lượng tương đương giữa sữa tươi và bọt sữa', NULL, 50000, 'mcf-002.jpg'),
(9, 3, 'Caramel Macchiato', 'Bắt đầu từ dòng sữa tươi và lớp bọt sữa, sau đó hòa quyện cùng cà phê espresso đậm đà và sốt caramel', NULL, 59000, 'mcf-003.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id_TK` int(10) UNSIGNED NOT NULL,
  `id_NV` int(10) UNSIGNED NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `id_permission` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`id_TK`, `id_NV`, `user_name`, `pass`, `id_permission`) VALUES
(1, 1, 'admin', 'admin', 1),
(2, 2, 'vonhu', 'vonhu', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ct_hoadon`
--
ALTER TABLE `ct_hoadon`
  ADD KEY `id_HD` (`id_HD`),
  ADD KEY `id_SP` (`id_SP`);

--
-- Chỉ mục cho bảng `ct_phieunhaphang`
--
ALTER TABLE `ct_phieunhaphang`
  ADD KEY `id_PNH` (`id_PNH`),
  ADD KEY `id_NL` (`id_NL`);

--
-- Chỉ mục cho bảng `ct_quyen`
--
ALTER TABLE `ct_quyen`
  ADD KEY `id_permission` (`id_permission`),
  ADD KEY `id_duty` (`id_duty`);

--
-- Chỉ mục cho bảng `danhmuc`
--
ALTER TABLE `danhmuc`
  ADD PRIMARY KEY (`id_duty`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_KH` (`id_KH`),
  ADD KEY `id_NV` (`id_NV`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id_KH`);

--
-- Chỉ mục cho bảng `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`id_Loai`);

--
-- Chỉ mục cho bảng `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  ADD PRIMARY KEY (`id_NL`);

--
-- Chỉ mục cho bảng `nguyenlieudadung`
--
ALTER TABLE `nguyenlieudadung`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_NL` (`id_NL`),
  ADD KEY `id_SP` (`id_SP`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`id_NCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`id_NV`);

--
-- Chỉ mục cho bảng `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD PRIMARY KEY (`id_PNH`),
  ADD KEY `id_NCC` (`id_NCC`),
  ADD KEY `id_NV` (`id_NV`);

--
-- Chỉ mục cho bảng `quyen`
--
ALTER TABLE `quyen`
  ADD PRIMARY KEY (`id_permission`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id_SP`),
  ADD KEY `id_Loai` (`id_Loai`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id_TK`),
  ADD KEY `id_NV` (`id_NV`),
  ADD KEY `taikhoan_ibfk_2` (`id_permission`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `danhmuc`
--
ALTER TABLE `danhmuc`
  MODIFY `id_duty` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id_KH` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `loai`
--
ALTER TABLE `loai`
  MODIFY `id_Loai` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  MODIFY `id_NL` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nguyenlieudadung`
--
ALTER TABLE `nguyenlieudadung`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `id_NCC` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `id_NV` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  MODIFY `id_PNH` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `quyen`
--
ALTER TABLE `quyen`
  MODIFY `id_permission` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id_SP` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id_TK` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ct_hoadon`
--
ALTER TABLE `ct_hoadon`
  ADD CONSTRAINT `ct_hoadon_ibfk_1` FOREIGN KEY (`id_HD`) REFERENCES `hoadon` (`id`),
  ADD CONSTRAINT `ct_hoadon_ibfk_2` FOREIGN KEY (`id_SP`) REFERENCES `sanpham` (`id_SP`);

--
-- Các ràng buộc cho bảng `ct_phieunhaphang`
--
ALTER TABLE `ct_phieunhaphang`
  ADD CONSTRAINT `ct_phieunhaphang_ibfk_1` FOREIGN KEY (`id_NL`) REFERENCES `nguyenlieu` (`id_NL`),
  ADD CONSTRAINT `ct_phieunhaphang_ibfk_2` FOREIGN KEY (`id_PNH`) REFERENCES `phieunhaphang` (`id_PNH`);

--
-- Các ràng buộc cho bảng `ct_quyen`
--
ALTER TABLE `ct_quyen`
  ADD CONSTRAINT `id_duty` FOREIGN KEY (`id_duty`) REFERENCES `danhmuc` (`id_duty`),
  ADD CONSTRAINT `id_permission` FOREIGN KEY (`id_permission`) REFERENCES `quyen` (`id_permission`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`id_KH`) REFERENCES `khachhang` (`id_KH`),
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`id_NV`) REFERENCES `nhanvien` (`id_NV`);

--
-- Các ràng buộc cho bảng `nguyenlieudadung`
--
ALTER TABLE `nguyenlieudadung`
  ADD CONSTRAINT `nguyenlieudadung_ibfk_1` FOREIGN KEY (`id_NL`) REFERENCES `nguyenlieu` (`id_NL`),
  ADD CONSTRAINT `nguyenlieudadung_ibfk_2` FOREIGN KEY (`id_SP`) REFERENCES `sanpham` (`id_SP`);

--
-- Các ràng buộc cho bảng `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD CONSTRAINT `phieunhaphang_ibfk_1` FOREIGN KEY (`id_NCC`) REFERENCES `nhacungcap` (`id_NCC`),
  ADD CONSTRAINT `phieunhaphang_ibfk_2` FOREIGN KEY (`id_NV`) REFERENCES `nhanvien` (`id_NV`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`id_Loai`) REFERENCES `loai` (`id_Loai`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`id_NV`) REFERENCES `nhanvien` (`id_NV`),
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`id_permission`) REFERENCES `quyen` (`id_permission`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
