
package expoescritorio.Controller;


import static expoescritorio.Controller.TiposCodigosConductualesController.getTiposCodigosConductualesFromApi;
import expoescritorio.Models.NivelesCodigosConductuales;
import expoescritorio.Models.TiposCodigosConductuales;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class NivelesCodigosConductualesController {
    
    public static Integer getPosicionNivelCodigoConductual(int id){
        // Obtiene una lista de niveles de códigos conductuales de manera asíncrona.
        List<NivelesCodigosConductuales> tiposCodigosConductuales = getNivelesCodigosConductualesAsync().join();
        int cnt = 0;
        for(NivelesCodigosConductuales item: tiposCodigosConductuales){
            // Compara el ID del nivel de código conductual actual con el ID proporcionado.
            if(item.getIdNivelCodigoConductual() == id) break;
            cnt++;// Incrementa el contador de posición si no se encuentra
        }
        return cnt;// Devuelve la posición del nivel de código conductual en la lista.
    }
    
    public static CompletableFuture<Integer> getNivelesCodigosConductualesNameAsync(String name) {
        return CompletableFuture.supplyAsync(() -> {
             // URL del servicio web 
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/NivelesCodigosConductuales/getName/"+name;
             // Valor predeterminado en caso de no encontrar el nombre.
            Integer modelList = 0;
            HttpURLConnection connection = null;
            try {
                // Se crea una URL a partir de la apiUrl proporcionada.
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Lee la respuesta del servidor.
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    
                    if(response.length()>0){
                        // Convierte la respuesta a un entero si contiene datos.
                        modelList = Integer.parseInt(response.toString());
                    }
                } else {
                    // Maneja errores si la respuesta del servidor no es exitosa.
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            } catch (Exception e) {
                // Maneja excepciones si ocurren problemas durante la solicitud HTTP.
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            } finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }
            return modelList;
        });
    }
    
    public static CompletableFuture<List<NivelesCodigosConductuales>> getNivelesCodigosConductualesAsync() {
        return CompletableFuture.supplyAsync(() -> {
            // URL del servicio web
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/NivelesCodigosConductuales/list";
            List<NivelesCodigosConductuales> modelList = new ArrayList<>();
            HttpURLConnection connection = null;
            try {
                // Se crea una URL a partir de la apiUrl proporcionada.
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Lee la respuesta del servidor.
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    JSONArray jsonArray = new JSONArray(reader.readLine());

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int idNivelCodigoConductual = jsonObject.getInt("idNivelCodigoConductual");
                        String nivelCodigoConductual = jsonObject.getString("nivelCodigoConductual");
                        modelList.add(new NivelesCodigosConductuales(idNivelCodigoConductual, nivelCodigoConductual));
                    }
                }else {
                    // Maneja errores si la respuesta del servidor no es exitosa.
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            }catch (IOException | JSONException e) {
                // Maneja excepciones si ocurren problemas durante la solicitud HTTP.
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            }finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }
            return modelList;
        });
    }
}
