package E2.Entity;

import java.time.LocalDateTime;

public class Booking {
    private int id;
    private Customer customer;
    private Room room;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Booking() {
    }

    public Booking(int id, Customer customer, Room room, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.id = id;
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customer=" + customer +
                ", room=" + room +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
