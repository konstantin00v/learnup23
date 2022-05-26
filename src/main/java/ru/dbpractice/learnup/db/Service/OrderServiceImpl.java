package ru.dbpractice.learnup.db.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import ru.dbpractice.learnup.db.entity.*;
import ru.dbpractice.learnup.db.repository.BookRepository;
import ru.dbpractice.learnup.db.repository.OrderRepository;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        Order order = null;
        Optional<Order> o = orderRepository.findById(id);
        if (o.isPresent()) {
            order = o.get();
        }
        return order;
    }
    @Lock(LockModeType.OPTIMISTIC)
    public void addOrder(int id, Client client, int count, BookStock bookStock) {
        if (bookStock.getCount() > 0) {
            bookRepository.deleteById(id);
        } else {
            System.out.println("К сожалению, книгу уже купили =(");
        }
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
