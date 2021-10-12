package org.library.System.rents;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rent")
public class rentController {
    @GetMapping("/")
    public Optional<Rent> read(@PathVariable UUID rentId){
        return RentService.read(rentId);
    }
    @PostMapping("/")
    public void create(@RequestBody Rent recent)
    {
        RentService.create(recent);
    }
}
