package edu.buaa.exception;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 11-6-15
 * Time: 下午3:30
 * To change this template use File | Settings | File Templates.
 */
public class ParkingEmptyException extends RuntimeException {
    public ParkingEmptyException(){}
    public ParkingEmptyException(String e){
         super(e);
    }
}
