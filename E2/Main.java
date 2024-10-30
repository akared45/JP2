package E2;

import E2.Controller.BookingController;
import E2.Controller.CustomerController;
import E2.Controller.RoomController;
import E2.Entity.Booking;
import E2.Entity.Customer;
import E2.Entity.Room;
import E2.Entity.RoomType;
import E2.Service.BookingService;
import E2.Service.CustomerService;
import E2.Service.RoomService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookingService bookingService = new BookingService();
        CustomerService customerService = new CustomerService();
        RoomService roomService = new RoomService();

        BookingController bookingController = new BookingController(bookingService);
        CustomerController customerController = new CustomerController(customerService);
        RoomController roomController = new RoomController(roomService);

        customerController.addCustomer(new Customer(1, "John Doe", "123456789"));
        customerController.addCustomer(new Customer(2, "Jane Smith", "987654321"));
        roomController.addRoom(new Room(1, RoomType.SINGLE, 89.0));
        roomController.addRoom(new Room(2, RoomType.DOUBLE, 125.0));
        roomController.addRoom(new Room(3, RoomType.QUEEN, 150.0));
        //Id book
        Scanner scanner = new Scanner(System.in);
        int bookingId = bookingService.generateBookingId();
        //Id cus
        System.out.println("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerController.getCustomer(customerId);
        //Id room
        System.out.println("Enter Room ID: ");
        int roomId = scanner.nextInt();
        Room room = roomController.getRoom(roomId);
        //Room type
        System.out.println("Select Room Type: ");
        System.out.println("1. SINGLE\n2. DOUBLE\n3. QUEEN\n4. QUAD\n5. TRIPLE");
        int roomTypeChoice = scanner.nextInt();
        scanner.nextLine();

        RoomType roomType;
        switch (roomTypeChoice) {
            case 1:
                roomType = RoomType.SINGLE;
                break;
            case 2:
                roomType = RoomType.DOUBLE;
                break;
            case 3:
                roomType = RoomType.QUEEN;
                break;
            case 4:
                roomType = RoomType.QUAD;
                break;
            case 5:
                roomType = RoomType.TRIPLE;
                break;
            default:
                System.out.println("Invalid choice! Exiting booking.");
                return;
        }
        System.out.println("Enter Check-in Date (yyyy-MM-ddTHH:mm): ");
        LocalDateTime checkIn = LocalDateTime.parse(scanner.nextLine());

        System.out.println("Enter Check-out Date (yyyy-MM-ddTHH:mm): ");
        LocalDateTime checkOut = LocalDateTime.parse(scanner.nextLine());

        Booking booking = new Booking(bookingId, customer, room, checkIn, checkOut);
        bookingController.createBooking(booking);

        System.out.println("Enter customer Name:  ");
        String customerName = scanner.nextLine();
        System.out.println("Enter customer Phone:  ");
        String customerPhone = scanner.nextLine();
        System.out.println("Enter room ID:  ");
        int roomFindId = scanner.nextInt();
        bookingController.findBooking(customerName,customerPhone,roomFindId);
        bookingController.priceRoomHour();
    }

}
