USE [master]
GO
/****** Object:  Database [PolyOEAsg]    Script Date: 16/2/2023 1:17:57 PM ******/
CREATE DATABASE [PolyOEAsg]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PolyOEAsg', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\PolyOEAsg.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PolyOEAsg_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\PolyOEAsg_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [PolyOEAsg] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PolyOEAsg].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PolyOEAsg] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PolyOEAsg] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PolyOEAsg] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PolyOEAsg] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PolyOEAsg] SET ARITHABORT OFF 
GO
ALTER DATABASE [PolyOEAsg] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [PolyOEAsg] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PolyOEAsg] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PolyOEAsg] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PolyOEAsg] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PolyOEAsg] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PolyOEAsg] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PolyOEAsg] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PolyOEAsg] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PolyOEAsg] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PolyOEAsg] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PolyOEAsg] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PolyOEAsg] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PolyOEAsg] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PolyOEAsg] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PolyOEAsg] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PolyOEAsg] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PolyOEAsg] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PolyOEAsg] SET  MULTI_USER 
GO
ALTER DATABASE [PolyOEAsg] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PolyOEAsg] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PolyOEAsg] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PolyOEAsg] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PolyOEAsg] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PolyOEAsg] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [PolyOEAsg] SET QUERY_STORE = ON
GO
ALTER DATABASE [PolyOEAsg] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [PolyOEAsg]
GO
/****** Object:  Table [dbo].[Favorites]    Script Date: 16/2/2023 1:17:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Favorites](
	[FavoriteId] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](30) NULL,
	[VideoId] [nvarchar](50) NULL,
	[LikeDate] [date] NULL,
 CONSTRAINT [PK_Favorites] PRIMARY KEY CLUSTERED 
(
	[FavoriteId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shares]    Script Date: 16/2/2023 1:17:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shares](
	[ShareId] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](30) NULL,
	[VideoId] [nvarchar](50) NULL,
	[Email] [nvarchar](250) NULL,
	[ShareDate] [date] NULL,
 CONSTRAINT [PK_Shares] PRIMARY KEY CLUSTERED 
(
	[ShareId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 16/2/2023 1:17:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[Username] [nvarchar](30) NOT NULL,
	[Fullname] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Admin] [bit] NOT NULL,
	[password] [nvarchar](20) NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Videos]    Script Date: 16/2/2023 1:17:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Videos](
	[VideoId] [nvarchar](50) NOT NULL,
	[Title] [nvarchar](100) NOT NULL,
	[Poster] [nvarchar](150) NOT NULL,
	[Views] [int] NOT NULL,
	[Description] [nvarchar](1500) NULL,
	[Active] [bit] NOT NULL,
 CONSTRAINT [PK_Videos] PRIMARY KEY CLUSTERED 
(
	[VideoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Favorites] ON 

INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikeDate]) VALUES (1134, N'leminh12', N'vd01', CAST(N'2022-12-16' AS Date))
INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikeDate]) VALUES (1137, N'leminh', N'vd14', CAST(N'2022-12-16' AS Date))
SET IDENTITY_INSERT [dbo].[Favorites] OFF
GO
SET IDENTITY_INSERT [dbo].[Shares] ON 

INSERT [dbo].[Shares] ([ShareId], [Username], [VideoId], [Email], [ShareDate]) VALUES (38, N'leminh', N'vd14', N'lengocminh081098@gmail.com', CAST(N'2022-12-16' AS Date))
INSERT [dbo].[Shares] ([ShareId], [Username], [VideoId], [Email], [ShareDate]) VALUES (39, N'leminh', N'vd01', N'lengocminh081098@gmail.com', CAST(N'2022-12-16' AS Date))
SET IDENTITY_INSERT [dbo].[Shares] OFF
GO
INSERT [dbo].[Users] ([Username], [Fullname], [Email], [Admin], [password]) VALUES (N'leminh', N'le van minh', N'levanminhht98@gmail.com', 0, N'123')
INSERT [dbo].[Users] ([Username], [Fullname], [Email], [Admin], [password]) VALUES (N'leminh12', N'le ngoc minh1222', N'leminh@gmail.com', 0, N'111')
INSERT [dbo].[Users] ([Username], [Fullname], [Email], [Admin], [password]) VALUES (N'minhlv', N'lee Minh HT', N'minhlvpd05439@fpt.edu.vn', 1, N'111')
GO
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd01', N'Khi Ma 222', N'uploads/vd01.jpg', 34, N'', 0)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd02', N'Tinh Ca Tinh Ta', N'uploads/vd02.jpg', 20, N'https://www.youtube.com/embed/1lLbjCyns80', 0)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd03', N'Tell Your Mom', N'uploads/vd03.jpg', 12, N'https://www.youtube.com/embed/mZF9BRZkTDQ', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd04', N'Vay Cuoi', N'uploads/vd04.jpg', 16, N'https://www.youtube.com/embed/74XZ9SB3l3k', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd11', N'Co Dau Ai Ngo', N'uploads/vd11.jpg', 17, N'https://www.youtube.com/embed/EW9v4iAGa0Q', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd13', N'See Tinh', N'uploads/vd13.jpg', 13, N'https://www.youtube.com/embed/tVTRY6851Ug', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd14', N'Gu', N'uploads/vd14.jpg', 16, N'https://www.youtube.com/embed/VI47bTJaMe4', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd15', N'Anh Se Don Em', N'uploads/vd15.jpg', 12, N'https://www.youtube.com/embed/a0MNrpNvyW0', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd16', N'Yeu Dung So Dau', N'uploads/vd16.jpg', 13, N'https://www.youtube.com/embed/IiVC7omXhUQ', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd17', N'Duong Toi Cho Em Ve', N'uploads/vd17.jpg', 12, N'https://www.youtube.com/embed/1NywJvNpgAI', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd18', N'Sai Gon Mua', N'uploads/vd18.jpg', 11, N'https://www.youtube.com/embed/TIH31txNjTc', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd19', N'Thuc Giac', N'uploads/vd19.jpg', 11, N'https://www.youtube.com/embed/aiCdY0sbcac', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd20', N'Co Hen Voi Thanh Xuan', N'uploads/vd20.jpg', 12, N'https://www.youtube.com/embed/ff1S43ggbQQ', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd21', N'Tinh Yeu Ngu Quen', N'uploads/vd21.jpg', 13, N'https://www.youtube.com/embed/GsjpxG5Q-eA', 1)
GO
ALTER TABLE [dbo].[Favorites]  WITH CHECK ADD  CONSTRAINT [FK_Favorites_Users] FOREIGN KEY([Username])
REFERENCES [dbo].[Users] ([Username])
GO
ALTER TABLE [dbo].[Favorites] CHECK CONSTRAINT [FK_Favorites_Users]
GO
ALTER TABLE [dbo].[Favorites]  WITH CHECK ADD  CONSTRAINT [FK_Favorites_Videos] FOREIGN KEY([VideoId])
REFERENCES [dbo].[Videos] ([VideoId])
GO
ALTER TABLE [dbo].[Favorites] CHECK CONSTRAINT [FK_Favorites_Videos]
GO
ALTER TABLE [dbo].[Shares]  WITH CHECK ADD  CONSTRAINT [FK_Shares_Users] FOREIGN KEY([Username])
REFERENCES [dbo].[Users] ([Username])
GO
ALTER TABLE [dbo].[Shares] CHECK CONSTRAINT [FK_Shares_Users]
GO
ALTER TABLE [dbo].[Shares]  WITH CHECK ADD  CONSTRAINT [FK_Shares_Videos] FOREIGN KEY([VideoId])
REFERENCES [dbo].[Videos] ([VideoId])
GO
ALTER TABLE [dbo].[Shares] CHECK CONSTRAINT [FK_Shares_Videos]
GO
USE [master]
GO
ALTER DATABASE [PolyOEAsg] SET  READ_WRITE 
GO
