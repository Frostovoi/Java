package Patterns.SmartParking;

import java.math.BigDecimal;
import java.util.Calendar;

public class ParkingSession {
    private Calendar entryDt;
    private Calendar paymentDt;
    private Calendar exitDt;
    private BigDecimal totalPayment;
    private String carPlateNumber;
    private int ticketNumber;

    public ParkingSession(Calendar entryDt, String carPlateNumber, int ticketNumber) {
        this.entryDt = entryDt;
        this.carPlateNumber = carPlateNumber;
        this.ticketNumber = ticketNumber;
    }


    public Calendar getEntryDt() {
        return entryDt;
    }

    public Calendar getPaymentDt() {
        return paymentDt;
    }

    public Calendar getExitDt() {
        return exitDt;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setPaymentDt(Calendar paymentDt) {
        this.paymentDt = paymentDt;
    }

    public void setExitDt(Calendar exitDt) {
        this.exitDt = exitDt;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }
}
