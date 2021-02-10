/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Airam
 */
public class PerfMenu extends javax.swing.JFrame {
int vp, vp1, vp2, vp3 = 0;
PerfRegistrar pr;
PerfBuscar  pb;
PerfElimiModif pm;
PerfRegistros prs;
   
    public PerfMenu() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(1050, 650);
           
        Abrir_Registro();
        Buscar();
        Modificar();
        Registros();
        
    }

     private void Abrir_Registro(){
         if (vp == 0){
          pr = new PerfRegistrar();
         principal.addTab("Registrar",pr);
         principal.setSelectedComponent(pr);
         }else{
             principal.setSelectedComponent(pr);
         }
         vp = 1;
     }
     
     private void Buscar(){
         if (vp1 == 0){
          pb = new PerfBuscar();
         principal.addTab("Buscar",pb);
         principal.setSelectedComponent(pb);
         }else{
             principal.setSelectedComponent(pb);
         }
         vp1 = 1;
     }
     
     private void Modificar(){
         if (vp2 == 0){
          pm = new PerfElimiModif();
         principal.addTab("Modificar y Eliminar",pm);
         principal.setSelectedComponent(pm);
         }else{
             principal.setSelectedComponent(pm);
         }
         vp2 = 1;
    } 
     
      private void Registros(){
         if (vp3 == 0){
          prs = new PerfRegistros();
         principal.addTab("Todos",prs);
         principal.setSelectedComponent(prs);
         }else{
             principal.setSelectedComponent(prs);
         }
         vp3 = 1;
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        principal = new javax.swing.JTabbedPane();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/return.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(961, 48, 57, 33);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Perforadores");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 320, 70);
        getContentPane().add(principal);
        principal.setBounds(10, 87, 1021, 401);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoI.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1040, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        MenuP m = new MenuP();
        m.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTabbedPane principal;
    // End of variables declaration//GEN-END:variables
}
