import models.entity.carriage.Flight;
import models.entity.carriage.Route;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class MainTest {

    HashMap<Integer, Route> routes;
    HashMap<String, Flight> flights;
    HashMap<Integer, Route> normalRoutes;

    @Before
    public void setUp() throws Exception {
        // normalRoutes = Reunion.BuildStruct();
    }

    //корректный парс по размеру
    @Test
    public void isCorrectParse() {
        //assertThat(routes.size(), is(986));
        //      assertThat(flights.size(), is(227127));
    }


}
