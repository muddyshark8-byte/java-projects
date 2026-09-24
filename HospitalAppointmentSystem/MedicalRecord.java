package HospitalAppointmentSystem;

public class MedicalRecord {
    private int patientId;
    private String bloodGroup;
    private String allergies;
    private String priorIllnesses;
    private String currentAilments;
    private String nextOfKinName;
    private String nextOfKinContact;
    private String lastVisitDate;
    private String admissionDate;
    private int attendedCount;
    private int missedCount;

    public MedicalRecord(int patientId, String bloodGroup, String allergies, String priorIllnesses,
                         String currentAilments, String nextOfKinName, String nextOfKinContact,
                         String lastVisitDate, String admissionDate) {
        this(patientId, bloodGroup, allergies, priorIllnesses, currentAilments,
                nextOfKinName, nextOfKinContact, lastVisitDate, admissionDate, 0, 0);
    }

    public MedicalRecord(int patientId, String bloodGroup, String allergies, String priorIllnesses,
                         String currentAilments, String nextOfKinName, String nextOfKinContact,
                         String lastVisitDate, String admissionDate, int attendedCount, int missedCount) {
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.priorIllnesses = priorIllnesses;
        this.currentAilments = currentAilments;
        this.nextOfKinName = nextOfKinName;
        this.nextOfKinContact = nextOfKinContact;
        this.lastVisitDate = lastVisitDate;
        this.admissionDate = admissionDate;
        this.attendedCount = attendedCount;
        this.missedCount = missedCount;
    }

    public int getPatientId() { return patientId; }
    public String getBloodGroup() { return bloodGroup; }
    public String getAllergies() { return allergies; }
    public String getPriorIllnesses() { return priorIllnesses; }
    public String getCurrentAilments() { return currentAilments; }
    public String getNextOfKinName() { return nextOfKinName; }
    public String getNextOfKinContact() { return nextOfKinContact; }
    public String getLastVisitDate() { return lastVisitDate; }
    public String getAdmissionDate() { return admissionDate; }
    public int getAttendedCount() { return attendedCount; }
    public int getMissedCount() { return missedCount; }

    public void setLastVisitDate(String lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public void incrementAttended() { attendedCount++; }
    public void incrementMissed() { missedCount++; }

    @Override
    public String toString() {
        return """
                Medical Record for Patient #%d
                Blood group     : %s
                Allergies       : %s
                Prior illnesses : %s
                Current ailments: %s
                Next of kin     : %s (%s)
                Last visit      : %s
                Admission date  : %s
                Attended        : %d
                Missed          : %d
                """.formatted(
                patientId, bloodGroup, allergies, priorIllnesses, currentAilments,
                nextOfKinName, nextOfKinContact, lastVisitDate, admissionDate,
                attendedCount, missedCount);
    }

    public String toFileString() {
        return patientId + "," + bloodGroup + "," + allergies + "," + priorIllnesses + "," +
                currentAilments + "," + nextOfKinName + "," + nextOfKinContact + "," +
                lastVisitDate + "," + admissionDate + "," + attendedCount + "," + missedCount;
    }

    public static MedicalRecord fromFileString(String line) {
        String[] p = line.split(",", -1);
        int attended = p.length > 9 ? Integer.parseInt(p[9]) : 0;
        int missed = p.length > 10 ? Integer.parseInt(p[10]) : 0;
        return new MedicalRecord(
                Integer.parseInt(p[0]), p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8], attended, missed
        );
    }
}
