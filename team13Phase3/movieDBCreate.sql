-- phpMyAdmin SQL Dump
-- version 4.5.3.1
-- http://www.phpmyadmin.net
--
-- Host: vergil.u.washington.edu:1138
-- Generation Time: Mar 12, 2016 at 12:16 PM
-- Server version: 5.5.18
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movies`
--
CREATE DATABASE IF NOT EXISTS `movies` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `movies`;

-- --------------------------------------------------------

--
-- Table structure for table `actor`
--

CREATE TABLE `actor` (
  `actor_ID` varchar(9) NOT NULL,
  `fName` varchar(45) NOT NULL,
  `lName` varchar(45) NOT NULL,
  `mName` varchar(45) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `actor`
--

INSERT INTO `actor` (`actor_ID`, `fName`, `lName`, `mName`) VALUES
('A01', 'Karen', 'Allen', NULL),
('A02', 'Tim', 'Allen', NULL),
('A03', 'David', 'Arquette', NULL),
('A04', 'Michael', 'Bates', NULL),
('A05', 'Kathy', 'Bates', NULL),
('A06', 'Emily', 'Blunt', NULL),
('A07', 'Barry', 'Bostwick', NULL),
('A08', 'Wilfred', 'Brimley', NULL),
('A09', 'Albert', 'Brooks', NULL),
('A10', 'Neve', 'Campbell', NULL),
('A11', 'Helena', 'Carter', 'Bonham'),
('A12', 'Michael', 'Cera', NULL),
('A13', 'Jessica', 'Chastain', NULL),
('A14', 'Courtney', 'Cox', NULL),
('A15', 'Kieran', 'Culkin', NULL),
('A16', 'Tim', 'Curry', NULL),
('A17', 'Jamie', 'Curtis', 'Lee'),
('A18', 'Keith', 'David', NULL),
('A19', 'Ellen', 'DeGeneres', NULL),
('A20', 'Leonardo', 'DiCaprio', NULL),
('A21', 'Robert', 'Downey Jr.', NULL),
('A22', 'Shelley', 'Duvall', NULL),
('A23', 'Ralph', 'Fiennes', NULL),
('A24', 'Colin', 'Firth', NULL),
('A25', 'Carrie', 'Fisher', NULL),
('A26', 'Harrison', 'Ford', NULL),
('A27', 'Meg', 'Foster', NULL),
('A28', 'Paul', 'Freeman', NULL),
('A29', 'Martin', 'Freeman', NULL),
('A30', 'Nick', 'Frost', NULL),
('A31', 'Jennifer', 'Garner', NULL),
('A32', 'Joseph', 'Gordon-Levitt', NULL),
('A33', 'Alexander', 'Gould', NULL),
('A34', 'Carla', 'Gugino', NULL),
('A35', 'Jake', 'Gyllenhaal', NULL),
('A36', 'Jackie', 'Haley', 'Earle'),
('A37', 'Mark', 'Hamill', NULL),
('A38', 'Tom', 'Hardy', NULL),
('A39', 'Anne', 'Hathaway', NULL),
('A40', 'Rutger', 'Hauer', NULL),
('A41', 'Tippi', 'Hedren', NULL),
('A42', 'Tyler', 'Hoechlin', NULL),
('A43', 'Nicholas', 'Hoult', NULL),
('A44', 'Holly', 'Hunter', NULL),
('A45', 'John', 'Hurt', NULL),
('A46', 'Samuel', 'Jackson', 'L'),
('A47', 'Adrienne', 'King', NULL),
('A48', 'Ben', 'Kingsley', NULL),
('A49', 'Janet', 'Leigh', NULL),
('A50', 'Danny', 'Lloyd', NULL),
('A51', 'Patrick', 'Magee', NULL),
('A52', 'Rob', 'Maxey', NULL),
('A53', 'Rachel', 'McAdams', NULL),
('A54', 'Matthew', 'McConaughey', NULL),
('A55', 'Malcolm', 'McDowell', NULL),
('A56', 'Dominique', 'McElligott', NULL),
('A57', 'Vera', 'Miles', NULL),
('A58', 'Toney', 'Moran', NULL),
('A59', 'Liam', 'Neeson', NULL),
('A60', 'Craig', 'Nelson', 'T'),
('A61', 'Jack', 'Nicholson', NULL),
('A62', 'Edward', 'Norton', NULL),
('A63', 'Ellen', 'Page', NULL),
('A64', 'Betsy', 'Palmer', NULL),
('A65', 'Simon', 'Pegg', NULL),
('A66', 'Anthony', 'Perkins', NULL),
('A67', 'Roddy', 'Piper', NULL),
('A68', 'Brad', 'Pitt', NULL),
('A69', 'Donald', 'Pleasence', NULL),
('A70', 'Suzanne', 'Pleshette', NULL),
('A71', 'Will', 'Poulter', NULL),
('A72', 'Don', 'Rickles', NULL),
('A73', 'Sam', 'Rockwell', NULL),
('A74', 'Mark', 'Ruffalo', NULL),
('A75', 'Geoffrey', 'Rush', NULL),
('A76', 'Kurt', 'Russell', NULL),
('A77', 'Tom', 'Skerrit', NULL),
('A78', 'Kevin', 'Spacey', NULL),
('A79', 'Susan', 'Surandon', NULL),
('A80', 'Rod', 'Taylor', NULL),
('A81', 'Jeannine', 'Taylor', NULL),
('A82', 'Charlize', 'Theron', NULL),
('A83', 'Sigourney', 'Weaver', NULL),
('A84', 'Bruce', 'Willis', NULL),
('A85', 'Patrick', 'Wilson', NULL),
('A86', 'Owen', 'Wilson', NULL),
('A87', 'Mary', 'Winstead', 'Elizabeth'),
('A88', 'Sean', 'Young', NULL),
('A89', 'Tom', 'Hanks', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `actor_movie`
--

CREATE TABLE `actor_movie` (
  `actor_ID` varchar(9) NOT NULL,
  `movie_ID` varchar(9) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `actor_movie`
--

INSERT INTO `actor_movie` (`actor_ID`, `movie_ID`) VALUES
('A01', 'M07'),
('A02', 'M17'),
('A03', 'M04'),
('A04', 'M08'),
('A05', 'M33'),
('A06', 'M28'),
('A07', 'M19'),
('A08', 'M31'),
('A09', 'M18'),
('A10', 'M04'),
('A11', 'M10'),
('A11', 'M15'),
('A12', 'M24'),
('A12', 'M25'),
('A13', 'M02'),
('A14', 'M04'),
('A15', 'M25'),
('A16', 'M19'),
('A17', 'M30'),
('A18', 'M31'),
('A18', 'M32'),
('A19', 'M18'),
('A20', 'M22'),
('A20', 'M23'),
('A21', 'M12'),
('A22', 'M09'),
('A23', 'M13'),
('A24', 'M15'),
('A25', 'M03'),
('A26', 'M03'),
('A26', 'M06'),
('A26', 'M07'),
('A27', 'M32'),
('A28', 'M07'),
('A29', 'M26'),
('A30', 'M26'),
('A31', 'M24'),
('A32', 'M23'),
('A32', 'M28'),
('A33', 'M18'),
('A34', 'M27'),
('A35', 'M12'),
('A36', 'M27'),
('A37', 'M03'),
('A38', 'M01'),
('A38', 'M22'),
('A39', 'M02'),
('A40', 'M06'),
('A41', 'M11'),
('A42', 'M21'),
('A43', 'M01'),
('A44', 'M16'),
('A45', 'M20'),
('A46', 'M16'),
('A47', 'M14'),
('A48', 'M13'),
('A49', 'M05'),
('A50', 'M09'),
('A51', 'M08'),
('A52', 'M21'),
('A53', 'M33'),
('A54', 'M02'),
('A55', 'M08'),
('A56', 'M29'),
('A57', 'M05'),
('A58', 'M30'),
('A59', 'M13'),
('A60', 'M16'),
('A61', 'M09'),
('A62', 'M10'),
('A63', 'M23'),
('A63', 'M24'),
('A64', 'M14'),
('A65', 'M26'),
('A66', 'M05'),
('A67', 'M32'),
('A68', 'M10'),
('A69', 'M30'),
('A70', 'M11'),
('A71', 'M22'),
('A72', 'M17'),
('A73', 'M29'),
('A74', 'M12'),
('A75', 'M15'),
('A76', 'M31'),
('A77', 'M20'),
('A78', 'M29'),
('A79', 'M19'),
('A80', 'M11'),
('A81', 'M14'),
('A82', 'M01'),
('A83', 'M20'),
('A84', 'M28'),
('A85', 'M27'),
('A86', 'M33'),
('A87', 'M25'),
('A88', 'M06'),
('A89', 'M17'),
('A89', 'M21');

-- --------------------------------------------------------

--
-- Table structure for table `director`
--

CREATE TABLE `director` (
  `director_ID` varchar(9) NOT NULL,
  `fName` varchar(45) NOT NULL,
  `lName` varchar(45) NOT NULL,
  `mName` varchar(45) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `director`
--

INSERT INTO `director` (`director_ID`, `fName`, `lName`, `mName`) VALUES
('D01', 'Alejandro', 'Inarritu', 'Gonzales'),
('D02', 'Alfred', 'Hitchcock', NULL),
('D03', 'Andrew', 'Stanton', NULL),
('D04', 'Brad', 'Bird', NULL),
('D05', 'Christopher', 'Nolan', NULL),
('D06', 'David', 'Fincher', NULL),
('D07', 'Duncan', 'Jones', NULL),
('D08', 'Edgar', 'Wright', NULL),
('D09', 'George', 'Lucas', NULL),
('D10', 'George', 'Miller', NULL),
('D11', 'Jason', 'Reitman', NULL),
('D12', 'Jim', 'Sharman', NULL),
('D13', 'John', 'Carpenter', NULL),
('D14', 'John', 'Lasseter', NULL),
('D15', 'Rian', 'Johnson', NULL),
('D16', 'Ridley', 'Scott', NULL),
('D17', 'Sam', 'Mendes', NULL),
('D18', 'Sean', 'Cunningham', NULL),
('D19', 'Stanley', 'Kubrick', NULL),
('D20', 'Steven', 'Spielberg', NULL),
('D21', 'Tom', 'Hooper', NULL),
('D22', 'Wes', 'Craven', NULL),
('D23', 'Woody', 'Allen', NULL),
('D24', 'Zack', 'Snyder', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `genre_ID` varchar(9) NOT NULL,
  `type` varchar(45) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`genre_ID`, `type`) VALUES
('G01', 'Action'),
('G02', 'Comedy'),
('G03', 'Drama'),
('G04', 'Family'),
('G05', 'Horror'),
('G06', 'Sci-Fi');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `movie_ID` varchar(9) NOT NULL,
  `title` varchar(45) NOT NULL,
  `run_time` int(11) NOT NULL,
  `release_date` int(11) NOT NULL,
  `box_office` int(11) NOT NULL,
  `poster` blob,
  `director_ID` varchar(9) NOT NULL,
  `mpaa_ID` varchar(9) NOT NULL,
  `genre_ID` varchar(9) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`movie_ID`, `title`, `run_time`, `release_date`, `box_office`, `poster`, `director_ID`, `mpaa_ID`, `genre_ID`) VALUES
('M01', 'Mad Max: Fury Road', 120, 2015, 187991439, NULL, 'D10', 'MP04', 'G01'),
('M02', 'Interstellar', 169, 2014, 187991439, NULL, 'D05', 'MP03', 'G06'),
('M03', 'Star Wars', 121, 1977, 460935665, NULL, 'D09', 'MP02', 'G06'),
('M04', 'Scream', 111, 1996, 103001286, NULL, 'D22', 'MP04', 'G05'),
('M05', 'Psycho', 109, 1960, 32000000, NULL, 'D02', 'MP04', 'G05'),
('M06', 'Blade Runner', 117, 1982, 27580111, NULL, 'D16', 'MP04', 'G05'),
('M07', 'Raiders of the Lost Ark', 115, 1981, 228671608, NULL, 'D20', 'MP02', 'G01'),
('M08', 'A Clockwork Orange', 115, 1971, 26589355, NULL, 'D19', 'MP04', 'G06'),
('M09', 'The Shining', 146, 1980, 44017374, NULL, 'D19', 'MP04', 'G05'),
('M10', 'Fight Club', 139, 1999, 37030102, NULL, 'D06', 'MP04', 'G03'),
('M11', 'The Birds', 139, 1963, 11403529, NULL, 'D02', 'MP03', 'G05'),
('M12', 'Zodiac', 157, 2007, 33080084, NULL, '06', 'MP04', 'G03'),
('M13', 'Schindlers List', 195, 1993, 96045248, NULL, 'D20', 'MP04', 'G03'),
('M14', 'Friday the 13th', 95, 1980, 39754601, NULL, 'D18', 'MP04', 'G05'),
('M15', 'The Kings Speech', 118, 2010, 138795342, NULL, 'D21', 'MP04', 'G03'),
('M16', 'The Incredibles', 115, 2004, 261441092, NULL, 'D04', 'MP02', 'G04'),
('M17', 'Toy Story', 81, 1995, 191796233, NULL, 'D14', 'MP01', 'G04'),
('M18', 'Finding Nemo', 100, 2003, 339714978, NULL, 'D03', 'MP01', 'G04'),
('M19', 'The Rocky Horror Picture Show', 100, 1975, 112892319, NULL, 'D12', 'MP04', 'G02'),
('M20', 'Alien', 117, 1979, 78944891, NULL, 'D16', 'G04', 'G06'),
('M21', 'Road to Perdition', 117, 2002, 104454762, NULL, 'D17', 'MP04', 'G03'),
('M22', 'The Revenant', 136, 2015, 141677381, NULL, 'D01', 'MP04', 'G03'),
('M23', 'Inception', 148, 2010, 292576195, NULL, 'D05', 'MP03', 'G06'),
('M24', 'Juno', 96, 2007, 143495265, NULL, 'D11', 'MP03', 'G02'),
('M25', 'Scott Pilgrim vs. the World', 112, 2010, 31524275, NULL, 'D08', 'MP03', 'G01'),
('M26', 'Hot Fuzz', 121, 2007, 23637265, NULL, 'D08', 'MP04', 'G01'),
('M27', 'Watchmen', 162, 2009, 107509799, NULL, 'D24', 'MP04', 'G01'),
('M28', 'Looper', 119, 2012, 66486205, NULL, 'D15', 'MP04', 'G06'),
('M29', 'Moon', 97, 2009, 5010163, NULL, 'D07', 'MP04', 'G06'),
('M30', 'Halloween', 91, 1978, 47000000, NULL, 'D13', 'MP04', 'G05'),
('M31', 'The Thing', 109, 1982, 19629760, NULL, 'D13', 'MP04', 'G05'),
('M32', 'They Live', 93, 1988, 13008928, NULL, 'D13', 'MP04', 'G06'),
('M33', 'Midnight in Paris', 94, 2011, 56817045, NULL, 'D23', 'MP03', 'G02');

-- --------------------------------------------------------

--
-- Table structure for table `mpaa`
--

CREATE TABLE `mpaa` (
  `mpaa_ID` varchar(9) NOT NULL,
  `rating` enum('G','PG','PG-13','R','NC-17','NR') NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mpaa`
--

INSERT INTO `mpaa` (`mpaa_ID`, `rating`) VALUES
('MP01', 'G'),
('MP02', 'PG'),
('MP03', 'PG-13'),
('MP04', 'R'),
('MP05', 'NC-17'),
('MP06', 'NR');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_ID` varchar(9) NOT NULL,
  `fName` varchar(45) DEFAULT NULL,
  `lName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_ID`, `fName`, `lName`, `email`) VALUES
('U01', 'Michael', 'Ford', 'fordm13@uw.edu'),
('U02', 'Andy', 'Bleich', 'andybleich@gmail.com'),
('U03', 'Joel', 'Larson', 'jilarson@uw.edu');

-- --------------------------------------------------------

--
-- Table structure for table `user_movie`
--

CREATE TABLE `user_movie` (
  `user_ID` varchar(9) NOT NULL,
  `movie_ID` varchar(9) NOT NULL,
  `user_rating` int(1) DEFAULT NULL,
  `watch_list` tinyint(1) NOT NULL DEFAULT '0',
  `favorite_list` tinyint(1) NOT NULL DEFAULT '0',
  `watched` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_movie`
--

INSERT INTO `user_movie` (`user_ID`, `movie_ID`, `user_rating`, `watch_list`, `favorite_list`, `watched`) VALUES
('U01', 'M08', 5, 1, 0, 1),
('U01', 'M01', 5, 1, 1, 1),
('U01', 'M05', NULL, 1, 1, 0),
('U02', 'M16', NULL, 1, 1, 0),
('U02', 'M01', 5, 1, 1, 1),
('U03', 'M03', 4, 1, 1, 0),
('U02', 'M25', 5, 1, 0, 1),
('U02', 'M22', NULL, 1, 0, 0),
('U03', 'M01', 4, 1, 0, 0),
('U03', 'M29', NULL, 1, 0, 0),
('U01', 'M30', 4, 1, 1, 0),
('U01', 'M09', 4, 1, 1, 0),
('U01', 'M25', 4, 1, 1, 0),
('U03', 'M31', 4, 1, 0, 0),
('U03', 'M26', 4, 1, 0, 0),
('U01', 'M07', 4, 1, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `actor`
--
ALTER TABLE `actor`
  ADD PRIMARY KEY (`actor_ID`);

--
-- Indexes for table `actor_movie`
--
ALTER TABLE `actor_movie`
  ADD PRIMARY KEY (`actor_ID`,`movie_ID`),
  ADD KEY `IX_movie_ID` (`movie_ID`),
  ADD KEY `IX_actor_ID` (`actor_ID`);

--
-- Indexes for table `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`director_ID`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`genre_ID`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movie_ID`),
  ADD KEY `IX_mpaa_ID` (`mpaa_ID`),
  ADD KEY `IX_genre_ID` (`genre_ID`),
  ADD KEY `IX_director_ID` (`director_ID`);

--
-- Indexes for table `mpaa`
--
ALTER TABLE `mpaa`
  ADD PRIMARY KEY (`mpaa_ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_ID`);

--
-- Indexes for table `user_movie`
--
ALTER TABLE `user_movie`
  ADD PRIMARY KEY (`user_ID`,`movie_ID`),
  ADD KEY `IX_movie_ID` (`movie_ID`),
  ADD KEY `IX_user_ID` (`user_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
