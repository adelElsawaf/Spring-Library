package org.library.System.books;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "books_rent_history")
public class RentHistory {
    @Id
    private final UUID rentId = UUID.randomUUID();
    private String bookName;
    private UUID userId;
    private String userName;
    private LocalDate startRentingDate = LocalDate.now();
    private LocalDate endRentingDate;
    private double rentPrice;

    public RentHistory() {
    }

    public RentHistory(UUID userId, LocalDate startRentingDate, LocalDate endRentingDate, UUID bookId, double rentPrice) {
        this.userId = userId;
        this.startRentingDate = startRentingDate;
        this.endRentingDate = endRentingDate;
        this.bookId = bookId;
        this.rentPrice = rentPrice;
    }

    public RentHistory(UUID bookId, String bookName, UUID userId, String userName, LocalDate startRentingDate, LocalDate endRentingDate, double rentPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.userId = userId;
        this.userName = userName;
        this.startRentingDate = startRentingDate;
        this.endRentingDate = endRentingDate;
        this.rentPrice = rentPrice;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    private UUID bookId;

    public UUID getRentId() {
        return rentId;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
