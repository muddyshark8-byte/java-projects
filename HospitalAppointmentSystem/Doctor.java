package HospitalAppointmentSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Doctor {
    private int id;
    private String name;
    private String gender;
    private String specialization;
    private List<String> availableTimeSlots;

    public Doctor(int id, String name, String gender, String specialization, List<String> availableTimeSlots) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.specialization = specialization;
        this.availableTimeSlots = new ArrayList<>(availableTimeSlots);
    }

    public Doctor(int id, String name, String gender, String specialization, String availableTimeSlots) {
        this(id, name, gender, specialization, splitSlots(availableTimeSlots));
    }

    private static List<String> splitSlots(String slots) {
        List<String> list = new ArrayList<>();
        if (slots == null || slots.isBlank()) {
            return list;
        }
        for (String part : slots.split("[;|]")) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                list.add(trimmed);
            }
        }
        if (list.isEmpty()) {
            list.add(slots.trim());
        }
        return list;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getSpecialization() { return specialization; }
    public List<String> getAvailableTimeSlots() { return availableTimeSlots; }

    public void addTimeSlot(String slot) {
        if (slot != null && !slot.isBlank() && !availableTimeSlots.contains(slot.trim())) {
            availableTimeSlots.add(slot.trim());
        }
    }

    @Override
    public String toString() {
        return String.format("Doctor #%d | %s | %s | %s | Slots: %s",
                id, name, gender, specialization, availableTimeSlots);
    }

    public String toFileString() {
        return id + "," + name + "," + gender + "," + specialization + "," + String.join(";", availableTimeSlots);
    }

    public static Doctor fromFileString(String line) {
        String[] p = line.split(",", 5);
        List<String> slots = p.length > 4 ? Arrays.asList(p[4].split(";")) : new ArrayList<>();
        return new Doctor(Integer.parseInt(p[0]), p[1], p[2], p[3], slots);
    }
}
