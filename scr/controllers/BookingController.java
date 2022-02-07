package controllers;

import objects.Booking;
import services.BookingService;

import java.util.List;

public class BookingController {

  private BookingService bookingService = new BookingService();

  public List<Booking> getAllBookings(){
    return bookingService.getAllBookings();
  }

  public void  displayAllBookings (){
    bookingService.displayAllBookings();
  }

  public void saveBooking(Booking booking){
    bookingService.saveBooking(booking);
  }
  public void saveDB(String filePath) {
    bookingService.saveDB(filePath);
  }

  public void readDB(String filePath) {
    bookingService.readDB(filePath);
  }

  public void deleteBookingByIndex(int index) {
    bookingService.deleteBookingByIndex(index);
  }





}
