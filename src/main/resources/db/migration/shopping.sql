CREATE TABLE shopping
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    created_by         VARCHAR(255),
    last_modified_by   VARCHAR(255),
    created_date       TIMESTAMP,
    last_modified_date TIMESTAMP,
    version            BIGINT,
    payment_method     VARCHAR(255),
    comment            VARCHAR(255),
    state              BOOLEAN,
    id_client          BIGINT,
    CONSTRAINT pk_shopping PRIMARY KEY (id)
);

ALTER TABLE shopping
    ADD CONSTRAINT FK_SHOPPING_ON_ID_CLIENT FOREIGN KEY (id_client) REFERENCES client (id);