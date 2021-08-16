package models.entity;

import models.entity.carriage.Route;
import models.entity.carriage.Stop;
import usecase.Reunion;

import java.util.HashMap;

public class TransportNetwork {
    protected HashMap<Integer, Route> network;
    protected HashMap<Integer, Stop> stopNetwork = new HashMap<>();

    public void loadAndBuild() {
        network = Reunion.BuildStruct();
        network.forEach((k, v) -> {
            for (Stop s : v.getStops()) {
                if (stopNetwork.containsKey(s.getStopID())) {
                    stopNetwork.get(s.getStopID()).addRoute(v);
                } else {
                    stopNetwork.put(s.getStopID(), s);
                }
            }

        });

    }

    public HashMap<Integer, Stop> getStopNetwork() {
        return stopNetwork;
    }

    public HashMap<Integer, Route> getNetwork() {
        return network;
    }
}
