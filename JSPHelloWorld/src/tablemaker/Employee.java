package tablemaker;

public class Employee {
	
	String employee_id;
	String position;
	String startSalary;
	String startYear;
	String endYear;
	String employerID;
	
	String employer_name;
	String employer_location;
	
	Employee(String employee1, String employee2, String employee3, String employee4, String employee5, String employee6, String nameMatch, String locationMatch){
		employee_id = employee1;
		position = employee2;
		startSalary = employee3;
		startYear = employee4;
		endYear = employee5;
		employerID = employee6;
		
		//Employer Name & Location (used for matching)
		employer_name = nameMatch;
		employer_location = locationMatch;
	}
	
	Employee(){
		employee_id = "EmplID";
		position = "Position";
		startSalary = "Starting Salary";
		startYear = "Start Year";
		endYear = "End Year";
		employerID = "EmployerID";
		
		//DEFAULT
		employer_name = "";
		employer_location = "";
	}
	
	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStartSalary() {
		return startSalary;
	}

	public void setStartSalary(String startSalary) {
		this.startSalary = startSalary;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public String getEmployerID() {
		return employerID;
	}

	public void setEmployerID(String employerID) {
		this.employerID = employerID;
	}

	public String getEmployer_name() {
		return employer_name;
	}

	public void setEmployer_name(String employer_name) {
		this.employer_name = employer_name;
	}

	public String getEmployer_location() {
		return employer_location;
	}

	public void setEmployer_location(String employer_location) {
		this.employer_location = employer_location;
	}
	
	@Override
	public String toString() {
		return employee_id+", "+position+", "+startSalary+", "+startYear+", "+endYear+", "+employerID+"\n";
		
	}
}
