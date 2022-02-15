package main.java.services;


import main.java.collections.CollectionFlightDAO;
import main.java.DAO.ActionDAO;
import main.java.logger.Logs;
import main.java.objects.Flight;

import java.util.List;

public class FlightService {

    private ActionDAO flightDao = new CollectionFlightDAO();
    public List<Flight> getAllFlights() {
        Logs.log("get all flights", "info");
        return flightDao.getAllFlight();
    }
    public void displayAllFlights() {
        Logs.log("display all flights", "info");
        flightDao.getAllFlight().forEach(System.out::println);

    }
    public void saveFlight(Flight flight) {
        Logs.log("save flight", "info");
        flightDao.saveFlight(flight);
    }
    public void saveDB(String path) {
        Logs.log("save DB", "info");
        flightDao.saveDB(path);
    }
    public void readDB(String path) {
        Logs.log("read DB", "info");
        flightDao.readDB(path);
    }
    public void deleteFlight(int index) {
        Logs.log("delete flight by index", "info");
        flightDao.remove(index);
    }
    public void deleteFlight(Flight flight) {
        Logs.log("delete flight", "info");
        flightDao.remove(flight);
    }

    public int count() {
        Logs.log("get count flight", "info");
        return flightDao.getAllFlight().size();
    }
    public Flight getFlightById(int index) {
        Logs.log("get flight by id", "info");
        if (index < flightDao.getAllFlight().size() && index >= 0) {
            return flightDao.getAllFlight().get(index);
        } else {
            return null;
        }
    }
}
