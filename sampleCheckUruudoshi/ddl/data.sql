DROP DATABASE IF EXISTS login_app;
CREATE DATABASE login_app;

USE login_app;

DROP TABLE IF EXISTS user;

CREATE TABLE user(
    user_id INT AUTO_INCREMENT,
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(2),
    PRIMARY KEY(user_id)
);

INSERT INTO user (username, password, role) VALUES
(
    'user',
    'password',
    '1'
),
(
    'tomida',
    'junichi',
    '0'
);