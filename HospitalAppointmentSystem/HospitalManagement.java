package HospitalAppointmentSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class HospitalManagement {

    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();
    private final List<MedicalRecord> medicalRecords = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    private static final String PATIENTS_FILE = "patients.txt";
    private static final String DOCTORS_FILE = "doctors.txt";
    private static final String APPOINTMENTS_FILE = "appointments.txt";
    private static final String RECORDS_FILE = "records.txt";

    public HospitalManagement() {
        loadData();
        if (patients.isEmpty() && doctors.isEmpty()) {
            seedData();
            saveData();
        }
    }

    private void seedData() {
        patients.add(new Patient(101, "Sarah", 29, "Female", "Nigerian", "08011112222"));
        patients.add(new Patient(102, "James", 45, "Male", "British", "08033334444"));
        patients.add(new Patient(103, "Noah Barnes", 40, "Male", "European", "08033962749"));

        doctors.add(new Doctor(200, "Handel", "Male", "Orthopedics", "10:00;11:00;12:00"));
        doctors.add(new Doctor(201, "Amaka", "Female", "Cardiology", "09:00;09:30;10:00"));

        appointments.add(new Appointment(1, 101, 200, "2026-09-25", "10:00", "Scheduled", "Room 4"));
        appointments.add(new Appointment(2, 102, 201, "2026-09-26", "09:00", "Scheduled", "Room 2"));

        medicalRecords.add(new MedicalRecord(101, "O+", "None", "Asthma", "None currently",
                "Mary", "08055556666", "2026-08-01", "2026-08-01"));
        medicalRecords.add(new MedicalRecord(102, "A-", "Penicillin", "None", "Mild flu",
                "Tom", "08077778888", "2026-07-15", "2026-07-15"));
    }

    public static void main(String[] args) {
        new HospitalManagement().start();
    }

    public void start() {
        while (true) {
            System.out.println("\n===== HEALTH WELFARE HOSPITAL =====");
            System.out.println("1. Admin Menu");
            System.out.println("2. Doctor Menu");
            System.out.println("3. Patient Menu");
            System.out.println("4. Exit");
            int choice = readInt("Choice: ");

            switch (choice) {
                case 1 -> adminMenu();
                case 2 -> doctorMenu();
                case 3 -> patientMenu();
                case 4 -> {
                    saveData();
                    System.out.println("Come again... hopefully just to look around.");
                    return;
                }
                default -> System.out.println("Wrong input. Try again.");
            }
        }
    }

    private void adminMenu() {
        while (true) {
            System.out.println("\n----- ADMIN MENU -----");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Assign Appointment");
            System.out.println("4. View All Appointments");
            System.out.println("5. Add Medical Record");
            System.out.println("6. Back to Main Menu");
            int choice = readInt("Choice: ");

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> addDoctor();
                case 3 -> assignAppointment();
                case 4 -> viewAllAppointments();
                case 5 -> addOrUpdateRecord();
                case 6 -> { return; }
                default -> System.out.println("Wrong choice.");
            }
        }
    }

    private void doctorMenu() {
        int doctorId = readInt("Enter your Doctor ID: ");
        Doctor doctor = findDoctor(doctorId);
        if (doctor == null) {
            System.out.println("No doctor found with that ID.");
      
... 