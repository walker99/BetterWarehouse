package tgw.warehouse;

public class Location {
    private String name;
    private LocationState state;
    private LoadCarrier lc;

    public Location(String name) {
        this.name = name;
        state = LocationState.EMPTY;
    }

    public String getName() {
        return name;
    }

    public LocationState getState() {
        return state;
    }

    public void setState(LocationState state) {
        this.state = state;
    }

    public LoadCarrier getLc() {
        return lc;
    }

    public void deposit(LoadCarrier loadCarrier)
    {
        lc = loadCarrier;
        setState(LocationState.OCCUPIED);
    }

    public LoadCarrier pickup()
    {
        LoadCarrier tempLc = null;
        
        if (lc != null)
        {
            tempLc = lc;
        }
        lc = null;
        setState(LocationState.EMPTY);
        return tempLc;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("    " + name);
        result.append(" - State: " + state.toString() + "\n");

        return result.toString();
    }
}
