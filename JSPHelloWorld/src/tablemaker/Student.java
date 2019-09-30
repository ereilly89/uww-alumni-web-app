package tablemaker;

public class Student {
	
	String student_id;
	String schoolID;
	
	String school_name;
	
	Student(String student1, String student2, String nameMatch){
		student_id = student1;
		schoolID = student2;
		
		//Employer Name & Location (used for matching)
		school_name = nameMatch;
	}
	
	Student(){
		student_id = "StudentID";
		schoolID = "SchoolID";
		
		//DEFAULT
		school_name = "";
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	@Override
	public String toString() {
		return student_id+", "+schoolID+","+"\n";
		
	}
}
