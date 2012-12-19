package edu.buaa.test;

import edu.buaa.park.Car;
import edu.buaa.park.FirstAvailableParkingLotChooser;
import edu.buaa.park.ParkPlace;
import edu.buaa.park.ParkingBoy;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;


public class FirstAvailableParkingTest {
    private ParkingBoy parkingBoy;
    @Before
    public void init(){
        parkingBoy=new ParkingBoy(Arrays.asList(new ParkPlace(10), new ParkPlace(20)),new FirstAvailableParkingLotChooser());
    }
    /*两个停车场，第一个停车场未满                             停车                        停在第一个停车场，第一个停车场车位减1*/
    @Test
    public void should_park_inTheFirstParkplace_when_parkCar_if_theFirstParkPlace_notFull(){
        for(int i=0;i<new Random().nextInt(parkingBoy.getParkPlaces().get(0).getCapacity());i++)parkingBoy.getParkPlaces().get(0).park(new Car());
        for(int i=0;i<new Random().nextInt(parkingBoy.getParkPlaces().get(1).getCapacity());i++)parkingBoy.getParkPlaces().get(1).park(new Car());
        int availableNum_beforePark=parkingBoy.getParkPlaces().get(0).getAvailableNum();
        parkingBoy.park(new Car());
        Assert.assertEquals(availableNum_beforePark-1,parkingBoy.getParkPlaces().get(0).getAvailableNum());
    }
    /*两空车场停超过第一个停车场车位数但小于总车位数的车       停车                        第一个停车场满*/
    @Test
    public void should_have_no_parkPlace_when_getTheFirstParkPlace_AvailableNum_if_park_moreThan_theFirstCapacity(){
        for(int i=0;i<parkingBoy.getParkPlaces().get(0).getCapacity()+new Random().nextInt(parkingBoy.getParkPlaces().get(1).getCapacity());i++)
            parkingBoy.park(new Car());
        Assert.assertEquals(0,parkingBoy.getParkPlaces().get(0).getAvailableNum());
    }

}
