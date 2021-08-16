package models.entity.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    HashMap<Integer, Vertex> graph = new HashMap<>();

    public void addEdgeToVertex(Vertex vertex, Edge edge) {
        graph.get(vertex.getStopId()).addNeighbour(edge);
    }


    /**
     * Put the vertex to the graph
     * or adds values for a given vertex
     *
     * @param vertex
     * @param routeId
     * @param numOfSequence
     */
    public void correctVertex(Vertex vertex, int routeId, int numOfSequence) {
        int stopId = vertex.getStopId();
        if (graph.containsKey(stopId)) {
            //добавляем заданный рут+ порядок
            graph.get(stopId).addRouteSequence(routeId, numOfSequence);

        } else {
            graph.put(stopId, vertex);
            graph.get(stopId).addRouteSequence(routeId, numOfSequence);
            //добавляем рут + порядок
        }
    }

    public HashMap<Integer, Vertex> getGraph() {
        return graph;
    }

    public void viewSortedSize() {
        ArrayList<Vertex> arm = new ArrayList(graph.values());

        arm.sort(Vertex::compareTo);
        for (Vertex v : arm
        ) {
            System.out.print(v.getEdges().size() + " ");
        }
    }


}
