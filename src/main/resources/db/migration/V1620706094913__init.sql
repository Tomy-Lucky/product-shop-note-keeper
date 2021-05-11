create table if not exists note
(
    id               serial primary key,
    date             timestamp,
    task_description varchar(255)
);

create table if not exists product
(
    id          serial primary key,
    category    integer,
    cost        integer,
    description varchar(255),
    name        varchar(255),
    seller_id   bigint
        constraint fkesd6fy52tk7esoo2gcls4lfe3
            references seller
);

create table if not exists seller
(
    id       serial primary key,
    name     varchar(255),
    password varchar(255),
    cash     integer
);

create table if not exists client
(
    id       serial primary key,
    name     varchar(255),
    type     integer,
    cash     integer,
    password varchar(255)
);

create table if not exists product_clients
(
    product_model_id bigint not null
        constraint fkce9agux9wni98vmiw76w4mfek
            references product,
    clients_id       bigint not null
        constraint fkp8wiwcefsupk9h6ulhcx1up18
            references client
);

create table if not exists seller_products
(
    seller_model_id bigint not null
        constraint fkkihqm2mxxgrpmg1af9lwmgpqx
            references seller,
    products_id     bigint not null
        constraint uk_iemjsutf7nimmyt7xoelaktg1
            unique
        constraint fk1lvaagcjjuytidwm9608hsg0y
            references product
);


