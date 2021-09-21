package org.library.System.books_rent_history;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "books_rent_history")
@Table(name = "books_rent_history")
public class BookRentHistory {
    @Id
    private final UUID rentId = UUID.randomUUID();
    private UUID bookId;
    private UUID userId;
    private float rentPrice;
    private LocalDate startRentingDate;
    private long rentDurationInDays;
    private LocalDate endRentingDate;

    public BookRentHistory() {
    }

    public BookRentHistory(UUID bookId, UUID userId, long rentDurationInDays, float rentPrice) {
        this.bookId = bookId;
        this.userId = userId;
        this.startRentingDate = LocalDate.now();
        this.rentDurationInDays = rentDurationInDays;
        this.endRentingDate = startRentingDate.plusDays(rentDurationInDays);
        this.rentPrice = rentPrice;
    }

    public UUID getRentId() {
        return rentId;
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

    public float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(float rentPrice) {
        this.rentPrice = rentPrice;
    }

    public LocalDate getStartRentingDate() {
        return startRentingDate;
    }

    public void setStartRentingDate(LocalDate startRentingDate) {
        this.startRentingDate = startRentingDate;
    }

    public long getRentDurationInDays() {
        return rentDurationInDays;
    }

    public void setRentDurationInDays(long rentDurationInDays) {
        this.rentDurationInDays = rentDurationInDays;
    }

    public LocalDate getEndRentingDate() {
        return endRentingDate;
    }

    public void setEndRentingDate(LocalDate endRentingDate) {
        this.endRentingDate = endRentingDate;
    }
}
