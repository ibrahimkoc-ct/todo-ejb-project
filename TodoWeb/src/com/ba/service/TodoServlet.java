package com.ba.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ba.dao.TodoDao;
import com.ba.dto.TodoDTO;
@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int maxId=1;
	
	@EJB
	TodoDao dao;
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		dao.deleteTodo(Integer.parseInt(id));
		PrintWriter outPrintWriter =resp.getWriter();
		outPrintWriter.print(true);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String description=req.getParameter("description");
		PrintWriter outPrintWriter =resp.getWriter();
		dao.addTodo(maxId, description);
		maxId++;
		resp.sendRedirect("todo");
		
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String description=req.getParameter("description");
		PrintWriter outPrintWriter =resp.getWriter();
		outPrintWriter.print(dao.updateTodo(Integer.parseInt(id), description));
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		out.println(
			 "<html>\r\n"
				+ "<head>\r\n"
		
				+ "<title>Todo</title>\r\n"
				+ "<link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n"
				+ "	crossorigin=\"anonymous\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<header>\r\n"
				+ "		<nav class=\"navbar navbar-expand-md navbar-dark\"\r\n"
				+ "			style=\"background-color: #335588\">\r\n"
				+ "			<div>\r\n"
				+ "				<a href=\"/TodoWeb/index.jsp\" class=\"navbar-brand\">\r\n"
				+ "					<h2 style=\"color: white\">Todo App</h2>\r\n"
				+ "				</a>\r\n"
				+ "			</div>\r\n"
				+ "		</nav>\r\n"
				+ "	</header>\r\n"
				+ "	<div class=\"row\">\r\n"
				+ "		<div class=\"container\">\r\n"
				+ "			<h3 class=\"text-center\">List of Todos</h3>\r\n"
				+ "			<hr>\r\n"
				+ "			<div class=\"container text-left\">\r\n"
				+ "\r\n"
				+ "				<a href=\"/TodoWeb/add.jsp\" class=\"btn btn-success\">Add Todo</a>\r\n"
				+ "			</div>\r\n"
				+ "			<br>");
      
		
		out.print("<table class=\"table table-bordered\">\r\n"
				+ "				<thead>\r\n"
				+ "					<tr>\r\n"
				+ "						<th>Index</th>\r\n"
				+ "						<th>Todo</th>\r\n"
				+ "						<th>Actions</th>\r\n"
				+ "					</tr>\r\n"
				+ "				</thead>");
		out.print("<tbody>");

        for(int i=0;i<dao.ListTodo().size();i++) {
             out.println("<tr>");

             out.println("<td>"+dao.ListTodo().get(i).getId()+"</td>");
             out.println("<td>"+dao.ListTodo().get(i).getDescription()+"</td>");
             out.println("<td><button (click)=\"updateTodo(todo.id)\" class=\"btn btn-success\">Update</button>\r\n"
             		+ "          							<button (click)=\"deleteTodo(todo.id)\" class=\"btn btn-warning\">Delete</button></td>");
                        out.println("</tr>");
        }
        out.print("</tbody>");

     
        out.println("	</div>\r\n"
        		+ "	</div>\r\n"
        		+ "</body>\r\n"
        		+ "</html>");
    }
		
}
