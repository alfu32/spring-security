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
(2,'admin','1234admin',true,true,true,true,'ADMIN;USER;SPECIAL');