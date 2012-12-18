package edu.buaa.park;
import java.util.*;

public class ParkPlace {
    private int availableNum;
    private final int capacity;
    private Map<Ticket,Car> placeCarMaps=new HashMap<Ticket,Car>() ;
    public ParkPlace(int capacity) {
        this.capacity=capacity;
        this.availableNum=capacity;
    }
    public Ticket  park(Car car){
        if(availableNum<=0) throw new ParkFullException("车库满了");
        Ticket ticket=new Ticket();
        placeCarMaps.put(ticket,car);
        availableNum--;
        return ticket;
    }
    public int getAvailableNum() {
        return availableNum;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getAvailableRate(){
        return (double)availableNum/(double)capacity;
    }
    public Car fetch(Ticket ticket) {
        Car car=placeCarMaps.get(ticket);
        if(car!=null){
        placeCarMaps.remove(ticket);
        availableNum++;}
        return car;
    }
}
