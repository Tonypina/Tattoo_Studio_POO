/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.*;
import objects.*;

/**
 *
 * @author Airam
 */
public class TatuadorMenu extends javax.swing.JFrame {
int vp, vp1, vp2, vp3 =0;
 TatuadorRegistro tr;
 TatuadorBuscar tb;
 TatuadorElimiModif tm;
 TatuadorRegistros tRT;

    public TatuadorMenu() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(1050, 650);
           
        Abrir_Registro();
        Buscar();
        ModifoElimin();
        RegistrosT();
       // setResizable(false);
    }
    
     TatuadorMenu(String nombre, String apellidop, String apellidom, String contacto, int rangoI, int total) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
     private void Abrir_Registro(){
         if (vp == 0){
          tr= new TatuadorRegistro();
         principal.addTab("Registrar",tr);
         principal.setSelectedComponent(tr);
         }else{
             principal.setSelectedComponent(tr);
         }
         vp = 1;
     }
     
     private void Buscar(){
         if (vp1 == 0) {
             tb = new TatuadorBuscar();
             principal.addTab("Buscar", tb);
             principal.setSelectedComponent(tb);
         } else {
             principal.setSelectedComponent(tb);
         }
         vp1 = 1;
     }
     
     private void ModifoElimin(){
       if (vp2==0){
           tm = new TatuadorElimiModif();
           principal.addTab("Modificar o Eliminar", tm);
           principal.setSelectedComponent(tm);
       } else {
             principal.setSelectedComponent(tm);
         }
         vp2 = 1;       
     }
     
     private void RegistrosT(){
       if (vp3==0){
           tRT = new TatuadorRegistros();
           principal.addTab("Todos", tRT);
           principal.setSelectedComponent(tRT);
       } else {
             principal.setSelectedComponent(tRT);
         }
         vp3 = 1;       
     }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        principal = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton5.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/return.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 58)); // NOI18N
        jLabel1.setText("Tatuadores");

        principal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(principal, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
        MenuP mt = new MenuP();
        mt.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane principal;
    // End of variables declaration//GEN-END:variables
}
