package collections;

import DAO.ActionDAO;
import objects.Flight;

import java.io.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import static utils.ConfigDate.TIME_ZONE;

public final class CollectionsFlightDao implements ActionDAO {

  List<Flight> flights = new ArrayList<>(0);
  private List<Flight> flightList = null;

  @Override
  public List<Flight> getAllFlight() {
    return flights;
  }

  @Override
  public void saveFlight(Flight flight) {
    if (flight != null) {
    if (flightList.contains(flight)) {
      flightList.set(flightList.indexOf(flight), flight);
    } else {
      flightList.add(flight);
    }
  }

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

  @Override
  public void saveDB(String path) {

    try {
      File af = new File(path);
      FileOutputStream fileOutput = new FileOutputStream(af.getAbsoluteFile());
      ObjectOutputStream streamOutput = new ObjectOutputStream(fileOutput);
      streamOutput.writeObject(flightList);
      streamOutput.close();
      fileOutput.close();

    } catch (IOException e) {
      e.getStackTrace();
    }
  }
  @Override
  public void readDB(String path) {
    List<Flight> listFlight = null;

    File file = new File(path);
    FileInputStream fi = null;
    ObjectInputStream oi = null;

    try {

      fi = new FileInputStream(file.getAbsoluteFile());
      oi = new ObjectInputStream(fi);

      listFlight = (List<Flight>) oi.readObject();


      oi.close();
      fi.close();
      loadToDB(listFlight);

    } catch (ClassNotFoundException | IOException e) {
      e.getStackTrace();
    }

  }
  @Override
  public void loadToDB(List<Flight> listFlight) {
    if (listFlight != null) {
      LocalTime currentTime = LocalTime.now(ZoneId.of(TIME_ZONE));
      LocalDate currentDate = LocalDate.now(ZoneId.of(TIME_ZONE));
      ZoneOffset zoneOffset = currentDate.atStartOfDay(ZoneId.of(TIME_ZONE)).getOffset();
      listFlight.forEach(flight -> {
        LocalDate flightDepartureDate = currentDate;
        LocalTime flightDepartureTime = Instant.ofEpochMilli(flight.getDepartureDateTime()).atOffset(zoneOffset).toLocalTime();
        if (flightDepartureTime.isBefore(currentTime)) {
          flightDepartureDate = currentDate.plusDays(1);
        }
        long departureDateTimeLong = LocalDateTime.of(flightDepartureDate,flightDepartureTime).toInstant(zoneOffset).toEpochMilli();
        flight.setDepartureDateTime(departureDateTimeLong);

        saveFlight(flight);

      });
    }
  }
}
