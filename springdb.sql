-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-05-2024 a las 04:05:30
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `springdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `individuo`
--

CREATE TABLE `individuo` (
  `id_individuo` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `edad` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `individuo`
--

INSERT INTO `individuo` (`id_individuo`, `apellido`, `correo`, `edad`, `nombre`, `telefono`) VALUES
(1, 'Pérez', 'perez1@gmail.com', 25, 'Juan', '987654321'),
(2, 'González', 'gonzalez2@gmail.com', 30, 'María', '987654322'),
(3, 'Rodríguez', 'rodriguez3@gmail.com', 28, 'Carlos', '987654323'),
(4, 'Fernández', 'fernandez4@gmail.com', 35, 'Laura', '987654324'),
(5, 'López', 'lopez5@gmail.com', 40, 'Ana', '987654325'),
(6, 'Martínez', 'martinez6@gmail.com', 27, 'David', '987654326'),
(7, 'Sánchez', 'sanchez7@gmail.com', 32, 'Sofía', '987654327'),
(8, 'Gómez', 'gomez8@gmail.com', 29, 'Roberto', '987654328'),
(9, 'Díaz', 'diaz9@gmail.com', 33, 'Elena', '987654329'),
(10, 'Gutiérrez', 'gutierrez10@gmail.com', 31, 'Pablo', '987654330'),
(11, 'Pérez', 'perez11@gmail.com', 36, 'Carmen', '987654331'),
(12, 'González', 'gonzalez12@gmail.com', 26, 'Miguel', '987654332'),
(13, 'Rodríguez', 'rodriguez13@gmail.com', 38, 'Luisa', '987654333'),
(14, 'Fernández', 'fernandez14@gmail.com', 37, 'Javier', '987654334'),
(15, 'López', 'lopez15@gmail.com', 41, 'Paula', '987654335'),
(16, 'Martínez', 'martinez16@gmail.com', 39, 'Santiago', '987654336'),
(17, 'Sánchez', 'sanchez17@gmail.com', 42, 'Isabel', '987654337'),
(18, 'Gómez', 'gomez18@gmail.com', 34, 'Eduardo', '987654338'),
(19, 'Díaz', 'diaz19@gmail.com', 43, 'Victoria', '987654339'),
(20, 'Gutiérrez', 'gutierrez20@gmail.com', 45, 'Adrián', '987654340'),
(21, 'Pérez', 'perez21@gmail.com', 44, 'Lucía', '987654341'),
(22, 'González', 'gonzalez22@gmail.com', 46, 'Raúl', '987654342'),
(23, 'Rodríguez', 'rodriguez23@gmail.com', 47, 'Cristina', '987654343'),
(24, 'Fernández', 'fernandez24@gmail.com', 48, 'Marta', '987654344'),
(25, 'López', 'lopez25@gmail.com', 50, 'Diego', '987654345'),
(26, 'Martínez', 'martinez26@gmail.com', 49, 'Natalia', '987654346'),
(27, 'Sánchez', 'sanchez27@gmail.com', 51, 'Alejandro', '987654347'),
(28, 'Gómez', 'gomez28@gmail.com', 53, 'Marina', '987654348'),
(29, 'Díaz', 'diaz29@gmail.com', 52, 'Julio', '987654349'),
(30, 'Gutiérrez', 'gutierrez30@gmail.com', 55, 'Carolina', '987654350'),
(31, 'Pérez', 'perez31@gmail.com', 54, 'Rosa', '987654351'),
(32, 'González', 'gonzalez32@gmail.com', 57, 'Jorge', '987654352'),
(33, 'Rodríguez', 'rodriguez33@gmail.com', 56, 'Ángela', '987654353'),
(34, 'Fernández', 'fernandez34@gmail.com', 58, 'Gabriel', '987654354'),
(35, 'López', 'lopez35@gmail.com', 59, 'Patricia', '987654355'),
(36, 'Martínez', 'martinez36@gmail.com', 60, 'Daniel', '987654356'),
(37, 'Sánchez', 'sanchez37@gmail.com', 62, 'Silvia', '987654357'),
(38, 'riego', 'onre233@gmail.com', 17, 'ornella', '99999999');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `individuo`
--
ALTER TABLE `individuo`
  ADD PRIMARY KEY (`id_individuo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `individuo`
--
ALTER TABLE `individuo`
  MODIFY `id_individuo` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
