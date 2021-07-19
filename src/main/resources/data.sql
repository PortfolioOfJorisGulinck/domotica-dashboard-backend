-- Creation and populating User table
CREATE TABLE User (
    id integer not null,
    active boolean not null,
    password varchar(255),
    roles varchar(255),
    userName varchar(255),
    primary key (id)
);

INSERT INTO User (id, userName, password, active, roles) VALUES (1, 'user', 'user', true, 'USER');

-- TODO Creation tables and datapopulation floors, schemes and rooms