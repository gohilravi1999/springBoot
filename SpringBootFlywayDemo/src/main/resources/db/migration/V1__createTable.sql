create table REGISTRATION_USERS(
id bigint(20) not null AUTO_INCREMENT,
username varchar(100) not null,
firstName varchar(50) not null,
lastName varchar(50) default null,
email varchar(50) not null,
PRIMARY KEY (id),
UNIQUE KEY UK_username (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;