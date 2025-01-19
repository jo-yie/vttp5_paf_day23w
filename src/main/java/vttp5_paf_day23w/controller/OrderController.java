package vttp5_paf_day23w.controller;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vttp5_paf_day23w.model.Order;
import vttp5_paf_day23w.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/api/order/total/{order_id}")
    @ResponseBody
    public ResponseEntity<Object> getOrderJson(@PathVariable int order_id) { 

        Optional<Order> o = orderService.getOrderById(order_id);

        if (o.isPresent()) {

            return ResponseEntity.ok().body(o.get());

        } else {

            return ResponseEntity.status(400)
                                .body(Map.of("Error", "Order doesn't exist"));

        }

    }

    @GetMapping("/form")
    public String getOrderForm() { 

        return "form";

    }

    @GetMapping("/order/total")
    public String getOrderDetails(@RequestParam("order_id") int order_id, Model model) {

        Optional<Order> optional = orderService.getOrderById(order_id);
        if (optional.isPresent()) {

            Order order = optional.get();
            model.addAttribute("order", order);
            return "order-details";


        } else {
            return "order-not-found";

        }

    }
    
}
