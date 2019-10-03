drop schema customer;
create schema customer;
use customer;
create table customer
(
    id int not null,
    name varchar(255) not null,
    age int(10) not null
);

create unique index customer_id_uindex
    on customer (id);

alter table customer
    add constraint customer_pk
        primary key (id);

