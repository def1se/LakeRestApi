-- liquibase formatted sql

-- changeset ashitok:7
CREATE TABLE IF NOT EXISTS bookings (
                                        id SERIAL PRIMARY KEY,
                                        date_in DATE NOT NULL,
                                        date_out DATE NOT NULL,
                                        status status NOT NULL DEFAULT 'PENDING',
                                        user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    room_id INTEGER NOT NULL REFERENCES rooms(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CHECK (date_out > date_in)
    );