package DAO;

import objects.Flight;
import java.util.List;

public interface ActionDAO {
  List<Flight> getAllFlight();
  void saveFlight(Flight flight);
  Flight getFlightByIndex(int index);
  boolean deleteFlight(int index);


  List<Flight> getAll();





  void saveDB(String filePath);
  void readDB(String filePath);
  void loadToDB(List<Flight> listFlight);


}
