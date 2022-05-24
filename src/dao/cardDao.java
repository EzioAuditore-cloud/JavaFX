/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import po.CardTable;
import model.*;
import util.JDBC;

public class cardDao {
    private CardTable cardTable;
    
    public cardDao()
    {
        this.cardTable = new CardTable();
    }
    
    public CardTable getCardTable()
    {
        return this.cardTable;
    }
}
