/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import cardsysapp.Controller;
import cardsysapp.ViewLoader;
import dao.cardDao;
import dao.userDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import po.MyUserTable;
import model.MyUser;

/**
 * FXML Controller class
 *
 * @author shao
 */
public class OperateController extends Controller<MyUser> {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button changeBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button checkBtn;

    @FXML
    void handleCancel(ActionEvent event) throws IOException {
        ViewLoader.showStage(new cardDao(), "/view/User.fxml", "", stage);
    }

    @FXML
    void handleChange(ActionEvent event) throws IOException {
        ViewLoader.showStage(model, "/view/ChangePwd.fxml", "", stage);
    }

    @FXML
    void handleCheck(ActionEvent event) throws IOException {
        ViewLoader.showStage(new cardDao(), "/view/Card.fxml", "", stage);
    }  
    
}
