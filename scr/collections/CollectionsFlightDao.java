package collections;

import DAO.ActionDAO;
import objects.Flight;
import objects.Passenger;

import java.util.ArrayList;
import java.util.List;

public final class CollectionsFlightDao implements ActionDAO {
  List<Flight> flights = new ArrayList<>(0);


  @Override
  public List<Flight> getAllFlight() {
    return flights;
  }

  @Override
  public void saveFlight(Flight flight) {
    int index = 0;
    for (Flight item : flights) {
      if (item.equals(flight)) {
        flights.set(index, flight);
        return;
      }
      index++;
    }
    flights.add(flight);
  }

  @Override
  public Flight getFlightByIndex(int index) {
      try {
        return flights.get(index);
      } catch (Exception e) {
        System.out.println("No flight found " + e.getMessage());
        return null;
      }
  }

  @Override
  public boolean deleteFlight(int index) {
    boolean result = false;
    if (index >= 0 && index < flights.size()){
      flights.remove(index);
      result = true;
    }
    return result;
  }
}
