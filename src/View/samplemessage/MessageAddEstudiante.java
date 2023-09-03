/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.samplemessage;

import Services.Encriptacion;
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
import View.Application.form.other.Estudiantes;
import expoescritorio.Controller.EspecialidadesController;
import expoescritorio.Controller.GradosController;
import expoescritorio.Controller.GruposTecnicosController;
import expoescritorio.Controller.NivelesAcademicosController;
import expoescritorio.Controller.PersonasController;
import expoescritorio.Controller.SeccionesBachilleratoController;
import expoescritorio.Controller.SeccionesController;
import expoescritorio.Models.Especialidades;
import expoescritorio.Models.Grados;
import expoescritorio.Models.GradosView;
import expoescritorio.Models.GruposTecnicos;
import expoescritorio.Models.NivelesAcademicos;
import expoescritorio.Models.Personas;
import expoescritorio.Models.Secciones;
import expoescritorio.Models.SeccionesBachillerato;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author educs
 */
public class MessageAddEstudiante extends javax.swing.JPanel {
    
    List<NivelesAcademicos> gradosAcademicos = new ArrayList<NivelesAcademicos>();
    List<Especialidades> gradosTecnicos = new ArrayList<Especialidades>();
    List<GruposTecnicos> seccionesBachillerato = new ArrayList<GruposTecnicos>();
    List<SeccionesBachillerato> secciones = new ArrayList<SeccionesBachillerato>();
    String rute = "";
    
    public MessageAddEstudiante() {

        initComponents();
        setOpaque(false);

        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
        // Obtener los datos de la API y cargarlos en el ComboBox
        
        CompletableFuture<List<NivelesAcademicos>> nivelesFuture = 
                NivelesAcademicosController.getNivelesAcademicosApiAsync();
        gradosAcademicos = nivelesFuture.join();
        
        CompletableFuture<List<Especialidades>> especialidadesFuture = 
                EspecialidadesController.getEspecialidadesApiAsync();
        gradosTecnicos = especialidadesFuture.join();
        
        CompletableFuture<List<GruposTecnicos>> bachilleratoFuture = 
                GruposTecnicosController.getGruposTecnicosApiAsync();
        
        seccionesBachillerato = bachilleratoFuture.join();
        
        CompletableFuture<List<SeccionesBachillerato>> seccionesFuture = 
                SeccionesBachilleratoController.getSeccionesBachilleratoApiAsync();
        
        secciones = seccionesFuture.join();
        

            // Limpiar el ComboBox antes de agregar los nuevos elementos
            cbAcademicos.removeAllItems();
            cbTecnicos.removeAllItems();
            cbSeccionAcademica.removeAllItems();
            cbSeccionTecnica.removeAllItems();

            // Agregar los niveles de códigos conductuales al ComboBox
            for (NivelesAcademicos grados : gradosAcademicos) {
                cbAcademicos.addItem(grados.getNivelAcademico());
            }
            
            for(Especialidades grados : gradosTecnicos){
                cbTecnicos.addItem(grados.getEspecialidad());
            }

            for(GruposTecnicos grados : seccionesBachillerato){
                cbSeccionTecnica.addItem(grados.getGrupoTecnico());
            }
            
            for(SeccionesBachillerato grados : secciones){
                cbSeccionAcademica.addItem(grados.getSeccionBachillerato());
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
        btnImagen = new View.BotonesText.Buttons();
        btnAceptar = new View.BotonesText.Buttons();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombres1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtNombres3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        txtNombres4 = new javax.swing.JTextField();
        btnCancelar = new View.BotonesText.Buttons();
        lbImagen = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbTecnicos = new javax.swing.JComboBox<>();
        cbAcademicos = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbSeccionTecnica = new javax.swing.JComboBox<>();
        cbSeccionAcademica = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dpNacimiento = new com.toedter.calendar.JDateChooser();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTitle.setText("Your Message Title Dialog Custom");
        add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btnImagen.setText("Escoger foto");
        btnImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImagenMouseClicked(evt);
            }
        });
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });
        add(btnImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 120, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 120, -1));

        jLabel1.setText("Nombres:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel2.setText("Foto:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 260, 20));

        jLabel4.setText("Fecha de nacimiento:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 150, 20));

        jLabel5.setText("Nombres:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        txtNombres1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombres1ActionPerformed(evt);
            }
        });
        add(txtNombres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 260, 20));

        jLabel6.setText("Apellidos:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 260, 20));

        txtNombres3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombres3ActionPerformed(evt);
            }
        });
        add(txtNombres3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 260, 20));

        jLabel7.setText("Grupo Técnico:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 260, 20));

        txtNombres4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombres4ActionPerformed(evt);
            }
        });
        add(txtNombres4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 260, 20));

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 120, -1));
        add(lbImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 220, 190));

        jLabel8.setText("Contraseña:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        jLabel9.setText("Especialidad:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, -1));

        cbTecnicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbTecnicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 210, -1));

        cbAcademicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbAcademicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 210, -1));

        jLabel10.setText("Nivel Academico:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        cbSeccionTecnica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbSeccionTecnica, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 210, -1));

        cbSeccionAcademica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbSeccionAcademica, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 210, -1));

        jLabel11.setText("Sección Academica:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, -1, -1));

        jLabel12.setText("Codigo:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        dpNacimiento.setDateFormatString("yyyy-MM-dd");
        add(dpNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:

        int idNivelAcademico = gradosAcademicos.get( cbAcademicos.getSelectedIndex()).getIdNivelAcademico();
        int idSeccionBachillerato = secciones.get(cbSeccionAcademica.getSelectedIndex()).getIdSeccionBachillerato();
        char seccion = secciones.get(cbSeccionAcademica.getSelectedIndex()).getSeccionBachillerato().charAt(0);
        String stringSeccion = ""; stringSeccion += seccion;
        
        int idGrupoTecnico = seccionesBachillerato.get(cbSeccionTecnica.getSelectedIndex()).getIdGrupoTecnico();
        int idEspecialidad = gradosTecnicos.get(cbTecnicos.getSelectedIndex()).getIdEspecialidad();
        
        int idSeccion = SeccionesController.getSeccionesbyNameApiAsync(stringSeccion).join().getIdSeccion();
        
        
        if (txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtCodigo.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Los campos no puede estar vacío");
        }
        else if(GradosController.getGradoAcademico(idNivelAcademico, idSeccion, idSeccionBachillerato) == null){
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El grado académico no es válido");
        }
        else if (GradosController.getGradoTecnico(idEspecialidad, idGrupoTecnico) == null){
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El grado técnico no es válido");
        }
        else {
            try {
                enviarDatosHaciaApi();
            } catch (IOException ex) {
                Logger.getLogger(MessageAddEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
            Timer timer = new Timer(500, (ActionEvent e) -> {
                Estudiantes cd = new Estudiantes();

                cd.cargarDatos();
                cd.deleteAllTableRows(cd.table1);
            });
            timer.setRepeats(false);
            timer.start();
        }


    }//GEN-LAST:event_btnAceptarMouseClicked

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombres1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres1ActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtNombres3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres3ActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void txtNombres4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres4ActionPerformed

    private void btnImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImagenMouseClicked
        
    }//GEN-LAST:event_btnImagenMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        // TODO add your handling code here:
        rute = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG","jpg","png");
        chooser.setFileFilter(filter);
        
        int res = chooser.showOpenDialog(this);
        
        if(res == JFileChooser.APPROVE_OPTION){
            rute = chooser.getSelectedFile().getPath();
            
            Image mImagen = new ImageIcon(rute).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lbImagen.getWidth(), lbImagen.getHeight(), Image.SCALE_SMOOTH));
            lbImagen.setIcon(mIcono);
            
        }
        
    }//GEN-LAST:event_btnImagenActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    public void eventOK(ActionListener event) {
        btnAceptar.addActionListener(event);
    }
    
    private void matricularGrado(Grados grado1, Grados grado2){
        try{
            JSONObject jsonData = new JSONObject();
            
            Personas estudiante = PersonasController.getPersonaByCodigo(txtCodigo.getText()).join();
            
        
            
            jsonData.put("idEstudiante", estudiante.getIdPersona());
            jsonData.put("idGradoAcademico", grado1.getIdGrado());
            jsonData.put("idGradoTecnico", grado2.getIdGrado());
            jsonData.put("horario", JSONObject.NULL);
            
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/Matriculas/save"; // Reemplaza esto con la URL de tu API
            String jsonString = jsonData.toString();
            
            CompletableFuture<Boolean> postFuture = ControllerFull.postApiAsync(endpointUrl, jsonString);

            // Manejar la respuesta de la API
            postFuture.thenAccept(success -> {
                if (success) {
                    // La solicitud POST fue exitosa
                    System.out.println("Datos enviados correctamente a la API");
                    
                    

                } else {
                    // La solicitud POST falló
                    System.out.println("Error al enviar los datos a la API");
                }
            });
            
        }
        catch (JSONException e) {
            // Manejar la excepción JSONException aquí
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
        }
    }

    private void matricular(){
        try{
            int idNivelAcademico = gradosAcademicos.get( cbAcademicos.getSelectedIndex()).getIdNivelAcademico();
            int idSeccionBachillerato = secciones.get(cbSeccionAcademica.getSelectedIndex()).getIdSeccionBachillerato();
            char seccion = secciones.get(cbSeccionAcademica.getSelectedIndex()).getSeccionBachillerato().charAt(0);
            String stringSeccion = ""; stringSeccion += seccion;
        
            int idGrupoTecnico = seccionesBachillerato.get(cbSeccionTecnica.getSelectedIndex()).getIdGrupoTecnico();
            int idEspecialidad = gradosTecnicos.get(cbTecnicos.getSelectedIndex()).getIdEspecialidad();
        
            int idSeccion = SeccionesController.getSeccionesbyNameApiAsync(stringSeccion).join().getIdSeccion();
            Grados gradoAcademico = GradosController.getGradoAcademico(idNivelAcademico, idSeccion, idSeccionBachillerato);
            Grados gradoTecnico = GradosController.getGradoTecnico(idEspecialidad, idGrupoTecnico);
            
            matricularGrado(gradoAcademico, gradoTecnico);
            
        }catch (Exception e) {
            // Manejar la excepción JSONException aquí
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
        }
    }
    
    private void enviarDatosHaciaApi() throws FileNotFoundException, IOException {
        
        
        
        try{
            JSONObject jsonData = new JSONObject();
            
            Path fotoPath;
            byte[] imageBytes;
            String base64Image="";
            
            if(rute==""){
                
            }
            else{
                fotoPath = Paths.get(rute);
                // Read the image file and encode it to Base64
                imageBytes = Files.readAllBytes(fotoPath);
                base64Image = Base64.getEncoder().encodeToString(imageBytes);
            }

            
            Date selectedDate = dpNacimiento.getDate();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(selectedDate);
            
            jsonData.put("codigo", txtCodigo.getText());
            jsonData.put("nombrePersona", txtNombres.getText());
            jsonData.put("apellidoPersona", txtApellidos.getText());
            jsonData.put("nacimientoPersona", formattedDate);
            jsonData.put("idTipoPersona", 2);
            jsonData.put("correo",txtCodigo.getText()+"@ricaldone.edu.sv");
            jsonData.put("claveCredenciales", Encriptacion.encryptPassword(txtClave.getText()));
            if(rute.isEmpty()) jsonData.put("foto", JSONObject.NULL);
            else jsonData.put("foto", base64Image);
            
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/Credenciales/save"; // Reemplaza esto con la URL de tu API
            String jsonString = jsonData.toString();
            
            CompletableFuture<Boolean> postFuture = ControllerFull.postApiAsync(endpointUrl, jsonString);

            // Manejar la respuesta de la API
            postFuture.thenAccept(success -> {
                if (success) {
                    // La solicitud POST fue exitosa
                    System.out.println("Datos enviados correctamente a la API");
                    
                    matricular();

                    Estudiantes cd = new Estudiantes();

                    cd.cargarDatos();

                    cd.deleteAllTableRows(cd.table1);
                    boolean pC = panelClosing() == true;
                    GlassPanePopup.closePopupLast();

                } else {
                    // La solicitud POST falló
                    System.out.println("Error al enviar los datos a la API");
                }
            });
            
        }
        catch (JSONException e) {
            // Manejar la excepción JSONException aquí
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
        }
        
/*
        int num = 4;
        int num1 = 1;

        MessageAddEstudiante msg = new MessageAddEstudiante();
        // Obtener los valores seleccionados del ComboBox y el texto del TextField
       
        String codigoConductual = txtCodigoConductual.getText();

        System.out.println(idTipoCodigoConductual);
        System.out.println(idNivelCodigoConductual);
        System.out.println(codigoConductual);
        try {
            // Crear un objeto JSON con los datos recopilados
            JSONObject jsonData = new JSONObject();
            jsonData.put("idTipoCodigoConductual", idTipoCodigoConductual);
            jsonData.put("idNivelCodigoConductual", idNivelCodigoConductual);
            jsonData.put("codigoConductual", codigoConductual);

            // Llamar al método postApiAsync para enviar los datos
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/CodigosConductuales/save"; // Reemplaza esto con la URL de tu API
            String jsonString = jsonData.toString();

            CompletableFuture<Boolean> postFuture = ControllerFull.postApiAsync(endpointUrl, jsonString);

            // Manejar la respuesta de la API
            postFuture.thenAccept(success -> {
                if (success) {
                    // La solicitud POST fue exitosa
                    System.out.println("Datos enviados correctamente a la API");

                    CodigosDisciplinarios cd = new CodigosDisciplinarios();

                    cd.cargarDatos();

                    cd.deleteAllTableRows(cd.table1);
                    boolean pC = panelClosing() == true;
                    GlassPanePopup.closePopupLast();

                } else {
                    // La solicitud POST falló
                    System.out.println("Error al enviar los datos a la API");
                }
            });
        } catch (JSONException e) {
            // Manejar la excepción JSONException aquí
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
        }
*/
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
        Estudiantes cd = new Estudiantes();

        cd.cargarDatos();
        cd.deleteAllTableRows(cd.table1);
        return false;
    }
// Método para obtener el ID seleccionado de un JComboBox

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.Buttons btnAceptar;
    private View.BotonesText.Buttons btnCancelar;
    private View.BotonesText.Buttons btnImagen;
    private javax.swing.JComboBox<String> cbAcademicos;
    private javax.swing.JComboBox<String> cbSeccionAcademica;
    private javax.swing.JComboBox<String> cbSeccionTecnica;
    private javax.swing.JComboBox<String> cbTecnicos;
    private com.toedter.calendar.JDateChooser dpNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNombres1;
    private javax.swing.JTextField txtNombres3;
    private javax.swing.JTextField txtNombres4;
    public javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
