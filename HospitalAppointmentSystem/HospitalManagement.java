package HospitalAppointmentSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalManagement {

    private final List<Patient> patients;
    private final List<Doctor> doctors;
    private final List<Appointment> appointments;
    private final List<MedicalRecord> medicalRecords;
    private final Scanner scanner;

    public HospitalManagement() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
        medicalRecords = new ArrayList<>();
        scanner = new Scanner(System.in);

        seedData();
    }

    private void seedData() {
        patients.add(new Patient("Sarah", 101, 29, "Female", "Nigerian", "08011112222"));
        patients.add(new Patient("James", 102, 45, "Male", "British", "08033334444"));
        patients.add(new Patient("Noah Barnes", 103, 40, "Male", "European", "08033962749"));

        doctors.add(new Doctor(200, "Handel", "Male", "Orthopedics", "10:00 - 12:00"));
        doctors.add(new Doctor(201, "Amaka", "Female", "Cardiology", "9:00 - 11:00"));

        appointments.add(new Appointment(1, 101, 200, "2026-09-25", "10:30", "Confirmed", "Room 4"));
        appointments.add(new Appointment(2, 102, 201, "2026-09-26", "09:15", "Confirmed", "Room 2"));

        medicalRecords.add(new MedicalRecord(101, "O+", "None", "Asthma", "None currently", "Mary", "08055556666", "2026-08-01", "2026-08-01"));
        medicalRecords.add(new MedicalRecord(102, "A-", "Penicillin", "None", "Mild flu", "Tom", "08077778888", "2026-07-15", "2026-07-15"));
    }

    public static void main(String[] args) {
        HospitalManagement system = new HospitalManagement();
        system.start();
    }

    public void start() {
        while (true) {
            System.out.println("WELCOME TO HEALTH WELFARE HOSPITAL.");
            System.out.println("Kindly Choose What you Want To Do Today");
            System.out.println("1. Admin Menu");
            System.out.println("2. Doctor Menu");
            System.out.println("3. Patient Menu");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    doctorMenu();
                    break;
                case 3:
                    patientMenu();
                    break;
                case 4:
                    System.out.println("Come Again... Hopefully just to look around lol");
                    return;
                default:
                    System.out.println("Ahem, Dear patient. That's a wrong input");
            }
        }
    }

    public void adminMenu() {
        while (true) {
            System.out.println("\nADMIN MENU");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter Nationality: ");
                    String nationality = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    patients.add(new Patient(name, id, age, gender, nationality, phone));
                    System.out.println("Patient Added Successfully");
                    break;

                case 2:
                    System.out.print("Enter name: ");
                    String docName = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int docId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Gender: ");
                    String docGender = scanner.nextLine();
                    System.out.print("Specialization: ");
                    String specialization = scanner.nextLine();
                    System.out.print("Enter Available Time Slots: ");
                    String availableTimeSlots = scanner.nextLine();

                    doctors.add(new Doctor(docId, docName, docGender, specialization, availableTimeSlots));
                    System.out.println("The Registered doctors shall arrive soon.");
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Wrong Choice buddy");
            }
        }
    }

    public void doctorMenu() {
        while (true) {
            System.out.println("\nDOCTOR MENU");
            System.out.println("1. Verify Doctor ID");
            System.out.println("2. Check Appointments");
            System.out.println("3. View Patient Medical Records");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Welcome Doctor. Please verify your ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Doctor foundDoctor = null;
                    for (Doctor d : doctors) {
                        if (d.getId() == id) {
                            foundDoctor = d;
                            break;
                        }
                    }

                    if (foundDoctor != null) {
                        System.out.println("Welcome Doctor. " + foundDoctor.getName());
                    } else {
                        System.out.println("No doctor found with that ID");
                    }
                    break;
                }

                case 2:
                    System.out.print("Input doctor ID: ");
                    int docId = scanner.nextInt();
                    scanner.nextLine();

                    List<Appointment> foundAppointments = new ArrayList<>();
                    for (Appointment a : appointments) {
                        if (a.getDoctorid() == docId) {
                            foundAppointments.add(a);
                        }
                    }

                    if (foundAppointments.isEmpty()) {
                        System.out.println("You have no appointments");
                    } else {
                        for (Appointment appt : foundAppointments) {
                            System.out.println(appt.toString());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Input the ID of your desired patient: ");
                    int patId = scanner.nextInt();
                    scanner.nextLine();

                    MedicalRecord foundMedicalRecord = null;
                    for (MedicalRecord record : medicalRecords) {
                        if (record.getPatientId() == patId) {
                            foundMedicalRecord = record;
                            break;
                        }
                    }

                    if (foundMedicalRecord != null) {
                        System.out.println(foundMedicalRecord.toString());
                    } else {
                        System.out.println("No medical record found for that patient.");
                    }
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Two wrongs don't make a right");
            }
        }
    }

    public void patientMenu() {
        while (true) {
            System.out.println("\nPATIENT MENU");
            System.out.println("1. Check Appointments");
            System.out.println("2. Book Appointment");
            System.out.println("Postpone Appointment");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your patient ID: ");
                    int patId = scanner.nextInt();
                    scanner.nextLine();

                    List<Appointment> found = new ArrayList<>();
                    for (Appointment a : appointments) {
                        if (a.getPatientid() == patId) {
                            found.add(a);
                        }
                    }

                    if (found.isEmpty()) {
                        System.out.println("No appointments found.");
                    } else {
                        for (Appointment a : found) {
                            System.out.println(a.toString());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter your patient ID: ");
                    int pid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter doctor ID: ");
                    int did = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter date: ");
                    String date = scanner.nextLine();
                    System.out.print("Enter time: ");
                    String time = scanner.nextLine();
                    System.out.print("Enter location: ");
                    String location = scanner.nextLine();

                    int newId = appointments.size() + 1;
                    appointments.add(new Appointment(newId, pid, did, date, time, "Confirmed", location));
                    System.out.println("Appointment booked!");
                    break;

                case 3:
                    System.out.println("Enter the appointment ID you want to postpone: ");
                    int aptid = scanner.nextInt();
                    scanner.nextLine();

                    Appointment foundAppointment = null;
                    for (Appointment a : appointments)
                    {
                        if (a.getAppointmentid() == aptid)
                        {
                            foundAppointment = a;
                            break;
                        }
                    }
                    if (foundAppointment != null)
                    {
                        System.out.println("Enter new date: ");
                        String newDate = scanner.nextLine();
                        System.out.println("Enter new time: ");
                        String newTime = scanner.nextLine();

                        foundAppointment.setDate(newDate);
                        foundAppointment.setTime(newTime);

                        System.out.println("Appointment postponed successfully!");
                       
                    }
                    else{
                        System.out.println("No appointment found with that ID");
                    }
                    break;

                    case 4:
                        return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

