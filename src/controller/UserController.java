package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import cardsysapp.*;
import model.*;
import po.*;
import dao.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Alert;
import util.JDBC;

public class UserController extends Controller<MyUserTable> {

    @FXML
    private Button loginBtn;

    @FXML
    private Button cancelBtn;
    
    @FXML
    private Button registerBtn;

    @FXML
    private TextField upwdTxt;

    @FXML
    private TextField unameTxt;

    @FXML
    void handleCancel(ActionEvent event) {
        this.stage.close();
    }

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        String uname = unameTxt.getText();
        String upwd = upwdTxt.getText();
        userDao userDao = new userDao();
        MyUser user = userDao.getUser(uname, upwd);
        if (userDao.hasUser(uname, upwd)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("OK Dialog");
            alert.setHeaderText("登录成功");
            alert.setContentText("欢迎使用！");
            alert.showAndWait();
            this.stage.close();
            ViewLoader.showStage(user, "/view/Operate.fxml", "", stage);
            
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("登录失败");
            alert.setContentText("用户名或密码错误！");
            alert.showAndWait();
        }
    }
    
     @FXML
    void handleRegister(ActionEvent event) {
        String getCount = "select * from user";
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
        String uname = unameTxt.getText();
        String upwd = upwdTxt.getText();
        userDao userDao = new userDao();
        boolean f = userDao.addUser(c+1, uname, upwd);
         if (f) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("OK Dialog");
            alert.setHeaderText("注册成功");
            alert.setContentText("欢迎使用！");
            alert.showAndWait();
         }
         else 
         {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("注册失败");
            alert.setContentText("该用户已存在！");
            alert.showAndWait();
         }
    }
}
