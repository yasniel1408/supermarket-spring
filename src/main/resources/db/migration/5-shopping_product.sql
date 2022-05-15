CREATE TABLE shopping_product
(
    cant        INT,
    total       INT,
    state       BOOLEAN,
    id_shopping BIGINT NOT NULL,
    id_product  BIGINT NOT NULL,
    CONSTRAINT pk_shopping_product PRIMARY KEY (id_shopping, id_product)
);

ALTER TABLE shopping_product
    ADD CONSTRAINT FK_SHOPPING_PRODUCT_ON_ID_PRODUCT FOREIGN KEY (id_product) REFERENCES product (id);

ALTER TABLE shopping_product
    ADD CONSTRAINT FK_SHOPPING_PRODUCT_ON_ID_SHOPPING FOREIGN KEY (id_shopping) REFERENCES shopping (id);