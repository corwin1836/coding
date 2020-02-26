//package com.company.fileOutputs;
//
//import com.company.*;
//import com.company.interfaces.Writer;
//import com.company.models.Airline;
//import com.company.models.TrafficControl;
//import com.google.gson.Gson;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class AirportSerializer {
//
//
//    public void serializer (Writer writer, String filePath, AirportNetwork airport) throws IOException {
//        AirplaneLandingFleet landingFleet = airport.getLandingList();
//        AirplaneTakeoffFleet takeoffFleet = airport.getTakeoffList();
//    //    TrafficControl trafficControl = new TrafficControl(buildIncoming(landingFleet), buildOutgoing(takeoffFleet));
//        Gson gson = new Gson();
//        String json = gson.toJson(trafficControl);
//        writer.write(filePath, json);
//    }
//
//
//
//    public Airline[] buildIncoming(AirplaneLandingFleet incoming){
//        Airplane[] airplanes = incoming.getFleet();
//        Airline[] airlines = new Airline[airplanes.length];
//        for (int i = 0; i < airlines.length; i += 1) {
//            AirplaneMake make = airplanes[i].getPlaneMake();
//            AirplaneModel model = airplanes[i].getPlaneModel();
//            String route = airplanes[i].getUniqueIdentifier();
//            String makeString =  make.toString();
//            String modelString = model.toString();
//            airlines[i] = new Airline(makeString, modelString, route);
//        }
//        return airlines;
//    }
//
//    public Airline[] buildOutgoing(AirplaneTakeoffFleet outgoing) {
//        ArrayList<Airplane> airplanes = outgoing.getFleet();
//        Airline[] airlines = new Airline[airplanes.size()];
//        for (int i = 0; i < airlines.length; i += 1) {
//            AirplaneMake make = airplanes.get(i).getPlaneMake();
//            AirplaneModel model = airplanes.get(i).getPlaneModel();
//            String route = airplanes.get(i).getUniqueIdentifier();
//            String makeString = make.toString();
//            String modelString = model.toString();
//            airlines[i] = new Airline(makeString, modelString, route);
//        }
//        return airlines;
//    }
//}
