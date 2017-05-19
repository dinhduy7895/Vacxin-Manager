-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th5 19, 2017 lúc 01:39 PM
-- Phiên bản máy phục vụ: 5.7.18-0ubuntu0.16.04.1
-- Phiên bản PHP: 7.0.18-1+deb.sury.org~xenial+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `LTM_VACXIN`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Benh`
--

CREATE TABLE `Benh` (
  `MaBenh` int(11) NOT NULL,
  `TenBenh` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MoTa` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `Benh`
--

INSERT INTO `Benh` (`MaBenh`, `TenBenh`, `MoTa`) VALUES
(1, 'HIV', 'phong HIV'),
(2, 'Lao', 'phòng Lao'),
(3, 'SIDA', 'Benh SIDA '),
(4, 'H5N1', 'Benh H5N1 ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `KhachHang`
--

CREATE TABLE `KhachHang` (
  `MaKH` int(11) NOT NULL,
  `HoTen` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Sdt` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DiaChiKH` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `KhachHang`
--

INSERT INTO `KhachHang` (`MaKH`, `HoTen`, `Sdt`, `DiaChiKH`, `NgaySinh`, `GioiTinh`) VALUES
(1, 'Nguyen Van Teo ', '0123456789', '32 Hòa Minh', '1995-03-28', 'nam'),
(2, 'Banh Thi Ton', '0123456789', '32 Hòa Minh', '1995-05-16', 'nu'),
(3, 'Tran Van Pheo', '123456789', '193 Nguyen Luong Bang ', '2017-05-10', 'Nu '),
(4, 'Cu Thi Xin ', '987456321', 'Tang 2 Cau Vuot ', '2017-05-10', 'NU ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `LichSuTiemPhong`
--

CREATE TABLE `LichSuTiemPhong` (
  `id` int(11) NOT NULL,
  `MaKH` int(11) NOT NULL,
  `MaVacxin` int(11) NOT NULL,
  `STTMui` int(11) NOT NULL,
  `NgayTiemPhong` date NOT NULL,
  `NgayHenTiepTheo` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `LichSuTiemPhong`
--

INSERT INTO `LichSuTiemPhong` (`id`, `MaKH`, `MaVacxin`, `STTMui`, `NgayTiemPhong`, `NgayHenTiepTheo`) VALUES
(1, 1, 1, 1, '2017-05-09', '2017-05-16'),
(2, 2, 2, 1, '2017-05-09', '2017-05-16'),
(3, 1, 2, 1, '2017-05-16', '2017-05-23'),
(4, 2, 2, 2, '2017-05-16', '2017-05-23'),
(5, 3, 13, 1, '2017-05-01', '2017-05-08'),
(6, 3, 14, 1, '2017-05-01', '2017-05-14'),
(7, 4, 14, 1, '2017-05-01', '2017-05-21'),
(8, 4, 14, 2, '2017-05-21', '2017-05-31');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `PhongBenh`
--

CREATE TABLE `PhongBenh` (
  `MaVacxin` int(11) NOT NULL,
  `MaBenh` int(11) NOT NULL,
  `GhiChu` text CHARACTER SET utf8 COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `PhongBenh`
--

INSERT INTO `PhongBenh` (`MaVacxin`, `MaBenh`, `GhiChu`) VALUES
(1, 1, ''),
(2, 2, ''),
(13, 3, 'Done'),
(14, 4, 'Done');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `name`, `role`) VALUES
(1, 'admin', 'admin', 'admin', 1),
(2, 'user', 'user', 'user', 2),
(3, 'duy', 'duy', 'duy', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Vacxin`
--

CREATE TABLE `Vacxin` (
  `MaVacxin` int(11) NOT NULL,
  `TenVacxin` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `SoMui` int(11) NOT NULL,
  `MoTa` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GiaVacxin` varchar(100) NOT NULL,
  `TenHang` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `Vacxin`
--

INSERT INTO `Vacxin` (`MaVacxin`, `TenVacxin`, `SoMui`, `MoTa`, `GiaVacxin`, `TenHang`) VALUES
(1, 'HIV', 2, 'phong HIV', '50', 'viet nam'),
(2, 'LAO', 1, 'Phong Lao', '100', 'USA'),
(13, 'SIDA', 3, 'Chua benh SiDa', '20000', 'MExico'),
(14, 'H5N1', 98, 'Iusto saepe aliquid ut dolor quaerat magnam cumque non', '50000', 'VN');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `Benh`
--
ALTER TABLE `Benh`
  ADD PRIMARY KEY (`MaBenh`);

--
-- Chỉ mục cho bảng `KhachHang`
--
ALTER TABLE `KhachHang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Chỉ mục cho bảng `LichSuTiemPhong`
--
ALTER TABLE `LichSuTiemPhong`
  ADD PRIMARY KEY (`id`),
  ADD KEY `MaKH` (`MaKH`),
  ADD KEY `MaVacxin` (`MaVacxin`),
  ADD KEY `MaKH_2` (`MaKH`);

--
-- Chỉ mục cho bảng `PhongBenh`
--
ALTER TABLE `PhongBenh`
  ADD KEY `MaBenh` (`MaBenh`),
  ADD KEY `MaVacxin` (`MaVacxin`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `Vacxin`
--
ALTER TABLE `Vacxin`
  ADD PRIMARY KEY (`MaVacxin`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `Benh`
--
ALTER TABLE `Benh`
  MODIFY `MaBenh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT cho bảng `KhachHang`
--
ALTER TABLE `KhachHang`
  MODIFY `MaKH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT cho bảng `LichSuTiemPhong`
--
ALTER TABLE `LichSuTiemPhong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `Vacxin`
--
ALTER TABLE `Vacxin`
  MODIFY `MaVacxin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `LichSuTiemPhong`
--
ALTER TABLE `LichSuTiemPhong`
  ADD CONSTRAINT `LichSuTiemPhong_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `KhachHang` (`MaKH`),
  ADD CONSTRAINT `LichSuTiemPhong_ibfk_2` FOREIGN KEY (`MaVacxin`) REFERENCES `Vacxin` (`MaVacxin`);

--
-- Các ràng buộc cho bảng `PhongBenh`
--
ALTER TABLE `PhongBenh`
  ADD CONSTRAINT `PhongBenh_ibfk_1` FOREIGN KEY (`MaBenh`) REFERENCES `Benh` (`MaBenh`),
  ADD CONSTRAINT `PhongBenh_ibfk_2` FOREIGN KEY (`MaVacxin`) REFERENCES `Vacxin` (`MaVacxin`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
