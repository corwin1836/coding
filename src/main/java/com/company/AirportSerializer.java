package com.company;

import com.company.AirplaneLandingFleet;
import com.company.Airport;
import com.company.Writer;
import com.company.models.TrafficControl;
import com.google.gson.Gson;

public class AirportSerializer {
    private TrafficControl trafficControl;

    public void serializer (Writer writer, String filePath, Airport airport) {


        Gson gson = new Gson();
        String json = gson.toJson(trafficControl);
    }

}
