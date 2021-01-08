/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.operacionesBD;

import com.unab.edu.DAO.ClsPersona;
import com.unab.edu.conexionmysql.ConexionBd;
import com.unab.edu.entidades.Persona;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class crudPersona extends javax.swing.JFrame {

    /**
     * Creates new form crudPersona
     */
    public crudPersona() {
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarTablaPersona();
    }

    SimpleDateFormat formato = new SimpleDateFormat("d MMM y");

    void MostrarTablaPersona() {

        String TITULOS[] = {"ID", "NOMBRE", "APELLIDO", "EDAD", "SEXO", "FECHA"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
        ClsPersona clasePersona = new ClsPersona();
        ArrayList<Persona> Personas = clasePersona.MostrarPersona();
        String filas[] = new String[6];

        for (var iterarDatosPersona : Personas) {
            filas[0] = String.valueOf(iterarDatosPersona.getIdPersona());
            filas[1] = iterarDatosPersona.getNombre();
            filas[2] = iterarDatosPersona.getApellido();
            filas[3] = String.valueOf(iterarDatosPersona.getEdad());
            filas[4] = iterarDatosPersona.getSexo();

            if (iterarDatosPersona.getFecha() == null) {
                filas[5] = "--/--/--";
            } else {
                filas[5] = String.valueOf(formato.format(iterarDatosPersona.getFecha()));
            }

            ModeloTabla.addRow(filas);
        }

        tb_Persona.setModel(ModeloTabla);
    }

    public void VaciarBox() {

        txtID.setText(null);
        txtNombres.setText(null);
        txtApellidos.setText(null);
        txtEdad.setText(null);
        txtSexo.setText(null);
        txtFecha.setDate(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tpMostrar = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        btnConector = new javax.swing.JButton();
        btnVaciar = new javax.swing.JButton();
        lblSexo1 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Persona = new javax.swing.JTable();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tpMostrar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        txtNombres.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtApellidos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtEdad.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtSexo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblID.setText("ID");

        lblNombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblNombre.setText("NOMBRES");

        lblApellidos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblApellidos.setText("APELLIDOS");

        lblEdad.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblEdad.setText("EDAD");

        lblSexo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblSexo.setText("SEXO");

        btnConector.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnConector.setText("Conectar");
        btnConector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectorActionPerformed(evt);
            }
        });

        btnVaciar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnVaciar.setText("Vaciar");
        btnVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarActionPerformed(evt);
            }
        });

        lblSexo1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblSexo1.setText("FECHA");

        txtFecha.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(btnVaciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConector)
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(txtNombres)
                    .addComponent(txtSexo, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID)
                            .addComponent(lblNombre)
                            .addComponent(lblApellidos)
                            .addComponent(lblEdad)
                            .addComponent(lblSexo)
                            .addComponent(lblSexo1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApellidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEdad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lblSexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSexo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnConector)
                    .addComponent(btnEliminar)
                    .addComponent(btnVaciar))
                .addGap(22, 22, 22))
        );

        tpMostrar.addTab("Operación de CRUD", jPanel1);

        tb_Persona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Persona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_PersonaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Persona);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpMostrar.addTab("Mostrar Datos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpMostrar)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpMostrar)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectorActionPerformed

        ConexionBd classConectar = new ConexionBd();
        Connection conectar = classConectar.retornarConexion();
    }//GEN-LAST:event_btnConectorActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        ClsPersona personas = new ClsPersona();
        Persona persona = new Persona();

        persona.setNombre(txtNombres.getText());
        persona.setApellido(txtApellidos.getText());
        persona.setEdad(Integer.parseInt(txtEdad.getText()));
        persona.setSexo(txtSexo.getText());
        persona.setFecha(txtFecha.getDate());

        if (txtID.getText().isEmpty()) {
            personas.AgregarPersonas(persona);
        } else {
            persona.setIdPersona(Integer.parseInt(txtID.getText()));
            personas.ActualizarPersonas(persona);
        }

        MostrarTablaPersona();
        //VaciarBox();
        btnVaciar.doClick();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        ClsPersona personas = new ClsPersona();
        Persona persona = new Persona();

        persona.setIdPersona(Integer.parseInt(txtID.getText()));

        personas.BorrarPersonas(persona);
        MostrarTablaPersona();
        VaciarBox();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tb_PersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_PersonaMouseClicked

        //Modificacion de TabPane.
        tpMostrar.setSelectedIndex(tpMostrar.indexOfComponent(jPanel1));
        //Obtener la fila actual que el usuario seleccionó
        int filas = tb_Persona.getSelectedRow();

        //Sirve para capturar datos de las tablas, pasandole filas y columnas.
        String ID = String.valueOf(tb_Persona.getValueAt(filas, 0));
        String NOMBRE = String.valueOf(tb_Persona.getValueAt(filas, 1));
        String APELLIDOS = String.valueOf(tb_Persona.getValueAt(filas, 2));
        String EDAD = String.valueOf(tb_Persona.getValueAt(filas, 3));
        String SEXO = String.valueOf(tb_Persona.getValueAt(filas, 4));
        String FECHA = String.valueOf(tb_Persona.getValueAt(filas, 5));

        txtID.setText(ID);
        txtNombres.setText(NOMBRE);
        txtApellidos.setText(APELLIDOS);
        txtEdad.setText(EDAD);
        txtSexo.setText(SEXO);

        Date castfecha = new Date();
        try {
            castfecha = formato.parse(FECHA);
            txtFecha.setDate(castfecha);
        } catch (ParseException ex) {
            //Logger.getLogger(crudPersona.class.getName()).log(Level.SEVERE, null, ex);
            txtFecha.setDate(null);
        }
    }//GEN-LAST:event_tb_PersonaMouseClicked

    private void btnVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarActionPerformed

        VaciarBox();
    }//GEN-LAST:event_btnVaciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(crudPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConector;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexo1;
    private javax.swing.JTable tb_Persona;
    private javax.swing.JTabbedPane tpMostrar;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtEdad;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtSexo;
    // End of variables declaration//GEN-END:variables
}
