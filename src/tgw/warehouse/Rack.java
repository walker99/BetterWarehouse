package tgw.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Rack extends AbstractAisleComponents{
    private String name;
    private List<Floor> floors;

    public Rack(String name, List<Floor> floors) {
        this.name = name;
        this.floors = floors;
    }

    public static Rack RegularRack(int xCoordinate, int yCoordinate, int slotDepth, int rackNumber, String aisleName) {
        List<Floor> floors = new ArrayList<>(yCoordinate);
        for (int i = 0; i < yCoordinate; i++)
        {
            floors.add(Floor.RegularFloor(xCoordinate, i, slotDepth, rackNumber));
        }

        String rackName = "R" + rackNumber + "-" + aisleName;

        return new Rack(rackName, floors);
    }

    public String getName() {
        return name;
    }

    public List<Floor> getFloors() {
        return floors;
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

    /**
     * Loop over all floors in a floor
     * @return
     */
    @Override
    protected int calculateEmptyLocations() {
        return floors.stream().
                mapToInt(Floor::calculateEmptyLocations).sum();
    }

    @Override
    protected int calculateLocationCapacity() {
        return floors.stream().
                mapToInt(Floor::calculateLocationCapacity).sum();
    }
}
