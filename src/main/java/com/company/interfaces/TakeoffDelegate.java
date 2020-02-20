package com.company.interfaces;

import com.company.Airplane;
import com.company.Airport;

public interface TakeoffDelegate {

    void onTakeoff(Airplane takeoffComplete);

    void lastAirport(Airport previousAirport);
}
