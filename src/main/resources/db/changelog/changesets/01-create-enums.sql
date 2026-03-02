-- liquibase formatted sql

-- changeset ashitok:1
CREATE TYPE role AS ENUM ('USER', 'ADMIN', 'HOTEL_OWNER');

-- changeset ashitok:2
CREATE TYPE status AS ENUM ('PENDING', 'CONFIRMED', 'CANCELLED');

-- changeset ashitok:3
CREATE TYPE room_type AS ENUM ('STANDARD', 'LUX');