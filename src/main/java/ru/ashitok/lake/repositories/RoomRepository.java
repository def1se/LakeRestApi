package ru.ashitok.lake.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ashitok.lake.models.Room;
import ru.ashitok.lake.models.enums.Type;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Boolean existsById(int id);
    Room findById(int id);
}
