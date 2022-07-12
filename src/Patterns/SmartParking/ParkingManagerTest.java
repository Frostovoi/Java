package Patterns.SmartParking;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class ParkingManagerTest {

    @Test
    public void enterParking() {
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.JULY,25,13,0);
        ApplicationHelper.getInstance().setCurDt(date);
        ParkingManager parkingManager = new ParkingManager(100, new MemoryLoader());
        ParkingSession session = parkingManager.enterParking("ABC");

        assertEquals("ABC",session.getCarPlateNumber());
        assertEquals(date,session.getEntryDt());
        assertEquals(1,session.getTicketNumber());
    }

    @Test
    public void tryLeaveParkingWithTicket() {

        ParkingManager parkingManager = new ParkingManager(100, new MemoryLoader());
//        ParkingSession session = parkingManager.enterParking("ABC");
//        assertTrue(parkingManager.tryLeaveParkingWithTicket(session.getTicketNumber()));


        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.JULY,25,13,0);
        ApplicationHelper.getInstance().setCurDt(date);
        ParkingSession session1 = parkingManager.enterParking("ABC");

        Calendar date1 = Calendar.getInstance();
        date1.set(2022, Calendar.JULY,26,14,20);
        ApplicationHelper.getInstance().setCurDt(date1);
        assertFalse(parkingManager.tryLeaveParkingWithTicket(session1.getTicketNumber()));

    }

    @Test
    public void getRemainingCost() {

    }

    @Test
    public void payForParking() {
    }
}