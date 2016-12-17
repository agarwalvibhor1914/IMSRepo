-- Sqlite special commands
-- .mode column -> to go into the column mode
-- .header on -> to show the table header 
-- .width 10 20 30 15 20 -> to adjust the width of the column


CREATE TABLE userDetails(Id INTEGER, name VARCHAR(55), password VARCHAR(30), email VARCHAR(55), telephone INTEGER, PRIMARY KEY(Id));

insert into userDetails values (10002, 'TestUser2','anshi', 'test2@gmail.com', 0686461800);

ALTER TABLE userDetails ADD password VARCHAR(30);

CREATE TABLE productDetails(Id INTEGER, make VARCHAR(55), model VARCHAR(55), version VARCHAR(55), active NUMERIC, expirationDate VARCHAR(20), netPrice REAL, grossPrice REAL, taxPerc REAL, discountPerc REAL, accessories VARCHAR(200), PRIMARY KEY(Id));

insert into productDetails values (101, 'SAMSUNG','LED','V1001',1, '2016-12-31', 36000, 0, 14, 0,'');

