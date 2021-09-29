package org.library.System.books;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RentHistoryRepository extends CrudRepository<RentHistory, UUID> {
}
