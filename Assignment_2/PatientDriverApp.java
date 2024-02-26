/*
 * Class: CMSC203-32689
 * Instructor: Professor Grigoriy Grinberg
 * Description:Assignment using multiple Java and Classes about Patients
 * Due: 02/26/2024
 * Platform/compiler:Java Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Min Hein Khant
*/


public class PatientDriverApp {
    public static void main(String[] args) {
        Patient patientEmily = new Patient("Emily", "R.", "Johnson", 
                                           "4587 Maple Street", "Denver", "CO", "80205", 
                                           "720-555-0147", "Laura Johnson", "720-555-0148");

        Procedure fluShot = new Procedure("Flu Shot", "02/15/2024", "Dr. Clark", 50.0);
        Procedure annualExam = new Procedure("Annual Physical Exam", "02/16/2024", "Dr. Clark", 200.0);

        Patient patientOliver = new Patient("Oliver", "T.", "Williams", 
                                            "32 High Street", "Bristol", "", "BS1 4AW", 
                                            "0117-555-0123", "Fiona Williams", "0117-555-0124");

        Procedure dentalCheckup = new Procedure("Dental Checkup", "03/21/2024", "Dr. Morris", 85.0);
        Procedure allergyTest = new Procedure("Allergy Testing", "03/22/2024", "Dr. Morris", 120.0);

        Patient patientHaruto = new Patient("Haruto", "", "Takahashi", 
                                            "3-5-1 Kita-Aoyama", "Minato City", "Tokyo", "107-0061", 
                                            "03-5550-4567", "Yui Takahashi", "03-5550-4568");

        Procedure bloodPressure = new Procedure("Blood Pressure Screening", "04/10/2024", "Dr. Sato", 3000.0);
        Procedure eyeExam = new Procedure("Eye Examination", "04/11/2024", "Dr. Sato", 5000.0);

        showPatientDetails(patientEmily);
        showProcedureDetails(fluShot);
        showProcedureDetails(annualExam);
        double chargesEmily = sumProcedureCharges(fluShot, annualExam);
        System.out.println("Total Charges for Emily Johnson: " + String.format("%.2f", chargesEmily) + "\n");

        showPatientDetails(patientOliver);
        showProcedureDetails(dentalCheckup);
        showProcedureDetails(allergyTest);
        double chargesOliver = sumProcedureCharges(dentalCheckup, allergyTest);
        System.out.println("Total Charges for Oliver Williams: " + String.format("%.2f", chargesOliver) + "\n");

        showPatientDetails(patientHaruto);
        showProcedureDetails(bloodPressure);
        showProcedureDetails(eyeExam);
        double chargesHaruto = sumProcedureCharges(bloodPressure, eyeExam);
        System.out.println("Total Charges for Haruto Takahashi: " + String.format("%.2f", chargesHaruto));
    }

    private static void showPatientDetails(Patient patient) {
        System.out.println("Patient Information:");
        System.out.println(patient);
    }

    private static void showProcedureDetails(Procedure procedure) {
        System.out.println("Procedure Information:");
        System.out.println(procedure);
    }

    private static double sumProcedureCharges(Procedure... procedures) {
        double total = 0.0;
        for (Procedure proc : procedures) {
            total += proc.getProcedureCharges();
        }
        return total;
    }
}
