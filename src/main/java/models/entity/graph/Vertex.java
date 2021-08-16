package models.entity.graph;

import models.entity.utility.PairOfStop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Vertex implements Comparable<Vertex> {
    private int stopId;
    private ArrayList<PairOfStop> pair = new ArrayList<>();
    private HashSet<Edge> edges;
    private boolean visited = false;
    private Vertex previosVertex;
    private double minDistance = Double.MAX_VALUE;

    public Vertex(int stopId) {
        this.stopId = stopId;
        this.edges = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return stopId == vertex.stopId && visited == vertex.visited && Double.compare(vertex.minDistance, minDistance) == 0 && Objects.equals(previosVertex, vertex.previosVertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stopId, visited, previosVertex, minDistance);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "stopId=" + stopId +
                ", edges=" + edges +
                '}';
    }

    public void addRouteSequence(int routeId, int numOfSequence) {

        pair.add(new PairOfStop(routeId, numOfSequence));
    }

    public ArrayList<PairOfStop> getPair() {
        return pair;
    }

    public void addPair(ArrayList<PairOfStop> pair) {
        this.pair = pair;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public void addNeighbour(Edge edge) {
        this.edges.add(edge);
    }

    public HashSet<Edge> getEdges() {
        return edges;
    }

    public void setEdges(HashSet<Edge> edges) {
        this.edges = edges;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPreviosVertex() {
        return previosVertex;
    }

    public void setPreviosVertex(Vertex previosVertex) {
        this.previosVertex = previosVertex;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }


    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.edges.size(), otherVertex.edges.size());

    }
}