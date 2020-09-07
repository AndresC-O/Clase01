/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.conexionmysql.ConexionBd;
import com.unab.edu.entidades.Estudiante;
import com.unab.edu.entidades.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
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

    public void AgregarEstudiante(Estudiante est) {

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_I_ESTUDIANTE (?,?,?,?,?)");
            Statement.setInt("pmatricula", est.getMatricula());
            Statement.setInt("pidPersona", est.getIdPersona());
            Statement.setString("pusuario", est.getUSU());
            Statement.setString("ppass", est.getPASS());
            Statement.setInt("pnie", est.getNIE());
            Statement.executeQuery();
            JOptionPane.showMessageDialog(null, "¡Inserción Exitosa!");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ActualizarEstudiante(Estudiante est) {

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_U_ESTUDIANTE (?,?,?,?,?,?)");
            Statement.setInt("pIdEstudiante", est.getId());
            Statement.setInt("pmatricula", est.getMatricula());
            Statement.setInt("pIdPersona", est.getIdPersona());
            Statement.setString("pUsuario", est.getUSU());
            Statement.setString("pPass", est.getPASS());
            Statement.setInt("pNie", est.getNIE());
            Statement.executeQuery();
            JOptionPane.showMessageDialog(null, "¡Actualización de los Datos Exitosa!");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void EliminarEstudiante(Estudiante est) {

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_D_ESTUDIANTE (?)");
            Statement.setInt("pIdEstudiante", est.getId());
            Statement.executeQuery();
            JOptionPane.showMessageDialog(null, "¡Eliminación de Datos Exitosa!");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Estudiante> MostrarJoinEstudiante() {

        ArrayList<Estudiante> lista = new ArrayList<>();

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_INNERESTUDIANTE()");
            ResultSet rs = Statement.executeQuery();

            while (rs.next()) {
                Estudiante es = new Estudiante();
                es.setId(rs.getInt("idEstudiante"));
                es.setMatricula(rs.getInt("matricula"));
                es.setIdPersona(rs.getInt("idPersona"));
                es.setNombre(rs.getString("Nombre"));
                es.setUSU(rs.getString("USU"));
                es.setPASS(rs.getString("PASS"));
                es.setNIE(rs.getInt("NIE"));

                lista.add(es);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }

    Persona person = new Persona();

    public void LlenarComboBox(JComboBox comboPersona) {

        comboPersona.removeAllItems();

        try {

            CallableStatement statement = conectar.prepareCall("call SP_S_Persona()");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                comboPersona.addItem(rs.getString(1));
                comboPersona.addItem(rs.getString(2));
            }
        } catch (Exception e) {

            System.out.println("Error en: " + e);
        }
    }

    @Override
    public String toString() {
        return person.getNombre();
    }
}
