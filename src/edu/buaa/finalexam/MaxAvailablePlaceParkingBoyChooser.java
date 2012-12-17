package edu.buaa.finalexam;

import edu.buaa.park.ParkFullException;
import edu.buaa.park.ParkingBoy;

import java.util.List;


public class MaxAvailablePlaceParkingBoyChooser implements ParkingBoyChooser {
    @Override
    public ParkingBoy getAvailableParkingBoy(List<ParkingBoy> parkingBoys) {
        ParkingBoy choosedParkingBoy=parkingBoys.get(0);
        for(ParkingBoy parkingBoy:parkingBoys){
           if(choosedParkingBoy.getAvailableNum()<parkingBoy.getAvailableNum())
               choosedParkingBoy=parkingBoy;
        }
        if(choosedParkingBoy.getAvailableNum()==0)  throw new ParkFullException("所有的停车场都已满");
        return choosedParkingBoy;
    }
}
