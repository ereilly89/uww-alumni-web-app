package tablemaker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class newConvert {
	
	public static void main(String[] args) throws Exception {
		
		//INPUT FILE
		File AlumniDatabaseCSV = new File("AlumniSpreadsheet - Copy.csv");
		Scanner AlumniCSV = new Scanner(AlumniDatabaseCSV);
		
		//OUTPUT FILES
		File AlumniDatabase_ALUMNI = new File("OutputTables\\AlumniDatabase_ALUMNI.csv");
		File AlumniDatabase_DEGREE = new File("OutputTables\\AlumniDatabase_DEGREE.csv");
		File AlumniDatabase_EMPLOYEE = new File("OutputTables\\AlumniDatabase_EMPLOYEE.csv");
		File AlumniDatabase_EMPLOYER = new File("OutputTables\\AlumniDatabase_EMPLOYER.csv");
		File AlumniDatabase_STUDENT = new File("OutputTables\\AlumniDatabase_STUDENT.csv");
		File AlumniDatabase_SCHOOL = new File("OutputTables\\AlumniDatabase_SCHOOL.csv");
		
		//ALUMNI(EmplID, Name, Major, Minor) // ID, First, Last, Email, Phone, LinkedIn, GradStudent, Employed 
		String alumni1="", alumni2="", alumni3="", alumni4="", alumni5="", alumni6="", alumni7="", alumni8="";
		
		//DEGREE(DegrID, Type, Honors, DegrStatus, DegrConf, EmplID) //ID, Type, Major, Honors, Grad_month, alumniID, minor
		String degree1="", degree2="", degree3="", degree4="", degree5="", degree6="", degree7minor="";
		
		//EMPLOYEE(EmplID, Salary, Starting Salary, Time, Position, EmployerID)	nameMatch & locationMatch needed for matching employer id's
		// ID, Position, startSalary, StartYear, endYear, EmployerID
		String employee1="", employee2="", employee3="", employee4="" ,employee5="", employee6="", employerNameMatch="", employerLocationMatch="";
		
		//EMPLOYER(EmployerID, EmployerName, Location, Feedback) // ID, employerName, city, state, feedback
		String employer1="", employer2="", employer3="", employer4="", employer5="";
		
		//STUDENT studentID, schoolID
		String student1="", student2="", schoolNameMatch="";
		
		//SCHOOL schoolID, schoolName
		String school1="", school2="";
		
		//BufferedWriters for writing to the output files
		BufferedWriter AlumniWriter = new BufferedWriter(new FileWriter(AlumniDatabase_ALUMNI));
		BufferedWriter DegreeWriter = new BufferedWriter(new FileWriter(AlumniDatabase_DEGREE));
		BufferedWriter EmployeeWriter = new BufferedWriter(new FileWriter(AlumniDatabase_EMPLOYEE));
		BufferedWriter EmployerWriter = new BufferedWriter(new FileWriter(AlumniDatabase_EMPLOYER));
		BufferedWriter StudentWriter = new BufferedWriter(new FileWriter(AlumniDatabase_STUDENT));
		BufferedWriter SchoolWriter = new BufferedWriter(new FileWriter(AlumniDatabase_SCHOOL));
		
		//Create clean data object
		cleanData c1 = new cleanData();
		
		//Create tuple objects
		Alumni a1;
		Degree d1;
		Employer er1;
		Employee ee1;
		Student st1;
		School sc1;
		
		//Create tables
		ArrayList<Alumni>alumniTable = new ArrayList<Alumni>();
		ArrayList<Degree>degreeTable = new ArrayList<Degree>();
		ArrayList<Employer>employerTable = new ArrayList<Employer>();
		ArrayList<Employee>employeeTable = new ArrayList<Employee>();
		ArrayList<Student>studentTable = new ArrayList<Student>();
		ArrayList<School>schoolTable = new ArrayList<School>();
		
		//Holds the first line of the CSV file (Doesn't have meaning for us)
		//String csvTitle = AlumniCSV.nextLine();
		
		int c=0;//Helps us determine if we are at the first iteration of the program (if so, displays our attribute names later on)
		int degreeIDnum = 0;//helps us order our degree ID's
		int employerIDnum = 1;//helps us order our employer ID's
		int schoolIDnum = 0;//hellps us order our school ID's
		
		String[] attributes;//Holds attributes from the input CSV file
		String attributesString;
		
		while(AlumniCSV.hasNextLine()) {
				System.out.println("BEGINNING OF WHILE LOOP: "+alumni1);
				//********************************************************************************************************//
				//System.out.println("TITLE: "+title);
				attributesString = AlumniCSV.nextLine();
				//System.out.println("FIRST LINE: "+attributesString);
				String commaFix[] = attributesString.split("\"");
				
				for(int i=0;i<commaFix.length;i++) {
					if(i%2==1) {//If Odd
						//Delete the comma within
						String updateCommaField="";
					    String splitComma[] = commaFix[i].split(",");
						for(int k=0;k<splitComma.length;k++) {
							splitComma[k].trim();
							updateCommaField+=splitComma[k]+" ";
						}
						commaFix[i] = updateCommaField;
					}
				}
				
				attributesString = "";
				
				for(int i=0;i<commaFix.length;i++) {
					attributesString +=commaFix[i];
				}
				
				attributes = attributesString.split(",");

				System.out.println("AFTER COMMA FIX: "+alumni1);
				
				//********************************************************************************************************//
				
				//Set the values of the necessary attributes	//ATTRIBUTE KEY
				alumni1 = attributes[0];						//	[0] ---> EmplID
				alumni2 = attributes[1];						//  [1] ---> First Name
				alumni3 = attributes[2];						//  [2] ---> Last Name
				alumni4 = attributes[3];						//  [3] ---> Email
				alumni5 = attributes[4];						//  [4] ---> Phone
				alumni6 = attributes[5];						//  [5] ---> LinkedIn
				alumni7 = attributes[10];						//  [6] ---> Major
				alumni8 = attributes[12];						//  [7] ---> DegreeType
																//  [8] ---> Honors
				degree2 = attributes[7];						//  [9] ---> GradMonth
				degree3 = attributes[6];						//  [10] ---> GraduateStudent
				degree4 = attributes[8];						//  [11] ---> GradSchool
				degree5 = attributes[9];						//  [12] ---> Employed
				degree6 = alumni1;
				degree7minor = attributes[19];
																//  [13] ---> Employer
				employee1 = attributes[0];							//  [14] ---> Position
				employee2 = attributes[14];						//  [15] ---> EmployerCity
				employee3 = attributes[18];						//  [16] ---> EmployerState/Country
																//  [17] ---> Time @ Employer
				employer2 = attributes[13];						//  [18] ---> StartingSalary
				employer3 = attributes[15];
				employer4 = attributes[16];
				employer5 = "NA";
				
				school2 = attributes[11];
				
				student1 = attributes[0];
				
				//Set locationMatch to be the employer's city
				employerLocationMatch = attributes[15]+" "+attributes[16];					
				employerNameMatch = attributes[13];
				schoolNameMatch = attributes[11];
				
				System.out.println("TEST 1: "+alumni1);
				//**********************************************************************************************//
				String timeString;
				timeString = attributes[17];
				
				if(timeString.equals("NA")) {//If a time start doesn't exist
					employee4 = "-1";
					employee5 = "-1";
				}else if(timeString.length()==15) {//if there is a month included within startTime and if the endTime is Present
					
					employee4 = timeString.substring(3,7);
					employee5 = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
					
				}else if(timeString.length()==8) {
				
					employee4 = timeString.substring(0,4);
					employee5 = timeString.substring(5,9);
					
				}else if(timeString.length()==11) {
					
					if(timeString.substring(2,3).equals("/")) {
						employee4 = timeString.substring(3,7);
						employee5 = timeString.substring(8,12);
					}else {
						employee4 = timeString.substring(0,4);
						employee5 = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
					}
				}
				
				//***********************************************************************************************//
				System.out.println("TEST 2: "+alumni1);
				a1 = new Alumni();
				d1 = new Degree();
				ee1 = new Employee();
				er1 = new Employer();
				st1 = new Student();
				sc1 = new School();
				
				++c;
				
				if(c==1) {	//Set the labels of the output csv files
					
					//write to the list
					alumniTable.add(a1);
					degreeTable.add(d1);
					employeeTable.add(ee1);
					employerTable.add(er1);
					studentTable.add(st1);
					schoolTable.add(sc1);
					System.out.println("TEST 3: "+alumni1);
					//add a N/A employer
					er1 = new Employer("1","NA","NA","NA","NA");
					employerTable.add(er1);
					
					//TEST
					
					
					
					//END TEST
					
				}else {		//Output the tuples to the data files
					
					//increment the degreeID
					degree1 = ++degreeIDnum+"";
					
					//Create Tuples
					
					a1 = new Alumni(alumni1,alumni2,alumni3,alumni4,alumni5,alumni6,alumni7,alumni8);
					d1 = new Degree(degree1,degree2,degree3,degree4,degree5,degree6,degree7minor);
					ee1 = new Employee(employee1, employee2, employee3, employee4, employee5, employee6, employerNameMatch, employerLocationMatch);
					st1 = new Student(student1, student2, schoolNameMatch);
					
					
					System.out.println("SHOULD BE GOOD HERE: "+alumni1);
					
					//write to the list
					alumniTable.add(a1);
					degreeTable.add(d1);
					
					if(alumni8.equals("TRUE"))
						employeeTable.add(ee1);
					
					if(alumni7.equals("TRUE"))
						studentTable.add(st1);
					
					//Create Tuples For Employer Table
					boolean inList = false;
					if(employer2.equals("NA")) {
						inList = true;
					}else {
						
						for(int i=0;i<employerTable.size();i++) {
							if(c1.isSimilar(employerTable.get(i).getName(), employer2)&&employerTable.get(i).getCity().equals(employer3)&&employerTable.get(i).getState().equals(employer4)) {//isSimilar to existing
								inList = true;
							}
						}
						
						//If the potential new Employer is not already in the employer table, add to it
						if(inList == false) {
							er1 = new Employer(++employerIDnum+"",employer2,employer3,employer4,employer5);
							employerTable.add(er1);
						}
					}
					
					//Create Tuples For School Table
					inList = false;
					if(school2.equals("NA")||school2.equals("")){
						inList = true;
					}else {
						for(int i=0;i<schoolTable.size();i++) {
							if(c1.isSimilar(schoolTable.get(i).getSchool_name(), school2)) {//isSimilar to existing
								inList = true;
							}
						}
						
						//If the potential new Employer is not already in the employer table, add to it
						if(inList == false) {
							sc1 = new School(++schoolIDnum+"",school2);
							schoolTable.add(sc1);
						}
					}
				}
				
		}
		
		//SYNC EMPLOYER ID'S WITH EMPLOYEE TABLE
		for(int i=1;i<employeeTable.size();i++) {
			for(int j=1;j<employerTable.size();j++) {
				
				if(c1.isSimilar(employeeTable.get(i).getEmployer_name(), employerTable.get(j).getName())&&employeeTable.get(i).getEmployer_location().equals(employerTable.get(j).getLocation())){
					employeeTable.get(i).setEmployerID(employerTable.get(j).getID());
				}
				
				if(employeeTable.get(i).getEmployer_name().equals("NA")) {
					employeeTable.get(i).setEmployerID(employerTable.get(1).getID());//SETS ID to NA
				}
			}
		}
		
		//SYNC SCHOOL ID's WITH STUDENT TABLE
		for(int i=1;i<studentTable.size();i++) {
			for(int j=1;j<schoolTable.size();j++) {
				if(c1.isSimilar(studentTable.get(i).getSchool_name(), schoolTable.get(j).getSchool_name())){
					studentTable.get(i).setSchoolID(schoolTable.get(j).getSchool_id());
				}
			}
		}
		
		//PRINT ALL DATA TO TABLES
		printToFile(AlumniWriter,alumniTable,DegreeWriter,degreeTable,EmployeeWriter,employeeTable,EmployerWriter,employerTable,StudentWriter,studentTable,SchoolWriter,schoolTable);
		
		//Save the Outputted Tables
		AlumniWriter.close();
		DegreeWriter.close();
		EmployeeWriter.close();
		EmployerWriter.close();
		StudentWriter.close();
		SchoolWriter.close();
		
	}
	
	public static void printToAlumni(BufferedWriter a, Alumni a1) throws IOException {
		a.write(a1.toString());
	}
	
	public static void printToDegree(BufferedWriter d, Degree d1) throws IOException {
		d.write(d1.toString());
	}

	public static void printToEmployee(BufferedWriter ee, Employee ee1) throws IOException {
		ee.write(ee1.toString());
	}

	public static void printToEmployer(BufferedWriter er, Employer er1) throws IOException {
		er.write(er1.toString());
	}
	
	public static void printToStudent(BufferedWriter st, Student st1) throws IOException {
		st.write(st1.toString());
	}
	
	public static void printToSchool(BufferedWriter sc, School sc1) throws IOException {
		sc.write(sc1.toString());
	}
	
	public static void printToFile(BufferedWriter AlumniWriter,ArrayList<Alumni>alumniTable
			,BufferedWriter DegreeWriter, ArrayList<Degree> degreeTable
			,BufferedWriter EmployeeWriter, ArrayList<Employee> employeeTable
			, BufferedWriter EmployerWriter, ArrayList<Employer> employerTable
			, BufferedWriter StudentWriter, ArrayList<Student> studentTable
			, BufferedWriter SchoolWriter, ArrayList<School> schoolTable) throws IOException {
		
		//PRINT TO ALUMNI TABLE
		for(int i=0;i<alumniTable.size();i++) {
			printToAlumni(AlumniWriter, alumniTable.get(i));
		}
		
		//PRINT TO DEGREE TABLE
		for(int i=0;i<degreeTable.size();i++) {
			printToDegree(DegreeWriter, degreeTable.get(i));
		}
		
		//PRINT TO EMPLOYEE TABLE
		for(int i=0;i<employeeTable.size();i++) {
			printToEmployee(EmployeeWriter, employeeTable.get(i));
		}
		
		//PRINT TO EMPLOYER TABLE
		for(int i=0;i<employerTable.size();i++) {
			printToEmployer(EmployerWriter, employerTable.get(i));
		}
		
		//PRINT TO STUDENT TABLE
		
		for(int i=0;i<studentTable.size();i++) {
			printToStudent(StudentWriter, studentTable.get(i));
		}
		
		//PRINT TO SCHOOL TABLE
		
		for(int i=0;i<schoolTable.size();i++) {
			printToSchool(SchoolWriter, schoolTable.get(i));
		}

	}
}