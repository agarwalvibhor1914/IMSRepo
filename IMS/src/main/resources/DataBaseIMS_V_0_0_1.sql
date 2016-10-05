-- Sqlite special commands
-- .mode column -> to go into the column mode
-- .header on -> to show the table header 
-- .width 10 20 30 15 20 -> to adjust the width of the column


CREATE TABLE userDetails(Id INTEGER, name VARCHAR(55), password VARCHAR(30), email VARCHAR(55), telephone INTEGER, PRIMARY KEY(Id));

insert into userDetails values (10002, 'TestUser2','anshi', 'test2@gmail.com', 0686461800);

ALTER TABLE userDetails ADD password VARCHAR(30);

