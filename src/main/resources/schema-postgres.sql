DROP TABLE IF EXISTS people;
CREATE TABLE people(
    id serial PRIMARY KEY,
    first_name VARCHAR(50),
    surname VARCHAR(50)
);

DROP TABLE IF EXISTS attendance;
CREATE TABLE attendance(
    id serial PRIMARY KEY,
    mandal VARCHAR(50),
    center VARCHAR(50),
    person_id Int,
    sabha_Date Date
);