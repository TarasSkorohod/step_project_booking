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
        System.out.println("----------------------");
        System.out.println("Один рейс был обновлён");
        return;
      }
      index++;
    }
    flights.add(flight);
    System.out.println("----------------------");
    System.out.println("Один рейс был добавлен");
  }

  @Override
  public Flight getFlightByIndex(int index) {
      try {
        return flights.get(index);
      } catch (Exception e) {
        System.out.println("No family found " + e.getMessage());
        return null;
      }
  }
}
