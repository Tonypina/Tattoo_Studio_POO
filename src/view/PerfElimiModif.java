/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objects.*;
import model.*;
/**
 *
 * @author Airam
 */
public class PerfElimiModif extends javax.swing.JPanel {

    /**
     * Creates new form PerfElimiModif
     */
    public PerfElimiModif() {
        initComponents();
        llenarTablaPerforadores( Model.getProveedor() );
        bloquearID();
    }
    
      public void bloquearID(){
        for(Component a:jPanel1.getComponents() ){
         a.setEnabled(false);
        }
        
    }
        
      private void llenarTablaPerforadores( ArrayList<Proveedor> lista ){
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        int cantidadColumnas = 4;
          
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
       
        modelo.addColumn("Contacto");
        modelo.addColumn("Total");  
        int[] anchos ={40,200,100,40};
          
        for (int x =0; x< cantidadColumnas;x++  ){
            jTable1.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
        }
        
        for(Proveedor p : lista){
            if(p.getNombre().endsWith("-P")){
                Object[] fila = new Object[cantidadColumnas];
                fila[0] = p.getId();
                fila[1] = p.getNombre().substring(0, p.getNombre().length()-2);
                fila[2] = p.getContacto();
                fila[3] = p.getTotal();
                modelo.addRow(fila);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setLayout(null);

        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        add(jTextField3);
        jTextField3.setBounds(718, 233, 207, 24);

        jLabel6.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contacto:");
        add(jLabel6);
        jLabel6.setBounds(636, 236, 64, 21);

        jTextField4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        add(jTextField4);
        jTextField4.setBounds(720, 189, 205, 24);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 49)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modificar y Eliminar");
        add(jLabel1);
        jLabel1.setBounds(10, 10, 423, 50);

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
        jScrollPane1.setBounds(10, 90, 595, 240);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editboton.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(760, 300, 57, 33);

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");
        add(jLabel4);
        jLabel4.setBounds(634, 192, 60, 21);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        add(jPanel1);
        jPanel1.setBounds(720, 140, 191, 29);

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trashpeque.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(850, 300, 33, 33);

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID:");
        add(jLabel3);
        jLabel3.setBounds(662, 148, 30, 21);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sync.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(680, 290, 41, 42);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoI.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(-10, 0, 970, 430);

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(730, 70, 171, 24);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int Fila = jTable1.getSelectedRow();
        int id = Integer.parseInt(jTable1.getValueAt(Fila, 0).toString());

        Proveedor p = Model.buscarProveedor(id);

        jTextField1.setText(Integer.toString(p.getId()));
        jTextField4.setText(p.getNombre().substring(0, p.getNombre().length()-2));
        jTextField3.setText(p.getContacto());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String id = jTextField1.getText();
        int iD = Integer.parseInt(id);
        String nombre = jTextField4.getText()+"-P";      
        String contacto = jTextField3.getText();
        
        double tot = 0;
        Proveedor p = new Proveedor (iD, nombre, contacto, tot);
        Model.modificarProveedor(p);
        ArrayList<Proveedor> lista = Model.getProveedor();
        llenarTablaPerforadores( lista );
        
        JOptionPane.showMessageDialog(null, "Perforador Modificado" );
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String iD = jTextField1.getText();
        int id = Integer.parseInt(iD);

        Model.eliminarProveedor(id);
        ArrayList<Proveedor> lista = Model.getProveedor();
       llenarTablaPerforadores( lista ); 
        
        jTextField1.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
       JOptionPane.showMessageDialog(null, "Perforador Borrado" );

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText("");
        llenarTablaPerforadores(Model.getProveedor());
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
