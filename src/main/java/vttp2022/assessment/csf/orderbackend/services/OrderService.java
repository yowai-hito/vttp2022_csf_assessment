package vttp2022.assessment.csf.orderbackend.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vttp2022.assessment.csf.orderbackend.models.CsfResponse;
import vttp2022.assessment.csf.orderbackend.models.Order;
import vttp2022.assessment.csf.orderbackend.models.OrderSummary;
import vttp2022.assessment.csf.orderbackend.models.PizzaOrderRequest;
import vttp2022.assessment.csf.orderbackend.repositories.OrderRepository;

import static vttp2022.assessment.csf.orderbackend.configs.BackendConstants.*;

@Service
public class OrderService {

	@Autowired
	private PricingService priceSvc;

	@Autowired
	private OrderRepository orderRepo;

	public ResponseEntity<CsfResponse> postPizzaOrder (PizzaOrderRequest req) {
		CsfResponse responseBody = new CsfResponse();
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus responseStatus = HttpStatus.resolve(200);

        responseHeaders.set("Content-Type", APPLICATION_JSON);
        responseHeaders.set("Accept", APPLICATION_JSON);
		try {
			createOrder(populateOrder(req));
			responseBody.setData("Success, order has been successfully added");
		} catch (Exception e) {
			responseBody.setStatus(FAIL_STATUS);
			responseBody.setError(e.getMessage());
		}
        return new ResponseEntity<>(responseBody, responseHeaders, responseStatus);
	}

	// POST /api/order
	// Create a new order by inserting into orders table in pizzafactory database
	// IMPORTANT: Do not change the method's signature
	public void createOrder(Order order) {
		orderRepo.insertPizzaOrder(order);
	}

	private Order populateOrder(PizzaOrderRequest req) {
		Order pizzaOrder = new Order();
		pizzaOrder.setName(req.getUserName());
		pizzaOrder.setEmail(req.getUserEmail());
		pizzaOrder.setSize(req.getUserPizzaSize());
		pizzaOrder.setSauce(req.getUserPizzaSauce());
		if (req.getUserPizzaBase().equals("thick")){
			pizzaOrder.setThickCrust(true);
		}
		pizzaOrder.setToppings(req.getUserPizzaToppings().toLinkedList());
		return pizzaOrder;
	}

	// public JSONObject getOrdersByEmailJson(String email) {
	// 	List<OrderSummary> orders = getOrdersByEmail(email);

	// }

	// GET /api/order/<email>/all
	// Get a list of orders for email from orders table in pizzafactory database
	// IMPORTANT: Do not change the method's signature
	public List<OrderSummary> getOrdersByEmail(String email) {
		// Use priceSvc to calculate the total cost of an order
		return this.orderRepo.getPizzaOrdersByEmail(email);
	}
}
