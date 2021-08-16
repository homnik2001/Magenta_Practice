package models.entity.carriage;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Objects;

public class Stop implements Comparable {
    int stopID = 0;
    HashSet<Route> routes = new HashSet<>();

    @Override
    public String toString() {
        return "Stop{" +
                "stopID=" + stopID +
                ", routes=" + routes +
                '}';
    }

    public void addRoute(Route r) {
        routes.add(r);
    }

    public Stop(int sid) {
        stopID = sid;
    }

    public int getStopID() {
        return stopID;
    }

    public HashSet<Route> getRoutes() {
        return routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return stopID == stop.stopID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stopID);
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Stop scompare = (Stop) o;

        return Integer.compare(routes.size(), scompare.getRoutes().size());
    }
}
