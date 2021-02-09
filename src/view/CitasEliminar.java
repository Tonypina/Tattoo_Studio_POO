/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;

import objects.*;
/**
 *
 * @author Airam
 */
public class CitasEliminar extends javax.swing.JPanel {

   
    public CitasEliminar() {
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
                fila[2] = c.getDiaInicio() + " / 0"+  + c.getMesInicio() + " / " + c.getAnioInicio();    
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

        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setLayout(null);

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        add(jTextField1);
        jTextField1.setBounds(932, 185, 248, 24);

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha:");
        add(jLabel3);
        jLabel3.setBounds(885, 272, 42, 21);

        jLabel8.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tatuador:");
        add(jLabel8);
        jLabel8.setBounds(850, 230, 64, 21);

        jComboBox7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox7);
        jComboBox7.setBounds(932, 227, 248, 24);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(13, 124, 832, 339);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(1123, 408, 57, 33);

        jComboBox1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Día", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(932, 269, 51, 24);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(1003, 408, 57, 33);

        jComboBox2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        add(jComboBox2);
        jComboBox2.setBounds(1035, 269, 60, 24);

        jComboBox3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032" }));
        add(jComboBox3);
        jComboBox3.setBounds(1123, 269, 57, 24);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 53)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modificar y Eliminar");
        add(jLabel1);
        jLabel1.setBounds(12, 13, 458, 54);

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Cliente:");
        add(jLabel2);
        jLabel2.setBounds(859, 188, 55, 21);

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hora:");
        add(jLabel5);
        jLabel5.setBounds(877, 353, 37, 21);

        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        add(jTextField2);
        jTextField2.setBounds(932, 350, 51, 24);

        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        add(jTextField3);
        jTextField3.setBounds(1035, 350, 60, 24);

        jComboBox8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        add(jComboBox8);
        jComboBox8.setBounds(1123, 350, 57, 24);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel6.setText(":");
        add(jLabel6);
        jLabel6.setBounds(1003, 352, 6, 19);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hora");
        add(jLabel4);
        jLabel4.setBounds(942, 327, 27, 16);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Minutos");
        add(jLabel7);
        jLabel7.setBounds(1035, 327, 44, 16);

        jLabel9.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID Cita:");
        add(jLabel9);
        jLabel9.setBounds(859, 146, 52, 26);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1);
        jPanel1.setBounds(932, 124, 189, 48);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoI.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        add(jLabel10);
        jLabel10.setBounds(-12, -14, 1220, 820);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
        String nombreC = jTextField1.getText();
        String diaI = jComboBox1.getSelectedItem().toString();
        int dI= Integer.parseInt(diaI);
      
        String mesI = jComboBox2.getSelectedItem().toString();
        int mI = 0;
        
       
       switch (mesI){
           case "Enero":
               mI=1;
               break;
           case "Febrero":
               mI= 2;
           break;
           case "Marzo":
               mI=3;
               break;
           case "Abril":
               mI= 4;
           break;
           case "Mayo":
               mI=5;
               break;
           case "Junio":
               mI= 6;
           break;
           case "Julio":
               mI=7;
               break;
           case "Agosto":
               mI= 8;
           break;
           case "Septiembre":
               mI=9;
               break;
           case "Octubre":
               mI= 10;
           break;
           case "Noviembre":
               mI=11;
               break;
           case "Diciembre":
               mI= 12;
           break;
       }
        
        String anI = jComboBox3.getSelectedItem().toString();
        int aI = Integer.parseInt(anI);
        
        String min=jTextField3.getText();
        int minuto=Integer.parseInt(min);
        
        String ho=jTextField2.getText();
        int hora=Integer.parseInt(ho);
        
          if ( jComboBox8.getSelectedItem().toString() == "AM"){
           hora = hora;
        }
        else if (jComboBox8.getSelectedItem().toString() == "PM"){
            hora = hora + 12;
        }
        
      
        String tatuador = jComboBox7.getSelectedItem().toString();
        StringTokenizer st = new StringTokenizer(tatuador, " ");
        ArrayList<Tatuador> listaT = Model.buscarTatuador(st.nextToken());
       
        int idT = 0;
        for(Tatuador t : listaT){
            if(tatuador.equals(t.getNombre()+" "+t.getAp_pat()+" "+t.getAp_mat())){
                idT = t.getId();
            }
        }

        Cita c = new Cita(nombreC, dI, mI, aI,hora,minuto, idT);
        Model.modificarCita(c);
        JOptionPane.showMessageDialog(null, "Cita Modificada" );
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Formato incorrecto." );
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
        String i=jTextField4.getText();
        int id=Integer.parseInt(i);
        Model.eliminarCita(id);
        JOptionPane.showMessageDialog(null, "Cita Eliminada" );
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
       
   /*     String dia= jComboBox1.getSelectedItem().toString();
        int dd = Integer.parseInt(dia);*/
        
        int Fila = jTable1.getSelectedRow();
      
        String h = jTable1.getValueAt(Fila, 3).toString();                             

        String dD = jTable1.getValueAt(Fila, 2).toString();                             
        StringTokenizer st = new StringTokenizer(dD, " / ");
        int nDatos = st.countTokens();
        int[] sr = new int[nDatos];
        int i =0;
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            sr[i]=Integer.valueOf(str).intValue();
            i++;
        }
        
        ArrayList<Cita> listaT = Model.getCitas(sr[0], sr[1], sr[2]);
        
        
        for(Cita c: listaT){
            if(h.equals(c.getHora()+ ":"+ c.getMinutos())){
                 jTextField4.setText(Integer.toString(c.getIdCita()));
                 jTextField1.setText(c.getNombreCliente());
                 jTextField2.setText(Integer.toString(c.getHora()));
                 jTextField3.setText(Integer.toString(c.getMinutos()));                 
            }
        }                                         
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
