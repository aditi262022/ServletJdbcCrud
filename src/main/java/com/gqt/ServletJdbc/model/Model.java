package com.gqt.ServletJdbc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.gqt.ServletJdbc.beans.Employee;

public class Model {

	private Connection con;
	private PreparedStatement pstmt;

	public Model(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/gqtonline";
			String user = "root";
			String pwd="root";
			con = DriverManager.getConnection(url, user, pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public boolean insertData(Employee e) {
		try {
			String sql = "insert into Employee values(?,?,?,?,)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, e.getEmpid());
			pstmt.setString(2, e.getEmpname());
			pstmt.setString(3, e.getEmpcomp());
			pstmt.setInt(4, e.getEmpsal());

			int x = pstmt.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}

		}
		catch(Exception excp) {
			excp.printStackTrace();
		}
		return false;
	}
	public boolean updateData (Employee e) {

		try {

			String sql = "update employee set empname-? where empid=?";
			pstmt = con.prepareStatement (sql); pstmt.setInt(2, e.getEmpid()); pstmt.setString (1, e.getEmpname());
			int x = pstmt.executeUpdate();

			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception excp) { 
			excp.printStackTrace();
		}

			return false;
		}

}