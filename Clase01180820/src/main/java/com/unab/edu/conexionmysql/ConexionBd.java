/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class ConexionBd {

    private Connection conexion;

    public ConexionBd() {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/clase1", "root", "root");
            System.out.println("¡Conexión Establecida!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXIÓN: \n\n" + e);
        }
    }

    public Connection retornarConexion() {

        return conexion;
    }
}
