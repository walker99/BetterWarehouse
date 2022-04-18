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
        aisles.add(Aisle.RegularAisle(numberOfSlots, numberOfLevels, numberOfLocations,numberOfRacks, name));
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
