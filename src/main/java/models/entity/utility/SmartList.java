package models.entity.utility;

import models.excpetions.LockedList;

import java.util.HashMap;

public class SmartList {

    private HashMap<RoutePair, UtilList> routeSequences = new HashMap<>();

    public HashMap<RoutePair, UtilList> getRouteSequences() {
        return routeSequences;
    }

    public int getSize() {
        return routeSequences.size();
    }

    @Override
    public String toString() {
        return "SmartList{" +
                "routeSequences=" + routeSequences +
                '}';
    }

    /**
     * adds a matching stop or creates a new chain
     *
     * @param routePair - route combination
     * @param stopId    - the stop being added
     */
    public void add(RoutePair routePair, int stopId) {
        if (routeSequences.containsKey(routePair)) {
            try {
                routeSequences.get(routePair).addStop(routePair, stopId);
            } catch (LockedList e) {
            }
        } else {
            routeSequences.put(routePair, new UtilList(routePair, stopId));
        }
    }

    /**
     * Close the sequence with this routePair for editing
     *
     * @param routePair - Route pair for close
     */
    public void closeSequence(RoutePair routePair) {
        UtilList utilList = routeSequences.get(routePair);
        if (utilList != null)
            utilList.close();
    }

}
