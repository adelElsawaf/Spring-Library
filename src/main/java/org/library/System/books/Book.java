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
    private String bookName;
    private String authorName;
    private String category;
    private float rentPrice;

    public Book(String bookName, String authorName, String category, float rentPrice) {
        this.setBookName(bookName);
        this.setAuthorName(authorName);
        this.setCategory(category);
        this.setRentPrice(rentPrice);
    }

    public Book() {
    }

    public float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(float rentPrice) {
        this.rentPrice = rentPrice;
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
