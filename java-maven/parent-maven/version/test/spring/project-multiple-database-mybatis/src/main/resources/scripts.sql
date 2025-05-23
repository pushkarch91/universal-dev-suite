CREATE TABLE products (
                          id INT PRIMARY KEY,
                          name VARCHAR(255),
                          price DOUBLE
);

CREATE TABLE orders (
                        id INT PRIMARY KEY,
                        order_code VARCHAR(100),
                        customer_name VARCHAR(255),
                        product_id INT,
                        quantity INT,
                        price INT,
                        created_at TIMESTAMP
);

/*MYSQL*/
TRUNCATE TABLE products;
/*POSTGRESQL*/
TRUNCATE TABLE orders;