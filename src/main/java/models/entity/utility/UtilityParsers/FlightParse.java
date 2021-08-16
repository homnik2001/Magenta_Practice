package models.entity.utility.UtilityParsers;


public class FlightParse {
    private String object_category_Id;
    private String global_id;
    private String stop_times_id;
    private String trip_id;
    private String arrival_time;
    private String departure_time;
    private String stop_id;
    private String shape_dist_traveled;
    private String pickup_type;
    private String stop_headsign;
    private String stop_sequence;
    private String trip_type;
    private String stop_interval;

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getStop_id() {
        return stop_id;
    }

    public void setStop_id(String stop_id) {
        this.stop_id = stop_id;
    }
}
