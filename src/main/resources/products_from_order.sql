CREATE VIEW ProductsFromOrder AS
SELECT products.id, products.name, products.price
FROM products
INNER JOIN orders
ON orders.id=products.orders_id
ORDER BY orders.id;