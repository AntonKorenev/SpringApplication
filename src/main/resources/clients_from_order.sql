CREATE VIEW ClientsFromOrder AS
SELECT clients.id, clients.first_name, clients.last_name
FROM clients
INNER JOIN orders
ON orders.order_number=clients.id
ORDER BY order_number;