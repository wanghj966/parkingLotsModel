package edu.buaa.park;

import java.util.Collection;
import java.util.List;

public class ParkingBoy {
    private Collection<ParkPlace> parkPlaces;
    public ParkingBoy(Collection<ParkPlace> parkPlaces) {
        this.parkPlaces=parkPlaces;
    }
    public Ticket park(Car car) {
      return getAvailablePark().parkCar(car);
    }
    public ParkPlace getAvailablePark(){
        for(ParkPlace parkPlace:parkPlaces){
            if(parkPlace.getAvailableNum()>0) return parkPlace;
        }
        throw new ParkFullException("所有的停车场都已满");
    }
    public Integer getAvailableNum() {
        int availableNum=0;
        for(ParkPlace parkPlace:parkPlaces){
            availableNum+=parkPlace.getAvailableNum();
        }
       return availableNum;
    }
    public Car fetch(Ticket ticket) {
        Car fetchedCar=null;
        for(ParkPlace parkPlace:parkPlaces){
            fetchedCar=parkPlace.fecthCar(ticket);
            if(fetchedCar!=null){return fetchedCar;}
        }
        throw new NoCarException("没有此车");
    }

}
