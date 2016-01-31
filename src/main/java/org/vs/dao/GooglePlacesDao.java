package org.vs.dao;


import org.codehaus.jackson.JsonNode;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class GooglePlacesDao {

    private RestTemplate restTemplate;
    
    private String authkey = "authkey";

    public GooglePlacesDao() {
        this.restTemplate = new RestTemplate();
    }

    public JsonNode getRestaurants(String latitude, String longitude) {
        String template = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=1000&types=restaurant&key=%s";
        String url = String.format(template, latitude, longitude, authkey);
        return restTemplate.getForObject(url, JsonNode.class);
    }

    public JsonNode getRestaurantDetails(String placeId) {
        String template = "https://maps.googleapis.com/maps/api/place/details/json?placeid=%s&key=%s";
        String url = String.format(template, placeId, authkey);
        return restTemplate.getForObject(url, JsonNode.class);
    }

    public String getPhoto(String photoRef) {
        String template = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=%s&key=%s";
        String url = String.format(template, photoRef, authkey);
        return restTemplate.getForObject(url, String.class);
    }

}
