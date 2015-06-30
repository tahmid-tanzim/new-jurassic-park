package com.rootnextsolution.newjurassicpark.api;

import com.rootnextsolution.newjurassicpark.model.Cage;
import com.rootnextsolution.newjurassicpark.model.PowerStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tahmid.tanzim on 6/30/15.
 */
@RestController
public class CageController {

    @RequestMapping(value = "api/cage", method = RequestMethod.GET)
    public Cage get(){
        return new Cage();
    }
}