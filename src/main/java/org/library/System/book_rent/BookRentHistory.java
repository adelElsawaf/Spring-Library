package org.library.System.book_rent;

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
    private float rentPrice;
    private LocalDate startRentingDate = LocalDate.now();
    private long rentDurationInDays;
    private LocalDate endRentingDate;

    public BookRentHistory(UUID bookId, UUID userId, long rentDurationInDays, float rentPrice) {
        this.bookId = bookId;
        this.userId = userId;
        this.rentDurationInDays = rentDurationInDays;
        this.endRentingDate = startRentingDate.plusDays(rentDurationInDays);
        this.rentPrice = rentPrice;
    }

    public BookRentHistory() {
    }

    public float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(long rentPrice) {
        this.rentPrice = rentPrice;
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
