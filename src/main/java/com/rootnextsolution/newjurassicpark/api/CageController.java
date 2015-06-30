package com.rootnextsolution.newjurassicpark.api;

import com.rootnextsolution.newjurassicpark.model.Cage;
import com.rootnextsolution.newjurassicpark.model.PowerStatus;
import com.rootnextsolution.newjurassicpark.model.CageRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

/**
 * Created by tahmid.tanzim on 6/30/15.
 */
@RestController
@RequestMapping(value = "api/cage")
public class CageController {
    @Autowired
    CageRepository cageRepository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Iterable<Cage> get() {
        return cageRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public Cage get(@PathVariable("id") Integer id) {
        return cageRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Cage create(Cage cage) {
        cageRepository.save(cage);
        return cage;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cage createFromJson(@RequestBody Cage Cage) {
        cageRepository.save(Cage);
        return Cage;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST,produces = "application/json", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Cage update(@PathVariable(value = "id") Integer id, @RequestParam(value = "maxCapacity", required = false) Integer maxCapacity, @RequestParam(value = "powerStatus", required = false) String powerStatus) throws Exception {
        Cage cage = cageRepository.findOne(id);
        if (maxCapacity != null) {
            cage.setMaximumCapacity(maxCapacity);
        }
        if (powerStatus != null) {
            cage.setPowerStatus(PowerStatus.valueOf(powerStatus));
        }
         cageRepository.save(cage);
         return cage;
     }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT,produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cage updateFromJson(@PathVariable(value = "id") Integer id, @RequestBody(required = true) String jsonString) throws ParseException, Exception {
         Cage cage = cageRepository.findOne(id);
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonString);
        Integer maxCapacity = (Integer) jsonObject.get("maxCapacity");
        String powerStatus = (String) jsonObject.get("powerStatus");
         if (maxCapacity != null) {
             cage.setMaximumCapacity(maxCapacity);
         }
         if (powerStatus != null) {
             cage.setPowerStatus(PowerStatus.valueOf(powerStatus));
         }
         cageRepository.save(cage);
         return cage;
     }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE,produces = "application/json")
    public Cage delete(@PathVariable(value = "id") Integer id) {
         Cage cage = cageRepository.findOne(id);
         cageRepository.delete(id);
         return cage;
    }
}