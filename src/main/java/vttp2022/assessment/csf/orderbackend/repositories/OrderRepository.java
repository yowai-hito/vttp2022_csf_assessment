package vttp2022.assessment.csf.orderbackend.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.assessment.csf.orderbackend.models.Order;
import vttp2022.assessment.csf.orderbackend.models.OrderSummary;
import vttp2022.assessment.csf.orderbackend.services.PricingService;

import static vttp2022.assessment.csf.orderbackend.configs.BackendConstants.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    
    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    PricingService pricingSvc;

    private Logger LOG = LoggerFactory.getLogger(OrderRepository.class.getName());

    public Integer insertPizzaOrder(Order order) {
        return jdbc.update(SQL_INSERT_PIZZA_ORDER,
        order.getName(), order.getEmail(), order.getSize(), order.isThickCrust(),
        order.getSauce(), 
        order.getToppings().toString().substring(1,order.getToppings().toString().length()-1), order.getComments());
    }

    public List<OrderSummary> getPizzaOrdersByEmail(String email) {
        List<OrderSummary> orders = new ArrayList<>();
        return jdbc.query(SQL_GET_ORDERS_BY_EMAIL, 
        (ResultSet rs) -> {
            while (rs.next()){
                Float cost = 0.0f;
                OrderSummary summary = new OrderSummary();
                summary.setEmail(email);
                summary.setName(rs.getString("name"));
                summary.setOrderId(rs.getInt("order_id"));
                String[] toppings = rs.getString("toppings").split(",",0);
                cost += this.pricingSvc.size(rs.getInt("pizza_size"));
                cost += this.pricingSvc.sauce(rs.getString("sauce"));
                for (String topping : toppings) {
                    cost += this.pricingSvc.topping(topping);
                }
                if (rs.getBoolean("thick_crust")) {cost += this.pricingSvc.thickCrust();}
                else {cost += this.pricingSvc.thinCrust();}
                summary.setAmount(cost);
                orders.add(summary);
            }
            return orders;
        },
        email);
    }
}
