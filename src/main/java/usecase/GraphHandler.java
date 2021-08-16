package usecase;

import models.entity.carriage.Route;
import models.entity.carriage.Stop;
import models.entity.graph.Edge;
import models.entity.graph.Graph;
import models.entity.graph.Vertex;
import models.entity.utility.RoutePair;
import models.entity.utility.UtilList;

import java.util.HashMap;


public final class GraphHandler {

    public static Graph createGraph(HashMap<Integer, Route> routes) {
        Graph graph = new Graph();
        routes.forEach((k, v) -> {

            Vertex saver = null;

            int i = 0;
            int routeId = v.getRouteId();
            for (Stop s : v.getStops()) {

                Vertex tmp = new Vertex(s.getStopID());
                graph.correctVertex(tmp, routeId, i);
                if (saver != null) {
                    Edge edge1 = new Edge(saver, tmp);
                    Edge edge2 = new Edge(tmp, saver);
                    graph.addEdgeToVertex(saver, edge1);
                    graph.addEdgeToVertex(tmp, edge2);
                }
                saver = tmp;
                i++;
            }
        });

        return graph;
    }

    public static HashMap<RoutePair, UtilList> consolidateRoutes(Graph graph) {
        return Consolidation.detour(graph.getGraph());
    }


}
