package vttp5_paf_day23w.restController;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vttp5_paf_day23w.model.Order;
import vttp5_paf_day23w.service.OrderService;

@RestController
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/total/{order_id}")
    public ResponseEntity<Object> getOrderTotal(@PathVariable int order_id) { 

        Optional<Order> o = orderService.getOrderById(order_id);

        if (o.isPresent()) {

            return ResponseEntity.ok().body(o.get());

        } else {

            return ResponseEntity.status(400)
                                .body(Map.of("Error", "Order doesn't exist"));

        }

    }
    
}
