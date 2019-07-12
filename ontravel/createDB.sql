create table cities
(
  description text not null,
  name        text not null
    constraint cities_pkey
    primary key
);

alter table cities
  owner to postgres;