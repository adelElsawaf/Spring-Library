package org.library.System.books;

import jdk.vm.ci.meta.Local;
import org.library.System.books_rent_history.BookRentHistory;
import org.library.System.books_rent_history.BookRentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class BookService {
    private static BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        BookService.bookRepository = bookRepository;
    }

    public static void createBook(Book recent) {
        bookRepository.save(recent);
    }

    public static List<Book> readAllBooks() {
        List<Book> booksInfo = new ArrayList<>();
        bookRepository.findAll().forEach(booksInfo::add);
        return booksInfo;
    }

    public static Optional<Book> readBook(UUID bookId) {
        return bookRepository.findById(bookId);
    }

    public static void updateBook(UUID bookId, Book recentBook) {
        Optional<Book> oldOptionalBook = bookRepository.findById(bookId);
        if (oldOptionalBook.isPresent()) {
            Book oldBook = oldOptionalBook.get();
            oldBook.setBookName(recentBook.getBookName());
            oldBook.setAuthorName((recentBook.getAuthorName()));
            oldBook.setCategory(recentBook.getCategory());
            oldBook.setRentPrice(recentBook.getRentPrice());
            oldBook.setRenterID(recentBook.getRenterID());
            bookRepository.save(oldBook);
        }
    }

    public static void deleteBook(UUID bookId) {
        bookRepository.deleteById(bookId);
    }
    public static String rentBook(UUID renterID, String bookName, long rentDuration)
    {
        Book rentedBook = bookRepository.getBookByName(bookName);
        if(rentedBook == null)
        {
            return "Book doesn't exist ";
        }
        else if (rentedBook.getRenterID() != null)
        {
            return "Book is already rented";
        }
        else {
            rentedBook.setRenterID(renterID);
            BookService.updateBook(rentedBook.getBookId(),rentedBook);
            BookRentHistoryService.create(new BookRentHistory(rentedBook.getBookId(),renterID,rentDuration,rentedBook.getRentPrice()));
            return "book Rented successfully";
        }
    }
}
