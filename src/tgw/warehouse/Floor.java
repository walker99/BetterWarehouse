package tgw.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Floor extends AbstractAisleComponents {
    private String name;
    private List<Slot> slots;

    public Floor(String name, List<Slot> slots) {
        this.name = name;
        this.slots = slots;
    }

    public static Floor RegularFloor(int xCoordinate, int yCoordinate, int slotDepth, int rackNumber) {
        List<Slot> slots = new ArrayList<>(xCoordinate);
        for (int i = 0; i < xCoordinate; i++)
        {
            slots.add(Slot.MultiSlot(i, yCoordinate, slotDepth));
        }

        String slotName = "F" + yCoordinate + "-R" + rackNumber;

        return new Floor(slotName, slots);
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
        return slots.stream().
                mapToInt(Slot::calculateEmptyLocations).sum();
    }

    @Override
    protected int calculateLocationCapacity() {
        return slots.stream().
                mapToInt(Slot::calculateLocationCapacity).sum();
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
