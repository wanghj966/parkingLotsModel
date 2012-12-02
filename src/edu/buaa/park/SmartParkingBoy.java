package edu.buaa.park;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午12:35
 * To change this template use File | Settings | File Templates.
 */
public class SmartParkingBoy extends ParkingBoy{
    private List<ParkPlace> parkPlaces;
    public SmartParkingBoy(List<ParkPlace> parkPlaces) {
        super(parkPlaces);
        this.parkPlaces=parkPlaces;
    }
    public ParkPlace getAvailablePark(){
        int maxsizeIndex=0;
        for(int i=1;i<parkPlaces.size();i++){
            if(parkPlaces.get(i).getAvailableNum()>parkPlaces.get(maxsizeIndex).getAvailableNum())
                maxsizeIndex=i;
        }
        if(parkPlaces.get(maxsizeIndex).getAvailableNum()==0)throw new ParkFullException("所有的停车场都已满");
        return   parkPlaces.get(maxsizeIndex);
    }

}
