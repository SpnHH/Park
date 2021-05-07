CREATE TABLE codes (
    id UUID NOT NULL PRIMARY KEY,
    userId UUID NOT NULL,
    password VARCHAR(10) NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY(userId) REFERENCES users(id)

);
CREATE TABLE parkingspots(
    id UUID NOT NULL PRIMARY KEY
);