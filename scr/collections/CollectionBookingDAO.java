package collections;

import DAO.BookingDAO;
import objects.Booking;

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

}
