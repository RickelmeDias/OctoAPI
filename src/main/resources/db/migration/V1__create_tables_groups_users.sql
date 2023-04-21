CREATE TABLE groups (
    id serial PRIMARY KEY,
    name VARCHAR (39) NOT NULL UNIQUE,
    description VARCHAR (254),
    permissions VARCHAR[],
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE users (
	id serial PRIMARY KEY,
	username VARCHAR (39) UNIQUE NOT NULL,
	password VARCHAR (60) NOT NULL,
	email VARCHAR (254) UNIQUE NOT NULL,
	group_id integer,
	created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_groups_on_users
    FOREIGN KEY (group_id)
    REFERENCES groups(id)
);