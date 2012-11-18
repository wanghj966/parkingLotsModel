package edu.buaa.park;
import java.util.*;

public class Park {
    private int capacity;
    private Map<Ticket,Car> placeCarMaps=new HashMap<Ticket,Car>() ;
    public Park(int capacity) {
        this.capacity=capacity;
    }
    public Ticket  parkCar(Car car){
        if(capacity<=0) throw new CarFullException("车库满了");
        Ticket ticket=new Ticket();
        placeCarMaps.put(ticket,new Car());
        capacity--;
        return ticket;
    }
    public int getCapacity() {
        return capacity;
    }

    public Car fecthCar(Ticket ticket) {
        Car car=placeCarMaps.get(ticket);
        if(car==null) throw new NoCarException("没有您要的车");
        placeCarMaps.remove(ticket);
        capacity++;
        return car;
    }
}
