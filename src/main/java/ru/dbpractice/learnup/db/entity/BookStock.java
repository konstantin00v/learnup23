package ru.dbpractice.learnup.db.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "book_stock")
@Getter
@Setter
public class BookStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_stock_id")
    private int book_stock_id;

    @Override
    public String toString() {
        return "BookStock{" +
                "book_stock_id=" + book_stock_id +
                ", book=" + book +
                ", count=" + count +
                '}';
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @Version
    int version;

    @Column(name = "count")
    private int count;

    public BookStock( Book book, int count) {
        this.book = book;
        this.count = count;
    }

    public BookStock() {
    }


}