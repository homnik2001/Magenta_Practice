package models.entity.utility;

import models.excpetions.LockedList;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UtilList implements Comparable {
    private final RoutePair routes;
    private final ArrayList<Integer> stopIds = new ArrayList<>();
    private boolean isOpen = true;
    private double occurrence = 0;

    public RoutePair getRoutes() {
        return routes;
    }

    public ArrayList<Integer> getStopIds() {
        return stopIds;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public UtilList(RoutePair routes, int stopId) {
        this.routes = routes;
        stopIds.add(stopId);
    }

    public void setOccurrence(double percent) {
        occurrence = percent;
    }

    public double getOccurrence() {
        return occurrence;
    }

    @Override
    public String toString() {
        return "UtilList{" +
                "routes=" + routes +
                ", stopIds=" + stopIds +
                ", isOpen=" + isOpen +
                '}';
    }

    public boolean isOpen() {
        return isOpen;
    }

    /**
     * close the sequence for editing
     */
    public void close() {
        isOpen = false;
    }

    /**
     * adding a stop to a consolidated route sequence
     *
     * @param routes - pair of routes
     * @param stopID - stop id
     * @return true if it turned out to add, false you can't add
     */
    public boolean addStop(RoutePair routes, int stopID) throws LockedList {
        if (!isOpen) {
            int a = 2;
            double b = (double) a;
            //   throw new LockedList();
        }
        if (this.routes.equals(routes)) {
            stopIds.add(stopID);
            return true;
        }
        return false;

    }

    @Override
    public int compareTo(@NotNull Object o) {
        UtilList utilList = (UtilList) o;
        return Double.compare(occurrence, utilList.getOccurrence());
    }
}
