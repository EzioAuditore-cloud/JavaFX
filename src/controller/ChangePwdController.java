/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import cardsysapp.Controller;
import cardsysapp.ViewLoader;
import dao.userDao;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import po.MyUserTable;
import util.JDBC;
import model.MyUser;

/**
 * FXML Controller class
 *
 * @author shao
 */
public class ChangePwdController extends Controller<MyUser> {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField pwd_againTxt;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField new_pwdTxt;

    @FXML
    private Button okBtn;

    @FXML
    void handleOK(ActionEvent event) throws IOException {
        String new_pwd = new_pwdTxt.getText();
        String pwd_again = pwd_againTxt.getText();
        String name = model.getname();
        String old_pwd = model.getpwd();
        if (new_pwd.equals(old_pwd)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("修改失败");
            alert.setContentText("新密码不能与旧密码一致！");
            alert.showAndWait();
        }
        else if (!new_pwd.equals(pwd_again)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("修改失败");
            alert.setContentText("请再次输入的密码与新密码一致！");
            alert.showAndWait();
        }
        else{
            String sql = "update user set upwd='"+new_pwd+"' where uname='"+name+"'";
            try {
		Connection conn = null;
		Statement state = null;
	        ResultSet rs = null;
                conn = JDBC.getConnection();
                state = conn.createStatement(); 
                state.executeUpdate(sql);
            }catch(Exception e) {
                    e.printStackTrace();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("OK Dialog");
            alert.setHeaderText("修改成功");
            alert.setContentText("请重新登录！");
            alert.showAndWait();
            ViewLoader.showStage(new MyUserTable(), "/view/User.fxml", "", stage);
        }
    }

    @FXML
    void handleCancel(ActionEvent event) throws IOException {
        ViewLoader.showStage(model, "/view/Operate.fxml", "", stage);
    }
  
    
}
