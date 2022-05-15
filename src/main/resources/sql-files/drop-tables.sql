drop SCHEMA IF EXISTS market CASCADE;
create schema market;

SET
search_path TO market;

drop table IF EXISTS category CASCADE;
drop table IF EXISTS client CASCADE;
drop table IF EXISTS product CASCADE;
drop table IF EXISTS shopping CASCADE;
drop table IF EXISTS shopping_product CASCADE;
