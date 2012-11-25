/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.presentation;

import com.encoming.controller.CursoController;
import com.encoming.utils.ExisteCursoException;
import com.encoming.vo.CursoVo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author FAMILIA
 */
public class createsCourses extends javax.swing.JPanel {
    
    List<CursoVo> cursos = new ArrayList<CursoVo>();
    private principal principal;
    /**
     * Creates new form createsCourses
     */
    public createsCourses(principal parent) {
        principal = parent;
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        cbPreRequisito = new javax.swing.JComboBox();
        tfCosto = new javax.swing.JTextField();
        bAgregarCurso = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("CREAR UN CURSO");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel2.setText("NOMBRE");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel3.setText("PRE-REQUISITO");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel4.setText("COSTO");

        cbPreRequisito.setModel(new javax.swing.DefaultComboBoxModel(new CursoController().getCursosNames()));
        cbPreRequisito.addItem("Ninguno");
        cbPreRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPreRequisitoActionPerformed(evt);
            }
        });

        tfCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCostoActionPerformed(evt);
            }
        });

        bAgregarCurso.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        bAgregarCurso.setForeground(new java.awt.Color(0, 153, 153));
        bAgregarCurso.setText("AGREGAR CURSO");
        bAgregarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4)
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPreRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCosto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(bAgregarCurso)
                        .addGap(102, 102, 102)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPreRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(bAgregarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void listarCursos(){
        cursos = new ArrayList<CursoVo>();
        for(CursoVo curso : cursos){
            cbPreRequisito.addItem(curso);        
        } 
    }
    
    
    private void tfCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCostoActionPerformed

    private void cbPreRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPreRequisitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPreRequisitoActionPerformed

    private void bAgregarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarCursoActionPerformed
        String str = tfNombre.getText();
        assert !str.equals("Prueba0"):"Se ha intentado agregar el curso Prueba0";
        str = CursoController.validateName(str);
        if (!str.equals("Validado")){
            JOptionPane.showMessageDialog(this, str, "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            new CursoController().crearCurso(tfNombre.getText(),
                    (String)cbPreRequisito.getSelectedItem(),
                    new Long(tfCosto.getText()));
            JOptionPane.showMessageDialog(this, "El curso se ha guardado", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
        } catch (ExisteCursoException ex) {
            Logger.getLogger(createsCourses.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "El curso ya EXISTE!!", "Aviso!", JOptionPane.ERROR_MESSAGE);
        }
        principal.cambiarPanel(new PPrincipal(principal));
    }//GEN-LAST:event_bAgregarCursoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregarCurso;
    private javax.swing.JComboBox cbPreRequisito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField tfCosto;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
