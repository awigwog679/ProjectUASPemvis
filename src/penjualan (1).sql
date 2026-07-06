-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Jul 2026 pada 05.15
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `id` varchar(6) NOT NULL,
  `nmbrg` varchar(50) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `harga_beli` int(11) NOT NULL,
  `harga_jual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id`, `nmbrg`, `jenis`, `harga_beli`, `harga_jual`) VALUES
('001', 'Biskuat', 'Makanan', 5000, 7000),
('002', 'Teh Pucuk', 'Minuman', 1000, 2000),
('003', 'Indomie Goreng', 'Makanan', 2500, 3500),
('004', 'Taro Snack', 'Makanan', 4000, 5000),
('005', 'Aqua Botol 600ml', 'Minuman', 2000, 3000),
('006', 'Minyak Goreng 1L', 'Sembako', 15000, 18000),
('007', 'Gula Pasir 1kg', 'Sembako', 12000, 14000),
('008', 'Kopi Kapal Api', 'Minuman', 10000, 12000),
('009', 'Susu Kental Manis', 'Minuman', 9000, 11000),
('010', 'Sabun Mandi', 'Alat Mandi', 3000, 4500),
('011', 'Shampoo Pantene', 'Alat Mandi', 15000, 18000),
('012', 'Sikat Gigi', 'Alat Mandi', 5000, 7000),
('013', 'Pasta Gigi Pepsodent', 'Alat Mandi', 8000, 10000),
('014', 'Deterjen Rinso 1kg', 'Pembersih', 20000, 24000),
('015', 'Pewangi Pakaian', 'Pembersih', 12000, 15000),
('016', 'Buku Tulis Sinar Dunia', 'Alat Tulis', 3500, 5000),
('017', 'Pulpen Faster', 'Alat Tulis', 2000, 3000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `isi`
--

CREATE TABLE `isi` (
  `idnota` varchar(30) NOT NULL,
  `kd_brg` varchar(30) NOT NULL,
  `h_beli` int(11) NOT NULL,
  `h_jual` int(11) NOT NULL,
  `qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `isi`
--

INSERT INTO `isi` (`idnota`, `kd_brg`, `h_beli`, `h_jual`, `qty`) VALUES
('NOT001', '002', 1000, 2000, 5),
('NOT002', '001', 5000, 7000, 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kasir`
--

CREATE TABLE `kasir` (
  `Id_kasir` varchar(10) NOT NULL,
  `nama_kasir` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `no_telp` varchar(20) NOT NULL,
  `agama` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kasir`
--

INSERT INTO `kasir` (`Id_kasir`, `nama_kasir`, `jenis_kelamin`, `no_telp`, `agama`, `password`, `alamat`) VALUES
('001', 'Dika', 'Laki-Laki', '08', 'Islam', '123', 'cakung'),
('003', 'Budi Santoso', 'Laki-Laki', '081234567890', 'Islam', 'pass123', 'Jl. Sudirman No. 1'),
('004', 'Siti Aminah', 'Perempuan', '089876543210', 'Islam', 'siti456', 'Jl. Thamrin No. 2'),
('005', 'Agus Supriyadi', 'Laki-Laki', '085612349876', 'Kristen', 'agus789', 'Jl. Gatot Subroto No. 3'),
('006', 'Rina Marlina', 'Perempuan', '081324354657', 'Katolik', 'rina321', 'Jl. Rasuna Said No. 4'),
('007', 'Joko Widodo', 'Laki-Laki', '087856473829', 'Islam', 'joko654', 'Jl. Merdeka No. 5'),
('008', 'Mega Wati', 'Perempuan', '089911223344', 'Hindu', 'mega987', 'Jl. Diponegoro No. 6'),
('009', 'Prabowo Subianto', 'Laki-Laki', '081155667788', 'Islam', 'prabowo111', 'Jl. Cendana No. 7'),
('010', 'Ahmad Dhani', 'Laki-Laki', '085799887766', 'Islam', 'ahmad222', 'Jl. Pahlawan No. 8'),
('011', 'Mulan Jameela', 'Perempuan', '081544332211', 'Islam', 'mulan333', 'Jl. Veteran No. 9'),
('012', 'Anies Baswedan', 'Laki-Laki', '081822334455', 'Islam', 'anies444', 'Jl. Salemba No. 10'),
('013', 'Ridwan Kamil', 'Laki-Laki', '087766554433', 'Islam', 'ridwan555', 'Jl. Braga No. 11'),
('014', 'Ganjar Pranowo', 'Laki-Laki', '089677889900', 'Islam', 'ganjar666', 'Jl. Pemuda No. 12'),
('015', 'Erick Thohir', 'Laki-Laki', '081211223344', 'Islam', 'erick777', 'Jl. Kuningan No. 13'),
('016', 'Susi Pudjiastuti', 'Perempuan', '085655443322', 'Islam', 'susi888', 'Jl. Pangandaran No. 14'),
('017', 'Sri Mulyani', 'Perempuan', '081399887766', 'Islam', 'sri999', 'Jl. Senayan No. 15');

-- --------------------------------------------------------

--
-- Struktur dari tabel `nota`
--

CREATE TABLE `nota` (
  `idnota` varchar(30) NOT NULL,
  `tgl` date NOT NULL,
  `txtid` varchar(50) NOT NULL,
  `id_kasir` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `nota`
--

INSERT INTO `nota` (`idnota`, `tgl`, `txtid`, `id_kasir`) VALUES
('NOT001', '2026-06-19', '001', '001'),
('NOT002', '2026-06-22', '001', '001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id` varchar(6) NOT NULL,
  `nmplgn` varchar(25) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `telepon` varchar(20) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id`, `nmplgn`, `jenis`, `telepon`, `alamat`) VALUES
('001', 'Dika', 'Laki-Laki', '0810189', 'jakarta'),
('004', 'Ali', 'Laki-Laki', '081234567891', 'Jl. Mawar No. 10'),
('005', 'Bela', 'Perempuan', '089876543212', 'Jl. Melati No. 11'),
('006', 'Cici', 'Perempuan', '085612349873', 'Jl. Anggrek No. 12'),
('007', 'Dodi', 'Laki-Laki', '081324354654', 'Jl. Kenanga No. 13'),
('008', 'Eka', 'Perempuan', '087856473825', 'Jl. Kamboja No. 14'),
('009', 'Fikri', 'Laki-Laki', '089911223346', 'Jl. Flamboyan No. 15'),
('010', 'Gita', 'Perempuan', '081155667787', 'Jl. Teratai No. 16'),
('011', 'Hadi', 'Laki-Laki', '085799887768', 'Jl. Dahlia No. 17'),
('012', 'Ima', 'Perempuan', '081544332219', 'Jl. Tulip No. 18'),
('013', 'Jaya', 'Laki-Laki', '081822334450', 'Jl. Lily No. 19'),
('014', 'Kiki', 'Perempuan', '087766554431', 'Jl. Bougenville No. 20'),
('015', 'Lala', 'Perempuan', '089677889902', 'Jl. Matahari No. 21'),
('016', 'Mira', 'Perempuan', '081211223343', 'Jl. Asoka No. 22'),
('017', 'Nando', 'Laki-Laki', '085655443324', 'Jl. Alamanda No. 23');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `isi`
--
ALTER TABLE `isi`
  ADD PRIMARY KEY (`idnota`);

--
-- Indeks untuk tabel `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`Id_kasir`);

--
-- Indeks untuk tabel `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`idnota`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
