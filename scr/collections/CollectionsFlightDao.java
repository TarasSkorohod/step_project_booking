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
}
