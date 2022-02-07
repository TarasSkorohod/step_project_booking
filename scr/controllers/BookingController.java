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



}
