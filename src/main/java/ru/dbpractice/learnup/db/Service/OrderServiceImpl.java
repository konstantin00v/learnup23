package ru.dbpractice.learnup.db.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbpractice.learnup.db.model.Order;
import ru.dbpractice.learnup.db.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

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

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}