package View.aplicacion;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingUtilities;
import View.Application.form.LoginForm;
import View.Application.form.MainForm;
import View.Application.form.RecuCorreo1;
import View.Application.form.RecuQR;
import View.Application.form.Recus;
import View.glasspanepopup.GlassPanePopup;
import raven.toast.Notifications;


public class Application extends javax.swing.JFrame {

    private static Application app;
    private final MainForm mainForm;
    private final LoginForm loginForm;
    private final Recus recuperaciones;
    private final RecuQR recuSMS;
    private final RecuCorreo1 recuCorreo;

    public Application() {
        initComponents();
        setSize(new Dimension(1200, 768));
        setLocationRelativeTo(null);
        mainForm = new MainForm();
        loginForm = new LoginForm();
        recuperaciones = new Recus();
        recuSMS = new RecuQR();
        recuCorreo = new RecuCorreo1();
        setContentPane(loginForm);
        Notifications.getInstance().setJFrame(this);
        GlassPanePopup.install(this);
    }

    public static void showForm(Component component) {
        component.applyComponentOrientation(app.getComponentOrientation());
        app.mainForm.showForm(component);
    }

    public static void login() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.mainForm);
        app.mainForm.applyComponentOrientation(app.getComponentOrientation());
        setSelectedMenu(0, 0);
        app.mainForm.hideMenu();
        SwingUtilities.updateComponentTreeUI(app.mainForm);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
        FlatLaf.updateUI();
    }

    public static void logout() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.loginForm);
        app.loginForm.applyComponentOrientation(app.getComponentOrientation());
        SwingUtilities.updateComponentTreeUI(app.loginForm);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
        FlatLaf.updateUI();
    }
    
    public static void recuperaciones() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.recuperaciones);
        app.recuperaciones.applyComponentOrientation(app.getComponentOrientation());
        setSelectedMenu(0, 0);
        SwingUtilities.updateComponentTreeUI(app.recuperaciones);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
        FlatLaf.updateUI();
    }
    
    public static void recuQR() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.recuSMS);
        app.recuSMS.applyComponentOrientation(app.getComponentOrientation());
        setSelectedMenu(0, 0);
        SwingUtilities.updateComponentTreeUI(app.recuSMS);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
        FlatLaf.updateUI();
    }
    
    public static void recuCorreo() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.recuCorreo);
        app.recuCorreo.applyComponentOrientation(app.getComponentOrientation());
        setSelectedMenu(0, 0);
        SwingUtilities.updateComponentTreeUI(app.recuCorreo);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
        FlatLaf.updateUI();
    }

    public static void setSelectedMenu(int index, int subIndex) {
        app.mainForm.setSelectedMenu(index, subIndex);
    }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        FlatLaf.registerCustomDefaultsSource("View.theme");
        FlatDarculaLaf.setup();
        
        java.awt.EventQueue.invokeLater(() -> {
            app = new Application();
            //  app.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            app.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
