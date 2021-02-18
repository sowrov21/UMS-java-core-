-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2019 at 04:10 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` varchar(10) NOT NULL,
  `a_name` varchar(30) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `join date` varchar(10) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `a_name`, `gender`, `join date`, `dob`, `address`, `password`) VALUES
('999', '', '', '', '', '', 'kkk'),
('1010', '', '', '', '', '', 'ggg');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` varchar(10) NOT NULL,
  `a_name` varchar(30) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `join date` varchar(10) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `a_name`, `gender`, `join date`, `dob`, `address`, `password`) VALUES
('444', '', '', '', '', '', 'fff'),
('555', '', '', '', '', '', 'ggg');

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `id` varchar(10) NOT NULL,
  `f_name` varchar(30) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `skill` varchar(10) NOT NULL,
  `join date` varchar(10) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`id`, `f_name`, `gender`, `skill`, `join date`, `dob`, `address`, `password`) VALUES
('123', '', '', '', '', '', '', 'abc'),
('456', '', '', '', '', '', '', 'def'),
('34', 'nazmul', 'Male', 'alforithm', 'yyyyddmm', 'yyyyddmm', 'dka', 'zxc');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` varchar(11) NOT NULL,
  `s_name` varchar(30) NOT NULL,
  `dept` varchar(10) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `s_name`, `dept`, `gender`, `dob`, `address`, `password`) VALUES
('111', '', '', '', '0000-00-00', '', 'aaa'),
('222', '', '', '', '0000-00-00', '', 'bbb'),
('18-36144-1', '', '', '', '0000-00-00', '', 'nazmul'),
('123456', 'soitan', 'cse', 'mate', 'yyyymmmdd', 'hell', 'zzzzzzzzz'),
('sdrtfyu', 'rrtyu', 'rty', '45r', 'we5r6t', '54we', 'erty');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
