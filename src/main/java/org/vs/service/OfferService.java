package org.vs.service;

import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vs.dao.GooglePlacesDao;
import org.vs.domain.Offer;
import org.vs.util.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class OfferService {

    @Autowired
    FileUtil fileUtil;

    @Autowired
    GooglePlacesDao googlePlacesDao;

    private static Map<String, Offer> offersMap = new HashMap();

    public List<Offer> getOffers(String latitude, String longitude) {
        JsonNode restaurants = googlePlacesDao.getRestaurants(latitude, longitude);
        Iterator<JsonNode> results = restaurants.get("results").getElements();
        populateOffersMap();

        List<Offer> offers = new ArrayList();

        while (results.hasNext()) {
            JsonNode next = results.next();
            String place_id = next.get("place_id").asText();

            if (offersMap.containsKey(place_id)) {
                offers.add(offersMap.get(place_id));
            }
        }

        return offers;
    }

    private static void populateOffersMap() {
        Offer offer1 = new Offer("Moti Mahal Delux", "15% Discount", "HDFC Platinum Debit Card");
        Offer offer2 = new Offer("Domino's Pizza", "25% Discount", "ICICI Gold Credit Card");
        Offer offer3 = new Offer("Cinnamon Kitchen", "10% Discount", "HDFC Regalia Credit Card");
        Offer offer4 = new Offer("Pind Balluchi", "26% Republic Day Discount", "SBI Silver Debit Card");
        Offer offer5 = new Offer("Urban Punjab", "10% Discount", "Paytm Wallet");

        offersMap.put("ChIJkaqqxjr7DDkRQZKu3p8pm4o", offer1);
        offersMap.put("ChIJI9vLvLT6DDkR6IxankeLUQQ", offer2);
        offersMap.put("ChIJmYyN6rL6DDkR0nbVaUKZ9Zw", offer3);
        offersMap.put("ChIJN44sqlPlDDkRKoZmyIERrCE", offer4);
        offersMap.put("ChIJsaVEwLL6DDkRJ4bWS3ZDXl4", offer5);
    }

    public String getNearbyRestaurants(String latitude, String longitude) {
        return googlePlacesDao.getRestaurants(latitude, longitude).toString();
    }
    
}
