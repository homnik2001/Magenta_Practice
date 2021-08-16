package models.entity.carriage;

import models.entity.utility.Time;
import models.excpetions.InvalidTime;

import java.util.ArrayList;

public class Flight {
    private String id;
    private ArrayList<Integer> stopIds = new ArrayList<>();
    private ArrayList<Time> times = new ArrayList<>();// evens are arrivals, odds are departures

    public void addStop(Time[] t, String stopId) throws InvalidTime, NullPointerException {
        times.add(t[0]);//add arrival time
        times.add(t[1]);// add departure time
        this.stopIds.add(Integer.parseInt(stopId));
    }

    public Flight(String str) {
        id = str;
    }

    public Flight(String fid, Time[] t, String stopId) throws InvalidTime, NullPointerException {
        id = fid;
        this.stopIds.add(Integer.parseInt(stopId));
        times.add(t[0]);//add arrival time
        times.add(t[1]);// add departure time
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", times=" + times +
                '}';
    }

    public ArrayList<Integer> getStopId() {
        return stopIds;
    }

    public void setStopId(ArrayList<Integer> stopId) {
        this.stopIds = stopId;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Time> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }
}
