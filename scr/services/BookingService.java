package services;

import DAO.BookingDAO;
import collections.CollectionBookingDAO;
import objects.Booking;

import java.util.List;

public class BookingService {
  private BookingDAO bookingDao = new CollectionBookingDAO();

  public BookingDAO getBookingDao() {
    return bookingDao;
  }

  public List<Booking> getAllBookings() {
    return bookingDao.getAllBookings();
  }

  public void displayAllBookings() {

    bookingDao.getAllBookings().forEach(System.out::println);

  }

  public void saveBooking(Booking booking) {

    bookingDao.saveBooking(booking);

  }

  public void saveDB(String filePath) {

    bookingDao.saveDB(filePath);

  }

  public void readDB(String filePath) {
    bookingDao.readDB(filePath);
  }
  public void deleteBookingByIndex(int index) {

    bookingDao.deleteBooking(index);

  }

}
