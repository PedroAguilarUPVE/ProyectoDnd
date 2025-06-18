package vistas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GeminiSwingApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField inputField;
	private JTextArea outputArea;
	private JButton sendButton;

	private static final String API_KEY = "AIzaSyAUyucNKCBxSpBO49ErlgdTNCT7jHTRgU8"; // Reemplaza con tu clave API de Gemini
	private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key="
			+ API_KEY;

	public GeminiSwingApp() {
		setTitle("Gemini API en Java Swing");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Crear componentes
		inputField = new JTextField(40);
		outputArea = new JTextArea(15, 50);
		outputArea.setEditable(false);
		sendButton = new JButton("Enviar");

		// Panel para organizar componentes
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel("Entrada:"), BorderLayout.NORTH);
		panel.add(inputField, BorderLayout.CENTER);
		panel.add(sendButton, BorderLayout.EAST);
		panel.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

		// Acción del botón
		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userInput = inputField.getText();
				if (!userInput.isEmpty()) {
					String response = sendRequestToGemini(userInput);
					outputArea.setText(response);
				} else {
					outputArea.setText("Por favor, ingresa una pregunta.");
				}
			}
		});

		// Agregar panel a la ventana
		add(panel);
	}

	private String sendRequestToGemini(String userInput) {
		OkHttpClient client = new OkHttpClient();

		// Crear el cuerpo de la solicitud en JSON
		JsonObject requestBody = new JsonObject();
		JsonObject content = new JsonObject();
		content.addProperty("parts", userInput);
		requestBody.add("contents", content);

		// Crear la solicitud HTTP
		RequestBody body = RequestBody.create(requestBody.toString(), MediaType.parse("application/json"));

		Request request = new Request.Builder().url(API_URL).post(body).build();

		try (Response response = client.newCall(request).execute()) {
			if (response.isSuccessful() && response.body() != null) {
				// Parsear la respuesta JSON
				String responseBody = response.body().string();
				JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
				return jsonResponse.getAsJsonArray("candidates").get(0).getAsJsonObject().getAsJsonObject("content")
						.getAsJsonArray("parts").get(0).getAsJsonObject().get("text").getAsString();
			} else {
				return "Error: " + response.code() + " - " + response.message();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "Error al conectar con la API de Gemini.";
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GeminiSwingApp().setVisible(true);
			}
		});
	}
}