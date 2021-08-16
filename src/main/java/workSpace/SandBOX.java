package workSpace;

import models.entity.TransportNetworkAsGraph;
import models.entity.carriage.Route;
import models.entity.carriage.Stop;

public class SandBOX {
    public static void main(String[] args) throws Exception {
        // создание и консолидация графа

        TransportNetworkAsGraph tn = new TransportNetworkAsGraph();
        tn.loadAndBuild();
        tn = tn.Create();
        int a = 0;
        for (Route rt : tn.getNetwork().values()) {
            if (a < rt.getStops().size())
                a = rt.getStops().size();
        }
        System.out.println(a + " - max stops on the route ");


        System.out.println( "Наибольщий процент совпадения маршрутов: "
                + tn.CheckOccurrence().last().getOccurrence() );
        //самая загруженная остановка по числу маршрутов
        Stop maxStop = new Stop(-3);
        for (Stop s : tn.getStopNetwork().values()) {

            if (s.compareTo(maxStop) > 0)
                maxStop = s;
        }
        System.out.println( maxStop.getRoutes().size());


    }

}
