package expoescritorio.Controller;


import static expoescritorio.Controller.TiposCodigosConductualesController.getTiposCodigosConductualesFromApi;
import expoescritorio.Models.NivelesAcademicos;
import expoescritorio.Models.TiposCodigosConductuales;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
public class NivelesAcademicosController {
    
    
    public static CompletableFuture<List<NivelesAcademicos>> getNivelesAcademicosApiAsync() {
        return CompletableFuture.supplyAsync(() -> {
            // URL del servicio web para obtener una lista 
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/NivelesAcademicos/list";
            List<NivelesAcademicos> modelList = new ArrayList<>();
            HttpURLConnection connection = null;
            try {
                 // Se crea una URL a partir de la apiUrl proporcionada.
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                // Se configura la solicitud como un método GET.
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Procesar la respuesta JSON del servidor.
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    JSONArray jsonArray = new JSONArray(reader.readLine());

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int idNivelAcademico = jsonObject.getInt("idNivelAcademico");
                        String nivelAcademico = jsonObject.getString("nivelAcademico");
                        modelList.add(new NivelesAcademicos(idNivelAcademico, nivelAcademico));
                    }
                } else {
                    // Manejar errores si la respuesta del servidor no es exitosa.
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            } catch (IOException | JSONException e) {
                 // Manejar excepciones si ocurren problemas durante la solicitud HTTP o el procesamiento JSON.
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            } finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }
            return modelList;
        });
    }
}
