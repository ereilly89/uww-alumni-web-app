package tablemaker;

public class Degree {
	
	String degree_id;
	String type;
	String major;
	String minor;
	String honors;
	String gradMonth;
	String alumniID;
	
	Degree(String degree1, String degree2, String degree3, String degree4, String degree5, String degree6, String degree7minor){
		degree_id = degree1;
		type = degree2;
		major = degree3;
		honors = degree4;
		gradMonth = degree5;
		alumniID = degree6;
		minor = degree7minor;
	}
	
	Degree(){
		degree_id = "DegreeID";
		type = "Type";
		major = "Major";
		honors = "Honors";
		gradMonth = "Graduation";
		alumniID = "AlumniID";
		minor = "Minor";
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getDegree_id() {
		return degree_id;
	}

	public void setDegree_id(String degree_id) {
		this.degree_id = degree_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getHonors() {
		return honors;
	}

	public void setHonors(String honors) {
		this.honors = honors;
	}

	public String getGradMonth() {
		return gradMonth;
	}

	public void setGradMonth(String gradMonth) {
		this.gradMonth = gradMonth;
	}

	public String getAlumniID() {
		return alumniID;
	}

	public void setAlumniID(String alumniID) {
		this.alumniID = alumniID;
	}

	@Override
	public String toString() {
		return degree_id+", "+type+", "+major+", "+minor+", "+honors+", "+gradMonth+", "+alumniID+"\n";
	}
}
