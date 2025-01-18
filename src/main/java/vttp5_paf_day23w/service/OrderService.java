package vttp5_paf_day23w.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp5_paf_day23w.model.Order;
import vttp5_paf_day23w.repo.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Optional<Order> getOrderById(int order_id) { 

        return orderRepo.getOrderById(order_id);

    }
    
}
