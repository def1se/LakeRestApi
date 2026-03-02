-- liquibase formatted sql

-- changeset ashitok:8
CREATE TABLE IF NOT EXISTS reviews (
                                       id SERIAL PRIMARY KEY,
                                       text TEXT,
                                       rating DECIMAL(2,1) NOT NULL CHECK (rating >= 0 AND rating <= 5),
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    hotel_id INTEGER NOT NULL REFERENCES hotels(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );