package org.library.System.rents;

import org.library.System.books.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rent")
public class RentController {
    @GetMapping("/{rentId}")
    public Optional<Rent> read(@PathVariable UUID rentId) {
        return RentService.read(rentId);
    }

    @PostMapping("/{duration}")
    public String create(@RequestBody Rent recent, @PathVariable long duration) {
        return BookService.rent(recent.getUserId(), recent.getBookId(), duration);
    }
    @DeleteMapping("/{rentId}")
    public void delete(@PathVariable UUID rentId){
        RentService.delete(rentId);
    }
}
