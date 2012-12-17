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

    public List<ParkingBoy> getManagedParkingboys() {
        return managedParkingboys;
    }

    public int getAvailableNum() {
        int availableNum=0;
        for(ParkingBoy parkingBoy:managedParkingboys){
            availableNum+=parkingBoy.getAvailableNum();
        }
        return availableNum;
    }
    public int getCapacity(){
        int totalCapacity=0;
        for(ParkingBoy parkingBoy:managedParkingboys){
            totalCapacity+=parkingBoy.getCapacity();
        }
        return totalCapacity;
    }
    public Car fetch(Ticket ticket) {
        Car fetchedCar=null;
        for(ParkingBoy parkingBoy:managedParkingboys){
            try{fetchedCar=parkingBoy.fetch(ticket);}
            catch(NoCarException e){
                fetchedCar=null;
            }
            if(fetchedCar!=null){return fetchedCar;}
        }
        throw new NoCarException("没有此车");
    }
}
