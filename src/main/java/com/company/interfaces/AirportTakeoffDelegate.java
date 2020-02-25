package com.company.interfaces;

import com.company.Airplane;
import com.company.Airport;

public interface AirportTakeoffDelegate {

    void onTakeoff(Airplane takeoffComplete, Airport previousAirport);

}
