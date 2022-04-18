package tgw.warehouse;

import java.util.List;

public class Aisle extends AbstractAisleComponents {
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

    /**
     * Loop over all floors in a floor
     * @return
     */
    @Override
    protected int calculateEmptyLocations() {
        return racks.stream().
                mapToInt(Rack::calculateEmptyLocations).sum();
    }

    @Override
    protected int calculateLocationCapacity() {
        return racks.stream().
                mapToInt(Rack::calculateLocationCapacity).sum();
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
