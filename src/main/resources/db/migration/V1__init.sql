DROP TABLE IF EXISTS products;
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) UNIQUE NOT NULL,
    description TEXT,
    price BIGINT
);

INSERT INTO products (title, description, price)
VALUES
('MacBook RED', 'Ultra low and Great Power', 3000),
('iPhone RED', 'The most expensive phone by credit', 1000),
('iPad RED', 'More size - more cost', 1500),
('iPod RED', 'Music on my mind', 3000),
('MacBook Yellow', 'Ultra low and Great Power', 3000),
('iPhone Yellow', 'The most expensive phone by credit', 1000),
('iPad Yellow', 'More size - more cost', 1500),
('iPod Yellow', 'Music on my mind', 3000),
('MacBook Blue', 'Ultra low and Great Power', 3000),
('iPhone Blue', 'The most expensive phone by credit', 1000),
('iPad Blue', 'More size - more cost', 1500),
('iPod Blue', 'Music on my mind', 3000),
('MacBook Green', 'Ultra low and Great Power', 3000),
('iPhone Green', 'The most expensive phone by credit', 1000),
('iPad Green', 'More size - more cost', 1500),
('iPod Green', 'Music on my mind', 3000),
('MacBook Black', 'Ultra low and Great Power', 3000),
('iPhone Black', 'The most expensive phone by credit', 1000),
('iPad Black', 'More size - more cost', 1500),
('iPod Black', 'Music on my mind', 3000);

