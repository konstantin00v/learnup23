package ru.dbpractice.learnup.db.Service;

import ru.dbpractice.learnup.db.model.BookStock;

import java.util.List;

public interface BookStockService {

     List<BookStock> getAllBooks();

     BookStock getBooksWarehouseById(int id);

     void saveBookWarehouse(BookStock booksWarehouse);

     void deleteBookWarehouse(int id);

}
