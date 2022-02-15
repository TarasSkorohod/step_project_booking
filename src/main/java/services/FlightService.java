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
    public void saveDB(String path) {
        Logs.log("save DB", "info");
        flightDao.saveDB(path);
    }
    public void readDB(String path) {
        Logs.log("read DB", "info");
        flightDao.readDB(path);
    }
}
