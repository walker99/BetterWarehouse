package tgw.warehouse;

import java.util.List;

public class Aisle {
    private String name;
    private List<Rack> racks;

    public Aisle(String name, List<Rack> racks) {
        this.name = name;
        this.racks = racks;
    }

    public String getName() {
        return name;
    }

    public List<Rack> getRacks() {
        return racks;
    }

    public double getCurrentOccupancyRate()
    {
        int sum = 0;
        int noOfRacks = racks.size();
        // all locations = noOfRacks*noOfFloors*noOfSlots*noOfLocations
        int capacity = noOfRacks * racks.get(0).getFloors().size()*racks.get(0).getFloors().get(0).getSlots().size()*racks.get(0).getFloors().get(0).getSlots().get(0).getLocations().size();

        for (Rack rack:racks)
        {
            for (Floor floor:rack.getFloors())
            {
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
        }

        for (Rack rack:racks)
        {
            for (Floor floor:rack.getFloors()) {
                for (Slot slot : floor.getSlots()) {
                    for (Location location : slot.getLocations()) {
                        if (location.getState() == LocationState.EMPTY) {
                            sum++;
                        }
                    }
                }
            }
        }

        return 1.0 - (double) sum/(double) capacity;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Aisle: " + name + "\n");
        for (Rack rack:racks)
        {
            result.append(rack.getName() + "\n");
        }

        return result.toString();
    }
}
