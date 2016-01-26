package org.vs.domain;

public class Offer {

    String placeName;
    String offerType;
    String cardType;

    public Offer(String placeName, String offerType, String cardType) {
        this.placeName = placeName;
        this.offerType = offerType;
        this.cardType = cardType;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    
}
