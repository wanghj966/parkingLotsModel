package edu.buaa.exception;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 11-6-15
 * Time: 下午3:30
 * To change this template use File | Settings | File Templates.
 */
public class ParkingFullException extends RuntimeException {
    public ParkingFullException(){}
    public ParkingFullException(String e){
         super(e);
    }
}
