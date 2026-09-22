package HospitalAppointmentSystem;

public class Appointment {
    private int appointmentid;
    private int patientid;
    private int doctorid;
    private String date;
    private String time;
    private String status;
    private String location;

    public Appointment(int appointmentid, int patientid, int doctorid, String date, String time, String status, String location) {
		this.appointmentid = appointmentid;
		this.patientid = patientid;
		this.doctorid = doctorid;
		this.date = date;
		this.time = time;
		this.status = status;
		this.location = location;
	}

	public int getAppointmentid() {return appointmentid;}
	public int getPatientid() {return patientid;}
	public int getDoctorid() {return doctorid;}
	public String getDate() {return date;}
	public String getTime() {return time;}
	public String getStatus() {return status;}
	public String getLocation() {return location;}
	public void setDate(String date)
	{
		if (date == null || date.isEmpty())
		{
			System.out.println("Date cannot be empty");
		}
		else{
			this.date = date;
		}
	}
	public void setTime(String time)
	{
		if (time == null || time.isEmpty())
		{
			System.out.println("Cannnot be empty");
		}
		else{
			this.time = time;
		}
	}


	@Override
	public String toString() {
		return "Appointment [appointmentid=" + appointmentid + ", patientid=" + patientid + ", doctorid=" + doctorid
				+ ", date=" + date + ", time=" + time + ", status=" + status + ", location=" + location + "]";
	}

    




	


}
