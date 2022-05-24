/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package po;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Card;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.JDBC;

public class CardTable {
    private final ObservableList<Card> cards = FXCollections.observableArrayList();
    
    public ObservableList<Card> getCardList()
    {
        return this.cards;
    }
    
    public CardTable()
    {
        try {
                Connection conn = null;
                Statement state = null;
                ResultSet rs = null;
                conn = JDBC.getConnection();
                state = conn.createStatement();    
                String sql = "select * from card";
                rs = state.executeQuery(sql);
                while (rs.next()) {                
                    cards.add(new Card(rs.getInt("id"),rs.getString("name"),rs.getString("telephone"),rs.getString("email"),rs.getString("company"),rs.getString("post")));
            }
            }catch (Exception e) {
                e.printStackTrace();
        }
    }
}
