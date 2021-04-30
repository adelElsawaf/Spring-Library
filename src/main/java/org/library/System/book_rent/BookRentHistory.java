package org.library.System.book_rent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "books_rent_history")
public class BookRentHistory {
    @Id
    private final UUID rentId = UUID.randomUUID();
    private UUID bookId;
    private UUID userId;
    private LocalDate startRentingDate = LocalDate.now();
    private long rentDurationInDays;
    private LocalDate endRentingDate;

    public BookRentHistory(UUID bookId, UUID userId, long rentDurationInDays) {
        this.bookId = bookId;
        this.userId = userId;
        this.rentDurationInDays = rentDurationInDays;
        this.endRentingDate = startRentingDate.plusDays(rentDurationInDays);
    }

    public BookRentHistory() {
    }

    public UUID getRentId() {
        return rentId;
    }

    public long getRentDurationInDays() {
        return rentDurationInDays;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public LocalDate getStartRentingDate() {
        return startRentingDate;
    }

    public LocalDate getEndRentingDate() {
        return endRentingDate;
    }

}
