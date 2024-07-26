package org.swastik.orchiddewhotel.service;

import org.springframework.web.multipart.MultipartFile;
import org.swastik.orchiddewhotel.entity.Room;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public interface IRoomService {
    Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws IOException, SQLException;
}
