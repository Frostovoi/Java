package Patterns.SmartParking;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Optional;

public class ParkingManager {
    private ArrayList<ParkingSession> activeSessions;
    private ArrayList<ParkingSession> closedSessions;
    private ArrayList<Tariff> tariffs;
    private int capacity;



    public ParkingManager(int capacity, TariffLoader loader) {
        this.capacity = capacity;
        activeSessions = new ArrayList<>();
        closedSessions = new ArrayList<>();
        tariffs = loader.load();
    }

    private boolean checkFree(Calendar date, ParkingSession session) {
        double minutes = Utils.minuteDifference(ApplicationHelper.getInstance().getCurDt(),date);
        if (minutes < findFree()) {
            closedSessions.add(session);
            activeSessions.remove(session);
            session.setExitDt(ApplicationHelper.getInstance().getCurDt());
            return true;
        }
        else
            return false;
    }

    private int findFree() {
        return tariffs.
                stream().filter(t->t.getRate().equals(BigDecimal.ZERO)).
                map(Tariff::getMinutes).findFirst().orElse(0);
    }

    private int createTicketNumber() {
        Optional<ParkingSession> maxSession = activeSessions.stream().
                max(Comparator.comparing(ParkingSession::getTicketNumber));
        return maxSession.map(t -> t.getTicketNumber() + 1).orElse(1);
    }

    private ParkingSession findSession(int ticketNumber){
        return activeSessions.stream().filter(t->t.getTicketNumber() == ticketNumber).findFirst().orElse(null);
    }

    public ParkingSession enterParking(String carPlateNumber) {
        if (activeSessions.size() == capacity)
            return null;
        if (activeSessions.stream().anyMatch(t->t.getCarPlateNumber().equals(carPlateNumber)))
            throw new ParkingException("This plate number already exist");
        ParkingSession session = new ParkingSession(
                ApplicationHelper.getInstance().getCurDt(),
                carPlateNumber,
                createTicketNumber()
        );
        activeSessions.add(session);
        return session;
    }

    public boolean tryLeaveParkingWithTicket(int ticketNumber) {
        ParkingSession session = findSession(ticketNumber);
        if (session != null) {
            if (session.getPaymentDt() == null) {
                return checkFree(session.getEntryDt(), session);
            }
            else {
                return checkFree(session.getPaymentDt(), session);
            }
        }
        else
            throw new ParkingException("No element with this ticketNumber");
    }

    public BigDecimal getRemainingCost(int ticketNumber) {
        ParkingSession session = findSession(ticketNumber);
        Calendar curDt = ApplicationHelper.getInstance().getCurDt();
        Calendar date;
        if (session.getPaymentDt() == null) {
            date = session.getEntryDt();

        }
        else {
            date = session.getPaymentDt();
        }
        double minutesOnParking = Utils.minuteDifference(curDt, date);
        return tariffs.stream().sorted(Comparator.comparing(Tariff::getMinutes)).
                filter(t->t.getMinutes() > minutesOnParking).map(Tariff::getRate).findFirst().get();
    }

    public void payForParking(int ticketNumber, BigDecimal amount) {
        ParkingSession session = findSession(ticketNumber);
        session.setPaymentDt(ApplicationHelper.getInstance().getCurDt());
        session.setTotalPayment(amount);
    }
}
