package org.swastik.orchiddewhotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.swastik.orchiddewhotel.entity.Room;
import org.swastik.orchiddewhotel.repository.RoomRepository;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

@RequiredArgsConstructor
@Service
public class BookedRoomServiceImpl{

//    private final RoomRepository roomRepository;
//    @Override
//    public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) throws IOException, SQLException {
//        Room room = new Room();
//        room.setRoomType(roomType);
//        room.setRoomPrice(roomPrice);
//        if (!file.isEmpty()) {
//            byte[] photoBytes = file.getBytes();
//            Blob photoBlob = new SerialBlob(photoBytes);
//            room.setPhoto(photoBlob);
//        }
//        roomRepository.save(room);
//        return room;
//    }
}
