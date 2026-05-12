package system_design.oops_movie_booking_2;

import java.util.*;

// ==========================================================
// OOP MOVIE TICKET BOOKING SYSTEM
// Focus: Association, Aggregation, Composition
// ==========================================================

// =======================
// MOVIE CLASS
// =======================
class Movie {
    private String movieId;
    private String title;
    private String genre;
    private int duration;
    private String language;

    public Movie(String movieId, String title, String genre, int duration, String language) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }
}

// =======================
// SEAT CLASS (COMPOSITION)
// =======================
class Seat {
    private String seatId;
    private String row;
    private int seatNumber;
    private String seatType; // Normal / Premium
    private boolean isBooked;

    public Seat(String seatId, String row, int seatNumber, String seatType) {
        this.seatId = seatId;
        this.row = row;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isBooked = false;
    }

    public boolean bookSeat() {
        if (!isBooked) {
            isBooked = true;
            return true;
        }
        return false;
    }

    public String getSeatType() {
        return seatType;
    }

    public String getSeatId() {
        return seatId;
    }

    public boolean isBooked() {
        return isBooked;
    }
}

// =======================
// THEATER CLASS
// =======================
class Theater {
    private String theaterId;
    private String name;
    private String location;

    // Aggregation: Theater has Shows
    private List<Show> shows = new ArrayList<>();

    // Composition: Seats belong to theater
    private Map<String, Seat> seats = new HashMap<>();

    public Theater(String theaterId, String name, String location) {
        this.theaterId = theaterId;
        this.name = name;
        this.location = location;
    }

    public void addSeat(Seat seat) {
        seats.put(seat.getSeatId(), seat);
    }

    public Seat getSeat(String seatId) {
        return seats.get(seatId);
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}

// =======================
// SHOW CLASS (ASSOCIATION)
// =======================
class Show {
    private String showId;
    private Movie movie;       // Association
    private String startTime;
    private String endTime;
    private Theater theater;   // Association
    private List<Seat> availableSeats;

    public Show(String showId, Movie movie, String startTime, String endTime, Theater theater) {
        this.showId = showId;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
        this.theater = theater;
        this.availableSeats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        availableSeats.add(seat);
    }

    public boolean bookSeat(String seatId) {
        for (Seat s : availableSeats) {
            if (s.getSeatId().equals(seatId)) {
                return s.bookSeat();
            }
        }
        return false;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getStartTime() {
        return startTime;
    }

    public Theater getTheater() {
        return theater;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }
}

// =======================
// BOOKING CLASS (AGGREGATION)
// =======================
class Booking {
    private static int counter = 1001;

    private String bookingId;
    private String customerName;
    private Date bookingTime;
    private Show show;                // Association
    private List<Seat> bookedSeats;   // Aggregation
    private double totalPrice;

    public Booking(String customerName, Show show, List<Seat> seats) {
        this.bookingId = "BK" + counter++;
        this.customerName = customerName;
        this.show = show;
        this.bookedSeats = seats;
        this.bookingTime = new Date();
        calculateTotal();
    }

    private void calculateTotal() {
        totalPrice = 0;

        for (Seat s : bookedSeats) {
            if (s.getSeatType().equalsIgnoreCase("Premium")) {
                totalPrice += 200;
            } else {
                totalPrice += 150;
            }
        }
    }

    public void printBooking() {
        System.out.println("\n=== BOOKING DETAILS ===");
        System.out.println("Movie: " + show.getMovie().getTitle());
        System.out.println("Theater: " + show.getTheater().getName() + " - " + show.getTheater().getLocation());
        System.out.println("Show Time: " + show.getStartTime());

        System.out.println("\nSeats Booked:");
        for (Seat s : bookedSeats) {
            System.out.println("- " + s.getSeatId() + " (" + s.getSeatType() + ")");
        }

        System.out.println("\nTotal Amount: ₹" + totalPrice);
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Customer: " + customerName);
        System.out.println("Booking Time: " + bookingTime);
    }
}

// =======================
// MAIN CLASS
// =======================
public class Main {
    public static void main(String[] args) {

        System.out.println("=== MOVIE TICKET BOOKING SYSTEM ===\n");

        // 1. Create Movie
        Movie movie = new Movie("M001", "Avengers: Endgame", "Action", 181, "English");

        // 2. Create Theater (Composition: seats belong here)
        Theater theater = new Theater("T001", "IMAX", "Downtown");

        // Add seats
        theater.addSeat(new Seat("A1", "A", 1, "Premium"));
        theater.addSeat(new Seat("A2", "A", 2, "Premium"));
        theater.addSeat(new Seat("B5", "B", 5, "Normal"));

        // 3. Create Show (Association)
        Show show = new Show("S001", movie, "15:30", "18:30", theater);

        // Add seats to show
        show.addSeat(theater.getSeat("A1"));
        show.addSeat(theater.getSeat("A2"));
        show.addSeat(theater.getSeat("B5"));

        theater.addShow(show);

        // 4. Book seats
        List<Seat> bookedSeats = new ArrayList<>();

        if (show.bookSeat("A1")) bookedSeats.add(theater.getSeat("A1"));
        if (show.bookSeat("A2")) bookedSeats.add(theater.getSeat("A2"));
        if (show.bookSeat("B5")) bookedSeats.add(theater.getSeat("B5"));

        // 5. Create Booking (Aggregation)
        Booking booking = new Booking("Alice Johnson", show, bookedSeats);

        // 6. Print Output
        booking.printBooking();
    }
}