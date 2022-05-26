package ru.dbpractice.learnup.db.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbpractice.learnup.db.entity.Book;
import ru.dbpractice.learnup.db.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        Book book = null;
        Optional<Book> b = bookRepository.findById(id);
        if (b.isPresent()) {
            book = b.get();
        }
        return book;
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);

    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);

    }


}