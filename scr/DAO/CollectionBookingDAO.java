package DAO;

import booking.Booking;

import java.util.List;

public class CollectionBookingDAO implements BookingDAO {




  @Override
  public List<Booking> getAllBookings() {
    return null;
  }

  @Override
  public Booking getBookingByIndex(int index) {
    return null;
  }

  @Override
  public void saveBooking(Booking booking) {

  }

  @Override
  public boolean deleteBooking(int index) {
    return false;
  }

  @Override
  public boolean deleteBooking(Booking booking) {
    return false;
  }

  @Override
  public void saveDB(String filePath) {

  }

  @Override
  public void readDB(String filePath) {

  }

  @Override
  public void loadToDB(List<Booking> bookingList) {

  }
}
