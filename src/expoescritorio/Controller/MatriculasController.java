/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expoescritorio.Controller;

import com.google.gson.Gson;
import expoescritorio.Models.Grados;
import expoescritorio.Models.Matriculas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author thatsgonzalez
 */
public class MatriculasController {
    
    public static CompletableFuture<Boolean> deleteMatricula(int idEstudiante){
        
        return CompletableFuture.supplyAsync(() -> {
           String apiUrl =  "https://expo2023-6f28ab340676.herokuapp.com/Matriculas/delete/"+idEstudiante;
           HttpURLConnection connection = null;

            try {
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("DELETE");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    return true;
                } else {
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            } catch (IOException e) {
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            } finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }

            return false;
           
           
        });
        
    }
    
    public static Matriculas getMatricula(int id){
        String baseUrl = "https://expo2023-6f28ab340676.herokuapp.com/Grados/gradoAcademico";
        String url = baseUrl;

        try {
            URL urlObject = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }

                reader.close();

                String responseData = response.toString();
                if (responseData != null) {
                    Gson gson = new Gson();
                    return gson.fromJson(responseData, Matriculas.class);
                }
            } else {
                System.out.println("No se encontro: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
        
    }
    
    
}
