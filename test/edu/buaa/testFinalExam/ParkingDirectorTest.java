package edu.buaa.testFinalExam;

import edu.buaa.finalexam.MaxAvailablePlaceParkingBoyChooser;
import edu.buaa.finalexam.ParkingDirector;
import edu.buaa.finalexam.ParkingManager;
import edu.buaa.park.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
    public void should_print_the_correct_String_when_print_parkPlace_if_never_parkCar(){
          System.out.println(ParkingDirector.getPrintString(parkPlace));
    }
    @Test
    public void should_print_the_correct_String_when_print_parkingBoy_if_never_parkCar(){
         System.out.println(ParkingDirector.getPrintString(parkingBoy));
    }
    @Test
    public void should_print_the_correct_String_when_print_parkingManager_if_never_parkCar(){
           System.out.println(ParkingDirector.getPrintString(parkingManager));
    }
    @Test
    public void should_print_the_correct_String_when_print_parkPlace_if_have_parkCar_but_NotFull(){
        for(int i=0;i<parkPlace.getCapacity()/2;i++){
            parkPlace.park(new Car());
        }
        System.out.println(ParkingDirector.getPrintString(parkPlace));
    }
    @Test
    public void should_print_the_correct_String_when_print_parkingBoy_if_have_parkCar_but_NotFull(){
        for(int i=0;i<parkingBoy.getCapacity()/2;i++){
            parkingBoy.park(new Car());
        }
        System.out.println(ParkingDirector.getPrintString(parkingBoy));
    }
    @Test
    public void should_print_the_correct_String_when_print_parkingManager_if_have_parkCar_but_NotFull(){
        for(int i=0;i<parkingManager.getCapacity()/2;i++){
            parkingManager.park(new Car());
        }
        System.out.println(ParkingDirector.getPrintString(parkingManager));
    }
}
