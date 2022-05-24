/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package po;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.MyUser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.JDBC;

public class MyUserTable {
    private final ObservableList<MyUser> users;
    
    public ObservableList<MyUser> getUserTable()
    {
        return this.users;
    }
    
    
    public MyUserTable() {
        users = FXCollections.observableArrayList();
        try {
                    Connection conn = null;
                    Statement state = null;
                    ResultSet rs = null;
                    conn = JDBC.getConnection();
                    state = conn.createStatement();    
                    String sql = "select * from user";
                    rs = state.executeQuery(sql);
                    while (rs.next()) {                
                        users.add(new MyUser(rs.getInt("id"),rs.getString("uname"),rs.getString("upwd")));
                }
            }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
}
