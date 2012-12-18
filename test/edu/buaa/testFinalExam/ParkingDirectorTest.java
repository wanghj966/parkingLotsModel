package edu.buaa.testFinalExam;

import edu.buaa.finalexam.MaxAvailablePlaceParkingBoyChooser;
import edu.buaa.finalexam.ParkingDirector;
import edu.buaa.finalexam.ParkingManager;
import edu.buaa.park.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ParkingDirectorTest {
    private ParkPlace parkPlace;
    private ParkingBoy parkingBoy;
    private ParkingManager parkingManager;
    @Before
    public void init(){
        parkPlace=new ParkPlace(50);
        parkingBoy=new ParkingBoy(Arrays.asList(new ParkPlace(20), new ParkPlace(10)),new MaxAvailableParkingLotChooser());
        ParkingBoy stupidParkingBoy=new ParkingBoy( Arrays.asList(new ParkPlace(10),new ParkPlace(20)),new FirstAvailableParkingLotChooser()) ;
        ParkingBoy smartParkingBoy=new ParkingBoy( Arrays.asList(new ParkPlace(20),new ParkPlace(40)),new MaxAvailableParkingLotChooser()) ;
        ParkingBoy superParkingBoy=new ParkingBoy( Arrays.asList(new ParkPlace(30),new ParkPlace(50)),new MaxAvailableRateParkingLotChooser()) ;
        List<ParkingBoy> parkingBoys=Arrays.asList(stupidParkingBoy,smartParkingBoy,superParkingBoy);
        parkingManager=new ParkingManager(Arrays.asList(new ParkPlace(30),new ParkPlace(40)),new MaxAvailableRateParkingLotChooser(),parkingBoys, new MaxAvailablePlaceParkingBoyChooser());
    }
    @Test
    public synchronized  void should_print_the_correct_String_when_print_parkPlace_if_never_parkCar(){
          System.out.println("未停车的ParkPlace展示....");
          System.out.println(ParkingDirector.getPrintString(parkPlace));
    }
    @Test
    public synchronized void should_print_the_correct_String_when_print_parkingBoy_if_never_parkCar(){
         System.out.println("未停车的ParkingBoy展示....");
         System.out.println(ParkingDirector.getPrintString(parkingBoy));
    }
    @Test
    public synchronized void should_print_the_correct_String_when_print_parkingManager_if_never_parkCar(){
           System.out.println("未停车的ParkingManager展示....");
           System.out.println(ParkingDirector.getPrintString(parkingManager));
    }
    @Test
    public synchronized void should_print_the_correct_String_when_print_parkPlace_if_have_parkCar_but_NotFull(){
        System.out.println("已停车的ParkPlace展示....");
        for(int i=0;i<new Random().nextInt(parkPlace.getCapacity());i++){
            parkPlace.park(new Car());
        }
        System.out.println(ParkingDirector.getPrintString(parkPlace));
    }
    @Test
    public synchronized void should_print_the_correct_String_when_print_parkingBoy_if_have_parkCar_but_NotFull(){
        System.out.println("已停车的ParkingBoy展示....");
        for(int i=0;i<new Random().nextInt(parkingBoy.getCapacity());i++){
            parkingBoy.park(new Car());
        }
        System.out.println(ParkingDirector.getPrintString(parkingBoy));
    }
    @Test
    public synchronized void should_print_the_correct_String_when_print_parkingManager_if_have_parkCar_but_NotFull(){
        System.out.println("已停车的ParkingManager展示....");
        for(int i=0;i<new Random().nextInt(parkingManager.getCapacity());i++){
            parkingManager.park(new Car());
        }
        System.out.println(ParkingDirector.getPrintString(parkingManager));
    }
}
