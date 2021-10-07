package org.library.System.books;

import org.library.System.rents.RentHistory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BookController {
    @RequestMapping("/books")
    public static List<Book> readAllBooks() {
        return BookService.readAllBooks();
    }

    @RequestMapping("/books/{bookId}")
    public static Optional<Book> readBook(@PathVariable UUID bookId) {
        return BookService.readBook(bookId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public static void createBook(@RequestBody Book recent) {
        BookService.createBook(recent);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "books/{bookId")
    public static void updateBook(@PathVariable UUID bookId, @RequestBody Book recent) {
        BookService.updateBook(bookId, recent);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{bookId}")
    public static void delete(@PathVariable UUID bookId) {
        BookService.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "books/rent/{duration}")
    public void rent(@RequestBody RentHistory obj, @PathVariable long duration) {
        BookService.rent(obj.getUserId(), obj.getBookId(), duration);
    }

    @RequestMapping(method = RequestMethod.GET, value = "books/rent/{userId}/{rentId}")
    public Optional<RentHistory> getRent(@PathVariable UUID userId, @PathVariable UUID rentId) {
        return BookService.getRent(userId, rentId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "rent/{userId}/{rentId}/")
    public Object getUserAndBookInRent(@PathVariable UUID userId, @PathVariable UUID rentId) {
        return BookService.x(userId, rentId);
    }
}