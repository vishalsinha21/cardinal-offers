package org.vs.dao;


import org.codehaus.jackson.JsonNode;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class GooglePlacesDao {

    private RestTemplate restTemplate;

    public GooglePlacesDao() {
        this.restTemplate = new RestTemplate();
    }

    public JsonNode getRestaurants(String latitude, String longitude) {
        String template = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=1000&types=restaurant&key=authkey";
        String url = String.format(template, latitude, longitude);
        return restTemplate.getForObject(url, JsonNode.class);
    }

}
