--liquibase formatted sql

--changeset litvina.e:init-db-model

create table if not exists polzovatel (
    id bigserial primary key,
    username varchar,
    password varchar,
    email varchar
);

create table if not exists stash
(
    id bigserial primary key,
    title varchar,
    polzovatel_id bigint references polzovatel(id) not null
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


create table if not exists polzovatel_stash (
    stash_id integer not null,
    polzovatel_id integer  not null,
    primary key (stash_id, polzovatel_id),
    foreign key (stash_id) references stash,
    foreign key (polzovatel_id) references polzovatel
);