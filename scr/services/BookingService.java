package services;

import DAO.BookingDAO;
import collections.CollectionBookingDAO;
import objects.Booking;

import java.util.List;

public class BookingService {
  private BookingDAO bookingDAO = new CollectionBookingDAO();

  public BookingDAO getBookingDAO() {
    return bookingDAO;
  }

  public List<Booking> getAllBookings() {
    return bookingDAO.getAllBookings();
  }

  public void saveBooking(Booking booking) {bookingDAO.saveBooking(booking);}

  public void displayAllBookings() {
    bookingDAO.getAllBookings().forEach(System.out::println);
  }
}
