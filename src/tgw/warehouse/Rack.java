package tgw.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Rack {
    private String name;
    private List<Floor> floors;

    public Rack(String name, List<Floor> floors) {
        this.name = name;
        this.floors = floors;
    }

    public String getName() {
        return name;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public double getCurrentOccupancyRate()
    {
        int sum = 0;
        int noOfFloors = floors.size();
        // all locations = noOfFloors*noOfSlots*noOfLocations
        int capacity = noOfFloors * floors.get(0).getSlots().size()*floors.get(0).getSlots().get(0).getLocations().size();

        for (Floor floor:floors){
            for (Slot slot:floor.getSlots())
            {
                for (Location location:slot.getLocations())
                {
                    if (location.getState() == LocationState.BLOCKED)
                    {
                        capacity--;
                    }
                }
            }
        }

        for (Floor floor:floors) {
            for (Slot slot : floor.getSlots()) {
                for (Location location : slot.getLocations()) {
                    if (location.getState() == LocationState.EMPTY) {
                        sum++;
                    }
                }
            }
        }

        return 1.0 - (double) sum/(double) capacity;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(" Rack: " + name + "\n");
        for (Floor floor:floors)
        {
            result.append("  " + floor.getName() + "\n");
        }

        return result.toString();
    }
}
