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

INSERT INTO groups(name, description, permissions, created_at, updated_at)
VALUES  ('SUPER', 'This is the super, he can do all actions and access all routes. It is for gods.', '{ ROLE_SUPER:DO:ALL }', NOW(), NOW()),
        ('ADMIN', 'This is the admin, he can do administrative things. It is for admins.', '{ ROLE_READ:PUBLICATION, ROLE_WRITE:PUBLICATION}', NOW(), NOW()),
        ('USER', 'This is the user, he can do common things. It is for common and new users.', '{ ROLE_READ:PUBLICATION, ROLE_WRITE:PUBLICATION}', NOW(), NOW());