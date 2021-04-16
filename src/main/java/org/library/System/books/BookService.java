package org.library.System.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public static List readAllBooks() {
        List<Book> booksInfo = new ArrayList<>();
        bookRepository.findAll().forEach(booksInfo::add);
        return booksInfo;
    }

    public static Optional<Book> readBook(UUID bookId) {
        return bookRepository.findById(bookId);
    }

    public static void updateBook(UUID bookId, Book recentBook) {
        Optional<Book> oldBook = bookRepository.findById(bookId);
        oldBook.get().setBookName(recentBook.getBookName());
        oldBook.get().setAuthorName((recentBook.getAuthorName()));
        oldBook.get().setCategory(recentBook.getCategory());
        bookRepository.save(oldBook.get());
    }

    public static void deleteBook(UUID bookId) {
        bookRepository.deleteById(bookId);
    }
}
