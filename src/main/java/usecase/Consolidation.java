package usecase;

import models.entity.graph.Edge;
import models.entity.graph.Vertex;
import models.entity.utility.PairOfStop;
import models.entity.utility.RoutePair;
import models.entity.utility.SmartList;
import models.entity.utility.UtilList;

import java.util.HashMap;
import java.util.HashSet;

public class Consolidation implements Consolidator {
    public static SmartList completedConsolidation = new SmartList();

    /**
     * A general pass with the launch of recursive algorithms.
     * It is needed for working with graphs with connectivity coefficients greater than 2
     *
     * @param graph traversed graph
     */
    public static HashMap<RoutePair, UtilList> detour(HashMap<Integer, Vertex> graph) {
        completedConsolidation = new SmartList();
        HashSet<Integer> a = new HashSet<>();
        for (Vertex v : graph.values()
        ) {
            if (!v.isVisited()) {
                scan(v, new HashSet<>());
            }
        }
        return completedConsolidation.getRouteSequences();

    }

    /**
     * A recursive algorithm for traversing a
     * graph with filling in sequences of routes
     *
     * @param v          - start vertex
     * @param activPairs - set of sequences on the previous vertex
     */
    public static void scan(Vertex v, HashSet<RoutePair> activPairs) {

        for (Edge edge : v.getEdges()) {

            HashSet<RoutePair> routePairs = getVertexPairs(v);

            for (RoutePair tmpPair : activPairs) {
                if (!routePairs.contains(tmpPair)) {
                    completedConsolidation.closeSequence(tmpPair);
                }
            }
            //продолжаем последовательности
            for (RoutePair tmpPair : activPairs
            ) {
                completedConsolidation.add(tmpPair, v.getStopId());
            }

            if (!edge.getTargetVertex().isVisited()) {
                edge.getTargetVertex().setVisited(true);
                scan(edge.getTargetVertex(), routePairs);
            }
            return;
        }
    }


    /**
     * creating all pairs for consolidation of the current vertex
     *
     * @param vertex which will be analyzed
     * @return HashSet with all Pairs at this vertex
     */
    private static HashSet<RoutePair> getVertexPairs(Vertex vertex) {
        HashSet<RoutePair> routePairs = new HashSet<>();

        for (PairOfStop pair : vertex.getPair()) {

            for (PairOfStop pair1 : vertex.getPair()) {
                if (!pair1.equals(pair)) {
                    routePairs.add(new RoutePair(pair.getRouteId(), pair1.getRouteId()));
                }
            }
        }
        return routePairs;
    }

    @Override
    public SmartList consolidate() {
        return null;
    }
}
