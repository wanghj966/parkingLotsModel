package edu.buaa.parkmanage;

import edu.buaa.exception.ParkingEmptyException;
import edu.buaa.exception.ParkingFullException;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 11-6-15
 * Time: 下午3:02
 * To change this template use File | Settings | File Templates.
 */
public class ParkManagement {
    private final int capacity;
    private int remainingAmount;
    public ParkManagement(int capacity){
          this.capacity=capacity;
          this.remainingAmount= capacity;
    }
    public int getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(int remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public void parkCar(Car car)  {
        if(remainingAmount==0)throw new ParkingFullException();
        remainingAmount--;
    }

    public Car getCar(String parkingNo) {
        if(remainingAmount==50) throw new ParkingEmptyException();
        remainingAmount++;
        return new Car();
    }
}
