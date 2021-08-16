package models;

import models.entity.TransportNetworkAsGraph;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

public class Networks {
    TransportNetworkAsGraph tn = new TransportNetworkAsGraph();

    @Before
    public void setUp() {
        tn.loadAndBuild();
        tn = tn.Create();
    }

    @Test
    public void goodSizeOfStruct() {
        assertThat(tn.getNetwork().size(), is(460));

    }

    @Test
    public void goodSizeOfStops() {
        assertThat(tn.getStopNetwork().size(), is(9385));
    }

    @Test
    public void checkConsolidatedRoutes() {
        assertThat(tn.getConsolidatedRoutes().size(), is(2484));
    }
    @Test
    public void checkOccurrence(){
        double occurrence =  tn.CheckOccurrence().first().getOccurrence();
        assertNotEquals(occurrence, 0 );
    }


}
