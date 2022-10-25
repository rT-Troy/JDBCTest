create table students
(
    id   int  not null
        primary key,
    name text not null,
    age  int  not null
);

INSERT INTO test.students (id, name, age) VALUES (1, 'name1', 18);
INSERT INTO test.students (id, name, age) VALUES (2, 'name2', 12);
INSERT INTO test.students (id, name, age) VALUES (3, 'name3', 21);
INSERT INTO test.students (id, name, age) VALUES (4, 'name4', 44);
