
package HospitalAppointmentSystem;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String nationality;
    private String phone;

    public Patient(int id, String name, int age, String gender, String nationality, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getNationality() { return nationality; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return String.format("Patient #%d | %s | Age %d | %s | %s | %s",
                id, name, age, gender, nationality, phone);
    }

    public String toFileString() {
        return id + "," + name + "," + age + "," + gender + "," + nationality + "," + phone;
    }

    public static Patient fromFileString(String line) {
        String[] p = line.split(",", -1);
        return new Patient(Integer.parseInt(p[0]), p[1], Integer.parseInt(p[2]), p[3], p[4], p[5]);
    }
}
