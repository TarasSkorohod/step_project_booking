package collections;

import DAO.BookingDAO;
import objects.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionBookingDAO implements BookingDAO {
  private List<Booking> bookingsList;


  public CollectionBookingDAO() {

    bookingsList = new ArrayList();

  }

  @Override
  public List<Booking> getAllBookings() {

    return bookingsList;

  }

  @Override
  public Booking getBookingByIndex(int index) {
    Booking result = null;
    if (index >= 0 && index < bookingsList.size()){
      result = bookingsList.get(index);
    }

    return result;
  }

  @Override
  public void saveBooking(Booking booking) {

    if (booking != null) {
      if (bookingsList.contains(booking)) {
        bookingsList.set(bookingsList.indexOf(booking), booking);
      } else {
        bookingsList.add(booking);
      }
    }

  }

  @Override
  public boolean deleteBooking(int index) {
    boolean result = false;
    if (index >= 0 && index < bookingsList.size()) {
      bookingsList.remove(index);
      result = true;
    }
    return result;
  }

  @Override
  public boolean deleteBooking(Booking booking) {
    return bookingsList.remove(booking);
  }

  @Override
  public void saveDB(String path) {

    try {
      File af = new File(path);
      FileOutputStream fileOutput = new FileOutputStream(af.getAbsoluteFile());
      ObjectOutputStream streamOutput = new ObjectOutputStream(fileOutput);

      streamOutput.writeObject(bookingsList);
      streamOutput.close();
      fileOutput.close();

    } catch (IOException e) {
      e.getStackTrace();
    }

  }

  @Override
  public void readDB(String path) {

    List<Booking> listBooking = null;

    File file = new File(path);
    FileInputStream fi = null;
    ObjectInputStream oi = null;

    try {

      fi = new FileInputStream(file.getAbsoluteFile());
      oi = new ObjectInputStream(fi);

      listBooking = (List<Booking>) oi.readObject();


      oi.close();
      fi.close();
      loadToDB(listBooking);

    } catch (ClassNotFoundException | IOException e) {
      e.getStackTrace();
    }


  }

  @Override
  public void loadToDB(List<Booking> bookingsList) {
    if (bookingsList != null){
      bookingsList.forEach(this::saveBooking);
    }
  }


}
