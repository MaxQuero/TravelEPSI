package travelepsi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import travelepsi.Entities.OrderEntity;
import travelepsi.Services.OrderService;
import travelepsi.Services.PeriodService;

import java.util.List;

/**
 * Created by benjaminsenechal on 06/06/15.
 */
@RestController
@RequestMapping("/orders")

public class OrderController {
    public OrderService orderService = new OrderService();

    @RequestMapping(method = RequestMethod.GET)
    public List<OrderEntity> getOrders() {
        List<OrderEntity> orders = orderService.getAll();
        return orders;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addOrder(@RequestBody OrderEntity order) {
        try {
            order = orderService.save(order);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<OrderEntity>(order, HttpStatus.CREATED);
    }
}
