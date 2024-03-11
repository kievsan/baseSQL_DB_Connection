create schema if not exists db3 authorization postgres;

create table if not exists db3.customers (
    id serial primary key ,
    name varchar(20) not null ,
    surname varchar(30) not null ,
    age int not null ,
    phone_number varchar(12)
);

insert into db3.customers (name, surname, age, phone_number)
VALUES ('Вася', 'Пупкин', 20, '+79614005530'),
       ('Сеня', 'Гоцман', 43, '+79223334455'),
       ('alexey', 'Ред', 30, '+79376584421'),
       ('Serg', 'Green', 33, '+79216320122');

create table if not exists db3.orders (
    id serial primary key ,
    date date not null default CURRENT_DATE ,
    product_name varchar(50) not null ,
    amount decimal(10,2) not null,
    customer_id int references db3.customers (id)
);

insert into db3.orders (product_name, amount, customer_id)
VALUES ('телевизор Sony', 56500.00, 1),
       ('утюг Scarlett', 4700.00, 2),
       ('телевизор Samsung', 42000.00, 3),
       ('куртка', 3370.00, 3),
       ('джинсы', 5030.00, 4);
