package ru.dbpractice.learnup.db.model;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "book_stock")
@Getter
@Setter
public class BookStock {

    @Id
    @Column(name = "stock")
    private int stock;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @Override
    public String toString() {
        return "BookStock{" +
                "stock=" + stock +
                ", book=" + book +
                '}';
    }

    public BookStock() {
    }

    public BookStock(int stock, Book book) {
        this.stock = stock;
        this.book = book;
    }
}