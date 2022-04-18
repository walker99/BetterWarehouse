package tgw.warehouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WarehouseTest {
    List<LoadCarrier> LcList;
    Warehouse warehouse;

    @BeforeEach
    void setUpOnRack() {
        warehouse = new Warehouse("Warehouse to Test");
        warehouse.createAisle("A1", 1, 3, 5, 2);
        LcList = new ArrayList<>(10);

        LcList.add(new LoadCarrier("LC 1"));
        LcList.add(new LoadCarrier("LC 2"));
        LcList.add(new LoadCarrier("LC 3"));
        LcList.add(new LoadCarrier("LC 4"));
        LcList.add(new LoadCarrier("LC 5"));
        LcList.add(new LoadCarrier("LC 6"));
        LcList.add(new LoadCarrier("LC 7"));
        LcList.add(new LoadCarrier("LC 8"));
        LcList.add(new LoadCarrier("LC 9"));
        LcList.add(new LoadCarrier("LC 10"));

        // x, y, z
        // 0, 0, 0
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(0).deposit(LcList.get(0));
        // 0, 0, 1
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(1).deposit(LcList.get(1));
        // 4, 0, 0
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(4).getLocations().get(0).deposit(LcList.get(2));
        // 4, 0, 1 BLOCKED
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(4).getLocations().get(1).setState(LocationState.BLOCKED);

        // 4, 2, 0
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(0).deposit(LcList.get(3));
        // 4, 2, 1
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(1).deposit(LcList.get(4));
        // 0, 2, 1
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(0).getLocations().get(1).deposit(LcList.get(5));
        // 1, 2, 1
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(1).getLocations().get(1).deposit(LcList.get(6));
        // 2, 2, 1
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(2).getLocations().get(1).deposit(LcList.get(7));

        // 1, 1, 1 BLOCKED
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(1).getLocations().get(1).setState(LocationState.BLOCKED);
    }

    @Test
    void testCreateAisle_all_30_locations() {
        // empty locations
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(1).getLocations().get(0).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(1).getLocations().get(1).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(2).getLocations().get(0).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(2).getLocations().get(1).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(3).getLocations().get(0).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(3).getLocations().get(1).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(0).getLocations().get(0).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(0).getLocations().get(1).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(1).getLocations().get(0).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(2).getLocations().get(0).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(2).getLocations().get(1).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(3).getLocations().get(0).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(3).getLocations().get(1).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(4).getLocations().get(0).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(4).getLocations().get(1).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(0).getLocations().get(0).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(1).getLocations().get(0).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(2).getLocations().get(0).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(3).getLocations().get(0).getState());
        assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(3).getLocations().get(1).getState());

        // occupied locations
        assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(0).getState());
        assertEquals("LoadCarrier{LC 1}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(0).getLc().toString());
        assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(1).getState());
        assertEquals("LoadCarrier{LC 2}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(1).getLc().toString());
        assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(4).getLocations().get(0).getState());
        assertEquals("LoadCarrier{LC 3}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(4).getLocations().get(0).getLc().toString());
        assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(0).getState());
        assertEquals("LoadCarrier{LC 4}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(0).getLc().toString());
        assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(1).getState());
        assertEquals("LoadCarrier{LC 5}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(1).getLc().toString());
        assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(0).getLocations().get(1).getState());
        assertEquals("LoadCarrier{LC 6}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(0).getLocations().get(1).getLc().toString());
        assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(1).getLocations().get(1).getState());
        assertEquals("LoadCarrier{LC 7}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(1).getLocations().get(1).getLc().toString());
        assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(2).getLocations().get(1).getState());
        assertEquals("LoadCarrier{LC 8}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(2).getLocations().get(1).getLc().toString());

        // blocked locations
        assertEquals(LocationState.BLOCKED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(1).getLocations().get(1).getState());
        assertEquals(LocationState.BLOCKED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(4).getLocations().get(1).getState());
    }

    @Test
    void testGetName_for_most_elements() {
        // Warehouse
        assertEquals("Warehouse to Test", warehouse.getName());
        // Aisle
        assertEquals("A1", warehouse.getAisles().get(0).getName());
        // Rack
        assertEquals("R0-A1", warehouse.getAisles().get(0).getRacks().get(0).getName());
        // Floors
        assertEquals("F0-R0", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getName());
        assertEquals("F1-R0", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getName());
        assertEquals("F2-R0", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getName());
        // Slots
        assertEquals("S0-F0", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getName());
        assertEquals("S4-F2", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getName());
        // Locations
        assertEquals("L0-S4", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(0).getName());
        assertEquals("L1-S1", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(1).getLocations().get(1).getName());
        assertEquals("L1-S1", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(1).getLocations().get(1).getName());
        assertEquals("L1-S1", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(1).getLocations().get(1).getName());
    }

    @Test
    void TestToString_for_most_elements() {
        // Warehouse
        assertEquals("Warehouse: Warehouse to Test\nAisle: A1\n----------------------------\n", warehouse.toString());
        // Aisle
        assertEquals("[Aisle: A1\nR0-A1\n]", warehouse.getAisles().toString());
        // Rack
        assertEquals(" Rack: R0-A1\n  F0-R0\n  F1-R0\n  F2-R0\n", warehouse.getAisles().get(0).getRacks().get(0).toString());
        // Floor
        assertEquals("  Floor: F0-R0\n   S0-F0\n   S1-F0\n   S2-F0\n   S3-F0\n   S4-F0\n", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).toString());
        // Slot
        assertEquals("   Slot: S0-F0\n    L0-S0\n    L1-S0\n", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).toString());
        assertEquals("   Slot: S4-F2\n    L0-S4\n    L1-S4\n", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).toString());
        // Location
        assertEquals("    L0-S4 - State: OCCUPIED\n", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(0).toString());
    }

    @Test
    void testCurrentOccupancies_for_all_components() {
        // 30 locations, 2 blocked, 8 occupied and capacity 28
        // 8/28
        assertEquals(String.format("%.4f", 8.0 / 28.0), String.format("%.4f", warehouse.getAisles().get(0).getCurrentOccupancyRate()));
        assertEquals(String.format("%.4f", 8.0 / 28.0), String.format("%.4f", warehouse.getAisles().get(0).getRacks().get(0).getCurrentOccupancyRate()));
        // Floor 0: 10 locations, 1 blocked, 3 occupied and capacity 9
        // 3/9
        assertEquals(String.format("%.4f", 3.0 / 9.0), String.format("%.4f", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getCurrentOccupancyRate()));
        // Floor 1: 10 locations, 1 blocked, 0 occupied and capacity 9
        // 0/9
        assertEquals(String.format("%.4f", 0.0 / 9.0), String.format("%.4f", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getCurrentOccupancyRate()));
        // Floor 2: 10 locations, 0 blocked, 5 occupied and capacity 10
        // 5/10
        assertEquals(String.format("%.4f", 5.0 / 10.0), String.format("%.4f", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getCurrentOccupancyRate()));
        // Slot 0/0 2 LCs in this slot
        assertEquals(1.0, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getCurrentOccupancyRate());
        // Slot 1/1 0 LC and 1 blocked
        assertEquals(0.0, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(1).getCurrentOccupancyRate());
        // Slot 2/2 1 LC in this slot
        assertEquals(0.5, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(2).getCurrentOccupancyRate());
        // Slot 1/3 0 LC
        assertEquals(0.0, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(3).getCurrentOccupancyRate());
        // Slot 4/0 1 LC and 1 blocked
        assertEquals(1.0, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(4).getCurrentOccupancyRate());
    }

    @Test
    void testLoadCarrier_pickup_Std() {
        LoadCarrier testDataLc = LcList.get(7);
        LoadCarrier pickedUpLc = warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(2).getLocations().get(1).pickup();

        assertEquals(testDataLc.toString(), pickedUpLc.toString());
    }
}