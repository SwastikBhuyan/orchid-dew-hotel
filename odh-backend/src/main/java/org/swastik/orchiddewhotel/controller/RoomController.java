package org.swastik.orchiddewhotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.swastik.orchiddewhotel.entity.Room;
import org.swastik.orchiddewhotel.response.RoomResponse;
import org.swastik.orchiddewhotel.service.IRoomService;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@RequiredArgsConstructor
@RequestMapping("/rooms")
@RestController
public class RoomController {

    private final IRoomService roomService;
    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse> addNewRoom(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("roomType") String roomType,
            @RequestParam("roomPrice") BigDecimal roomPrice) throws SQLException, IOException {
        Room savedRoom = roomService.addNewRoom(photo, roomType, roomPrice);
        RoomResponse roomResponse = new RoomResponse(
                savedRoom.getId(),
                savedRoom.getRoomType(),
                savedRoom.getRoomPrice());
        return ResponseEntity.ok(roomResponse);
    }
}
