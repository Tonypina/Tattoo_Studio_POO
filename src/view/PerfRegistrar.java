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
public class PerfRegistrar extends javax.swing.JPanel {

    /**
     * Creates new form PerforadoresReg
     */
    public PerfRegistrar() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 58)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registrar");
        add(jLabel1);
        jLabel1.setBounds(249, 0, 233, 58);

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        add(jLabel2);
        jLabel2.setBounds(175, 88, 85, 29);

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido Paterno:");
        add(jLabel3);
        jLabel3.setBounds(92, 128, 168, 29);

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido Materno:");
        add(jLabel4);
        jLabel4.setBounds(92, 175, 175, 29);

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contacto:");
        add(jLabel5);
        jLabel5.setBounds(144, 222, 92, 29);

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        add(jTextField1);
        jTextField1.setBounds(285, 89, 253, 25);

        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        add(jTextField2);
        jTextField2.setBounds(285, 129, 253, 25);

        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        add(jTextField3);
        jTextField3.setBounds(285, 176, 253, 25);

        jTextField4.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        add(jTextField4);
        jTextField4.setBounds(285, 223, 253, 25);

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(276, 269, 147, 37);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoI.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        add(jLabel6);
        jLabel6.setBounds(0, 0, 700, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String nombre = jTextField1.getText();
        String apellidoP = jTextField2.getText();
        String apellidoM = jTextField3.getText();
        
        String nombreC = nombre+" " + apellidoP + " " + apellidoM;
        
        String contacto = jTextField4.getText();
        double total =0;
                
        Proveedor p = new Proveedor (nombreC, contacto, total);
        Model.insertarProveedor(p);
         JOptionPane.showMessageDialog(null, "Registro Exitoso" );
         
         jTextField1.setText("");
         jTextField2.setText("");
         jTextField3.setText("");
         jTextField4.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
