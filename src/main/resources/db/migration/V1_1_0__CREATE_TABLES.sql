CREATE TABLE IF NOT EXISTS users (

    user_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_name VARCHAR(64) UNIQUE,
    role_id BIGINT,
    status_id BIGINT

);


CREATE TABLE IF NOT EXISTS tasks (

    task_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    title VARCHAR(255)

);


CREATE TABLE IF NOT EXISTS teams (

    team_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)

);


CREATE TABLE IF NOT EXISTS user_teams (

    user_id BIGINT,
    team_id BIGINT

);


CREATE TABLE IF NOT EXISTS user_tasks (

    user_id BIGINT,
    task_id BIGINT

);


CREATE TABLE IF NOT EXISTS team_tasks (

    team_id BIGINT,
    task_id BIGINT

);

CREATE TABLE IF NOT EXISTS status (

    status_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)

);


CREATE TABLE IF NOT EXISTS roles (

    role_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)

);


CREATE TABLE IF NOT EXISTS role_permissions (

    permission_id BIGINT,
    role_id BIGINT

);


CREATE TABLE IF NOT EXISTS permissions (

    permission_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)

);