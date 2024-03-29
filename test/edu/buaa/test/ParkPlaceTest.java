package edu.buaa.test;

import edu.buaa.park.Car;
import edu.buaa.park.ParkFullException;
import edu.buaa.park.ParkPlace;
import edu.buaa.park.Ticket;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;


public class ParkPlaceTest {
    private ParkPlace park;

    @Before
    public void init(){
          park=new ParkPlace(50);
    }
    /*
    * 显示停车位数
    * */
    @Test
    public void should_get_the_CorrectAvailableNum(){
        Assert.assertEquals(50,park.getAvailableNum());
    }
    /*
    一个停车场,有空车位
    停车
    成功,空车位-1
    * */

     @Test
    public void should_carplaceNum_Minus_1_if_have_empty_Carplace_when_park(){
             park.park(new Car());
             Assert.assertEquals(park.getCapacity()-1,park.getAvailableNum());
    }
    /**
     * 一个停车场,没有空车位
     停车
     fail
     */
    @Test(expected =ParkFullException.class)
    public void should_throw_ParkFullException_if_park_full_when_park(){
        for(int i=0;i<park.getCapacity();i++)
        park.park(new Car());
        park.park(new Car());
    }

    /*
    停车
    得到 有效的停车凭证
    */
    @Test
    public void should_get_ticket_if_park_success_when_park(){
        Ticket ticket=park.park(new Car());
        Assert.assertNotNull(ticket);
    }


    /**
     * 一个停车场,一辆车A
     取车
     取到车A,空车位+1
     */
    @Test
    public void should_fetchSuccess_and_carplaceNum_add_1_if_have_fetched_car_when_fetch(){
        for(int i=0;i<new Random().nextInt(park.getCapacity());i++)
        park.park(new Car());
        int preParkAvailableNum=park.getAvailableNum();
         Ticket ticket =park.park(new Car());
         park.fetch(ticket);
         Assert.assertEquals(preParkAvailableNum,park.getAvailableNum());
    }

    /*有效的停车凭证
    停车
    取到原来的车
    */
    @Test
    public void should_fetch_the_correct_car_if_ticket_correct_when_fetch(){
        Car mycar = new Car();
        Ticket ticket = park.park(mycar);
        Car fetchedCar=park.fetch(ticket);
        Assert.assertSame(mycar,fetchedCar);
    }






}
