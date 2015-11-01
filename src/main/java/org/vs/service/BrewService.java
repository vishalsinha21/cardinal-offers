package org.vs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vs.util.FileUtil;

@Service
public class BrewService {

    @Autowired
    FileUtil fileUtil;

    public String getBestBeers() {
        return fileUtil.readStringFromFile("beers.json");
    }

}
