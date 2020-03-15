CREATE TABLE parkings(
	id SERIAL PRIMARY KEY,
	description VARCHAR(255) NOT NULL,
	capacity INT NOT NULL,
	current_fullness INT NOT NULL DEFAULT 0
);