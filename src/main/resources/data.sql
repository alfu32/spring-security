insert into USER(
    ID,
    USERNAME,
    PASSWORD,
    IS_ACCOUNT_NON_EXPIRED,
    IS_ACCOUNT_NON_LOCKED,
    IS_CREDENTIALS_NON_EXPIRED,
    IS_ENABLED,
    GRANTED_AUTHORITIES
    )
values
(0,'guest','',true,true,true,true,'GUEST'),
(1,'user','user',true,true,true,true,'USER'),
(2,'dbadmin','dbadmin',true,true,true,true,'DBADMIN'),
(3,'comadmin','comadmin',true,true,true,true,'DBADMIN'),
(4,'admin','1234admin',true,true,true,true,'ADMIN;USER;DBADMIN');

INSERT INTO ROLE(ID, SCOPE, ROLE, DESCRIPTION) values
(0,'GLOBAL', 'CREATE','create globals'),
(1,'GLOBAL', 'READ','read globals'),
(2,'GLOBAL', 'UPDATE','update globals'),
(3,'GLOBAL', 'DELETE','delete globals'),
(4,'ROLE', 'CREATE','create roles'),
(5,'ROLE', 'READ','read roles'),
(6,'ROLE', 'UPDATE','update roles'),
(7,'ROLE', 'DELETE','delete roles'),
(8,'ROLE', 'ASSIGN','assign roles'),
(9,'ROLE', 'UNASSIGN','unassign roles'),
(10,'DBADMIN', 'ACCESS','access db console'),
(11,'USER', 'REGISTER','register user'),
(12,'USER', 'DISABLE','disable user'),
(13,'USER', 'DEREGISTER','deregister user'),
(14,'LIST', 'CREATE','create lists'),
(15,'LIST', 'READ','read lists'),
(16,'LIST', 'UPDATE','update lists'),
(17,'LIST', 'DELETE','delete lists'),
(18,'LISTITEM', 'CREATE','create listitems'),
(19,'LISTITEM', 'READ','read listitems'),
(20,'LISTITEM', 'UPDATE','update listitems'),
(21,'LISTITEM', 'DELETE','delete listitems');

INSERT INTO USER_ROLE(USER_ID, ROLE_ID) VALUES
(0,14),
(0,15),
(0,16),
(0,17),
(0,18),
(0,19),
(0,20),
(0,21),
(1,5),
(1,14),
(1,15),
(1,16),
(1,17),
(1,18),
(1,19),
(1,20),
(1,21),
(2,10),
(3,4),
(3,5),
(3,6),
(3,7),
(3,8),
(3,9),
(3,11),
(3,12),
(3,13),
(4,0),
(4,1),
(4,2),
(4,3);
-- INSERT INTO USER_AUTHORITY(id, scope, right)
-- VALUES
-- (5, 'ADMIN', 'CREATE'),
-- (6, 'ADMIN', 'READ'),
-- (7, 'ADMIN', 'UPDATE'),
-- (8, 'ADMIN', 'DELETE'),
-- (9, 'DB_CONSOLE', 'ACCESS'),
-- (10, 'USER_AUTHORITY', 'CREATE'),
-- (11, 'USER_AUTHORITY', 'READ'),
-- (12, 'USER_AUTHORITY', 'UPDATE'),
-- (13, 'USER_AUTHORITY', 'DELETE'),
-- (14, 'USER', 'CREATE'),
-- (15, 'USER', 'READ'),
-- (16, 'USER', 'UPDATE'),
-- (17, 'USER', 'DELETE'),
-- (18, 'LIST', 'CREATE'),
-- (19, 'LIST', 'READ'),
-- (20, 'LIST', 'UPDATE'),
-- (21, 'LIST', 'DELETE'),
-- (22, 'ITEM', 'CREATE'),
-- (23, 'ITEM', 'READ'),
-- (24, 'ITEM', 'UPDATE'),
-- (25, 'ITEM', 'DELETE');