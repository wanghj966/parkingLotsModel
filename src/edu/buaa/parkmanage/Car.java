package edu.buaa.parkmanage;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 11-6-15
 * Time: 下午3:41
 * To change this template use File | Settings | File Templates.
 */
public class Car {
    private String carNumber;
    public Car(){}
    public Car(String carNumber){
        this.carNumber=carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
