package ru.dbpractice.learnup.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dbpractice.learnup.db.entity.Order;



@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
