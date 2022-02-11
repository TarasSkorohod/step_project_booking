package main.java.services;


import main.java.collections.CollectionFlightDAO;
import main.java.DAO.ActionDAO;
import main.java.objects.Flight;

import java.util.List;

public class FlightService {

    private ActionDAO flightDao = new CollectionFlightDAO();
    public ActionDAO getFlightDao() {return flightDao;}

    public List<Flight> getAllFlights() {
        return flightDao.getAllFlight();
    }

    public void displayAllFlights() {
        flightDao.getAllFlight().forEach(System.out::println);

    }
    public void saveFlight(Flight flight) {flightDao.saveFlight(flight);}
    public void saveDB(String path) {flightDao.saveDB(path);}
    public void readDB(String path) {
        flightDao.readDB(path);
    }

    public void deleteFlight(int index) {
        flightDao.remove(index);
    }
    public void deleteFlight(Flight flight) {flightDao.remove(flight);}

    public int count() {
        return flightDao.getAllFlight().size();
    }
    public Flight getFlightById(int index) {
        if (index < flightDao.getAllFlight().size() && index >= 0) {
            return flightDao.getAllFlight().get(index);
        } else {
            return null;
        }
    }
//    public static void displayAllFlight() {
//        for (int i = 0; i < getAllFlight().size(); i++) {
//            System.out.println("======================");
//            System.out.println("Index flight - " + i);
//            getAllFlight().get(i).prettyFormat();
//        }
//    }


}
