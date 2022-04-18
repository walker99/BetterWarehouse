package tgw.warehouse;

public abstract class AbstractAisleComponents {
    public double getCurrentOccupancyRate() {
        return 1.0 - (double) calculateEmptyLocations()/ (double) calculateLocationCapacity();
    }

    protected abstract int calculateEmptyLocations();
    
    protected abstract int calculateLocationCapacity();
}
