package edu.buaa.park;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午12:54
 * To change this template use File | Settings | File Templates.
 */
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
       return parkStrategy.getAvailablePark(parkPlaces).parkCar(car);
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
