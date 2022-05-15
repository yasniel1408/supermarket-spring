CREATE TABLE product
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    created_date       TIMESTAMP,
    last_modified_date TIMESTAMP,
    version            BIGINT,
    name               VARCHAR(255),
    bar_code           VARCHAR(255),
    sale_price         DOUBLE,
    cant_stock         INT,
    state              BOOLEAN,
    id_category        BIGINT,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_ID_CATEGORY FOREIGN KEY (id_category) REFERENCES category (id);