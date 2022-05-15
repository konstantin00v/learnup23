package ru.dbpractice.learnup.db.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbpractice.learnup.db.model.BookStock;
import ru.dbpractice.learnup.db.repository.BookStockRepository;
import java.util.List;
import java.util.Optional;

@Service
public class BookStockServiceImpl implements BookStockService {
    @Autowired
    public BookStockRepository booksStockRepository;

    @Override
    public List<BookStock> getAllBooks() {
        return booksStockRepository.findAll();
    }

    @Override
    public BookStock getBooksWarehouseById(int id) {
        BookStock booksWarehouse = null;
        Optional<BookStock> b = booksStockRepository.findById(id);
        if (b.isPresent()) {
            booksWarehouse = b.get();
        }
        return booksWarehouse;
    }

    @Override
    public void saveBookWarehouse(BookStock booksWarehouse) {
        booksStockRepository.save(booksWarehouse);
    }

    @Override
    public void deleteBookWarehouse(int id) {
        booksStockRepository.deleteById(id);
    }
}
