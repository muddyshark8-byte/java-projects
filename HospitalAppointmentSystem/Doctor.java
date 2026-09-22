package HospitalAppointmentSystem;

import java.util.List;
import java.util.ArrayList;

public class Doctor {
    private List<String> availableTimeSlots;
    private int id;
    private String name;
    private String gender;
    private String specialization;
    
    public Doctor(int id, String name, String gender, String specialization, String availableTimeSlots) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.specialization = specialization;
		this.availableTimeSlots = new ArrayList<>(); // TO HANDLE ALL THE TIME SLOTS
	}
    public int getId() {return id;}
    public String getName() {return name;}
    public String getGender() {return gender;}
    public String getSpecialization() {return specialization;}
    public List <String> getAvailableTimeSlots() {return availableTimeSlots;}


	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", gender=" + gender + ", specialization=" + specialization
				+ ", availableTimeSlots=" + availableTimeSlots + "]";
	}



	
    
	
    
    

    
}
