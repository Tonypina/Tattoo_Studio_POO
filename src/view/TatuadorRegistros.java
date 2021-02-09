/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Model;
import objects.Tatuador;

/**
 *
 * @author Airam
 */
public class TatuadorRegistros extends javax.swing.JPanel {

    /**
     * Creates new form TatuadorRegistros
     */
    public TatuadorRegistros() {
        initComponents();
        llenarTablaTatuadores();
    }

   public void llenarTablaTatuadores (){
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
        int[] anchos ={35,100,100,100,100,100,40};
          
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 58)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registros");
        add(jLabel1);
        jLabel1.setBounds(360, 13, 236, 58);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apelldio Materno", "Contacto", "Rango", "Total $"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(105, 89, 731, 290);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoI.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(-10, -10, 960, 460);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
