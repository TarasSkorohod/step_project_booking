package services;

import DAO.BookingDAO;
import collections.CollectionBookingDAO;
import objects.Booking;

import java.util.List;

public class BookingService {
  private static BookingDAO bookingDAO = new CollectionBookingDAO();
  public static BookingDAO getBookingDAO() {
    return bookingDAO;
  }
  public static List<Booking> getAllBookings() {
    return bookingDAO.getAllBookings();
  }
  public static void saveBooking(Booking booking) {bookingDAO.saveBooking(booking);}
  public static void displayAllBookings() {
    bookingDAO.getAllBookings().forEach(System.out::println);
  }
}
