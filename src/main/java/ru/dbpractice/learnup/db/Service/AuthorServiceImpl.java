package ru.dbpractice.learnup.db.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbpractice.learnup.db.model.Author;
import ru.dbpractice.learnup.db.repository.AuthorRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(int id) {
        Author author = null;
        Optional<Author> a = authorRepository.findById(id);
        if (a.isPresent()) {
            author = a.get();
        }
        return author;
    }

    @Override
    public void saveAuthor(Author authors) {
        authorRepository.save(authors);
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}
