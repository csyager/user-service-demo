create table users
(
    id              bigint      primary key,
    first_name      text        not null,
    middle_name     text        not null,
    last_name       text        not null
);

create table contacts
(
    id              bigint      primary key,
    user_id         bigint      not null,
        constraint users_contact_fk
            foreign key(user_id)
                references users(id)
                on delete cascade,
    email           text      unique,
    phone           text        unique
);

create table accounts
(
    id              bigint      primary key,
    user_id         bigint      not null,
        constraint users_account_fk
            foreign key(user_id)
                references users(id)
                on delete cascade,
    account_name    text        not null
);

create sequence users_id_seq
    start 1
    increment 1
    NO MAXVALUE
    CACHE 1;

create sequence contacts_id_seq
    start 1
    increment 1
    NO MAXVALUE
    CACHE 1;

create sequence accounts_id_seq
    start 1
    increment 1
    NO MAXVALUE
    CACHE 1;

ALTER TABLE users_id_seq
OWNER TO postgres;

ALTER TABLE contacts_id_seq
OWNER TO postgres;

ALTER TABLE accounts_id_seq
OWNER TO postgres;