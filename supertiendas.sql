-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-08-2023 a las 03:51:47
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `supertiendas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `nombre` varchar(100) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `direccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`nombre`, `cedula`, `email`, `telefono`, `direccion`) VALUES
('Edwin Wladimir Montenegro Cañizares', '1709973588', 'ed_monte65@yahoo.com', '022841804', 'Casa'),
('Taylor Alisson Swift Morales', '1706381975', 'taylor_s@gmail.com', '023040565', 'Beverly Hills'),
('Paola Marcela Cevallos Gomez', '1716975501', 'paolac@gmail.com', '023020658', 'Casa Paola'),
('Emilio Eduardo Diaz Gatia', '1723514335', 'emiliog@gmail.com', '023020541', 'Chillogallo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `codigo` varchar(7) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `cedula` int(10) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono1` varchar(9) NOT NULL,
  `telefono2` varchar(10) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `fecha` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`codigo`, `nombre`, `cedula`, `correo`, `telefono1`, `telefono2`, `direccion`, `fecha`, `usuario`, `contraseña`, `rol`) VALUES
('ST01', 'Juan Franciso Donoso Olivos', 1725578775, 'jdonoso@gmail.com', '022841804', '0987655427', 'Casa', '2023-07-28', 'jdonosoo@adm.st.com', 'ups-Jjjk01', 1),
('ST02', 'Edwin Mateo Montenegro Cañizares', 1709973588, 'emontenegro@gmail.com', '022841805', '0987655417', 'Casita', '2023-07-29', 'emontenegroc@sel.st.com', '1709973588', 2),
('ST03', 'Brenda Damaris Simbaña Gualavisí', 1702991363, 'bsimbana@gmail.com', '023020646', '0987655417', 'Casa', '2023-07-29', 'bsimbañag@sto.st.com', '1702991363', 3),
('ST04', 'Brithanny Mishelle Menendez Jácome', 401197298, 'bmenendez@gmail.com', '023049582', '0983345233', 'Casa', '2023-07-29', 'bmenendezj@sel.st.com', '0401197298', 2),
('ST05', 'Cristina Anabel Gatia Arguello', 200562791, 'cgatia@gmail.com', '023056831', '0995431746', 'Casa Cristina', '2023-07-30', 'cgatiaa@sto.st.com', '0200562791', 3),
('ST011', 'Jorge Emilio Donoso Suarez', 1801910678, 'jor_emilio@yahoo.com', '023045818', '0998765437', 'Casa Jorge', '2023-07-30', 'jdonosos@adm.st.com', '1801910678', 1),
('ST07', 'Julian Alberto Donoso Osorio', 101348795, 'juli_alb_os@gmail.com', '023645711', '0987654321', 'Casa Julian', '2023-07-30', 'jdonosoo2@sto.st.com', '0101348795', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `empleado` varchar(50) NOT NULL,
  `fecha` varchar(50) NOT NULL,
  `turno_lunes` varchar(50) DEFAULT NULL,
  `turno_martes` varchar(50) DEFAULT NULL,
  `turno_miercoles` varchar(50) DEFAULT NULL,
  `turno_jueves` varchar(50) DEFAULT NULL,
  `turno_viernes` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`empleado`, `fecha`, `turno_lunes`, `turno_martes`, `turno_miercoles`, `turno_jueves`, `turno_viernes`) VALUES
('Edwin Mateo Montenegro Cañizares (Vendedor)', '2023-07-29 18:27:18', '7:00-15:00', '13:00-21:00', '18:00-00:00', '23:00-7:00', '23:00-7:00'),
('Brithanny Mishelle Menendez Jácome (Vendedor)', '2023-08-01 10:00:18', '7:00-15:00', '13:00-21:00', '18:00-00:00', '23:00-7:00', '18:00-00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` varchar(7) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `peso` varchar(10) DEFAULT NULL,
  `unidades` varchar(5) NOT NULL,
  `precio` varchar(10) NOT NULL,
  `proveedor` varchar(50) NOT NULL,
  `tipo` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `peso`, `unidades`, `precio`, `proveedor`, `tipo`) VALUES
('00001', 'Pan', NULL, '0', '2.21', 'La Favorita', 'Unidad'),
('00002', 'Cola', NULL, '0', '2.0', 'Coca Cola Company', 'Unidad'),
('00003', 'Arroz', '1004.6', 'null', '2.0', 'La Favorita', 'Peso'),
('00004', 'Detergente', '185.7', 'null', '0.5', 'La Favorita', 'Peso'),
('00005', 'Azucar', '492.5', 'null', '5', 'Coca Cola Company', 'Peso'),
('00006', 'Queso', '92.5', 'null', '0.1', 'Coca Cola Company', 'Peso'),
('00007', 'Nueces', '598.5', 'null', '0.25', 'La Favorita', 'Peso'),
('00008', 'Azucarblanca', '14993.0', 'null', '25.0', 'San Carlos', 'Peso'),
('00009', 'Uwu', 'null', '21', '0.25', 'La Favorita', 'Unidad'),
('00010', 'Shampoo', 'null', '94', '3.5', 'El Rosado', 'Unidad'),
('00011', 'Mani', '19775.21', 'null', '0.5', 'Coca Cola Company', 'Peso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `codigo` varchar(5) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `contacto` varchar(50) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`codigo`, `nombre`, `contacto`, `telefono`, `email`) VALUES
('00001', 'La Favorita', 'Ingrid Cañizares', '023020636', 'icanizares@gmail.com'),
('00002', 'Coca Cola Company', 'Miguel García', '023020678', 'mgarcia@yahoo.com'),
('00003', 'El Rosado', 'Pablo Gallegos', '024976512', 'pablopink@gmail.com'),
('00004', 'San Carlos', 'Fernando Yepez', '025040675', 'fyepez@sancarlos.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
