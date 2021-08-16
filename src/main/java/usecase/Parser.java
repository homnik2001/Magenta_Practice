package usecase;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import models.entity.carriage.Flight;
import models.entity.carriage.Route;
import models.entity.utility.UtilityParsers.FlightParse;
import models.entity.utility.UtilityParsers.FlightPostParse;
import models.entity.utility.UtilityParsers.RouteParse;
import models.excpetions.InvalidTime;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Parser {
    private static final String[] columnsOfFlight = new String[]{
            "object_category_Id", "global_id", "stop_times_id",
            "trip_id", "arrival_time", "departure_time", "stop_id", "shape_dist_traveled",
            "pickup_type", "stop_headsign", "stop_sequence", "trip_type", "stop_interval"};
    private static final String[] columnsOfRoute = new String[]{
            "object_category_Id", "global_id", "route_id",
            "service_id", "trip_id", "trip_headsign", "direction_id",
            "block_id", "volume_id", "trip_type"};


    //Составляем хэшмпэпу рейсов со временем
    public static HashMap<String, Flight> ParseFlights() {
        HashMap<String, Flight> flightHashMap = new HashMap<>();
        List list = Read("/Users/khomenko/IdeaProjects/Magenta/flights.csv",
                columnsOfFlight, FlightParse.class);
        ArrayList<String> listToRemove = new ArrayList<>();
        for (Object object : list) {
            FlightPostParse tmp = new FlightPostParse((FlightParse) object);
            String trId = tmp.getId();
            if (flightHashMap.containsKey(trId)) {
                try {
                    flightHashMap.get(trId).addStop(tmp.getTime(), tmp.getStopId());
                } catch (InvalidTime e) {
                    listToRemove.add(trId);
                } catch (NullPointerException e2) {
                    listToRemove.add(trId);
                }
            } else {
                try {
                    Flight fl = new Flight(trId, tmp.getTime(), tmp.getStopId());
                    flightHashMap.put(trId, fl);
                } catch (InvalidTime e) {

                } catch (NullPointerException e2) {
                    listToRemove.add(trId);
                }

            }
        }
        for (String str : listToRemove) {
            flightHashMap.remove(str);

        }
        return flightHashMap;
    }


    //Мэйн хэшмпэпа с маршрутами
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static HashMap<Integer, Route> ParseRoutes() {
        HashMap<Integer, Route> routeHashMap = new HashMap<>();
        List list = Read("/Users/khomenko/IdeaProjects/Magenta/routes.csv",
                columnsOfRoute, RouteParse.class);
        for (Object object : list) {
            RouteParse tmp = (RouteParse) object;
            Integer rId = Integer.parseInt(tmp.getRoute_id());

            String trId = tmp.getTrip_id();
            if (routeHashMap.containsKey(rId)) {
                routeHashMap.get(rId).getFlights().add(new Flight(trId));
            } else {
                Route rt = new Route(rId, trId);
                routeHashMap.put(rId, rt);
            }
        }
        return routeHashMap;
    }


    @SuppressWarnings({"rawtypes", "unchecked"})//связывание csv файла со списком компонентов
    private static <T> ColumnPositionMappingStrategy setColumnMapping(String[] columns, Class<T> clazz) {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        try {
            if (RouteParse.class.equals(clazz)) {
                strategy.setType(RouteParse.class); //
            } else if (FlightParse.class.equals(clazz)) {
                strategy.setType(FlightParse.class); //
            } else {
                throw new ClassCastException();
                //throw some exception
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        strategy.setColumnMapping(columns);
        return strategy;

    }

    //универсальный метод на чтение
    private final static <T> List<T> Read(String fileName, String[] columns, Class<T> clazz) {
        CsvToBean csv = new CsvToBean();
        String csvFilename = fileName;

        CSVReader csvReader;// разделитель - ;
        try {
            csvReader = new CSVReader(new FileReader(csvFilename),
                    ';', '"', 1);
            return csv.parse(setColumnMapping(columns, clazz), csvReader);//Возвращаем лист считанных элементов

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Please correct filepath to dataset");
        }
        return null;
    }
}
