package main.java.services;

import main.java.DAO.BookingDAO;
import main.java.collections.CollectionBookingDAO;
import main.java.objects.Booking;
import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

  @Test
  void getBookingDao() {
    BookingDAO bookingDAO = new CollectionBookingDAO();
    List<Booking> allBookings = bookingDAO.getAllBookings();

    assertEquals(allBookings.toString(), "[]");
  }
  @Test
  void getAllBookings() {
    BookingDAO bookingDAO = new CollectionBookingDAO();
    List<Booking> allBookings = bookingDAO.getAllBookings();

    assertEquals(allBookings.toString(), "[]");
    System.out.println("get all Bookings");
  }
  @Test
  void displayAllBookings() {
    saveBooking();
    BookingDAO bookingDAO = new CollectionBookingDAO();
    for (int i = 0; i < bookingDAO.getAllBookings().size(); i++) {
      Booking item = bookingDAO.getAllBookings().get(i);
      assertEquals(item, "");

    }
  }
  @Test
  void saveBooking() {

  }

  @Test
  void saveDB() {
    BookingDAO bookingDAO = new CollectionBookingDAO();
    bookingDAO.saveDB("./db/Test.txt");
  }

  @Test
  void readDB() {
    BookingDAO bookingDAO = new CollectionBookingDAO();
    bookingDAO.readDB("./db/Test.txt");
  }

  @Test
  void deleteBookingByIndex() {
  }

  @Test
  void deleteBookingByObject() {


  }

  @Test
  void count() {
  }

  @Test
  void getBookingById() {
  }
}