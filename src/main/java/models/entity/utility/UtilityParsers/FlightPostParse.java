package models.entity.utility.UtilityParsers;


import models.entity.utility.Time;
import models.excpetions.InvalidTime;

import java.util.Arrays;

public class FlightPostParse {
    private String id;
    private Time[] time = new Time[2];
    private String stopId;

    public FlightPostParse(FlightParse flight) {
        id = flight.getTrip_id();
        stopId = flight.getStop_id();
        try {
            time[0] = new Time(flight.getArrival_time());
            time[1] = new Time(flight.getDeparture_time());
        } catch (InvalidTime e) {

        }
    }

    public String getStopId() {
        return stopId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Time[] getTime() {
        if (time[0] == null || time[1] == null) {
            time = null;
        }
        return time;
    }

    public void setTime(Time[] time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FlightPostParse{" +
                "id='" + id + '\'' +
                ", time=" + Arrays.toString(time) +
                '}';
    }
}
