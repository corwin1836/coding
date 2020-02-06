package com.company;

import com.company.models.Airports;

import java.util.Map;
import java.util.Set;

public class AirportNetwork {
    public AirportNetwork(Map<String, Airports> airportsMap) {
        Set<String> keySet = airportsMap.keySet();
        for(String key : keySet) {
            Airports airports = airportsMap.get(key);
        }
    }
}
