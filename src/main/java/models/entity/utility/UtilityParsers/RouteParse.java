package models.entity.utility.UtilityParsers;

public class RouteParse {
    private String object_category_Id;
    private String global_id;
    private String route_id;
    private String service_id;
    private String trip_id;
    private String trip_headsign;
    private String direction_id;
    private String block_id;
    private String volume_id;
    private String trip_type;

    @Override
    public String toString() {
        return "RouteParse{" +
                "object_category_Id='" + object_category_Id + '\'' +
                ", global_id='" + global_id + '\'' +
                ", route_id='" + route_id + '\'' +
                ", service_id='" + service_id + '\'' +
                ", trip_id='" + trip_id + '\'' +
                ", trip_headsign='" + trip_headsign + '\'' +
                ", direction_id='" + direction_id + '\'' +
                ", block_id='" + block_id + '\'' +
                ", volume_id='" + volume_id + '\'' +
                ", trip_type='" + trip_type + '\'' +
                '}';
    }

    public String getObject_category_Id() {
        return object_category_Id;
    }

    public void setObject_category_Id(String object_category_Id) {
        this.object_category_Id = object_category_Id;
    }

    public String getGlobal_id() {
        return global_id;
    }

    public void setGlobal_id(String global_id) {
        this.global_id = global_id;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getTrip_headsign() {
        return trip_headsign;
    }

    public void setTrip_headsign(String trip_headsign) {
        this.trip_headsign = trip_headsign;
    }

    public String getDirection_id() {
        return direction_id;
    }

    public void setDirection_id(String direction_id) {
        this.direction_id = direction_id;
    }

    public String getBlock_id() {
        return block_id;
    }

    public void setBlock_id(String block_id) {
        this.block_id = block_id;
    }

    public String getVolume_id() {
        return volume_id;
    }

    public void setVolume_id(String volume_id) {
        this.volume_id = volume_id;
    }

    public String getTrip_type() {
        return trip_type;
    }

    public void setTrip_type(String trip_type) {
        this.trip_type = trip_type;
    }
}
