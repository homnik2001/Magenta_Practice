package models.entity.utility;

public class PairOfStop {
    private int routeId;
    public int stopId;
    public int numOfSequence;

    public int getRouteId() {
        return routeId;
    }

    public PairOfStop(int routeId, int numOfSequence) {
        this.routeId = routeId;
        this.numOfSequence = numOfSequence;
    }

    @Override
    public String toString() {
        return "PairOfStop{" +
                "routeId=" + routeId +
                ", stopId=" + stopId +
                ", numOfSequence=" + numOfSequence +
                '}';
    }
}
