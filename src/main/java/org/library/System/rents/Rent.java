package org.library.System.rents;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "books_rent_history")
public class Rent {
    @Id
    private final UUID rentId = UUID.randomUUID();
    private UUID bookId;
    private UUID userId;
    private LocalDate startRentingDate;
    private LocalDate endRentingDate;
    private double rentPrice;

    public Rent() {
    }

    public Rent(UUID userId, LocalDate startRentingDate, LocalDate endRentingDate, UUID bookId, double rentPrice) {
        this.userId = userId;
        this.startRentingDate = startRentingDate;
        this.endRentingDate = endRentingDate;
        this.bookId = bookId;
        this.rentPrice = rentPrice;
    }


    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
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


    public LocalDate getStartRentingDate() {
        return startRentingDate;
    }

    public void setStartRentingDate(LocalDate startRentingDate) {
        this.startRentingDate = startRentingDate;
    }

    public LocalDate getEndRentingDate() {
        return endRentingDate;
    }

    public void setEndRentingDate(LocalDate endRentingDate) {
        this.endRentingDate = endRentingDate;
    }


}
