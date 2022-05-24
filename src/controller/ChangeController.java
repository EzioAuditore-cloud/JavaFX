/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import cardsysapp.Controller;
import cardsysapp.ViewLoader;
import dao.cardDao;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Card;
import model.MyUser;
import util.JDBC;


public class ChangeController extends Controller<Card> implements Initializable {
    
    @FXML
    private Button changeBtn;
    
    @FXML
    private Button backBtn;

    @FXML
    private TextField telTxt;

    @FXML
    private TextField compTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField postTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        nameTxt.setText(model.getName());
        telTxt.setText(model.getTel());
        emailTxt.setText(model.getEmail());
        compTxt.setText(model.getComp());
        postTxt.setText(model.getPost());
        if(model.getName().equals(""))
            changeBtn.setDisable(true);
        nameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {  
                if (newValue.isEmpty()) {
                    changeBtn.setDisable(true);
                }
                else
                {
                    telTxt.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue1, String newValue1) {  
                            if (newValue1.isEmpty()) {
                                changeBtn.setDisable(true);
                            }
                            else
                                changeBtn.setDisable(false);
                        }       
                    });
                }
            }       
        });
        
    }    
    
    @FXML
    void handleChange(ActionEvent event) throws IOException {
        
        String getCount = "select * from card";
        int c=0;
        try {
		Connection conn = null;
		Statement state = null;
	        ResultSet rs = null;
                conn = JDBC.getConnection();
                state = conn.createStatement(); 
                rs = state.executeQuery(getCount);
                while (rs.next()) {
                    c++;
                }
        }catch(Exception e) {
                e.printStackTrace();
        }
        String sql1 = "SELECT * FROM card where name='"+nameTxt.getText()+"'";
        String sql = "insert into card (id,name,telephone,email,company,post) values ("+String.valueOf(c+1)+",'"+nameTxt.getText()+"','"+telTxt.getText()+"','"+emailTxt.getText()+"','"+compTxt.getText()+"','"+postTxt.getText()+"')";
        String sql2 = "update card set name='"+nameTxt.getText()+"', telephone='"+telTxt.getText()+"', email='"+emailTxt.getText()+"', company='"+compTxt.getText()+"', post='"+postTxt.getText()+"' where name='"+nameTxt.getText()+"'";
        try {
		Connection conn = null;
		Statement state = null;
	        ResultSet rs = null;
                conn = JDBC.getConnection();
                state = conn.createStatement(); 
                rs = state.executeQuery(sql1);
                boolean isempty = rs.next();
                if (!isempty) {
                    state.executeUpdate(sql);
                }
                else{
                    state.executeUpdate(sql2);
                }
        }catch(Exception e) {
                e.printStackTrace();
        }
        ViewLoader.showStage(new cardDao(), "/view/Card.fxml", "", stage);
    }
    
    @FXML
    void handleBack(ActionEvent event) throws IOException {
        ViewLoader.showStage(new cardDao(), "/view/Card.fxml", "", stage);
    }
}
