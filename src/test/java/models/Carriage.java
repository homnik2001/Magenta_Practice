package models;

import models.entity.carriage.Flight;
import models.entity.carriage.Route;
import models.entity.utility.Time;
import models.excpetions.InvalidTime;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class Carriage {
    private Route route;

    @Before
    public void setUp() throws InvalidTime {
        Flight flight = new Flight("123_2");
        Flight flight_2 = new Flight("123_3");

        for (int i = 0; i < 10; i++) {
            Time t1 = new Time("12:10:12");
            Time t2 = new Time("12:12:12");
            flight.addStop(new Time[]{t1, t2}, Integer.toString(i));
            flight_2.addStop(new Time[]{t1, t2}, Integer.toString(i));

        }
        route = new Route(213);
        route.getFlights().add(flight);
        route.getFlights().add(flight_2);
    }

    /**
     * Test, that flight correctly added
     */
    @Test
    public void whenAddTheFlight() {
        assertThat(route.getFlights().size(), is(2));
        Flight fl = new Flight("123_11");
        route.getFlights().add(fl);
        assertThat(route.getFlights().size(), is(3));

    }

    @Test
    public void testTimeException() {
        String wrongTime = "123:12:12";
        try {
            Time t = new Time(wrongTime);
            fail("lol error");
        } catch (InvalidTime invalidTime) {
            assertThat(invalidTime.getMessage(), containsString(wrongTime));
        }
    }

    @Test
    public void testStopsFromRoutes() {
        assertThat(route.getStops().size(), is(0));
        route.setStopsForRoutes();
        assertThat(route.getStops().size(), is(10));
    }
}
