CREATE TABLE sensors (
    id SERIAL PRIMARY KEY,
    parking_id INT REFERENCES parkings(id) NOT NULL,
    number INT NOT NULL,
    is_busy BOOLEAN NOT NULL DEFAULT FALSE
);