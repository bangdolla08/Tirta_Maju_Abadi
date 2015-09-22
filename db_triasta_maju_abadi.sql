-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 02 Sep 2015 pada 17.30
-- Versi Server: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_triasta_maju_abadi`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `Id_admin` int(11) NOT NULL,
  `Nama` varchar(45) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `User` varchar(20) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `No_telepon` varchar(15) NOT NULL,
  `Email` varchar(50) NOT NULL,
  PRIMARY KEY (`Id_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `datang_bahan_dasar`
--

CREATE TABLE IF NOT EXISTS `datang_bahan_dasar` (
  `No_masuk` int(11) NOT NULL AUTO_INCREMENT,
  `No_po` varchar(30) NOT NULL,
  `Banyak` int(11) NOT NULL,
  `Surat_jalan` varchar(30) NOT NULL,
  `Fisik` varchar(50) NOT NULL,
  `Id_supplier` int(11) NOT NULL,
  PRIMARY KEY (`No_masuk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `full_penjualan`
--

CREATE TABLE IF NOT EXISTS `full_penjualan` (
  `Id_produk` int(11) NOT NULL,
  `No_nota` varchar(20) NOT NULL,
  `Banyak` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `galon_cacat`
--

CREATE TABLE IF NOT EXISTS `galon_cacat` (
  `No_urut` int(30) NOT NULL,
  `Treatment` varchar(30) NOT NULL,
  `Pecah` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `galon_keluar`
--

CREATE TABLE IF NOT EXISTS `galon_keluar` (
  `No_urut` int(30) NOT NULL AUTO_INCREMENT,
  `Banyak_keluar` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `Id_pelanggan` int(11) NOT NULL,
  PRIMARY KEY (`No_urut`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `galon_masuk`
--

CREATE TABLE IF NOT EXISTS `galon_masuk` (
  `No_urut` int(30) NOT NULL AUTO_INCREMENT,
  `Banyak_masuk` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `Id_pelanggan` int(11) NOT NULL,
  PRIMARY KEY (`No_urut`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `gudang_barang_jadi`
--

CREATE TABLE IF NOT EXISTS `gudang_barang_jadi` (
  `Koordinator` varchar(30) NOT NULL,
  `Operator` varchar(30) NOT NULL,
  `Shift` varchar(30) NOT NULL,
  `Id_barang` int(11) NOT NULL,
  `Banyak` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `harga_pelanggan`
--

CREATE TABLE IF NOT EXISTS `harga_pelanggan` (
  `Id_pelanggan` int(11) NOT NULL,
  `Id_produk` int(11) NOT NULL,
  `Harga` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `keluar_gudang_bahan_jadi`
--

CREATE TABLE IF NOT EXISTS `keluar_gudang_bahan_jadi` (
  `No_nota` varchar(30) NOT NULL,
  `No_surat_jalan` varchar(30) NOT NULL,
  `Banyak` int(11) NOT NULL,
  `Nopol` varchar(30) NOT NULL,
  `Id_produk` int(11) NOT NULL,
  PRIMARY KEY (`No_surat_jalan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `keluar_gudang_bahan_mentah`
--

CREATE TABLE IF NOT EXISTS `keluar_gudang_bahan_mentah` (
  `Id_supplier` int(11) NOT NULL,
  `Banyak` int(11) NOT NULL,
  `No_urut` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`No_urut`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `nota_pesan`
--

CREATE TABLE IF NOT EXISTS `nota_pesan` (
  `No_pemesanan` varchar(20) NOT NULL,
  `Harga` varchar(20) NOT NULL,
  `Banyak` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE IF NOT EXISTS `pelanggan` (
  `Id_pelanggan` int(11) NOT NULL,
  `Nama` varchar(45) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `Tipe_pembayaran` varchar(50) NOT NULL,
  PRIMARY KEY (`Id_pelanggan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan_po`
--

CREATE TABLE IF NOT EXISTS `penjualan_po` (
  `Id_pelanggan` int(11) NOT NULL,
  `No_nota` varchar(20) NOT NULL,
  `No_po` varchar(20) NOT NULL,
  PRIMARY KEY (`No_po`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesan_barang`
--

CREATE TABLE IF NOT EXISTS `pesan_barang` (
  `No_po` varchar(30) NOT NULL,
  `No_pemesanan` varchar(30) NOT NULL,
  `Id_supplier` int(11) NOT NULL,
  PRIMARY KEY (`No_pemesanan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `po_bahan_dasar`
--

CREATE TABLE IF NOT EXISTS `po_bahan_dasar` (
  `No_po` varchar(30) NOT NULL,
  `Nama_barang` varchar(50) NOT NULL,
  `Banyak` int(11) NOT NULL,
  PRIMARY KEY (`No_po`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `Id_supplier` int(11) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `No_telepon1` varchar(15) NOT NULL,
  `No_telepon2` varchar(15) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Ppn` tinyint(1) NOT NULL,
  `No_rekening1` varchar(15) NOT NULL,
  `No_rekening2` varchar(15) NOT NULL,
  PRIMARY KEY (`Id_supplier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
