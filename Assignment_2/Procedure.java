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



public class Procedure {


	    private String name;
	    private String datePerformed;
	    private String doctorName;
	    private double procedureCharges;
	 // No-arg constructor
	    public Procedure() {
	        this.name = "";
	        this.datePerformed = "";
	        this.doctorName = "";
	        this.procedureCharges = 0.0;
	    }
	 //Only name and date parameters
	    public Procedure(String name, String datePerformed) {
	        this.name = name;
	        this.datePerformed = datePerformed;
	    }
	 //All arguments parameters
	    public Procedure(String name, String datePerformed, String doctorName, double procedureCharges) {
	        this.name = name;
	        this.datePerformed = datePerformed;
	        this.doctorName = doctorName;
	        this.procedureCharges = procedureCharges;
	    }
	 //Accessor methods
	    public String getName() {
	        return name;
	    }
	 //Mutator methods
	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDatePerformed() {
	        return datePerformed;
	    }

	    public void setDatePerformed(String datePerformed) {
	        this.datePerformed = datePerformed;
	    }

	    public String getDoctorName() {
	        return doctorName;
	    }

	    public void setDoctorName(String doctorName) {
	        this.doctorName = doctorName;
	    }
	 // Accessor for procedureCharges
	    
	    public double getProcedureCharges() {
	        return procedureCharges;
	    }
	    
	 // Mutator for procedureCharges
	    public void setProcedureCharges(double procedureCharges) {
	        this.procedureCharges = procedureCharges;
	    }
	 // toString method for Procedure
	    @Override
	    public String toString() {
	        return "Procedure Name: " + name + "\n" +
	               "Date Performed: " + datePerformed + "\n" +
	               "Doctor Name: " + doctorName + "\n" +
	               "Charges: " + procedureCharges;
	    }
	}



