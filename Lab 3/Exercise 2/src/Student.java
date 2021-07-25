import java.util.ArrayList;


public class Student {
	
	private String studentName;
	private int studentId;
	// schedule is an ArrayList of course offerings (i.e. sections) that a student has enrolled in.
	private ArrayList<CourseOffering> schedule;
	// A collection of Registration objects that serves as both a record of previously completed courses
	// AND for currently enrolled courses.
	private ArrayList<Registration> studentRegList; // Past + Current
	
	
	public Student (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		studentRegList = new ArrayList<Registration>();
		schedule = new ArrayList<CourseOffering>();
	}

	public void addToSchedule(Registration rStu) {
		
		schedule.add(rStu.getTheOffering());

	}

	public int getScheduleSize() {
		return this.schedule.size();
	}

	public void getSchedule() {
		//System.out.println(schedule);
		String status;
		for(CourseOffering e : this.schedule) {
			if(e.getOfferingStatus() == true){
				status = "Confirmed.";
				System.out.println(e.getTheCourse().getCourseName() + " " + e.getTheCourse().getCourseNum() + ", Section No: " + e.getSecNum() + ", Status: "+ status +"\n");
			} else {
				status = "Tentative.";
				System.out.println(e.getTheCourse().getCourseName() + " " + e.getTheCourse().getCourseNum() + ", Section No: " + e.getSecNum() + ", Status: "+ status +"\n");
			}
		}
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString () {
		String st = "Student Name: " + getStudentName() + "\n" +
			"Student Id: " + getStudentId() + "\n\n";
		return st;
	}

	public void addToRecords(Registration registration) {
		// TODO Auto-generated method stub
		studentRegList.add(registration);
		
	}

	public void getStuOffering(Course course, Registration registration) {
		CourseOffering removeCoffering = null;
		Registration removeReg = null;
		
		for(CourseOffering ce : schedule)
		{
			if((ce.getTheCourse()).equals(course))
				removeCoffering = ce;
		}

		for(Registration rr : studentRegList)
		{
			if(rr.equals(registration))
				removeReg = rr;
		}
		schedule.remove(removeCoffering);
		studentRegList.remove(removeReg);

	}

}
