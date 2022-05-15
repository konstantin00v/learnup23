package ru.dbpractice.learnup.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dbpractice.learnup.db.model.BookStock;


@Repository
public interface BookStockRepository extends JpaRepository<BookStock, Integer> {
}
