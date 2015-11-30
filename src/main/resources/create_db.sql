CREATE DATABASE spring_application;

CREATE TABLE clients
(
id int NOT NULL UNIQUE AUTO_INCREMENT,
first_name varchar(50) NOT NULL,
last_name varchar(50) NOT NULL,
PRIMARY KEY (id),
CHECK (id > 0)
);

CREATE TABLE products
(
id int NOT NULL UNIQUE AUTO_INCREMENT,
price double NOT NULL,
name varchar(50) NOT NULL,
PRIMARY KEY (id),
CONSTRAINT chk_product CHECK (id > 0 AND price > 0.0)
);

CREATE TABLE orders
(
id int NOT NULL UNIQUE AUTO_INCREMENT,
task varchar(10) NOT NULL,
order_number int NOT NULL,
client_id int NOT NULL,
product_id int NOT NULL,
PRIMARY KEY (id),
CONSTRAINT FOREIGN KEY (client_id) REFERENCES clients(id),
CONSTRAINT FOREIGN KEY (product_id) REFERENCES products(id),
CHECK (id > 0)
);

INSERT INTO clients (first_name,last_name)
VALUES ('Anton','Korenev');
INSERT INTO clients (first_name,last_name)
VALUES ('Johny','Catsville');
INSERT INTO clients (first_name,last_name)
VALUES ('Ichiro','Hodzyo');

INSERT INTO products (price, name)
VALUES (1000.0, 'router');
INSERT INTO products (price, name)
VALUES (2000.0, 'smartphone');
INSERT INTO products (price, name)
VALUES (3000.0, 'tablet');
INSERT INTO products (price, name)
VALUES (4000.0, 'TV');
INSERT INTO products (price, name)
VALUES (5000.0, 'owen');

INSERT INTO orders (task,order_number,client_id,product_id)
VALUES ('buy',1,1,1);
INSERT INTO orders (task,order_number,client_id,product_id)
VALUES ('buy',1,1,2);
INSERT INTO orders (task,order_number,client_id,product_id)
VALUES ('buy',1,1,3);
INSERT INTO orders (task,order_number,client_id,product_id)
VALUES ('buy',2,1,1);
INSERT INTO orders (task,order_number,client_id,product_id)
VALUES ('buy',2,1,2);
INSERT INTO orders (task,order_number,client_id,product_id)
VALUES ('buy',3,1,1);