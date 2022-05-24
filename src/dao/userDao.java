/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import po.MyUserTable;
import model.*;
import util.JDBC;


public class userDao {
    private MyUserTable MyUserTable;
    
    public userDao()
    {
        this.MyUserTable  = new MyUserTable();
    }
    
    public boolean hasUser(String name, String pwd)
    {
        return MyUserTable.getUserTable().stream().anyMatch(p -> (p.login(name, pwd)));
    }
    
    public MyUser getUser(String name, String pwd)
    {
        for (MyUser u : MyUserTable.getUserTable()) {
            if (u.login(name, pwd)) {
                return u;
            }
        }
        return null;
    }
    
    public boolean addUser(int id, String name, String pwd)
    {
        MyUser u = new MyUser(id,name,pwd);
        boolean has = MyUserTable.getUserTable().stream().anyMatch(p -> (p.login(name, pwd)));
        if (!has) {
            try {
                    Connection conn = null;
                    Statement state = null;
                    conn = JDBC.getConnection();
                    state = conn.createStatement();    
                    String sql = "insert into user (id, uname, upwd) values("+id+",'"+name+"','"+pwd+"')";
                    state.executeUpdate(sql);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return !has;
    }
}
