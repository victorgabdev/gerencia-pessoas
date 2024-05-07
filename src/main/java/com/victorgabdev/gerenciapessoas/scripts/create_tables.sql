CREATE TABLE Person (
                        person_id SERIAL PRIMARY KEY,
                        fullName VARCHAR(255) NOT NULL,
                        birthDate DATE NOT NULL
);

CREATE TABLE Address (
                         address_id SERIAL PRIMARY KEY,
                         street VARCHAR(255) NOT NULL,
                         zipCode VARCHAR(20) NOT NULL,
                         address_number VARCHAR(20),
                         city VARCHAR(100) NOT NULL,
                         address_state VARCHAR(100) NOT NULL,
                         primary_address BOOLEAN NOT NULL,
                         person_id INT,
                         CONSTRAINT fk_person
                             FOREIGN KEY(person_id)
                                 REFERENCES Person(person_id)
);