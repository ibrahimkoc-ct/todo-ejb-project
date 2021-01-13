package com.ba.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.jasper.tagplugins.jstl.ForEach;

import com.ba.dto.TodoDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class TodoDao {
	private String kullanici_adi = "root";
    private String parola = "12345678";
    private String db_ismi = "todo";
    private String host = "todo";
    private PreparedStatement preparedStatement = null;
    private int port = 3306;
    private Connection con = null;
    private Statement statament = null;
    List<TodoDTO> todoList =new ArrayList<TodoDTO>();

    public TodoDao() {
        String url = "jdbc:mysql://localhost:3306/todo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadý.");

        }
        try {
            con = DriverManager.getConnection(url, kullanici_adi, parola);
            System.out.println("Baðlantý Baþarýlý");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addToDoDb(TodoDTO toDoDTO) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO todo" + "  (id, description) VALUES "
                + " (?, ?)";

        // Step 2:Create a statement using connection object
        try {
            preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1, toDoDTO.getId());
            preparedStatement.setString(2, toDoDTO.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String addTodo(int id ,String description) {
    	TodoDTO dto = new TodoDTO();
    	dto.setId(id);
    	dto.setDescription(description);
    	todoList.add(dto);
    	return "Id: "+id+" Todo: "+description+ " adli Todo eklendi.";
    }
    
    
    public String updateTodo(int id ,String description) {
    	if(id<0) {
    		return null;
    	}
    	for(int i=0; i<todoList.size(); i++) {
    		if(id==todoList.get(i).getId()) {
    			todoList.get(i).setDescription(description);
    			return "Id: "+id+" Todo: "+description+" adli Todo guncellendi.";
    		}
    	}
    	return null;
    }
    
    
    public boolean deleteTodo(int id) {
    	if(id<0) {
    		return false;
    	}
    	for(int i=0; i<todoList.size(); i++) {
    		if(id==todoList.get(i).getId()) {
    			todoList.remove(todoList.get(i));
    			return true;
    		}
    	}
  
    	return false;
    }
    
    
    public List<TodoDTO> ListTodo() {
    	if(todoList.isEmpty()) {
    		return null;
    	}
    	
    	return todoList;
    }
      
}
