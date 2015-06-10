package travelepsi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travelepsi.Entities.OrderEntity;
import travelepsi.Entities.PackageEntity;
import travelepsi.Services.PackageService;

import javax.persistence.criteria.Order;
import java.util.List;


@RestController
@RequestMapping("/packages")
public class PackageController {
    public PackageService packageService = new PackageService();

    @RequestMapping(method = RequestMethod.GET)
    public List<PackageEntity> getPackage() {
        List<PackageEntity> packages = packageService.getAll();
        return packages;
    }

    @RequestMapping(value = "/{id}/orders", method = RequestMethod.GET)
    public ResponseEntity<?> getOrders(@PathVariable Integer id) {
        List<OrderEntity> orders = packageService.getOrders(id);
        return new ResponseEntity<List<OrderEntity>>(orders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPackage(@PathVariable Integer id) {
        PackageEntity p = packageService.get(id);

        if (p == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<PackageEntity>(p, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPackage(@RequestBody PackageEntity p) {
        try {
            p = packageService.save(p);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<PackageEntity>(p, HttpStatus.CREATED);
    }
}