package main.java.services;

import main.java.objects.Booking;
import main.java.collections.CollectionBookingDAO;
import main.java.DAO.BookingDAO;

import java.util.List;

public class BookingService {

    private BookingDAO bookingDao = new CollectionBookingDAO();
    public BookingDAO getBookingDao() {
        return bookingDao;
    }
    public List<Booking> getAllBookings() {
        return bookingDao.getAllBookings();
    }
    public void displayAllBookings() {
        bookingDao.getAllBookings().forEach(System.out::println);
    }
    public void saveBooking(Booking booking) {
        bookingDao.saveBooking(booking);
    }
    public void saveDB(String filePath) {
        bookingDao.saveDB(filePath);
    }
    public void readDB(String filePath) {
        bookingDao.readDB(filePath);
    }
    public void deleteBookingByIndex(int index) {
        bookingDao.deleteBooking(index);
    }
    public void deleteBookingByObject(Booking booking) {
        bookingDao.deleteBooking(booking);
    }

    public int count() {
        return bookingDao.getAllBookings().size();
    }
    public Booking getBookingById(int index) {
        if (index >= 0 && index < bookingDao.getAllBookings().size()) {
            return bookingDao.getAllBookings().get(index);
        }else {
            return null;
        }
    }
}
