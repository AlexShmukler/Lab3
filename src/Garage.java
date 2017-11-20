import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Garage {
    private List<Bus> buses;
    private int capacity;
    private String location;

    public Garage(){
        this.capacity = 10;
        this.location = "Main Str. 32";
        this.buses = new ArrayList<Bus>();
    }
    public Garage(int capacity, String location){
        if ((!(capacity > 1 | capacity < 20))) throw new IllegalArgumentException("Wrong input(1 < capacity < 20)");
        this.capacity = capacity;
        this.location = location;
        this.buses = new ArrayList<Bus>();
    }

    public Garage(int capacity, String location, List<Bus> buses){
        this.location = location;
        this.capacity = capacity;
        this.buses = buses;
    }

    public void deleteBus(String number){
        for(Bus i: this.buses){
            if(i.getNumber().equals(number)) {
                this.buses.remove(i);
                return;
            }
            throw new RuntimeException("Product with this number not found, try another bus number");
        }
    }

    public List<Bus> busesInAlphabeticalOrder(){
        List<Bus> garage = new ArrayList<>();
        List<Bus> tempGarage = this.buses;
        List<String> temp1 = new ArrayList<>();
        for (Bus bus : tempGarage)
            temp1.add(bus.getNumber());
        Collections.sort(temp1);
        for(Bus bus : tempGarage){
            for(int i=0;i<temp1.size();i++){
                if(bus.getNumber() == temp1.get(i)){
                    garage.add(bus);
                }
            }
        }
        return garage;
    }

    public List<Bus> busesSort(){
        List<Bus> resultGarage = new ArrayList<>();
        List<Bus> tempGarage = this.buses;
        Garage temp = new Garage();
        int min_capacity = 201;
        for(int i = 0; i < this.buses.size()+1; i++) {
            for (Bus bus : tempGarage) {
                if (bus.getCapacity() < min_capacity)
                         min_capacity = bus.getCapacity();
            }
            for(int j=0; j<tempGarage.size(); j++){
                if(tempGarage.get(j).getCapacity() == min_capacity) {
                    temp.buses.add(tempGarage.get(j));
                    tempGarage.remove(j);

                }
            }
            temp.buses = temp.busesInAlphabeticalOrder();
            resultGarage.addAll(temp.buses);
            temp.buses.removeAll(buses);
            min_capacity = 201;
        }

        return resultGarage;
    }
    public void addBus(Bus bus){
        this.buses.add(bus);
    }

    public boolean isEnoughtBuses(int people){
        int allPeople=0;
        for(Bus i:this.buses){
            allPeople+=i.getCapacity();
        }
        return allPeople>=people;
    }

    @Override
    public int hashCode() {
        int result = capacity * 31;
        result+=location.hashCode();
        result+= buses.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(this.getClass()!=obj.getClass())
            return false;
        Garage temp = (Garage)obj;
        return ( (this.capacity==temp.capacity) || (this.location==temp.location) || (this.buses ==temp.buses));
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAmountOfBuses(){
        return this.buses.size();
    }


}
