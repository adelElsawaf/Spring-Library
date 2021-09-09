package org.library.System.books;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private final UUID bookId = UUID.randomUUID();
    private String bookName;
    private String authorName;
    private String category;
    private float rentPrice;
    @Column(name = "renter_id")
    private UUID renterID;

    public Book(String bookName, String authorName, String category, float rentPrice) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.category = category;
        this.rentPrice = rentPrice;
    }

    public Book() {
    }

    public float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(float rentPrice) {
        this.rentPrice = rentPrice;
    }

    public UUID getRenterID() {
        return renterID;
    }

    public void setRenterID(UUID renterID) {
        this.renterID = renterID;
    }

    public UUID getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String Category) {
        category = Category;
    }
}
