package tgw.warehouse;

import java.util.List;

public class Floor extends AbstractAisleComponents {
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

    /**
     * Loop over all slots in a floor
     * @return
     */
    @Override
    protected int calculateEmptyLocations() {
        Integer sumOfEmptyLocations = slots.stream().
                mapToInt(o -> o.calculateEmptyLocations()).sum();

        return sumOfEmptyLocations;
    }

    @Override
    protected int calculateLocationCapacity() {
        Integer sumLocationsCapacity = slots.stream().
                mapToInt(o -> o.calculateLocationCapacity()).sum();

        return sumLocationsCapacity;
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
