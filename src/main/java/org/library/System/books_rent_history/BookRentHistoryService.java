package org.library.System.books_rent_history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookRentHistoryService {
    private static BookRentHistoryRepository bookRentHistoryRepository;

    @Autowired
    public BookRentHistoryService(BookRentHistoryRepository bookRentHistoryRepository) {
        BookRentHistoryService.bookRentHistoryRepository = bookRentHistoryRepository;
    }

    public BookRentHistoryService() {
    }

    public static void create(BookRentHistory bookRentInformation) {
        bookRentHistoryRepository.save(bookRentInformation);
    }

}
