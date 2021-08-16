package usecase;

import models.entity.carriage.Flight;
import models.entity.carriage.Route;

import java.util.ArrayList;
import java.util.HashMap;

public final class Reunion extends Parser {

    public static HashMap<Integer, Route> BuildStruct() {

        HashMap<String, Flight> flightHashMap = ParseFlights();
        HashMap<Integer, Route> routeHashMap = ParseRoutes();

        ArrayList<Integer> listToRemove = new ArrayList<>();
        routeHashMap.forEach((k, v) -> {
            for (Flight fl : v.getFlights()) {
                Flight ftmp;
                if ((ftmp = flightHashMap.get(fl.getId())) == null) {
                    listToRemove.add(k);
                } else {
                    fl.setTimes(ftmp.getTimes());
                    fl.setStopId(ftmp.getStopId());
                }
            }
            v.setStopsForRoutes();
        });
        for (Integer tmp : listToRemove) {
            routeHashMap.remove(tmp);
        }
        BuildStopNetwork(routeHashMap);
        return routeHashMap;
    }

    private static void BuildStopNetwork(HashMap<Integer, Route> routes) {
        // HashMap<Integer, Stop> a = new HashMap<>();

        //билдить новую структуру на основе нынешнего мэпа с рутами
        routes.forEach((k, v) -> {
            v.getStops().forEach(s -> {
                        s.addRoute(v);
                    }
            );
        });

    }


}

