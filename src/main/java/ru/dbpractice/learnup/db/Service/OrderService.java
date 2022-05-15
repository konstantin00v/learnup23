package ru.dbpractice.learnup.db.Service;

import ru.dbpractice.learnup.db.model.Order;

import java.util.List;

public interface OrderService {

     List<Order> getAllOrder();

     Order getOrderById(int id);

     void saveOrder(Order order);

     void deleteOrder(int id);
}
