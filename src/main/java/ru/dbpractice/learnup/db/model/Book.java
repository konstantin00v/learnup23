package ru.dbpractice.learnup.db.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    public Book(String title, Author author, int age, int count_page, int price) {
        this.title = title;
        this.author = author;
        this.age = age;
        this.count_page = count_page;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int book_id;

    @Column
    private String title;

    @Column
    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @Column
    private Integer age;

    @Column
    private int count_page;


    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", age=" + age +
                ", count_page=" + count_page +
                '}';
    }
}
