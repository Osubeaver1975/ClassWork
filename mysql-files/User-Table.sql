use estoer;
drop table if exists User;
create table User (
    uid     int PRIMARY KEY AUTO_INCREMENT, -- have DBMS generate a unique uid
    name    varchar(256),
    phone   varchar(16),
    email   varchar(256)
);
show tables;
describe User;