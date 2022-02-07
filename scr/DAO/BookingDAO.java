package DAO;

import objects.Booking;
import java.util.List;

public interface BookingDAO  {
  List<Booking> getAllBookings();
  Booking getBookingByIndex(int index);
  void saveBooking(Booking booking);


}
