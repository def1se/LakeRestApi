-- liquibase formatted sql

-- changeset ashitok:16 context:dev
-- Добавляем тестовых пользователей (пароль захеширован - 'password')
INSERT INTO users (email, password, role) VALUES
                                              ('admin@lake.com', '$2a$10$YourHashedPasswordHere', 'ADMIN'),
                                              ('user@lake.com', '$2a$10$YourHashedPasswordHere', 'USER'),
                                              ('owner@lake.com', '$2a$10$YourHashedPasswordHere', 'HOTEL_OWNER')
    ON CONFLICT (email) DO NOTHING;

-- changeset ashitok:17 context:dev
-- Добавляем тестовые отели
INSERT INTO hotels (name, address, user_id) VALUES
                                                ('Grand Hotel', 'Moscow, Red Square 1', 3),
                                                ('Sea View Resort', 'Sochi, Seaside 25', 3)
    ON CONFLICT DO NOTHING;

-- changeset ashitok:18 context:dev
-- Добавляем тестовые комнаты
INSERT INTO rooms (type, price, hotel_id) VALUES
                                              ('LUX', 15000.00, 1),
                                              ('STANDARD', 5000.00, 1),
                                              ('LUX', 20000.00, 2),
                                              ('STANDARD', 7000.00, 2)
    ON CONFLICT DO NOTHING;

-- changeset ashitok:19 context:dev
-- Добавляем тестовые бронирования
INSERT INTO bookings (date_in, date_out, user_id, room_id, status) VALUES
                                                                       ('2024-06-01', '2024-06-05', 2, 1, 'CONFIRMED'),
                                                                       ('2024-07-10', '2024-07-15', 2, 3, 'PENDING')
    ON CONFLICT DO NOTHING;

-- changeset ashitok:20 context:dev
-- Добавляем тестовые отзывы
INSERT INTO reviews (text, rating, user_id, hotel_id) VALUES
                                                          ('Отличный отель!', 5.0, 2, 1),
                                                          ('Хорошее соотношение цена/качество', 4.5, 2, 2)
    ON CONFLICT DO NOTHING;