package HospitalAppointmentSystem;

public class Patient {
    private String name;
    private int id;
    private int age;
    private String gender;
    private String nationality;
    private String phone;

	public Patient(String name, int iD, int age, String gender, String nationality, String phone) {
		this.name = name;
		this.id = iD;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
        this.phone = phone;
	}

	public String getName() {return name;}
    public int getID() {return id;}
    public int getAge() {return age;}
    public String getGender() {return gender;}
    public String getNationality() {return nationality;}
    public String getPhone() { return phone; }

	@Override
	public String toString() {
		return "Patient [name=" + name + ", id=" + id + ", age=" + age + ", gender=" + gender + ", nationality="
				+ nationality + ", phone=" + phone + "]";
	}
}
