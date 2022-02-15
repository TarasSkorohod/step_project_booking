package main.java.services;

import main.java.logger.Logs;
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
        Logs.log("get all booking", "info");
        return bookingDao.getAllBookings();
    }
    public void displayAllBookings() {
        bookingDao.getAllBookings().forEach(System.out::println);
    }
    public void saveBooking(Booking booking) {
        Logs.log("save booking", "info");
        bookingDao.saveBooking(booking);
    }
    public void saveDB(String filePath) {
        Logs.log("save DB", "info");
        bookingDao.saveDB(filePath);
    }
    public void readDB(String filePath) {
        Logs.log("read DB", "info");
        bookingDao.readDB(filePath);
    }
    public void deleteBookingByIndex(int index) {
        Logs.log("delete booking by index", "info");
        bookingDao.deleteBooking(index);
    }
    public void deleteBookingByObject(Booking booking) {
        Logs.log("delete booking by object", "info");
        bookingDao.deleteBooking(booking);
    }

    public int count() {
        Logs.log("get count booking", "info");
        return bookingDao.getAllBookings().size();
    }
    public Booking getBookingById(int index) {
        Logs.log("get booking by id", "info");
        if (index >= 0 && index < bookingDao.getAllBookings().size()) {
            return bookingDao.getAllBookings().get(index);
        }else {
            return null;
        }
    }
}
