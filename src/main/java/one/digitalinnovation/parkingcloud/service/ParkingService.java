package one.digitalinnovation.parkingcloud.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import one.digitalinnovation.parkingcloud.exception.ParkingNotFoundException;
import one.digitalinnovation.parkingcloud.model.Parking;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import one.digitalinnovation.parkingcloud.repository.ParkingRepository;


import org.springframework.transaction.annotation.Transactional;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Transactional(readOnly = true)
    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Parking findById(String id) {
        return parkingRepository.findById(id).orElseThrow(
                () -> new ParkingNotFoundException(id));
    }

    @Transactional
    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);
        return parkingCreate;
    }

    @Transactional
    public void delete(String id) {
        findById(id);
        parkingRepository.deleteById(id);
    }
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
