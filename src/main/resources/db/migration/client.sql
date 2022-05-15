CREATE TABLE client
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    created_date       TIMESTAMP,
    last_modified_date TIMESTAMP,
    version            BIGINT,
    name               VARCHAR(255),
    last_name          VARCHAR(255),
    phone              VARCHAR(255),
    address            VARCHAR(255),
    email              VARCHAR(255),
    CONSTRAINT pk_client PRIMARY KEY (id)
);