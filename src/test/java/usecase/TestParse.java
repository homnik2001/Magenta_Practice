package usecase;


import models.entity.carriage.Flight;
import models.entity.carriage.Route;
import models.entity.utility.Time;
import models.excpetions.InvalidTime;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class TestParse {

    HashMap<String, Flight> flights;
    HashMap<Integer, Route> normalRoutes;

    @Before
    public void setUp() throws Exception {
         normalRoutes = Parser.ParseRoutes();
         flights = Parser.ParseFlights();
    }

    @Test
    public void checkRoteParse(){
        assertThat(normalRoutes.size(), is (986));
    }
    @Test
    public void checkFlightsParse(){
        assertThat(flights.size(), is(218422));
    }

}
