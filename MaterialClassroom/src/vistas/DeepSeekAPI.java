package vistas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class DeepSeekAPI {

    private static final String API_URL = "https://api.deepseek.com/v1/endpoint"; // URL correcta
    private static final String API_KEY = "sk-d1a772e3a7274b3b9267439aded16ad0";

    public static String sendRequest(String input) {
        try {
            URI uri = URI.create(API_URL);
            URL url = uri.toURL();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
            conn.setDoOutput(true);

            String jsonInputString = "{\"input\": \"" + input + "\"}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] inputBytes = jsonInputString.getBytes("utf-8");
                os.write(inputBytes, 0, inputBytes.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    return response.toString();
                }
            } else {
                // Manejar errores de respuesta HTTP
                System.err.println("Error: " + responseCode);
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"))) {
                    StringBuilder errorResponse = new StringBuilder();
                    String errorLine = null;
                    while ((errorLine = br.readLine()) != null) {
                        errorResponse.append(errorLine.trim());
                    }
                    return "Error: " + responseCode + " - " + errorResponse.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception: " + e.getMessage();
        }
    }
}