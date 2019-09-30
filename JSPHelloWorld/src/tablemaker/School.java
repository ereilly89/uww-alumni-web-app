package tablemaker;

public class School {
	
	String school_id;
	String school_name;
	
	//CONSTRUCTOR
	School(String school1, String school2){
		school_id = school1;
		school_name = school2;
	}
	
	School(){
		school_id = "SchoolID";
		school_name = "School Name";
	}
	
	public String getSchool_id() {
		return school_id;
	}

	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	@Override
	public String toString() {
		return school_id+", "+school_name+"\n";
	}
}