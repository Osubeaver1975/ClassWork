-- select * - retrieve all columns in order they are defined in the table
use estore;
select * -- the asterisk is a wildcard, so everything gets displayed
  from User
;
select email, name  -- specifying what columns you want displayed
  from User
;
select name -- column title
    from User -- table
where email like '%skywalker%'
;

-- Join is retreive data from multiple tables. 
-- needs to be something that matchhes  between tables (usually PK and FK)
-- show the names and addresses of all customers
-- INNER JOIN  Most common type of join is an INNER JOIN - shows rows that match between tables
-- LEFT JOIN - shows rows that are in first but not second table
-- RIGHT JOIN shows rows in second but not first
-- FULL OUTER JOIN shows all rows from both tables
-- name in USER TABLE address in CUSTOMER table ! ! ! 
select name, address  -- column titles 
    from User,Customer -- this is multiple tables this is called a JOIN using matching PK, FK in this case uid
where User.uid = Customer.uid 
;


-- MODERN SYNTAX is:
select name, address  -- column titles 
    from User
        INNER JOIN
        Customer 
on User.uid = Customer.uid -- this is multiple tables this is called a JOIN using matching PK, FK in this case uid
;

