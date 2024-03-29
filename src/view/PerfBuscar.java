/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.*;
import objects.*;
/**
 *
 * @author Airam
 */
public class PerfBuscar extends javax.swing.JPanel {

    /**
     * Creates new form PerforadoresBuscar
     */
    public PerfBuscar() {
        initComponents();
        ArrayList<Proveedor> lista = Model.getProveedor();
        llenarTablaPerforadores( lista );
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

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 58)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Búsqueda");
        add(jLabel1);
        jLabel1.setBounds(340, 10, 240, 58);

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
        jButton2.setBounds(770, 90, 41, 42);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese el nombre del perforador que desee buscar:");
        add(jLabel2);
        jLabel2.setBounds(110, 110, 380, 22);

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(490, 100, 187, 24);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/searchboton.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(700, 90, 49, 42);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(150, 160, 654, 150);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoI.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(0, 0, 1000, 440);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText("");
        llenarTablaPerforadores(Model.getProveedor());

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<Proveedor> perforadores = new ArrayList<>();
        
        for(Proveedor p : Model.getProveedor()){
            if(p.getNombre().endsWith("-P")){
                if(p.getNombre().contains(jTextField1.getText())){
                    perforadores.add(p);
                }
            }
        }
        llenarTablaPerforadores(perforadores);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
