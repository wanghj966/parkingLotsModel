package edu.buaa.finalexam;

import edu.buaa.park.*;

import java.util.ArrayList;
import java.util.List;
public class ParkingManager{
    private List<ParkingBoy> managedParkingboys=new ArrayList<ParkingBoy>();
    private final  ParkingBoyChooser parkingBoyChooser;
    public ParkingManager(List<ParkPlace> parkPlaces, ParkingLotChooser parkingLotChooser, List<ParkingBoy> parkingBoys, ParkingBoyChooser parkingBoyChooser) {
        this.managedParkingboys.add(new ParkingBoy(parkPlaces,parkingLotChooser));
        this.managedParkingboys.addAll(parkingBoys);
        this.parkingBoyChooser = parkingBoyChooser;
    }
    public Ticket park(Car car) {
        return parkingBoyChooser.getAvailableParkingBoy(managedParkingboys).park(car);
    }
    public Integer getAvailableNum() {
        return managedParkingboys.get(0).getAvailableNum();
    }
    public Car fetch(Ticket ticket) {
        Car fetchedCar;
        for(ParkingBoy parkingBoy:managedParkingboys){
            fetchedCar=parkingBoy.fetch(ticket);
            if(fetchedCar!=null){return fetchedCar;}
        }
        throw new NoCarException("没有此车");
    }
}
