import java.util.ArrayList;

//This class is simulating a database for our
//program

//Assumption, courses are offered every year in the same number of
//sections. An unlimited number of students may possess registration
//for any course offering (grade records + current). Currently enrolled
//Students are limited to section caps.
public class DBManager {
	
	private ArrayList<Course> courseList;
	private ArrayList<Student> currentStudents;
	private static CourseCatalogue catalogue;

	public DBManager (CourseCatalogue aCatalogue) {
		this.courseList = new ArrayList<Course>();
		catalogue = aCatalogue;
		currentStudents = new ArrayList<Student>();
	}

	public ArrayList<Course> readFromDataBase() {
		
		retrieveCourses();
		setPreReqs();
		setCurrentStudents();
		batchOfferingCreation();
		batchRegAttempts();
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
		courseList.add(new Course ("MATH", 177));
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
		addPreReq("ENEL", 101, "ENGG", 233);
		addPreReq("ENEL", 300, "ENGG", 233);
		addPreReq("ENEL", 300, "ENGG", 225);
		addPreReq("ENCM", 335, "ENGG", 233);
		addPreReq("ENSF", 337, "ENGG", 233);
		addPreReq("PHYS", 259, "MATH", 375);
	}

	private void batchOfferingCreation () {
		catalogue.createCourseOffering(searchDBcourse("MATH", 275), 1, 60);
		catalogue.createCourseOffering(searchDBcourse("MATH", 275), 2, 60);
		catalogue.createCourseOffering(searchDBcourse("MATH", 277), 1, 80);
		catalogue.createCourseOffering(searchDBcourse("MATH", 211), 1, 45);
		catalogue.createCourseOffering(searchDBcourse("ENEL", 101), 1, 150);
		catalogue.createCourseOffering(searchDBcourse("ENSF", 409), 1, 35);
		catalogue.createCourseOffering(searchDBcourse("ENGG", 225), 1, 200);
		catalogue.createCourseOffering(searchDBcourse("ENGG", 233), 1, 115);
		catalogue.createCourseOffering(searchDBcourse("ENSF", 337), 1, 80);
		catalogue.createCourseOffering(searchDBcourse("MATH", 177), 1, 3); // LOW CAP FOR TESTING PURPOSES
		catalogue.createCourseOffering(searchDBcourse("PHYS", 259), 1, 180);
		catalogue.createCourseOffering(searchDBcourse("ENGG", 202), 1, 75);
		catalogue.createCourseOffering(searchDBcourse("ENGG", 201), 1, 110);
		catalogue.createCourseOffering(searchDBcourse("ENEL", 300), 1, 75);
		catalogue.createCourseOffering(searchDBcourse("CHEM", 209), 1, 120);
	}

	
	private void batchRegAttempts() {
		attemptRegistration(searchDBstudent("Nestor Chacin", 12388999), 
		                    searchDBcourse("MATH", 211).getCourseOfferingAt(0),
							'B');
		attemptRegistration(searchDBstudent("Nestor Chacin", 12388999), 
		                    searchDBcourse("ENGG", 225).getCourseOfferingAt(0),
							'A');
		attemptRegistration(searchDBstudent("Nestor Chacin", 12388999), 
		                    searchDBcourse("PHYS", 259).getCourseOfferingAt(0),
							'B');
		attemptRegistration(searchDBstudent("Nasih Nazeem", 32199888), 
		                    searchDBcourse("ENGG", 202).getCourseOfferingAt(0),
							'A');
		attemptRegistration(searchDBstudent("Nasih Nazeem", 32199888), 
		                    searchDBcourse("ENEL", 300).getCourseOfferingAt(0),
							'A');
		attemptRegistration(searchDBstudent("Nasih Nazeem", 32199888), 
		                    searchDBcourse("ENSF", 337).getCourseOfferingAt(0),
							'A');
	}



	private void attemptRegistration (Student aStudent, CourseOffering anOffering, char aGrade) {
		Registration regAttempt = new Registration(aStudent, anOffering, aGrade);
		regAttempt.completeRegistration(aStudent, anOffering);
	}

	private void setCurrentStudents() {
		var student1 = new Student("Nestor Chacin", 12388999);
		currentStudents.add(student1);
		var student2 = new Student("Nasih Nazeem", 32199888);
		currentStudents.add(student2);
	}



	private void addPreReq (String targetCourseName, int targetCourseNum, String preReqName, int preReqNum) {
		Course target = searchDBcourse(targetCourseName, targetCourseNum);
		if (target != null) {
			target.addCoursePreReq(searchDBcourse(preReqName, preReqNum));
		} else {
			System.out.println("DB failed to add " + targetCourseName + targetCourseNum + "to prereqs.");
		}
		
	}
 	public Course searchDBcourse (String courseName, int courseNum) {
		for (Course c : courseList) {
			if (courseName.equals(c.getCourseName()) &&
					courseNum == c.getCourseNum()) {
				return c;
			}	
		}
		displayDBsetUpError();
		return null;
	}

	public Student searchDBstudent (String studentName, int ID) {
		for (Student s : currentStudents) {
			if (studentName.equals(s.getStudentName()) &&
			    ID == s.getStudentId()) {
					return s;
				}
		}
		System.out.println("Student not found in Database search");
		return null;
	}


	private void displayDBsetUpError() {
		// TODO Auto-generated method stub
		System.err.println("Database was set up wrong!");
		
	}

}
