package edu.buaa.test.parkmanage;

import edu.buaa.parkmanage.Car;
import edu.buaa.parkmanage.ParkManagement;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 11-6-15
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public class ParkManagementTest {
        private ParkManagement parkManagement;

        @Before
         public void  init(){
            int CAPACITY=50;
            parkManagement=new  ParkManagement(CAPACITY);
         }
        @Test
        public void parkCar_should_return_remainingAmountMinusOne(){
            int  remainingAmount=30;
            parkManagement.setRemainingAmount(remainingAmount);
            parkManagement.parkCar(new Car());
            Assert.assertEquals(remainingAmount-1,parkManagement.getRemainingAmount());
        }

        @Test
        public void getCar_should_return_remainingAmountMinusOne(){
            int  remainingAmount=30;
            parkManagement.setRemainingAmount(remainingAmount);
            parkManagement.getCar("abc");
            Assert.assertEquals(remainingAmount+1,parkManagement.getRemainingAmount());
        }
        @Test(expected = edu.buaa.exception.ParkingFullException.class)
        public void parkCar_should_Throw_ParkingFullException_when_parkFull(){
            int  remainingAmount=0;
            parkManagement.setRemainingAmount(remainingAmount);
            parkManagement.parkCar(new Car());
        }

        @Test(expected = edu.buaa.exception.ParkingEmptyException.class)
        public void getCar__should_Throw_ParkingEmptyException_when_parkEmpty(){
            int  remainingAmount=50;
            parkManagement.setRemainingAmount(50);
            parkManagement.getCar("abc");
        }
}
