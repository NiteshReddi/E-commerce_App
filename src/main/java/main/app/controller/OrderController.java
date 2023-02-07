package main.app.controller;

import main.app.entity.Orders;
import main.app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/getOrderDetailsByCustomerId/{id}")
    private List<Orders> getOrderDetailsByCustomerId(@PathVariable("id") Long id){
        List<Orders> order = orderRepository.findByCustomerId(1L);
        // List<Order> order = orderRepository.getById(customerID);
        return order;
    }

//    @GetMapping("/getOrderByID/{id}")
//    public Order getOrderByID(@PathVariable("id") Long id) {
//        Order order = orderRepository.findById(id).get();
//        return order;
//    }

}
