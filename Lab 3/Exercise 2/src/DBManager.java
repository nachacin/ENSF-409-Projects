import java.util.ArrayList;

//This class is simulating a database for our
//program

//Assumption, courses are offered every year in the same number of
//sections. An unlimited number of students may possess registration
//for any course offering (grade records + current). But 
public class DBManager {
	
	private ArrayList<Course> courseList;
	private ArrayList<Student> currentStudents;
	private static CourseCatalogue catalogue;

	public DBManager (CourseCatalogue aCatalogue) {
		this.courseList = new ArrayList<Course>();
		catalogue = aCatalogue;
	}

	public ArrayList<Course> readFromDataBase() {
		
		retrieveCourses();
		setPreReqs();
		setCurrentStudents();
		return courseList;
	}

	private void retrieveCourses() {
		courseList.add(new Course ("CHEM", 209));
		courseList.add(new Course ("ENGG", 233));
		courseList.add(new Course ("MATH", 275));
		courseList.add(new Course ("MATH", 211));
		courseList.add(new Course ("ENGG", 225));
		courseList.add(new Course ("ENGG", 201));
		courseList.add(new Course ("ENGG", 202));
		courseList.add(new Course ("MATH", 277));
		courseList.add(new Course ("PHYS", 259));
		courseList.add(new Course ("ENGG", 200));
		courseList.add(new Course ("PHYS", 365));
		courseList.add(new Course ("MATH", 375));
		courseList.add(new Course ("ENCM", 335));
		courseList.add(new Course ("ENSF", 337));
		courseList.add(new Course ("ENEL", 353));
		courseList.add(new Course ("ENEL", 101));
		courseList.add(new Course ("ENEL", 361));
		courseList.add(new Course ("ENEL", 343));
		courseList.add(new Course ("ENEL", 327));
		courseList.add(new Course ("ENEL", 300));
		courseList.add(new Course ("ENCM", 369));
		courseList.add(new Course ("ENEL", 475));
		courseList.add(new Course ("ENEL", 469));
		courseList.add(new Course ("ENEL", 487));
		courseList.add(new Course ("ENCM", 467));
		courseList.add(new Course ("ENEL", 453));
		courseList.add(new Course ("ENEL", 419));
		courseList.add(new Course ("ENCM", 511));
		courseList.add(new Course ("ENEL", 102));
		courseList.add(new Course ("ENEL", 441));
		courseList.add(new Course ("ENEL", 400));
		courseList.add(new Course ("ENEL", 471));
		courseList.add(new Course ("ENSF", 409));
		courseList.add(new Course ("CPSC", 319));
		courseList.add(new Course ("ENEL", 567));
		courseList.add(new Course ("CPSC", 457));
		courseList.add(new Course ("ENEL", 573));
		courseList.add(new Course ("ENEL", 501));
	}

	
	private void setPreReqs() {
		addPreReq("MATH", 277, "MATH", 275);
		addPreReq("MATH", 277, "MATH", 211);
		addPreReq("MATH", 277, "MATH", 275);
		addPreReq("ENEL", 101, "ENGG", 233);
		addPreReq("ENEL", 300, "ENGG", 233);
		addPreReq("ENEL", 300, "ENGG", 225);
		addPreReq("ENCM", 335, "ENGG", 233);
		addPreReq("ENSF", 337, "ENGG", 233);
		addPreReq("PHYS", 259, "MATH", 375);
	}

	private void setCurrentStudents() {
		student1 = new Student("Nestor Chacin", 12388999);
		create
		stu1Reg = new Registration(student1, )
 
	}



	private void addPreReq (String targetCourseName, int targetCourseNum, String preReqName, int preReqNum) {
		Course target = searchDB(targetCourseName, targetCourseNum);
		if (target != null) {
			target.addCoursePreReq(searchDB(preReqName, preReqNum));
		} else {
			System.out.println("DB failed to add " + targetCourseName + targetCourseNum + "to prereqs.");
		}
		
	}
 	public Course searchDB (String courseName, int courseNum) {
		for (Course c : courseList) {
			if (courseName.equals(c.getCourseName()) &&
					courseNum == c.getCourseNum()) {
				return c;
			}	
		}
		displayDBsetUpError();
		return null;
	}
	private void displayDBsetUpError() {
		// TODO Auto-generated method stub
		System.err.println("Database was set up wrong!");
		
	}

}
