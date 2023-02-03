TRUNCATE TABLE user_table RESTART IDENTITY;
INSERT  INTO user_table (id, firstname, lastname, birthday) VALUES (1, 'Roma', 'Lutsiv', '1997-11-14');
INSERT INTO user_table (id, firstname, lastname, birthday) VALUES (2, 'John', 'Doe', '1990-10-20');
INSERT INTO user_table (id, firstname, lastname, birthday) VALUES (3, 'Test', 'User', '1983-01-05');