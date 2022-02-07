package DAO;

import objects.Flight;
import java.util.List;

public interface ActionDAO {
  List<Flight> getAllFlight();
  void saveFlight(Flight flight);
  Flight getFlightByIndex(int index);
}
