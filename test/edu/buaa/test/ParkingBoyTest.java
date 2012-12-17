package edu.buaa.test;

import edu.buaa.park.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午3:45
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoyTest {
    private int totalAmount;
    private ParkingBoy parkingBoy;
    private  List<ParkPlace> parkPlaces;
    @Before
    public void init(){
        List<ParkPlace> parkPlaces=new ArrayList<ParkPlace>();
        Integer[] parkPlaceNums= new Integer[]{10, 20};
        totalAmount=0;
        for(Integer parknum:parkPlaceNums){
              parkPlaces.add(new ParkPlace(parknum));
            totalAmount+=parknum;
        }
        parkingBoy=new ParkingBoy(parkPlaces,new FirstAvailableParkingLotChooser());
        this.parkPlaces=parkPlaces;
    }
    @Test
    public void parkBoy_ShouldParkCar(){
        Car car=new Car();
        int maxParkingNum=20;
        ParkPlace parkPlace=new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces=new ArrayList<ParkPlace>();
        parkPlaces.add(parkPlace) ;
        ParkingBoy parkingBoy= new ParkingBoy(parkPlaces,new FirstAvailableParkingLotChooser());
        Ticket ticket=parkingBoy.park(car);
        Assert.assertEquals(maxParkingNum-1,parkingBoy.getAvailableNum());
    }
    /*取车---

    * */
    @Test
    public void parkBoy_ShouldfetchCar(){
        Car car=new Car();
        int maxParkingNum=20;
        ParkPlace parkPlace=new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces=new ArrayList<ParkPlace>();
        parkPlaces.add(parkPlace) ;
        ParkingBoy parkingBoy= new ParkingBoy(parkPlaces,new FirstAvailableParkingLotChooser());
        Ticket ticket=parkingBoy.park(car);
        Assert.assertSame(car,parkingBoy.fetch(ticket));
    }
    /*
    * 都空       停车
    * */
    @Test
    public void should_park_Sucess_when_park_is_empty(){
        parkingBoy.park(new Car());
        Assert.assertEquals(totalAmount-1,parkingBoy.getAvailableNum());
    }
    /*
   * 都空              取车
   * */
    @Test(expected = edu.buaa.park.NoCarException.class)
    public void should_fetch_Sucess_when_park_is_empty(){
        parkingBoy.fetch(new Ticket());
    }

    /*
   * 不全为空 ,取车
   * */
    @Test
    public void should_fetch_Sucess_when_park_is_notempty(){
        for(int i=0;i<totalAmount/2;i++){
        parkingBoy.park(new Car());}
        Car car=new Car();
        Ticket ticket=parkingBoy.park(car);
        Assert.assertSame(car,parkingBoy.fetch(ticket));
    }

    /*
   * 全满 ,停车
   * */
    @Test(expected = edu.buaa.park.ParkFullException.class)
    public void should_throwParkFullException_if_park_when_park_is_full(){
        for(int i=0;i<totalAmount;i++){
            parkingBoy.park(new Car());}
        parkingBoy.park(new Car());
    }


 }
