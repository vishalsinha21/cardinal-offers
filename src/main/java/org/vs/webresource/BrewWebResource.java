package org.vs.webresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vs.service.BrewService;

@RestController
public class BrewWebResource {

    BrewService brewService;

    @Autowired
    public BrewWebResource(BrewService brewService) {
        this.brewService = brewService;
    }

    @RequestMapping(produces = "application/json;charset=UTF-8", value = "/brew/best", method = RequestMethod.GET)
    public ResponseEntity<String> getBestBeers() {
        String bestBeers = brewService.getBestBeers();

        return new ResponseEntity<String>(bestBeers, HttpStatus.OK);
    }

}
