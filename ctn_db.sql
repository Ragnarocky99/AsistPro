-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-10-2024 a las 16:49:48
-- Versión del servidor: 9.0.1
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ctn_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id_alumno` int NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `cdi` varchar(255) DEFAULT NULL,
  `curso` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `seccion` int DEFAULT NULL,
  `id_especialidad` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id_alumno`, `apellido`, `cdi`, `curso`, `estado`, `nombre`, `seccion`, `id_especialidad`) VALUES
(1, 'Espinola', '6363114', 'Primero', 'activo', 'Anibal', 1, 1),
(2, 'Estigarribia Delgadillo', '6911572.0', 'Primero', 'activo', 'Thiago David', 1, 1),
(3, 'Leon Coronel', '6168091.0', 'Primero', 'activo', 'Thiago Alexander', 1, 1),
(4, 'Benitez Barrios', '7350265.0', 'Primero', 'activo', 'Maria Cecilia', 1, 1),
(5, 'Caceres Achucarro', '7.536 039', 'Primero', 'activo', 'Valeria Alejandra', 1, 1),
(6, 'Valinotti Paredes', '6.761 746', 'Primero', 'activo', 'Leonardo', 1, 1),
(7, 'Dure Aquino', '6711232.0', 'Primero', 'activo', 'Kevin Matias', 1, 1),
(8, 'Martinez Gonzales', '6219481.0', 'Primero', 'activo', 'Lucas Abdiel', 1, 1),
(9, 'Amarilla Ettiene', '7011624.0', 'Primero', 'activo', 'Cesar Ezequiel', 1, 1),
(10, 'Noguera Avila', '6298042.0', 'Primero', 'activo', 'Miane Maria Veronica', 1, 1),
(11, 'Vera Salinas', '7.007 217', 'Primero', 'activo', 'Facundo Benjamin', 1, 1),
(12, 'Barreto Roche', '6.271 898', 'Primero', 'activo', 'Fernando Jose', 1, 1),
(13, 'Candia Romero', '6895905.0', 'Primero', 'activo', 'Carlos Antonio', 1, 1),
(14, 'Medina', '6218519.0', 'Primero', 'activo', 'Alan Nicolas', 1, 1),
(15, 'Schmidt Silveira', '6595852.0', 'Primero', 'activo', 'Samuel Jesus', 1, 1),
(16, 'Ortiz', '6552138', 'Primero', 'activo', 'Guillermo', 1, 1),
(17, 'Diaz Amarilla', '6274837.0', 'Primero', 'activo', 'Alice Gisselle', 1, 1),
(18, 'Martinez Insfran', '7449854.0', 'Primero', 'activo', 'Christopher Ivan', 1, 1),
(19, 'Molinas Leon', '6820120.0', 'Primero', 'activo', 'Marcos Daniel', 1, 1),
(20, 'Cubilla Morinigo', '7 979.695', 'Primero', 'activo', 'Jonas Alexander', 1, 1),
(21, 'Vazquez Peralta', '6658507.0', 'Primero', 'activo', 'Matias David', 1, 1),
(22, 'Soler Vazquez', '7309281.0', 'Primero', 'activo', 'Jose Federico', 1, 1),
(23, 'Mongelos Camacho', '6656584.0', 'Primero', 'activo', 'Joshua Fabrizio', 1, 1),
(24, 'Benitez Martinez', '7290536.0', 'Primero', 'activo', 'Sofia Esmeralda', 1, 1),
(25, 'Suarez Arza', '6711101.0', 'Primero', 'activo', 'Mikahela', 1, 1),
(26, 'Ortiz', '6520371', 'Primero', 'activo', 'Guille', 1, 1),
(27, 'Ojeda Oliver', '6840108.0', 'Primero', 'activo', 'Alan Enrique Damian', 1, 1),
(28, 'Espinola', '6216256', 'Primero', 'activo', 'Anibal', 1, 1),
(29, 'jimenez petero', '123', 'TERCERO', 'activo', 'jaun', 1, 1),
(30, 'Fariña Moran', '6363114.0', 'TERCERO', 'activo', 'Gloria Milena', 1, 1),
(31, 'Estigarribia Delgadillo', '6911572.0', 'TERCERO', 'activo', 'Thiago David', 1, 1),
(32, 'Leon Coronel', '6168091.0', 'TERCERO', 'activo', 'Thiago Alexander', 1, 1),
(33, 'Benitez Barrios', '7350265.0', 'TERCERO', 'activo', 'Maria Cecilia', 1, 1),
(34, 'Caceres Achucarro', '7.536 039', 'TERCERO', 'activo', 'Valeria Alejandra', 1, 1),
(35, 'Valinotti Paredes', '6.761 746', 'TERCERO', 'activo', 'Leonardo', 1, 1),
(36, 'Dure Aquino', '6711232.0', 'TERCERO', 'activo', 'Kevin Matias', 1, 1),
(37, 'Martinez Gonzales', '6219481.0', 'TERCERO', 'activo', 'Lucas Abdiel', 1, 1),
(38, 'Amarilla Ettiene', '7011624.0', 'TERCERO', 'activo', 'Cesar Ezequiel', 1, 1),
(39, 'Noguera Avila', '6298042.0', 'TERCERO', 'activo', 'Miane Maria Veronica', 1, 1),
(40, 'Vera Salinas', '7.007 217', 'TERCERO', 'activo', 'Facundo Benjamin', 1, 1),
(41, 'Barreto Roche', '6.271 898', 'TERCERO', 'activo', 'Fernando Jose', 1, 1),
(42, 'Candia Romero', '6895905.0', 'TERCERO', 'activo', 'Carlos Antonio', 1, 1),
(43, 'Gayozo Avalos', '6218519.0', 'TERCERO', 'activo', 'Luz Nahiara', 1, 1),
(44, 'Schmidt Silveira', '6595852.0', 'TERCERO', 'activo', 'Samuel Jesus', 1, 1),
(45, 'Acuña Rodriguez', '6552138.0', 'TERCERO', 'activo', 'Paz Fiorella', 1, 1),
(46, 'Diaz Amarilla', '6274837.0', 'TERCERO', 'activo', 'Alice Gisselle', 1, 1),
(47, 'Martinez Insfran', '7449854.0', 'TERCERO', 'activo', 'Christopher Ivan', 1, 1),
(48, 'Molinas Leon', '6820120.0', 'TERCERO', 'activo', 'Marcos Daniel', 1, 1),
(49, 'Cubilla Morinigo', '7 979.695', 'TERCERO', 'activo', 'Jonas Alexander', 1, 1),
(50, 'Olmedo Rodriguez', '6658507.0', 'TERCERO', 'activo', 'Alexander Agustin', 1, 1),
(51, 'Ortega', '7309281', 'Primero', 'activo', 'Valeria', 1, 1),
(52, 'Mongelos Camacho', '6656584.0', 'TERCERO', 'activo', 'Joshua Fabrizio', 1, 1),
(53, 'Benitez Martinez', '7290536.0', 'TERCERO', 'activo', 'Sofia Esmeralda', 1, 1),
(54, 'Suarez Arza', '6711101.0', 'TERCERO', 'activo', 'Mikahela', 1, 1),
(55, 'Alegre Ortiz', '6520371.0', 'TERCERO', 'activo', 'Gabriela Elizabeth', 1, 1),
(56, 'Ojeda Oliver', '6840108.0', 'TERCERO', 'activo', 'Alan Enrique Damian', 1, 1),
(57, 'Gamarra Aguayo', '6216256.0', 'TERCERO', 'activo', 'Lucio Alessandro', 1, 1),
(58, 'Fariña Moran', '6363114.0', 'Tercero', 'activo', 'Gloria Milena', 1, 2),
(59, 'Fariña Moran', '6363114.0', 'Tercero', 'activo', 'Gloria Milena', 1, 2),
(60, 'Estigarribia Delgadillo', '6911572.0', 'Tercero', 'activo', 'Thiago David', 1, 2),
(61, 'Estigarribia Delgadillo', '6911572.0', 'Tercero', 'activo', 'Thiago David', 1, 2),
(62, 'Leon Coronel', '6168091.0', 'Tercero', 'activo', 'Thiago Alexander', 1, 2),
(63, 'Leon Coronel', '6168091.0', 'Tercero', 'activo', 'Thiago Alexander', 1, 2),
(64, 'Benitez Barrios', '7350265.0', 'Tercero', 'activo', 'Maria Cecilia', 1, 2),
(65, 'Benitez Barrios', '7350265.0', 'Tercero', 'activo', 'Maria Cecilia', 1, 2),
(66, 'Caceres Achucarro', '7.536 039', 'Tercero', 'activo', 'Valeria Alejandra', 1, 2),
(67, 'Caceres Achucarro', '7.536 039', 'Tercero', 'activo', 'Valeria Alejandra', 1, 2),
(68, 'Valinotti Paredes', '6.761 746', 'Tercero', 'activo', 'Leonardo', 1, 2),
(69, 'Valinotti Paredes', '6.761 746', 'Tercero', 'activo', 'Leonardo', 1, 2),
(70, 'Dure Aquino', '6711232.0', 'Tercero', 'activo', 'Kevin Matias', 1, 2),
(71, 'Dure Aquino', '6711232.0', 'Tercero', 'activo', 'Kevin Matias', 1, 2),
(72, 'Martinez Gonzales', '6219481.0', 'Tercero', 'activo', 'Lucas Abdiel', 1, 2),
(73, 'Martinez Gonzales', '6219481.0', 'Tercero', 'activo', 'Lucas Abdiel', 1, 2),
(74, 'Amarilla Ettiene', '7011624.0', 'Tercero', 'activo', 'Cesar Ezequiel', 1, 2),
(75, 'Amarilla Ettiene', '7011624.0', 'Tercero', 'activo', 'Cesar Ezequiel', 1, 2),
(76, 'Noguera Avila', '6298042.0', 'Tercero', 'activo', 'Miane Maria Veronica', 1, 2),
(77, 'Noguera Avila', '6298042.0', 'Tercero', 'activo', 'Miane Maria Veronica', 1, 2),
(78, 'Vera Salinas', '7.007 217', 'Tercero', 'activo', 'Facundo Benjamin', 1, 2),
(79, 'Vera Salinas', '7.007 217', 'Tercero', 'activo', 'Facundo Benjamin', 1, 2),
(80, 'Barreto Roche', '6.271 898', 'Tercero', 'activo', 'Fernando Jose', 1, 2),
(81, 'Candia Romero', '6895905.0', 'Tercero', 'activo', 'Carlos Antonio', 1, 2),
(82, 'Barreto Roche', '6.271 898', 'Tercero', 'activo', 'Fernando Jose', 1, 2),
(83, 'Gayozo Avalos', '6218519.0', 'Tercero', 'activo', 'Luz Nahiara', 1, 2),
(84, 'Candia Romero', '6895905.0', 'Tercero', 'activo', 'Carlos Antonio', 1, 2),
(85, 'Gayozo Avalos', '6218519.0', 'Tercero', 'activo', 'Luz Nahiara', 1, 2),
(86, 'Schmidt Silveira', '6595852.0', 'Tercero', 'activo', 'Samuel Jesus', 1, 2),
(87, 'Acuña Rodriguez', '6552138.0', 'Tercero', 'activo', 'Paz Fiorella', 1, 2),
(88, 'Schmidt Silveira', '6595852.0', 'Tercero', 'activo', 'Samuel Jesus', 1, 2),
(89, 'Diaz Amarilla', '6274837.0', 'Tercero', 'activo', 'Alice Gisselle', 1, 2),
(90, 'Acuña Rodriguez', '6552138.0', 'Tercero', 'activo', 'Paz Fiorella', 1, 2),
(91, 'Martinez Insfran', '7449854.0', 'Tercero', 'activo', 'Christopher Ivan', 1, 2),
(92, 'Diaz Amarilla', '6274837.0', 'Tercero', 'activo', 'Alice Gisselle', 1, 2),
(93, 'Martinez Insfran', '7449854.0', 'Tercero', 'activo', 'Christopher Ivan', 1, 2),
(94, 'Molinas Leon', '6820120.0', 'Tercero', 'activo', 'Marcos Daniel', 1, 2),
(95, 'Cubilla Morinigo', '7 979.695', 'Tercero', 'activo', 'Jonas Alexander', 1, 2),
(96, 'Molinas Leon', '6820120.0', 'Tercero', 'activo', 'Marcos Daniel', 1, 2),
(97, 'Olmedo Rodriguez', '6658507.0', 'Tercero', 'activo', 'Alexander Agustin', 1, 2),
(98, 'Soler Vazquez', '7309281.0', 'Tercero', 'activo', 'Jose Federico', 1, 2),
(99, 'Mongelos Camacho', '6656584.0', 'Tercero', 'activo', 'Joshua Fabrizio', 1, 2),
(100, 'Cubilla Morinigo', '7 979.695', 'Tercero', 'activo', 'Jonas Alexander', 1, 2),
(101, 'Benitez Martinez', '7290536.0', 'Tercero', 'activo', 'Sofia Esmeralda', 1, 2),
(102, 'Olmedo Rodriguez', '6658507.0', 'Tercero', 'activo', 'Alexander Agustin', 1, 2),
(103, 'Soler Vazquez', '7309281.0', 'Tercero', 'activo', 'Jose Federico', 1, 2),
(104, 'Suarez Arza', '6711101.0', 'Tercero', 'activo', 'Mikahela', 1, 2),
(105, 'Alegre Ortiz', '6520371.0', 'Tercero', 'activo', 'Gabriela Elizabeth', 1, 2),
(106, 'Mongelos Camacho', '6656584.0', 'Tercero', 'activo', 'Joshua Fabrizio', 1, 2),
(107, 'Benitez Martinez', '7290536.0', 'Tercero', 'activo', 'Sofia Esmeralda', 1, 2),
(108, 'Ojeda Oliver', '6840108.0', 'Tercero', 'activo', 'Alan Enrique Damian', 1, 2),
(109, 'Suarez Arza', '6711101.0', 'Tercero', 'activo', 'Mikahela', 1, 2),
(110, 'Gamarra Aguayo', '6216256.0', 'Tercero', 'activo', 'Lucio Alessandro', 1, 2),
(111, 'Alegre Ortiz', '6520371.0', 'Tercero', 'activo', 'Gabriela Elizabeth', 1, 2),
(112, 'Ojeda Oliver', '6840108.0', 'Tercero', 'activo', 'Alan Enrique Damian', 1, 2),
(113, 'Gamarra Aguayo', '6216256.0', 'Tercero', 'activo', 'Lucio Alessandro', 1, 2),
(114, '1', '4', 'Primero', 'activo', 'a', 1, 1),
(115, 'Fariña Moran', '6363114.0', 'Primero', 'inactivo', 'Gloria Milena', 2, 2),
(116, 'Fariña Moran', '6363114.0', 'Primero', 'inactivo', 'Gloria Milena', 2, 2),
(117, 'Estigarribia Delgadillo', '6911572.0', 'Primero', 'inactivo', 'Thiago David', 2, 2),
(118, 'Estigarribia Delgadillo', '6911572.0', 'Primero', 'inactivo', 'Thiago David', 2, 2),
(119, 'Leon Coronel', '6168091.0', 'Primero', 'inactivo', 'Thiago Alexander', 2, 2),
(120, 'Leon Coronel', '6168091.0', 'Primero', 'inactivo', 'Thiago Alexander', 2, 2),
(121, 'Benitez Barrios', '7350265.0', 'Primero', 'inactivo', 'Maria Cecilia', 2, 2),
(122, 'Benitez Barrios', '7350265.0', 'Primero', 'inactivo', 'Maria Cecilia', 2, 2),
(123, 'Caceres Achucarro', '7.536 039', 'Primero', 'inactivo', 'Valeria Alejandra', 2, 2),
(124, 'Caceres Achucarro', '7.536 039', 'Primero', 'inactivo', 'Valeria Alejandra', 2, 2),
(125, 'Valinotti Paredes', '6.761 746', 'Primero', 'inactivo', 'Leonardo', 2, 2),
(126, 'Valinotti Paredes', '6.761 746', 'Primero', 'inactivo', 'Leonardo', 2, 2),
(127, 'Dure Aquino', '6711232.0', 'Primero', 'inactivo', 'Kevin Matias', 2, 2),
(128, 'Dure Aquino', '6711232.0', 'Primero', 'inactivo', 'Kevin Matias', 2, 2),
(129, 'Martinez Gonzales', '6219481.0', 'Primero', 'inactivo', 'Lucas Abdiel', 2, 2),
(130, 'Martinez Gonzales', '6219481.0', 'Primero', 'inactivo', 'Lucas Abdiel', 2, 2),
(131, 'Amarilla Ettiene', '7011624.0', 'Primero', 'inactivo', 'Cesar Ezequiel', 2, 2),
(132, 'Amarilla Ettiene', '7011624.0', 'Primero', 'inactivo', 'Cesar Ezequiel', 2, 2),
(133, 'Noguera Avila', '6298042.0', 'Primero', 'inactivo', 'Miane Maria Veronica', 2, 2),
(134, 'Noguera Avila', '6298042.0', 'Primero', 'inactivo', 'Miane Maria Veronica', 2, 2),
(135, 'Vera Salinas', '7.007 217', 'Primero', 'inactivo', 'Facundo Benjamin', 2, 2),
(136, 'Vera Salinas', '7.007 217', 'Primero', 'inactivo', 'Facundo Benjamin', 2, 2),
(137, 'Barreto Roche', '6.271 898', 'Primero', 'inactivo', 'Fernando Jose', 2, 2),
(138, 'Barreto Roche', '6.271 898', 'Primero', 'inactivo', 'Fernando Jose', 2, 2),
(139, 'Candia Romero', '6895905.0', 'Primero', 'inactivo', 'Carlos Antonio', 2, 2),
(140, 'Candia Romero', '6895905.0', 'Primero', 'inactivo', 'Carlos Antonio', 2, 2),
(141, 'Gayozo Avalos', '6218519.0', 'Primero', 'inactivo', 'Luz Nahiara', 2, 2),
(142, 'Gayozo Avalos', '6218519.0', 'Primero', 'inactivo', 'Luz Nahiara', 2, 2),
(143, 'Schmidt Silveira', '6595852.0', 'Primero', 'inactivo', 'Samuel Jesus', 2, 2),
(144, 'Schmidt Silveira', '6595852.0', 'Primero', 'inactivo', 'Samuel Jesus', 2, 2),
(145, 'Acuña Rodriguez', '6552138.0', 'Primero', 'inactivo', 'Paz Fiorella', 2, 2),
(146, 'Acuña Rodriguez', '6552138.0', 'Primero', 'inactivo', 'Paz Fiorella', 2, 2),
(147, 'Diaz Amarilla', '6274837.0', 'Primero', 'inactivo', 'Alice Gisselle', 2, 2),
(148, 'Diaz Amarilla', '6274837.0', 'Primero', 'inactivo', 'Alice Gisselle', 2, 2),
(149, 'Martinez Insfran', '7449854.0', 'Primero', 'inactivo', 'Christopher Ivan', 2, 2),
(150, 'Martinez Insfran', '7449854.0', 'Primero', 'inactivo', 'Christopher Ivan', 2, 2),
(151, 'Molinas Leon', '6820120.0', 'Primero', 'inactivo', 'Marcos Daniel', 2, 2),
(152, 'Molinas Leon', '6820120.0', 'Primero', 'inactivo', 'Marcos Daniel', 2, 2),
(153, 'Cubilla Morinigo', '7 979.695', 'Primero', 'inactivo', 'Jonas Alexander', 2, 2),
(154, 'Cubilla Morinigo', '7 979.695', 'Primero', 'inactivo', 'Jonas Alexander', 2, 2),
(155, 'Olmedo Rodriguez', '6658507.0', 'Primero', 'inactivo', 'Alexander Agustin', 2, 2),
(156, 'Olmedo Rodriguez', '6658507.0', 'Primero', 'inactivo', 'Alexander Agustin', 2, 2),
(157, 'Soler Vazquez', '7309281.0', 'Primero', 'inactivo', 'Jose Federico', 2, 2),
(158, 'Soler Vazquez', '7309281.0', 'Primero', 'inactivo', 'Jose Federico', 2, 2),
(159, 'Mongelos Camacho', '6656584.0', 'Primero', 'inactivo', 'Joshua Fabrizio', 2, 2),
(160, 'Mongelos Camacho', '6656584.0', 'Primero', 'inactivo', 'Joshua Fabrizio', 2, 2),
(161, 'Benitez Martinez', '7290536.0', 'Primero', 'inactivo', 'Sofia Esmeralda', 2, 2),
(162, 'Benitez Martinez', '7290536.0', 'Primero', 'inactivo', 'Sofia Esmeralda', 2, 2),
(163, 'Suarez Arza', '6711101.0', 'Primero', 'inactivo', 'Mikahela', 2, 2),
(164, 'Suarez Arza', '6711101.0', 'Primero', 'inactivo', 'Mikahela', 2, 2),
(165, 'Alegre Ortiz', '6520371.0', 'Primero', 'inactivo', 'Gabriela Elizabeth', 2, 2),
(166, 'Alegre Ortiz', '6520371.0', 'Primero', 'inactivo', 'Gabriela Elizabeth', 2, 2),
(167, 'Ojeda Oliver', '6840108.0', 'Primero', 'inactivo', 'Alan Enrique Damian', 2, 2),
(168, 'Ojeda Oliver', '6840108.0', 'Primero', 'inactivo', 'Alan Enrique Damian', 2, 2),
(169, 'Gamarra Aguayo', '6216256.0', 'Primero', 'inactivo', 'Lucio Alessandro', 2, 2),
(170, 'Gamarra Aguayo', '6216256.0', 'Primero', 'inactivo', 'Lucio Alessandro', 2, 2),
(171, 'Fariña Moran', '6363114.0', 'Primero', 'activo', 'Gloria Milena', 2, 2),
(172, 'Estigarribia Delgadillo', '6911572.0', 'Primero', 'activo', 'Thiago David', 2, 2),
(173, 'Leon Coronel', '6168091.0', 'Primero', 'activo', 'Thiago Alexander', 2, 2),
(174, 'Benitez Barrios', '7350265.0', 'Primero', 'activo', 'Maria Cecilia', 2, 2),
(175, 'Caceres Achucarro', '7.536 039', 'Primero', 'activo', 'Valeria Alejandra', 2, 2),
(176, 'Valinotti Paredes', '6.761 746', 'Primero', 'activo', 'Leonardo', 2, 2),
(177, 'Dure Aquino', '6711232.0', 'Primero', 'activo', 'Kevin Matias', 2, 2),
(178, 'Martinez Gonzales', '6219481.0', 'Primero', 'activo', 'Lucas Abdiel', 2, 2),
(179, 'Amarilla Ettiene', '7011624.0', 'Primero', 'activo', 'Cesar Ezequiel', 2, 2),
(180, 'Noguera Avila', '6298042.0', 'Primero', 'activo', 'Miane Maria Veronica', 2, 2),
(181, 'Vera Salinas', '7.007 217', 'Primero', 'activo', 'Facundo Benjamin', 2, 2),
(182, 'Barreto Roche', '6.271 898', 'Primero', 'activo', 'Fernando Jose', 2, 2),
(183, 'Candia Romero', '6895905.0', 'Primero', 'activo', 'Carlos Antonio', 2, 2),
(184, 'Gayozo Avalos', '6218519.0', 'Primero', 'activo', 'Luz Nahiara', 2, 2),
(185, 'Schmidt Silveira', '6595852.0', 'Primero', 'activo', 'Samuel Jesus', 2, 2),
(186, 'Acuña Rodriguez', '6552138.0', 'Primero', 'activo', 'Paz Fiorella', 2, 2),
(187, 'Diaz Amarilla', '6274837.0', 'Primero', 'activo', 'Alice Gisselle', 2, 2),
(188, 'Martinez Insfran', '7449854.0', 'Primero', 'activo', 'Christopher Ivan', 2, 2),
(189, 'Molinas Leon', '6820120.0', 'Primero', 'activo', 'Marcos Daniel', 2, 2),
(190, 'Cubilla Morinigo', '7 979.695', 'Primero', 'activo', 'Jonas Alexander', 2, 2),
(191, 'Olmedo Rodriguez', '6658507.0', 'Primero', 'activo', 'Alexander Agustin', 2, 2),
(192, 'Soler Vazquez', '7309281.0', 'Primero', 'activo', 'Jose Federico', 2, 2),
(193, 'Mongelos Camacho', '6656584.0', 'Primero', 'activo', 'Joshua Fabrizio', 2, 2),
(194, 'Benitez Martinez', '7290536.0', 'Primero', 'activo', 'Sofia Esmeralda', 2, 2),
(195, 'Suarez Arza', '6711101.0', 'Primero', 'activo', 'Mikahela', 2, 2),
(196, 'Alegre Ortiz', '6520371.0', 'Primero', 'activo', 'Gabriela Elizabeth', 2, 2),
(197, 'Ojeda Oliver', '6840108.0', 'Primero', 'activo', 'Alan Enrique Damian', 2, 2),
(198, 'Gamarra Aguayo', '6216256.0', 'Primero', 'activo', 'Lucio Alessandro', 2, 2),
(199, 'Fariña Moran', '6363114.0', 'Primero', 'activo', 'Gloria Milena', 1, 2),
(200, 'Estigarribia Delgadillo', '6911572.0', 'Primero', 'activo', 'Thiago David', 1, 2),
(201, 'Leon Coronel', '6168091.0', 'Primero', 'activo', 'Thiago Alexander', 1, 2),
(202, 'Benitez Barrios', '7350265.0', 'Primero', 'activo', 'Maria Cecilia', 1, 2),
(203, 'Caceres Achucarro', '7.536 039', 'Primero', 'activo', 'Valeria Alejandra', 1, 2),
(204, 'Valinotti Paredes', '6.761 746', 'Primero', 'activo', 'Leonardo', 1, 2),
(205, 'Dure Aquino', '6711232.0', 'Primero', 'activo', 'Kevin Matias', 1, 2),
(206, 'Martinez Gonzales', '6219481.0', 'Primero', 'activo', 'Lucas Abdiel', 1, 2),
(207, 'Amarilla Ettiene', '7011624.0', 'Primero', 'activo', 'Cesar Ezequiel', 1, 2),
(208, 'Noguera Avila', '6298042.0', 'Primero', 'activo', 'Miane Maria Veronica', 1, 2),
(209, 'Vera Salinas', '7.007 217', 'Primero', 'activo', 'Facundo Benjamin', 1, 2),
(210, 'Barreto Roche', '6.271 898', 'Primero', 'activo', 'Fernando Jose', 1, 2),
(211, 'Candia Romero', '6895905.0', 'Primero', 'activo', 'Carlos Antonio', 1, 2),
(212, 'Gayozo Avalos', '6218519.0', 'Primero', 'activo', 'Luz Nahiara', 1, 2),
(213, 'Schmidt Silveira', '6595852.0', 'Primero', 'activo', 'Samuel Jesus', 1, 2),
(214, 'Acuña Rodriguez', '6552138.0', 'Primero', 'activo', 'Paz Fiorella', 1, 2),
(215, 'Diaz Amarilla', '6274837.0', 'Primero', 'activo', 'Alice Gisselle', 1, 2),
(216, 'Martinez Insfran', '7449854.0', 'Primero', 'activo', 'Christopher Ivan', 1, 2),
(217, 'Molinas Leon', '6820120.0', 'Primero', 'activo', 'Marcos Daniel', 1, 2),
(218, 'Cubilla Morinigo', '7 979.695', 'Primero', 'activo', 'Jonas Alexander', 1, 2),
(219, 'Olmedo Rodriguez', '6658507.0', 'Primero', 'activo', 'Alexander Agustin', 1, 2),
(220, 'Soler Vazquez', '7309281.0', 'Primero', 'activo', 'Jose Federico', 1, 2),
(221, 'Mongelos Camacho', '6656584.0', 'Primero', 'activo', 'Joshua Fabrizio', 1, 2),
(222, 'Benitez Martinez', '7290536.0', 'Primero', 'activo', 'Sofia Esmeralda', 1, 2),
(223, 'Suarez Arza', '6711101.0', 'Primero', 'activo', 'Mikahela', 1, 2),
(224, 'Alegre Ortiz', '6520371.0', 'Primero', 'activo', 'Gabriela Elizabeth', 1, 2),
(225, 'Ojeda Oliver', '6840108.0', 'Primero', 'activo', 'Alan Enrique Damian', 1, 2),
(226, 'Gamarra Aguayo', '6216256.0', 'Primero', 'activo', 'Lucio Alessandro', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `id_asistencia` int NOT NULL,
  `fecha` date DEFAULT NULL,
  `id_horario` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `asistencia`
--

INSERT INTO `asistencia` (`id_asistencia`, `fecha`, `id_horario`) VALUES
(59, '2024-09-09', 81),
(60, '2024-09-09', 118),
(61, '2024-09-09', 119),
(62, '2024-10-08', 87);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_asistencia`
--

CREATE TABLE `detalle_asistencia` (
  `esta_presente` bit(1) NOT NULL,
  `hora_presencia` time(6) DEFAULT NULL,
  `id_alumno` int NOT NULL,
  `id_asistencia` int NOT NULL,
  `rasgos` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `detalle_asistencia`
--

INSERT INTO `detalle_asistencia` (`esta_presente`, `hora_presencia`, `id_alumno`, `id_asistencia`, `rasgos`) VALUES
(b'0', '09:16:31.301000', 1, 59, 'N1,N2'),
(b'0', '11:59:33.662000', 1, 60, 'N6,N7'),
(b'0', '14:15:50.956000', 1, 61, ''),
(b'1', '13:29:30.717000', 1, 62, ''),
(b'1', '09:13:57.874000', 2, 59, 'N1,N2'),
(b'0', '11:49:58.371000', 2, 60, ''),
(b'0', NULL, 2, 61, ''),
(b'1', '13:29:48.122000', 2, 62, ''),
(b'1', '09:16:39.289000', 3, 59, 'N1,N2,N3,N4,N5,N6,N7,N8,N9'),
(b'0', '10:54:50.096000', 3, 60, ''),
(b'0', NULL, 3, 61, ''),
(b'0', NULL, 3, 62, ''),
(b'0', '09:14:15.891000', 4, 59, ''),
(b'0', '10:55:06.902000', 4, 60, ''),
(b'0', NULL, 4, 61, ''),
(b'1', NULL, 4, 62, ''),
(b'0', NULL, 5, 59, ''),
(b'1', '11:05:19.148000', 5, 60, 'N1,N2,N3,N4,N5,N6,N7,N8,N9'),
(b'0', NULL, 5, 61, ''),
(b'0', NULL, 5, 62, ''),
(b'0', NULL, 6, 59, ''),
(b'1', '11:50:26.329000', 6, 60, 'N1,N3,N4,N7'),
(b'0', NULL, 6, 61, ''),
(b'0', NULL, 6, 62, ''),
(b'0', NULL, 7, 59, ''),
(b'0', NULL, 7, 60, ''),
(b'0', NULL, 7, 61, ''),
(b'0', NULL, 7, 62, ''),
(b'0', NULL, 8, 59, ''),
(b'0', NULL, 8, 60, ''),
(b'0', NULL, 8, 61, ''),
(b'0', NULL, 8, 62, ''),
(b'0', NULL, 9, 59, ''),
(b'0', NULL, 9, 60, ''),
(b'0', NULL, 9, 61, ''),
(b'0', NULL, 9, 62, ''),
(b'0', NULL, 10, 59, ''),
(b'0', NULL, 10, 60, ''),
(b'0', NULL, 10, 61, ''),
(b'0', NULL, 10, 62, ''),
(b'0', NULL, 11, 59, ''),
(b'0', NULL, 11, 60, ''),
(b'0', NULL, 11, 61, ''),
(b'0', NULL, 11, 62, ''),
(b'0', NULL, 12, 59, ''),
(b'0', NULL, 12, 60, ''),
(b'0', NULL, 12, 61, ''),
(b'0', NULL, 12, 62, ''),
(b'0', NULL, 13, 59, ''),
(b'0', NULL, 13, 60, ''),
(b'0', NULL, 13, 61, ''),
(b'0', NULL, 13, 62, ''),
(b'1', '08:52:41.069000', 14, 59, 'N2'),
(b'1', '10:29:52.021000', 14, 60, ''),
(b'0', '15:29:54.549000', 14, 61, 'N1,N4'),
(b'0', NULL, 14, 62, ''),
(b'0', '08:50:48.501000', 15, 59, 'N1,N2,N3'),
(b'0', NULL, 15, 60, ''),
(b'0', NULL, 15, 61, ''),
(b'0', NULL, 15, 62, ''),
(b'0', '08:56:34.876000', 16, 59, ''),
(b'0', NULL, 16, 60, ''),
(b'0', NULL, 16, 61, ''),
(b'0', NULL, 16, 62, ''),
(b'0', NULL, 17, 59, ''),
(b'0', NULL, 17, 60, ''),
(b'0', NULL, 17, 61, ''),
(b'0', NULL, 17, 62, ''),
(b'0', NULL, 18, 59, ''),
(b'0', NULL, 18, 60, ''),
(b'0', NULL, 18, 61, ''),
(b'0', NULL, 18, 62, ''),
(b'0', NULL, 19, 59, ''),
(b'0', NULL, 19, 60, ''),
(b'0', NULL, 19, 61, ''),
(b'0', NULL, 19, 62, ''),
(b'0', NULL, 20, 59, ''),
(b'0', NULL, 20, 60, ''),
(b'0', NULL, 20, 61, ''),
(b'0', NULL, 20, 62, ''),
(b'0', NULL, 21, 59, ''),
(b'0', NULL, 21, 60, ''),
(b'0', '15:39:29.929000', 21, 61, 'N1,N2,N3'),
(b'0', NULL, 21, 62, ''),
(b'0', NULL, 22, 59, ''),
(b'0', NULL, 22, 60, ''),
(b'0', NULL, 22, 61, ''),
(b'0', NULL, 22, 62, ''),
(b'0', NULL, 23, 59, ''),
(b'0', NULL, 23, 60, ''),
(b'0', NULL, 23, 61, ''),
(b'0', NULL, 23, 62, ''),
(b'0', NULL, 24, 59, ''),
(b'0', NULL, 24, 60, ''),
(b'0', NULL, 24, 61, ''),
(b'0', NULL, 24, 62, ''),
(b'0', NULL, 25, 59, ''),
(b'0', NULL, 25, 60, ''),
(b'0', NULL, 25, 61, ''),
(b'0', NULL, 25, 62, ''),
(b'0', '08:57:38.530000', 26, 59, ''),
(b'0', NULL, 26, 60, ''),
(b'0', NULL, 26, 61, ''),
(b'0', NULL, 26, 62, ''),
(b'0', NULL, 27, 59, ''),
(b'0', NULL, 27, 60, ''),
(b'0', NULL, 27, 61, ''),
(b'0', NULL, 27, 62, ''),
(b'0', '09:04:34.412000', 28, 59, 'N1,N2,N3'),
(b'0', NULL, 28, 60, ''),
(b'0', NULL, 28, 61, ''),
(b'0', NULL, 28, 62, ''),
(b'0', NULL, 51, 59, ''),
(b'0', NULL, 51, 60, ''),
(b'0', NULL, 51, 61, ''),
(b'0', NULL, 51, 62, ''),
(b'0', NULL, 114, 59, ''),
(b'0', NULL, 114, 60, ''),
(b'0', NULL, 114, 61, ''),
(b'0', NULL, 114, 62, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfasis`
--

CREATE TABLE `enfasis` (
  `id_enfasis` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `enfasis`
--

INSERT INTO `enfasis` (`id_enfasis`, `nombre`) VALUES
(1, 'Plan Comun'),
(2, 'Plan Especifico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id_especialidad` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id_especialidad`, `nombre`) VALUES
(1, 'Informatica'),
(2, 'Electricidad'),
(3, 'Mecanica Automotriz'),
(4, 'Mecanica Industrial'),
(5, 'Electromecanica'),
(6, 'Construcciones Civiles'),
(7, 'Electronica'),
(8, 'Quimica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE `horario` (
  `id_horario` int NOT NULL,
  `hora_fin` time DEFAULT NULL,
  `hora_inicio` time DEFAULT NULL,
  `seccion` int NOT NULL,
  `id_especialidad` int DEFAULT NULL,
  `id_materia` int DEFAULT NULL,
  `id_profesor` int DEFAULT NULL,
  `id_sala` int DEFAULT NULL,
  `dias` varchar(255) DEFAULT NULL,
  `curso` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`id_horario`, `hora_fin`, `hora_inicio`, `seccion`, `id_especialidad`, `id_materia`, `id_profesor`, `id_sala`, `dias`, `curso`) VALUES
(81, '09:20:00', '08:10:00', 1, 1, 8, 8, 1, 'LUNES', 'Primero'),
(82, '09:20:00', '07:00:00', 1, 1, 4, 8, 1, 'LUNES', 'Segundo'),
(83, '12:00:00', '09:40:00', 1, 1, 6, 8, 1, 'LUNES', 'Segundo'),
(84, '15:20:00', '14:10:00', 1, 1, 6, 3, 1, 'LUNES', 'Segundo'),
(85, '12:00:00', '09:40:00', 1, 1, 4, 13, 1, 'LUNES', 'Tercero'),
(86, '12:00:00', '10:50:00', 1, 1, 6, 2, 1, 'MARTES', 'Primero'),
(87, '14:10:00', '13:00:00', 1, 1, 11, 2, 1, 'MARTES', 'Primero'),
(88, '09:20:00', '07:00:00', 1, 1, 1, 5, 1, 'MIÉRCOLES', 'Primero'),
(89, '09:20:00', '08:10:00', 1, 1, 11, 8, 1, 'MIÉRCOLES', 'Segundo'),
(90, '15:20:00', '13:00:00', 1, 1, 11, 8, 1, 'MIÉRCOLES', 'Segundo'),
(91, '09:20:00', '08:10:00', 1, 1, 14, 7, 1, 'JUEVES', 'Primero'),
(92, '12:00:00', '10:50:00', 1, 1, 1, 5, 1, 'JUEVES', 'Primero'),
(93, '09:20:00', '07:00:00', 1, 1, 1, 5, 1, 'JUEVES', 'Segundo'),
(94, '15:20:00', '13:00:00', 1, 1, 1, 2, 1, 'JUEVES', 'Segundo'),
(95, '12:00:00', '09:40:00', 1, 1, 1, 5, 1, 'JUEVES', 'Tercero'),
(96, '09:20:00', '07:00:00', 1, 1, 4, 2, 1, 'VIERNES', 'Primero'),
(97, '08:10:00', '07:00:00', 1, 1, 1, 5, 1, 'VIERNES', 'Segundo'),
(98, '09:20:00', '08:10:00', 1, 1, 14, 7, 1, 'VIERNES', 'Segundo'),
(99, '09:20:00', '08:10:00', 1, 1, 1, 5, 1, 'VIERNES', 'Tercero'),
(100, '12:00:00', '09:40:00', 1, 1, 14, 7, 1, 'VIERNES', 'Tercero'),
(101, '14:10:00', '13:00:00', 2, 1, 6, 7, 1, 'LUNES', 'Segundo'),
(102, '15:20:00', '14:10:00', 2, 1, 14, 7, 1, 'LUNES', 'Segundo'),
(103, '09:20:00', '07:00:00', 2, 1, 4, 5, 1, 'MARTES', 'Primero'),
(104, '12:00:00', '09:40:00', 2, 1, 1, 5, 1, 'MARTES', 'Primero'),
(105, '12:00:00', '09:40:00', 2, 1, 6, 2, 1, 'MARTES', 'Segundo'),
(106, '09:20:00', '07:00:00', 2, 1, 1, 5, 1, 'MARTES', 'Tercero'),
(107, '08:10:00', '07:00:00', 2, 1, 11, 8, 1, 'MIÉRCOLES', 'Primero'),
(108, '09:20:00', '08:10:00', 2, 1, 8, 8, 1, 'MIÉRCOLES', 'Primero'),
(109, '12:00:00', '09:40:00', 2, 1, 1, 5, 1, 'MIÉRCOLES', 'Primero'),
(110, '23:50:00', '17:00:00', 1, 1, 11, 5, 1, 'DOMINGO', 'Primero'),
(111, '12:00:00', '10:50:00', 2, 1, 1, 5, 1, 'MIÉRCOLES', 'Segundo'),
(112, '12:00:00', '09:40:00', 2, 1, 4, 12, 1, 'JUEVES', 'Segundo'),
(113, '15:20:00', '13:00:00', 2, 1, 11, 12, 1, 'JUEVES', 'Segundo'),
(114, '12:00:00', '09:40:00', 2, 1, 6, 11, 1, 'VIERNES', 'Primero'),
(115, '12:00:00', '09:40:00', 2, 1, 1, 5, 1, 'VIERNES', 'Segundo'),
(116, '09:20:00', '07:00:00', 2, 1, 14, 7, 1, 'VIERNES', 'Tercero'),
(117, '08:10:00', '05:00:00', 1, 1, 1, 1, 1, 'Lunes,', 'Primero'),
(118, '12:00:00', '09:40:00', 1, 1, 1, 1, 1, 'Lunes,', 'Primero'),
(119, '16:50:00', '13:00:00', 1, 1, 1, 1, 1, 'Lunes,', 'Primero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `individuo`
--

CREATE TABLE `individuo` (
  `idindividuo` bigint NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `edad` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `individuo`
--

INSERT INTO `individuo` (`idindividuo`, `apellido`, `correo`, `edad`, `nombre`, `telefono`) VALUES
(1, 'Tqm mucho', 'orneputita@gmail.com', 17, 'Orne', '981882123'),
(3, 'xd', 'evilaje18@gmail.com', 17, 'anibal', '123456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lector_huella`
--

CREATE TABLE `lector_huella` (
  `id_lector` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `lector_huella`
--

INSERT INTO `lector_huella` (`id_lector`) VALUES
(1),
(2),
(3),
(4),
(5),
(6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login_attempt`
--

CREATE TABLE `login_attempt` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  `successful` bit(1) NOT NULL,
  `timestamp` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `login_attempt`
--

INSERT INTO `login_attempt` (`id`, `email`, `ip_address`, `successful`, `timestamp`) VALUES
(1, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-07 23:36:16.823000'),
(2, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-07 23:41:30.826000'),
(3, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-07 23:46:41.994000'),
(4, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-07 23:48:24.894000'),
(5, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 00:06:25.524000'),
(6, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 00:08:37.911000'),
(7, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 00:09:14.806000'),
(8, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 00:09:52.024000'),
(9, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 00:10:56.869000'),
(10, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 13:37:12.531000'),
(11, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 13:40:59.286000'),
(12, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 13:47:29.833000'),
(13, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 13:53:58.032000'),
(14, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 13:56:10.872000'),
(15, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 13:56:33.906000'),
(16, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 14:57:29.214000'),
(17, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 17:53:14.117000'),
(18, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 18:08:10.038000'),
(19, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 18:11:36.185000'),
(20, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 18:18:30.686000'),
(21, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 18:24:38.050000'),
(22, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 18:25:23.669000'),
(23, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 18:33:44.621000'),
(24, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 18:41:36.024000'),
(25, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 19:08:53.478000'),
(26, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-08 19:46:56.229000'),
(27, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 01:01:19.285000'),
(28, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 01:41:41.719000'),
(29, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 01:54:42.644000'),
(30, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 03:03:49.250000'),
(31, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 09:45:16.554000'),
(32, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 10:04:55.042000'),
(33, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 11:30:25.452000'),
(34, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 11:55:55.934000'),
(35, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 11:57:20.524000'),
(36, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 11:59:39.807000'),
(37, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 12:02:34.370000'),
(38, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 17:07:59.378000'),
(39, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 19:24:31.434000'),
(40, 'stormcursedd', '0:0:0:0:0:0:0:1', b'0', '2024-09-09 19:24:42.630000'),
(41, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-09-09 19:24:51.451000'),
(42, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-10-07 11:08:43.337000'),
(43, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-10-08 16:25:42.316000'),
(44, 'a@gmail.com', '0:0:0:0:0:0:0:1', b'1', '2024-10-08 16:29:39.830000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `id_materia` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`id_materia`, `nombre`) VALUES
(1, 'Literatura'),
(2, 'Matematica Comun'),
(3, 'Matematica Aplicada'),
(4, 'Algoritmica'),
(5, 'Laboratorio Hardware'),
(6, 'Guarani'),
(7, 'Historia y Geografia'),
(8, 'Etica'),
(9, 'Educacion Vial'),
(10, 'Laboratorio Software'),
(11, 'Ingles'),
(12, 'Antropologia'),
(13, 'Orientacion'),
(14, 'Ciencias'),
(15, 'Economia y Gestion'),
(16, 'Educacion Fisica'),
(17, 'Administracion Financiera');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `id_profesor` int NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `cdi` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`id_profesor`, `apellido`, `cdi`, `nombre`, `correo`) VALUES
(1, 'Lopez', 123, 'Graciela', 'ani@gmail.com'),
(2, 'Delgado', 1234, 'Cristian', NULL),
(3, 'Ascurra', 12345, 'Elizabeth', NULL),
(4, 'Gonzalez', 123456, 'Federico', NULL),
(5, 'Alvarenga', 1233, 'Susana', NULL),
(6, 'Nunez', 1232, 'Zully', NULL),
(7, 'Rivas', 1231, 'Laura', NULL),
(8, 'Montania', 12323, 'Mirian', NULL),
(9, 'Cardozo', 12342, 'Irma', NULL),
(10, 'Ovelar', 12323, 'Gerardo', NULL),
(11, 'Estigarribia', 13412, 'Ruth', NULL),
(12, 'Roman', 15241, 'Ruth', NULL),
(13, 'Lenguaza', 24132, 'Daniel', NULL),
(14, 'Alonso', 3412131, 'Blanca', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `id_sala` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_lector` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`id_sala`, `nombre`, `id_lector`) VALUES
(1, 'Sala 1', 1),
(2, 'Sala 2', 2),
(3, 'Sala 3', 3),
(4, 'Sala 4', 4),
(5, 'Sala 5', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salas_por_enfasis`
--

CREATE TABLE `salas_por_enfasis` (
  `salas_id_sala` int NOT NULL,
  `id_enfasis` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `salas_por_enfasis`
--

INSERT INTO `salas_por_enfasis` (`salas_id_sala`, `id_enfasis`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `address`, `created_at`, `email`, `first_name`, `last_name`, `password`, `phone`, `role`) VALUES
(1, '', '2024-08-28 12:26:25.599000', 'a@gmail.com', 'evilaje', 'stormblessed', '$2a$10$q9GPmttaVrPHHsb2MG5DoeDCOUsAP8XQcZ9uNi7xLu0do8fc/bOiy', '988192991', 'ADMIN'),
(2, '1233', '2024-08-28 22:08:39.892000', 'ani@gmail.com', 'suprano', 'gaspi', '$2a$10$QdZEYXdhvqJm2euyxRNAqeXm/48O1yWxMCPvJB3oP7QRDd.tpJ0kK', '123', 'PROFESOR'),
(3, '', '2024-08-31 17:12:07.617000', 'a2@gmail.com', 'suprano', 'suculini', '$2a$10$FYalqD.RQ7LVWvEdCoxOTOyccsfLJlYJ7CEM5y/e2/P2fWqVuHdtu', '', 'QUERY'),
(5, '123', '2024-09-08 18:19:11.181000', 'suprano@gmail.com', 'suprano', '123', '$2a$10$.uJqm63RLf7b0qJU3I2cguwBRFub6VGBPX6CxI8h86CYZQZGvCgRe', '123', 'QUERY'),
(6, '123', '2024-09-08 18:25:16.112000', 'a3@a.com', 'evilaje', '123', '$2a$10$yI3jmlLT6BenkEMSS2ZdAeLDoYD5DvJVaBq35uA5c/ayG7BDw/6XG', '123', 'QUERY');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id_alumno`),
  ADD KEY `FK9wgl2fil5qk52q6x0jh8avp92` (`id_especialidad`);

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`id_asistencia`),
  ADD KEY `FKpepavq598qngepgf7cqrfh3w8` (`id_horario`);

--
-- Indices de la tabla `detalle_asistencia`
--
ALTER TABLE `detalle_asistencia`
  ADD PRIMARY KEY (`id_alumno`,`id_asistencia`),
  ADD KEY `FKny7genk0v8c35grwwo0pprq1i` (`id_asistencia`);

--
-- Indices de la tabla `enfasis`
--
ALTER TABLE `enfasis`
  ADD PRIMARY KEY (`id_enfasis`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id_especialidad`);

--
-- Indices de la tabla `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`id_horario`),
  ADD KEY `FKpgbvhn8steq4ch2asmgan1kol` (`id_especialidad`),
  ADD KEY `FK7xb1qp94vc1pbk3vovwo39do6` (`id_materia`),
  ADD KEY `FK1alm3vwaj7x1qx9avlgdeaqgv` (`id_profesor`),
  ADD KEY `FK4cmeswbedd8t89nat4owp4a72` (`id_sala`);

--
-- Indices de la tabla `individuo`
--
ALTER TABLE `individuo`
  ADD PRIMARY KEY (`idindividuo`);

--
-- Indices de la tabla `lector_huella`
--
ALTER TABLE `lector_huella`
  ADD PRIMARY KEY (`id_lector`);

--
-- Indices de la tabla `login_attempt`
--
ALTER TABLE `login_attempt`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`id_materia`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`id_profesor`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`id_sala`),
  ADD KEY `FKhnb1l9ieyfd0g798vu8yslrur` (`id_lector`);

--
-- Indices de la tabla `salas_por_enfasis`
--
ALTER TABLE `salas_por_enfasis`
  ADD PRIMARY KEY (`salas_id_sala`,`id_enfasis`),
  ADD KEY `FKh0c9sjovh9jtox0a226j2jlkr` (`id_enfasis`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id_alumno` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=227;

--
-- AUTO_INCREMENT de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `id_asistencia` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT de la tabla `enfasis`
--
ALTER TABLE `enfasis`
  MODIFY `id_enfasis` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `id_especialidad` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `horario`
--
ALTER TABLE `horario`
  MODIFY `id_horario` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=120;

--
-- AUTO_INCREMENT de la tabla `individuo`
--
ALTER TABLE `individuo`
  MODIFY `idindividuo` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `lector_huella`
--
ALTER TABLE `lector_huella`
  MODIFY `id_lector` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `login_attempt`
--
ALTER TABLE `login_attempt`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `id_materia` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `profesor`
--
ALTER TABLE `profesor`
  MODIFY `id_profesor` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `id_sala` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD CONSTRAINT `FK9wgl2fil5qk52q6x0jh8avp92` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidad` (`id_especialidad`);

--
-- Filtros para la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `FKpepavq598qngepgf7cqrfh3w8` FOREIGN KEY (`id_horario`) REFERENCES `horario` (`id_horario`);

--
-- Filtros para la tabla `detalle_asistencia`
--
ALTER TABLE `detalle_asistencia`
  ADD CONSTRAINT `FKmf4o8pb4nr9f2843g139rnbhl` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`),
  ADD CONSTRAINT `FKny7genk0v8c35grwwo0pprq1i` FOREIGN KEY (`id_asistencia`) REFERENCES `asistencia` (`id_asistencia`);

--
-- Filtros para la tabla `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `FK1alm3vwaj7x1qx9avlgdeaqgv` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id_profesor`),
  ADD CONSTRAINT `FK4cmeswbedd8t89nat4owp4a72` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id_sala`),
  ADD CONSTRAINT `FK7xb1qp94vc1pbk3vovwo39do6` FOREIGN KEY (`id_materia`) REFERENCES `materia` (`id_materia`),
  ADD CONSTRAINT `FKpgbvhn8steq4ch2asmgan1kol` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidad` (`id_especialidad`);

--
-- Filtros para la tabla `sala`
--
ALTER TABLE `sala`
  ADD CONSTRAINT `FKhnb1l9ieyfd0g798vu8yslrur` FOREIGN KEY (`id_lector`) REFERENCES `lector_huella` (`id_lector`);

--
-- Filtros para la tabla `salas_por_enfasis`
--
ALTER TABLE `salas_por_enfasis`
  ADD CONSTRAINT `FK6lbwktb1dmt67jfrip9wy1kgl` FOREIGN KEY (`salas_id_sala`) REFERENCES `sala` (`id_sala`),
  ADD CONSTRAINT `FKh0c9sjovh9jtox0a226j2jlkr` FOREIGN KEY (`id_enfasis`) REFERENCES `enfasis` (`id_enfasis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
