package edu.buaa.test;

import edu.buaa.park.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class MaxAvailableRateParkingTest {
    private Integer totalAmount;
    private ParkingBoy parkingBoy;
    private List<ParkPlace> parkPlaces;
    @Before
    public void init(){
        List<ParkPlace> parkPlaces=new ArrayList<ParkPlace>();
        Integer[] parkPlaceNums= new Integer[]{10, 20};
        totalAmount=0;
        for(Integer parknum:parkPlaceNums){
            parkPlaces.add(new ParkPlace(parknum));
            totalAmount+=parknum;
        }
        parkingBoy=new ParkingBoy(parkPlaces,new MaxAvailableRateParkingLotChooser());
        this.parkPlaces=parkPlaces;
    }
    /*
    * kong
    * */
    @Test
     public  void should_park_in_the_first_parkplace_when_two_empty(){
        parkingBoy.park(new Car());
        Assert.assertEquals(9, parkPlaces.get(0).getAvailableNum());
    }
    /*都停了5辆车，停在第二辆*/
    @Test
    public  void should_park_in_the_second_parkplace_when_second_had_greaterAvailableRate(){
        for(int i=0;i<5;i++){parkPlaces.get(0).park(new Car());}
        for(int i=0;i<5;i++){parkPlaces.get(1).park(new Car());}
        parkingBoy.park(new Car());
        Assert.assertEquals(14, parkPlaces.get(1).getAvailableNum());
    }
    /*第一个停车场停了5辆车，第二个停了15辆车，停在第一个*/
    @Test
    public  void should_park_in_the_first_parkplace_when_firstPark_hasLessPlaces_but_greaterAvailableRate(){
        for(int i=0;i<5;i++){parkPlaces.get(0).park(new Car());}
        for(int i=0;i<15;i++){parkPlaces.get(1).park(new Car());}
        parkingBoy.park(new Car());
        Assert.assertEquals(4, parkPlaces.get(0).getAvailableNum());
    }

 }
