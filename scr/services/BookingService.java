package services;

import DAO.BookingDAO;
import collections.CollectionBookingDAO;
import objects.Booking;

import java.util.List;

public class BookingService {
  private static final BookingDAO bookingDao = new CollectionBookingDAO();

  public static BookingDAO getBookingDao() {
    return bookingDao;
  }

  public static List<Booking> getAllBookings() {
    return bookingDao.getAllBookings();
  }

  public static void displayAllBookings() {
    bookingDao.getAllBookings().forEach(System.out::println);
  }

  public static void saveBooking(Booking booking) {

    bookingDao.saveBooking(booking);

  }

  public static void saveDB(String filePath) {

    bookingDao.saveDB(filePath);

  }

  public static void readDB(String filePath) {
    bookingDao.readDB(filePath);
  }

  public static void deleteBookingByIndex(int index) {

    bookingDao.deleteBooking(index);

  }

  public static void deleteBookingByObject(Booking booking) {
    bookingDao.deleteBooking(booking);
  }


  public static int count() {
    return bookingDao.getAllBookings().size();}


  public  Booking getBookingById(int index) {
    if (index >= 0 && index< bookingDao.getAllBookings().size()){
      return bookingDao.getAllBookings().get(index);
    }else {
      return null;
    }
  }
}
