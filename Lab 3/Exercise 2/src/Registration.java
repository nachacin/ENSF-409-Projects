
public class Registration {
	private Student theStudent;
	private CourseOffering theOffering;
	private char grade;

	//first constructor - with no params
	public Registration () {
		this.theStudent = null;
		this.theOffering = null;
		this.grade = '\u0000';
	}
	//second constructor - wi params
	public Registration (Student aStudent, CourseOffering anOffering, char aGrade) {
		this.theStudent = aStudent;
		this.theOffering = anOffering;
		this.grade = aGrade;
	}
	
	void completeRegistration (Student st, CourseOffering of) {
		theStudent = st;
		theOffering = of;
		addRegistration ();
	}
	
	private void addRegistration () {
		theStudent.addRegistration(this);
		theOffering.addRegistration(this);
	}
	
	
	public Student getTheStudent() {
		return theStudent;
	}
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}
	public CourseOffering getTheOffering() {
		return theOffering;
	}
	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString () {
		String st = "\n";
		st += "Student Name: " + getTheStudent() + "\n";
		st += "The Offering: " + getTheOffering () + "\n";
		st += "Grade: " + getGrade();
		st += "\n-----------\n";
		return st;
		
	}
	

}
