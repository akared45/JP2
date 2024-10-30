package E2.Controller;

import E2.Entity.Booking;
import E2.Entity.RoomType;
import E2.Service.BookingService;

import java.util.Map;

public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void createBooking(Booking booking) {
        bookingService.add(booking);
        System.out.println("Booking created" + booking);
    }

    public void findBooking(String cusName, String cusPhone, int roomId) {
        Booking foundBooking=bookingService.getBooking(cusName, cusPhone, roomId);
        if(foundBooking!=null) {
            System.out.println("Booking found" + foundBooking);
        }else {
            System.out.println("Booking not found");
        }
    }

    public void priceRoomHour(){
        Map<RoomType, Double> priceRoomHour = bookingService.calculateRevenueByRoomType();
        System.out.println("Revenue by Room Type:");
        priceRoomHour.forEach((roomType, revenue) ->
                System.out.println(roomType + ": " + revenue + " VND")
        );
    }
}
