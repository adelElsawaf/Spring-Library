package org.library.System.books;

import org.library.System.book_rent.BookRentHistory;
import org.library.System.book_rent.BookRentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class BookService {
    private static BookRepository bookRepository;
    private static BookRentHistoryRepository bookRentHistoryRepository;

    @Autowired
    public BookService(BookRepository bookRepository, BookRentHistoryRepository bookRentHistoryRepository) {
        BookService.bookRepository = bookRepository;
        BookService.bookRentHistoryRepository = bookRentHistoryRepository;
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
            oldBook.setRenterId((recentBook.getRenterId()));
            oldBook.setRentDuration(recentBook.getRentDuration());
            oldBook.setPrice((recentBook.getPrice()));
            bookRepository.save(oldBook);
        }
    }

    public static void deleteBook(UUID bookId) {
        bookRepository.deleteById(bookId);
    }

    public static void rentBook(UUID bookId, UUID userId, long duration) {
        Optional<Book> optionalBook = readBook(bookId);
        if (optionalBook.isPresent()) {
            Book rentedBook = optionalBook.get();
            if (rentedBook.getRenterId() == null) {
                rentedBook.setRenterId(userId);
                rentedBook.setRentDuration(duration);
                bookRentHistoryRepository.save(new BookRentHistory(bookId, userId, duration,rentedBook.getPrice()));
            }
        }
    }
}
