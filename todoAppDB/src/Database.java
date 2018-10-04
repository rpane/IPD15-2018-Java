
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 0639300
 */
public class Database {

    private Connection conn;

    public Database() throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/todoapp";
        conn = DriverManager.getConnection(dbUrl, "root", "root");
    }

    ArrayList<Todo> getAllTodos() throws SQLException {
        ArrayList<Todo> resultList = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM todoapp.todos");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            long id = rs.getLong("id");
            String task = rs.getString("task");
            Date dueDate = rs.getDate("dueDate");
            boolean isDone = rs.getString("isDone").equals("done");
            resultList.add(new Todo(id, task, dueDate, isDone));
        }
        return resultList;
    }

    Todo getTodoById(long id) throws SQLException {
        throw new RuntimeException("UNIMPLEMENTED");

    }

    // returns id of newly created record
    int addTodo(Todo todo) throws SQLException {
        throw new RuntimeException("UNIMPLEMENTED");
    }

    void updateTodo(Todo todo) throws SQLException {
        throw new RuntimeException("UNIMPLEMENTED");
    }

    void deleteTodoById(long id) throws SQLException {
        String sql = "DELETE FROM todoapp.todos WHERE ID = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        // set the corresponding param
        pstmt.setLong(1, id);
        // execute the delete statement
        pstmt.executeUpdate();

    }

}
