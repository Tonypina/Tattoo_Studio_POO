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
public class CitasMenu extends javax.swing.JFrame {
int vp, vp1, vp2, vp3 =0;
CitasBusca busqueda;
CitasNuevaC nuevacita;
CitasAgenda agenda;
CitasEliminar elim;
private Usuario u;

    /**
     * Creates new form CitasM
     */
    public CitasMenu( Usuario u ) {
        initComponents();
        setSize(1050, 510);    
        this.u = u;
        setLocationRelativeTo(null); 
        setResizable(false);
        Abrir_Registro();
        Buscar_y_Mostrar();
        Eliminar_o_M();
          
    }
    
    public CitasMenu( ) {
        initComponents();
        this.u = new Usuario(0, null, null, null, true, null, null);
        setLocationRelativeTo(null);
        setSize(1050, 510);  
        setResizable(false);
        Abrir_Registro();
        Buscar_y_Mostrar();
        Eliminar_o_M();
      //  Agenda();
    }
    
     private void Abrir_Registro(){
         if (vp == 0){
         nuevacita = new CitasNuevaC();
         principal.addTab("Nueva Cita",nuevacita);
         principal.setSelectedComponent(nuevacita);
         }else{
             principal.setSelectedComponent(nuevacita);
         }
         vp = 1;
      }
     
     private void Buscar_y_Mostrar(){
         if (vp1 == 0){
         busqueda = new CitasBusca();
         principal.addTab("Buscar y Mostrar",busqueda);
         principal.setSelectedComponent(busqueda);
         }else{
             principal.setSelectedComponent(busqueda);
         }
         vp1 = 1;
      }
     
     private void Eliminar_o_M(){
         if (vp2 == 0){
         elim = new CitasEliminar();
         principal.addTab("Modificar o Eliminar",elim);
         principal.setSelectedComponent(elim);
         }else{
             principal.setSelectedComponent(elim);
         }
         vp2 = 1;
      }
   /*   private void Agenda(){
         if (vp3 == 0){
         agenda = new CitasAgenda();
         principal.addTab("Modificar o Eliminar",agenda);
         principal.setSelectedComponent(agenda);
         }else{
             principal.setSelectedComponent(agenda);
         }
         vp3 = 1;
     }*/
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        principal = new javax.swing.JTabbedPane();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 0, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agenda de Citas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 364, 56);
        getContentPane().add(principal);
        principal.setBounds(10, 73, 997, 393);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sync.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(950, 30, 57, 33);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoI.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, -10, 1040, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        if(this.u.getRango()){
            MenuP m = new MenuP();
            m.setVisible(true);
        } else {
            new MenuS(u).setVisible(true);
        }
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
