package edu.buaa.park;

import java.util.List;

public class ParkingBoy{
    protected List<ParkPlace> parkPlaces;
    private final ParkingLotChooser parkingLotChooser;

    public ParkingBoy(List<ParkPlace> parkPlaces, ParkingLotChooser parkingLotChooser) {
        this.parkPlaces=parkPlaces;
        this.parkingLotChooser = parkingLotChooser;
    }

    public List<ParkPlace> getParkPlaces() {
        return parkPlaces;
    }

    public Ticket park(Car car) {
        return parkingLotChooser.getAvailablePark(parkPlaces).park(car);
    }

    public int getAvailableNum() {
        int availableNum=0;
        for(ParkPlace parkPlace:parkPlaces){
            availableNum+=parkPlace.getAvailableNum();
        }
        return availableNum;
    }
    public int getCapacity(){
        int totalCapacity=0;
        for(ParkPlace parkPlace:parkPlaces){
            totalCapacity+=parkPlace.getCapacity();
        }
        return totalCapacity;
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