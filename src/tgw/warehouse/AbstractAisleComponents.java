package tgw.warehouse;

public abstract class AbstractAisleComponents {
    public double getCurrentOccupancyRate() {
        return 1.0 - calculateEmptyLocations()/ calculateLocationCapacity();
    }

    protected abstract double calculateEmptyLocations();
    
    protected abstract double calculateLocationCapacity();
}
