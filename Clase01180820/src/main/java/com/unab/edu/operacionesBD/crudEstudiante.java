/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.operacionesBD;

import com.unab.edu.DAO.ClsEstudiante;
import com.unab.edu.DAO.ClsPersona;
import com.unab.edu.entidades.Estudiante;
import com.unab.edu.entidades.Persona;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDRES CORDOVA
 */
public class crudEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form crudEstudiante
     */
    public crudEstudiante() {
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarTablaJOIN();
        MostrarTablaPersona();
        DisplayMember();
    }

    String valueMember[];
    int contador = 0;
    public void DisplayMember(){
        
        DefaultComboBoxModel cbdefault = new DefaultComboBoxModel();
        ClsPersona clsPersona = new ClsPersona();
        ArrayList<Persona> personas = clsPersona.MostrarPersona();
        valueMember = new String[personas.size()];
        
        String Filas[] = new String[5];

        for (var iterar : personas) {

            Filas[0] = String.valueOf(iterar.getIdPersona());
            Filas[1] = iterar.getNombre();
            valueMember[contador] = Filas[0];
            cbdefault.addElement(Filas[1]);
            contador++;
        }
        
        cbPersonas.setModel(cbdefault);
    }
    
    public void VaciarBox() {

        txtIdEstudiante.setText("");
        txtMatricula.setText("");
        //txtIdPersona.setText("");
        txtUsuario.setText("");
        txtPassword.setText("");
        txtNIE.setText("");
    }

    public void MostrarTablaJOIN() {

        String Titulos[] = {"ID", "MATRICULA", "ID PERSONA", "NOMBRE", "USUARIO", "CONTRASEÑA", "NIE"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, Titulos);
        ClsEstudiante clsEstudiante = new ClsEstudiante();
        ArrayList<Estudiante> Estudiantes = clsEstudiante.MostrarJoinEstudiante();
        String filas[] = new String[8];

        for (var iterar : Estudiantes) {

            filas[0] = String.valueOf(iterar.getId());
            filas[1] = String.valueOf(iterar.getMatricula());
            filas[2] = String.valueOf(iterar.getIdPersona());
            filas[3] = iterar.getNombre();
            filas[4] = iterar.getUSU();
            filas[5] = iterar.getPASS();
            filas[6] = String.valueOf(iterar.getNIE());
            ModeloTabla.addRow(filas);
        }

        tb_Estudiante.setModel(ModeloTabla);
    }

    public void MostrarTablaPersona() {
        String Titulos[] = {"ID", "NOMBRE PERSONA"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, Titulos);
        ClsPersona clsPersona = new ClsPersona();
        ArrayList<Persona> personas = clsPersona.MostrarPersona();
        String Filas[] = new String[2];

        for (var iterar : personas) {

            Filas[0] = String.valueOf(iterar.getIdPersona());
            Filas[1] = iterar.getNombre();
            ModeloTabla.addRow(Filas);
        }

        //tbPersona.setModel(ModeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpEstudiante = new javax.swing.JTabbedPane();
        pnDatos = new javax.swing.JPanel();
        txtIdEstudiante = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtNIE = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVaciar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        cbPersonas = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_Estudiante = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(42, 118, 122));

        tpEstudiante.setFocusable(false);
        tpEstudiante.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        pnDatos.setBackground(new java.awt.Color(42, 118, 122));

        txtIdEstudiante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtMatricula.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtNIE.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("ID ESTUDIANTE");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setText("MATRICULA");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("ID PERSONA");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setText("USUARIO");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setText("CONTRASEÑA");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setText("NIE");

        btnGuardar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnVaciar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnVaciar.setText("Vaciar");
        btnVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        cbPersonas.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cbPersonas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnDatosLayout = new javax.swing.GroupLayout(pnDatos);
        pnDatos.setLayout(pnDatosLayout);
        pnDatosLayout.setHorizontalGroup(
            pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdEstudiante, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDatosLayout.createSequentialGroup()
                                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnDatosLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                                        .addGap(73, 73, 73))
                                    .addGroup(pnDatosLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(3, 3, 3))
                                    .addGroup(pnDatosLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(35, 35, 35))
                                    .addGroup(pnDatosLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(14, 14, 14))
                                    .addGroup(pnDatosLayout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(17, 17, 17))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(88, 88, 88))
                            .addComponent(txtNIE, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword)
                            .addComponent(cbPersonas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVaciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );
        pnDatosLayout.setVerticalGroup(
            pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNIE, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVaciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tpEstudiante.addTab("DATOS", pnDatos);

        tb_Estudiante.setBackground(new java.awt.Color(42, 118, 122));
        tb_Estudiante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tb_Estudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "MATRICULA", "ID PERSONA", "NOMBRE", "USUARIO", "CONTRASEÑA", "NIE"
            }
        ));
        tb_Estudiante.setGridColor(new java.awt.Color(42, 118, 122));
        tb_Estudiante.setShowGrid(true);
        tb_Estudiante.setSurrendersFocusOnKeystroke(true);
        tb_Estudiante.getTableHeader().setResizingAllowed(false);
        tb_Estudiante.getTableHeader().setReorderingAllowed(false);
        tb_Estudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_EstudianteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_Estudiante);
        if (tb_Estudiante.getColumnModel().getColumnCount() > 0) {
            tb_Estudiante.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        tpEstudiante.addTab("VISTA DE DATOS", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpEstudiante)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpEstudiante)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_EstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_EstudianteMouseClicked

        tpEstudiante.setSelectedIndex(tpEstudiante.indexOfComponent(pnDatos));
        int filas = tb_Estudiante.getSelectedRow();

        String ID = String.valueOf(tb_Estudiante.getValueAt(filas, 0));
        String Matricula = String.valueOf(tb_Estudiante.getValueAt(filas, 1));
        String IdPersona = String.valueOf(tb_Estudiante.getValueAt(filas, 2));
        String Usuario = String.valueOf(tb_Estudiante.getValueAt(filas, 4));
        String Contrasenia = String.valueOf(tb_Estudiante.getValueAt(filas, 5));
        String Nie = String.valueOf(tb_Estudiante.getValueAt(filas, 6));

        txtIdEstudiante.setText(ID);
        txtMatricula.setText(Matricula);
        //txtIdPersona.setText(IdPersona);
        txtUsuario.setText(Usuario);
        txtPassword.setText(Contrasenia);
        txtNIE.setText(Nie);
    }//GEN-LAST:event_tb_EstudianteMouseClicked

    private void btnVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarActionPerformed

        VaciarBox();
    }//GEN-LAST:event_btnVaciarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (txtIdEstudiante.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡Ingrese un ID para Eliminar!");
        } else {
            ClsEstudiante estudiantes = new ClsEstudiante();
            Estudiante estudiante = new Estudiante();

            estudiante.setId(Integer.parseInt(txtIdEstudiante.getText()));
            estudiantes.EliminarEstudiante(estudiante);
            VaciarBox();
            MostrarTablaJOIN();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (txtIdEstudiante.getText().isEmpty() || txtMatricula.getText().isEmpty() || txtUsuario.getText().isEmpty()
            || txtPassword.getText().isEmpty() || txtNIE.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "¡Complete todos los campos para continuar!");
        } else {
            ClsEstudiante estudiantes = new ClsEstudiante();
            Estudiante estudiante = new Estudiante();

            estudiante.setId(Integer.parseInt(txtIdEstudiante.getText()));
            estudiante.setMatricula(Integer.parseInt(txtMatricula.getText()));
            //estudiante.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
            estudiante.setUSU(txtUsuario.getText());
            estudiante.setPASS(txtPassword.getText());
            estudiante.setNIE(Integer.parseInt(txtNIE.getText()));
            estudiantes.ActualizarEstudiante(estudiante);
            VaciarBox();
            MostrarTablaJOIN();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtMatricula.getText().isEmpty()|| txtUsuario.getText().isEmpty()
            || txtPassword.getText().isEmpty() || txtNIE.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "¡Complete todos los campos para continuar!");
        } else {
            ClsEstudiante estudiantes = new ClsEstudiante();
            Estudiante estudiante = new Estudiante();

            estudiante.setMatricula(Integer.parseInt(txtMatricula.getText()));
            //estudiante.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
            estudiante.setIdPersona(Integer.parseInt(valueMember[cbPersonas.getSelectedIndex()]));
            estudiante.setUSU(txtUsuario.getText());
            estudiante.setPASS(txtPassword.getText());
            estudiante.setNIE(Integer.parseInt(txtNIE.getText()));
            estudiantes.AgregarEstudiante(estudiante);
            VaciarBox();
            MostrarTablaJOIN();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JComboBox<String> cbPersonas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnDatos;
    private javax.swing.JTable tb_Estudiante;
    private javax.swing.JTabbedPane tpEstudiante;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNIE;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
