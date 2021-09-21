package org.library.System.books_rent_history;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface BookRentHistoryRepository extends CrudRepository<BookRentHistory, UUID> {
    @Query(value = "select books_rent_history.rent_id from books_rent_history \n" +
            "inner join books \n" +
            "on books_rent_history.book_id  = books.book_id \n" +
            "where \n" +
            "?1 between start_renting_date and end_renting_date \n" +
            "and \n" +
            "?2 = books.book_name ",nativeQuery = true)
    UUID getRentInDateRange(LocalDate now , String bookName);



}
