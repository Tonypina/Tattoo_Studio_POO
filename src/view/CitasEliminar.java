/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Component;
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
        setSize(1190,510);  
     ArrayList<Cita> lista = Model.getCitas();
        llenarTablaCitas(lista);
        combo2();
        bloquearID();
    }
    
     public void bloquearID(){
        for(Component a:jPanel1.getComponents() ){
         a.setEnabled(false);
        }
        
    }
    public void combo2(){
        
        jComboBox7.removeAllItems();
        ArrayList <String> lista = new ArrayList <>();
        
        for(Tatuador t : Model.getTatuadores())
            lista.add(t.getNombre()+" "+t.getAp_pat()+" "+t.getAp_mat());
        
        for(int i = 0; i < lista.size(); i++){
             jComboBox7.addItem(lista.get(i));
        }
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
                   
          int id = c.getIdTatuador();
          Tatuador t = Model.buscarTatuador(id);
          fila [4]= t.getNombre()+ " " + t.getAp_pat()+ " " + t.getAp_mat();
          
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
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setLayout(null);

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        add(jTextField1);
        jTextField1.setBounds(930, 177, 248, 24);

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha:");
        add(jLabel3);
        jLabel3.setBounds(884, 264, 42, 21);

        jLabel8.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tatuador:");
        add(jLabel8);
        jLabel8.setBounds(848, 222, 64, 21);

        jComboBox7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox7);
        jComboBox7.setBounds(930, 219, 248, 24);

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
        jScrollPane1.setBounds(11, 122, 832, 339);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trashpeque.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(1121, 428, 65, 41);

        jComboBox1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Día", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(930, 261, 51, 24);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editboton.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(1020, 430, 57, 33);

        jComboBox2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        add(jComboBox2);
        jComboBox2.setBounds(1014, 261, 79, 24);

        jComboBox3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032" }));
        add(jComboBox3);
        jComboBox3.setBounds(1121, 261, 57, 24);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 53)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modificar y Eliminar");
        add(jLabel1);
        jLabel1.setBounds(10, 11, 458, 54);

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Cliente:");
        add(jLabel2);
        jLabel2.setBounds(857, 180, 55, 21);

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hora:");
        add(jLabel5);
        jLabel5.setBounds(868, 344, 37, 21);

        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        add(jTextField2);
        jTextField2.setBounds(930, 341, 51, 24);

        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        add(jTextField3);
        jTextField3.setBounds(1033, 341, 60, 24);

        jComboBox8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        add(jComboBox8);
        jComboBox8.setBounds(1121, 341, 57, 24);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel6.setText(":");
        add(jLabel6);
        jLabel6.setBounds(1001, 343, 6, 19);

        jLabel4.setText("Hora");
        add(jLabel4);
        jLabel4.setBounds(940, 319, 27, 16);

        jLabel7.setText("Minutos");
        add(jLabel7);
        jLabel7.setBounds(1033, 319, 44, 16);

        jLabel9.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID Cita:");
        add(jLabel9);
        jLabel9.setBounds(857, 140, 52, 26);

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
        jPanel1.setBounds(930, 122, 189, 48);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sync.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(940, 420, 44, 52);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoI.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        add(jLabel10);
        jLabel10.setBounds(0, 0, 1190, 510);
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

             String ho=jTextField2.getText();
            int hora=Integer.parseInt(ho);

            String min=jTextField3.getText();
            int minuto=Integer.parseInt(min);               

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

            Cita c = new Cita(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()), nombreC, dI, mI, aI,hora,minuto, idT);
            Model.modificarCita(c);
            ArrayList<Cita> lista = Model.getCitas();
            llenarTablaCitas(lista);
            JOptionPane.showMessageDialog(null, "Cita Modificada" );
        }catch(Exception e){
            e.getMessage();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
        String i=jTextField4.getText();
        int id=Integer.parseInt(i);
        Model.eliminarCita(id);
         ArrayList<Cita> lista = Model.getCitas();
        llenarTablaCitas(lista);
        JOptionPane.showMessageDialog(null, "Cita Eliminada" );
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un Error" );
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
          //  if(h.equals(c.getHora()+ ":"+ c.getMinutos())){
                 jTextField4.setText(Integer.toString(c.getIdCita()));
                 jTextField1.setText(c.getNombreCliente());
                 if (c.getHora()>12){
                 jTextField2.setText(Integer.toString(c.getHora()-12));
                 //jComboBox8.setSelectedIndex(2);
                 }else{
                  jTextField2.setText(Integer.toString(c.getHora()));
                 }
                 jTextField3.setText(Integer.toString(c.getMinutos())); 
                 
            //}
        }                                         
    }//GEN-LAST:event_jTable1MouseClicked

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
