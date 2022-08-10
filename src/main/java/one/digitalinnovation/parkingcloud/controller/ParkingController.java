package one.digitalinnovation.parkingcloud.controller;


import one.digitalinnovation.parkingcloud.controller.dto.ParkingDTO;
import one.digitalinnovation.parkingcloud.controller.mapper.ParkingMapper;
import one.digitalinnovation.parkingcloud.model.Parking;
import one.digitalinnovation.parkingcloud.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }


    @GetMapping
    public List<ParkingDTO> findAll(){

        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return result;
    }

}
