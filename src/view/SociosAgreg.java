/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Component;
import java.util.ArrayList;
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
        setSize(980,575);
        setLocationRelativeTo(null); 
        llenar();
    }
    
    public void bloquearBoton(){
     for(Component a:jPanel1.getComponents() ){
         a.setEnabled(false);
        }
      }
    
     public void llenar(){
    ArrayList <Socio> lista= Model.getSocios();
        for (Socio f :lista ){
                if (f.isRango() == true){
                 jComboBox1.removeAllItems();
                 jComboBox1.addItem("Minoritario");
                 
                 }   
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("                     Rango:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(241, 354, 180, 29);

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("                Nombre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(248, 155, 172, 29);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 68)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registrar");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(325, 31, 300, 69);

        jComboBox1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rango", "Mayoritario", "Minoritario" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(455, 354, 286, 25);

        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(jTextField2);
        jTextField2.setBounds(455, 417, 286, 25);

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(455, 155, 286, 25);

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("                Contacto:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(237, 416, 180, 29);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresarboton.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(850, 40, 57, 33);

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido Paterno:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(248, 215, 161, 29);

        jLabel6.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apeliido Materno:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(248, 288, 168, 29);

        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(jTextField3);
        jTextField3.setBounds(448, 219, 286, 25);

        jTextField4.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(jTextField4);
        jTextField4.setBounds(455, 289, 286, 25);

        jPanel1.setOpaque(false);

        jButton1.setFont(new java.awt.Font("Sitka Small", 0, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(444, 473, 179, 48);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoI.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(-10, -10, 990, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 

     int c = Model.getSocios().size();
     if (c<4){
      String nombre = jTextField1.getText();
      String apellidop = jTextField3.getText();
      String apellidom = jTextField4.getText();
      String nombreC = nombre + " " + apellidop  + " "+ apellidom;
      
      String contacto = jTextField2.getText();
      String rango = jComboBox1.getSelectedItem().toString();
      boolean rang = false;
      double total = 0;
      if (rango.equals("Mayoritario")){
          rang = true;    
        jComboBox1.removeItemAt(1);
      }
      
      else{
          rang = false;
      }
      
    
    /* if (jTextField1.getText().length() != 0 && jTextField2.getText().length() != 0
             && jTextField3.getText().length() != 0 && jTextField4.getText().length() != 0 &&
              jComboBox1.getSelectedIndex() !=0) { */    
     
         Socio s = new Socio (nombreC, contacto, rang, total);
          Model.insertarSocio(s);
      
          JOptionPane.showMessageDialog(null, "Registro Exitoso" );
          jTextField1.setText(" ");
          jTextField2.setText(" ");   
          jTextField3.setText(" ");       
          jTextField4.setText(" ");         
      /*  }else{
           JOptionPane.showMessageDialog(null, "Datos incompletos" );

        }*/

     }
     
      else{
       JOptionPane.showMessageDialog(null, "Solo se permiten 4 socios" ); 
        jTextField1.setText(" ");
          jTextField2.setText(" ");   
          jTextField3.setText(" ");       
          jTextField4.setText(" "); 
       bloquearBoton();
      } 
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
