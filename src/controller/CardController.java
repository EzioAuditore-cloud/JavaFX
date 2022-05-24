/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import cardsysapp.*;
import po.CardTable;
import model.*;
import dao.cardDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.JDBC;

public class CardController extends Controller<cardDao> implements Initializable {
    
    @FXML
    private Button ChangeBtn;
    
    @FXML
    private Button CloseBtn;
    
    @FXML
    private Button showBtn;

    @FXML
    private TableView<Card> cardView;
    
    @FXML
    private TableColumn<Card, Integer> idCol;

    @FXML
    private TableColumn<Card, String> compCol;

    @FXML
    private TableColumn<Card, String> emCol;

    @FXML
    private TableColumn<Card, String> postCol;

    @FXML
    private TableColumn<Card, String> telCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private Button selectBtn;
    
    @FXML
    private Button removeBtn;

    @FXML
    private TableColumn<Card, String> nameCol;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Card> cards = model.getCardTable().getCardList();
        System.out.println(cards.get(0).getComp());
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        telCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
        cardView.setItems(cards);
    }   

    @FXML
    void handleSelect(ActionEvent event) {
        String sql1 = "SELECT id, name, telephone FROM card";
        String sql = "SELECT id, name, telephone FROM card where name='"+nameTxt.getText()+"'";
	ObservableList<Card> data = FXCollections.observableArrayList();
	try {
		Connection conn = null;
		Statement state = null;
	        ResultSet rs = null;
                conn = JDBC.getConnection();
                state = conn.createStatement(); 
                if (nameTxt.getText().isEmpty()) {
                    rs = state.executeQuery(sql1);
                } 
		else
                    rs = state.executeQuery(sql);
		while(rs.next()) {
                    Card m = new Card(rs.getInt("id"),rs.getString("name"),rs.getString("telephone"));
                    data.add(m);    
		}
        }catch(Exception e) {
                e.printStackTrace();
        }
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        telCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
        cardView.setItems(data);
    }
    
    @FXML
    void handleChange(ActionEvent event) throws IOException {
        ViewLoader.showStage(new Card(), "/view/Change.fxml", "", stage);
    }
    
    @FXML
    void handleClose(ActionEvent event) {
        this.stage.close();
    }
    
    @FXML
    void handleRemove(ActionEvent event) {
        Card selectCard = cardView.getSelectionModel().getSelectedItem();
        String sql1 = "update card set id = id-1 where id > "+String.valueOf(selectCard.getId());
        String sql = "delete from card where name='"+selectCard.getName()+"'";
        
        try {
		Connection conn = null;
		Statement state = null;
	        ResultSet rs = null;
                conn = JDBC.getConnection();
                state = conn.createStatement(); 
                state.executeUpdate(sql1);
                state.executeUpdate(sql);
        }catch(Exception e) {
                e.printStackTrace();
        }
        ObservableList<Card> cards = new cardDao().getCardTable().getCardList();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        telCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
        cardView.setItems(cards);
    }
    
    @FXML
    void showChange(ActionEvent event) throws IOException {
        Card selectCard = cardView.getSelectionModel().getSelectedItem();
        ViewLoader.showStage(selectCard, "/view/Change.fxml", "", stage);
    }
      
}
