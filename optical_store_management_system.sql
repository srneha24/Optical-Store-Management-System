-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 23, 2021 at 11:18 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `optical_store_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `client_id` varchar(5) NOT NULL,
  `appointment_date` date NOT NULL,
  `complete` varchar(3) NOT NULL,
  `charge` decimal(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`client_id`, `appointment_date`, `complete`, `charge`) VALUES
('C1002', '2021-03-01', 'YES', '300.00'),
('C1001', '2021-03-16', 'YES', '250.00'),
('C1002', '2021-03-06', 'YES', '300.00'),
('C1004', '2021-03-28', 'YES', '300.00');

-- --------------------------------------------------------

--
-- Table structure for table `client_info`
--

CREATE TABLE `client_info` (
  `client_id` varchar(5) NOT NULL,
  `client_name` varchar(255) NOT NULL,
  `client_phone_num` varchar(14) NOT NULL,
  `age` int(3) NOT NULL,
  `vision` varchar(7) DEFAULT NULL,
  `right_sph` double(3,1) NOT NULL,
  `right_cyl` double(3,1) DEFAULT NULL,
  `power_axis` double(4,1) DEFAULT NULL,
  `power_sph` double(3,1) DEFAULT NULL,
  `left_cyl` double(3,1) DEFAULT NULL,
  `left_axis` double(4,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client_info`
--

INSERT INTO `client_info` (`client_id`, `client_name`, `client_phone_num`, `age`, `vision`, `right_sph`, `right_cyl`, `power_axis`, `power_sph`, `left_cyl`, `left_axis`) VALUES
('C1001', 'Rafia Atkia Rafa', '8801763548975', 20, 'Distant', -3.8, -1.0, 180.0, -3.4, -0.8, 5.0),
('C1002', 'Ariya Akhi', '8801932468521', 25, 'Near', 2.5, 0.2, 150.0, 0.2, 2.8, 15.0),
('C1003', 'Jakir Khan', '8801854698234', 0, '', 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
('C1004', 'Jack', '8801765348952', 0, '', 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

-- --------------------------------------------------------

--
-- Table structure for table `client_order_specs`
--

CREATE TABLE `client_order_specs` (
  `receipt_no` varchar(15) NOT NULL,
  `product_id` varchar(15) NOT NULL,
  `quantity` int(3) NOT NULL,
  `lens_type` varchar(80) DEFAULT NULL,
  `lens_material` varchar(30) DEFAULT NULL,
  `frame_length` float(4,1) DEFAULT NULL,
  `nose_length` float(3,1) DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `order_status` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client_order_specs`
--

INSERT INTO `client_order_specs` (`receipt_no`, `product_id`, `quantity`, `lens_type`, `lens_material`, `frame_length`, `nose_length`, `delivery_date`, `order_status`) VALUES
('O100000001', '31964L646118', 1, 'Bifocal', 'Tribrid', 130.0, 50.0, '2021-03-16', 'Factory'),
('O100000002', 'Q624L34024762', 2, 'Unifocal', 'High-Index Plastics', 120.0, 60.0, '2021-03-13', 'Delivered'),
('O100000003', '306875218140', 1, 'Unifocal', 'CR-39 plastic', 135.0, 40.0, '2021-02-18', 'Store'),
('O100000004', '31964L646118', 1, 'Unifocal', 'Crown glass', 126.0, 47.0, '2021-03-16', 'Factory'),
('O100000005', 'K38355118135', 1, 'Unifocal', 'Polycarbonate', 110.0, 35.0, '2021-01-06', 'Delivered'),
('O100000003', '619265318138', 2, 'Bifocal', 'High-Index Plastics', 126.0, 52.0, '2021-02-18', 'Factory'),
('O100000003', '31964L646118', 1, 'Bifocal', 'Tribrid', 126.0, 52.0, '2021-02-18', 'Delivered'),
('O100000005', '306875218140', 1, 'Unifocal', 'High-Index Plastics', 110.0, 35.0, '2021-01-06', 'Store'),
('O100000006', '31964L646118', 3, 'Unifocal', 'Metal', 120.0, 99.9, '0000-00-00', 'Store');

-- --------------------------------------------------------

--
-- Table structure for table `employee_information`
--

CREATE TABLE `employee_information` (
  `employee_id` varchar(3) NOT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `employee_phone_num` varchar(14) DEFAULT NULL,
  `employee_address` varchar(255) DEFAULT NULL,
  `designation` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee_information`
--

INSERT INTO `employee_information` (`employee_id`, `employee_name`, `employee_phone_num`, `employee_address`, `designation`) VALUES
('100', 'Rashedul Hasan', '8801763254951', 'Mirpur, Dhaka', 'Owner'),
('101', 'Nazmul Hoassain', '8801932647582', 'Mirpur, Dhaka', 'Store Assistant'),
('102', 'Tahseen Sharika Anzum', '8801963254785', 'Ibrahimpur, Mirpur, Dhaka', 'Junior Partner');

-- --------------------------------------------------------

--
-- Table structure for table `employee_permissions`
--

CREATE TABLE `employee_permissions` (
  `employee_id` varchar(3) NOT NULL,
  `product` tinyint(1) NOT NULL,
  `supplier` tinyint(1) NOT NULL,
  `sales` tinyint(1) NOT NULL,
  `supplies` tinyint(1) NOT NULL,
  `orders` tinyint(1) NOT NULL,
  `client` tinyint(1) NOT NULL,
  `appointment` tinyint(1) NOT NULL,
  `employee` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee_permissions`
--

INSERT INTO `employee_permissions` (`employee_id`, `product`, `supplier`, `sales`, `supplies`, `orders`, `client`, `appointment`, `employee`) VALUES
('100', 1, 1, 1, 1, 1, 1, 1, 1),
('101', 0, 0, 0, 0, 1, 0, 0, 0),
('102', 1, 0, 0, 0, 1, 1, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `login_info`
--

CREATE TABLE `login_info` (
  `employee_id` varchar(3) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login_info`
--

INSERT INTO `login_info` (`employee_id`, `pass`) VALUES
('100', 'PASS0'),
('101', 'PASS1'),
('102', 'PASS2');

-- --------------------------------------------------------

--
-- Table structure for table `ordered_supplies`
--

CREATE TABLE `ordered_supplies` (
  `supply_no` varchar(5) NOT NULL,
  `product_id` varchar(15) NOT NULL,
  `quantity` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ordered_supplies`
--

INSERT INTO `ordered_supplies` (`supply_no`, `product_id`, `quantity`) VALUES
('P1001', '306875218140', 16),
('P1001', '619265318138', 4),
('P1002', 'K38355118135', 10),
('P1002', '306875218140', 17),
('P1003', 'Q624L34024762', 5),
('P1003', '619265318138', 21),
('P1004', '306875218140', 8),
('P1004', 'K38355118135', 9),
('P1005', '306875218140', 10),
('P1005', 'K38355118135', 10),
('P1006', 'K38355118135', 2);

-- --------------------------------------------------------

--
-- Table structure for table `product_info`
--

CREATE TABLE `product_info` (
  `product_id` varchar(15) NOT NULL,
  `brand` varchar(30) DEFAULT NULL,
  `shape` varchar(9) DEFAULT NULL,
  `design` varchar(15) DEFAULT NULL,
  `material` varchar(30) DEFAULT NULL,
  `quantity` int(3) NOT NULL,
  `unit_cost_price` decimal(6,2) NOT NULL,
  `unit_selling_price` decimal(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product_info`
--

INSERT INTO `product_info` (`product_id`, `brand`, `shape`, `design`, `material`, `quantity`, `unit_cost_price`, `unit_selling_price`) VALUES
('306875218140', 'Police', 'Rectangle', 'Rimless', 'Plastic', 28, '190.00', '250.00'),
('31964L646118', 'Gucci', 'Round', 'Full Frame', 'Plastic', 5, '160.00', '210.00'),
('619265318138', 'Ray Ban', 'Rectangle', 'Semi-Rimless', 'Plastic', 6, '125.00', '170.00'),
('K38355118135', 'Prada', 'Rectangle', 'Semi-Rimless', 'Plastic', 29, '180.00', '260.00'),
('Q624L34024762', 'Danson', 'Rectangle', 'Rimless', 'Metal', 8, '135.00', '165.00');

-- --------------------------------------------------------

--
-- Table structure for table `sales_records`
--

CREATE TABLE `sales_records` (
  `receipt_no` varchar(15) NOT NULL,
  `client_id` varchar(5) NOT NULL,
  `payment` decimal(6,2) NOT NULL,
  `order_date` date NOT NULL,
  `employee_id` varchar(3) DEFAULT NULL,
  `pay_cleared` varchar(3) NOT NULL DEFAULT 'NO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales_records`
--

INSERT INTO `sales_records` (`receipt_no`, `client_id`, `payment`, `order_date`, `employee_id`, `pay_cleared`) VALUES
('O100000001', 'C1003', '200.00', '2021-03-14', '100', 'YES'),
('O100000002', 'C1001', '100.00', '2021-03-10', '101', 'YES'),
('O100000003', 'C1002', '500.00', '2021-02-14', '102', 'NO'),
('O100000004', 'C1002', '370.00', '2021-01-02', '100', 'YES'),
('O100000005', 'C1003', '475.00', '2021-02-18', '100', 'YES'),
('O100000006', 'C1003', '200.00', '2021-02-14', '100', 'NO');

-- --------------------------------------------------------

--
-- Table structure for table `supplier_info`
--

CREATE TABLE `supplier_info` (
  `supplier_id` varchar(4) NOT NULL,
  `supplier_name` varchar(255) NOT NULL,
  `supplier_phone_num` varchar(14) DEFAULT NULL,
  `supplier_address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier_info`
--

INSERT INTO `supplier_info` (`supplier_id`, `supplier_name`, `supplier_phone_num`, `supplier_address`) VALUES
('1001', 'Emon Optics', '8801921795690', '146-147 Sadhin Bangla Super Market'),
('1002', 'Monir Optics', '8801884827123', 'Boro Bazar Market(1st Floor) 104 Green Road Tejgaon, Farmgate, Dhaka - 1215'),
('1003', 'A R Optics', '8801912081038', '60 Feet Road, Mirpur'),
('1004', 'Bangla Vision', '8801920938877', ''),
('1005', 'Al Tayeba Optics', '8801710464766', '21/22 No. Potuakhali Road, Nurul Haque Tower, Dhaka - 1100');

-- --------------------------------------------------------

--
-- Table structure for table `supplies_info`
--

CREATE TABLE `supplies_info` (
  `supply_no` varchar(5) NOT NULL,
  `supplier_id` varchar(4) NOT NULL,
  `order_date` date NOT NULL,
  `delivery_date` date NOT NULL,
  `delivery_status` varchar(13) NOT NULL DEFAULT 'NOT DELIVERED'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplies_info`
--

INSERT INTO `supplies_info` (`supply_no`, `supplier_id`, `order_date`, `delivery_date`, `delivery_status`) VALUES
('P1001', '1003', '2020-11-26', '2021-01-06', 'NOT DELIVERED'),
('P1002', '1002', '2020-11-30', '2020-12-22', 'DELIVERED'),
('P1003', '1001', '2020-10-29', '2020-11-29', 'DELIVERED'),
('P1004', '1005', '2020-10-28', '2020-11-04', 'DELIVERED'),
('P1005', '1003', '2020-10-19', '2020-11-04', 'NOT DELIVERED'),
('P1006', '1004', '2021-03-20', '2021-03-28', 'NOT DELIVERED');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD KEY `client_id` (`client_id`);

--
-- Indexes for table `client_info`
--
ALTER TABLE `client_info`
  ADD PRIMARY KEY (`client_id`),
  ADD UNIQUE KEY `client_phone_num` (`client_phone_num`);

--
-- Indexes for table `client_order_specs`
--
ALTER TABLE `client_order_specs`
  ADD KEY `receipt_no` (`receipt_no`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `employee_information`
--
ALTER TABLE `employee_information`
  ADD PRIMARY KEY (`employee_id`),
  ADD UNIQUE KEY `employee_phone_num` (`employee_phone_num`);

--
-- Indexes for table `employee_permissions`
--
ALTER TABLE `employee_permissions`
  ADD UNIQUE KEY `employee_id` (`employee_id`);

--
-- Indexes for table `login_info`
--
ALTER TABLE `login_info`
  ADD UNIQUE KEY `employee_id` (`employee_id`);

--
-- Indexes for table `ordered_supplies`
--
ALTER TABLE `ordered_supplies`
  ADD KEY `supply_no` (`supply_no`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `product_info`
--
ALTER TABLE `product_info`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `sales_records`
--
ALTER TABLE `sales_records`
  ADD PRIMARY KEY (`receipt_no`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indexes for table `supplier_info`
--
ALTER TABLE `supplier_info`
  ADD PRIMARY KEY (`supplier_id`),
  ADD UNIQUE KEY `supplier_phone_num` (`supplier_phone_num`);

--
-- Indexes for table `supplies_info`
--
ALTER TABLE `supplies_info`
  ADD PRIMARY KEY (`supply_no`),
  ADD KEY `supplier_id` (`supplier_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client_info` (`client_id`);

--
-- Constraints for table `client_order_specs`
--
ALTER TABLE `client_order_specs`
  ADD CONSTRAINT `client_order_specs_ibfk_1` FOREIGN KEY (`receipt_no`) REFERENCES `sales_records` (`receipt_no`),
  ADD CONSTRAINT `client_order_specs_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product_info` (`product_id`);

--
-- Constraints for table `employee_permissions`
--
ALTER TABLE `employee_permissions`
  ADD CONSTRAINT `employee_permissions_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee_information` (`employee_id`);

--
-- Constraints for table `login_info`
--
ALTER TABLE `login_info`
  ADD CONSTRAINT `login_info_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee_information` (`employee_id`);

--
-- Constraints for table `ordered_supplies`
--
ALTER TABLE `ordered_supplies`
  ADD CONSTRAINT `ordered_supplies_ibfk_1` FOREIGN KEY (`supply_no`) REFERENCES `supplies_info` (`supply_no`),
  ADD CONSTRAINT `ordered_supplies_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product_info` (`product_id`);

--
-- Constraints for table `sales_records`
--
ALTER TABLE `sales_records`
  ADD CONSTRAINT `sales_records_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client_info` (`client_id`),
  ADD CONSTRAINT `sales_records_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee_information` (`employee_id`);

--
-- Constraints for table `supplies_info`
--
ALTER TABLE `supplies_info`
  ADD CONSTRAINT `supplies_info_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier_info` (`supplier_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
