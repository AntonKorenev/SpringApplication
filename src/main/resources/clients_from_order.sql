CREATE VIEW ClientsFromOrder AS
SELECT clients.id, clients.first_name, clients.last_name
FROM clients
INNER JOIN orders
ON orders.client_id=clients.id
ORDER BY orders.client_id;