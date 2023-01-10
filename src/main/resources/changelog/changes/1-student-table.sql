--liquibase formatted sql

--changeset renars:1

CREATE TABLE tutors
(
    tutor_id long primary key,
    name     varchar(255) not null,
    surname  varchar(255) not null

);
CREATE TABLE courses
(
    course_id  long primary key,
    courseName varchar(255) unique not null,
    tutor      varchar(255)        not null

);

CREATE TABLE students
(
    student_id int primary key,
    name       varchar(255) not null,
    surname    varchar(255) not null,
    courseName varchar(255) not null


);
CREATE TABLE course_attending
(
    student_id int,
    course_id  int,
    CONSTRAINT student_id_foreign_key FOREIGN KEY (student_id) references students (student_id),
    CONSTRAINT course_id_foreign_key FOREIGN KEY (course_id) references courses (course_id)

);
