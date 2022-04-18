package tgw.warehouse;

import java.util.List;

/**
 * Slots are parts of floors (see it as the x-coordinate)
 * In a slot you find locations (see it as the z-coordinate)
 */
public class Slot extends AbstractAisleComponents {
    private String name;
    private List<Location> locations;

    /**
     * Constructor for a slot
     *
     * @param name Name of this slot
     * @param locations List of locations
     */
    public Slot(String name, List<Location> locations) {
        this.name = name;
        this.locations = locations;
    }

    /**
     * Retruns the slot name
     * @return slot name as a string
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the locations of a slot
     * @return ArrayList of locations
     */
    public List<Location> getLocations() {
        return locations;
    }

    protected double getEmptyLocations()
    {
        int sumEmptyLocations = 0;

        // loop through all locations
        for (Location location:locations)
        {
            // if a location is occupied sum it up!
            if (location.getState() == LocationState.EMPTY)
            {
                sumEmptyLocations++;
            }
        }

        return sumEmptyLocations;
    }

    protected double getLocationCapacity()
    {
        int locationCapacity = locations.size();

        // loop through all locations
        for (Location location:locations)
        {
            // lower the capacity if a location is blocked
            if (location.getState() == LocationState.BLOCKED)
            {
                locationCapacity--;
            }
        }

        return locationCapacity;
    }

    /**
     * Returns a representation of slot
     * @return string of this object
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("   Slot: " + name + "\n");
        for (Location location:locations)
        {
            result.append("    " + location.getName() + "\n");
        }

        return result.toString();
    }
}
