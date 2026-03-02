-- liquibase formatted sql

-- changeset ashitok:5
CREATE TABLE IF NOT EXISTS hotels (
                                      id SERIAL PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL,
    address TEXT NOT NULL,
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );