/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Card {
    
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty tel;
    private SimpleStringProperty email;
    private SimpleStringProperty company;
    private SimpleStringProperty post;
    
    
    public Card(int id, String n, String t, String e, String c, String p){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(n);
        this.tel = new SimpleStringProperty(t);
        this.email = new SimpleStringProperty(e);
        this.company = new SimpleStringProperty(c);
        this.post = new SimpleStringProperty(p);
    }
    
    public Card(int id, String n, String t){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(n);
        this.tel = new SimpleStringProperty(t);
        this.email = new SimpleStringProperty();
        this.company = new SimpleStringProperty();
        this.post = new SimpleStringProperty();
    }
    
    public Card(){
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty("");
        this.tel = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.company = new SimpleStringProperty();
        this.post = new SimpleStringProperty();
    }
      
    public String getName() {
	return this.name.get();
    }
    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }
    
    public String getTel() {
	return this.tel.get();
    }
    public void setTel(String t) {
            this.tel = new SimpleStringProperty(t);
    }
    
    public String getEmail() {
	return this.email.get();
    }
    public void setEmail(String t) {
            this.email = new SimpleStringProperty(t);
    }
    
    public String getComp() {
	return this.company.get();
    }
    public void setComp(String t) {
            this.company = new SimpleStringProperty(t);
    }
    
    public String getPost() {
	return this.post.get();
    }
    public void setPost(String t) {
        this.post = new SimpleStringProperty(t);
    }
    
    public int getId() {
        return this.id.get();
    }
    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }
}
