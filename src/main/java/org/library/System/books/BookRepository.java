package org.library.System.books;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends CrudRepository<Book, UUID> {
    @Query(value = "select * from books where books.book_name = ?1 ",nativeQuery = true)
    Book getBookByName(String bookName);
}
