package travelepsi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travelepsi.Entities.TownEntity;
import travelepsi.Services.TownService;

import java.util.List;

@RestController
@RequestMapping("/towns")
public class TownController {

    public TownService townService = new TownService();

    @RequestMapping(method = RequestMethod.GET)
    public List<TownEntity> getTowns() {
        List<TownEntity> towns = townService.getAll();
        return towns;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTown(@PathVariable Integer id) {
        TownEntity town = townService.get(id);

        if (town == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<TownEntity>(town, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addTown(@RequestBody TownEntity town) {
        try {
            town = townService.save(town);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<TownEntity>(town, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTown(@PathVariable Integer id, @RequestBody TownEntity town) {
        TownEntity base = townService.get(id);

        if (town == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }

        try {
            town = townService.update(base.merge(town));
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<TownEntity>(town, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTown(@PathVariable Integer id) {
        TownEntity town = townService.get(id);

        if (town == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }

        try {
            townService.delete(town);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    }

}
