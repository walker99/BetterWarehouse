package tgw.warehouse;

import java.time.Instant;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {
    	// write your code here
        Warehouse myWarehouse = new Warehouse("Amazon Traun");
        myWarehouse.createAisle("A1", 2, 3, 5, 3);
        myWarehouse.createAisle("A2", 3, 4, 6, 1);
        System.out.println(myWarehouse);

        for (Aisle aisle : myWarehouse.getAisles())
        {
            System.out.println(aisle);
            for (Rack rack :aisle.getRacks())
            {
                System.out.println(rack);

                for (Floor floor :rack.getFloors())
                {
                    System.out.println(floor);

                    for (Slot slot : floor.getSlots())
                    {
                        System.out.println(slot);

                        for (Location location :slot.getLocations())
                        {
                            System.out.println(location);
                        }
                    }
                }
            }
        }

        double occupancyRate1 = myWarehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getCurrentOccupancyRate();
        System.out.println("occupancyRate " + myWarehouse.getAisles().get(0).getName() + " = " + occupancyRate1 * 100 + "%");

        LoadCarrier lc1 = new LoadCarrier("LC-4711");
        LoadCarrier lc2 = new LoadCarrier("LC-4712");
        LoadCarrier lc3 = new LoadCarrier("LC-4713");
        myWarehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(2).deposit(lc1);
        occupancyRate1 = myWarehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getCurrentOccupancyRate();
        System.out.println("occupancyRate " + myWarehouse.getAisles().get(0).getName() + " = " + occupancyRate1 * 100 + "%");

        myWarehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(1).getLocations().get(2).setState(LocationState.BLOCKED);
        double occupancyRate2 = myWarehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getCurrentOccupancyRate();
        System.out.println("occupancyRate " + myWarehouse.getAisles().get(0).getName() + " = " + occupancyRate2 * 100 + "%");
    }
}

