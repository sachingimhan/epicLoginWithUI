CREATE DATABASE epicLogin;

USE epicLogin;

CREATE TABLE user_role(
roleid int auto_increment,
rolename varchar(255) not null,
CONSTRAINT PRIMARY KEY (roleid)
)engine=innodb;

INSERT INTO user_role(rolename) VALUES('user');

CREATE TABLE user_(
uuid int auto_increment,
username varchar(255) not null,
userpass varchar(255) not null,
fullname varchar(255) not null,
useraddress varchar(255) not null,
roleid int not null,
CONSTRAINT PRIMARY KEY (uuid),
CONSTRAINT FOREIGN KEY (roleid) REFERENCES user_role(roleid) on delete cascade on update cascade
)engine=innodb;

CREATE TABLE login_history(
hid int auto_increment,
date_stamp date not null,
time_stamp time not null,
uuid int not null,
CONSTRAINT PRIMARY KEY (hid),
CONSTRAINT FOREIGN KEY (uuid) REFERENCES user_(uuid) on delete cascade on update cascade
)engine=innodb;
