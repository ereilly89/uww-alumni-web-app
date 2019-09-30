package tablemaker;

public class Alumni {
	
	String employee_id;
	String first;
	String last;
	String email;
	String phone;
	String linkedIn;
	String gradStudent;
	String employed;
	
	Alumni(String alumni1, String alumni2, String alumni3, String alumni4, String alumni5, String alumni6, String alumni7, String alumni8){
		employee_id = alumni1;
		first = alumni2;
		last = alumni3;
		email = alumni4;
		phone = alumni5;
		linkedIn = alumni6;
		gradStudent = alumni7;
		employed = alumni8;
	}
	
	Alumni(){
		employee_id = "AlumniID";
		first = "First Name";
		last = "Last Name";
		email = "Email";
		phone = "Phone";
		linkedIn = "LinkedIn";
		gradStudent = "GradStudent";
		employed = "Employed";
	}
	
	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getGradStudent() {
		return gradStudent;
	}

	public void setGradStudent(String gradStudent) {
		this.gradStudent = gradStudent;
	}

	public String getEmployed() {
		return employed;
	}

	public void setEmployed(String employed) {
		this.employed = employed;
	}

	public String getID() {
		return employee_id;
	}
	
	@Override 
	public String toString() {
		return employee_id+", "+first+", "+last+", "+email+","+phone+","+linkedIn+","+gradStudent+","+employed+"\n";
	}
}
