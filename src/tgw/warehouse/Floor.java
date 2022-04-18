package tgw.warehouse;

import java.util.List;

public class Floor {
    private String name;
    private List<Slot> slots;

    public Floor(String name, List<Slot> slots) {
        this.name = name;
        this.slots = slots;
    }

    public String getName() {
        return name;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public double getCurrentOccupancyRate()
    {
        int sum = 0;
        int noOfSlots = slots.size();
        // noOfLocations = slots.get(0).getLocations().size()
        int capacity = slots.get(0).getLocations().size() * noOfSlots;

        for (Slot slot:slots)
        {
            for (Location location:slot.getLocations())
            {
                if (location.getState() == LocationState.BLOCKED)
                {
                    capacity--;
                }
            }
        }

        for (Slot slot:slots)
        {
            for (Location location:slot.getLocations())
            {
                if (location.getState() == LocationState.EMPTY)
                {
                    sum++;
                }
            }
        }

        return 1.0 - (double) sum/(double) capacity;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("  Floor: " + name +"\n");
        for (Slot slot:slots)
        {
            result.append("   " + slot.getName() + "\n");
        }

        return result.toString();
    }
}
