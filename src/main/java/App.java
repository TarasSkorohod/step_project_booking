package main.java;

import main.java.authorization.Auth;
import main.java.objects.BookingApp;


public class App {
    public static void app() {
        BookingApp app = new BookingApp();


        Auth.startAuth();
        app.start();
    }
}
