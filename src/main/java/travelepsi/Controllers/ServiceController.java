package travelepsi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travelepsi.Entities.ServiceEntity;
import travelepsi.Services.ServiceService;

import java.util.List;


@RestController
@RequestMapping("/services")

public class ServiceController {
    public ServiceService serviceService = new ServiceService();

    @RequestMapping(method = RequestMethod.GET)
    public List<ServiceEntity> getService() {
        List<ServiceEntity> services = serviceService.getAll();
        return services;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPackage(@PathVariable Integer id) {
        ServiceEntity service = serviceService.get(id);

        if (service == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ServiceEntity>(service, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPackage(@RequestBody ServiceEntity service) {
        try {
            service = serviceService.save(service);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ServiceEntity>(service, HttpStatus.CREATED);
    }
}
