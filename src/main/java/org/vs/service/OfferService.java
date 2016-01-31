package org.vs.service;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vs.dao.GooglePlacesDao;
import org.vs.domain.Offer;
import org.vs.util.FileUtil;

import java.io.IOException;
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
        printResponse(restaurants);
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
        Offer offer6 = new Offer("Chicken Mahal", "15% Discount", "HDFC Platinum Debit Card");
        Offer offer7 = new Offer("Moti Mahal Deluxe", "25% Discount", "ICICI Gold Credit Card");
        Offer offer8 = new Offer("The Pizza Point", "10% Discount", "HDFC Regalia Credit Card");
        Offer offer9 = new Offer("Desi Tadka", "26% Republic Day Discount", "SBI Silver Debit Card");
        Offer offer10 = new Offer("Hurry Curry", "10% Discount", "Paytm Wallet");

        offersMap.put("ChIJkaqqxjr7DDkRQZKu3p8pm4o", offer1);
        offersMap.put("ChIJI9vLvLT6DDkR6IxankeLUQQ", offer2);
        offersMap.put("ChIJmYyN6rL6DDkR0nbVaUKZ9Zw", offer3);
        offersMap.put("ChIJN44sqlPlDDkRKoZmyIERrCE", offer4);
        offersMap.put("ChIJsaVEwLL6DDkRJ4bWS3ZDXl4", offer5);
        offersMap.put("ChIJkVfqvxACDTkR5x25TVltbDY", offer6);
        offersMap.put("ChIJTb3B5aQDDTkR27XFJhox7EI", offer7);
        offersMap.put("ChIJp7ffCEIDDTkRrYV6vGk0a_o", offer8);
        offersMap.put("ChIJS8IqEj0DDTkRyVw6fp9JyD4", offer9);
        offersMap.put("ChIJEXGjyzoDDTkR94LXm3FRiQk", offer10);
    }

    public String getNearbyRestaurants(String latitude, String longitude) {
        JsonNode restaurants = googlePlacesDao.getRestaurants(latitude, longitude);
        printResponse(restaurants);
        return restaurants.toString();
    }

    public String getRestaurantDetails(String placeId) {
        JsonNode restaurantDetails = googlePlacesDao.getRestaurantDetails(placeId);
        printResponse(restaurantDetails);
        return restaurantDetails.toString();
    }

    public String getPhoto(String photoRef) {
        return googlePlacesDao.getPhoto(photoRef);
    }

    private void printResponse(JsonNode node) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String asString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
            System.out.println("Response:\n" + asString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
