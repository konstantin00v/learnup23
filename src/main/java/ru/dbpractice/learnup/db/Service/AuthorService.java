package ru.dbpractice.learnup.db.Service;

import ru.dbpractice.learnup.db.entity.Author;

import java.util.List;

public interface AuthorService {


     List<Author> getAllAuthors();

     Author getAuthorById(int id);

     void saveAuthor(Author authors);

     void deleteAuthor(int id);

}
