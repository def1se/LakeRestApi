-- liquibase formatted sql

-- changeset ashitok:6
CREATE TABLE IF NOT EXISTS rooms (
                                     id SERIAL PRIMARY KEY,
                                     type room_type NOT NULL DEFAULT 'STANDARD',
                                     price DECIMAL(10,2) NOT NULL CHECK (price > 0),
    is_available BOOLEAN DEFAULT true,
    hotel_id INTEGER NOT NULL REFERENCES hotels(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );