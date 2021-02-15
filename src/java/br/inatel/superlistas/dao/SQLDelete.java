/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.superlistas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MatheusdeOliveiraCam
 */
public class SQLDelete {
    
    private SQLConnection mSQLConnection;
    
    private static final String DELETE_PRODUTO = "delete from produto "
            + "where idProduto = ?"; 
    
    public void deleteProduto(int id) {
        
        mSQLConnection = SQLConnection.getInstance();
        Connection conn = mSQLConnection.getMySQLConnetion();
        
        PreparedStatement pstmt = null;
        
        try {
            pstmt = conn.prepareStatement(DELETE_PRODUTO);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLDelete.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            mSQLConnection.closeConnection(pstmt, null);
        }
        
    }
    
}
