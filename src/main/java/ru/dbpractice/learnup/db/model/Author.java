package ru.dbpractice.learnup.db.model;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "author")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(name = "initials_author")
    private String initialsAuthor;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", initialsAuthor='" + initialsAuthor + '\'' +
                '}';
    }

    public Author() {
    }

    public Author(String name) {
        this.initialsAuthor = name;
    }
}
