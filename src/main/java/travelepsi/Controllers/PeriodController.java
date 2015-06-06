package travelepsi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travelepsi.Entities.PeriodEntity;
import travelepsi.Services.PeriodService;

import java.util.List;

/**
 * Created by benjaminsenechal on 28/05/15.
 */
@RestController
@RequestMapping("/api/periods")
public class PeriodController {
    public PeriodService periodService = new PeriodService();

    @RequestMapping(method = RequestMethod.GET)
    public List<PeriodEntity> getPeriods() {
        List<PeriodEntity> periods = periodService.getAll();
        return periods;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPeriod(@PathVariable Integer id) {
        PeriodEntity period = periodService.get(id);

        if (period == null) {
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<PeriodEntity>(period, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPeriod(@RequestBody PeriodEntity period) {
        try {
            period = periodService.save(period);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<PeriodEntity>(period, HttpStatus.CREATED);
    }
}
