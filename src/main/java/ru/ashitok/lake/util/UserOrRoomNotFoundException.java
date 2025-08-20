package ru.ashitok.lake.util;

public class UserOrRoomNotFoundException extends RuntimeException {
    public UserOrRoomNotFoundException(String message) {
        super(message);
    }
}
