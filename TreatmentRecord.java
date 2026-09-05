import java.time.LocalDate;

public class TreatmentRecord {
    private Patient patient;
    private String treatmentDate;
    private String diagnosis;

    public TreatmentRecord(Patient patient, String treatmentDate, String diagnosis) {
        this.patient = patient;
        this.treatmentDate = treatmentDate;
        this.diagnosis = diagnosis;
    }

    public Patient getPatient() { return patient; }
    public String getTreatmentDate() { return treatmentDate; }
    public String getDiagnosis() { return diagnosis; }

    @Override
    public String toString() {
        return "[Treatment: " + patient.getName() + 
               ", ID: " + patient.getPatientId() + 
               ", Diagnosis: " + diagnosis + 
               ", Date: " + treatmentDate + "]";
    }
}