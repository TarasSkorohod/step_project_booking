package main.java.DAO;

import main.java.objects.Flight;

import java.util.List;

public interface ActionDAO {
    void saveFlight(Flight item);
    Flight get(int index);
    List<Flight> getAllFlight();
    boolean remove(int index);
    boolean remove(Flight item);
    void saveDB(String path);
    void readDB(String path);
    void loadToDB(List<Flight> list);
}
