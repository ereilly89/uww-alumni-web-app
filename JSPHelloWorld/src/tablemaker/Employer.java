package tablemaker;

public class Employer {
	
	String employer_id;
	String employer_name;
	String city;
	String state;
	String feedback;
	
	//CONSTRUCTOR
	Employer(String employer1, String employer2, String employer3, String employer4, String employer5){
		employer_id = employer1;
		employer_name = employer2;
		city = employer3;
		state = employer4;
		feedback = employer5;
	}
	
	Employer(){
		employer_id = "EmployerID";
		employer_name = "Employer";
		city = "City";
		state = "State";
		feedback = "Feedback";
	}
	
	//SETS
	public void setID(String employer_id) {
		this.employer_id = employer_id;
	}
	
	public void setName(String employer_name) {
		this.employer_name = employer_name;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	//GETS
	public String getID() {
		return employer_id;
	}
	
	public String getName() {
		return employer_name;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getFeedback() {
		return feedback;
	}
	
	public String getLocation() {
		return city+" "+state;
	}
	
	@Override
	public String toString() {
		return employer_id+", "+employer_name+", "+city+", "+state+", "+feedback+"\n";
	}
}
