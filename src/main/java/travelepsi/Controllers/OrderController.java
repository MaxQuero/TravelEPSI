package travelepsi.Controllers;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import travelepsi.Entities.OrderEntity;
import travelepsi.Entities.PackageEntity;
import travelepsi.Entities.PeriodEntity;
import travelepsi.Entities.ServiceEntity;
import travelepsi.Services.OrderService;
import travelepsi.Services.PackageService;
import travelepsi.Services.PeriodService;
import travelepsi.Services.ServiceService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/orders")

public class OrderController {
    public OrderService orderService = new OrderService();
    public PackageService packageService = new PackageService();
    public PeriodService periodService = new PeriodService();
    public ServiceService serviceService = new ServiceService();

    @RequestMapping(method = RequestMethod.GET)
    public List<OrderEntity> getOrders() {
        List<OrderEntity> orders = orderService.getAll();
        return orders;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addOrder(@RequestBody OrderEntity order) {
        try {
            PackageEntity pck = packageService.get(order.getPackage_id());
            order.setPckage(pck);

            ServiceEntity service = serviceService.getService(order.getService_id());
            order.setService(service);

            order = orderService.save(order);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<OrderEntity>(order, HttpStatus.CREATED);
    }
}
