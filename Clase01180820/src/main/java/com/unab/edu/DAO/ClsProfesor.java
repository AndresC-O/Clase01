/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.conexionmysql.ConexionBd;
import com.unab.edu.entidades.Profesor;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDRES CORDOVA
 */
public class ClsProfesor {
    
    ConexionBd con = new ConexionBd();
    Connection conectar = con.retornarConexion();
    
    public boolean LoguinProfesor(String Usuario, String Password){
        
        ArrayList<Profesor> ListadoUsersPasswords = new ArrayList<>();
        ArrayList<Profesor> ListadoPass = new ArrayList<>();
        
        try {
            
            CallableStatement consulta = conectar.prepareCall("call SP_S_LOGINPROFESOR(?,?)");
            consulta.setString("pUsuario", Usuario);
            consulta.setString("pPass", Password);
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
                
                Profesor profesor = new Profesor();
                profesor.setUsuario(rs.getString("Usuario"));
                profesor.setPass(rs.getString("Pass"));
                ListadoUsersPasswords.add(profesor);   
            }
            String usuarioBD = null;
            String passwordBD = null;
            for(var iterar : ListadoUsersPasswords){
                
                usuarioBD = iterar.getUsuario();
                passwordBD = iterar.getPass();
            }
            
            CallableStatement consulta2 = conectar.prepareCall("call SP_S_CRIPPROFESOR(?)");
            consulta2.setString("pPass", Password);
            ResultSet rs2 = consulta2.executeQuery();
            while(rs2.next()){
                
                Profesor profesor = new Profesor();
                profesor.setPass(rs2.getNString("crip"));
                ListadoPass.add(profesor);
            }
            String passcrip = null;
            for(var iterar : ListadoPass){
                
                passcrip = iterar.getPass();
                Password = passcrip;
            }
            
            if(usuarioBD != null && passwordBD != null){
                if(usuarioBD.equals(Usuario) && passwordBD.equals(Password)){
                    return true;
                }
            }
            
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en: " + e);
        }
        
        return false;
    }
}
