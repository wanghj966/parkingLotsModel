package edu.buaa.park;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午12:44
 * To change this template use File | Settings | File Templates.
 */
public interface ParkStrategy {
    ParkPlace getAvailablePark(List<ParkPlace> parks);
}
