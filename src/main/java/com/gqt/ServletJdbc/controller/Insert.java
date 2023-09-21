package com.gqt.ServletJdbc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gqt.ServletJdbc.beans.Employee;
import com.gqt.ServletJdbc.model.Model;

public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		int empsal = Integer.parseInt(request.getParameter("empsal"));
		String empname = request.getParameter("empname");
		String empcomp = request.getParameter("empcomp");

		Employee e = new Employee();
		e.setEmpid(empid);
		e.setEmpname(empname);
		e.setEmpcomp(empcomp);
		e.setEmpsal(empsal);

		Model m = new Model();
		boolean b = m.insertData(e);
		if(b==true) {
			response.sendRedirect("/ServletJdbcCrud/InsertSuccess.html");
		}
		else {

			response.sendRedirect("/ServletJdbcCrud/InsertFail.html");
		}
	}

}
