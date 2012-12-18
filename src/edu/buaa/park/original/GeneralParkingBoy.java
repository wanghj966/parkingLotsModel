package edu.buaa.park.original;

import edu.buaa.park.*;

import java.util.List;

public class GeneralParkingBoy {
    private List<ParkPlace> parkPlaces;
    private ParkingLotChooser parkStrategy;
    public GeneralParkingBoy(List<ParkPlace> parkPlaces) {
        this.parkPlaces=parkPlaces;
    }
    public GeneralParkingBoy(List<ParkPlace> parkPlaces,ParkingLotChooser parkStrategy) {
        this.parkPlaces=parkPlaces;
        this.parkStrategy=parkStrategy;
    }
    public Ticket park(Car car) {
       return parkStrategy.getAvailablePark(parkPlaces).park(car);
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
            fetchedCar=parkPlace.fetch(ticket);
            if(fetchedCar!=null){return fetchedCar;}
        }
        throw new NoCarException("没有此车");
    }
}
