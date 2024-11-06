package E3;

import E3.Entity.Booking;
import E3.Entity.Customer;
import E3.Entity.Room;
import E3.Entity.RoomType;
import E3.Service.RoomService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        List<Room> rooms = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();

        RoomService roomService = new RoomService(rooms, bookings);

        rooms.add(new Room(1, "RS001", RoomType.SINGLE, 8));
        rooms.add(new Room(2, "RD001", RoomType.DOUBLE, 12));
        rooms.add(new Room(3, "RQ002", RoomType.QUEEN, 35));
        rooms.add(new Room(4, "RT001", RoomType.TRIPLE, 12.5));
        rooms.add(new Room(5, "RQ001", RoomType.QUAD, 20.5));

        customers.add(new Customer(1, "001", "Mr. Linus Tovaldo", "84125325346457"));
        customers.add(new Customer(2, "002", "Mr. Bill", "91124235346467"));
        customers.add(new Customer(3, "003", "Mr. Turing", "911423534646"));

        // Bước 3: Thêm dữ liệu mẫu cho Booking
        bookings.add(new Booking(1, rooms.get(0), customers.get(0),
                LocalDateTime.parse("2023-03-15 09:30:15", formatter),
                LocalDateTime.parse("2023-03-16 12:30:45", formatter)));

        bookings.add(new Booking(2, rooms.get(0), customers.get(1),
                LocalDateTime.parse("2023-06-09 19:30:25", formatter),
                LocalDateTime.parse("2023-06-10 11:25:15", formatter)));

        bookings.add(new Booking(3, rooms.get(1), customers.get(1),
                LocalDateTime.parse("2023-03-11 10:10:05", formatter),
                LocalDateTime.parse("2023-03-13 11:05:10", formatter)));

        bookings.add(new Booking(4, rooms.get(3), customers.get(2),
                LocalDateTime.parse("2023-11-11 11:11:15", formatter),
                LocalDateTime.parse("2023-11-13 11:15:15", formatter)));

        bookings.add(new Booking(5, rooms.get(3), customers.get(0),
                LocalDateTime.parse("2023-10-25 09:20:25", formatter),
                LocalDateTime.parse("2023-10-26 12:25:30", formatter)));

        bookings.add(new Booking(6, rooms.get(4), customers.get(0),
                LocalDateTime.parse("2023-08-18 18:25:35", formatter),
                LocalDateTime.parse("2023-08-19 11:35:20", formatter)));

        System.out.println("\nList Room:");
        rooms.forEach(System.out::println);

        System.out.println("\nList Customer:");
        customers.forEach(System.out::println);

        System.out.println("\nList Booking:");
        bookings.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Book a room");
            System.out.println("2. Display booking information");
            System.out.println("3. Revenue statistics by RoomType");
            System.out.println("4. RoomType with the largest revenue in 2023");
            System.out.println("0. Exit");
            System.out.print("Select function: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookRoom(roomService, scanner);
                    break;
                case 2:
                    displayBookingInformation(roomService, scanner);
                    break;
                case 3:
                    revenueByRoomType(roomService);
                    break;
                case 4:
                    topRevenue2023(roomService);
                    break;
                case 0:
                    System.out.println("Exit the program.");
                    return;
                default:
                    System.out.println("Invalid selection. Please select again.");
            }
        }
    }

    private static void bookRoom(RoomService roomService, Scanner scanner) {
        System.out.println("Choose room type: ");
        //RoomType
        List<RoomType> roomTypes = roomService.getRoom();
        for (int i = 0; i < roomTypes.size(); i++) {
            System.out.println((i + 1) + "." + roomTypes.get(i));
        }
        System.out.print("Enter your choice: ");
        int roomTypeChoice = Integer.parseInt(scanner.nextLine());
        RoomType selectedRoomType = roomTypes.get(roomTypeChoice - 1);
        List<Room> availableRooms = roomService.getRoomsType(selectedRoomType);
        if (availableRooms.isEmpty()) {
            System.out.println("There are no rooms available for the selected room type.");
            return;
        }
        System.out.println("List of available rooms for room type " + selectedRoomType + ":");
        for (int i = 0; i < availableRooms.size(); i++) {
            System.out.println((i + 1) + ". " + availableRooms.get(i));
        }
        //Time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime checkIn;
        LocalDateTime checkOut;
        while (true) {
            System.out.print("Enter check-in time (yyyy-MM-dd HH:mm:ss): ");
            checkIn = LocalDateTime.parse(scanner.nextLine(), formatter);

            System.out.print("Enter check-out time (yyyy-MM-dd HH:mm:ss): ");
            checkOut = LocalDateTime.parse(scanner.nextLine(), formatter);

            if (checkOut.isAfter(checkIn)) {
                break;
            } else {
                System.out.println("Check-out time must be greater than check-in time. Please re-enter.");
            }
        }
        List<Room> availableRoomsByTime = roomService.getRoomsByTypeAndTime(selectedRoomType, checkIn, checkOut);
        if (availableRoomsByTime.isEmpty()) {
            System.out.println("There are no rooms available for the selected room type during this time period.");
            return;
        }
        System.out.println("List of available rooms for room type " + availableRoomsByTime + " for the selected time period:");
        for (int i = 0; i < availableRoomsByTime.size(); i++) {
            System.out.println((i + 1) + ". " + availableRoomsByTime.get(i));
        }
        //Room
        System.out.print("Choose room by order number: ");
        int roomChoice = Integer.parseInt(scanner.nextLine());

        if (roomChoice < 1 || roomChoice > availableRoomsByTime.size()) {
            System.out.println("The room number you selected is invalid. Please select again.");
            return;
        }
        Room selectedRoom = availableRoomsByTime.get(roomChoice - 1);
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String customerPhone = scanner.nextLine();
        Customer customer = new Customer(roomService.getBookings().size() + 1, "KH" + (roomService.getBookings().size() + 1), customerName, customerPhone);
        Booking booking = new Booking(roomService.getBookings().size() + 1, selectedRoom, customer, checkIn, checkOut);
        roomService.addBooking(booking);
        System.out.println("Reservation successful!");
        System.out.println("Reservation information:");
        System.out.println(booking);

    }
    private static void displayBookingInformation(RoomService roomService, Scanner scanner) {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine().trim();
        System.out.print("Enter customer phone number: ");
        String customerPhone = scanner.nextLine().trim();
        System.out.print("Enter room ID: ");
        String roomCode = scanner.nextLine();
        Booking booking = roomService.findBooking(customerName, customerPhone, roomCode);
        if (booking != null) {
            System.out.println("Booking information found:");
            System.out.println(booking);
        } else {
            System.out.println("No booking found with the provided information.");
        }
    }
    private static void revenueByRoomType(RoomService roomService) {
        Map<RoomType, Double> revenueByRoomType = roomService.revenueByRoomType();
        System.out.println("Revenue by Room Type:");
        revenueByRoomType.forEach((roomType, revenue) -> {
            System.out.println(roomType + ": " + revenue + " (total revenue)");
        });
    }
    private static void topRevenue2023(RoomService roomService) {
        System.out.println(roomService.topRevenue2023());
    }

}
