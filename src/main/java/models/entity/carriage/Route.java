package models.entity.carriage;

import java.util.ArrayList;
import java.util.LinkedHashSet;


public class Route {
    private int number;//код маршрута
    private ArrayList<Stop> stopIds = new ArrayList<>();
    private ArrayList<Flight> flights = new ArrayList<>();// рейсы

    public Route(int nmb, String fl) {
        number = nmb;
        flights.add(new Flight(fl));

    }

    public Route(Integer nmb) {
        number = nmb;
    }

    public int getRouteId() {
        return number;
    }

    public ArrayList<Stop> getStops() {
        return stopIds;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    @Override
    public String toString() {
        return "Route{" +
                "number=" + number +
                ", flights=" + flights +
                '}';
    }

    public void setStopsForRoutes() { //вот такой вот интересный метод, который вытаскивает
        // из внутренней коллекции данные для внешней
        //пробегается по все поездкам из идеии
        // что маршру может быть реализован как a->b, b->a
        for (Flight f : flights) {
            for (Integer stopId : f.getStopId()) {
                stopIds.add(new Stop(stopId));
            }
        }
        LinkedHashSet<Stop> stopSet = new LinkedHashSet<>(stopIds);
        stopIds.clear();
        stopIds.addAll(stopSet);
    }

}
