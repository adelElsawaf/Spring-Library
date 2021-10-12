package org.library.System.rents;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface RentRepository extends CrudRepository<Rent, UUID> {
    @Query(value = "select *  from books_rent_history \n" +
            "inner join books \n" +
            "on books_rent_history.book_id  = books.book_id \n" +
            "where \n" +
            "?1 between start_renting_date and end_renting_date \n" +
            "and \n" +
            "?2 = books.book_id ",nativeQuery = true)
    Rent getRentInDateRange(LocalDate now , UUID bookName);
}
