package edu.buaa.test;

import edu.buaa.park.Car;
import edu.buaa.park.MaxAvailableParkingLotChooser;
import edu.buaa.park.ParkPlace;
import edu.buaa.park.ParkingBoy;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MaxAvailableParkingTest {
    private ParkingBoy parkingBoy;
    @Before
    public void init(){
        parkingBoy=new ParkingBoy(Arrays.asList(new ParkPlace(10),new ParkPlace(20)),new MaxAvailableParkingLotChooser());
    }
    /*smartingboy测试
*    停车停在空车位多的那个停车场
* */
    @Test
    public  void should_park_in_the_more_empty_parkplace(){
        parkingBoy.park(new Car());
        Assert.assertEquals(19, parkingBoy.getParkPlaces().get(1).getAvailableNum());
    }
    /*smartingboy测试
    两个车库空间相同时停在第一个
    * */
    @Test
    public void  should_park_in_the_first_parkplace_if_park_availableSize_same(){
        for(int i=0;i<10;i++){
            parkingBoy.park(new Car());}
        parkingBoy.park(new Car());
        Assert.assertEquals(9, parkingBoy.getParkPlaces().get(0).getAvailableNum());
    }
}
