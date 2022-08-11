package one.digitalinnovation.parkingcloud.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinnovation.parkingcloud.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.parkingcloud.controller.dto.ParkingDTO;
import one.digitalinnovation.parkingcloud.controller.mapper.ParkingMapper;
import one.digitalinnovation.parkingcloud.model.Parking;
import one.digitalinnovation.parkingcloud.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Tag(name = "ParkingController")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }


    @GetMapping
    @Operation (description = "Find all parkings")
    public ResponseEntity<List<ParkingDTO>> findAll(){

        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @Operation (description = "findById")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id){

        Parking parking = parkingService.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @Operation (description = "Create")
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){

        var parkingCreate = parkingMapper.toParkingCreate(dto);
        var  parking = parkingService.create(parkingCreate);
        var  result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
