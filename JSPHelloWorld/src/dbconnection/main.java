package dbconnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.CallableStatement;

/**
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String databasePrefix = "cs_alumni"; // name of database
	static final String netID = "csmember"; // username/netID
	static final String hostName = "washington.uww.edu"; // ex) washington.uww.edu, localhost, localhost:3306
	static final String databaseURL = "jdbc:mysql://" + hostName + "/" + databasePrefix+ "?autoReconnect=true&useSSL=false&useInformationSchema=true"; //noAccessToProcedureBodies=true";
	static final String password = "alumni2019"; // password
	private static Connection connection = null;
	
	//Connection to Database
	public void Connection(){

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("databaseURL"+ databaseURL);
			connection = DriverManager.getConnection(databaseURL, netID, password);
			System.out.println("Successfully connected to the database.");
			
			//Call some test stored procedures now that the database has connected.************//
			
			//Employer
			/*
			
			System.out.println("****getEmployersAll()*************************************************************");
			getEmployersAll();
			
			int year=2018;
			System.out.println("****getEmployersHiring("+year+")**************************************************");
			getEmployersHiring(year);
			
			System.out.println("****getTop10EmployersCount()******************************************************");
			getTop10EmployersCount();
			
			System.out.println("****getTop10EmployersPercentage()*************************************************");
			//getTop10EmployersPercentage();
			System.out.println("(NOT WORKING");
			
			System.out.println("****getEmployersWisconsin()*******************************************************");
			getEmployersWisconsin();
			
			System.out.println("****getEmployersOutOfState()******************************************************");
			getEmployersOutOfState();
			
			System.out.println("****getTopGradSchools()***********************************************************");
			getTopGradSchools();
			
			
			//Alumni
			System.out.println("****getAlumniAll()****************************************************************");
			getAlumniAll();
			
			System.out.println("****getAlumniHonors()*************************************************************");
			getAlumniHonors();
			
			
			//Employee
			System.out.println("****getEmployeesAll()*************************************************************");
			getEmployeesAll();
			
			System.out.println("****getEmployeeLeaders()**********************************************************");
			getEmployeeLeaders();
			
			 */
			//Degree
			
			
			//End of stored procedure tests******************************************************//
			
		}
		
		catch (ClassNotFoundException e) {
			System.out.println("Connection Failed.  Class not found.");
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			System.out.println("Connection Failed.  SQL Exception.");
			e.printStackTrace();
		}
		
	} // end of Connection
	
	//********************************************Methods for sending to JavaScript*****************************************************************************************//
	
	public ArrayList<String> getEmployersAll_JS() throws SQLException{
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getEmployersAll()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();
		
		int numGraduates;
		String employerName;
		String city;
		String state;
		String concatData;
		
		ArrayList<String> theData = new ArrayList<String>();
		theData.add("Graduates,Employer,City,State");
		
		int count=0;
		while(rs.next()) {
			numGraduates = rs.getInt(1);
			employerName = rs.getString(2);
			city = rs.getString(3);
			state = rs.getString(4);
			concatData = numGraduates+","+employerName+","+city+","+state;
			theData.add(concatData);
			System.out.println(theData.get(count++));
		}
		
		return theData;
	}
	
	public ArrayList<String> getAlumniAll_JS() throws SQLException{
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getAlumniAll()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();
		
		String name;
		String type;
		String DegrConfDate;
		String honors;
		String concatData;
		
		ArrayList<String> theData = new ArrayList<String>();
		theData.add("Full Name,Degree Type,Graduation Date,Honors");
		
		while(rs.next()) {
			name = rs.getString(1);
			type = rs.getString(2);
			DegrConfDate = rs.getString(3);
			honors = rs.getString(4);
			concatData = name+","+type+","+DegrConfDate+","+honors;
			theData.add(concatData);
		}
		
		return theData;
	}
	
	
	public ArrayList<String> getTopTenEmployers_JS() throws SQLException{
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getTop10EmployersCount()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();
		
		int numGraduates;
		String employerName;
		String city;
		String state;
		String concatData;
		
		ArrayList<String> theData = new ArrayList<String>();
		
		while(rs.next()) {
			numGraduates = rs.getInt(1);
			employerName = rs.getString(2);
			city = rs.getString(3);
			state = rs.getString(4);
			concatData = numGraduates+","+employerName+","+city+","+state;
			theData.add(concatData);
		}
		
		return theData;
	}
	
	public ArrayList<String> getEmployersWisconsin_JS() throws SQLException{
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getEmployersWisconsin()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();
		
		String name;
		String position;
		String employerName;
		String city;
		String state;
		String concatData;
		
		ArrayList<String> theData = new ArrayList<String>();
		
		while(rs.next()) {
			name = rs.getString(1);
			position = rs.getString(2);
			employerName = rs.getString(3);
			city = rs.getString(4);
			state = rs.getString(5);
			concatData = name+","+position+","+employerName+","+city+","+"state"+","+state+",";
			theData.add(concatData);
		}
		
		return theData;
	}
	
	public ArrayList<String> getEmployersOutOfState_JS() throws SQLException{
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getEmployersOutOfState()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();

		String name;
		String position;
		String employerName;
		String city;
		String state;
		String concatData;
		
		ArrayList<String> theData = new ArrayList<String>();
		
		while(rs.next()) {
			name = rs.getString(1);
			position = rs.getString(2);
			employerName = rs.getString(3);
			city = rs.getString(4);
			state = rs.getString(5);
			concatData = name+","+position+","+employerName+","+city+","+state;
			theData.add(concatData);
		}
		
		return theData;
	}
	
	public ArrayList<String> getEmployeesAll_JS() throws SQLException{
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getEmployeesAll()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();
		
		String name;
		String position;
		String employerName;
		String city;
		String state;
		int startYear;
		int endYear;
		String concatData;
		
		ArrayList<String> theData = new ArrayList<String>();
		
		while(rs.next()) {
			name = rs.getString(1);
			position = rs.getString(2);
			employerName = rs.getString(3);
			city = rs.getString(4);
			state = rs.getString(5);
			startYear = rs.getInt(6);
			endYear = rs.getInt(6);
			concatData = name+","+position+","+employerName+","+city+","+state+","+startYear+","+endYear;
			theData.add(concatData);
		}
		
		return theData;
	}
	
	public ArrayList<String> getAlumniDescription_JS() throws SQLException{
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getAlumniDescription()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();
		
		String name;
		String position;
		String employerName;
		String city;
		String state;
		int startYear;
		int endYear;
		String type;
		String honors;
		String DegrConfDate;
		String concatData;
		
		ArrayList<String> theData = new ArrayList<String>();
		
		theData.add("Name,Position,Employer, City, State, Start Year, End Year, Degree Type, Honors, Graduation");
		
		while(rs.next()) {
			name = rs.getString(1);
			position = rs.getString(2);
			employerName = rs.getString(3);
			city = rs.getString(4);
			state = rs.getString(5);
			startYear = rs.getInt(6);
			endYear = rs.getInt(7);
			type = rs.getString(8);
			honors = rs.getString(9);
			DegrConfDate = rs.getString(10);
			concatData = name+","+position+","+employerName+","+city+","+state+","+startYear+","+endYear+","+type+","+honors+","+DegrConfDate;
			theData.add(concatData);
		}
		
		return theData;
	}
	
	
	//********************************************STORED**PROCEDURES*********************************************************************************************************//
	
	
	
	//----Employer-----------------------------------//*******************************************************************
	//Implemented Methods----//
	
	public ResultSet getEmployersAll() throws SQLException { //RETURNS--> #Graduates	EmployerName	City	State
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getEmployersAll()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();
		
		int numGraduates;
		String employerName;
		String city;
		String state;
		
		System.out.println("#Graduates\tEmployerName\tCity\tState");
		while(rs.next()) {
			numGraduates = rs.getInt(1);
			employerName = rs.getString(2);
			city = rs.getString(3);
			state = rs.getString(4);
			
			System.out.println(numGraduates+"\t"+employerName+"\t"+city+"\t"+state);
		}
		
		return rs;
	}
	
	public ResultSet getEmployersHiring(int year) throws SQLException { //RETURNS-->  EmployerName	#GraduatesHired
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getEmployersHiring(?)}");
		myCallStmt.setInt(1, year);
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();
		
		String employerName;
		int graduatesHired;
		
		System.out.println("EmployerName\t#GraduatesHired");
		while(rs.next()) {
			employerName = rs.getString(1);
			graduatesHired = rs.getInt(2);
			
			System.out.println(employerName+"\t"+graduatesHired);
		}
		
		return rs;
	}
	
	public ResultSet getTop10EmployersCount() throws SQLException { //RETURNS--> #Graduates	EmployerName	City	State
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getTop10EmployersCount()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();
		
		int numGraduates;
		String employerName;
		String city;
		String state;
		
		System.out.println("#Graduates\tEmployerName\tCity\tState");
		while(rs.next()) {
			numGraduates = rs.getInt(1);
			employerName = rs.getString(2);
			city = rs.getString(3);
			state = rs.getString(4);
			
			System.out.println(numGraduates+"\t"+employerName+"\t"+city+"\t"+state);
		}
		
		return rs;
	}
	
	//**NEEDS WORK/*
	/*
	public ResultSet getTop10EmployersPercentage() throws SQLException { //RETURNS--> %Graduates	EmployerName	City	State
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getTop10EmployersPercentage()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();
		
		double pctGraduates;
		String employerName;
		String city;
		String state;
		
		System.out.println("%Graduates\temployerName\tCity\tState");
		while(rs.next()) {
			pctGraduates = rs.getDouble(1);
			employerName = rs.getString(2);
			city = rs.getString(3);
			state = rs.getString(4);
			
			System.out.println(pctGraduates+"\t"+employerName+"\t"+city+"\t"+state);
		}
		
		return rs;
	}
	*/
	
	public ResultSet getEmployersWisconsin() throws SQLException { //RETURNS--> Name	Position	EmployerName	City	State
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getEmployersWisconsin()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();
		
		String name;
		String position;
		String employerName;
		String city;
		String state;
		
		System.out.println("Name\tPosition\tEmployerName\tCity\tState");
		while(rs.next()) {
			name = rs.getString(1);
			position = rs.getString(2);
			employerName = rs.getString(3);
			city = rs.getString(4);
			state = rs.getString(5);
			
			System.out.println(name+"\t"+position+"\t"+employerName+"\t"+city+"\t"+state);
		}
		
		return rs;
	}
	
	public ResultSet getEmployersOutOfState() throws SQLException { //RETURNS--> Name	Position	EmployerName	City	State
		
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getEmployersOutOfState()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();

		String name;
		String position;
		String employerName;
		String city;
		String state;
		
		System.out.println("Name\tPosition\tEmployerName\tCity\tState");
		while(rs.next()) {
			name = rs.getString(1);
			position = rs.getString(2);
			employerName = rs.getString(3);
			city = rs.getString(4);
			state = rs.getString(5);
			
			System.out.println(name+"\t"+position+"\t"+employerName+"\t"+city+"\t"+state);
		}
		
		return rs;
	}
	
	public ResultSet getTopGradSchools() throws SQLException { //RETURNS--> #Graduates		EmployerName	City
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getTopGradSchools()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();

		int numGraduates;
		String employerName;
		String city;
		
		System.out.println("#Graduates\tEmployerName\tCity");
		while(rs.next()) {
			numGraduates = rs.getInt(1);
			employerName = rs.getString(2);
			city = rs.getString(3);
			
			System.out.println(numGraduates+"\t"+employerName+"\t"+city);
		}
		
		return rs;
	}
	
	//----To Do's (not yet implemented as a MySQL stored procedure)---//
	//----Feel free to add new query ideas to this list
	
	//End of Employer To Do's
	
	
	//----Alumni-------------------------------------//*******************************************************************
	//Implemented Methods----//
	
	public ResultSet getAlumniAll() throws SQLException { //RETURNS--> Name		Type	DegrConfDate	Honors
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getAlumniAll()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();

		String name;
		String type;
		String DegrConfDate;
		String honors;
		
		System.out.println("Name\tType\tDegrConfDate\tHonors");
		while(rs.next()) {
			name = rs.getString(1);
			type = rs.getString(2);
			DegrConfDate = rs.getString(3);
			honors = rs.getString(4);
			
			System.out.println(name+"\t"+type+"\t"+DegrConfDate+"\t"+honors);
		}
		
		return rs;
	}
	
	public ResultSet getAlumniHonors() throws SQLException { //RETURNS--> Name	Honors
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getAlumniHonors()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();

		String name;
		String honors;
		
		System.out.println("Name\tHonors");
		while(rs.next()) {
			name = rs.getString(1);
			honors = rs.getString(2);
			
			System.out.println(name+"\t"+honors);
		}
		
		return rs;
	}
	
	//----To Do's (not yet implemented as a MySQL stored procedure)---//
	//----Feel free to add new query ideas to this list
	public void getAlumniSumma() throws SQLException {
		
	}
	
	public void getAlumniMagna() throws SQLException {
		
	}
	
	public void getAlumniCuml() throws SQLException {
		
	}
	//End of Alumni To Do's
	
	
	//----Employee-----------------------------------//*******************************************************************
	//Implemented Methods----//
	
	public ResultSet getEmployeesAll() throws SQLException { //RETURNS--> Name	Position	EmployerName	City	State	StartYear	EndYear
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getEmployeesAll()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();
		
		String name;
		String position;
		String employerName;
		String city;
		String state;
		String startYear;
		String endYear;
		
		System.out.println("Name\tPosition\tEmployerName\tCity\tState\tStartYear\tEndYear");
		while(rs.next()) {
			name = rs.getString(1);
			position = rs.getString(2);
			employerName = rs.getString(3);
			city = rs.getString(4);
			state = rs.getString(5);
			startYear = rs.getString(6);
			endYear = rs.getString(6);
			
			System.out.println(name+"\t"+position+"\t"+employerName+"\t"+city+"\t"+state+"\t"+startYear+"\t"+endYear);
		}
		
		return rs;
	}
	
	public ResultSet getEmployeeLeaders() throws SQLException {
		CallableStatement myCallStmt = (CallableStatement) connection.prepareCall("{call getEmployeeLeaders()}");
		myCallStmt.execute();
		ResultSet rs = myCallStmt.getResultSet();

		String name;
		String position;
		String employerName;
		String honors;
		
		System.out.println("Name\tPosition\tEmployerName\tHonors");
		while(rs.next()) {
			name = rs.getString(1);
			position = rs.getString(2);
			employerName = rs.getString(3);
			honors = rs.getString(4);
			
			System.out.println(name+"\t"+position+"\t"+employerName+"\t"+honors);
		}
		
		return rs;
	}
	
	//----To Do's (not yet implemented as a MySQL stored procedure)---//
	//----Feel free to add new query ideas to this list
	
	//End of Employee To Do's
	
	
	//----degree-------------------------------------//*******************************************************************
	//Implemented Methods----//
	
	
	
	//----To Do's (not yet implemented as a MySQL stored procedure)---//
	//----Feel free to add new query ideas to this list
	
	public void getNumSumma(int year) throws SQLException {
		
	}
	
	public void getNumMagna(int year) throws SQLException {
		
	}
	
	public void getNumCuml(int year) throws SQLException {
		
	}
	
	public void getNumHonors(int year) throws SQLException {
		
	}
	//End of Degree To Do's
	//********************************************END**OF**STORED**PROCEDURES*************************************************************************************************//
	
	public ArrayList<String> formatList(ArrayList<String> theList, int width) {
		String[] lineToPrint;
		ArrayList<String> newList = new ArrayList<String>();
		
		newList.add("<table id=\"customers\" align=\"center\" style=\"width:"+width+"%\">");
		
		for(int i=0;i<theList.size();i++) {
			newList.add("<tr>");
			
			if(i==0) {
				lineToPrint = theList.get(i).split(",");
				for(int j=0;j<lineToPrint.length;j++) {
					newList.add("<th>"+lineToPrint[j]+"</th>");
				}
			}else {
				lineToPrint = theList.get(i).split(",");
				for(int j=0;j<lineToPrint.length;j++) {
					newList.add("<td>"+lineToPrint[j]+"</td>");
				}
			}
			newList.add("</tr>");
		}
		newList.add("</table>");
		return newList;
	}
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
