-- CREATE TABLE Product
DROP TABLE IF EXISTS product;
CREATE TABLE product (
                id bigint PRIMARY KEY,
                name VARCHAR(255),
                description VARCHAR(255),
                price double precision,
                image VARCHAR(255)
    );

-- CREATE TABLE Client
DROP TABLE IF EXISTS client;
CREATE TABLE client (
                        id bigint PRIMARY KEY,
                        client_name VARCHAR(255) NOT NULL UNIQUE,
                        password VARCHAR(255),
                        role VARCHAR(255)
);