package models.entity.graph;

import java.util.Objects;

public class Edge {
    private static final int weight = 1;
    private int routeId;  //код маршрута
    private Vertex startVertex;
    private Vertex targetVertex;

    public Edge(Vertex startVertex, Vertex targetVertex) {
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "routeId=" + routeId +
                ", startVertex=" + startVertex.getStopId() +
                ", targetVertex=" + targetVertex.getStopId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return routeId == edge.routeId && startVertex.equals(edge.startVertex) && targetVertex.equals(edge.targetVertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, startVertex, targetVertex);
    }

    public double getWeight() {
        return weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
}