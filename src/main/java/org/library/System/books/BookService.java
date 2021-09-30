package org.library.System.books;

import org.library.System.User.User;
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
    private static RentHistoryRepository rentHistoryRepository;

    @Autowired
    public BookService(BookRepository bookRepository,RentHistoryRepository rentHistoryRepository) {
        BookService.bookRepository = bookRepository;
        BookService.rentHistoryRepository=rentHistoryRepository;
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
            bookRepository.save(oldBook);
        }
    }

    public static void deleteBook(UUID bookId) {
        bookRepository.deleteById(bookId);
    }
    public static String rent(UUID renterId ,String bookName,long rentDuration ){
        Book neededBook = bookRepository.getBookByName(bookName);
        RentHistory rentedBook = rentHistoryRepository.getRentInDateRange(LocalDate.now(),bookName);
        if(neededBook == null)
        {
            return "there is no book  by this name ";
        }
        else if (rentedBook != null)
        {
            return "Book is already rented";
        }
        else
        {
            rentHistoryRepository.save(new RentHistory(renterId,LocalDate.now(),LocalDate.now().plusDays(rentDuration),neededBook.getBookId(),neededBook.getRentPrice()));
            return "book rented successfully";
        }
    }
}
