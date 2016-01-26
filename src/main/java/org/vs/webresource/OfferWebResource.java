package org.vs.webresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vs.domain.Offer;
import org.vs.service.OfferService;

import java.util.List;

@RestController
public class OfferWebResource {

    OfferService offerService;

    @Autowired
    public OfferWebResource(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping(produces = "application/json;charset=UTF-8", value = "/brew/offers", method = RequestMethod.GET)
    public ResponseEntity<List<Offer>> getAllOffers(
            @RequestParam(value = "lat") String latitude,
            @RequestParam(value = "long") String longitude) {

        List<Offer> offers = offerService.getOffers(latitude, longitude);
        return new ResponseEntity<List<Offer>>(offers, HttpStatus.OK);
    }

    @RequestMapping(produces = "application/json;charset=UTF-8", value = "/brew/restaurants", method = RequestMethod.GET)
    public ResponseEntity<String> getNearbyRestaurants(
            @RequestParam(value = "lat") String latitude,
            @RequestParam(value = "long") String longitude) {

        String offers = offerService.getNearbyRestaurants(latitude, longitude);
        return new ResponseEntity<String>(offers, HttpStatus.OK);
    }

}
