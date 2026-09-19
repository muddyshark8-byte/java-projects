import java.time.LocalDate;

public class Reservation {
    private String bookingId;
    private int roomId;
    private String guestName;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double totalAmount;
    private String paymentStatus;

    public Reservation(String bookingId, int roomId, String guestName,
                       LocalDate checkIn, LocalDate checkOut, double totalAmount) {
        this.bookingId = bookingId;
        this.roomId = roomId;
        this.guestName = guestName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalAmount = totalAmount;
        this.paymentStatus = "PENDING";
    }

    public String getBookingId() { return bookingId; }
    public int getRoomId() { return roomId; }
    public String getGuestName() { return guestName; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public double getTotalAmount() { return totalAmount; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String status) { this.paymentStatus = status; }

    @Override
    public String toString() {
        return String.format("""
                Booking ID   : %s
                Guest        : %s
                Room ID      : %d
                Check-in     : %s
                Check-out    : %s
                Total Amount : $%.2f
                Payment      : %s
                """, bookingId, guestName, roomId, checkIn, checkOut, totalAmount, paymentStatus);
    }

    public String toFileString() {
        return bookingId + "," + roomId + "," + guestName + "," +
               checkIn + "," + checkOut + "," + totalAmount + "," + paymentStatus;
    }

    public static Reservation fromFileString(String line) {
        String[] p = line.split(",");
        Reservation r = new Reservation(p[0], Integer.parseInt(p[1]), p[2],
                LocalDate.parse(p[3]), LocalDate.parse(p[4]), Double.parseDouble(p[5]));
        r.setPaymentStatus(p[6]);
        return r;
    }
}