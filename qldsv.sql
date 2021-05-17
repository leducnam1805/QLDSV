-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 17, 2021 lúc 07:59 AM
-- Phiên bản máy phục vụ: 10.4.6-MariaDB
-- Phiên bản PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qldsv`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `diem`
--

CREATE TABLE `diem` (
  `maBD` int(11) NOT NULL,
  `heso1` float NOT NULL,
  `heso3` float NOT NULL,
  `heso6` float NOT NULL,
  `tongDiem` float NOT NULL,
  `maGV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `maSV` int(11) NOT NULL,
  `maMH` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `maTC` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `maTL` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `maHK` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `maNH` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `diem`
--

INSERT INTO `diem` (`maBD`, `heso1`, `heso3`, `heso6`, `tongDiem`, `maGV`, `maSV`, `maMH`, `maTC`, `maTL`, `maHK`, `maNH`) VALUES
(39, 5, 6, 8, 7, '2021000002', 1, '2117100153', 'TC1', 'TL02', 'HK1', 'NH01'),
(40, 0, 0, 0, 0, '2021000002', 1, '2117100153', 'TC1', 'TL02', 'HK1', 'NH01'),
(41, 5, 6, 8, 7, '2021000002', 1, '2117100153', 'TC1', 'TL02', 'HK1', 'NH01'),
(50, 5, 6, 6, 8, '2021000002', 2117100111, '2117100153', 'TC1', 'TL02', 'HK1', 'NH01'),
(52, 5, 6, 8, 7, '2021000002', 2117100111, '2117100153', 'TC1', 'TL02', 'HK1', 'NH01'),
(53, 10, 8, 8, 7, '2021000002', 2117100111, '2117100153', 'TC1', 'TL02', 'HK1', 'NH01'),
(54, 10, 8, 8, 7, '2021000002', 2117100111, '2117100153', 'TC1', 'TL01', 'HK1', 'NH01'),
(55, 10, 8, 8, 0, '3', 3, '2117100153', 'TC3', 'TL02', 'HK2', 'NH03');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giangvien`
--

CREATE TABLE `giangvien` (
  `maGV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tenGV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `diaChi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` int(11) NOT NULL,
  `email` varchar(60) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `giangvien`
--

INSERT INTO `giangvien` (`maGV`, `tenGV`, `diaChi`, `sdt`, `email`) VALUES
('2021000002', 'Lê Thị C', 'Duy Xuyên', 257893465, 'c@gmail.com'),
('202100001', 'Nguyễn Văn A', 'Tam Kỳ', 797207493, 'a@gmail.com'),
('2117100123', 'Hồ Đến', 'Đà Nẵng', 123456, 'leducnam1805@gmail.com'),
('3', 'Hồ Thị E', 'Đà Nẵng', 797207493, 'E@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocky`
--

CREATE TABLE `hocky` (
  `maHK` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tenHK` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hocky`
--

INSERT INTO `hocky` (`maHK`, `tenHK`) VALUES
('HK1', '1'),
('HK2', '2'),
('HK3', '3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoa`
--

CREATE TABLE `khoa` (
  `maKH` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tenKH` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lienheKH` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khoa`
--

INSERT INTO `khoa` (`maKH`, `tenKH`, `lienheKH`) VALUES
('CNTT', 'Công Nghệ Thông Tin', 'cntt@gmail.com'),
('LYHOASINH', 'Lý Hóa Sinh', 'lyhoasinh@gmail.com'),
('TOAN', 'Sư Phạm Toán', 'toan@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lop`
--

CREATE TABLE `lop` (
  `maLop` int(11) NOT NULL,
  `tenLop` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `maKH` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `lop`
--

INSERT INTO `lop` (`maLop`, `tenLop`, `maKH`) VALUES
(1, 'DT17CTT01', 'CNTT'),
(2, 'DT18SGT01', 'TOAN'),
(3, 'DT18CTT01', 'CNTT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monhoc`
--

CREATE TABLE `monhoc` (
  `maMH` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tenMH` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `maTC` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `maTL` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `monhoc`
--

INSERT INTO `monhoc` (`maMH`, `tenMH`, `maTC`, `maTL`) VALUES
('2117100153', 'Toán Cao Cấp', 'TC2', 'TL02'),
('2117100158', 'Lập Trình Di Động', 'TC2', 'TL02'),
('211710054', 'Triết Học', 'TC2', 'TL01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monhoc_giaovien`
--

CREATE TABLE `monhoc_giaovien` (
  `maMH` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `maGV` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `namhoc`
--

CREATE TABLE `namhoc` (
  `maNH` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tenNH` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `namhoc`
--

INSERT INTO `namhoc` (`maNH`, `tenNH`) VALUES
('NH01', '2017-2018'),
('NH02', '2018-2019'),
('NH03', '2019-2020');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nienkhoa`
--

CREATE TABLE `nienkhoa` (
  `maNK` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tenNK` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nienkhoa`
--

INSERT INTO `nienkhoa` (`maNK`, `tenNK`) VALUES
('NKCD02', '2018-2022'),
('NKDH01', '2017-2021'),
('NKDH02', '2019-2023');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `role` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`id`, `role`) VALUES
(1, 'Admin'),
(2, 'Trưởng Phòng'),
(3, 'Phó Phòng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sinhvien`
--

CREATE TABLE `sinhvien` (
  `maSV` int(11) NOT NULL,
  `tenSV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `diaChi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` int(11) NOT NULL,
  `email` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `maLop` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sinhvien`
--

INSERT INTO `sinhvien` (`maSV`, `tenSV`, `diaChi`, `sdt`, `email`, `maLop`) VALUES
(1, 'Lê Đức Nam', 'Quảng Nam', 797207493, 'teo@vinaenter.edu.vn', 1),
(2, 'Alăng C', 'Đà Nẵng', 123456, 'leducnam1805@gmail.com', 1),
(3, 'Lê Văn D', 'Đà Nẵng', 797207493, 'd@gmail.com', 2),
(2117100111, 'Hồ Nhan', 'Đà Nẵng', 797207493, 'teo@vinaenter.edu.vn', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `username`, `password`, `email`, `role`) VALUES
(1, 'Admin', '123', 'admin@gmail.com', 1),
(2, 'phophong', '123', 'phophong@gmail.com', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `theloai`
--

CREATE TABLE `theloai` (
  `maTL` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tenTL` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `theloai`
--

INSERT INTO `theloai` (`maTL`, `tenTL`) VALUES
('TL01', 'Chính trị và Xã Hội'),
('TL02', 'Chuyên Nghành'),
('TL03', 'Du Học');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tinchi`
--

CREATE TABLE `tinchi` (
  `maTC` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `soTC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tinchi`
--

INSERT INTO `tinchi` (`maTC`, `soTC`) VALUES
('TC1', 1),
('TC2', 2),
('TC3', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `xeploai`
--

CREATE TABLE `xeploai` (
  `maXL` int(11) NOT NULL,
  `canDuoi` float NOT NULL,
  `canTren` float NOT NULL,
  `tenXL` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `diem`
--
ALTER TABLE `diem`
  ADD PRIMARY KEY (`maBD`),
  ADD KEY `maGV` (`maGV`),
  ADD KEY `maHK` (`maHK`),
  ADD KEY `maNH` (`maNH`),
  ADD KEY `maMH` (`maMH`),
  ADD KEY `maSV` (`maSV`),
  ADD KEY `maTC` (`maTC`),
  ADD KEY `maTL` (`maTL`);

--
-- Chỉ mục cho bảng `giangvien`
--
ALTER TABLE `giangvien`
  ADD PRIMARY KEY (`maGV`);

--
-- Chỉ mục cho bảng `hocky`
--
ALTER TABLE `hocky`
  ADD PRIMARY KEY (`maHK`);

--
-- Chỉ mục cho bảng `khoa`
--
ALTER TABLE `khoa`
  ADD PRIMARY KEY (`maKH`);

--
-- Chỉ mục cho bảng `lop`
--
ALTER TABLE `lop`
  ADD PRIMARY KEY (`maLop`),
  ADD KEY `maKH` (`maKH`);

--
-- Chỉ mục cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`maMH`),
  ADD KEY `maTC` (`maTC`),
  ADD KEY `maTL` (`maTL`);

--
-- Chỉ mục cho bảng `monhoc_giaovien`
--
ALTER TABLE `monhoc_giaovien`
  ADD PRIMARY KEY (`maMH`,`maGV`),
  ADD KEY `maGV` (`maGV`);

--
-- Chỉ mục cho bảng `namhoc`
--
ALTER TABLE `namhoc`
  ADD PRIMARY KEY (`maNH`);

--
-- Chỉ mục cho bảng `nienkhoa`
--
ALTER TABLE `nienkhoa`
  ADD PRIMARY KEY (`maNK`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`maSV`),
  ADD KEY `maLop` (`maLop`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `role` (`role`);

--
-- Chỉ mục cho bảng `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`maTL`);

--
-- Chỉ mục cho bảng `tinchi`
--
ALTER TABLE `tinchi`
  ADD PRIMARY KEY (`maTC`);

--
-- Chỉ mục cho bảng `xeploai`
--
ALTER TABLE `xeploai`
  ADD PRIMARY KEY (`maXL`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `diem`
--
ALTER TABLE `diem`
  MODIFY `maBD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT cho bảng `lop`
--
ALTER TABLE `lop`
  MODIFY `maLop` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `xeploai`
--
ALTER TABLE `xeploai`
  MODIFY `maXL` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `diem`
--
ALTER TABLE `diem`
  ADD CONSTRAINT `diem_ibfk_1` FOREIGN KEY (`maGV`) REFERENCES `giangvien` (`maGV`),
  ADD CONSTRAINT `diem_ibfk_3` FOREIGN KEY (`maHK`) REFERENCES `hocky` (`maHK`),
  ADD CONSTRAINT `diem_ibfk_4` FOREIGN KEY (`maNH`) REFERENCES `namhoc` (`maNH`),
  ADD CONSTRAINT `diem_ibfk_5` FOREIGN KEY (`maMH`) REFERENCES `monhoc` (`maMH`),
  ADD CONSTRAINT `diem_ibfk_6` FOREIGN KEY (`maSV`) REFERENCES `sinhvien` (`maSV`),
  ADD CONSTRAINT `diem_ibfk_7` FOREIGN KEY (`maTC`) REFERENCES `tinchi` (`maTC`),
  ADD CONSTRAINT `diem_ibfk_8` FOREIGN KEY (`maTL`) REFERENCES `theloai` (`maTL`);

--
-- Các ràng buộc cho bảng `lop`
--
ALTER TABLE `lop`
  ADD CONSTRAINT `lop_ibfk_1` FOREIGN KEY (`maKH`) REFERENCES `khoa` (`maKH`);

--
-- Các ràng buộc cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  ADD CONSTRAINT `monhoc_ibfk_1` FOREIGN KEY (`maTC`) REFERENCES `tinchi` (`maTC`),
  ADD CONSTRAINT `monhoc_ibfk_2` FOREIGN KEY (`maTL`) REFERENCES `theloai` (`maTL`);

--
-- Các ràng buộc cho bảng `monhoc_giaovien`
--
ALTER TABLE `monhoc_giaovien`
  ADD CONSTRAINT `monhoc_giaovien_ibfk_1` FOREIGN KEY (`maGV`) REFERENCES `giangvien` (`maGV`),
  ADD CONSTRAINT `monhoc_giaovien_ibfk_2` FOREIGN KEY (`maMH`) REFERENCES `monhoc` (`maMH`);

--
-- Các ràng buộc cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD CONSTRAINT `sinhvien_ibfk_1` FOREIGN KEY (`maLop`) REFERENCES `lop` (`maLop`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`role`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
