-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 18 Jun 2026 pada 17.30
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
('002', 'Teh Pucuk', 'Minuman', 1000, 2000);

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
('NOT001', '001', 5000, 7000, 3);

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
('02', 'k', 'Laki-Laki', '11', 'Islam', '435', 'bogor');

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
('NOT001', '2026-06-18', '001', '001');

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
('002', 'q', 'Laki-Laki', '2', '3'),
('003', 'w', 'Perempuan', '3', '4');

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
