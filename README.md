Cardinal Offers
----------------

Location specific restaurant offers

First time setup:
- clone project
- mvn clean install
- bower install
- mvn jetty:run to start app


Restaurants are fetched in real time but offers data is mocked up

To make it work add mock up data to offersMap in OfferService, key should be google place_id

Also replace authkey in GooglePlaceDAO with your google auth key
