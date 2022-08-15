package one.digitalinnovation.parkingcloud.repository;

import one.digitalinnovation.parkingcloud.model.Parking;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface ParkingRepository extends JpaRepository<Parking, String> {
}

