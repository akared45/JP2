package E2.Service;

import E2.Entity.Booking;
import E2.Entity.RoomType;
import E2.General.Generic;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingService implements Generic<Booking> {
    private final Map<Integer, Booking> bookings = new HashMap<>();

    @Override
    public void add(Booking booking) {
        bookings.put(booking.getId(), booking);
    }

    @Override
    public Booking findById(Integer id) {
        return null;
    }

    public int generateBookingId() {
        return bookings.size() + 1;
    }

    public Booking getBooking(String cusName, String cusPhone, int roomId) {
        return bookings.values().stream()
                .filter(b -> b.getCustomer().getName().equalsIgnoreCase(cusName) ||
                        b.getCustomer().getPhoneNumber().equals(cusPhone) ||
                        b.getRoom().getId() == roomId)
                .findFirst()
                .orElse(null);
    }

    public Map<RoomType, Double> calculateRevenueByRoomType() {
        return bookings.values().stream()
                .collect(Collectors.groupingBy(
                        booking -> booking.getRoom().getRoomType(),
                        Collectors.summingDouble(booking -> {
                            long hours = Duration.between(booking.getCheckIn(), booking.getCheckOut()).toHours();
                            return hours * booking.getRoom().getPricePerHour();
                        })
                ));
    }

    public Optional<Map.Entry<RoomType, Double>> getTopRevenueRoomTypeFor2023() {
        return calculateRevenueByRoomType().entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

    private boolean isInYear2023(Booking booking) {
        return (booking.getCheckIn().getYear() == 2023 || booking.getCheckOut().getYear() == 2023);
    }
}
