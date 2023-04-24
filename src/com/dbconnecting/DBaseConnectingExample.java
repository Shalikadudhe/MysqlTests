package com.dbconnecting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBaseConnectingExample {

	public static void main(String[] args) throws SQLException {

		insertQueryIntoStudentTable();
		updateQueryIntoStudentTable();
		deleteQueryIntoStudentTable();
		selectTableFromStudent();
	}

	public static void selectTableFromStudent() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");	

		Statement stmt=con.createStatement();
		String selectQuery="SELECT Sr_no,Sname,Marks FROM Student";
		ResultSet rs= stmt.executeQuery(selectQuery);

		while(rs.next()) {
			int stuNo= rs.getInt("Sr_no");
			String stuName= rs.getString("Sname");
			int stuMarks= rs.getInt("Marks");

			System.out.println(stuNo+"   "+stuName+"  "+stuMarks);
		}
		System.out.println("*************************************************");
		con.close();
	}

	public static void insertQueryIntoStudentTable() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");	
		Statement stmt=con.createStatement();
		String insertQuery="INSERT INTO Student VALUES(10,'RUBY',146)";
		stmt.execute(insertQuery);
		selectTableFromStudent();
		con.close();
		System.out.println("Insert Query executed...");
        System.out.println("*************************************************");
	}

	public static void deleteQueryIntoStudentTable() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");	
		Statement stmt=con.createStatement();
		String deleteQuery="Delete from Student WHERE Sname='Mow'";
		stmt.execute(deleteQuery);
		selectTableFromStudent();
		con.close();
		System.out.println("Delete Query executed...");
		System.out.println("*************************************************");
	}
	public static void updateQueryIntoStudentTable() throws SQLException {

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");	
		Statement stmt=con.createStatement();
		String updateQuery="UPDATE Student SET Sname='Mow' WHERE Sr_no=10";
		stmt.execute(updateQuery);
		selectTableFromStudent();
		con.close();
		System.out.println("Upadet Query executed...");
		System.out.println("*************************************************");
	}

} 
