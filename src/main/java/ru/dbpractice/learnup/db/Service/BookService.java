package ru.dbpractice.learnup.db.Service;
import ru.dbpractice.learnup.db.entity.Book;

import java.util.List;

public interface BookService {

     List<Book> getAllBooks();

     Book getBookById(int id);

     void saveBook(Book book);

     void deleteBook(int id);

}
