package HospitalAppointmentSystem;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String date;
    private String time;
    private String status;
    private String location;

    public Appointment(int appointmentId, int patientId, int doctorId,
                       String date, String time, String status, String location) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.status = status;
        this.location = location;
    }

    public int getAppointmentId() { return appointmentId; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getStatus() { return status; }
    public String getLocation() { return location; }

    public void setDate(String date) {
        if (date == null || date.isBlank()) {
            System.out.println("Date cannot be empty.");
            return;
        }
        this.date = date.trim();
    }

    public void setTime(String time) {
        if (time == null || time.isBlank()) {
            System.out.println("Time cannot be empty.");
            return;
        }
        this.time = time.trim();
    }

    public void setStatus(String status) {
        if (status != null && !status.isBlank()) {
            this.status = status.trim();
        }
    }

    @Override
    public String toString() {
        return String.format("Appointment #%d | Patient %d | Doctor %d | %s %s | %s | %s",
                appointmentId, patientId, doctorId, date, time, location, status);
    }

    public String toFileString() {
        return appointmentId + "," + patientId + "," + doctorId + "," +
                date + "," + time + "," + status + "," + location;
    }

    public static Appointment fromFileString(String line) {
        String[] p = line.split(",", -1);
        return new Appointment(
                Integer.parseInt(p[0]),
                Integer.parseInt(p[1]),
                Integer.parseInt(p[2]),
                p[3], p[4], p[5], p[6]
        );
    }
}
