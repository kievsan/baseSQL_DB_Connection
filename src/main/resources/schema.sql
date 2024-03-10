create schema db3 authorization postgres;

create table if not exists db3.customers (
    id serial primary key ,
    name varchar(20) not null ,
    surname varchar(30) not null ,
    age int not null ,
    phone_number bigint
);

create table if not exists db3.orders (
    id serial primary key ,
    date date not null default CURRENT_DATE ,
    product_name varchar(50) not null ,
    amount decimal(10,2) not null,
    customer_id int references db3.customers (id)
);
