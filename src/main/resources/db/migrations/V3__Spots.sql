DROP TABLE parkingspots;

CREATE TABLE spots(
    id UUID NOT NULL PRIMARY KEY,
    spotnr int NOT NULL ,
    available boolean NOT NULL

);
