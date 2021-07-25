import java.util.ArrayList;


public class CourseOffering {
	
	// Section Number of the Course
	private int secNum;
	// Section Capacity of the Course
	private int secCap;
	// Course which is receiving a course offering (a course section)
	private Course theCourse;
	// Current students enlisted in the course offering.
	private ArrayList<Student> currentEnrolment;
	// Current and past students that possess a registration of this course offering. Past 
	// students who have completed the course would have a registration containing a Student object, a Course Section object, and a grade.
	// Currently enrolled students are similar, but lack a grade.
	private ArrayList<Registration> offeringRegRecord; // all students ever enrolled + currently enrolled students
	// Checks to see whether there are enough students enrolled to continue to hold onto a section.
	private boolean minEnrolmentMet;
	
	public CourseOffering (int secNum, int secCap) {
		this.setSecNum(secNum);
		this.setSecCap(secCap);
		this.minEnrolmentMet = false;

		offeringRegRecord = new ArrayList <Registration>();
		currentEnrolment = new ArrayList<Student>();
		
	}

	public int getSecNum() {
		return secNum;
	}

	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}
	
	public int getSecCap() {
		return secCap;
	}

	public void setSecCap(int secCap) {
		this.secCap = secCap;
	}

	public Course getTheCourse() {
		return theCourse;
	}

	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}
	
	@Override
	public String toString () {
		String st = "\n";
		String status;

		if(getOfferingStatus() == true) {
			status = "Confirmed.";
		} else {
			status = "Tentative.";
		}

		st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
		st += "Section Num: " + getSecNum() + ", section cap: "+ getSecCap() + ", Status: " + status + "\n";
		//We also want to print the names of all students in the section
		st += "Students in this course:\n" + this.currentEnrolment;
		

		return st;
	}

	public void recordRegistration(Registration anEntry) {
		// TODO Auto-generated method stub
		offeringRegRecord.add(anEntry);
		
	}

	public void addToStudentEnrollment(Registration offerReg) {

		currentEnrolment.add(offerReg.getTheStudent());
		if(currentEnrolment.size() >= 8){
			this.minEnrolmentMet = true;
		} else {
			System.out.println("This course's enrolment is still too low to create a section. As of now, these registrations are tentative.");
		}
	}
	
	public boolean getOfferingStatus() {
		return this.minEnrolmentMet;
	}

	public void removeReg(Student student, Registration registration) {
		Student removeStudent = null;
		Registration removeRegistration = null;

		for(Student se : currentEnrolment)
		{
			if(se.equals(student))
				removeStudent = se;
		}

		for(Registration rr : offeringRegRecord)
		{
			if (rr.equals(registration))
				removeRegistration = rr;
		}
		currentEnrolment.remove(removeStudent);
		offeringRegRecord.remove(removeRegistration);
	}

	

	
	

}