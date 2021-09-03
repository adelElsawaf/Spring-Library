package org.library.System.books_rent_history;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRentHistoryRepository extends CrudRepository<BookRentHistory, UUID> {



}
