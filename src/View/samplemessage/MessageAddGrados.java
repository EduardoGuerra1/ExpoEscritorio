/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.samplemessage;

import View.Application.form.other.CodigosDisciplinarios;
import View.glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.FlatClientProperties;
import com.kitfox.svg.A;
import expoescritorio.Controller.CodigosConductualesController;
import expoescritorio.Controller.ControllerFull;
import expoescritorio.Controller.NivelesCodigosConductualesController;
import expoescritorio.Controller.TiposCodigosConductualesController;
import expoescritorio.Models.CodigosConductuales;
import expoescritorio.Models.NivelesCodigosConductuales;
import expoescritorio.Models.TiposCodigosConductuales;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.Timer;
import org.json.JSONException;
import org.json.JSONObject;
import raven.toast.Notifications;
import Services.Validaciones;
import expoescritorio.Controller.EspecialidadesController;
import expoescritorio.Controller.GruposTecnicosController;
import expoescritorio.Controller.NivelesAcademicosController;
import expoescritorio.Controller.PersonasController;
import expoescritorio.Controller.SeccionesBachilleratoController;
import expoescritorio.Models.Especialidades;
import expoescritorio.Models.GruposTecnicos;
import expoescritorio.Models.NivelesAcademicos;
import expoescritorio.Models.Personas;
import expoescritorio.Models.SeccionesBachillerato;

/**
 *
 * @author educs
 */
public class MessageAddGrados extends javax.swing.JPanel {

    List<NivelesAcademicos> nivelesAcademicos = new ArrayList<NivelesAcademicos>();
    List<SeccionesBachillerato> seccionesBachillerato = new ArrayList<SeccionesBachillerato>();
    List<Personas> docentes = new ArrayList<Personas>();
    List<Especialidades> especialidades = new ArrayList<Especialidades>();
    List<GruposTecnicos> gruposTecnicos = new ArrayList<GruposTecnicos>();
    String rute = "";
    
    public MessageAddGrados() {

        initComponents();
        setOpaque(false);

        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
        // Obtener los datos de la API y cargarlos en el ComboBox
        nivelesAcademicos = NivelesAcademicosController.getNivelesAcademicosApiAsync().join();
        seccionesBachillerato = SeccionesBachilleratoController.getSeccionesBachilleratoApiAsync().join();
        docentes = PersonasController.getPersonasAsync(1).join();
        especialidades = EspecialidadesController.getEspecialidadesApiAsync().join();
        gruposTecnicos = GruposTecnicosController.getGruposTecnicosApiAsync().join();

        cbNivelesAcademicos.removeAllItems();
        cbSeccionesBachillerato.removeAllItems();
        cbDocentes.removeAllItems();
        cbEspecialidades.removeAllItems();
        cbGruposTecnicos.removeAllItems();
        
        for(NivelesAcademicos item : nivelesAcademicos){
            cbNivelesAcademicos.addItem(item.getNivelAcademico());
        }
        for(SeccionesBachillerato item : seccionesBachillerato){
            cbSeccionesBachillerato.addItem(item.getSeccionBachillerato());
        }
        for(Personas item : docentes){
            cbDocentes.addItem(item.getCodigo()+", "+item.getApellidoPersona()+" "+item.getNombrePersona());
        }
        for(Especialidades item : especialidades){
            cbEspecialidades.addItem(item.getEspecialidad());
        }
        for(GruposTecnicos item : gruposTecnicos){
            cbNivelesAcademicos.addItem(item.getGrupoTecnico());
        }
        
        

    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitle = new javax.swing.JLabel();
        btnCancelar = new View.BotonesText.Buttons();
        btnAceptar = new View.BotonesText.Buttons();
        jLabel1 = new javax.swing.JLabel();
        cbNivelesAcademicos = new javax.swing.JComboBox<>();
        cbSeccionesBachillerato = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbDocentes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbEspecialidades = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbGruposTecnicos = new javax.swing.JComboBox<>();
        btnImagen1 = new View.BotonesText.Buttons();
        jLabel13 = new javax.swing.JLabel();
        lbImagen1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTitle.setText("Your Message Title Dialog Custom");
        add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 120, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 120, -1));

        jLabel1.setText("Nivel Academico:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));
        add(cbNivelesAcademicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 160, -1));
        add(cbSeccionesBachillerato, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 160, -1));

        jLabel3.setText("Secciones:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        jLabel4.setText("Docente Encargado:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));
        add(cbDocentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 400, -1));

        jLabel5.setText("Especialidad:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));
        add(cbEspecialidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 160, -1));

        jLabel6.setText("Grupo Técnico:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));
        add(cbGruposTecnicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 160, -1));

        btnImagen1.setText("Escoger horario");
        btnImagen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImagen1MouseClicked(evt);
            }
        });
        btnImagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagen1ActionPerformed(evt);
            }
        });
        add(btnImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 120, -1));

        jLabel13.setText("Horario:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        lbImagen1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lbImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 220, 190));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:

        /*Validaciones valida = new Validaciones();
        if (txtCodigoConductual.getText().isEmpty() ) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El campo no puede estar vacío");
        }else {
            if (!valida.check50(txtCodigoConductual.getText()) ) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El Campo es muy grande");
            }
            else{
            enviarDatosHaciaApi();
            Timer timer = new Timer(500, (ActionEvent e) -> {
                CodigosDisciplinarios cd = new CodigosDisciplinarios();
                cd.cargarDatos();
                cd.deleteAllTableRows(cd.table1);
            });
            timer.setRepeats(false);
            timer.start();
            }
        }
        */

    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnImagen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImagen1MouseClicked

    }//GEN-LAST:event_btnImagen1MouseClicked

    private void btnImagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagen1ActionPerformed
        // TODO add your handling code here:
        /*rute = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG","jpg","png");
        chooser.setFileFilter(filter);

        int res = chooser.showOpenDialog(this);

        if(res == JFileChooser.APPROVE_OPTION){
            rute = chooser.getSelectedFile().getPath();

            Image mImagen = new ImageIcon(rute).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lbImagen.getWidth(), lbImagen.getHeight(), Image.SCALE_SMOOTH));
            lbImagen.setIcon(mIcono);

        }*/
    }//GEN-LAST:event_btnImagen1ActionPerformed

    public void eventOK(ActionListener event) {
        btnAceptar.addActionListener(event);
    }

    private void enviarDatosHaciaApi() {
        
    }

    private int obtenerIdSeleccionadoComboBox(JComboBox<String> comboBox) {
        int selectedIndex = (int) comboBox.getSelectedIndex();
        // Aquí deberías obtener el ID correspondiente al valor seleccionado en el ComboBox
        // Puedes tener una lista de objetos con ID y valor asociado y buscar el ID basado en el valor seleccionado.
        // Por simplicidad, aquí asumiremos que el valor seleccionado es el ID directamente.

        return selectedIndex;
    }

    public boolean panelClosing() {
        // Realiza las acciones necesarias antes de cerrar el panel
        System.out.println("El panel se va a cerrar.");
        CodigosDisciplinarios cd = new CodigosDisciplinarios();

        cd.cargarDatos();
        cd.deleteAllTableRows(cd.table1);
        return false;
    }
// Método para obtener el ID seleccionado de un JComboBox

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.Buttons btnAceptar;
    private View.BotonesText.Buttons btnCancelar;
    private View.BotonesText.Buttons btnImagen1;
    public javax.swing.JComboBox<String> cbDocentes;
    public javax.swing.JComboBox<String> cbEspecialidades;
    public javax.swing.JComboBox<String> cbGruposTecnicos;
    public javax.swing.JComboBox<String> cbNivelesAcademicos;
    public javax.swing.JComboBox<String> cbSeccionesBachillerato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbImagen1;
    public javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
