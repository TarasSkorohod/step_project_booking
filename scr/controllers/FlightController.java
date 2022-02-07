package controllers;

import services.FlightService;

import java.util.*;

public class FlightController {
  private FlightService flightService;

  public void getAllFlightWithEnterData() {
    flightService.getAllFlightWithEnterData();
  }
}
