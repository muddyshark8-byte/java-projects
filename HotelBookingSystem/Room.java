public class Room {
    private int roomId;
    private String category;
    private double pricePerNight;
    private boolean isAvailable;

    public Room(int roomId, String category, double pricePerNight, boolean isAvailable) {
        this.roomId = roomId;
        this.category = category;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
    }

    public int getRoomId() { return roomId; }
    public String getCategory() { return category; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public String toString() {
        return String.format("Room %d | %-8s | $%.2f/night | %s",
                roomId, category, pricePerNight, isAvailable ? "Available" : "Booked");
    }

    public String toFileString() {
        return roomId + "," + category + "," + pricePerNight + "," + isAvailable;
    }

    public static Room fromFileString(String line) {
        String[] p = line.split(",");
        return new Room(Integer.parseInt(p[0]), p[1], Double.parseDouble(p[2]), Boolean.parseBoolean(p[3]));
    }
}