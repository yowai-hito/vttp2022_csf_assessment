package vttp2022.assessment.csf.orderbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.assessment.csf.orderbackend.models.CsfResponse;
import vttp2022.assessment.csf.orderbackend.models.OrderSummary;
import vttp2022.assessment.csf.orderbackend.models.PizzaOrderRequest;
import vttp2022.assessment.csf.orderbackend.services.OrderService;

@RestController
@RequestMapping(path="/api")
public class OrderRestController {

    private OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) { 
        this.orderService = orderService;
    } 
    
    @CrossOrigin
    @PostMapping(path="/order")
    public ResponseEntity<CsfResponse> doRegistration(@RequestBody PizzaOrderRequest req) {
        return this.orderService.postPizzaOrder(req);
    }

    @CrossOrigin
    @GetMapping(path="/order/{email}/all")
    public List<OrderSummary> getOrdersByEmail(@PathVariable String email) {
        return this.orderService.getOrdersByEmail(email);
    }
}
