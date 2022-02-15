package main.java;

import main.java.authorization.Auth;
import main.java.logger.Logs;
import main.java.objects.BookingApp;


public class App {
    public static void app() {
        BookingApp app = new BookingApp();

        Logs.log("Run auth", "info");
        Auth.startAuth();
        Logs.log("Start app", "info");
        app.start();
    }
}
