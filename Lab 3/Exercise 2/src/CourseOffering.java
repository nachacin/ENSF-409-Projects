import java.util.ArrayList;

// CourseOffering = section of a particular course

public class CourseOffering {
	
	private int secNum;
	private int secCap;
	private Course theCourse;
	private ArrayList<Student> currentEnrolment;
	private ArrayList<Registration> offeringRegRecord; // all students ever enrolled + currently enrolled students
	
	public CourseOffering (int secNum, int secCap) {
		this.setSecNum(secNum);
		this.setSecCap(secCap);
		offeringRegRecord = new ArrayList <Registration>();
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
		st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
		st += "Section Num: " + getSecNum() + ", section cap: "+ getSecCap() +"\n";
		//We also want to print the names of all students in the section
		return st;
	}

	public void recordRegistration(Registration anEntry) {
		// TODO Auto-generated method stub
		offeringRegRecord.add(anEntry);
		
	}
	
	

}
