package services;

import DAO.BookingDAO;
import DAO.CollectionBookingDAO;
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

}
