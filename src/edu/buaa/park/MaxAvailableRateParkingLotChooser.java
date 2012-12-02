package edu.buaa.park;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午4:00
 * To change this template use File | Settings | File Templates.
 */
public class MaxAvailableRateParkingLotChooser implements ParkingLotChooser {

    @Override
    public ParkPlace getAvailablePark(List<ParkPlace> parks) {
         ParkPlace availableParkPlace=parks.get(0);
        for(ParkPlace parkPlace:parks){
            if(parkPlace.getAvailableRate()>availableParkPlace.getAvailableRate()){
                availableParkPlace=parkPlace;
            }
        }
        if(availableParkPlace.getAvailableNum()==0) throw new ParkFullException("所有的停车场都已满");
        return  availableParkPlace;
    }
}
