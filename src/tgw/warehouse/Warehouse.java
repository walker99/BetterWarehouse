package tgw.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private String name;
    private ArrayList<Aisle> aisles;

    public Warehouse(String name) {
        this.name = name;
        aisles = new ArrayList<>();
    }

    /**
     * Create objects for one standard aisle
     *
     * @param name use the standard system "tgw.warehouse.Aisle 1" to "tgw.warehouse.Aisle n"
     * @param numberOfRacks number of racks vor one aisle, mostly we do have two racks
     * @param numberOfLevels number of levels in one rack. Only symmetric situation
     * @param numberOfSlots number of slots in one level. All levels are equivalent
     * @param numberOfLocations number of locations in one slot. All slots are equivalent
     */
    public void createAisle(String name, int numberOfRacks, int numberOfLevels, int numberOfSlots, int numberOfLocations)
    {
        ArrayList<Rack> racks = new ArrayList<>(numberOfRacks);
        for (int i = 0; i < numberOfRacks; i++)
        {
            ArrayList<Floor> levels = new ArrayList<>(numberOfLevels);
            for (int j = 0; j < numberOfLevels; j++)
            {
                ArrayList<Slot> slots = new ArrayList<>(numberOfSlots);
                for (int k = 0; k < numberOfSlots; k++)
                {
                    ArrayList<Location> locations = new ArrayList<>(numberOfLocations);
                    for (int l = 0; l < numberOfLocations; l++)
                    {
                        String locationName = "L" + l + "-S" + k;
                        locations.add(new Location(locationName));
                    }
                    String slotName = "S" + k + "-F" + j;
                    slots.add(new Slot(slotName, locations));
                }
                String levelName = "F" + j + "-R" + i;
                levels.add(new Floor(levelName, slots));
            }
            String rackName = "R" + i + "-" + name;
            racks.add(new Rack(rackName, levels));
        }
        Aisle myAisle = new Aisle(name, racks);
        aisles.add(myAisle);
    }

    public String getName() {
        return name;
    }

    public List<Aisle> getAisles() {
        return aisles;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Warehouse: " + name + "\n");
        for (Aisle aisle:aisles)
        {
            result.append("Aisle: " + aisle.getName() + "\n");
        }
        String line = "";
        for (int i = 0; i < (name.length() + 11); i++)
        {
            line += "-";
        }
        result.append(line + "\n");
        return result.toString();
    }
}
