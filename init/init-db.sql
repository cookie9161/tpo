IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'movie_database')
BEGIN
CREATE DATABASE movie_database;
END

SELECT name, type_desc, is_disabled
FROM sys.sql_logins
WHERE name = 'sa';