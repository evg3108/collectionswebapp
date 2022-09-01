--liquibase formatted sql

--changeset litvina.e:init-db

create table if not exists appuser (
    id bigserial primary key,
    username varchar unique,
    password varchar
);

create table if not exists topic (
    id bigserial primary key,
    title varchar unique
);

create table if not exists stash
(
    id bigserial primary key,
    title varchar,
    description varchar,
    topic_id bigint references topic (id) not null,
    appuser_id bigint references appuser(id) not null
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
    title varchar unique
);

create table if not exists artifact_tag (
    artifact_id integer not null,
    tag_id integer  not null,
    primary key (artifact_id, tag_id),
    foreign key (artifact_id) references artifact,
    foreign key (tag_id) references tag
);
