/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form;

/**
 *
 * @author gyaci
 */
public class RecuSMS extends javax.swing.JPanel {

    /**
     * Creates new form RecuSMS
     */
    public RecuSMS() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        txtTelefono1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRegresosms = new javax.swing.JButton();
        label1 = new java.awt.Label();
        txtTelefono = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        txtCorreosms1 = new javax.swing.JTextField();
        label3 = new java.awt.Label();
        txtTelefono2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 51, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/png/SMSS (1).png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 83, -1, -1));

        btnRegresosms.setBackground(new java.awt.Color(0, 51, 102));
        btnRegresosms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/png/regreso (3).png"))); // NOI18N
        add(btnRegresosms, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 50, 37));

        label1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label1.setForeground(java.awt.Color.lightGray);
        label1.setText("Ingrese el código que se le envio:");
        add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));
        label1.getAccessibleContext().setAccessibleName("");

        add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 190, -1));

        label2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label2.setForeground(java.awt.Color.lightGray);
        label2.setText("Ingrese el correo electronico con el que esta registrado:");
        add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));
        add(txtCorreosms1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 190, -1));

        label3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label3.setForeground(java.awt.Color.lightGray);
        label3.setText("Ingrese el número al que le gustaría que se le envie el codigo:");
        add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));
        add(txtTelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 190, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresosms;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JTextField txtCorreosms1;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefono1;
    private javax.swing.JTextField txtTelefono2;
    // End of variables declaration//GEN-END:variables
}
