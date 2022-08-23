--liquibase formatted sql

--changeset litvina.e:init-db-model

create table if not exists "user" (
    id bigserial primary key,
    username varchar,
    password varchar
);

create table if not exists stash
(
    id bigserial primary key,
    title varchar,
    topic varchar,
    description varchar,
    user_id bigint references "user"(id) not null
);

create table if not exists artifact
(
    id bigserial primary key,
    title varchar,
    stash_id bigint references stash (id) not null
);

create table if not exists tag
(
    id bigserial primary key,
    title varchar
);


create table if not exists user_stash (
    stash_id integer not null,
    user_id integer  not null,
    primary key (stash_id, user_id),
    foreign key (stash_id) references stash,
    foreign key (user_id) references "user"
);