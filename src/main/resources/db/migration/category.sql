CREATE TABLE category
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    created_date       TIMESTAMP,
    last_modified_date TIMESTAMP,
    version            BIGINT,
    description        VARCHAR(255),
    state              BOOLEAN,
    CONSTRAINT pk_category PRIMARY KEY (id)
);