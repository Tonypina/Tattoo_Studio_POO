/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.*;
import objects.*;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Airam
 */
public class TatuadorElimiModif extends javax.swing.JPanel {

   
    public TatuadorElimiModif() {
        initComponents();
        llenarTablaTatuadores();
        bloquearID();
    }

    public void bloquearID(){
        for(Component a:jPanel1.getComponents() ){
         a.setEnabled(false);
        }
        
    }
    
    private void llenarTablaTatuadores (){
      
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList <Tatuador> lista= Model.getTatuadores();
        jTable1.setModel(modelo);
          
        int cantidadColumnas =7;
          
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Contacto");
        modelo.addColumn("Rango");
        modelo.addColumn("Total");  
        int[] anchos ={40,100,100,100,100,100,40};
          
        for (int x =0; x< cantidadColumnas;x++  ){
            jTable1.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
        }
        for(Tatuador t : lista){
            Object[] fila = new Object[cantidadColumnas];
            fila[0] = t.getId();
            fila[1] = t.getNombre();
            fila[2] = t.getAp_pat();
            fila[3] = t.getAp_mat();
            fila[4] = t.getContacto();
            switch(t.getRango()){
                case 0:
                    fila[5] = "Principal";
                    break;
                case 1:
                    fila[5] = "Aprendiz";
                    break;
                case 2:
                    fila[5] = "Secundario";
                    break;
            }
            fila[6] = t.getTotal();
            modelo.addRow(fila);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setLayout(null);

        jTextField5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        add(jTextField5);
        jTextField5.setBounds(740, 240, 181, 24);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 49)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modificar y Eliminar");
        add(jLabel1);
        jLabel1.setBounds(10, 10, 423, 50);

        jButton3.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N
        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(731, 379, 119, 33);

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");
        add(jLabel4);
        jLabel4.setBounds(664, 132, 60, 21);

        jButton4.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(840, 379, 113, 33);

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido Materno:");
        add(jLabel5);
        jLabel5.setBounds(609, 208, 121, 21);

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rango:");
        add(jLabel2);
        jLabel2.setBounds(684, 278, 46, 21);

        jLabel6.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apeliido Paterno:");
        add(jLabel6);
        jLabel6.setBounds(609, 170, 115, 21);

        jLabel8.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Contacto:");
        add(jLabel8);
        jLabel8.setBounds(666, 240, 64, 21);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Contacto", "Rango", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 91, 595, 294);

        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        add(jTextField2);
        jTextField2.setBounds(740, 202, 181, 24);

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel1);
        jPanel1.setBounds(740, 91, 191, 29);

        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        add(jTextField3);
        jTextField3.setBounds(740, 164, 181, 24);

        jTextField4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        add(jTextField4);
        jTextField4.setBounds(750, 126, 171, 24);

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID:");
        add(jLabel3);
        jLabel3.setBounds(701, 99, 21, 21);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Principal", "Aprendiz", "Secundario" }));
        add(jComboBox1);
        jComboBox1.setBounds(740, 275, 172, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoI.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        add(jLabel7);
        jLabel7.setBounds(0, 0, 950, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            String id = jTextField1.getText();
            int iD = Integer.parseInt(id);
            String nombre = jTextField2.getText();
            String apellidop = jTextField3.getText();
            String apellidom = jTextField4.getText();
            String contacto = jTextField5.getText();
             String rango = jComboBox1.getSelectedItem().toString();
            int rangoI=0;
            if ("Principal".equals(rango)){
                rangoI=0;
            }

            else if ("Aprendiz".equals(rango)){
                rangoI=1;
            }

            else if ("Secundario".equals(rango)){
                rangoI=2;
            }


            double tot = 0;

            Tatuador t = new Tatuador(iD, nombre, apellidop, apellidom, contacto, rangoI, tot );
            Model.modificarTatuador(t);
            llenarTablaTatuadores();
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El formato en los campos es incorrecto." );
        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "No a seleccionado nada." );
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            String iD = jTextField1.getText();
            int id = Integer.parseInt(iD);

            Model.eliminarTatuador(id);
            llenarTablaTatuadores();

             jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField5.setText("");
            jTextField4.setText("");
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El formato en los campos es incorrecto." );
        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "No a seleccionado nada." );
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int Fila = jTable1.getSelectedRow();
        int idTatuador = Integer.parseInt(jTable1.getValueAt(Fila, 0).toString());

        Tatuador t = Model.buscarTatuador(idTatuador);

        jTextField1.setText(Integer.toString(t.getId()));
        jTextField4.setText(t.getNombre());
        jTextField3.setText(t.getAp_pat());
        jTextField2.setText(t.getAp_mat());
        jTextField5.setText(t.getContacto());
        //jComboBox1.setText(Integer.toString(t.getRango()));
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
