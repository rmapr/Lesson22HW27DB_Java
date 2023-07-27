create database lesson22hw27;
CREATE TABLE if not exists Homework (
                                        id int auto_increment primary key,
                                        name varchar(255),
                                        description varchar(1024)
);
CREATE TABLE if not exists Lesson (
                                      id int auto_increment primary key,
                                      name varchar(255),
                                      updatedAt timestamp,
                                      homework_id int,
                                      foreign key (homework_id) references homework (id)
);