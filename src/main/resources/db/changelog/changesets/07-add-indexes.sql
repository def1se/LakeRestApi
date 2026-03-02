-- liquibase formatted sql

-- changeset ashitok:9
CREATE INDEX idx_users_email ON users(email);

-- changeset ashitok:10
CREATE INDEX idx_hotels_user_id ON hotels(user_id);

-- changeset ashitok:11
CREATE INDEX idx_rooms_hotel_id ON rooms(hotel_id);

-- changeset ashitok:12
CREATE INDEX idx_bookings_user_id ON bookings(user_id);

-- changeset ashitok:13
CREATE INDEX idx_bookings_room_id ON bookings(room_id);

-- changeset ashitok:14
CREATE INDEX idx_reviews_user_id ON reviews(user_id);

-- changeset ashitok:15
CREATE INDEX idx_reviews_hotel_id ON reviews(hotel_id);