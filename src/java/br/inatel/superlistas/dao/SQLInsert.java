/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.superlistas.dao;

import br.inatel.superlistas.model.Lista;
import br.inatel.superlistas.model.Produto;
import br.inatel.superlistas.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MatheusdeOliveiraCam
 */
public class SQLInsert {
    
    private SQLConnection mSQLConnection;
    
    private static final String INSERT_LIST = "insert into lista (nomeLista) "
            + "values (?);";
    
    private static final String INSERT_PRODUTO = "insert into produto "
            + "(nomeProduto, qntProduto, valorProduto, lista_idlista) "
            + "values (?, ?, ?, ?);";
    
    private static final String INSERT_USER = "insert into user (nome, email, "
            + "senha) "
            + "values (?, ?, ?);";
    
    public void insertList (Lista lista) {
        
        mSQLConnection = SQLConnection.getInstance();
        Connection conn = mSQLConnection.getMySQLConnetion();
        
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(INSERT_LIST);
            pstmt.setString(1, lista.getNome());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLInsert.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            mSQLConnection.closeConnection(pstmt, null);
        }
    }
    
    public void insertProduto (Produto produto, int id) {
        mSQLConnection = SQLConnection.getInstance();
        Connection conn = mSQLConnection.getMySQLConnetion();
        
        PreparedStatement pstmt = null;
        
        try {
            pstmt = conn.prepareStatement(INSERT_PRODUTO);
            pstmt.setString(1, produto.getNome());
            pstmt.setInt(2, produto.getQnt());
            pstmt.setFloat(3, produto.getPrice());
            pstmt.setInt(4, id);
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLInsert.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            mSQLConnection.closeConnection(pstmt, null);
        }
        
    }
    
    public void insertUser (User user) {
        mSQLConnection = SQLConnection.getInstance();
        Connection conn = mSQLConnection.getMySQLConnetion();
        
        PreparedStatement pstmt = null;
        
        try {
            pstmt = conn.prepareStatement(INSERT_USER);
            pstmt.setString(1, user.getNome());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getSenha());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLInsert.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            mSQLConnection.closeConnection(pstmt, null);
        }
        
    }
    
}
