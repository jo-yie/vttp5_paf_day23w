package vttp5_paf_day23w.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vttp5_paf_day23w.service.OrderService;

@RestController
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/total/{order_id}")
    public ResponseEntity<Object> getOrderTotal(@PathVariable int order_id) { 

        return ResponseEntity.ok().body(orderService.getOrderById(order_id));

    }
    
}
