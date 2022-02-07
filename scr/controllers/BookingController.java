package controllers;

import objects.Booking;
import objects.Flight;
import objects.Passenger;
import services.BookingService;

import java.util.List;

public class BookingController {

  private static BookingService bookingService = new BookingService();

  public static List<Booking> getAllBookings(){
    return BookingService.getAllBookings();
  }

  public static void  displayAllBookings (){
    BookingService.displayAllBookings();
  }

  public static void saveBooking(Booking booking){
    BookingService.saveBooking(booking);
  }
  public static void saveDB(String filePath) {
    BookingService.saveDB(filePath);
  }

  public static void readDB(String filePath) {
    BookingService.readDB(filePath);
  }

  public static void deleteBookingByIndex(int index) {
    BookingService.deleteBookingByIndex(index);
  }
  public static void deleteBookingByObject(Booking booking) {
    BookingService.deleteBookingByObject(booking);
  }

  public static int count (){
    return BookingService.count();
  }
  public static Booking getBookingById(int index) {
    return bookingService.getBookingById(index);
  }

  public static Booking createBooking (Flight flight, List<Passenger> passengers){
    Booking result = null;

    if (flight != null && passengers.size() > 0) {
      result = new Booking(flight, passengers);
      passengers.forEach(passenger -> flight.addPassenger(passenger));
      saveBooking(result);
    }
    return result;
  }




}
