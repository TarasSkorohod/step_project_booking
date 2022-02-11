package main.java.DAO;

import main.java.objects.Booking;

import java.util.List;

public interface BookingDAO {

    List<Booking> getAllBookings();
    Booking getBookingByIndex(int index);
    void saveBooking(Booking booking);
    boolean deleteBooking(int index);
    boolean deleteBooking(Booking booking);
    void saveDB(String filePath);
    void readDB(String filePath);
    void loadToDB(List<Booking> bookingList);

}
