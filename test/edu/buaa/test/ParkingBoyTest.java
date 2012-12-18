package edu.buaa.test;

import edu.buaa.park.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class ParkingBoyTest {
    private ParkingBoy parkingBoy;
    private ParkingBoy singleParkPlaceParkingBoy;
    @Before
    public void init(){
        singleParkPlaceParkingBoy=new ParkingBoy(Arrays.asList(new ParkPlace(10)),new FirstAvailableParkingLotChooser());
        parkingBoy=new ParkingBoy(Arrays.asList(new ParkPlace(10), new ParkPlace(20)),new FirstAvailableParkingLotChooser());
    }
    /*管理一个停车场空                                           停车                        停车成功，两个停车场总停车位减少1*/
    @Test
    public void parkBoy_Should_parkSuccess_when_ParkCar_if_parkingBoy_have_oneParkPlace(){
        singleParkPlaceParkingBoy.park(new Car());
        Assert.assertEquals(singleParkPlaceParkingBoy.getCapacity()-1,singleParkPlaceParkingBoy.getAvailableNum());
    }
    /*两个停车场全为空，成功停车                               取车                        取到停的那辆车
    * */
    @Test
    public void parkBoy_Should_fetchSuccess_when_fetchCar_if_parkingBoy_have_oneParkPlace(){
        Car car=new Car();
        Ticket ticket=singleParkPlaceParkingBoy.park(car);
        Assert.assertSame(car,singleParkPlaceParkingBoy.fetch(ticket));
    }
    /*两个停车场都空                                           停车                        停车成功，两个停车场总停车位减少1*/
    @Test
    public void parkBoy_ShouldParkCar(){
        parkingBoy.park(new Car());
        Assert.assertEquals(parkingBoy.getCapacity()-1,parkingBoy.getAvailableNum());
    }
    /*两个停车场不全为空，成功停车                             取车                        取到停的那辆车
    * */
    @Test
    public void parkBoy_ShouldfetchCar(){
        Car car=new Car();
        Ticket ticket=parkingBoy.park(car);
        Assert.assertSame(car,parkingBoy.fetch(ticket));
    }

    /*
   * 两个停车场都空                                           取车                        取车失败，抛出未取到车异常
   * */
    @Test(expected = edu.buaa.park.NoCarException.class)
    public void should_fetch_Sucess_when_park_is_empty(){
        parkingBoy.fetch(new Ticket());
    }

    /*
   * 两个停车场不空不满，成功停车                             取车                        取到停的那辆车
   * */
    @Test
    public void should_fetch_Sucess_when_park_is_notempty(){
        for(int i=0;i<parkingBoy.getCapacity()/2;i++)    parkingBoy.park(new Car());
        Car car=new Car();
        Ticket ticket=parkingBoy.park(car);
        Assert.assertSame(car,parkingBoy.fetch(ticket));
    }

    /*
   * 两个停车场都满                                           停车                        停车失败，抛出停车场已满的异常
   * */
    @Test(expected = edu.buaa.park.ParkFullException.class)
    public void should_throwParkFullException_if_park_when_park_is_full(){
        for(int i=0;i<parkingBoy.getCapacity();i++){
            parkingBoy.park(new Car());}
         parkingBoy.park(new Car());
    }


 }
