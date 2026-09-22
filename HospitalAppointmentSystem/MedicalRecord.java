package HospitalAppointmentSystem;

public class MedicalRecord {
    private int patientId;
    private String bloodGroup;
    private String allergies;
    private String priorIllness;
    private String currentAilments;
    private String nextOfKinName;
    private String nextOfkinContact;
    private String lastVisitDate;
    private String admissionDate;

    public MedicalRecord(int patientId, String bloodGroup, String allergies, String priorIllness,
                        String currentAilments, String nextOfKinName, String nextOfkinContact,
                        String lastVisitDate, String admissionDate) {
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.priorIllness = priorIllness;
        this.currentAilments = currentAilments;
        this.nextOfKinName = nextOfKinName;
        this.nextOfkinContact = nextOfkinContact;
        this.lastVisitDate = lastVisitDate;
        this.admissionDate = admissionDate;
    }

    public int getPatientId() { return patientId;}
    public String getBloodGroup() { return bloodGroup;}
    public String getAllergies() { return allergies;}
    public String getPriorIllness() {return priorIllness;}
    public String getCurrentAilments() { return currentAilments;}
    public String getNextOfKinName() { return nextOfKinName;}
    public String getNextOfkinContact() {return nextOfkinContact;}
    public String getLastVisitDate() { return lastVisitDate;}
    public String getAdmissionDate() { return admissionDate;}
    
    @Override
    public String toString() {
        return "MedicalRecord [patientId=" + patientId + ", bloodGroup=" + bloodGroup + ", allergies=" + allergies
                + ", priorIllness=" + priorIllness + ", currentAilments=" + currentAilments + ", nextOfKinName="
                + nextOfKinName + ", nextOfkinContact=" + nextOfkinContact + ", lastVisitDate=" + lastVisitDate
                + ", admissionDate=" + admissionDate + "]";
    }
}
