package general.utilitario;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.naming.ServiceUnavailableException;
import javax.servlet.http.Part;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;
import general.bean.RutaArchivosOneDrive;


import groovy.json.JsonException;

public class OneDriveUploadAPI {
	// URL de Autenticacion
	private final static String AUTHORITY = "https://login.microsoftonline.com/common/oauth2/authorize";
	
	// Testing
	//private final static String CLIENT_ID = "f6866cc1-cc98-4c07-a60a-24ee28364228";
	//private final static String usuario = "test_zoom@uvirtual.edu.pe";
	//private final static String clave = "Testzoom0";
	
	// Produccion
	private final static String CLIENT_ID = "fe451b01-3267-40a4-86cf-f83b828a2903";
	private final static String usuario = "app_fiadata@usmp.pe";
	private final static String clave = "appF1adata";
	

	//public String subirArchivoOneDrive(Part part, String nombreArchivo, String token) {
	public String subirArchivoOneDrive(Part part, String nombreArchivo, String token, String aplicacion, String carpeta) {
		
		try {
			String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			byte[] fileBytes = convertFileToBytes(part);
			try {
				String fileExtension = fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
				System.out.println("Uploading...");
				//return uploadFileOneDrive(token, fileBytes, fileExtension, nombreArchivo);
				return uploadFileOneDrive(token, fileBytes, fileExtension, nombreArchivo, aplicacion, carpeta);
			}catch(StringIndexOutOfBoundsException s) {
				System.out.println("No contiene archvio...");
				return "1";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}
		
	}
		
	private byte[] convertFileToBytes(Part filePart) {
		try {
			InputStream fileContent = filePart.getInputStream();
			byte[] buff = new byte[60000];
			int bytesRead = 0;
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			while ((bytesRead = fileContent.read(buff)) != -1) {
				bao.write(buff, 0, bytesRead);
			}
			byte[] data = bao.toByteArray();

			ByteArrayInputStream bin = new ByteArrayInputStream(data);
			System.out.println(bin.available());
			return data;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "Unable to read file.");
			e.printStackTrace();
			return null;
		}
	}

	//private static String uploadFileOneDrive(String token, byte[] fileBytes, String fileExtension, String nombreArchivo)
	private static String uploadFileOneDrive(String token, byte[] fileBytes, String fileExtension, String nombreArchivo, String aplicacion, String carpeta)
			throws IOException {
		//String fileName = nombreArchivo + fileExtension;
		String fileName = nombreArchivo;
		URL url = new URL("https://graph.microsoft.com/v1.0/me/drive/root:/Aplicaciones/"+aplicacion+"/"+carpeta+"/"+fileName + ":/content");
		System.out.println("URL ---"+url);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Authorization", "Bearer " + token);
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);
		conn.getOutputStream().write(fileBytes);

		int httpResponseCode = conn.getResponseCode();
		if (httpResponseCode == 200) {
			BufferedReader in = null;
			StringBuilder response;
			try {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				response = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
			} finally {
				in.close();
			}
			System.out.print(response.toString());
			return "1";
		}else if(httpResponseCode == 201) {
			BufferedReader in = null;
			StringBuilder response;
			try {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				response = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
			} finally {
				in.close();
			}
			System.out.print(response.toString());

			return "201";
		}else {
			System.out.print(String.format("Connection returned HTTP code: %s with message: %s", httpResponseCode,
					conn.getResponseMessage()));
			return "else";
		}
	}
	

	private static String obtenerListaArchvios(String token, String aplicacion,String carpeta) throws IOException {
		URL url = new URL("https://graph.microsoft.com/v1.0/me/drive/root:/Aplicaciones/" + aplicacion +"/" + carpeta +":/children");
		System.out.println("GENERAL --- https://graph.microsoft.com/v1.0/me/drive/root:/Aplicaciones/" + aplicacion +"/" + carpeta +":/children");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "Bearer " + token);
		conn.setRequestProperty("Accept", "application/json");

		int httpResponseCode = conn.getResponseCode();
		if (httpResponseCode == 200) {
			BufferedReader in = null;
			StringBuilder response;
			try {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				response = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
			} finally {
				in.close();
			}
			return response.toString();
		} else {
			return String.format("Connection returned HTTP code: %s with message: %s", httpResponseCode,
					conn.getResponseMessage());
		}
	}
	

	// Obtener Credenciales
	public String LogInOffice365() {
		AuthenticationResult result = null;
		try {
			result = getAccessTokenFromUserCredentials(usuario, clave);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.getAccessToken();
	}

	private static AuthenticationResult getAccessTokenFromUserCredentials(String username, String password)
			throws Exception {
		AuthenticationContext context;
		AuthenticationResult result;
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(1);
			context = new AuthenticationContext(AUTHORITY, false, service);
			Future<AuthenticationResult> future = context.acquireToken("https://graph.microsoft.com", CLIENT_ID,
					username, password, null);
			result = future.get();
		} finally {
			service.shutdown();
		}

		if (result == null) {
			throw new ServiceUnavailableException("authentication result was null");
		}
		return result;
	}
	// ----------
	
	public ArrayList<RutaArchivosOneDrive> leerArchivosDescargaOneDrive(String token, String aplicacion, String id) {
		try {
			ArrayList<RutaArchivosOneDrive> archivos = new ArrayList<>();
			String listaDeArchivos = obtenerListaArchvios(token,aplicacion,id);
			if(!listaDeArchivos.equals("Connection returned HTTP code: 404 with message: Not Found")) {
				try {
					JSONObject oneDriveDirectory = new JSONObject(listaDeArchivos);
					JSONArray oneDriveFiles = (JSONArray) oneDriveDirectory.get("value");
					for (int i = 0; i < oneDriveFiles.length(); i++) {
						RutaArchivosOneDrive archivo = new RutaArchivosOneDrive();
						JSONObject oneDriveFile = new JSONObject(oneDriveFiles.get(i).toString());
						System.out.println(oneDriveFile.get("@microsoft.graph.downloadUrl"));
						//downloadLinks.add(oneDriveFile.getString("@microsoft.graph.downloadUrl"));
						System.out.println(oneDriveFile.get("name"));
						//fileName.add(oneDriveFile.getString("name"));
						String createdDateTime = oneDriveFile.getString("createdDateTime");
						String date = createdDateTime.substring(0,createdDateTime.indexOf('T'));
						//String[] dateBroken = date.split("-");
						
						//archivo.setCreatedDateTime(dateBroken[2] + "/" + dateBroken[1] + "/" + dateBroken[0]);
						archivo.setFileName(oneDriveFile.getString("name"));
						archivo.setUrl(oneDriveFile.getString("@microsoft.graph.downloadUrl"));
						archivos.add(archivo);
					}
					return archivos;
				} catch (JsonException j) {
					j.printStackTrace();
					return archivos;
				} catch(JSONException e) {
					e.printStackTrace();
					return archivos;
				}
			}else {
				return archivos;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
