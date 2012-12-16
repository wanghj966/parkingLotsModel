package edu.buaa.finalexam;

import edu.buaa.park.ParkingBoy;

import java.util.List;


public interface ParkingBoyChooser {
    ParkingBoy getAvailableParkingBoy(List<ParkingBoy> parkingBoys);
}
