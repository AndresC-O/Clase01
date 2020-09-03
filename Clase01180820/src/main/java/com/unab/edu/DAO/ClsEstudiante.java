/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.conexionmysql.ConexionBd;
import com.unab.edu.entidades.Estudiante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDRES CORDOVA
 */
public class ClsEstudiante {

    ConexionBd classConectar = new ConexionBd();
    Connection conectar = classConectar.retornarConexion();

    public boolean LoguinEstudiante(String usuario, String pass) {

        ArrayList<Estudiante> ListadoUSUPASS = new ArrayList<>();

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_LOGINESTUDIANTE (?,?)");
            Statement.setString("pusuario", usuario);
            Statement.setString("ppass", pass);
            ResultSet resultadoConsulta = Statement.executeQuery();
            while (resultadoConsulta.next()) {

                Estudiante es = new Estudiante();
                es.setUSU(resultadoConsulta.getString("USU"));
                es.setPASS(resultadoConsulta.getString("PASS"));
                ListadoUSUPASS.add(es);
            }

            String usuariobasedatos = "";
            String passbasedatos = "";
            for (var iterar : ListadoUSUPASS) {

                usuariobasedatos = iterar.getUSU();
                passbasedatos = iterar.getPASS();
            }

            if (usuariobasedatos.equals(usuario) && passbasedatos.equals(pass)) {
                return true;
            }

            conectar.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return false;
    }
}
