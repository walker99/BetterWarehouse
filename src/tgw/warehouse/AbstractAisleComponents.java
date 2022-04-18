package tgw.warehouse;

public abstract class AbstractAisleComponents {
    public double getCurrentOccupancyRate() {
        return 1.0 - getEmptyLocations()/getLocationCapacity();
    }

    protected abstract double getEmptyLocations();
    
    protected abstract double getLocationCapacity();
}
