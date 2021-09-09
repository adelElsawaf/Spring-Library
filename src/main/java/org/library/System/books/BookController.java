package org.library.System.books;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping("/")
    public  List<Book> readAllBooks() {
        return BookService.readAllBooks();
    }

    @GetMapping("/{bookId}")
    public Optional<Book> readBook(@PathVariable UUID bookId) {
        return BookService.readBook(bookId);
    }

    @PostMapping("/")
    public void createBook(@RequestBody Book recent) {
        BookService.createBook(recent);
    }

    @PutMapping("/{bookId}")
    public void updateBook(@PathVariable UUID bookId, @RequestBody Book recent) {
        BookService.updateBook(bookId, recent);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable UUID bookId) {
        BookService.deleteBook(bookId);
    }
}