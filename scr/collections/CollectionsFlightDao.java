package collections;

import DAO.ActionDAO;
import objects.Flight;

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
        System.out.println("One flight was updated");
        return;
      }
      index++;
    }
    flights.add(flight);
    System.out.println("One flight was added");
  }
}
