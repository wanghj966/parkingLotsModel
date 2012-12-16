package edu.buaa.finalexam;

import edu.buaa.park.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wanghj
 * Date: 12-12-16
 * Time: 上午3:03
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManager {
    private List<ParkPlace> parkPlaces;
    private final ParkingLotChooser parkingLotChooser;
    private List<ParkingBoy> managedParkingboys;

    public ParkingManager(List<ParkPlace> parkPlaces, ParkingLotChooser parkingLotChooser) {
        this.parkPlaces=parkPlaces;
        this.parkingLotChooser = parkingLotChooser;
    }
    public ParkingManager(List<ParkPlace> parkPlaces, ParkingLotChooser parkingLotChooser,List<ParkingBoy> parkingBoys) {
        this.parkPlaces=parkPlaces;
        this.parkingLotChooser = parkingLotChooser;
        this.managedParkingboys=parkingBoys;
    }
    public void addParkingBoy(ParkingBoy parkingBoy){
          this.managedParkingboys.add(parkingBoy);
    }
    public Ticket park(Car car) {
        return parkingLotChooser.getAvailablePark(parkPlaces).parkCar(car);
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
