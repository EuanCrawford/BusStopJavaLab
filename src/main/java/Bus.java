import java.util.ArrayList;

public class Bus {

    private String destination;
    private int capacity;
    private ArrayList<Person> passengers;

    public Bus(String destination, int capacity) {
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<Person>();
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNoOfPassengers() {
        return passengers.size();
    }

    public void addPassenger(Person person) {
        if (passengers.size() < this.capacity) {
            passengers.add(person);
        }
    }

    public void removePassengers(Person person) {
        passengers.remove(person);
    }

    public void pickUp(BusStop busStop) {
        if (passengers.size() < this.capacity && busStop.getSizeOfQueue() > 0) {
            Person passengerAtStop = busStop.removePerson();
            this.addPassenger(passengerAtStop);
        }
    }
}
