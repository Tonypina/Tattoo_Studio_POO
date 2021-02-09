/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import model.Model;
import objects.*;

/**
 *
 * @author Airam
 */
public class CitasBusca extends javax.swing.JPanel {

    public CitasBusca() {
        initComponents();
        ArrayList<Cita> lista = Model.getCitas();
        llenarTablaCitas(lista);
    }

    private void llenarTablaCitas( ArrayList<Cita> lista ){
      
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        int cantidadColumnas = 5;
   
        modelo.addColumn("ID cita");
        modelo.addColumn("Nombre");
        modelo.addColumn("Dia");     
        modelo.addColumn("Hora");       
        modelo.addColumn("Tatuador");  
        int[] anchos ={35, 130, 23, 23, 130};
          
        for (int x =0; x< cantidadColumnas;x++  ){
            jTable1.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
        }
                       
        for(Cita c : lista){           
            Object[] fila = new Object[cantidadColumnas];
            fila[0] = c.getIdCita();
            fila[1] = c.getNombreCliente();
            
            if (c.getDiaInicio() < 10 && c.getMesInicio()<10 ){
               fila[2] = "0"+c.getDiaInicio() + " / 0" + c.getMesInicio() + " / " + c.getAnioInicio();    
            }else if (c.getDiaInicio() < 10){
                fila[2] = "0"+c.getDiaInicio() + " / " + c.getMesInicio() + " / " + c.getAnioInicio();    
            }else if (c.getMesInicio() < 10){
                fila[2] = c.getDiaInicio() + " / 0" + c.getMesInicio() + " / " + c.getAnioInicio();    
            }else{
                fila[2] = c.getDiaInicio() + " / "+ c.getMesInicio() + " / " + c.getAnioInicio();                   
            }
            
            if (c.getHora()< 10 && c.getMinutos()< 10){
                fila[3] = "0"+c.getHora() + ":0" + c.getMinutos() + " hrs" ;
            }
            else if (c.getHora()< 10){
                fila[3] = "0"+c.getHora() + ":" + c.getMinutos() + " hrs" ;
            }
            else if (c.getMinutos()< 10){
                fila[3] = c.getHora() + ":0" + c.getMinutos() + " hrs" ;                
            }else{
                fila[3] = c.getHora() + ":" + c.getMinutos() + " hrs" ;                
            }
            
            Tatuador t = Model.buscarTatuador(c.getIdTatuador());
            fila[4] = t.getNombre()+" "+t.getAp_pat()+" "+t.getAp_mat();
          
            modelo.addRow(fila);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(null);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(747, 85, 44, 52);
        add(jButton2);
        jButton2.setBounds(26, 440, 33, 9);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 53)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Búsqueda");
        add(jLabel1);
        jLabel1.setBounds(352, 24, 216, 54);

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha de la Cita:");
        add(jLabel2);
        jLabel2.setBounds(128, 103, 147, 27);

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        add(jTextField1);
        jTextField1.setBounds(293, 101, 70, 27);

        jButton1.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(600, 100, 113, 37);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre del Cliente", "Fecha de Reservación", "Fecha Final", "Tatuador", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(46, 150, 829, 250);

        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        add(jTextField2);
        jTextField2.setBounds(393, 101, 70, 27);

        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        add(jTextField3);
        jTextField3.setBounds(487, 101, 70, 27);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("//");
        add(jLabel3);
        jLabel3.setBounds(370, 104, 18, 21);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("//");
        add(jLabel4);
        jLabel4.setBounds(468, 104, 18, 21);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoI.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        add(jLabel5);
        jLabel5.setBounds(-9, -14, 970, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{    
            String dia=jTextField1.getText();
            int diaC=Integer.parseInt(dia);
            String mes=jTextField2.getText();
            int mesC=Integer.parseInt(mes);
             String año=jTextField3.getText();
            int añoC=Integer.parseInt(año);

            llenarTablaCitas(Model.getCitas(diaC, mesC, añoC));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Formato incorrecto." );
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
     llenarTablaCitas(Model.getCitas());

    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
