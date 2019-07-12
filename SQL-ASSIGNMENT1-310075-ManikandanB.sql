

select * from fse.subject;

select * from fse.book;


drop table fse.book;

CREATE TABLE fse.SUBJECT (
	SUBJECTID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SUBTITLE VARCHAR(50) NOT NULL,
    DURATIONINHOURS INT,
    REFERENCE SET('HEADFIRSTJAVA','HEADFIRSTEJB','HIBERNATE1.0','SQLMANAGER','KafaDoc')    
);

INSERT INTO FSE.subject (SUBJECTID,SUBTITLE,DURATIONINHOURS,REFERENCE) values (1003,'EJB',20,'HEADFIRSTEJB');

UPDATE FSE.SUBJECT SET DURATIONINHOURS=100 WHERE subjectid=1002;

DELETE FROM FSE.BOOK WHERE BOOKID ='2003';

ALTER TABLE fse.SUBJECT ADD SUBJECTID int;


CREATE TABLE fse.BOOK (
	BOOKID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TITLE VARCHAR(50) NOT NULL,
    PRICE DOUBLE,
    VOLUME INT,
    PUBLISHDATE date,SUBJECTID int
);


SET SQL_SAFE_UPDATES = 0;

INSERT INTO FSE.BOOK (BOOKID,TITLE,PRICE,VOLUME,PUBLISHDATE) values (2003,'HIBERNATE1.0',400,1.5,STR_TO_DATE('12-12-2015','%m-%d-%Y'));

UPDATE FSE.BOOK SET volume=3 WHERE BOOKID=2001;

Delete from FSE.BOOK WHERE BOOKID=2002; 

select * from fse.users;

select * from fse.authorities;






CREATE TABLE fse.parent_task (
	parent_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    parent_task VARCHAR(500) NOT NULL   
	
) ENGINE=INNODB;


CREATE TABLE fse.task (
    task_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    task VARCHAR(50),
    start_date date,
    end_date date,
    priority int,
    INDEX parent_task_ind (parent_id),
    FOREIGN KEY (parent_id)
        REFERENCES fse.parent_task(parent_id)
        ON DELETE CASCADE
) ENGINE=INNODB;


CREATE TABLE fse.users (
	user_name VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled VARCHAR(50) NOT NULL
	
);

INSERT INTO FSE.users (user_name,password,enabled,role) values ('mani','mani',true,'Principal');


CREATE TABLE fse.authorities (
	authority VARCHAR(50) not null PRIMARY KEY
       
       );

CREATE TABLE fse.authorities (
    authority VARCHAR(50) not null PRIMARY KEY,
    user_name VARCHAR(50),
    INDEX user_ind (user_name),
    FOREIGN KEY (user_name)
        REFERENCES fse.users(user_name)
        ON DELETE CASCADE
) ENGINE=INNODB;


insert into fse.authorities (authority) values('Librarian');
insert into fse.authorities (authority) values('Principal');





