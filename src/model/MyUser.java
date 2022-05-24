/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class MyUser {
    private int id;
    private String uname;
    private String upwd;
    
    public MyUser(int id, String uname, String upwd)
    {
        this.id = id;
        this.uname = uname;
        this.upwd = upwd;
    }
    
    public MyUser()
    {
    }
    
    public void setid(int id)
    {
        this.id = id;
    }
    
    public int getid()
    {
        return id;
    }
    
    public void setname(String name)
    {
        this.uname = name;
    }
    
    public String getname()
    {
        return uname;
    }
    
    public void setnpwd(String pwd)
    {
        this.upwd = pwd;
    }
    
    public String getpwd()
    {
        return upwd;
    }
    
    public boolean login(String uname, String upwd)
    {
        return this.getname().equals(uname) && this.getpwd().equals(upwd);
    }
}
