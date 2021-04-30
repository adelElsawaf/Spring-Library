package org.library.System.books;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private final UUID bookId = UUID.randomUUID();
    private UUID RenterId;
    private String bookName;
    private String authorName;
    private String category;
    private float price;
    private long rentDuration;

    public Book(String bookName, String authorName, String category, float price, long rentDuration) {
        this.setBookName(bookName);
        this.setAuthorName(authorName);
        this.setCategory(category);
        this.setPrice(price);
        this.setRentDuration(rentDuration);
    }

    public Book() {
    }

    public long getRentDuration() {
        return rentDuration;
    }

    public void setRentDuration(long rentDuration) {
        this.rentDuration = rentDuration;
    }

    public UUID getRenterId() {
        return RenterId;
    }

    public void setRenterId(UUID renterId) {
        this.RenterId = renterId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
