package edu.buaa.testFinalExam;

import edu.buaa.finalexam.MaxAvailablePlaceParkingBoyChooser;
import edu.buaa.finalexam.ParkingManager;
import edu.buaa.park.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingManagerTest {
    private ParkingManager parkingManager;
    /*
    * 初始化：自己管理两个停车场,三个parkingBoy,每个停车场管理两个parkPlace
    * */
    @Before
    public void init(){
        ParkingBoy stupidParkingBoy=new ParkingBoy( Arrays.asList(new ParkPlace(10),new ParkPlace(20)),new FirstAvailableParkingLotChooser()) ;
        ParkingBoy smartParkingBoy=new ParkingBoy( Arrays.asList(new ParkPlace(20),new ParkPlace(40)),new MaxAvailableParkingLotChooser()) ;
        ParkingBoy superParkingBoy=new ParkingBoy( Arrays.asList(new ParkPlace(30),new ParkPlace(50)),new MaxAvailableRateParkingLotChooser()) ;
        List<ParkingBoy> parkingBoys=Arrays.asList(stupidParkingBoy,smartParkingBoy,superParkingBoy);
        parkingManager=new ParkingManager(Arrays.asList(new ParkPlace(30),new ParkPlace(40)),new MaxAvailableRateParkingLotChooser(),parkingBoys, new MaxAvailablePlaceParkingBoyChooser());
    }
     /*自己管理两个停车场,三个parkingBoy(默认)未全满             停车                         停车成功，总车位数减1*/
    @Test
    public void should_parkSuccess_and_TotalPlaceMinus1_when_parkCar_if_parkplaces_not_full(){
        Car car=new Car();
        int availablePlaceNum_BeforePark=parkingManager.getAvailableNum();
        parkingManager.park(car);
        Assert.assertEquals(availablePlaceNum_BeforePark-1,parkingManager.getAvailableNum());
    }
    /*自己管理两个停车场,三个parkingBoy(默认)未全满             停车取车                     取到刚停下的车*/
    @Test
    public void should_fetchSuccess_when_fetchCar_if_parkSuccess(){
        Car car=new Car();
        Ticket ticket=parkingManager.park(car);
        Assert.assertSame(car, parkingManager.fetch(ticket));
    }
    /*所有停车场都满了均满                                      停车                         停车场已满异常  */
    @Test(expected = edu.buaa.park.ParkFullException.class)
    public void should_throwParkFullException_when_parkCar_if_AllParkPlacesFull(){   /*parkingManager.getAvailableNum()不能作为i的上限，它是变化的*/
        int parkingManagerCapacity= parkingManager.getAvailableNum();
        for(int i=0;i<parkingManagerCapacity;i++){
            parkingManager.park(new Car());
        }
       parkingManager.park(new Car());
    }
    /*所有停车场为空                                            取车                         找不到车异常*/
    @Test(expected = NoCarException.class)
    public void should_throwNoCarException_when_fetchCar_if_AllParkPlacesEmpty(){   /*parkingManager.getAvailableNum()不能作为i的上限，它是变化的*/
        parkingManager.fetch(new Ticket());
    }
    /*停车场和parkingboy都为空                                  停车                         停车场已满的异常*/   /**改变默认条件*/
    @Test(expected = edu.buaa.park.ParkFullException.class)
    public void should_throwParkFullException_when_parkCar_if_no_Parkplace_and_no_parkingBoy(){
        parkingManager=new ParkingManager(new ArrayList<ParkPlace>(),new MaxAvailableRateParkingLotChooser(),new ArrayList<ParkingBoy>(),new  MaxAvailablePlaceParkingBoyChooser());
        parkingManager.park(new Car());
    }
    /*只给了停车场，并未给parkingBoy                            停车                         停在自己的停车场中*/
    @Test
    public void should_parkSucess_when_parkCar_if_have_Parkplace_but_no_parkingBoy(){
        parkingManager=new ParkingManager(Arrays.asList(new ParkPlace(30),new ParkPlace(40)),new MaxAvailableRateParkingLotChooser(),new ArrayList<ParkingBoy>(),new  MaxAvailablePlaceParkingBoyChooser());
        int prePark=parkingManager.getAvailableNum();
        parkingManager.park(new Car());
        Assert.assertEquals(prePark-1,parkingManager.getAvailableNum());
    }
    /*只给了parkingBoy，并未给停车场                            停车                         停在parkingboy的停车场中*/
    @Test
    public void should_parkSucess_when_parkCar_if_have_parkingBoy_but_no_Parkplace(){
        ParkingBoy stupidParkingBoy=new ParkingBoy( Arrays.asList(new ParkPlace(10),new ParkPlace(20)),new FirstAvailableParkingLotChooser()) ;
        ParkingBoy smartParkingBoy=new ParkingBoy( Arrays.asList(new ParkPlace(20),new ParkPlace(40)),new MaxAvailableParkingLotChooser()) ;
        ParkingBoy superParkingBoy=new ParkingBoy( Arrays.asList(new ParkPlace(30),new ParkPlace(50)),new MaxAvailableRateParkingLotChooser()) ;
        List<ParkingBoy> parkingBoys=Arrays.asList(stupidParkingBoy,smartParkingBoy,superParkingBoy);
        parkingManager=new ParkingManager(new ArrayList<ParkPlace>(),new MaxAvailableRateParkingLotChooser(),parkingBoys, new MaxAvailablePlaceParkingBoyChooser());
        int prePark=parkingManager.getAvailableNum();
        parkingManager.park(new Car());
        Assert.assertEquals(prePark-1,parkingManager.getAvailableNum());
    }

}
