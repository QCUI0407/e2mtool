CREATE DATABASE e2m;
use e2m;
CREATE TABLE IF NOT EXISTS dept (
                                    dept_id INT PRIMARY KEY AUTO_INCREMENT,
                                    dept_name VARCHAR(50) default null
);

CREATE TABLE IF NOT EXISTS emp (
                       `emp_id` int(11) NOT NULL AUTO_INCREMENT,
                       `name` varchar(60) DEFAULT NULL,
                       `sex` varchar(2) DEFAULT NULL,
                       `age` int(3) DEFAULT NULL,
                       `sal` decimal(17,0) DEFAULT NULL,
                       `birthday` date NOT NULL,
                       `address` varchar(200) DEFAULT NULL,
                       `dept_id` int DEFAULT NULL,
                       PRIMARY KEY (`emp_id`,`birthday`)
);

CREATE TABLE IF NOT EXISTS user (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `username` varchar(50) DEFAULT NULL,
                        `password` varchar(256) DEFAULT NULL,
                        `ch_name` varchar(50) DEFAULT NULL,
                        PRIMARY KEY (`id`)
);

insert  into dept(dept_id,dept_name) values (1,'DEP1'),(2,'DEP2'),(3,'DEP3');

insert  into emp(`emp_id`,`name`,`sex`,`age`,`sal`,`birthday`,`address`,`dept_id`) values
                                                                                       (1,'AAA','M',34,'8000','2020-04-06','ADDRESS',1),
                                                                                       (2,'BBB','F',18,'2800','1989-04-11','ADDRESS',2),
                                                                                       (3,'CCC','M',23,'3500','1998-02-23','ADDRESS',3),
                                                                                       (4,'DDD','M',30,'6500','1976-01-14','ADDRESS',2),
                                                                                       (5,'EEE','M',58,'4000','2021-08-04','ADDRESS',3),
                                                                                       (6,'FFF','M',60,'9800','2021-11-02','ADDRESS',1),
                                                                                       (8,'GGG','F',40,'3000','2021-01-30','ADDRESS',2);

insert  into user(`id`,`username`,`password`,`ch_name`) values
                                                            (1,'admin','123','gm'),
                                                            (2,'aaa','123','AAA');