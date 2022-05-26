package ru.dbpractice.learnup.db.Service;

import ru.dbpractice.learnup.db.entity.BookStock;
import ru.dbpractice.learnup.db.entity.Client;
import ru.dbpractice.learnup.db.entity.Order;

import java.util.List;

public interface OrderService {

     List<Order> getAllOrder();

     Order getOrderById(int id);

     void saveOrder(Order order);

     void deleteOrder(int id);

     void addOrder(int id, Client client, int count, BookStock bookStock);
}
