--liquibase formatted sql

--changeset litvina.e:init-db-model

create table if not exists stash
(
    id int GENERATED BY DEFAULT AS IDENTITY,
    title varchar(255)
);

create table if not exists artifact
(
    id int GENERATED BY DEFAULT AS IDENTITY,
    title varchar(255),
    stash_id int references stash (id) not null
);

create table if not exists tag
(
    id int GENERATED BY DEFAULT AS IDENTITY,
    title varchar(50)
);