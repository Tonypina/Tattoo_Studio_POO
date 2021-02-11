/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JOptionPane;
import model.*;
import objects.Tatuador;

/**
 *
 * @author Airam
 */
public class TatuadorRegistro extends javax.swing.JPanel {

    /**
     * Creates new form TatuadorRegistro
     */
    public TatuadorRegistro() {
        initComponents();
        setSize(750,460);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setLayout(null);

        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        add(jTextField2);
        jTextField2.setBounds(203, 189, 274, 25);

        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        add(jTextField3);
        jTextField3.setBounds(203, 235, 272, 25);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 58)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro ");
        add(jLabel1);
        jLabel1.setBounds(211, 35, 225, 58);

        jTextField5.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        add(jTextField5);
        jTextField5.setBounds(203, 333, 274, 25);

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        add(jLabel2);
        jLabel2.setBounds(100, 145, 85, 29);

        jComboBox1.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Principal", "Aprendiz", "Secundario" }));
        add(jComboBox1);
        jComboBox1.setBounds(201, 284, 274, 25);

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido Paterno:");
        add(jLabel3);
        jLabel3.setBounds(17, 191, 168, 29);

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido Materno:");
        add(jLabel4);
        jLabel4.setBounds(10, 237, 175, 29);

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Rango:");
        add(jLabel5);
        jLabel5.setBounds(117, 286, 66, 29);

        jLabel6.setFont(new java.awt.Font("Palatino Linotype", 0, 21)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contacto:");
        add(jLabel6);
        jLabel6.setBounds(93, 335, 92, 29);

        jButton1.setFont(new java.awt.Font("Sitka Small", 0, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(510, 230, 159, 37);

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        add(jTextField1);
        jTextField1.setBounds(203, 143, 274, 25);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoI.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        add(jLabel7);
        jLabel7.setBounds(0, 0, 750, 460);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            String nombre= jTextField1.getText();
            String apellidop= jTextField2.getText();
            String apellidom= jTextField3.getText();
            String contacto = jTextField5.getText();
            String rango = jComboBox1.getSelectedItem().toString();
            int rangoI=0;
            int total=0;
            if ("Principal".equals(rango)){
                rangoI=1;
            }

            else if ("Aprendiz".equals(rango)){
                rangoI=2;
            }

            else if ("Secundario".equals(rango)){
                rangoI=3;
            }

            Tatuador t = new Tatuador(nombre, apellidop,apellidom, contacto, rangoI,total);
            Model.insertarTatuador(t);
            JOptionPane.showMessageDialog(null, "Registro Exitoso" );

            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField5.setText("");
        } catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
