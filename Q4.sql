CREATE DATABASE IF NOT EXISTS librarydb;

USE librarydb;

DROP TABLE IF EXISTS Book;

CREATE TABLE Book (
    BookID INT PRIMARY KEY,
    Title VARCHAR(100),
    Author VARCHAR(100),
    Price DOUBLE,
    Availability BOOLEAN
);