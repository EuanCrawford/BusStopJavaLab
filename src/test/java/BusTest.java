import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person person1;
    private Person person2;
    private Person person3;

    private BusStop busStop;

    @Before
    public void before() {
        bus = new Bus("Glasgow", 2);
        person1 = new Person("John");
        person2 = new Person("Sarah");
        person3 = new Person("Kate");
        busStop = new BusStop("King Street");
        busStop.addPerson(person1);
    }

    @Test
    public void hasDestination() {
        assertEquals("Glasgow", bus.getDestination());
    }

    @Test
    public void hasCapacity() {
        assertEquals(2, bus.getCapacity());
    }

    @Test
    public void startsWithNoPassengers() {
        assertEquals(0, bus.getNoOfPassengers());
    }

    @Test
    public void canAddPassenger() {
        bus.addPassenger(person1);
        assertEquals(1, bus.getNoOfPassengers());
    }

    @Test
    public void canRemovePassenger() {
        bus.addPassenger(person1);
        bus.removePassengers(person1);
        assertEquals(0, bus.getNoOfPassengers());
    }

    @Test
    public void canPickPassengersUp() {
        bus.pickUp(busStop);
        assertEquals(1, bus.getNoOfPassengers());
    }

    @Test
    public void canRemoveFromQueueWhenPickingUp() {
        bus.pickUp(busStop);
        assertEquals(0, busStop.getSizeOfQueue());
    }

    @Test
    public void cantPickUpFromBusStop() {
        bus.addPassenger(person2);
        bus.addPassenger(person3);
        bus.pickUp(busStop);
        assertEquals(2, bus.getNoOfPassengers());
        assertEquals(1, busStop.getSizeOfQueue());
    }

    @Test
    public void cantPickUpFromEmptyStop() {
        busStop.removePerson();
        bus.pickUp(busStop);
        assertEquals(0, bus.getNoOfPassengers());
    }
}
