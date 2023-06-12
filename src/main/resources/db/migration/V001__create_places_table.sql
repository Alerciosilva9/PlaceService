create schema if not exists challenge;

create table challenge.places(
    id bigserial primary key,
     name varchar not null,
     slug varchar(30),
     city varchar,
     state varchar,
     created time,
     updated time
);
