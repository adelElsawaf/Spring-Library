package org.library.System.rents;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class RentService {
    public static RentRepository rentRepository;
    @Autowired
    public RentService(RentRepository rentRepository){
        RentService.rentRepository=rentRepository;
    }
    public static void create(Rent recent){
        rentRepository.save(recent);
    }
    public static Optional<Rent> read(UUID rentId){
       return rentRepository.findById(rentId);
    }
}
