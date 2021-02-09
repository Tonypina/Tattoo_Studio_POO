/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JOptionPane;
import objects.*;
import model.*;

/**
 *
 * @author Airam
 */
public class SociosAgreg extends javax.swing.JFrame {

    /**
     * Creates new form SociosAgreg
     */
    public SociosAgreg() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(1050, 650); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel3.setText("Rango:");

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 58)); // NOI18N
        jLabel1.setText("Registrar");

        jButton1.setFont(new java.awt.Font("Sitka Small", 0, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rango", "Mayoritario", "Minoritario" }));

        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel4.setText("Contacto:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/return.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel5.setText("Apellido Paterno:");

        jLabel6.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel6.setText("Apeliido Materno:");

        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(35, 35, 35)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel3)
                        .addGap(34, 34, 34)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jButton1)))
                .addGap(156, 156, 156)
                .addComponent(jButton2)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton2)
                .addContainerGap(316, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      String nombre = jTextField1.getText();
      String apellidop = jTextField3.getText();
      String apellidom = jTextField4.getText();
      String nombreC = nombre + " " + apellidop  + " "+ apellidom;
      
      String contacto = jTextField2.getText();
      String rango = jComboBox1.getSelectedItem().toString();
      boolean rang = false;
      double total =0;
      if ("Mayoritario".equals(rango)){
          rang = true;
          // jComboBox1.remove(1);
      }
      
      else if ("Minoritario".equals(rango)){
          rang = false;
      }
      
      Socio s = new Socio (nombreC, contacto, rang, total);
      Model.insertarSocio(s);
      
       JOptionPane.showMessageDialog(null, "Registro Exitoso" );
       jTextField1.setText(" ");
       jTextField2.setText(" ");   
       jTextField3.setText(" ");       
       jTextField4.setText(" ");       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
       SociosMenu m = new SociosMenu();
        m.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}