CREATE TABLE publications (
    user_author_id INTEGER NOT NULL,
	title VARCHAR(254) NOT NULL,
	body TEXT NOT NULL,
	slug VARCHAR(508) NOT NULL,
	username_author VARCHAR (39) NOT NULL,
	category VARCHAR (39) NOT NULL,
	sub_category VARCHAR (39) NOT NULL,
	tags VARCHAR[3],
	is_active BOOLEAN NOT NULL,
	created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP,
    CONSTRAINT fk_users_on_publications
    FOREIGN KEY (user_author_id)
    REFERENCES users(id),
    PRIMARY KEY(username_author, slug)
);