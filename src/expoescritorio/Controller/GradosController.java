package expoescritorio.Controller;


import com.google.gson.Gson;
import static expoescritorio.Controller.PersonasController.encryptPassword;
import expoescritorio.Models.Grados;
import expoescritorio.Models.GradosView;
import expoescritorio.Models.Personas;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class GradosController {
    
    private static String addQueryParameters(String baseUrl, Map<String, String> params) {
        StringBuilder builder = new StringBuilder(baseUrl);
        // Verifica si hay parámetros en el mapa.
        if (!params.isEmpty()) {
            builder.append("?");
            // Itera a través del mapa de parámetros y los agrega a la URL.
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            builder.deleteCharAt(builder.length() - 1); // Elimina el último "&"
        }

        return builder.toString();
    }
    
    public static Grados getGradoAcademico(int idNivelAcademico, int idSeccion, int idSeccionBachillerato) {
        
        String baseUrl = "https://expo2023-6f28ab340676.herokuapp.com/Grados/gradoAcademico";
        // Parámetros de consulta a ser agregados a la URL.
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("idNivelAcademico", String.valueOf(idNivelAcademico));
        queryParams.put("idSeccion", String.valueOf(idSeccion));
        queryParams.put("idSeccionBachillerato", String.valueOf(idSeccionBachillerato));

        String url = addQueryParameters(baseUrl, queryParams);

        try {
            // Crea un objeto URL a partir de la URL completa.
            URL urlObject = new URL(url);
            // Abre una conexión HTTP.
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                // Lee la respuesta del servidor.
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
                    return gson.fromJson(responseData, Grados.class);
                }
            } else {
                // Maneja errores si la respuesta del servidor no es exitosa.
                System.out.println("No se encontro: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Si hay algún problema, retorna null
    }
    
    public static Grados getGradoTecnico(int idEspecialidad, int idGrupoTecnico) {
        // URL base del servicio web para obtener información 
        String baseUrl = "https://expo2023-6f28ab340676.herokuapp.com/Grados/gradoTecnico";
        // Parámetros de consulta a ser agregados a la URL.
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("idEspecialidad", String.valueOf(idEspecialidad));
        queryParams.put("idGrupoTecnico", String.valueOf(idGrupoTecnico));

        String url = addQueryParameters(baseUrl, queryParams);

        try {
            // Crea un objeto URL a partir de la URL completa.
            URL urlObject = new URL(url);
            // Abre una conexión HTTP.
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                // Lee la respuesta del servidor.
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
                    return gson.fromJson(responseData, Grados.class);
                }
            } else {
                 // Maneja errores si la respuesta del servidor no es exitosa.
                System.out.println("No se encontro: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Si hay algún problema, retorna null
    }
    
    public static GradosView getGradoAcademico(int idGrado) {
        
        String baseUrl = "https://expo2023-6f28ab340676.herokuapp.com/Grados/get/"+idGrado;
        // Parámetros de consulta a ser agregados a la URL.


        try {
            // Crea un objeto URL a partir de la URL completa.
            URL urlObject = new URL(baseUrl);
            // Abre una conexión HTTP.
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                // Lee la respuesta del servidor.
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
                    return gson.fromJson(responseData, GradosView.class);
                }
            } else {
                // Maneja errores si la respuesta del servidor no es exitosa.
                System.out.println("No se encontro: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Si hay algún problema, retorna null
    }
    
    /*public static CompletableFuture<List<GradosView>> getGradosApiAsync() {
        return CompletableFuture.supplyAsync(() -> {
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/Grados/list";
            List<GradosView> modelList = new ArrayList<>();
            HttpURLConnection connection = null;
            try {
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    JSONArray jsonArray = new JSONArray(reader.readLine());

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int idGrado = jsonObject.getInt("idGrado");
                        String idNivelAcademico = jsonObject.getString("idNivelAcademico");
                        String idSeccion = jsonObject.getString("idSeccion");
                        String idSeccionBachillerato = jsonObject.getString("idSeccionBachillerato");
                        String idDocenteEncargado = jsonObject.getString("idDocenteEncargado");
                        String idEspecialidad = jsonObject.getString("idEspecialidad");
                        String idGrupoTecnico  = jsonObject.getString("idGrupoTecnico");
                        modelList.add(new GradosView(idGrado, idNivelAcademico, idSeccion, idSeccionBachillerato,idDocenteEncargado,idEspecialidad, idGrupoTecnico ));
                    }
                } else {
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            } catch (IOException | JSONException e) {
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            } finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }
            return modelList;
        });
    }*/

}
