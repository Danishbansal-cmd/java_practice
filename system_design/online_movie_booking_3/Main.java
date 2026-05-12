import java.util.*;

// ==========================================================
// MOVIE TICKET BOOKING SYSTEM
// Uses:
// 1. Factory Method Pattern
// 2. Observer Pattern
// 3. Strategy Pattern
// 4. SOLID Principles
// ==========================================================

// =======================
// ABSTRACT MOVIE CLASS
// =======================
abstract class Movie {
    private static int counter = 1;

    private String id;
    private String title;
    private int duration;

    public Movie(String title, int duration) {
        this.id = "M" + counter++;
        this.title = title;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public abstract double getBasePrice();

    public abstract String getMovieType();
}

// =======================
// REGULAR MOVIE
// =======================
class RegularMovie extends Movie {
    private final double basePrice = 150.0;

    public RegularMovie(String title, int duration) {
        super(title, duration);
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String getMovieType() {
        return "Regular";
    }
}

// =======================
// IMAX MOVIE
// =======================
class IMAXMovie extends Movie {
    private final double basePrice = 300.0;
    private final boolean has3D = true;

    public IMAXMovie(String title, int duration) {
        super(title, duration);
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String getMovieType() {
        return has3D ? "IMAX 3D" : "IMAX";
    }
}

// =======================
// FACTORY METHOD PATTERN
// =======================
interface MovieFactory {
    Movie createMovie(String title, int duration);
}

class RegularMovieFactory implements MovieFactory {
    @Override
    public Movie createMovie(String title, int duration) {
        return new RegularMovie(title, duration);
    }
}

class IMAXMovieFactory implements MovieFactory {
    @Override
    public Movie createMovie(String title, int duration) {
        return new IMAXMovie(title, duration);
    }
}

class MovieFactoryProducer {
    public static MovieFactory getFactory(String movieType) {
        switch (movieType.toLowerCase()) {
            case "regular":
                return new RegularMovieFactory();
            case "imax":
                return new IMAXMovieFactory();
            default:
                throw new IllegalArgumentException("Unknown movie type: " + movieType);
        }
    }
}

// =======================
// SEAT CLASS
// =======================
class Seat {
    private String seatId;
    private String seatType; // NORMAL, PREMIUM
    private boolean isAvailable;

    public Seat(String seatId, String seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.isAvailable = true;
    }

    public String getSeatId() {
        return seatId;
    }

    public String getSeatType() {
        return seatType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean bookSeat() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
}

// =======================
// THEATER CLASS
// =======================
class Theater {
    private String theaterId;
    private String name;
    private String location;

    public Theater(String theaterId, String name, String location) {
        this.theaterId = theaterId;
        this.name = name;
        this.location = location;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}

// =======================
// OBSERVER PATTERN
// =======================
interface ShowObserver {
    void update(String message);
}

class User implements ShowObserver {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification to " + name + " (" + email + "): " + message);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class TheaterManager implements ShowObserver {
    @Override
    public void update(String message) {
        System.out.println("[Manager Alert]: " + message);
    }
}

// =======================
// SHOW CLASS
// =======================
class Show {
    private String showId;
    private Movie movie;
    private String time;
    private Theater theater;
    private Map<String, Seat> seats;
    private List<ShowObserver> observers;

    public Show(String showId, Movie movie, String time, Theater theater) {
        this.showId = showId;
        this.movie = movie;
        this.time = time;
        this.theater = theater;
        this.seats = new LinkedHashMap<>();
        this.observers = new ArrayList<>();
        initializeSeats();
    }

    private void initializeSeats() {
        // Create seats A1-A5, B1-B5, C1-C5
        String[] rows = {"A", "B", "C"};

        for (String row : rows) {
            for (int i = 1; i <= 5; i++) {
                String seatId = row + i;
                String seatType = (row.equals("A")) ? "PREMIUM" : "NORMAL";
                seats.put(seatId, new Seat(seatId, seatType));
            }
        }
    }

    public void addObserver(ShowObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (ShowObserver observer : observers) {
            observer.update(message);
        }
    }

    public boolean bookSeat(String seatId) {
        Seat seat = seats.get(seatId);

        if (seat == null) {
            System.out.println("Seat " + seatId + " does not exist.");
            return false;
        }

        if (seat.bookSeat()) {
            notifyObservers("Seat " + seatId + " booked successfully for show " + showId);
            return true;
        } else {
            System.out.println("Seat " + seatId + " is already booked.");
            return false;
        }
    }

    public Seat getSeat(String seatId) {
        return seats.get(seatId);
    }

    public String getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTime() {
        return time;
    }

    public Theater getTheater() {
        return theater;
    }
}

// =======================
// STRATEGY PATTERN
// =======================
interface PaymentStrategy {
    boolean pay(double amount);
    String getPaymentMethod();
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing ₹" + amount + " via Credit Card ending with "
                + cardNumber.substring(cardNumber.length() - 4));
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}

class UPIPayment implements PaymentStrategy {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing ₹" + amount + " via UPI: " + upiId);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "UPI";
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing ₹" + amount + " via PayPal: " + email);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}

// =======================
// BOOKING CLASS
// =======================
class Booking {
    private static int bookingCounter = 1001;

    private String bookingId;
    private Show show;
    private List<String> bookedSeats;
    private String customerName;
    private PaymentStrategy paymentStrategy;
    private double totalAmount;

    public Booking(Show show, List<String> bookedSeats, String customerName, PaymentStrategy paymentStrategy) {
        this.bookingId = "BK" + bookingCounter++;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.customerName = customerName;
        this.paymentStrategy = paymentStrategy;
        this.totalAmount = calculateTotalAmount();
    }

    private double calculateTotalAmount() {
        double total = 0;

        for (String seatId : bookedSeats) {
            Seat seat = show.getSeat(seatId);

            if (seat != null) {
                double seatPrice = show.getMovie().getBasePrice();

                if (seat.getSeatType().equalsIgnoreCase("PREMIUM")) {
                    seatPrice += 100; // premium seat surcharge
                }

                total += seatPrice;
            }
        }

        return total;
    }

    public boolean confirmBooking() {
        boolean paymentSuccess = paymentStrategy.pay(totalAmount);

        if (paymentSuccess) {
            System.out.println("Payment successful!");
            return true;
        }

        System.out.println("Payment failed!");
        return false;
    }

    public void printSummary() {
        System.out.println("\n5. Booking Summary:");
        System.out.println("   Movie: " + show.getMovie().getTitle() + " (" + show.getMovie().getMovieType() + ")");
        System.out.println("   Show Time: " + show.getTime());
        System.out.println("   Seats: " + String.join(", ", bookedSeats));
        System.out.println("   Total: ₹" + totalAmount);
        System.out.println("   Payment Method: " + paymentStrategy.getPaymentMethod());
        System.out.println("   Booking ID: " + bookingId);
    }
}

// =======================
// MAIN CLASS
// =======================
public class Main {
    public static void main(String[] args) {

        System.out.println("=== MOVIE TICKET BOOKING SYSTEM (SOLID + Patterns) ===\n");

        // ------------------------------------------------------
        // 1. Factory Method: Create movie
        // ------------------------------------------------------
        String movieType = "imax";
        String movieTitle = "Dune: Part Two";
        int duration = 166;

        MovieFactory factory = MovieFactoryProducer.getFactory(movieType);
        Movie movie = factory.createMovie(movieTitle, duration);

        System.out.println("1. Factory Method: Creating " + movieType.toUpperCase()
                + " movie '" + movie.getTitle() + "' (" + movie.getDuration() + " minutes)\n");

        // ------------------------------------------------------
        // 2. Create theater and show
        // ------------------------------------------------------
        Theater theater = new Theater("T001", "PVR Cinemas", "Ropar");
        Show show = new Show("S002", movie, "20:30", theater);

        // ------------------------------------------------------
        // 3. Observer Pattern
        // ------------------------------------------------------
        User user = new User("Bob Smith", "bob@email.com");
        TheaterManager manager = new TheaterManager();

        show.addObserver(user);
        show.addObserver(manager);

        System.out.println("2. Observer Pattern:");
        System.out.println("   - Added " + user.getName() + " as observer");
        System.out.println("   - Added Theater Manager as observer\n");

        // ------------------------------------------------------
        // 4. Booking seats
        // ------------------------------------------------------
        List<String> seatsToBook = Arrays.asList("B3", "B4");

        System.out.println("3. Booking seats " + String.join(", ", seatsToBook) + "...");

        List<String> successfullyBooked = new ArrayList<>();
        for (String seatId : seatsToBook) {
            if (show.bookSeat(seatId)) {
                successfullyBooked.add(seatId);
            }
        }

        // ------------------------------------------------------
        // 5. Strategy Pattern: Payment
        // ------------------------------------------------------
        PaymentStrategy payment = new CreditCardPayment("1234567890123456", "12/25");

        Booking booking = new Booking(show, successfullyBooked, user.getName(), payment);

        System.out.println("\n4. Strategy Pattern - Payment:");
        if (booking.confirmBooking()) {
            booking.printSummary();
            System.out.println("\nBooking confirmed! Enjoy your movie!");
        } else {
            System.out.println("Booking failed.");
        }
    }
}