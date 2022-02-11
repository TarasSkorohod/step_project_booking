package main.java;

import main.java.objects.Flight;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static main.java.utils.ConfigDate.DATE_TIME_FORMAT;
import static main.java.utils.FormatDate.dateTimeToLong;
import static main.java.utils.FormatDate.printNow;

public class SetTestFlights {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        int dayInMinute = 24 * 60;
        String myTime = printNow();
        SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        Date d = df.parse(myTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        List<Flight> flightList = new ArrayList();
        List<String> destinations = sortarray();
        int destinationsLength = destinations.size();

        for (int i = 15; i < dayInMinute; i = i + 30){
            cal.add(Calendar.MINUTE, 30);


            Flight f = new Flight(
                    genChars(),
                    dateTimeToLong(df.format(cal.getTime())),
                    destinations.get(genNumbers(0, destinationsLength - 1)),
                    150
            );
            flightList.add(f);

        }
        saveDB(flightList);
        readDB();
    }

    public static void saveDB(List<Flight> flightList) {
        String path = "./db/flights.txt";

        try {
            File af = new File(path);
            FileOutputStream fileOutput = new FileOutputStream(af.getAbsoluteFile());
            ObjectOutputStream streamOutput = new ObjectOutputStream(fileOutput);
            streamOutput.writeObject(flightList);
            streamOutput.close();
            fileOutput.close();

        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static void readDB() {
        String path = "./db/flights.txt";
        List<Flight> listFlight = null;

        File file = new File(path);
        FileInputStream fi = null;
        ObjectInputStream oi = null;

        try {

            fi = new FileInputStream(file.getAbsoluteFile());
            oi = new ObjectInputStream(fi);

            listFlight = (List<Flight>) oi.readObject();



            oi.close();
            fi.close();
        } catch (ClassNotFoundException | IOException e) {
            e.getStackTrace();
        }
        System.out.println(listFlight);

    }

    private static String genChars(){
        int length = 2;
        Random r = new Random();
        String eng = "abcdefghijklmnopqrstuvwxyz";
        String gen = "";
        for (int i = 0; i < length; i++){
            char c = eng.charAt(r.nextInt(eng.length()));
            gen += c;
        }
        return String.format("%s%04d", gen, genNumbers(1, 9999)).toUpperCase(Locale.ROOT);
    }

    public static int genNumbers(int min, int max){
        int a = (int) (min + Math.random()*max);

        return a;
    }


    public static List<String> sortarray(){
        List<String> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("./db/city.txt"), StandardCharsets.UTF_8)
                )
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String valuesRow = values[0].split(" ")[0];
                records.add(valuesRow);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
