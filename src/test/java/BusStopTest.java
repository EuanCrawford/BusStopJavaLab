import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    private BusStop busStop;
    private Person person;

    @Before
    public void before() {
        busStop = new BusStop("King Street");
        person = new Person("John");
    }

    @Test
    public void hasName() {
        assertEquals("King Street", busStop.getName());
    }

    @Test
    public void queueStartsEmpty() {
        assertEquals(0, busStop.getSizeOfQueue());
    }

    @Test
    public void canAddPersonToBusStop() {
        busStop.addPerson(person);
        assertEquals(1, busStop.getSizeOfQueue());
    }

    @Test
    public void canRemovePersonFromBusStop() {
        busStop.addPerson(person);
        busStop.removePerson();
        assertEquals(0, busStop.getSizeOfQueue());
    }
}

