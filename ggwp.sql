-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 04, 2023 at 06:26 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ggwp`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `COMMENT_ID` int(11) NOT NULL,
  `FIELD` varchar(50) NOT NULL,
  `CONTENT` varchar(1000) NOT NULL,
  `LIKES_COUNT` int(11) NOT NULL,
  `SUB_COMMENT_COUNT` int(11) NOT NULL,
  `COMMENT_DATE` date NOT NULL DEFAULT current_timestamp(),
  `USER_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`COMMENT_ID`, `FIELD`, `CONTENT`, `LIKES_COUNT`, `SUB_COMMENT_COUNT`, `COMMENT_DATE`, `USER_ID`) VALUES
(1, '/leagueoflegends', 'Looking for someone who can play mid well. Hurry up!!!!', 512, 2, '2023-07-29', 36),
(2, '/valorant', 'Hi! Welcome to GGWP!', 0, 3, '2023-07-30', 37),
(3, '/diablo', 'hello! im major', 0, 3, '2023-08-01', 36),
(4, '/valorant', '^^', 0, 4, '2023-08-02', 38),
(5, '/genshin:impact', 'i want to make friends here', 0, 0, '2023-08-03', 40);

-- --------------------------------------------------------

--
-- Table structure for table `FORUM`
--

CREATE TABLE `FORUM` (
  `FORUM_ID` int(11) NOT NULL,
  `IMAGE_URL` varchar(255) NOT NULL,
  `FORUM_TITLE` varchar(255) NOT NULL,
  `GAME_TYPE` varchar(255) NOT NULL,
  `DESCRIPTION` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `FORUM`
--

INSERT INTO `FORUM` (`FORUM_ID`, `IMAGE_URL`, `FORUM_TITLE`, `GAME_TYPE`, `DESCRIPTION`) VALUES
(1, 'https://notagamer.net/wp-content/uploads/2023/01/Saint-League-of-Legends.jpeg', 'League of Legends', 'MOBA, PVP', 'League of Legends (LoL), commonly referred to as League, is a 2009 multiplayer online battle arena video game developed and published by Riot Games. Inspired by Defense of Ancients, a custom map for Warcraft III, Riot\'s founders sought to develop a stand-alone game in the same genre. Since its release in October 2009, League has been free-to-play and is monetized through purchasable character customization. The game is available for Microsoft Windows and macOS.'),
(2, 'https://upload.wikimedia.org/wikipedia/commons/0/0f/Celeste_box_art_full.png', 'Celeste', '2D', 'Embark on an epic adventure in Celeste, a challenging platformer that follows the journey of a young girl named Madeline as she ascends a treacherous mountain. Master precision platforming, face inner demons, and discover the power of perseverance in this heartwarming and visually stunning indie gem.'),
(3, 'https://assets-prd.ignimgs.com/2023/06/09/fortnitewilds-1686353306240.jpg', 'Fortnite', 'Battle Royale, PVP', 'Step into the thrilling world of Fortnite, where you\'ll battle it out with friends and foes in a vibrant, ever-changing environment. Build, fight, and strategize your way to victory as you uncover hidden treasures and unlock your true potential in this action-packed, multiplayer gaming experience.'),
(4, 'https://www.riotgames.com/darkroom/1440/d0807e131a84f2e42c7a303bda672789:3d02afa7e0bfb75f645d97467765b24c/valorant-offwhitelaunch-keyart.jpg', 'Valorant', 'PVP, FPS', 'Enter the high-stakes world of Valorant, a tactical first-person shooter where precise gunplay and strategic teamwork are essential. Select from a diverse roster of agents, each with unique abilities, and engage in intense 5v5 matches. Master your skills, outwit opponents, and lead your team to victory in this adrenaline-pumping competitive experience.'),
(5, 'https://dotesports.com/wp-content/uploads/2021/02/23172633/csgo.jpg', 'CS:GO', 'FPS, PVP', 'Immerse yourself in the adrenaline-pumping world of CS:GO Game Form! Choose your elite counter-terrorist or terrorist team, strategize, and master the art of precise shooting to complete thrilling objectives. Engage in intense, fast-paced battles across diverse maps and prove your skill in this competitive first-person shooter experience.'),
(6, 'https://m.media-amazon.com/images/I/91yiVwuQ2cL._AC_UF1000,1000_QL80_.jpg', 'The Last of Us', 'Fiction', 'The Last of Us: Survivors\' Quest\" is an intense post-apocalyptic adventure game where players navigate a crumbling world plagued by a deadly fungal infection. As a seasoned survivor, form alliances, make tough choices, and battle both infected and desperate humans to secure a hopeful future in this emotionally gripping journey.'),
(7, 'https://gamingtrend.com/wp-content/uploads/2022/01/five-nights-at-freddys-security-breach-01-Medium.png', 'Five Nights Freddy’s Security Breach', 'Horror, Survial', 'Welcome to Five Nights at Freddy\'s Security Breach! Survive the night as a security guard in the new Mega Pizza Plex. Watch out for animatronic horrors roaming the facility. Use cameras, doors, and stealth to stay alive. Beware, the fun is just beginning!'),
(8, 'https://cdn1.epicgames.com/offer/77f2b98e2cef40c8a7437518bf420e47/EGS_Cyberpunk2077_CDPROJEKTRED_S1_03_2560x1440-359e77d3cd0a40aebf3bbc130d14c5c7', 'Cyberpunk', 'Open-world RPG', 'Immerse yourself in a high-octane Cyberpunk adventure where neon-soaked streets and advanced technology collide. As a gritty urban mercenary, navigate a dystopian world rife with corporate espionage, hacktivism, and cybernetic enhancements. Choose your allies wisely, shape your destiny, and uncover the dark secrets that define the future.'),
(9, 'https://image.api.playstation.com/gs2-sec/appkgo/prod/CUSA08032_00/3/i_1ef7033e599774239b53869b64c7362da504cfec72a2a7ff6bba26eb1121da6f/i/icon0.png', 'Dead By Daylight', 'Survival Horror', 'Dead By Daylight is a thrilling asymmetrical multiplayer horror game. Players can either take on the role of ruthless killers or the hunted survivors in intense, heart-pounding matches. The hunt is on, as survivors work together to escape, while killers strive to sacrifice their prey to the Entity.'),
(10, 'https://i.ytimg.com/vi/qdMTOvYBsPQ/maxresdefault.jpg', 'Dota 2', 'MOBA', 'Dive into the epic world of Dota 2 Game Form, a thrilling multiplayer experience where players strategize and clash in intense battles. Choose from a roster of powerful heroes, wield devastating abilities, and conquer objectives to lead your team to victory in this action-packed, competitive arena!');

-- --------------------------------------------------------

--
-- Table structure for table `FORUM_ARTICLE`
--

CREATE TABLE `FORUM_ARTICLE` (
  `ARTICLE_ID` int(11) NOT NULL,
  `ARTICLE_TITLE` varchar(255) NOT NULL,
  `CONTENT` text NOT NULL,
  `IMAGE_URL` varchar(255) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `FORUM_ID` int(11) NOT NULL,
  `CONTENT_AS_HTML` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `FORUM_ARTICLE`
--

INSERT INTO `FORUM_ARTICLE` (`ARTICLE_ID`, `ARTICLE_TITLE`, `CONTENT`, `IMAGE_URL`, `USER_ID`, `FORUM_ID`, `CONTENT_AS_HTML`) VALUES
(1, 'League new mode coming out!', ' The launch of Arena coincides with the release of the franchise’s latest skin line,\n                                    where champions from Soul Fighter will occasionally make cameo appearances during matches.\n                                    These appearances can prove advantageous or disadvantageous for the players,\n                                    adding an extra layer of anticipation and strategy to the matches.', 'https://img.utdstc.com/screen/e25/838/e25838128eea795131ca034ab84198324673918402d8e43390c4e1d4a38c0b48:600', 36, 1, NULL),
(2, 'How to Play Gnar', 'First things first, make sure you\'re in the champion select screen. When it\'s your turn, look for the cute little Yordle with a boomerang and a big attitude! That\'s Gnar! Lock him in and get ready for some fun.\r\n\r\n', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 36, 1, NULL),
(3, 'Test', '<h1>Test</h1>\n<p>&nbsp;</p>\n<p>please work</p>', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 39, 1, NULL),
(4, 'How to play like kami', 'How to play like kami\n\nahri mid gg', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 39, 1, '<h1>How to play like kami</h1>\n<p>ahri mid gg</p>'),
(7, 'My Article', 'My Article\n\n\n\nsfjmeisdfjmisdfiisdfmisdfosdfsdfsdf', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 39, 1, '<h1>My Article</h1>\n<p>&nbsp;</p>\n<p>sfjmeisdfjmisdfiisdfmisdfosdfsdfsdf</p>'),
(8, 'My article title', 'My article title\n\n\n\nsdefhjnsdfiuhnbfuisdhusdfsdfuihniusdfszdfjuiszdfjnuisdfznuiszdffszd', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 39, 1, '<h1>My article title</h1>\n<p>&nbsp;</p>\n<p>sdefhjnsdfiuhnbfuisdhusdfsdfuihniusdfszdfjuiszdfjnuisdfznuiszdffszd</p>'),
(9, 'Please work', 'Please work\n\n\n\nyes yes?', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 39, 1, '<h1>Please work</h1>\n<p>&nbsp;</p>\n<p>yes yes?</p>'),
(10, 'WORK', 'WORK\n\n\n\nPLEASEEE', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 39, 1, '<h1>WORK</h1>\n<p>&nbsp;</p>\n<p>PLEASEEE</p>'),
(11, 'Are you working?', 'Are you working?\n\n\n\nYES HOPEFULLY', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 39, 1, '<h1>Are you working?</h1>\n<p>&nbsp;</p>\n<p>YES HOPEFULLY</p>'),
(12, '<strong>How to Play Jinx in League of Legends</strong>', 'How to Play Jinx in League of Legends\n\nJinx, the Loose Cannon, is a high-octane marksman champion in the popular game League of Legends. With her wild personality and penchant for chaos, Jinx brings an explosive playstyle to the Rift. To master this manic champion, players need to focus on positioning, timing, and strategic use of her abilities.\n\nIn the laning phase, Jinx relies on her long-range basic attacks and abilities to poke and farm safely from a distance. Her Q ability, Switcheroo!, allows her to toggle between two weapon forms: Pow-Pow, a minigun for sustained damage, and Fishbones, a rocket launcher for area-of-effect damage. Learning when to switch between these forms is crucial for maximizing her damage output. Additionally, her W, Zap!, is a powerful skillshot that can be used to harass enemies and slow them down. In team fights, Jinx\'s ultimate ability, Super Mega Death Rocket!, can turn the tide with its massive global-range damage. Properly timing and aiming her ultimate is a skill that can separate good Jinx players from great ones.', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 39, 1, '<h1><strong>How to Play Jinx in League of Legends</strong></h1>\n<p>Jinx, the Loose Cannon, is a high-octane marksman champion in the popular game League of Legends. With her wild personality and penchant for chaos, Jinx brings an explosive playstyle to the Rift. To master this manic champion, players need to focus on positioning, timing, and strategic use of her abilities.</p>\n<p>In the laning phase, Jinx relies on her long-range basic attacks and abilities to poke and farm safely from a distance. Her Q ability, Switcheroo!, allows her to toggle between two weapon forms: Pow-Pow, a minigun for sustained damage, and Fishbones, a rocket launcher for area-of-effect damage. Learning when to switch between these forms is crucial for maximizing her damage output. Additionally, her W, Zap!, is a powerful skillshot that can be used to harass enemies and slow them down. In team fights, Jinx\'s ultimate ability, Super Mega Death Rocket!, can turn the tide with its massive global-range damage. Properly timing and aiming her ultimate is a skill that can separate good Jinx players from great ones.</p>'),
(13, 'How to Play Jinx in League of Legends', 'How to Play Jinx in League of Legends\n\nJinx, the Loose Cannon, is a high-octane marksman champion in the popular game League of Legends. With her wild personality and penchant for chaos, Jinx brings an explosive playstyle to the Rift. To master this manic champion, players need to focus on positioning, timing, and strategic use of her abilities.\n\nIn the laning phase, Jinx relies on her long-range basic attacks and abilities to poke and farm safely from a distance. Her Q ability, Switcheroo!, allows her to toggle between two weapon forms: Pow-Pow, a minigun for sustained damage, and Fishbones, a rocket launcher for area-of-effect damage. Learning when to switch between these forms is crucial for maximizing her damage output. Additionally, her W, Zap!, is a powerful skillshot that can be used to harass enemies and slow them down. In team fights, Jinx\'s ultimate ability, Super Mega Death Rocket!, can turn the tide with its massive global-range damage. Properly timing and aiming her ultimate is a skill that can separate good Jinx players from great ones.\n\nAs the game progresses, Jinx\'s power spikes significantly. Her passive ability, Get Excited!, grants her bonus movement speed when she secures a kill or assist, allowing her to chase down enemies or reposition in fights. Players should be mindful of her positioning and take advantage of her speed boosts to stay safe while dealing massive damage. Additionally, building the right items is essential for maximizing her potential. A mix of attack damage, attack speed, and critical strike chance will make her basic attacks and abilities hit like a truck. Embrace the chaos, unleash the mayhem, and dominate the Rift as Jinx!\n\nWhether you\'re a seasoned ADC main or a newcomer to League of Legends, playing Jinx can be a thrilling and rewarding experience. Mastering her unique abilities, understanding her strengths and weaknesses, and working closely with your team will make you a formidable force on the battlefield. So, grab your rocket launcher, get ready to wreak havoc, and let the chaos begin with Jinx, the Loose Cannon!', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 39, 1, '<h1>How to Play Jinx in League of Legends</h1>\n<p>Jinx, the Loose Cannon, is a high-octane marksman champion in the popular game League of Legends. With her wild personality and penchant for chaos, Jinx brings an explosive playstyle to the Rift. To master this manic champion, players need to focus on positioning, timing, and strategic use of her abilities.</p>\n<p>In the laning phase, Jinx relies on her long-range basic attacks and abilities to poke and farm safely from a distance. Her Q ability, Switcheroo!, allows her to toggle between two weapon forms: Pow-Pow, a minigun for sustained damage, and Fishbones, a rocket launcher for area-of-effect damage. Learning when to switch between these forms is crucial for maximizing her damage output. Additionally, her W, Zap!, is a powerful skillshot that can be used to harass enemies and slow them down. In team fights, Jinx\'s ultimate ability, Super Mega Death Rocket!, can turn the tide with its massive global-range damage. Properly timing and aiming her ultimate is a skill that can separate good Jinx players from great ones.</p>\n<p>As the game progresses, Jinx\'s power spikes significantly. Her passive ability, Get Excited!, grants her bonus movement speed when she secures a kill or assist, allowing her to chase down enemies or reposition in fights. Players should be mindful of her positioning and take advantage of her speed boosts to stay safe while dealing massive damage. Additionally, building the right items is essential for maximizing her potential. A mix of attack damage, attack speed, and critical strike chance will make her basic attacks and abilities hit like a truck. Embrace the chaos, unleash the mayhem, and dominate the Rift as Jinx!</p>\n<p>Whether you\'re a seasoned ADC main or a newcomer to League of Legends, playing Jinx can be a thrilling and rewarding experience. Mastering her unique abilities, understanding her strengths and weaknesses, and working closely with your team will make you a formidable force on the battlefield. So, grab your rocket launcher, get ready to wreak havoc, and let the chaos begin with Jinx, the Loose Cannon!</p>'),
(14, 'Mastering the Shapeshifting Fury: A Comprehensive Guide to Playing Gnar in League of Legends', 'Mastering the Shapeshifting Fury: A Comprehensive Guide to Playing Gnar in League of Legends\n\nGnar, the Missing Link, is a unique and versatile champion in League of Legends, capable of changing between two forms - Mini Gnar and Mega Gnar. His kit offers a blend of ranged and melee abilities, making him a force to be reckoned with in both laning and teamfighting. In this detailed guide, we\'ll delve into Gnar\'s mechanics, laning strategies, teamfight tactics, and itemization, enabling you to harness his shapeshifting fury for victory on the Rift.\n\nUnderstanding Gnar\'s Passive and Form Mechanics: Gnar\'s passive, Rage Gene, fuels his transformation between Mini and Mega Gnar. As Gnar deals and receives damage, his Rage bar fills up. Once the bar reaches 100, he transforms into Mega Gnar, gaining bonus health, increased attack damage, and access to new abilities. After his rage depletes, he returns to his Mini form. Timing the transformation is crucial as Mega Gnar excels in initiating fights, while Mini Gnar shines in sustained skirmishes.\n\nLaning Phase: During the laning phase, Gnar\'s Mini form relies on harassing opponents with his Q ability, Boomerang Throw, and kiting with his W ability, Hyper, which empowers his basic attacks. Properly managing the minion wave allows you to build your Rage bar efficiently. Once you\'re close to Mega Gnar, communicate with your jungler to coordinate a gank or use your E ability, Hop, to engage enemies. In Mega Gnar form, use your W ability, Wallop, for crowd control and the Q ability, Boulder Toss, for ranged poke. Harass your lane opponent and look for opportunities to unleash your ultimate, GNAR!, against the wall for massive stun and damage.\n\nTeamfighting and Late Game: In teamfights, Gnar\'s impact lies in his ability to engage and disrupt the enemy team as Mega Gnar or kite and deal consistent damage as Mini Gnar. Communicate with your team about your form and plan your engages accordingly. Utilize the Flash+E combo for surprise Mega Gnar initiations, followed by the ultimate to turn the tide of battle. As Mini Gnar, use your Q ability to slow enemies and control the pace of the fight. Make use of your E ability to reposition and dodge skillshots, maintaining your survival. Properly managing Gnar\'s form is a key aspect of his late-game success, so always be aware of the Rage bar status before entering any skirmish or teamfight.\n\nItemization and Build Path: For Gnar, the choice of items depends on the game\'s dynamics and the enemy team composition. For Mini Gnar, consider building attack damage and attack speed items like Blade of the Ruined King and Black Cleaver. For Mega Gnar, focus on tanky items such as Sterak\'s Gage and Dead Man\'s Plate to increase your survivability in teamfights. Understanding when to prioritize damage or tankiness is essential for adapting to different situations in the game.\n\nConclusion: Playing Gnar requires finesse, quick decision-making, and the ability to adapt to various situations. Mastering his form mechanics, properly timing his transformation, and maximizing the potential of both Mini and Mega Gnar will allow you to excel as the Missing Link on the Rift. Whether you prefer to dominate your lane or unleash fury in teamfights, harnessing Gnar\'s shapeshifting abilities will undoubtedly make you a formidable force on the battlefield. So, embrace the primal rage, embrace the chaos, and embrace Gnar - the Missing Link!', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 39, 1, '<h1>Mastering the Shapeshifting Fury: A Comprehensive Guide to Playing Gnar in League of Legends</h1>\n<p>Gnar, the Missing Link, is a unique and versatile champion in League of Legends, capable of changing between two forms - Mini Gnar and Mega Gnar. His kit offers a blend of ranged and melee abilities, making him a force to be reckoned with in both laning and teamfighting. In this detailed guide, we\'ll delve into Gnar\'s mechanics, laning strategies, teamfight tactics, and itemization, enabling you to harness his shapeshifting fury for victory on the Rift.</p>\n<p><strong>Understanding Gnar\'s Passive and Form Mechanics:</strong> Gnar\'s passive, Rage Gene, fuels his transformation between Mini and Mega Gnar. As Gnar deals and receives damage, his Rage bar fills up. Once the bar reaches 100, he transforms into Mega Gnar, gaining bonus health, increased attack damage, and access to new abilities. After his rage depletes, he returns to his Mini form. Timing the transformation is crucial as Mega Gnar excels in initiating fights, while Mini Gnar shines in sustained skirmishes.</p>\n<p><strong>Laning Phase:</strong> During the laning phase, Gnar\'s Mini form relies on harassing opponents with his Q ability, Boomerang Throw, and kiting with his W ability, Hyper, which empowers his basic attacks. Properly managing the minion wave allows you to build your Rage bar efficiently. Once you\'re close to Mega Gnar, communicate with your jungler to coordinate a gank or use your E ability, Hop, to engage enemies. In Mega Gnar form, use your W ability, Wallop, for crowd control and the Q ability, Boulder Toss, for ranged poke. Harass your lane opponent and look for opportunities to unleash your ultimate, GNAR!, against the wall for massive stun and damage.</p>\n<p><strong>Teamfighting and Late Game:</strong> In teamfights, Gnar\'s impact lies in his ability to engage and disrupt the enemy team as Mega Gnar or kite and deal consistent damage as Mini Gnar. Communicate with your team about your form and plan your engages accordingly. Utilize the Flash+E combo for surprise Mega Gnar initiations, followed by the ultimate to turn the tide of battle. As Mini Gnar, use your Q ability to slow enemies and control the pace of the fight. Make use of your E ability to reposition and dodge skillshots, maintaining your survival. Properly managing Gnar\'s form is a key aspect of his late-game success, so always be aware of the Rage bar status before entering any skirmish or teamfight.</p>\n<p><strong>Itemization and Build Path:</strong> For Gnar, the choice of items depends on the game\'s dynamics and the enemy team composition. For Mini Gnar, consider building attack damage and attack speed items like Blade of the Ruined King and Black Cleaver. For Mega Gnar, focus on tanky items such as Sterak\'s Gage and Dead Man\'s Plate to increase your survivability in teamfights. Understanding when to prioritize damage or tankiness is essential for adapting to different situations in the game.</p>\n<p><strong>Conclusion:</strong> Playing Gnar requires finesse, quick decision-making, and the ability to adapt to various situations. Mastering his form mechanics, properly timing his transformation, and maximizing the potential of both Mini and Mega Gnar will allow you to excel as the Missing Link on the Rift. Whether you prefer to dominate your lane or unleash fury in teamfights, harnessing Gnar\'s shapeshifting abilities will undoubtedly make you a formidable force on the battlefield. So, embrace the primal rage, embrace the chaos, and embrace Gnar - the Missing Link!</p>'),
(15, 'title', 'title\n\n\n\nsdfnjindfvjuisdcvnjuidxfvnhjuszdcnvbihszdcb hyuszxcvbhyjuxcxcv', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 39, 1, '<h1>title</h1>\n<p>&nbsp;</p>\n<p>sdfnjindfvjuisdcvnjuidxfvnhjuszdcnvbihszdcb hyuszxcvbhyjuxcxcv</p>'),
(16, 'Test', 'Test\n\n\n\nsdfsdfsdfsdf', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 39, 2, '<h1>Test</h1>\n<p>&nbsp;</p>\n<p>sdfsdfsdfsdf</p>'),
(17, 'This is my first post', 'This is my first post\n\nhello world', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 36, 1, '<h1>This is my first post</h1>\n<p>hello world</p>'),
(18, 'This is my second post', 'This is my second post\n\n', 'https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Gnar_0.jpg', 36, 1, '<h1>This is my second post</h1>\n<p><img src=\"https://i.pinimg.com/1200x/80/a6/61/80a661624920c01310d42d60834354ef.jpg\" alt=\"\" width=\"437\" height=\"438\"></p>');

-- --------------------------------------------------------

--
-- Table structure for table `GAMES`
--

CREATE TABLE `GAMES` (
  `GAME_ID` int(11) NOT NULL,
  `TITLE` varchar(255) NOT NULL,
  `DESCRIPTION` text DEFAULT NULL,
  `RELEASE_DATE` date DEFAULT NULL,
  `GAME_COVER_IMG_URL` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `GAMES`
--

INSERT INTO `GAMES` (`GAME_ID`, `TITLE`, `DESCRIPTION`, `RELEASE_DATE`, `GAME_COVER_IMG_URL`) VALUES
(15, 'Celeste', 'A critically acclaimed platformer with challenging gameplay.', '2018-01-25', '/img/game-covers/celeste-cover.png'),
(16, 'Fortnite', 'A popular battle royale game with a cartoonish art style.', '2017-07-25', '/img/game-covers/fortnite-cover.jpeg'),
(17, 'Five Nights Freddy’s Security Breach', 'A horror game set in a haunted location.', '2021-12-16', '/img/game-covers/fnaf_security_breach-cover.png'),
(18, 'Valorant', 'A tactical first-person shooter with unique character abilities.', '2020-06-02', '/img/game-covers/valorant-cover.jpg'),
(19, 'CS:GO', 'A classic competitive first-person shooter with a huge player base.', '2012-08-21', '/img/game-covers/csgo-cover.jpeg'),
(20, 'League of Legends', 'A highly popular multiplayer online battle arena (MOBA) game.', '2009-10-27', '/img/game-covers/leagueoflegends-cover.jpeg'),
(21, 'The Last of Us', 'An emotional action-adventure game in a post-apocalyptic world.', '2013-06-14', '/img/game-covers/thelastofus-cover.jpg'),
(22, 'Cyberpunk', 'A futuristic action role-playing game set in Night City.', '2020-12-10', '/img/game-covers/cyberpunk-cover.jpeg'),
(23, 'Dead By Daylight', 'A 4v1 horror game where one player is the killer, and the rest are survivors.', '2016-06-14', '/img/game-covers/deadbydaylight-cover.jpg'),
(24, 'Dota 2', 'A popular MOBA game and the sequel to Defense of the Ancients (DotA).', '2013-07-09', '/img/game-covers/dota2-cover.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `sub_comment`
--

CREATE TABLE `sub_comment` (
  `SUB_COMMENT_ID` int(11) NOT NULL,
  `CONTENT` text NOT NULL,
  `COMMENT_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sub_comment`
--

INSERT INTO `sub_comment` (`SUB_COMMENT_ID`, `CONTENT`, `COMMENT_ID`, `USER_ID`) VALUES
(1, 'Hi! Add me!', 1, 36),
(2, 'HIIIIII!', 1, 37),
(3, 'Hello!!', 2, 36),
(5, '123', 3, 36),
(6, 'hi im major', 2, 36),
(7, 'HIiiiiiiii', 2, 36),
(9, '111', 3, 36),
(11, 'hello world', 3, 36),
(12, 'xdddd', 4, 36),
(13, 'hello i wanna join the game', 4, 36),
(14, '1234', 4, 36),
(17, 'hi', 4, 39);

-- --------------------------------------------------------

--
-- Table structure for table `tutoring`
--

CREATE TABLE `tutoring` (
  `id` int(11) NOT NULL,
  `game_id` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `tutor_availability_id` int(11) DEFAULT NULL,
  `rank` varchar(50) DEFAULT NULL,
  `contact_info` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tutoring`
--

INSERT INTO `tutoring` (`id`, `game_id`, `price`, `tutor_availability_id`, `rank`, `contact_info`, `description`) VALUES
(36, 20, 70.00, 1, 'Master', 'major@hotmail.com', 'A description'),
(37, 22, 24.00, 5, 'TOP', 'email.com', 'dfvfgvdfvdvdfvf'),
(38, 16, 50.00, 0, 'High Rank', 'example@email.com', 'Experienced tutor in the game.');

-- --------------------------------------------------------

--
-- Table structure for table `tutor_availability`
--

CREATE TABLE `tutor_availability` (
  `id` int(11) NOT NULL,
  `tutor_id` int(11) NOT NULL,
  `day_of_week` varchar(20) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tutor_availability`
--

INSERT INTO `tutor_availability` (`id`, `tutor_id`, `day_of_week`, `start_time`, `end_time`) VALUES
(1, 36, 'Wednesday', '23:31:03', '23:31:03'),
(2, 38, 'Thursday', '23:31:03', '23:31:03'),
(4, 36, 'Friday', '23:58:58', '23:58:58'),
(5, 38, 'Sunday', '00:00:09', '00:00:09'),
(6, 37, 'Tuesday', '00:05:41', '00:05:41');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `USER_ID` int(11) NOT NULL,
  `IMAGE_URL` varchar(255) NOT NULL,
  `USER_NAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `DATE_CREATED` date NOT NULL DEFAULT current_timestamp(),
  `SUBSCRIPTION` varchar(10) NOT NULL,
  `ROLE` varchar(10) NOT NULL,
  `PAYMENT_TYPE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`USER_ID`, `IMAGE_URL`, `USER_NAME`, `PASSWORD`, `EMAIL`, `DATE_CREATED`, `SUBSCRIPTION`, `ROLE`, `PAYMENT_TYPE`) VALUES
(36, '/img/user_avatar/3fe4cf4d-b95d-462b-b480-66e71bb7e60b.jpg', 'major0814', 'Mj123456!', 'majorangeee@gmail.com', '2023-07-30', 'vip', '/gg', 'none'),
(37, '/img/user_avatar/113aaefc-ba9f-4167-a170-abcdc238b520.png', 'testuser001', 'Mj123456!', 'testuser001@gmail.com', '2023-07-30', 'non-vip', '/wp', 'none'),
(38, '/img/user_avatar/113aaefc-ba9f-4167-a170-abcdc238b520.png', 'ryan0829', 'Colorful1010?', 'ab00999819@gmail.com', '2023-08-02', 'diamond', '/gg', 'none'),
(39, 'https://cdn-icons-png.flaticon.com/512/3177/3177440.png', 'rochaLS', '12345678@', 'rocha@hotmail.com', '2023-08-03', 'non-vip', '/gg', 'none'),
(40, '/img/user_avatar/ce379156-0ee1-47ee-ab2a-2ee615444324.jpg', 'jenny123', '12345678!', 'jenny@gmail.com', '2023-08-03', 'non-vip', '/gg', 'none');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`COMMENT_ID`),
  ADD KEY `USER_ID` (`USER_ID`);

--
-- Indexes for table `FORUM`
--
ALTER TABLE `FORUM`
  ADD PRIMARY KEY (`FORUM_ID`);

--
-- Indexes for table `FORUM_ARTICLE`
--
ALTER TABLE `FORUM_ARTICLE`
  ADD PRIMARY KEY (`ARTICLE_ID`),
  ADD KEY `USER_ID` (`USER_ID`),
  ADD KEY `FORUM_ID` (`FORUM_ID`);

--
-- Indexes for table `GAMES`
--
ALTER TABLE `GAMES`
  ADD PRIMARY KEY (`GAME_ID`);

--
-- Indexes for table `sub_comment`
--
ALTER TABLE `sub_comment`
  ADD PRIMARY KEY (`SUB_COMMENT_ID`),
  ADD KEY `COMMENT_ID` (`COMMENT_ID`),
  ADD KEY `USER_ID` (`USER_ID`);

--
-- Indexes for table `tutoring`
--
ALTER TABLE `tutoring`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tutor_availability`
--
ALTER TABLE `tutor_availability`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tutoring` (`tutor_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`USER_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `COMMENT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `FORUM`
--
ALTER TABLE `FORUM`
  MODIFY `FORUM_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `FORUM_ARTICLE`
--
ALTER TABLE `FORUM_ARTICLE`
  MODIFY `ARTICLE_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `GAMES`
--
ALTER TABLE `GAMES`
  MODIFY `GAME_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `sub_comment`
--
ALTER TABLE `sub_comment`
  MODIFY `SUB_COMMENT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `tutoring`
--
ALTER TABLE `tutoring`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `tutor_availability`
--
ALTER TABLE `tutor_availability`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `USER_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `FORUM_ARTICLE`
--
ALTER TABLE `FORUM_ARTICLE`
  ADD CONSTRAINT `forum_article_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `forum_article_ibfk_3` FOREIGN KEY (`FORUM_ID`) REFERENCES `FORUM` (`FORUM_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sub_comment`
--
ALTER TABLE `sub_comment`
  ADD CONSTRAINT `sub_comment_ibfk_1` FOREIGN KEY (`COMMENT_ID`) REFERENCES `comment` (`COMMENT_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sub_comment_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
