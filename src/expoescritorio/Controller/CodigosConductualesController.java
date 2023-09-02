
package expoescritorio.Controller;

import expoescritorio.Models.CodigosConductuales;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class CodigosConductualesController {
    
    
    public static CompletableFuture<String> getTipoCodigoConductualAsync(int id){
         // Se crea un CompletableFuture que contendrá el resultado asincrónico.
        return CompletableFuture.supplyAsync(()->{
            // URL del servicio web al que se va a realizar la solicitud.
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/TiposCodigosConductuales/get/"+id;
            String model = "";
            HttpURLConnection connection = null; 
            try{
                // Configura y realiza una solicitud HTTP GET al servidor.
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                
                if(responseCode == HttpURLConnection.HTTP_OK){
                    // Lee y almacena la respuesta del servidor si la solicitud fue exitosa.
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    
                    if(response.length()>0){
                        model = response.toString();
                    }
                }
                else {
                     // Maneja errores si la respuesta del servidor no es exitosa.
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
                
            }catch (Exception e) {
                 // Maneja excepciones si ocurren problemas durante la solicitud HTTP.
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            }finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }
            return model;
        });
    }
    
    public static CompletableFuture<String> getNivelCodigoConductualAsync(int id){
        return CompletableFuture.supplyAsync(()->{
             // URL del servicio web al que se va a realizar la solicitud.
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/NivelesCodigosConductuales/get/"+id;
            String model = "";
            HttpURLConnection connection = null; 
            try{
                // Configura y realiza una solicitud HTTP GET al servidor.
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                
                if(responseCode == HttpURLConnection.HTTP_OK){
                    // Lee y almacena la respuesta del servidor si la solicitud fue exitosa.
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    
                    if(response.length()>0){
                        model = response.toString();
                    }
                }
                else {
                    // Maneja errores si la respuesta del servidor no es exitosa.
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
                
            }catch (Exception e) {
                // Maneja excepciones si ocurren problemas durante la solicitud HTTP.
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            }finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }
            return model;
        });
    }
    
    public static CompletableFuture<List<CodigosConductuales>> getCodigosConductualesApiAsync() {
        return CompletableFuture.supplyAsync(() -> {
             // URL del servicio web al que se va a realizar la solicitud.
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/CodigosConductuales/list";
            List<CodigosConductuales> modelList = new ArrayList<>();
            HttpURLConnection connection = null;
            try {
                // Configura y realiza una solicitud HTTP GET al servidor.
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Procesar la respuesta JSON del servidor y llenar la lista modelList.
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    JSONArray jsonArray = new JSONArray(reader.readLine());

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int idCodigoConductual = jsonObject.getInt("idCodigoConductual");
                        int idTipoCodigoConductual = jsonObject.getInt("idTipoCodigoConductual");
                        int idNivelCodigoConductual = jsonObject.getInt("idNivelCodigoConductual");
                        String codigoConductual= jsonObject.getString("codigoConductual");
                        modelList.add(new CodigosConductuales(idCodigoConductual, idTipoCodigoConductual, idNivelCodigoConductual,codigoConductual));
                    }
                }else {
                     // Manejar errores si la respuesta del servidor no es exitosa.
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            }catch (IOException | JSONException e) {
                 // Manejar excepciones si ocurren problemas durante la solicitud HTTP o el procesamiento JSON.
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            }finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }
             // Devolver la lista de objetos CodigosConductuales como un CompletableFuture.
            return modelList;
        });
    }
    
    
}
