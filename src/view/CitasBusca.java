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
            
       
          int id = c.getIdTatuador();
          Tatuador t = Model.buscarTatuador(id);
          fila [4]= t.getNombre()+ " " + t.getAp_pat()+ " " + t.getAp_mat();
          
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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 53)); // NOI18N
        jLabel1.setText("Búsqueda");

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel2.setText("Fecha de la Cita:");

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setText("//");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setText("//");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton1)
                        .addGap(34, 34, 34)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jLabel1)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dia=jTextField1.getText();
        int diaC=Integer.parseInt(dia);
        String mes=jTextField2.getText();
        int mesC=Integer.parseInt(mes);
         String año=jTextField3.getText();
        int añoC=Integer.parseInt(año);
   
        llenarTablaCitas(Model.getCitas(diaC, mesC, añoC));


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
