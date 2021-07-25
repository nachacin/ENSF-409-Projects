import java.util.ArrayList;


public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList<CourseOffering> schedule; // Current
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

		//System.out.println(schedule);
		schedule.remove(removeCoffering);
		studentRegList.remove(removeReg);
		//System.out.println(schedule);
		System.out.println(studentRegList);

	}

}
