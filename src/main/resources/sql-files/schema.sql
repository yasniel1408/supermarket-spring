-- -----------------------------------------------------
-- Table "CATEGORY"
-- -----------------------------------------------------
CREATE TABLE  category (
   "id" INT NOT NULL,
   "description" VARCHAR(45) NOT NULL,
   "state" BOOLEAN NOT NULL,
   PRIMARY KEY ("id")
);

-- -----------------------------------------------------
-- Table "CLIENT"
-- -----------------------------------------------------
CREATE TABLE client (
    "id" INT NOT NULL,
    "name" VARCHAR(40) NULL,
    "last_name" VARCHAR(100) NULL,
    "phone" NUMERIC NULL,
    "address" VARCHAR(80) NULL,
    "email" VARCHAR(70) NULL,
    PRIMARY KEY ("id")
);

-- -----------------------------------------------------
-- Table "PRODUCT"
-- -----------------------------------------------------
CREATE TABLE product (
     "id" INT NOT NULL,
     "name" VARCHAR(45) NULL,
     "id_category" INT NOT NULL,
     "bar_code" VARCHAR(150) NULL,
     "sale_price" DECIMAL(16,2) NULL,
     "cant_stock" INT NOT NULL,
     "state" BOOLEAN NULL,
     PRIMARY KEY ("id"),
     CONSTRAINT "fk_product_category"
         FOREIGN KEY ("id_category")
             REFERENCES category ("id")
             ON DELETE NO ACTION
             ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table "COMPRAS"
-- -----------------------------------------------------
CREATE TABLE shopping (
  "id" INT NOT NULL,
  "id_client" VARCHAR(20) NOT NULL,
  "date" TIMESTAMP NULL,
  "payment_method" CHAR(1) NULL,
  "comment" VARCHAR(300) NULL,
  "state" CHAR(1) NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_compra_client"
      FOREIGN KEY ("id_client")
          REFERENCES client ("id")
          ON DELETE NO ACTION
          ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table "Shopping_Product"
-- -----------------------------------------------------
CREATE TABLE  shopping_product (
    "id_shopping" INT NOT NULL,
    "id_product" INT NOT NULL,
    "cant" INT NULL,
    "total" DECIMAL(16,2) NULL,
    "state" BOOLEAN NULL,
    PRIMARY KEY ("id_shopping", "id_product"),
    CONSTRAINT "fk_shopping_product_product"
       FOREIGN KEY ("id_product")
           REFERENCES product ("id")
           ON DELETE NO ACTION
           ON UPDATE NO ACTION,
    CONSTRAINT "fk_shopping_product_shopping"
       FOREIGN KEY ("id_shopping")
           REFERENCES shopping ("id")
           ON DELETE NO ACTION
           ON UPDATE NO ACTION);
