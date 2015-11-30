CREATE VIEW ProductsFromOrder AS
SELECT products.id, products.name, products.price
FROM products
INNER JOIN orders
ON orders.order_number=products.id
ORDER BY order_number;