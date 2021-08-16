package models.entity;

import models.entity.graph.Graph;
import models.entity.graph.Vertex;
import models.entity.utility.RoutePair;
import models.entity.utility.UtilList;
import usecase.GraphHandler;

import java.util.HashMap;
import java.util.TreeSet;

public class TransportNetworkAsGraph extends TransportNetwork {
    private Graph graph;
    private HashMap<RoutePair, UtilList> consolidatedRoutes;

    public HashMap<RoutePair, UtilList> getConsolidatedRoutes() {
        return consolidatedRoutes;
    }

    public HashMap<Integer, Vertex> getGraph() {
        return graph.getGraph();
    }

    /**
     * Create Graph with consolidated routes and their occurrence
     *
     * @return Graph of TN
     */
    public TransportNetworkAsGraph Create() {
        graph = GraphHandler.createGraph(getNetwork());
        consolidatedRoutes = GraphHandler.consolidateRoutes(graph);
        setOccurrence();
        return this;
    }

    /**
     * Calculate max percentage  of occurrence of one route in another
     *
     * @param list that will bi analyze
     * @return the max percentage  of occurrence of one route in another
     */
    private double percOfOccurrence(UtilList list) {
        int rId_1 = list.getRoutes().getRoute0();// id of the first route
        int rId_2 = list.getRoutes().getRoute1(); //if of the second route
        double sofRid_1 = network.get(rId_1).getStops().size();
        double sofRid_2 = network.get(rId_2).getStops().size();

        double percent_1 = list.getStopIds().size() / sofRid_1;
        double percent_2 = list.getStopIds().size() / sofRid_2;

        if (percent_1 > percent_2)
            return percent_1 * 100;
        else
            return percent_2 * 100;
    }

    /**
     * Exposes occurrence for UtilLists
     */
    private void setOccurrence() {
        consolidatedRoutes.forEach((k, v) -> {
            v.setOccurrence(percOfOccurrence(v));
        });
    }

    /**
     * Check the highest percentage of route occurrences
     */
    public TreeSet<UtilList> CheckOccurrence() {
        TreeSet<UtilList> percents = new TreeSet<>();
        consolidatedRoutes.forEach((k, v) -> {
            percents.add(v);
        });

        return percents;
    }
}
