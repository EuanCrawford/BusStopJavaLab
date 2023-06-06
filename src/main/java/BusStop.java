import java.util.ArrayList;

public class BusStop {

    private String name;
    private ArrayList<Person> queue;

    public BusStop(String name) {
        this.name = name;
        this.queue = new ArrayList<Person>();
    }

    public String getName() {
        return name;
    }

    public int getSizeOfQueue() {
        return queue.size();
    }

    public void addPerson(Person person) {
        queue.add(person);
    }

    public Person removePerson() {
        Person passengerAtStop = null;
        if (this.getSizeOfQueue() > 0) {
            passengerAtStop = queue.remove(0);
        }
        return passengerAtStop;
    }
}
