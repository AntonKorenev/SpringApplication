CREATE DATABASE spring_application;

CREATE TABLE clients
(
  id int NOT NULL UNIQUE AUTO_INCREMENT,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE orders
(
  id int NOT NULL UNIQUE AUTO_INCREMENT,
  task varchar(10) NOT NULL,
  client_id int,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE products
(
  id int NOT NULL UNIQUE AUTO_INCREMENT,
  price double NOT NULL,
  name varchar(50) NOT NULL,
  order_id int,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (order_id) REFERENCES orders(id)
);

