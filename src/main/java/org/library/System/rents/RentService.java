package org.library.System.rents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class RentService {
    private static RentRepository rentRepository;

    @Autowired
    public RentService(RentRepository rentRepository) {
        RentService.rentRepository = rentRepository;
    }

    public static void create(Rent recent) {
        rentRepository.save(recent);
    }

    public static Optional<Rent> read(UUID rentId) {
        return rentRepository.findById(rentId);
    }
}
