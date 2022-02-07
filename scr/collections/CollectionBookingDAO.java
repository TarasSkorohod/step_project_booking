package collections;

import DAO.BookingDAO;
import objects.Booking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class CollectionBookingDAO implements BookingDAO {
  private List<Booking> bookingsList;


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
    if (booking != null){
      if (bookingsList.contains(booking)){
        bookingsList.set(bookingsList.indexOf(booking),booking);
      }else {
        bookingsList.add(booking);
      }
    }
  }

  @Override
  public boolean deleteBooking(int index) {
    boolean result = false;
    if (index >= 0 && index < bookingsList.size()){
      bookingsList.remove(index);
      result = true;
    }
    return true;
  }

  @Override
  public boolean deleteBooking(Booking booking) {
    return bookingsList.remove(booking);
  }

  @Override
  public void saveDB(String path) {
    try{
      File af = new File(path);
      FileOutputStream fileOutput = new FileOutputStream(af.getAbsoluteFile());
      ObjectOutputStream streamOutput = new ObjectOutputStream(fileOutput);

      streamOutput.writeObject(bookingsList);
      streamOutput.close();
      fileOutput.close();
    }catch (IOException e){
      e.getStackTrace();
    }
  }

  @Override
  public void readDB(String path) {

    List<Booking> listBooking = null;

    File file = new File(path);
    FileOutputStream fi = null;
    ObjectOutputStream oi = null;

    try{
      fi = new FileOutputStream(file.getAbsoluteFile());
      oi = new ObjectOutputStream(fi);


      oi.close();
      fi.close();
      loadToDB(listBooking);
    }catch (IOException e){
      e.getStackTrace();
    }
  }

  @Override
  public void loadToDB(List<Booking> bookingList) {
    if (bookingsList != null){
      bookingsList.forEach(this::saveBooking);
    }
  }

}
