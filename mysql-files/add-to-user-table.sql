-- Add some rows to User table

-- the SQL INSERT statement is how you add rows to a table
--
-- Insert into table(columns-in-table-you-have-data-for)
--  Values(list of values for columns)
--
-- Note: order of values must match order of columns! ! ! 
use estore;
insert into User
 (name, phone, email)
 value('Frank', '123-456-7890', 'frank@frank.com');
 insert into User
  (name, phone, email)
 value('Tinkerbell', '234-567-8901', 'tinkerbell@tinkerbell.com');
 select * from User;
 