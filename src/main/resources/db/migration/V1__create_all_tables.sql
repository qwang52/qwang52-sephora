CREATE TABLE customers (
    customer_id            BIGSERIAL not null unique,
    first_name        VARCHAR(30),
    last_name       VARCHAR(30),
    email          VARCHAR(30),
	address        VARCHAR(100),
    post_code       INT,
	phone_number    INT
);
ALTER TABLE customers ADD CONSTRAINT customers_pk PRIMARY KEY ( customer_id );

CREATE TABLE products (
    item_number          BIGSERIAL NOT NULL unique,
    product_name         VARCHAR(150) not null,
	category        VARCHAR(30),
    description       VARCHAR(400),
    size          DECIMAL,
	price         DECIMAL
);
ALTER TABLE products ADD CONSTRAINT products_pk PRIMARY KEY ( item_number );

CREATE TABLE transactions (
    order_number             BIGSERIAL NOT NULL unique,
    customer_id          BIGSERIAL not null unique,
    item_number        BIGSERIAL NOT NULL unique,
	order_total   DECIMAL
);
ALTER TABLE transactions ADD CONSTRAINT transactions_pk PRIMARY KEY ( order_number );

ALTER TABLE transactions
    ADD CONSTRAINT transactions_customers_fk FOREIGN KEY ( customer_id )
        REFERENCES customers ( customer_id );
ALTER TABLE transactions
    ADD CONSTRAINT transctions_products_fk FOREIGN KEY ( item_number )
        REFERENCES products ( item_number );