ALTER TABLE transaction
RENAME itemnumber TO product_id;

ALTER TABLE transaction
RENAME order_number TO id;

ALTER TABLE transactions
    ADD CONSTRAINT transctions_products_fk FOREIGN KEY ( product_id )
        REFERENCES products ( product_id );
ALTER TABLE transactions ADD CONSTRAINT transactions_pk PRIMARY KEY ( id );

