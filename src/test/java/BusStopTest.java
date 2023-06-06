import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    private BusStop busStop;
    private Person person1;
    private Person person2;

    @Before
    public void before() {
        busStop = new BusStop("King Street");
        person1 = new Person("John");
        person2 = new Person("Sarah");
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
        busStop.addPerson(person1);
        assertEquals(1, busStop.getSizeOfQueue());
    }

    @Test
    public void canRemovePersonFromBusStop() {
        busStop.addPerson(person1);
        busStop.addPerson(person2);
        busStop.removePerson();
        assertEquals(1, busStop.getSizeOfQueue());
    }
}

