package controllers;

import objects.Booking;
import services.BookingService;

import java.util.List;

public class BookingController {

  private BookingService bookingService = new BookingService();
  private FlightController flightController = new FlightController();

  public List<Booking> getAllBookings(){
    return bookingService.getAllBookings();
  }



}
