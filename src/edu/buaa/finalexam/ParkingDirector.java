package edu.buaa.finalexam;

import edu.buaa.park.*;

import java.util.Arrays;
import java.util.List;


public class ParkingDirector {
    public static void  main(String[] args){
        String s=ParkingDirector.getPrintString(new ParkPlace(50));
        System.out.println(s);
        s=ParkingDirector.getPrintString(new ParkingBoy(Arrays.asList(new ParkPlace(20),new ParkPlace(10)),new MaxAvailableRateParkingLotChooser()));
        System.out.println(s);

        ParkingBoy stupidParkingBoy=new ParkingBoy( Arrays.asList(new ParkPlace(10),new ParkPlace(20)),new FirstAvailableParkingLotChooser()) ;
        ParkingBoy smartParkingBoy=new ParkingBoy( Arrays.asList(new ParkPlace(20),new ParkPlace(40)),new MaxAvailableParkingLotChooser()) ;
        ParkingBoy superParkingBoy=new ParkingBoy( Arrays.asList(new ParkPlace(30),new ParkPlace(50)),new MaxAvailableRateParkingLotChooser()) ;
        List<ParkingBoy> parkingBoys=Arrays.asList(stupidParkingBoy,smartParkingBoy,superParkingBoy);
        ParkingManager parkingManager=new ParkingManager(Arrays.asList(new ParkPlace(30),new ParkPlace(40)),new MaxAvailableRateParkingLotChooser(),parkingBoys, new MaxAvailablePlaceParkingBoyChooser());
        s=ParkingDirector.getPrintString(parkingManager);
        System.out.println(s);

    }
    public static void print(ParkPlace parkPlace){
        System.out.println(getPrintString(parkPlace));
    }
    public static void print(ParkingBoy parkingBoy){

    }
    public static void print(ParkingManager parkingManager){

    }
    public static String getPrintString(ParkPlace parkPlace){
        return String.format("%s%d\n%s%d\n","车位数：",parkPlace.getCapacity(),"空位数：",parkPlace.getAvailableNum());

    }
    public  static String getPrintString(ParkingBoy parkingBoy){
        return getPrintString(parkingBoy,"");
    }
    private static String getPrintString(ParkingBoy parkingBoy,String indent){
        String parkingBoyStr="";
        List<ParkPlace> parkPlaces=parkingBoy.getParkPlaces();
        for(int i=0;i<parkPlaces.size();i++){
            parkingBoyStr+=String.format("%s%d\n    %s%d\n    %s%d\n",indent+"停车场编号：",i+1,indent+"车位数：",parkPlaces.get(i).getCapacity(),indent+"空位数：",parkPlaces.get(i).getAvailableNum());
        }
        parkingBoyStr+=String.format("%s%d\n",indent+"Total车位数：",parkingBoy.getCapacity());
        parkingBoyStr+=String.format("%s%d\n",indent+"Total空位数：",parkingBoy.getAvailableNum());
        return parkingBoyStr;
    }
    public static  String getPrintString(ParkingManager parkingManager){
        String parkingManagerStr="";
        List<ParkingBoy> parkingBoys=parkingManager.getManagedParkingboys();
        parkingManagerStr+=getPrintString(parkingBoys.get(0));
        for(int i=1;i<parkingBoys.size();i++){
            parkingManagerStr+= String.format("%s%d\n","停车仔编号：",i);
            parkingManagerStr+= getPrintString(parkingBoys.get(i),"    ");
        }
        parkingManagerStr+=String.format("%s%d\n","Total车位数：",parkingManager.getCapacity());
        parkingManagerStr+=String.format("%s%d\n","Total空位数：",parkingManager.getAvailableNum());
        return parkingManagerStr;

    }
}
